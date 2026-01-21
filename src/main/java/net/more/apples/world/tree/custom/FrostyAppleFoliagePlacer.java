package net.more.apples.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.more.apples.block.ModBlocks2;
import net.more.apples.world.tree.ModFoliagePlacerType;

public class FrostyAppleFoliagePlacer extends FoliagePlacer {
    /*
    public static final MapCodec<FrostyAppleFoliagePlacer> CODEC = RecordCodecBuilder.create(
            instance -> fillFoliagePlacerFields(instance)
                    .and(Codec.intRange(0, 12).fieldOf("height")
                            .forGetter(instance2 -> instance2.height)).apply(instance, FrostyAppleFoliagePlacer::new));
     */
    public static final MapCodec<FrostyAppleFoliagePlacer> CODEC =
            RecordCodecBuilder.mapCodec(foliagePlacerInstance
             -> fillFoliagePlacerFields(foliagePlacerInstance)
                    .and(Codec.intRange(0, 12).fieldOf("height")
                            .forGetter(applePlacer -> applePlacer.height))
                    .apply(foliagePlacerInstance, FrostyAppleFoliagePlacer::new));

    private final int height;

    public FrostyAppleFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerType.FROSTY_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config,
                            int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        // generateSquare(world, placer, random, config, treeNode.getCenter());
        // radius on how many blocks it extends into x and z direction
        // y how much offset in the y direction from treeNode.getCenter()
        // y if it is dependent on i, also offsets each new layer in the y direction
        /*
        generateSquare(world, placer, random, config, treeNode.getCenter().up(0),1,1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(1),1,1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(2),1,1, treeNode.isGiantTrunk());
         */
        boolean giant = treeNode.isGiantTrunk();
        BlockPos center = treeNode.getCenter().up(offset);

        this.generateSquare(world, placer, random, config, center, radius + treeNode.getFoliageRadius(), -1 - foliageHeight, giant);
        this.generateSquare(world, placer, random, config, center, radius - 1, -foliageHeight, giant);
        this.generateSquare(world, placer, random, config, center, radius + treeNode.getFoliageRadius() - 1, 0, giant);

        /*
        int rTop = radius + treeNode.getFoliageRadius() - 1;
        for (int dx = -rTop; dx <= rTop; dx++) {
            for (int dz = -rTop; dz <= rTop; dz++) {

                if (Math.abs(dx) != rTop && Math.abs(dz) != rTop) continue;

                if (random.nextFloat() > 0.38f) continue;

                BlockPos hangStart = center.add(dx, -foliageHeight, dz);

                int hangLength = random.nextBetween(2, 3);

                for (int i = 1; i <= hangLength; i++) {
                    BlockPos pos = hangStart.down(i);

                    placer.placeBlock(pos, config.foliageProvider.get(random, pos));
                }
            }
        }
         */
        /*
        int hangingRadius = radius + treeNode.getFoliageRadius();
        BlockPos.Mutable mutablePos = new BlockPos.Mutable();
        for (int x = -hangingRadius; x <= hangingRadius; ++x) {
            for (int z = -hangingRadius; z <= hangingRadius; ++z) {
                if (!this.isInvalidForLeaves(random, Math.abs(x), -1 - foliageHeight, Math.abs(z), hangingRadius, giant)) {
                    if (random.nextFloat() < 0.1f) {
                        int hangLength = 1 + random.nextInt(3);
                        for (int i = 1; i <= hangLength; i++) {
                            mutablePos.set(center, x, -1 - foliageHeight - i, z);
                            placer.placeBlock(mutablePos, config.foliageProvider.get(random, mutablePos));
                        }
                    }
                }
            }
        }
         */
        int hangingRadius = radius + treeNode.getFoliageRadius();
        BlockPos.Mutable mutablePos = new BlockPos.Mutable();
        //chance leave hang 1 block to 3 block and 20%
        float hangChance = 0.2f;
        int minHang = 1;
        int maxHangVariation = 3;

        for (int x = -hangingRadius; x <= hangingRadius; ++x) {
            for (int z = -hangingRadius; z <= hangingRadius; ++z) {
                if (!this.isInvalidForLeaves(random, Math.abs(x), -1 - foliageHeight, Math.abs(z), hangingRadius, giant)) {
                    if (random.nextFloat() < hangChance) {
                        int hangLength = minHang + random.nextInt(maxHangVariation);

                        for (int i = 1; i <= hangLength; i++) {
                            mutablePos.set(center, x, -1 - foliageHeight - i, z);
                            final BlockPos currentPos = mutablePos.toImmutable();

                            if (world.testBlockState(currentPos, state -> {
                                return (state.isAir() || state.isOf(Blocks.WATER))
                                        && !state.isOf(ModBlocks2.FROSTY_APPLE_LOG);
                            })) {

                                placer.placeBlock(currentPos, config.foliageProvider.get(random, currentPos));
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }

    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        if (y == 0) {
            return (dx > 1 || dz > 1) && dx != 0 && dz != 0;
        } else {
            return dx == radius && dz == radius && radius > 0;
        }
    }
}
