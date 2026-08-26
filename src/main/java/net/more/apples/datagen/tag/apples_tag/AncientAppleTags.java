package net.more.apples.datagen.tag.apples_tag;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodVariants;
import net.more.apples.datagen.provider.ModBlockTagProvider;
import net.more.apples.datagen.provider.ModItemTagProvider;
import net.more.apples.util.ModTags;

public final class AncientAppleTags {
    private AncientAppleTags() {
    }

    public static void addBlockTags(ModBlockTagProvider provider) {

        // --- Fences ---
        provider.addToTag(BlockTags.WOODEN_FENCES,
                AncientAppleWoodVariants.ANCIENT_APPLE_FENCE);

        // --- Fence Gates ---
        provider.addToTag(BlockTags.FENCE_GATES,
                AncientAppleWoodVariants.ANCIENT_APPLE_FENCE_GATE);

        // --- Logs That Burn ---
        provider.addToTag(BlockTags.LOGS_THAT_BURN,
                AncientAppleWoodBlocks.ANCIENT_APPLE_LOG,
                AncientAppleWoodBlocks.ANCIENT_APPLE_WOOD,
                AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG,
                AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_WOOD);

        // --- Planks ---
        provider.addToTag(BlockTags.PLANKS,
                AncientAppleWoodBlocks.ANCIENT_APPLE_PLANKS);

        // --- Custom Test Apple Logs ---
        provider.addToTag(ModTags.Blocks.ALL_ANCIENT_APPLE_LOG,
                AncientAppleWoodBlocks.ANCIENT_APPLE_LOG,
                AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG,
                AncientAppleWoodBlocks.ANCIENT_APPLE_WOOD,
                AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_WOOD);

        // --- Stairs ---
        provider.addToTag(BlockTags.WOODEN_STAIRS,
                AncientAppleWoodVariants.ANCIENT_APPLE_STAIRS);

        // --- Slabs ---
        provider.addToTag(BlockTags.WOODEN_SLABS,
                AncientAppleWoodVariants.ANCIENT_APPLE_SLAB);

        // --- Doors ---
        provider.addToTag(BlockTags.WOODEN_DOORS,
                AncientAppleWoodVariants.ANCIENT_APPLE_DOOR);

        // --- Trapdoors ---
        provider.addToTag(BlockTags.WOODEN_TRAPDOORS,
                AncientAppleWoodVariants.ANCIENT_APPLE_TRAPDOOR);

        // --- Buttons ---
        provider.addToTag(BlockTags.WOODEN_BUTTONS,
                AncientAppleWoodVariants.ANCIENT_APPLE_BUTTON);

        // --- Pressure Plates ---
        provider.addToTag(BlockTags.WOODEN_PRESSURE_PLATES,
                AncientAppleWoodVariants.ANCIENT_APPLE_PRESSURE_PLATE);

        // --- Shelves ---
        provider.addToTag(BlockTags.WOODEN_SHELVES,
                AncientAppleWoodVariants.ANCIENT_APPLE_SHELF);
    }

    public static void addItemTags(ModItemTagProvider provider) {

        // --- Fences ---
        provider.addToTag(ItemTags.WOODEN_FENCES,
                AncientAppleWoodVariants.ANCIENT_APPLE_FENCE.asItem());

        // --- Fence Gates ---
        provider.addToTag(ItemTags.FENCE_GATES,
                AncientAppleWoodVariants.ANCIENT_APPLE_FENCE_GATE.asItem());

        // --- Logs That Burn ---
        provider.addToTag(ItemTags.LOGS_THAT_BURN,
                AncientAppleWoodBlocks.ANCIENT_APPLE_LOG.asItem(),
                AncientAppleWoodBlocks.ANCIENT_APPLE_WOOD.asItem(),
                AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG.asItem(),
                AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_WOOD.asItem());

        // --- Planks ---
        provider.addToTag(ItemTags.PLANKS,
                AncientAppleWoodBlocks.ANCIENT_APPLE_PLANKS.asItem());

        // --- Custom Test Apple Logs ---
        provider.addToTag(ModTags.Items.ALL_ANCIENT_APPLE_LOG,
                AncientAppleWoodBlocks.ANCIENT_APPLE_LOG.asItem(),
                AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG.asItem(),
                AncientAppleWoodBlocks.ANCIENT_APPLE_WOOD.asItem(),
                AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_WOOD.asItem());

        // --- Stairs ---
        provider.addToTag(ItemTags.WOODEN_STAIRS,
                AncientAppleWoodVariants.ANCIENT_APPLE_STAIRS.asItem());

        // --- Slabs ---
        provider.addToTag(ItemTags.WOODEN_SLABS,
                AncientAppleWoodVariants.ANCIENT_APPLE_SLAB.asItem());

        // --- Doors ---
        provider.addToTag(ItemTags.WOODEN_DOORS,
                AncientAppleWoodVariants.ANCIENT_APPLE_DOOR.asItem());

        // --- Trapdoors ---
        provider.addToTag(ItemTags.WOODEN_TRAPDOORS,
                AncientAppleWoodVariants.ANCIENT_APPLE_TRAPDOOR.asItem());

        // --- Buttons ---
        provider.addToTag(ItemTags.WOODEN_BUTTONS,
                AncientAppleWoodVariants.ANCIENT_APPLE_BUTTON.asItem());

        // --- Pressure Plates ---
        provider.addToTag(ItemTags.WOODEN_PRESSURE_PLATES,
                AncientAppleWoodVariants.ANCIENT_APPLE_PRESSURE_PLATE.asItem());

        // --- Shelves ---
        provider.addToTag(ItemTags.WOODEN_SHELVES,
                AncientAppleWoodVariants.ANCIENT_APPLE_SHELF.asItem());
    }
}
