package net.more.apples.datagen.tag;

import net.minecraft.tags.BlockTags;
import net.more.apples.block.general_block.ModGeneralBlock;
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
                FrostyAppleWoodVariants.FROSTY_APPLE_WALL_HANGING_SIGN);

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
                FrostyAppleWoodBlocks.FROSTY_APPLE_LEAVES);
    }
}
