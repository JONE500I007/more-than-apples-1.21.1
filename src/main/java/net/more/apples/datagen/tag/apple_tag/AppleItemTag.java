package net.more.apples.datagen.tag.apple_tag;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class AppleItemTag extends FabricTagsProvider.ItemTagsProvider {
    public AppleItemTag(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
//        getOrCreateTagBuilder(ItemTags.PICKAXE_MINEABLE)
//                .add(ModBlocks2.APPLE_PLANKS);
//
//        getOrCreateTagBuilder(ItemTags.NEEDS_IRON_TOOL)
//                .add(ModBlocks2.DEEPSLATE_APPLE_ORE);

        valueLookupBuilder(ItemTags.WOODEN_FENCES)
                .add(AppleWoodVariants.APPLE_FENCE.asItem());
        valueLookupBuilder(ItemTags.FENCE_GATES)
                .add(AppleWoodVariants.APPLE_FENCE_GATE.asItem());

        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
                .add(AppleWoodBlocks.APPLE_LOG.asItem())
                .add(AppleWoodBlocks.APPLE_WOOD.asItem())
                .add(AppleWoodBlocks.STRIPPED_APPLE_LOG.asItem())
                .add(AppleWoodBlocks.STRIPPED_APPLE_WOOD.asItem());

        valueLookupBuilder(ItemTags.PLANKS)
                .add(AppleWoodBlocks.APPLE_PLANKS.asItem());

        valueLookupBuilder(ModTags.Items.ALL_APPLE_LOG)
                .add(AppleWoodBlocks.APPLE_LOG.asItem())
                .add(AppleWoodBlocks.STRIPPED_APPLE_LOG.asItem())
                .add(AppleWoodBlocks.APPLE_WOOD.asItem())
                .add(AppleWoodBlocks.STRIPPED_APPLE_WOOD.asItem());


        // --- Stairs ---
        valueLookupBuilder(ItemTags.WOODEN_STAIRS)
                .add(AppleWoodVariants.APPLE_STAIRS.asItem());
        // --- Slab ---
        valueLookupBuilder(ItemTags.WOODEN_SLABS)
                .add(AppleWoodVariants.APPLE_SLAB.asItem());
        // --- Fence ---
        valueLookupBuilder(ItemTags.WOODEN_FENCES)
                .add(AppleWoodVariants.APPLE_FENCE.asItem());
        // --- Fence Gate ---
        valueLookupBuilder(ItemTags.FENCE_GATES)
                .add(AppleWoodVariants.APPLE_FENCE_GATE.asItem());
        // --- Door ---
        valueLookupBuilder(ItemTags.WOODEN_DOORS)
                .add(AppleWoodVariants.APPLE_DOOR.asItem());
        // --- Trapdoor ---
        valueLookupBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(AppleWoodVariants.APPLE_TRAPDOOR.asItem());
        // --- Button ---
        valueLookupBuilder(ItemTags.WOODEN_BUTTONS)
                .add(AppleWoodVariants.APPLE_BUTTON.asItem());
        // --- Pressure Plate ---
        valueLookupBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(AppleWoodVariants.APPLE_PRESSURE_PLATE.asItem());
        // --- Shelves ---
        valueLookupBuilder(ItemTags.WOODEN_SHELVES)
                .add(AppleWoodVariants.APPLE_SHELF.asItem());


//        valueLookupBuilder(ModTags.Blocks.ALL_THE_SHELF)
//                .addTag(ItemTags.WOODEN_SHELVES)
//                .add(ModBlocks2.APPLE_SHELF);

    }
}
