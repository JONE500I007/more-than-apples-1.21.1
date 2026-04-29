package net.more.apples.datagen.tag.test_apple_tag;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;
import net.more.apples.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class TestAppleBlockTag extends FabricTagsProvider.BlockTagsProvider {
    public TestAppleBlockTag(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.WOODEN_FENCES)
                .add(TestAppleWoodVariants.TEST_APPLE_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(TestAppleWoodVariants.TEST_APPLE_FENCE_GATE);

        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                .add(TestAppleWoodBlocks.TEST_APPLE_LOG)
                .add(TestAppleWoodBlocks.TEST_APPLE_WOOD)
                .add(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG)
                .add(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD);

        valueLookupBuilder(BlockTags.PLANKS)
                .add(TestAppleWoodBlocks.TEST_APPLE_PLANKS);

        valueLookupBuilder(ModTags.Blocks.ALL_TEST_APPLE_LOG)
                .add(TestAppleWoodBlocks.TEST_APPLE_LOG)
                .add(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG)
                .add(TestAppleWoodBlocks.TEST_APPLE_WOOD)
                .add(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD);


        // --- Stairs ---
        valueLookupBuilder(BlockTags.WOODEN_STAIRS)
                .add(TestAppleWoodVariants.TEST_APPLE_STAIRS);
        // --- Slab ---
        valueLookupBuilder(BlockTags.WOODEN_SLABS)
                .add(TestAppleWoodVariants.TEST_APPLE_SLAB);
        // --- Fence ---
        valueLookupBuilder(BlockTags.WOODEN_FENCES)
                .add(TestAppleWoodVariants.TEST_APPLE_FENCE);
        // --- Fence Gate ---
        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(TestAppleWoodVariants.TEST_APPLE_FENCE_GATE);
        // --- Door ---
        valueLookupBuilder(BlockTags.WOODEN_DOORS)
                .add(TestAppleWoodVariants.TEST_APPLE_DOOR);
        // --- Trapdoor ---
        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(TestAppleWoodVariants.TEST_APPLE_TRAPDOOR);
        // --- Button ---
        valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
                .add(TestAppleWoodVariants.TEST_APPLE_BUTTON);
        // --- Pressure Plate ---
        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(TestAppleWoodVariants.TEST_APPLE_PRESSURE_PLATE);
        // --- Shelves ---
        valueLookupBuilder(BlockTags.WOODEN_SHELVES)
                .add(TestAppleWoodVariants.TEST_APPLE_SHELF);
    }
}
