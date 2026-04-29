package net.more.apples.datagen.tag.test_apple_tag;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;
import net.more.apples.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class TestAppleItemTag extends FabricTagsProvider.ItemTagsProvider {
    public TestAppleItemTag(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(ItemTags.WOODEN_FENCES)
                .add(TestAppleWoodVariants.TEST_APPLE_FENCE.asItem());
        valueLookupBuilder(ItemTags.FENCE_GATES)
                .add(TestAppleWoodVariants.TEST_APPLE_FENCE_GATE.asItem());

        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
                .add(TestAppleWoodBlocks.TEST_APPLE_LOG.asItem())
                .add(TestAppleWoodBlocks.TEST_APPLE_WOOD.asItem())
                .add(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG.asItem())
                .add(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD.asItem());

        valueLookupBuilder(ItemTags.PLANKS)
                .add(TestAppleWoodBlocks.TEST_APPLE_PLANKS.asItem());

        valueLookupBuilder(ModTags.Items.ALL_TEST_APPLE_LOG)
                .add(TestAppleWoodBlocks.TEST_APPLE_LOG.asItem())
                .add(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG.asItem())
                .add(TestAppleWoodBlocks.TEST_APPLE_WOOD.asItem())
                .add(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD.asItem());


        // --- Stairs ---
        valueLookupBuilder(ItemTags.WOODEN_STAIRS)
                .add(TestAppleWoodVariants.TEST_APPLE_STAIRS.asItem());
        // --- Slab ---
        valueLookupBuilder(ItemTags.WOODEN_SLABS)
                .add(TestAppleWoodVariants.TEST_APPLE_SLAB.asItem());
        // --- Fence ---
        valueLookupBuilder(ItemTags.WOODEN_FENCES)
                .add(TestAppleWoodVariants.TEST_APPLE_FENCE.asItem());
        // --- Fence Gate ---
        valueLookupBuilder(ItemTags.FENCE_GATES)
                .add(TestAppleWoodVariants.TEST_APPLE_FENCE_GATE.asItem());
        // --- Door ---
        valueLookupBuilder(ItemTags.WOODEN_DOORS)
                .add(TestAppleWoodVariants.TEST_APPLE_DOOR.asItem());
        // --- Trapdoor ---
        valueLookupBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(TestAppleWoodVariants.TEST_APPLE_TRAPDOOR.asItem());
        // --- Button ---
        valueLookupBuilder(ItemTags.WOODEN_BUTTONS)
                .add(TestAppleWoodVariants.TEST_APPLE_BUTTON.asItem());
        // --- Pressure Plate ---
        valueLookupBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(TestAppleWoodVariants.TEST_APPLE_PRESSURE_PLATE.asItem());
        // --- Shelves ---
        valueLookupBuilder(ItemTags.WOODEN_SHELVES)
                .add(TestAppleWoodVariants.TEST_APPLE_SHELF.asItem());
    }
}
