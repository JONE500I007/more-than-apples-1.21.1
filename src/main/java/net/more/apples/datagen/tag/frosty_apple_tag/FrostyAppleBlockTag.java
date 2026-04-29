package net.more.apples.datagen.tag.frosty_apple_tag;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class FrostyAppleBlockTag extends FabricTagsProvider.BlockTagsProvider {
    public FrostyAppleBlockTag(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.WOODEN_FENCES)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE);

        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                .add(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG)
                .add(FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD)
                .add(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG)
                .add(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD);

        valueLookupBuilder(BlockTags.PLANKS)
                .add(FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS);

        valueLookupBuilder(ModTags.Blocks.ALL_FROSTY_APPLE_LOG)
                .add(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG)
                .add(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG)
                .add(FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD)
                .add(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD);


        // --- Stairs ---
        valueLookupBuilder(BlockTags.WOODEN_STAIRS)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_STAIRS);
        // --- Slab ---
        valueLookupBuilder(BlockTags.WOODEN_SLABS)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_SLAB);
        // --- Fence ---
        valueLookupBuilder(BlockTags.WOODEN_FENCES)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE);
        // --- Fence Gate ---
        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE);
        // --- Door ---
        valueLookupBuilder(BlockTags.WOODEN_DOORS)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_DOOR);
        // --- Trapdoor ---
        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_TRAPDOOR);
        // --- Button ---
        valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_BUTTON);
        // --- Pressure Plate ---
        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_PRESSURE_PLATE);
        // --- Shelves ---
        valueLookupBuilder(BlockTags.WOODEN_SHELVES)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_SHELF);
    }
}
