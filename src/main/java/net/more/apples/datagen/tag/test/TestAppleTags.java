package net.more.apples.datagen.tag.test;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;
import net.more.apples.datagen.provider.ModBlockTagProvider;
import net.more.apples.datagen.provider.ModItemTagProvider;
import net.more.apples.util.ModTags;

public final class TestAppleTags {
    private TestAppleTags() {
    }

    public static void addBlockTags(ModBlockTagProvider provider) {
        provider.addToTag(BlockTags.WOODEN_FENCES, TestAppleWoodVariants.TEST_APPLE_FENCE);
        provider.addToTag(BlockTags.FENCE_GATES, TestAppleWoodVariants.TEST_APPLE_FENCE_GATE);
        provider.addToTag(BlockTags.LOGS_THAT_BURN,
                TestAppleWoodBlocks.TEST_APPLE_LOG,
                TestAppleWoodBlocks.TEST_APPLE_WOOD,
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG,
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD);
        provider.addToTag(BlockTags.PLANKS, TestAppleWoodBlocks.TEST_APPLE_PLANKS);
        provider.addToTag(ModTags.Blocks.ALL_TEST_APPLE_LOG,
                TestAppleWoodBlocks.TEST_APPLE_LOG,
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG,
                TestAppleWoodBlocks.TEST_APPLE_WOOD,
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD);
        provider.addToTag(BlockTags.WOODEN_STAIRS, TestAppleWoodVariants.TEST_APPLE_STAIRS);
        provider.addToTag(BlockTags.WOODEN_SLABS, TestAppleWoodVariants.TEST_APPLE_SLAB);
        provider.addToTag(BlockTags.WOODEN_DOORS, TestAppleWoodVariants.TEST_APPLE_DOOR);
        provider.addToTag(BlockTags.WOODEN_TRAPDOORS, TestAppleWoodVariants.TEST_APPLE_TRAPDOOR);
        provider.addToTag(BlockTags.WOODEN_BUTTONS, TestAppleWoodVariants.TEST_APPLE_BUTTON);
        provider.addToTag(BlockTags.WOODEN_PRESSURE_PLATES, TestAppleWoodVariants.TEST_APPLE_PRESSURE_PLATE);
        provider.addToTag(BlockTags.WOODEN_SHELVES, TestAppleWoodVariants.TEST_APPLE_SHELF);
    }

    public static void addItemTags(ModItemTagProvider provider) {
        provider.addToTag(ItemTags.WOODEN_FENCES, TestAppleWoodVariants.TEST_APPLE_FENCE.asItem());
        provider.addToTag(ItemTags.FENCE_GATES, TestAppleWoodVariants.TEST_APPLE_FENCE_GATE.asItem());
        provider.addToTag(ItemTags.LOGS_THAT_BURN,
                TestAppleWoodBlocks.TEST_APPLE_LOG.asItem(),
                TestAppleWoodBlocks.TEST_APPLE_WOOD.asItem(),
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG.asItem(),
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD.asItem());
        provider.addToTag(ItemTags.PLANKS, TestAppleWoodBlocks.TEST_APPLE_PLANKS.asItem());
        provider.addToTag(ModTags.Items.ALL_TEST_APPLE_LOG,
                TestAppleWoodBlocks.TEST_APPLE_LOG.asItem(),
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG.asItem(),
                TestAppleWoodBlocks.TEST_APPLE_WOOD.asItem(),
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD.asItem());
        provider.addToTag(ItemTags.WOODEN_STAIRS, TestAppleWoodVariants.TEST_APPLE_STAIRS.asItem());
        provider.addToTag(ItemTags.WOODEN_SLABS, TestAppleWoodVariants.TEST_APPLE_SLAB.asItem());
        provider.addToTag(ItemTags.WOODEN_DOORS, TestAppleWoodVariants.TEST_APPLE_DOOR.asItem());
        provider.addToTag(ItemTags.WOODEN_TRAPDOORS, TestAppleWoodVariants.TEST_APPLE_TRAPDOOR.asItem());
        provider.addToTag(ItemTags.WOODEN_BUTTONS, TestAppleWoodVariants.TEST_APPLE_BUTTON.asItem());
        provider.addToTag(ItemTags.WOODEN_PRESSURE_PLATES, TestAppleWoodVariants.TEST_APPLE_PRESSURE_PLATE.asItem());
        provider.addToTag(ItemTags.WOODEN_SHELVES, TestAppleWoodVariants.TEST_APPLE_SHELF.asItem());
    }
}
