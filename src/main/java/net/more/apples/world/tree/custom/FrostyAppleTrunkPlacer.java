package net.more.apples.world.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.more.apples.world.tree.ModTrunkPlacerType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class FrostyAppleTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<FrostyAppleTrunkPlacer> CODEC =
            RecordCodecBuilder.mapCodec(frostyAppleTrunkPlacerInstance ->
                    trunkPlacerParts(frostyAppleTrunkPlacerInstance)
                            .apply(frostyAppleTrunkPlacerInstance, FrostyAppleTrunkPlacer::new));

    public FrostyAppleTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerType.FROSTY_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(
            WorldGenLevel level,
            BiConsumer<BlockPos, BlockState> trunkSetter,
            RandomSource random, int treeHeight, BlockPos origin,
            TreeConfiguration config) {

        placeBelowTrunkBlock(level, trunkSetter, random, origin.below(), config);

        List<FoliagePlacer.FoliageAttachment> foliageNodes = new ArrayList<>();

        int trunkHeight = treeHeight
                + random.nextIntBetweenInclusive(heightRandA , heightRandA + 1)
                + random.nextIntBetweenInclusive(heightRandB, heightRandB + 1);

        for (Direction dir : Direction.Plane.HORIZONTAL) {
            BlockPos baseBranch = origin.relative(dir);

            if (!hasSupport(level, baseBranch)) {
                continue;
            }

            clearSnow(level, trunkSetter, baseBranch);
            clearSnow(level, trunkSetter, baseBranch.below());

            this.placeLog(
                    level,
                    trunkSetter,
                    random,
                    baseBranch,
                    config,
                    state -> state.setValue(RotatedPillarBlock.AXIS, dir.getAxis())
            );
        }
        //int branchY = trunkHeight - random.nextBetween(3, 4);
        //int branchY = trunkHeight - random.nextBetween(1, 2);

        int baseBranchY = trunkHeight - 1;

        for (int y = 0; y < trunkHeight; y++) {
            BlockPos trunkPos = origin.above(y);
            this.placeLog(level, trunkSetter, random, trunkPos, config);

            if (y == baseBranchY) {

                List<Direction> dirs = new ArrayList<>();
                for (Direction d : Direction.Plane.HORIZONTAL) {
                    dirs.add(d);
                }

                for (int i = dirs.size() - 1; i > 0; i--) {
                    int j = random.nextInt(i + 1);
                    Direction tmp = dirs.get(i);
                    dirs.set(i, dirs.get(j));
                    dirs.set(j, tmp);
                }

                int branchCount = random.nextIntBetweenInclusive(2, 4);

                for (int b = 0; b < Math.min(branchCount, dirs.size()); b++) {
                    Direction dir = dirs.get(b);

                    int offset;
                    float r = random.nextFloat();
                    if (r < 0.4f) {
                        offset = 0;
                    } else if (r < 0.75f) {
                        offset = 1;
                    } else {
                        offset = 2;
                    }

                    BlockPos.MutableBlockPos branchPos =
                            origin.above(baseBranchY - offset).mutable();

                    int length = random.nextIntBetweenInclusive(3, 4);

                    for (int i = 0; i < length; i++) {

                        if (i < 2 || random.nextFloat() < 0.2f) {
                            branchPos.move(Direction.UP);
                        }

                        branchPos.move(dir);

                        this.placeLog(
                                level,
                                trunkSetter,
                                random,
                                branchPos,
                                config,
                                state -> state.setValue(RotatedPillarBlock.AXIS, dir.getAxis()));
                    }

                    foliageNodes.add(new FoliagePlacer.FoliageAttachment(
                            branchPos.above(),
                            0,
                            false));
                }
            }
        }
        return foliageNodes;
    }
    private void clearSnow(WorldGenLevel level,
                           BiConsumer<BlockPos, BlockState> replacer,
                           BlockPos pos) {
        if (level.getBlockState(pos).getBlock() == Blocks.SNOW) {
            replacer.accept(pos, Blocks.AIR.defaultBlockState());
        }
    }
    private boolean hasSupport(WorldGenLevel level, BlockPos pos) {
        BlockState state = level.getBlockState(pos.below());
        return state.getBlock() != Blocks.AIR;
    }
}
