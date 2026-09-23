package net.more.apples.datagen.tag.apples_tag;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodVariants;
import net.more.apples.datagen.provider.ModBlockTagProvider;
import net.more.apples.datagen.provider.ModItemTagProvider;
import net.more.apples.item.apple_wood_item.AncientAppleWoodItem;
import net.more.apples.util.ModTags;

public final class AncientAppleTags {
    private AncientAppleTags() {
    }

    public static void addBlockTags(ModBlockTagProvider provider) {

        // --- Fences ---
        provider.addToTag(BlockTags.WOODEN_FENCES,
                AncientAppleWoodVariants.ANCIENT_APPLE_FENCE);
        provider.addToTag(ConventionalBlockTags.WOODEN_FENCES,
                AncientAppleWoodVariants.ANCIENT_APPLE_FENCE);

        // --- Fence Gates ---
        provider.addToTag(BlockTags.FENCE_GATES,
                AncientAppleWoodVariants.ANCIENT_APPLE_FENCE_GATE);
        provider.addToTag(ConventionalBlockTags.WOODEN_FENCE_GATES,
                AncientAppleWoodVariants.ANCIENT_APPLE_FENCE_GATE);

        // --- Logs That Burn ---
        provider.addTagToTag(BlockItemTags.LOGS_THAT_BURN.block(), ModTags.Blocks.ALL_ANCIENT_APPLE_LOG);
        provider.addToTag(BlockTags.OVERWORLD_NATURAL_LOGS,
                AncientAppleWoodBlocks.ANCIENT_APPLE_LOG);
        provider.addToTag(ConventionalBlockTags.OVERWORLD_NATURAL_LOGS,
                AncientAppleWoodBlocks.ANCIENT_APPLE_LOG);
        provider.addToTag(ConventionalBlockTags.NATURAL_WOODS,
                AncientAppleWoodBlocks.ANCIENT_APPLE_WOOD);
        provider.addToTag(ConventionalBlockTags.STRIPPED_LOGS,
                AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG);
        provider.addToTag(ConventionalBlockTags.STRIPPED_WOODS,
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

        // --- Leaves ---
        provider.addToTag(BlockTags.LEAVES,
                AncientAppleWoodBlocks.ANCIENT_APPLE_LEAVES);

        // --- Saplings ---
        provider.addToTag(BlockTags.SAPLINGS,
                AncientAppleWoodBlocks.ANCIENT_APPLE_SAPLING,
                AncientAppleWoodBlocks.ANCIENT_APPLE_SAPLING2);

        // --- Signs ---
        provider.addToTag(BlockTags.STANDING_SIGNS,
                AncientAppleWoodVariants.ANCIENT_APPLE_STANDING_SIGN);
        provider.addToTag(BlockTags.WALL_SIGNS,
                AncientAppleWoodVariants.ANCIENT_APPLE_WALL_SIGN);
        provider.addToTag(BlockTags.CEILING_HANGING_SIGNS,
                AncientAppleWoodVariants.ANCIENT_APPLE_HANGING_SIGN_BLOCK);
        provider.addToTag(BlockTags.WALL_HANGING_SIGNS,
                AncientAppleWoodVariants.ANCIENT_APPLE_WALL_HANGING_SIGN);
    }

    public static void addItemTags(ModItemTagProvider provider) {

        // --- Fences ---
        provider.addToTag(ItemTags.WOODEN_FENCES,
                AncientAppleWoodVariants.ANCIENT_APPLE_FENCE.asItem());
        provider.addToTag(ConventionalItemTags.WOODEN_FENCES,
                AncientAppleWoodVariants.ANCIENT_APPLE_FENCE.asItem());

        // --- Fence Gates ---
        provider.addToTag(ItemTags.FENCE_GATES,
                AncientAppleWoodVariants.ANCIENT_APPLE_FENCE_GATE.asItem());
        provider.addToTag(ConventionalItemTags.WOODEN_FENCE_GATES,
                AncientAppleWoodVariants.ANCIENT_APPLE_FENCE_GATE.asItem());

        // --- Logs That Burn ---
        provider.addToTag(ItemTags.LOGS_THAT_BURN,
                AncientAppleWoodBlocks.ANCIENT_APPLE_LOG.asItem(),
                AncientAppleWoodBlocks.ANCIENT_APPLE_WOOD.asItem(),
                AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG.asItem(),
                AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_WOOD.asItem());
        provider.addToTag(ConventionalItemTags.OVERWORLD_NATURAL_LOGS,
                AncientAppleWoodBlocks.ANCIENT_APPLE_LOG.asItem());
        provider.addToTag(ConventionalItemTags.NATURAL_WOODS,
                AncientAppleWoodBlocks.ANCIENT_APPLE_WOOD.asItem());
        provider.addToTag(ConventionalItemTags.STRIPPED_LOGS,
                AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG.asItem());
        provider.addToTag(ConventionalItemTags.STRIPPED_WOODS,
                AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_WOOD.asItem());

        // --- Planks ---
        provider.addToTag(ItemTags.PLANKS,
                AncientAppleWoodBlocks.ANCIENT_APPLE_PLANKS.asItem());

        // --- Custom Ancient Apple Logs ---
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

        // --- Leaves ---
        provider.addToTag(ItemTags.LEAVES,
                AncientAppleWoodBlocks.ANCIENT_APPLE_LEAVES.asItem());

        // --- Saplings ---
        provider.addToTag(ItemTags.SAPLINGS,
                AncientAppleWoodBlocks.ANCIENT_APPLE_SAPLING.asItem(),
                AncientAppleWoodBlocks.ANCIENT_APPLE_SAPLING2.asItem());

        // --- Signs ---
        provider.addToTag(ItemTags.SIGNS,
                AncientAppleWoodItem.ANCIENT_APPLE_SIGN);
        provider.addToTag(ItemTags.HANGING_SIGNS,
                AncientAppleWoodItem.ANCIENT_APPLE_HANGING_SIGN);

        // --- Boats ---
        provider.addToTag(ItemTags.BOATS,
                AncientAppleWoodItem.ANCIENT_APPLE_BOAT);
        provider.addToTag(ItemTags.CHEST_BOATS,
                AncientAppleWoodItem.ANCIENT_APPLE_CHEST_BOAT);
    }
}
