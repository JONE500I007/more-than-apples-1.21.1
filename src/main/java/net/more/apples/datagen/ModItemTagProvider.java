package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.more.apples.block.ModBlocks2;
import net.more.apples.item.ModItems;
import net.more.apples.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
//        getOrCreateTagBuilder(ModTags.Items.HORSE_TEMPT_ITEMS)
//                .add(ModItems.DIAMOND_CARROT);

        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks2.APPLE_LOG.asItem())
                .add(ModBlocks2.APPLE_WOOD.asItem())
                .add(ModBlocks2.STRIPPED_APPLE_LOG.asItem())
                .add(ModBlocks2.STRIPPED_APPLE_WOOD.asItem())

                .add(ModBlocks2.TEST_APPLE_LOG.asItem())
                .add(ModBlocks2.TEST_APPLE_WOOD.asItem())
                .add(ModBlocks2.STRIPPED_TEST_APPLE_LOG.asItem())
                .add(ModBlocks2.STRIPPED_TEST_APPLE_WOOD.asItem())

                .add(ModBlocks2.FROSTY_APPLE_LOG.asItem())
                .add(ModBlocks2.FROSTY_APPLE_WOOD.asItem())
                .add(ModBlocks2.STRIPPED_FROSTY_APPLE_LOG.asItem())
                .add(ModBlocks2.STRIPPED_FROSTY_APPLE_WOOD.asItem());

        valueLookupBuilder(ItemTags.PLANKS)
                .add(ModBlocks2.APPLE_PLANKS.asItem())
                .add(ModBlocks2.TEST_APPLE_PLANKS.asItem())
                .add(ModBlocks2.FROSTY_APPLE_PLANKS.asItem());


        valueLookupBuilder(ModTags.Items.ALL_APPLE)
                .add(Items.APPLE)
                .add(Items.GOLDEN_APPLE)
                .add(Items.ENCHANTED_GOLDEN_APPLE)
                .add(ModItems.GREEN_APPLE)
                .add(ModItems.TEST_APPLE)
                .add(ModItems.DIAMOND_APPLE)
                .add(ModItems.ENCHANTED_DIAMOND_APPLE)
                .add(ModItems.NETHERITE_APPLE)
                .add(ModItems.ENCHANTED_NETHERITE_APPLE);

        valueLookupBuilder(ModTags.Items.ALL_APPLE_LOG)
                .add(ModBlocks2.APPLE_LOG.asItem())
                .add(ModBlocks2.STRIPPED_APPLE_LOG.asItem())
                .add(ModBlocks2.APPLE_WOOD.asItem())
                .add(ModBlocks2.STRIPPED_APPLE_WOOD.asItem());
        valueLookupBuilder(ModTags.Items.ALL_TEST_APPLE_LOG)
                .add(ModBlocks2.TEST_APPLE_LOG.asItem())
                .add(ModBlocks2.STRIPPED_TEST_APPLE_LOG.asItem())
                .add(ModBlocks2.TEST_APPLE_WOOD.asItem())
                .add(ModBlocks2.STRIPPED_TEST_APPLE_WOOD.asItem());
        valueLookupBuilder(ModTags.Items.ALL_FROSTY_APPLE_LOG)
                .add(ModBlocks2.FROSTY_APPLE_LOG.asItem())
                .add(ModBlocks2.STRIPPED_FROSTY_APPLE_LOG.asItem())
                .add(ModBlocks2.FROSTY_APPLE_WOOD.asItem())
                .add(ModBlocks2.STRIPPED_FROSTY_APPLE_WOOD.asItem());


        // --- Stairs ---
        valueLookupBuilder(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks2.APPLE_STAIRS.asItem())
                .add(ModBlocks2.TEST_APPLE_STAIRS.asItem())
                .add(ModBlocks2.FROSTY_APPLE_STAIRS.asItem());
        // --- Slabs ---
        valueLookupBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBlocks2.APPLE_SLAB.asItem())
                .add(ModBlocks2.TEST_APPLE_SLAB.asItem())
                .add(ModBlocks2.FROSTY_APPLE_STAIRS.asItem());
        // --- Fence ---
        valueLookupBuilder(ItemTags.WOODEN_FENCES)
                .add(ModBlocks2.APPLE_FENCE.asItem())
                .add(ModBlocks2.TEST_APPLE_FENCE.asItem())
                .add(ModBlocks2.FROSTY_APPLE_STAIRS.asItem());
        // --- Fence Gate ---
        valueLookupBuilder(ItemTags.FENCE_GATES)
                .add(ModBlocks2.APPLE_FENCE_GATE.asItem())
                .add(ModBlocks2.TEST_APPLE_FENCE_GATE.asItem())
                .add(ModBlocks2.FROSTY_APPLE_STAIRS.asItem());
        // --- Door ---
        valueLookupBuilder(ItemTags.WOODEN_DOORS)
                .add(ModBlocks2.APPLE_DOOR.asItem())
                .add(ModBlocks2.TEST_APPLE_DOOR.asItem())
                .add(ModBlocks2.FROSTY_APPLE_STAIRS.asItem());
        // --- Trapdoor ---
        valueLookupBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks2.APPLE_TRAPDOOR.asItem())
                .add(ModBlocks2.TEST_APPLE_TRAPDOOR.asItem())
                .add(ModBlocks2.FROSTY_APPLE_STAIRS.asItem());
        // --- Button ---
        valueLookupBuilder(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks2.APPLE_BUTTON.asItem())
                .add(ModBlocks2.TEST_APPLE_BUTTON.asItem())
                .add(ModBlocks2.FROSTY_APPLE_STAIRS.asItem());
        // --- Pressure Plate ---
        valueLookupBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks2.APPLE_PRESSURE_PLATE.asItem())
                .add(ModBlocks2.TEST_APPLE_PRESSURE_PLATE.asItem())
                .add(ModBlocks2.FROSTY_APPLE_STAIRS.asItem());
    }
}
