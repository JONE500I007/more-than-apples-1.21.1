package net.more.apples.world.tree.custom.test_tree;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.more.apples.world.tree.ModTrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.BiConsumer;

public class TestAppleTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<TestAppleTrunkPlacer> CODEC =
            RecordCodecBuilder.mapCodec(testAppleTrunkPlacerInstance ->
                    trunkPlacerParts(testAppleTrunkPlacerInstance)
                            .apply(testAppleTrunkPlacerInstance, TestAppleTrunkPlacer::new));

    public TestAppleTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerType.TEST_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(
            WorldGenLevel level,
            BiConsumer<BlockPos, BlockState> trunkSetter,
            RandomSource random, int treeHeight, BlockPos origin,
            TreeConfiguration config) {

        placeBelowTrunkBlock(level, trunkSetter, random, origin.below(), config);
        List<FoliagePlacer.FoliageAttachment> list = new ArrayList<>();

        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        int splitHeight = treeHeight - random.nextInt(4) - 1;
        int branchLength = 3 - random.nextInt(3);
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        int currentX = origin.getX();
        int currentZ = origin.getZ();
        OptionalInt mainNodeY = OptionalInt.empty();

        for (int m = 0; m < treeHeight; ++m) {
            int currentY = origin.getY() + m;

            if (m >= splitHeight && m > 1 && branchLength > 0) {
                currentX += direction.getStepX();
                currentZ += direction.getStepZ();
                --branchLength;
            }

            if (this.placeLogAt(level, trunkSetter, random, mutable.set(currentX, currentY, currentZ), config)) {
                mainNodeY = OptionalInt.of(currentY + 1);
            }
        }

        if (mainNodeY.isPresent()) {
            list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(currentX, mainNodeY.getAsInt(), currentZ), 1, false));
        }

        currentX = origin.getX();
        currentZ = origin.getZ();
        Direction direction2 = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        if (direction2 != direction) {
            int secondarySplitHeight = splitHeight - random.nextInt(2) - 1;
            int secondaryLength = 1 + random.nextInt(3);
            OptionalInt secondaryNodeY = OptionalInt.empty();

            for (int p = secondarySplitHeight; p < treeHeight && secondaryLength > 0; ++secondaryLength) {
                if (p >= 1) {
                    int q = origin.getY() + p;
                    currentX += direction2.getStepX();
                    currentZ += direction2.getStepZ();

                    if (this.placeLogAt(level, trunkSetter, random, mutable.set(currentX, q, currentZ), config)) {
                        secondaryNodeY = OptionalInt.of(q + 1);
                    }
                }
                p++;
                --secondaryLength;
                if (secondaryLength <= 0) break;
            }

            if (secondaryNodeY.isPresent()) {
                list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(currentX, secondaryNodeY.getAsInt(), currentZ), 0, false));
            }
        }

        return list;
    }
    //testBlockState
    private boolean placeLogAt(
            WorldGenLevel level,
            BiConsumer<BlockPos, BlockState> replacer,
            RandomSource random,
            BlockPos pos,
            TreeConfiguration config) {

        BlockState state = level.getBlockState(pos);

        if (TreeFeature.validTreePos(level, pos) ||
                state.getBlock() == Blocks.SNOW) {

            this.placeLog(level, replacer, random, pos, config);
            return true;
        }
        return false;
    }
}
