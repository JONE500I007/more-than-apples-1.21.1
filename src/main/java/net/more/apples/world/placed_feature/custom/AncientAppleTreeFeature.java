package net.more.apples.world.placed_feature.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.world.tree.custom.ancient_apple.custom.AncientAppleTreeGeneratorBlockEntity;
import net.more.apples.world.tree.custom.ancient_apple.custom.AncientAppleTreePlan;

public class AncientAppleTreeFeature extends Feature<NoneFeatureConfiguration> {

    public AncientAppleTreeFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        if (!level.getBlockState(origin.below()).isSolid()) return false;

        // เช็คความสูงว่างขั้นต่ำ 10 block
        for (int y = 1; y <= 10; y++) {
            if (!level.getBlockState(origin.above(y)).isAir()) {
                return false;
            }
        }

        // ลบส่วนเช็ครอบๆ ออก

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
