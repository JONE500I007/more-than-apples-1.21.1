package net.more.apples.world.tree.custom.frosty_tree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.more.apples.world.tree.ModFoliagePlacerType;

public class FrostyAppleFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<FrostyAppleFoliagePlacer> CODEC =
            RecordCodecBuilder.mapCodec(foliagePlacerInstance
                    -> foliagePlacerParts(foliagePlacerInstance)
                    .and(Codec.intRange(0, 12).fieldOf("height")
                            .forGetter(applePlacer -> applePlacer.height))
                    .apply(foliagePlacerInstance, FrostyAppleFoliagePlacer::new));

    private final int height;

    public FrostyAppleFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacerType.FROSTY_FOLIAGE_PLACER;
    }

    @Override
    protected void createFoliage(WorldGenLevel level,
                                 FoliageSetter foliageSetter,
                                 RandomSource random,
                                 TreeConfiguration config,
                                 int treeHeight,
                                 FoliageAttachment attachment,
                                 int foliageHeight,
                                 int leafRadius,
                                 int offset) {
        // generateSquare(world, placer, random, config, treeNode.getCenter());
        // radius on how many blocks it extends into x and z direction
        // y how much offset in the y direction from treeNode.getCenter()
        // y if it is dependent on i, also offsets each new layer in the y direction
        /*
        generateSquare(world, placer, random, config, treeNode.getCenter().up(0),1,1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(1),1,1, treeNode.isGiantTrunk());
        generateSquare(world, placer, random, config, treeNode.getCenter().up(2),1,1, treeNode.isGiantTrunk());
         */
        boolean giant = attachment.doubleTrunk();
        BlockPos center = attachment.pos().above(offset);

        this.placeLeavesRow(level, foliageSetter, random, config, center, leafRadius + attachment.radiusOffset(), -1 - foliageHeight, giant);
        this.placeLeavesRow(level, foliageSetter, random, config, center, leafRadius - 1, -foliageHeight, giant);
        this.placeLeavesRow(level, foliageSetter, random, config, center, leafRadius + attachment.radiusOffset() - 1, 0, giant);

        int hangingRadius = leafRadius + attachment.radiusOffset();
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        //chance leave hang 1 block to 3 block and 20%
        float hangChance = 0.2f;
        int minHang = 1;
        int maxHangVariation = 3;

//        for (int x = -hangingRadius; x <= hangingRadius; ++x) {
//            for (int z = -hangingRadius; z <= hangingRadius; ++z) {
//                if (!this.shouldSkipLocation(random, Math.abs(x), -1 - foliageHeight, Math.abs(z), hangingRadius, giant)) {
//                    if (random.nextFloat() < hangChance) {
//                        int hangLength = minHang + random.nextInt(maxHangVariation);
//
//                        for (int i = 1; i <= hangLength; i++) {
//                            mutablePos.set(
//                                    center.getX() + x,
//                                    center.getY() - 1 - foliageHeight - i,
//                                    center.getZ() + z);
//                            final BlockPos currentPos = mutablePos.immutable();
//
//                            if ((level.getBlockState(currentPos).getBlock() == Blocks.AIR
//                                    || level.getBlockState(currentPos).getBlock() == Blocks.WATER)
//                                    && level.getBlockState(currentPos).getBlock() != FrostyAppleWoodBlocks.FROSTY_APPLE_LOG) {
//                                foliageSetter.set(currentPos, config.foliageProvider.getState(level, random, currentPos));
//                            } else {
//                                {
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }

    @Override
    public int foliageHeight(RandomSource random, int treeHeight, TreeConfiguration config) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int dx, int y, int dz, int currentRadius, boolean doubleTrunk) {
        if (y == 0) {
            return (dx > 1 || dz > 1) && dx != 0 && dz != 0;
        } else {
            return dx == currentRadius && dz == currentRadius && currentRadius > 0;
        }
    }
}
