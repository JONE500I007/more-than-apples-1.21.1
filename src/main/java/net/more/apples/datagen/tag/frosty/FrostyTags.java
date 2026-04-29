package net.more.apples.datagen.tag.frosty;

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
        provider.addToTag(BlockTags.WOODEN_FENCES, FrostyAppleWoodVariants.FROSTY_APPLE_FENCE);
        provider.addToTag(BlockTags.FENCE_GATES, FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE);
        provider.addToTag(BlockTags.LOGS_THAT_BURN,
                FrostyAppleWoodBlocks.FROSTY_APPLE_LOG,
                FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD,
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG,
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD);
        provider.addToTag(BlockTags.PLANKS, FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS);
        provider.addToTag(ModTags.Blocks.ALL_FROSTY_APPLE_LOG,
                FrostyAppleWoodBlocks.FROSTY_APPLE_LOG,
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG,
                FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD,
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD);
        provider.addToTag(BlockTags.WOODEN_STAIRS, FrostyAppleWoodVariants.FROSTY_APPLE_STAIRS);
        provider.addToTag(BlockTags.WOODEN_SLABS, FrostyAppleWoodVariants.FROSTY_APPLE_SLAB);
        provider.addToTag(BlockTags.WOODEN_DOORS, FrostyAppleWoodVariants.FROSTY_APPLE_DOOR);
        provider.addToTag(BlockTags.WOODEN_TRAPDOORS, FrostyAppleWoodVariants.FROSTY_APPLE_TRAPDOOR);
        provider.addToTag(BlockTags.WOODEN_BUTTONS, FrostyAppleWoodVariants.FROSTY_APPLE_BUTTON);
        provider.addToTag(BlockTags.WOODEN_PRESSURE_PLATES, FrostyAppleWoodVariants.FROSTY_APPLE_PRESSURE_PLATE);
        provider.addToTag(BlockTags.WOODEN_SHELVES, FrostyAppleWoodVariants.FROSTY_APPLE_SHELF);
    }

    public static void addItemTags(ModItemTagProvider provider) {
        provider.addToTag(ItemTags.WOODEN_FENCES, FrostyAppleWoodVariants.FROSTY_APPLE_FENCE.asItem());
        provider.addToTag(ItemTags.FENCE_GATES, FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE.asItem());
        provider.addToTag(ItemTags.LOGS_THAT_BURN,
                FrostyAppleWoodBlocks.FROSTY_APPLE_LOG.asItem(),
                FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD.asItem(),
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG.asItem(),
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD.asItem());
        provider.addToTag(ItemTags.PLANKS, FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS.asItem());
        provider.addToTag(ModTags.Items.ALL_FROSTY_APPLE_LOG,
                FrostyAppleWoodBlocks.FROSTY_APPLE_LOG.asItem(),
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG.asItem(),
                FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD.asItem(),
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD.asItem());
        provider.addToTag(ItemTags.WOODEN_STAIRS, FrostyAppleWoodVariants.FROSTY_APPLE_STAIRS.asItem());
        provider.addToTag(ItemTags.WOODEN_SLABS, FrostyAppleWoodVariants.FROSTY_APPLE_SLAB.asItem());
        provider.addToTag(ItemTags.WOODEN_DOORS, FrostyAppleWoodVariants.FROSTY_APPLE_DOOR.asItem());
        provider.addToTag(ItemTags.WOODEN_TRAPDOORS, FrostyAppleWoodVariants.FROSTY_APPLE_TRAPDOOR.asItem());
        provider.addToTag(ItemTags.WOODEN_BUTTONS, FrostyAppleWoodVariants.FROSTY_APPLE_BUTTON.asItem());
        provider.addToTag(ItemTags.WOODEN_PRESSURE_PLATES, FrostyAppleWoodVariants.FROSTY_APPLE_PRESSURE_PLATE.asItem());
        provider.addToTag(ItemTags.WOODEN_SHELVES, FrostyAppleWoodVariants.FROSTY_APPLE_SHELF.asItem());
    }
}
