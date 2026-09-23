package net.more.apples.world.placed_feature.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.world.tree.custom.ancient_apple.custom.AncientAppleTreeGeneratorBlockEntity;
import net.more.apples.world.tree.custom.ancient_apple.custom.AncientAppleTreePlan;

public record AncientAppleTreeFeature() implements Feature {
    public static final MapCodec<AncientAppleTreeFeature> CODEC = MapCodec.unit(AncientAppleTreeFeature::new);

    @Override
    public MapCodec<AncientAppleTreeFeature> codec() {
        return CODEC;
    }

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos origin) {

        if (!level.getBlockState(origin.below()).isSolid()) return false;


        for (int y = 1; y <= 10; y++) {
            if (!level.getBlockState(origin.above(y)).isAir()) {
                return false;
            }
        }



        level.setBlock(origin, AncientAppleWoodBlocks.ANCIENT_APPLE_TREE_GENERATOR.defaultBlockState(), 3);

        if (level instanceof ServerLevel serverLevel) {
            BlockEntity be = serverLevel.getBlockEntity(origin);
            if (be instanceof AncientAppleTreeGeneratorBlockEntity generator) {
                generator.setQueue(AncientAppleTreePlan.generate(serverLevel, origin, random));
                return true;
            }
        }

        return false;
    }
}
