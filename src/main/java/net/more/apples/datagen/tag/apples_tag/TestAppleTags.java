package net.more.apples.datagen.tag.apples_tag;

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

        // --- Fences ---
        provider.addToTag(BlockTags.WOODEN_FENCES,
                TestAppleWoodVariants.TEST_APPLE_FENCE);

        // --- Fence Gates ---
        provider.addToTag(BlockTags.FENCE_GATES,
                TestAppleWoodVariants.TEST_APPLE_FENCE_GATE);

        // --- Logs That Burn ---
        provider.addToTag(BlockTags.LOGS_THAT_BURN,
                TestAppleWoodBlocks.TEST_APPLE_LOG,
                TestAppleWoodBlocks.TEST_APPLE_WOOD,
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG,
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD);

        // --- Planks ---
        provider.addToTag(BlockTags.PLANKS,
                TestAppleWoodBlocks.TEST_APPLE_PLANKS);

        // --- Custom Test Apple Logs ---
        provider.addToTag(ModTags.Blocks.ALL_TEST_APPLE_LOG,
                TestAppleWoodBlocks.TEST_APPLE_LOG,
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG,
                TestAppleWoodBlocks.TEST_APPLE_WOOD,
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD);

        // --- Stairs ---
        provider.addToTag(BlockTags.WOODEN_STAIRS,
                TestAppleWoodVariants.TEST_APPLE_STAIRS);

        // --- Slabs ---
        provider.addToTag(BlockTags.WOODEN_SLABS,
                TestAppleWoodVariants.TEST_APPLE_SLAB);

        // --- Doors ---
        provider.addToTag(BlockTags.WOODEN_DOORS,
                TestAppleWoodVariants.TEST_APPLE_DOOR);

        // --- Trapdoors ---
        provider.addToTag(BlockTags.WOODEN_TRAPDOORS,
                TestAppleWoodVariants.TEST_APPLE_TRAPDOOR);

        // --- Buttons ---
        provider.addToTag(BlockTags.WOODEN_BUTTONS,
                TestAppleWoodVariants.TEST_APPLE_BUTTON);

        // --- Pressure Plates ---
        provider.addToTag(BlockTags.WOODEN_PRESSURE_PLATES,
                TestAppleWoodVariants.TEST_APPLE_PRESSURE_PLATE);

        // --- Shelves ---
        provider.addToTag(BlockTags.WOODEN_SHELVES,
                TestAppleWoodVariants.TEST_APPLE_SHELF);
    }

    public static void addItemTags(ModItemTagProvider provider) {

        // --- Fences ---
        provider.addToTag(ItemTags.WOODEN_FENCES,
                TestAppleWoodVariants.TEST_APPLE_FENCE.asItem());

        // --- Fence Gates ---
        provider.addToTag(ItemTags.FENCE_GATES,
                TestAppleWoodVariants.TEST_APPLE_FENCE_GATE.asItem());

        // --- Logs That Burn ---
        provider.addToTag(ItemTags.LOGS_THAT_BURN,
                TestAppleWoodBlocks.TEST_APPLE_LOG.asItem(),
                TestAppleWoodBlocks.TEST_APPLE_WOOD.asItem(),
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG.asItem(),
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD.asItem());

        // --- Planks ---
        provider.addToTag(ItemTags.PLANKS,
                TestAppleWoodBlocks.TEST_APPLE_PLANKS.asItem());

        // --- Custom Test Apple Logs ---
        provider.addToTag(ModTags.Items.ALL_TEST_APPLE_LOG,
                TestAppleWoodBlocks.TEST_APPLE_LOG.asItem(),
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG.asItem(),
                TestAppleWoodBlocks.TEST_APPLE_WOOD.asItem(),
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD.asItem());

        // --- Stairs ---
        provider.addToTag(ItemTags.WOODEN_STAIRS,
                TestAppleWoodVariants.TEST_APPLE_STAIRS.asItem());

        // --- Slabs ---
        provider.addToTag(ItemTags.WOODEN_SLABS,
                TestAppleWoodVariants.TEST_APPLE_SLAB.asItem());

        // --- Doors ---
        provider.addToTag(ItemTags.WOODEN_DOORS,
                TestAppleWoodVariants.TEST_APPLE_DOOR.asItem());

        // --- Trapdoors ---
        provider.addToTag(ItemTags.WOODEN_TRAPDOORS,
                TestAppleWoodVariants.TEST_APPLE_TRAPDOOR.asItem());

        // --- Buttons ---
        provider.addToTag(ItemTags.WOODEN_BUTTONS,
                TestAppleWoodVariants.TEST_APPLE_BUTTON.asItem());

        // --- Pressure Plates ---
        provider.addToTag(ItemTags.WOODEN_PRESSURE_PLATES,
                TestAppleWoodVariants.TEST_APPLE_PRESSURE_PLATE.asItem());

        // --- Shelves ---
        provider.addToTag(ItemTags.WOODEN_SHELVES,
                TestAppleWoodVariants.TEST_APPLE_SHELF.asItem());
    }
}
