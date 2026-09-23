package net.more.apples.datagen.tag.apples_tag;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;
import net.more.apples.datagen.provider.ModBlockTagProvider;
import net.more.apples.datagen.provider.ModItemTagProvider;
import net.more.apples.item.apple_wood_item.TestAppleWoodItem;
import net.more.apples.util.ModTags;

public final class TestAppleTags {
    private TestAppleTags() {
    }

    public static void addBlockTags(ModBlockTagProvider provider) {

        // --- Fences ---
        provider.addToTag(BlockTags.WOODEN_FENCES,
                TestAppleWoodVariants.TEST_APPLE_FENCE);
        provider.addToTag(ConventionalBlockTags.WOODEN_FENCES,
                TestAppleWoodVariants.TEST_APPLE_FENCE);

        // --- Fence Gates ---
        provider.addToTag(BlockTags.FENCE_GATES,
                TestAppleWoodVariants.TEST_APPLE_FENCE_GATE);
        provider.addToTag(ConventionalBlockTags.WOODEN_FENCE_GATES,
                TestAppleWoodVariants.TEST_APPLE_FENCE_GATE);

        // --- Logs That Burn ---
        provider.addTagToTag(BlockItemTags.LOGS_THAT_BURN.block(), ModTags.Blocks.ALL_TEST_APPLE_LOG);
        provider.addToTag(BlockTags.OVERWORLD_NATURAL_LOGS,
                TestAppleWoodBlocks.TEST_APPLE_LOG);
        provider.addToTag(ConventionalBlockTags.OVERWORLD_NATURAL_LOGS,
                TestAppleWoodBlocks.TEST_APPLE_LOG);
        provider.addToTag(ConventionalBlockTags.NATURAL_WOODS,
                TestAppleWoodBlocks.TEST_APPLE_WOOD);
        provider.addToTag(ConventionalBlockTags.STRIPPED_LOGS,
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG);
        provider.addToTag(ConventionalBlockTags.STRIPPED_WOODS,
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

        // --- Leaves ---
        provider.addToTag(BlockTags.LEAVES,
                TestAppleWoodBlocks.TEST_APPLE_LEAVES);

        // --- Saplings ---
        provider.addToTag(BlockTags.SAPLINGS,
                TestAppleWoodBlocks.TEST_APPLE_SAPLING);

        // --- Signs ---
        provider.addToTag(BlockTags.STANDING_SIGNS,
                TestAppleWoodVariants.TEST_APPLE_STANDING_SIGN);
        provider.addToTag(BlockTags.WALL_SIGNS,
                TestAppleWoodVariants.TEST_APPLE_WALL_SIGN);
        provider.addToTag(BlockTags.CEILING_HANGING_SIGNS,
                TestAppleWoodVariants.TEST_APPLE_HANGING_SIGN_BLOCK);
        provider.addToTag(BlockTags.WALL_HANGING_SIGNS,
                TestAppleWoodVariants.TEST_APPLE_WALL_HANGING_SIGN);
    }

    public static void addItemTags(ModItemTagProvider provider) {

        // --- Fences ---
        provider.addToTag(ItemTags.WOODEN_FENCES,
                TestAppleWoodVariants.TEST_APPLE_FENCE.asItem());
        provider.addToTag(ConventionalItemTags.WOODEN_FENCES,
                TestAppleWoodVariants.TEST_APPLE_FENCE.asItem());

        // --- Fence Gates ---
        provider.addToTag(ItemTags.FENCE_GATES,
                TestAppleWoodVariants.TEST_APPLE_FENCE_GATE.asItem());
        provider.addToTag(ConventionalItemTags.WOODEN_FENCE_GATES,
                TestAppleWoodVariants.TEST_APPLE_FENCE_GATE.asItem());

        // --- Logs That Burn ---
        provider.addToTag(ItemTags.LOGS_THAT_BURN,
                TestAppleWoodBlocks.TEST_APPLE_LOG.asItem(),
                TestAppleWoodBlocks.TEST_APPLE_WOOD.asItem(),
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG.asItem(),
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD.asItem());
        provider.addToTag(ConventionalItemTags.OVERWORLD_NATURAL_LOGS,
                TestAppleWoodBlocks.TEST_APPLE_LOG.asItem());
        provider.addToTag(ConventionalItemTags.NATURAL_WOODS,
                TestAppleWoodBlocks.TEST_APPLE_WOOD.asItem());
        provider.addToTag(ConventionalItemTags.STRIPPED_LOGS,
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG.asItem());
        provider.addToTag(ConventionalItemTags.STRIPPED_WOODS,
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

        // --- Leaves ---
        provider.addToTag(ItemTags.LEAVES,
                TestAppleWoodBlocks.TEST_APPLE_LEAVES.asItem());

        // --- Saplings ---
        provider.addToTag(ItemTags.SAPLINGS,
                TestAppleWoodBlocks.TEST_APPLE_SAPLING.asItem());

        // --- Signs ---
        provider.addToTag(ItemTags.SIGNS,
                TestAppleWoodItem.TEST_APPLE_SIGN);
        provider.addToTag(ItemTags.HANGING_SIGNS,
                TestAppleWoodItem.TEST_APPLE_HANGING_SIGN);

        // --- Boats ---
        provider.addToTag(ItemTags.BOATS,
                TestAppleWoodItem.TEST_APPLE_BOAT);
        provider.addToTag(ItemTags.CHEST_BOATS,
                TestAppleWoodItem.TEST_APPLE_CHEST_BOAT);
    }
}
