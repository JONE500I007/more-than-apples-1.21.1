package net.more.apples.world.tree.custom;

import com.google.common.collect.Lists;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.more.apples.world.tree.ModTrunkPlacerType;

import java.util.List;
import java.util.OptionalInt;
import java.util.function.BiConsumer;

public class TestAppleTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<TestAppleTrunkPlacer> CODEC =
            RecordCodecBuilder.mapCodec(testAppleTrunkPlacerInstance ->
                    fillTrunkPlacerFields(testAppleTrunkPlacerInstance)
                            .apply(testAppleTrunkPlacerInstance, TestAppleTrunkPlacer::new));

    public TestAppleTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerType.TEST_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(
            TestableWorld world,
            BiConsumer<BlockPos, BlockState> replacer,
            Random random, int height, BlockPos startPos,
            TreeFeatureConfig config) {

        setToDirt(world, replacer, random, startPos.down(), config);
        List<FoliagePlacer.TreeNode> list = Lists.newArrayList();

        Direction direction = Direction.Type.HORIZONTAL.random(random);
        int splitHeight = height - random.nextInt(4) - 1;
        int branchLength = 3 - random.nextInt(3);
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        int currentX = startPos.getX();
        int currentZ = startPos.getZ();
        OptionalInt mainNodeY = OptionalInt.empty();

        for (int m = 0; m < height; ++m) {
            int currentY = startPos.getY() + m;

            if (m >= splitHeight && m > 1 && branchLength > 0) {
                currentX += direction.getOffsetX();
                currentZ += direction.getOffsetZ();
                --branchLength;
            }

            if (this.placeLogAt(world, replacer, random, mutable.set(currentX, currentY, currentZ), config)) {
                mainNodeY = OptionalInt.of(currentY + 1);
            }
        }

        if (mainNodeY.isPresent()) {
            list.add(new FoliagePlacer.TreeNode(new BlockPos(currentX, mainNodeY.getAsInt(), currentZ), 1, false));
        }

        currentX = startPos.getX();
        currentZ = startPos.getZ();
        Direction direction2 = Direction.Type.HORIZONTAL.random(random);

        if (direction2 != direction) {
            int secondarySplitHeight = splitHeight - random.nextInt(2) - 1;
            int secondaryLength = 1 + random.nextInt(3);
            OptionalInt secondaryNodeY = OptionalInt.empty();

            for (int p = secondarySplitHeight; p < height && secondaryLength > 0; ++secondaryLength) {
                if (p >= 1) {
                    int q = startPos.getY() + p;
                    currentX += direction2.getOffsetX();
                    currentZ += direction2.getOffsetZ();

                    if (this.placeLogAt(world, replacer, random, mutable.set(currentX, q, currentZ), config)) {
                        secondaryNodeY = OptionalInt.of(q + 1);
                    }
                }
                p++;
                --secondaryLength;
                if (secondaryLength <= 0) break;
            }

            if (secondaryNodeY.isPresent()) {
                list.add(new FoliagePlacer.TreeNode(new BlockPos(currentX, secondaryNodeY.getAsInt(), currentZ), 0, false));
            }
        }

        return list;
    }

    private boolean placeLogAt(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos pos, TreeFeatureConfig config) {
        if (TreeFeature.canReplace(world, pos) || world.testBlockState(pos, state -> state.isOf(Blocks.SNOW))) {
            this.getAndSetState(world, replacer, random, pos, config);
            return true;
        }
        return false;
    }

    /*
    private boolean placeLogAt(TestableWorld world,
                               BiConsumer<BlockPos, BlockState> replacer,
                               Random random,
                               BlockPos pos,
                               TreeFeatureConfig config) {

        if (TreeFeature.canReplace(world, pos)
                || world.testBlockState(pos, state ->
                state.isOf(Blocks.SNOW)
                        || state.isOf(Blocks.GRASS_BLOCK)
                        || state.isOf(Blocks.DIRT))) {

            this.getAndSetState(world, replacer, random, pos, config);
            return true;
        }
        return false;
    }
     */
}
