package net.more.apples.datagen.tag;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.datagen.provider.ModBlockTagProvider;
import net.more.apples.datagen.provider.ModItemTagProvider;
import net.more.apples.util.ModTags;

public final class AppleTags {
    private AppleTags() {
    }

    public static void addBlockTags(ModBlockTagProvider provider) {

        // --- Fences ---
        provider.addToTag(BlockTags.WOODEN_FENCES,
                AppleWoodVariants.APPLE_FENCE);

        // --- Fence Gates ---
        provider.addToTag(BlockTags.FENCE_GATES,
                AppleWoodVariants.APPLE_FENCE_GATE);

        // --- Logs That Burn ---
        provider.addToTag(BlockTags.LOGS_THAT_BURN,
                AppleWoodBlocks.APPLE_LOG,
                AppleWoodBlocks.APPLE_WOOD,
                AppleWoodBlocks.STRIPPED_APPLE_LOG,
                AppleWoodBlocks.STRIPPED_APPLE_WOOD);

        // --- Planks ---
        provider.addToTag(BlockTags.PLANKS,
                AppleWoodBlocks.APPLE_PLANKS);

        // --- Custom Apple Logs ---
        provider.addToTag(ModTags.Blocks.ALL_APPLE_LOG,
                AppleWoodBlocks.APPLE_LOG,
                AppleWoodBlocks.STRIPPED_APPLE_LOG,
                AppleWoodBlocks.APPLE_WOOD,
                AppleWoodBlocks.STRIPPED_APPLE_WOOD);

        // --- Stairs ---
        provider.addToTag(BlockTags.WOODEN_STAIRS,
                AppleWoodVariants.APPLE_STAIRS);

        // --- Slabs ---
        provider.addToTag(BlockTags.WOODEN_SLABS,
                AppleWoodVariants.APPLE_SLAB);

        // --- Doors ---
        provider.addToTag(BlockTags.WOODEN_DOORS,
                AppleWoodVariants.APPLE_DOOR);

        // --- Trapdoors ---
        provider.addToTag(BlockTags.WOODEN_TRAPDOORS,
                AppleWoodVariants.APPLE_TRAPDOOR);

        // --- Buttons ---
        provider.addToTag(BlockTags.WOODEN_BUTTONS,
                AppleWoodVariants.APPLE_BUTTON);

        // --- Pressure Plates ---
        provider.addToTag(BlockTags.WOODEN_PRESSURE_PLATES,
                AppleWoodVariants.APPLE_PRESSURE_PLATE);

        // --- Shelves ---
        provider.addToTag(BlockTags.WOODEN_SHELVES,
                AppleWoodVariants.APPLE_SHELF);
    }

    public static void addItemTags(ModItemTagProvider provider) {

        // --- Fences ---
        provider.addToTag(ItemTags.WOODEN_FENCES,
                AppleWoodVariants.APPLE_FENCE.asItem());

        // --- Fence Gates ---
        provider.addToTag(ItemTags.FENCE_GATES,
                AppleWoodVariants.APPLE_FENCE_GATE.asItem());

        // --- Logs That Burn ---
        provider.addToTag(ItemTags.LOGS_THAT_BURN,
                AppleWoodBlocks.APPLE_LOG.asItem(),
                AppleWoodBlocks.APPLE_WOOD.asItem(),
                AppleWoodBlocks.STRIPPED_APPLE_LOG.asItem(),
                AppleWoodBlocks.STRIPPED_APPLE_WOOD.asItem());

        // --- Planks ---
        provider.addToTag(ItemTags.PLANKS,
                AppleWoodBlocks.APPLE_PLANKS.asItem());

        // --- Custom Apple Logs ---
        provider.addToTag(ModTags.Items.ALL_APPLE_LOG,
                AppleWoodBlocks.APPLE_LOG.asItem(),
                AppleWoodBlocks.STRIPPED_APPLE_LOG.asItem(),
                AppleWoodBlocks.APPLE_WOOD.asItem(),
                AppleWoodBlocks.STRIPPED_APPLE_WOOD.asItem());

        // --- Stairs ---
        provider.addToTag(ItemTags.WOODEN_STAIRS,
                AppleWoodVariants.APPLE_STAIRS.asItem());

        // --- Slabs ---
        provider.addToTag(ItemTags.WOODEN_SLABS,
                AppleWoodVariants.APPLE_SLAB.asItem());

        // --- Doors ---
        provider.addToTag(ItemTags.WOODEN_DOORS,
                AppleWoodVariants.APPLE_DOOR.asItem());

        // --- Trapdoors ---
        provider.addToTag(ItemTags.WOODEN_TRAPDOORS,
                AppleWoodVariants.APPLE_TRAPDOOR.asItem());

        // --- Buttons ---
        provider.addToTag(ItemTags.WOODEN_BUTTONS,
                AppleWoodVariants.APPLE_BUTTON.asItem());

        // --- Pressure Plates ---
        provider.addToTag(ItemTags.WOODEN_PRESSURE_PLATES,
                AppleWoodVariants.APPLE_PRESSURE_PLATE.asItem());

        // --- Shelves ---
        provider.addToTag(ItemTags.WOODEN_SHELVES,
                AppleWoodVariants.APPLE_SHELF.asItem());
    }
}
