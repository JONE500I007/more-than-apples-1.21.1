package net.more.apples.datagen.tag;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.tags.BlockTags;
import net.more.apples.block.general_block.ModGeneralBlock;
import net.more.apples.block.ore_block.ModBlockOre;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodVariants;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;
import net.more.apples.datagen.provider.ModBlockTagProvider;

public final class BlockTagsPr {
    private BlockTagsPr() {
    }

    public static void addBlockTags(ModBlockTagProvider provider) {
        provider.addToTag(BlockTags.MINEABLE_WITH_AXE,
                ModGeneralBlock.APPLE_BARREL,

                // Apple
                AppleWoodVariants.APPLE_STANDING_SIGN,
                AppleWoodVariants.APPLE_WALL_SIGN,
                AppleWoodVariants.APPLE_HANGING_SIGN_BLOCK,
                AppleWoodVariants.APPLE_WALL_HANGING_SIGN,

                // Test Apple
                TestAppleWoodVariants.TEST_APPLE_STANDING_SIGN,
                TestAppleWoodVariants.TEST_APPLE_WALL_SIGN,
                TestAppleWoodVariants.TEST_APPLE_HANGING_SIGN_BLOCK,
                TestAppleWoodVariants.TEST_APPLE_WALL_HANGING_SIGN,

                // Frosty Apple
                FrostyAppleWoodVariants.FROSTY_APPLE_STANDING_SIGN,
                FrostyAppleWoodVariants.FROSTY_APPLE_WALL_SIGN,
                FrostyAppleWoodVariants.FROSTY_APPLE_HANGING_SIGN_BLOCK,
                FrostyAppleWoodVariants.FROSTY_APPLE_WALL_HANGING_SIGN,

                // Ancient Apple
                AncientAppleWoodVariants.ANCIENT_APPLE_STANDING_SIGN,
                AncientAppleWoodVariants.ANCIENT_APPLE_WALL_SIGN,
                AncientAppleWoodVariants.ANCIENT_APPLE_HANGING_SIGN_BLOCK,
                AncientAppleWoodVariants.ANCIENT_APPLE_WALL_HANGING_SIGN);

        provider.addToTag(BlockTags.MINEABLE_WITH_HOE,
                // Apple Leaves
                AppleWoodBlocks.APPLE_LEAVES,
                AppleWoodBlocks.FRUIT_APPLE_LEAVES,

                // Test Apple Leaves
                TestAppleWoodBlocks.TEST_APPLE_LEAVES,

                // Golden Apple Leaves
                AppleWoodBlocks.GOLDEN_APPLE_LEAVES,
                AppleWoodBlocks.FRUIT_GOLDEN_APPLE_LEAVES,

                // Frosty Apple Leaves
                FrostyAppleWoodBlocks.FROSTY_APPLE_LEAVES,

                // Ancient Apple Leaves
                AncientAppleWoodBlocks.ANCIENT_APPLE_LEAVES);

        provider.addToTag(BlockTags.PREVENTS_NEARBY_LEAF_DECAY,
                AppleWoodBlocks.APPLE_LOG,
                TestAppleWoodBlocks.TEST_APPLE_LOG,
                FrostyAppleWoodBlocks.FROSTY_APPLE_LOG,
                AncientAppleWoodBlocks.ANCIENT_APPLE_LOG);

        provider.addToTag(BlockTags.LOGS,
                AppleWoodBlocks.APPLE_LOG,
                TestAppleWoodBlocks.TEST_APPLE_LOG,
                FrostyAppleWoodBlocks.FROSTY_APPLE_LOG,
                AncientAppleWoodBlocks.ANCIENT_APPLE_LOG);

        // --- Apple Blossom ---
        provider.addToTag(BlockTags.SMALL_FLOWERS,
                AncientAppleWoodBlocks.APPLE_BLOSSOM,
                AncientAppleWoodBlocks.APPLE_BLOSSOMV2);
        provider.addToTag(ConventionalBlockTags.SMALL_FLOWERS,
                AncientAppleWoodBlocks.APPLE_BLOSSOM,
                AncientAppleWoodBlocks.APPLE_BLOSSOMV2);
        provider.addToTag(BlockTags.BEE_ATTRACTIVE,
                AncientAppleWoodBlocks.APPLE_BLOSSOM,
                AncientAppleWoodBlocks.APPLE_BLOSSOMV2);
        provider.addToTag(BlockTags.FLOWER_POTS,
                AncientAppleWoodBlocks.POTTED_APPLE_BLOSSOM);

        // --- Apple Leaf Litter ---
        provider.addToTag(BlockTags.INSIDE_STEP_SOUND_BLOCKS,
                AncientAppleWoodBlocks.APPLE_LEAF_LITTER);
        provider.addToTag(BlockTags.REPLACEABLE,
                AncientAppleWoodBlocks.APPLE_LEAF_LITTER);
        provider.addToTag(BlockTags.REPLACEABLE_BY_MUSHROOMS,
                AncientAppleWoodBlocks.APPLE_LEAF_LITTER);
        provider.addToTag(BlockTags.REPLACEABLE_BY_TREES,
                AncientAppleWoodBlocks.APPLE_LEAF_LITTER);

        provider.addToTag(BlockTags.WASHED_AWAY_BY_FLUIDS,
                AncientAppleWoodBlocks.APPLE_BLOSSOM,
                AncientAppleWoodBlocks.APPLE_BLOSSOMV2,
                AncientAppleWoodBlocks.APPLE_LEAF_LITTER);

        provider.addToTag(BlockTags.BLOCKS_MOTION_NO_LEAVES,
                ModGeneralBlock.APPLE_BARREL);

        // --- Apple Ores ---
        provider.addToTag(BlockTags.ORES,
                ModBlockOre.APPLE_ORE,
                ModBlockOre.DEEPSLATE_APPLE_ORE);
        provider.addToTag(ConventionalBlockTags.ORES,
                ModBlockOre.APPLE_ORE,
                ModBlockOre.DEEPSLATE_APPLE_ORE);
        provider.addToTag(ConventionalBlockTags.ORES_IN_GROUND_STONE,
                ModBlockOre.APPLE_ORE);
        provider.addToTag(ConventionalBlockTags.ORES_IN_GROUND_DEEPSLATE,
                ModBlockOre.DEEPSLATE_APPLE_ORE);


        provider.addToTag(ConventionalBlockTags.ORE_RATES_DENSE,
                ModBlockOre.APPLE_ORE,
                ModBlockOre.DEEPSLATE_APPLE_ORE);
        provider.addToTag(BlockTags.SNAPS_GOAT_HORN,
                ModBlockOre.APPLE_ORE);
    }
}
