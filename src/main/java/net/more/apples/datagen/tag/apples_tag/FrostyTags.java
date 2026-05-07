package net.more.apples.datagen.tag.apples_tag;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.datagen.provider.ModBlockTagProvider;
import net.more.apples.datagen.provider.ModItemTagProvider;
import net.more.apples.util.ModTags;

public final class FrostyTags {
    private FrostyTags() {
    }

    public static void addBlockTags(ModBlockTagProvider provider) {

        // --- Fences ---
        provider.addToTag(BlockTags.WOODEN_FENCES,
                FrostyAppleWoodVariants.FROSTY_APPLE_FENCE);

        // --- Fence Gates ---
        provider.addToTag(BlockTags.FENCE_GATES,
                FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE);

        // --- Logs That Burn ---
        provider.addToTag(BlockTags.LOGS_THAT_BURN,
                FrostyAppleWoodBlocks.FROSTY_APPLE_LOG,
                FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD,
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG,
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD);

        // --- Planks ---
        provider.addToTag(BlockTags.PLANKS,
                FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS);

        // --- Custom Frosty Apple Logs ---
        provider.addToTag(ModTags.Blocks.ALL_FROSTY_APPLE_LOG,
                FrostyAppleWoodBlocks.FROSTY_APPLE_LOG,
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG,
                FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD,
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD);

        // --- Stairs ---
        provider.addToTag(BlockTags.WOODEN_STAIRS,
                FrostyAppleWoodVariants.FROSTY_APPLE_STAIRS);

        // --- Slabs ---
        provider.addToTag(BlockTags.WOODEN_SLABS,
                FrostyAppleWoodVariants.FROSTY_APPLE_SLAB);

        // --- Doors ---
        provider.addToTag(BlockTags.WOODEN_DOORS,
                FrostyAppleWoodVariants.FROSTY_APPLE_DOOR);

        // --- Trapdoors ---
        provider.addToTag(BlockTags.WOODEN_TRAPDOORS,
                FrostyAppleWoodVariants.FROSTY_APPLE_TRAPDOOR);

        // --- Buttons ---
        provider.addToTag(BlockTags.WOODEN_BUTTONS,
                FrostyAppleWoodVariants.FROSTY_APPLE_BUTTON);

        // --- Pressure Plates ---
        provider.addToTag(BlockTags.WOODEN_PRESSURE_PLATES,
                FrostyAppleWoodVariants.FROSTY_APPLE_PRESSURE_PLATE);

        // --- Shelves ---
        provider.addToTag(BlockTags.WOODEN_SHELVES,
                FrostyAppleWoodVariants.FROSTY_APPLE_SHELF);
    }

    public static void addItemTags(ModItemTagProvider provider) {

        // --- Fences ---
        provider.addToTag(ItemTags.WOODEN_FENCES,
                FrostyAppleWoodVariants.FROSTY_APPLE_FENCE.asItem());

        // --- Fence Gates ---
        provider.addToTag(ItemTags.FENCE_GATES,
                FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE.asItem());

        // --- Logs That Burn ---
        provider.addToTag(ItemTags.LOGS_THAT_BURN,
                FrostyAppleWoodBlocks.FROSTY_APPLE_LOG.asItem(),
                FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD.asItem(),
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG.asItem(),
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD.asItem());

        // --- Planks ---
        provider.addToTag(ItemTags.PLANKS,
                FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS.asItem());

        // --- Custom Frosty Apple Logs ---
        provider.addToTag(ModTags.Items.ALL_FROSTY_APPLE_LOG,
                FrostyAppleWoodBlocks.FROSTY_APPLE_LOG.asItem(),
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG.asItem(),
                FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD.asItem(),
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD.asItem());

        // --- Stairs ---
        provider.addToTag(ItemTags.WOODEN_STAIRS,
                FrostyAppleWoodVariants.FROSTY_APPLE_STAIRS.asItem());

        // --- Slabs ---
        provider.addToTag(ItemTags.WOODEN_SLABS,
                FrostyAppleWoodVariants.FROSTY_APPLE_SLAB.asItem());

        // --- Doors ---
        provider.addToTag(ItemTags.WOODEN_DOORS,
                FrostyAppleWoodVariants.FROSTY_APPLE_DOOR.asItem());

        // --- Trapdoors ---
        provider.addToTag(ItemTags.WOODEN_TRAPDOORS,
                FrostyAppleWoodVariants.FROSTY_APPLE_TRAPDOOR.asItem());

        // --- Buttons ---
        provider.addToTag(ItemTags.WOODEN_BUTTONS,
                FrostyAppleWoodVariants.FROSTY_APPLE_BUTTON.asItem());

        // --- Pressure Plates ---
        provider.addToTag(ItemTags.WOODEN_PRESSURE_PLATES,
                FrostyAppleWoodVariants.FROSTY_APPLE_PRESSURE_PLATE.asItem());

        // --- Shelves ---
        provider.addToTag(ItemTags.WOODEN_SHELVES,
                FrostyAppleWoodVariants.FROSTY_APPLE_SHELF.asItem());
    }
}
