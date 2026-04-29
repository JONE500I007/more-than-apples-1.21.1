package net.more.apples.datagen.tag.frosty_apple_tag;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class FrostyAppleItemTag extends FabricTagsProvider.ItemTagsProvider {
    public FrostyAppleItemTag(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(ItemTags.WOODEN_FENCES)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE.asItem());
        valueLookupBuilder(ItemTags.FENCE_GATES)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE.asItem());

        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
                .add(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG.asItem())
                .add(FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD.asItem())
                .add(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG.asItem())
                .add(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD.asItem());

        valueLookupBuilder(ItemTags.PLANKS)
                .add(FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS.asItem());

        valueLookupBuilder(ModTags.Items.ALL_FROSTY_APPLE_LOG)
                .add(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG.asItem())
                .add(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG.asItem())
                .add(FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD.asItem())
                .add(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD.asItem());


        // --- Stairs ---
        valueLookupBuilder(ItemTags.WOODEN_STAIRS)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_STAIRS.asItem());
        // --- Slab ---
        valueLookupBuilder(ItemTags.WOODEN_SLABS)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_SLAB.asItem());
        // --- Fence ---
        valueLookupBuilder(ItemTags.WOODEN_FENCES)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE.asItem());
        // --- Fence Gate ---
        valueLookupBuilder(ItemTags.FENCE_GATES)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE.asItem());
        // --- Door ---
        valueLookupBuilder(ItemTags.WOODEN_DOORS)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_DOOR.asItem());
        // --- Trapdoor ---
        valueLookupBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_TRAPDOOR.asItem());
        // --- Button ---
        valueLookupBuilder(ItemTags.WOODEN_BUTTONS)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_BUTTON.asItem());
        // --- Pressure Plate ---
        valueLookupBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_PRESSURE_PLATE.asItem());
        // --- Shelves ---
        valueLookupBuilder(ItemTags.WOODEN_SHELVES)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_SHELF.asItem());
    }
}
