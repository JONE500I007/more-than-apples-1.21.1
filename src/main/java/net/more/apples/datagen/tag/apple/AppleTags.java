package net.more.apples.datagen.tag.apple;

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
        provider.addToTag(BlockTags.WOODEN_FENCES, AppleWoodVariants.APPLE_FENCE);
        provider.addToTag(BlockTags.FENCE_GATES, AppleWoodVariants.APPLE_FENCE_GATE);
        provider.addToTag(BlockTags.LOGS_THAT_BURN,
                AppleWoodBlocks.APPLE_LOG,
                AppleWoodBlocks.APPLE_WOOD,
                AppleWoodBlocks.STRIPPED_APPLE_LOG,
                AppleWoodBlocks.STRIPPED_APPLE_WOOD);
        provider.addToTag(BlockTags.PLANKS, AppleWoodBlocks.APPLE_PLANKS);
        provider.addToTag(ModTags.Blocks.ALL_APPLE_LOG,
                AppleWoodBlocks.APPLE_LOG,
                AppleWoodBlocks.STRIPPED_APPLE_LOG,
                AppleWoodBlocks.APPLE_WOOD,
                AppleWoodBlocks.STRIPPED_APPLE_WOOD);
        provider.addToTag(BlockTags.WOODEN_STAIRS, AppleWoodVariants.APPLE_STAIRS);
        provider.addToTag(BlockTags.WOODEN_SLABS, AppleWoodVariants.APPLE_SLAB);
        provider.addToTag(BlockTags.WOODEN_DOORS, AppleWoodVariants.APPLE_DOOR);
        provider.addToTag(BlockTags.WOODEN_TRAPDOORS, AppleWoodVariants.APPLE_TRAPDOOR);
        provider.addToTag(BlockTags.WOODEN_BUTTONS, AppleWoodVariants.APPLE_BUTTON);
        provider.addToTag(BlockTags.WOODEN_PRESSURE_PLATES, AppleWoodVariants.APPLE_PRESSURE_PLATE);
        provider.addToTag(BlockTags.WOODEN_SHELVES, AppleWoodVariants.APPLE_SHELF);
    }

    public static void addItemTags(ModItemTagProvider provider) {
        provider.addToTag(ItemTags.WOODEN_FENCES, AppleWoodVariants.APPLE_FENCE.asItem());
        provider.addToTag(ItemTags.FENCE_GATES, AppleWoodVariants.APPLE_FENCE_GATE.asItem());
        provider.addToTag(ItemTags.LOGS_THAT_BURN,
                AppleWoodBlocks.APPLE_LOG.asItem(),
                AppleWoodBlocks.APPLE_WOOD.asItem(),
                AppleWoodBlocks.STRIPPED_APPLE_LOG.asItem(),
                AppleWoodBlocks.STRIPPED_APPLE_WOOD.asItem());
        provider.addToTag(ItemTags.PLANKS, AppleWoodBlocks.APPLE_PLANKS.asItem());
        provider.addToTag(ModTags.Items.ALL_APPLE_LOG,
                AppleWoodBlocks.APPLE_LOG.asItem(),
                AppleWoodBlocks.STRIPPED_APPLE_LOG.asItem(),
                AppleWoodBlocks.APPLE_WOOD.asItem(),
                AppleWoodBlocks.STRIPPED_APPLE_WOOD.asItem());
        provider.addToTag(ItemTags.WOODEN_STAIRS, AppleWoodVariants.APPLE_STAIRS.asItem());
        provider.addToTag(ItemTags.WOODEN_SLABS, AppleWoodVariants.APPLE_SLAB.asItem());
        provider.addToTag(ItemTags.WOODEN_DOORS, AppleWoodVariants.APPLE_DOOR.asItem());
        provider.addToTag(ItemTags.WOODEN_TRAPDOORS, AppleWoodVariants.APPLE_TRAPDOOR.asItem());
        provider.addToTag(ItemTags.WOODEN_BUTTONS, AppleWoodVariants.APPLE_BUTTON.asItem());
        provider.addToTag(ItemTags.WOODEN_PRESSURE_PLATES, AppleWoodVariants.APPLE_PRESSURE_PLATE.asItem());
        provider.addToTag(ItemTags.WOODEN_SHELVES, AppleWoodVariants.APPLE_SHELF.asItem());
    }
}
