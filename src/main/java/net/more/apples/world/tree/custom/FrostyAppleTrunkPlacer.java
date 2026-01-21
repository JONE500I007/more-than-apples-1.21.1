package net.more.apples.world.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
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
                    fillTrunkPlacerFields(frostyAppleTrunkPlacerInstance)
                            .apply(frostyAppleTrunkPlacerInstance, FrostyAppleTrunkPlacer::new));

    public FrostyAppleTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerType.FROSTY_TRUNK_PLACER;
    }

    /*
    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        setToDirt(world, replacer, random, startPos.down(), config);

        int height_ = height + random.nextBetween(firstRandomHeight, firstRandomHeight + 2) + random.nextBetween(secondRandomHeight - 1, secondRandomHeight + 1);

        for(int i = 0; i < height_; i++) {
            getAndSetState(world, replacer, random, startPos.up(i), config);

            if(i % 2 == 0 && random.nextBoolean()) {
                if(random.nextFloat() > 0.25f) {
                    for(int x = 1; x <= 4; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.NORTH, x), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                    }
                }

                if(random.nextFloat() > 0.25f) {
                    for(int x = 1; x <= 4; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.SOUTH, x), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
                    }
                }

                if(random.nextFloat() > 0.25f) {
                    for(int x = 1; x <= 4; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.EAST, x), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                    }
                }

                if(random.nextFloat() > 0.25f) {
                    for(int x = 1; x <= 4; x++) {
                        replacer.accept(startPos.up(i).offset(Direction.WEST, x), (BlockState) Function.identity().apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
                    }
                }
            }
        }

        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(height_), 0, false));

    }
    */
    @Override
    public List<FoliagePlacer.TreeNode> generate(
            TestableWorld world,
            BiConsumer<BlockPos, BlockState> replacer,
            Random random,
            int height,
            BlockPos startPos,
            TreeFeatureConfig config) {

        setToDirt(world, replacer, random, startPos.down(), config);

        List<FoliagePlacer.TreeNode> foliageNodes = new ArrayList<>();

        int trunkHeight = height
                + random.nextBetween(firstRandomHeight, firstRandomHeight + 1)
                + random.nextBetween(secondRandomHeight, secondRandomHeight + 1);

        for (Direction dir : Direction.Type.HORIZONTAL) {
            BlockPos baseBranch = startPos.offset(dir);

            clearSnow(world, replacer, baseBranch);
            clearSnow(world, replacer, baseBranch.down());

            this.getAndSetState(
                    world,
                    replacer,
                    random,
                    baseBranch,
                    config,
                    state -> state.with(PillarBlock.AXIS, dir.getAxis())
            );
        }
        //int branchY = trunkHeight - random.nextBetween(3, 4);
        //int branchY = trunkHeight - random.nextBetween(1, 2);

        int baseBranchY = trunkHeight - 1;

        for (int y = 0; y < trunkHeight; y++) {
            BlockPos trunkPos = startPos.up(y);
            this.getAndSetState(world, replacer, random, trunkPos, config);

            if (y == baseBranchY) {

                List<Direction> dirs = new ArrayList<>();
                for (Direction d : Direction.Type.HORIZONTAL) {
                    dirs.add(d);
                }

                for (int i = dirs.size() - 1; i > 0; i--) {
                    int j = random.nextInt(i + 1);
                    Direction tmp = dirs.get(i);
                    dirs.set(i, dirs.get(j));
                    dirs.set(j, tmp);
                }

                int branchCount = random.nextBetween(2, 4);

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

                    BlockPos.Mutable branchPos =
                            startPos.up(baseBranchY - offset).mutableCopy();

                    int length = random.nextBetween(3, 4);

                    for (int i = 0; i < length; i++) {

                        if (i < 2 || random.nextFloat() < 0.2f) {
                            branchPos.move(Direction.UP);
                        }

                        branchPos.move(dir);

                        this.getAndSetState(
                                world,
                                replacer,
                                random,
                                branchPos,
                                config,
                                state -> state.with(PillarBlock.AXIS, dir.getAxis()));
                    }

                    foliageNodes.add(new FoliagePlacer.TreeNode(
                            branchPos.up(),
                            0,
                            false));
                }
            }
        }
        return foliageNodes;
    }
    private void clearSnow(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, BlockPos pos) {
        if (world.testBlockState(pos, state -> state.isOf(Blocks.SNOW))) {
            replacer.accept(pos, Blocks.AIR.getDefaultState());
        }
    }
}
