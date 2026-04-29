package net.more.apples.datagen.tag.apple_tag;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class AppleBlockTag extends FabricTagsProvider.BlockTagsProvider {
    public AppleBlockTag(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
//        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
//                .add(ModBlocks2.APPLE_PLANKS);
//
//        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
//                .add(ModBlocks2.DEEPSLATE_APPLE_ORE);

        valueLookupBuilder(BlockTags.WOODEN_FENCES)
                .add(AppleWoodVariants.APPLE_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(AppleWoodVariants.APPLE_FENCE_GATE);

        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                .add(AppleWoodBlocks.APPLE_LOG)
                .add(AppleWoodBlocks.APPLE_WOOD)
                .add(AppleWoodBlocks.STRIPPED_APPLE_LOG)
                .add(AppleWoodBlocks.STRIPPED_APPLE_WOOD);

        valueLookupBuilder(BlockTags.PLANKS)
                .add(AppleWoodBlocks.APPLE_PLANKS);

        valueLookupBuilder(ModTags.Blocks.ALL_APPLE_LOG)
                .add(AppleWoodBlocks.APPLE_LOG)
                .add(AppleWoodBlocks.STRIPPED_APPLE_LOG)
                .add(AppleWoodBlocks.APPLE_WOOD)
                .add(AppleWoodBlocks.STRIPPED_APPLE_WOOD);


        // --- Stairs ---
        valueLookupBuilder(BlockTags.WOODEN_STAIRS)
                .add(AppleWoodVariants.APPLE_STAIRS);
        // --- Slab ---
        valueLookupBuilder(BlockTags.WOODEN_SLABS)
                .add(AppleWoodVariants.APPLE_SLAB);
        // --- Fence ---
        valueLookupBuilder(BlockTags.WOODEN_FENCES)
                .add(AppleWoodVariants.APPLE_FENCE);
        // --- Fence Gate ---
        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(AppleWoodVariants.APPLE_FENCE_GATE);
        // --- Door ---
        valueLookupBuilder(BlockTags.WOODEN_DOORS)
                .add(AppleWoodVariants.APPLE_DOOR);
        // --- Trapdoor ---
        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(AppleWoodVariants.APPLE_TRAPDOOR);
        // --- Button ---
        valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
                .add(AppleWoodVariants.APPLE_BUTTON);
        // --- Pressure Plate ---
        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(AppleWoodVariants.APPLE_PRESSURE_PLATE);
        // --- Shelves ---
        valueLookupBuilder(BlockTags.WOODEN_SHELVES)
                .add(AppleWoodVariants.APPLE_SHELF);


//        valueLookupBuilder(ModTags.Blocks.ALL_THE_SHELF)
//                .addTag(BlockTags.WOODEN_SHELVES)
//                .add(ModBlocks2.APPLE_SHELF);

    }
}
