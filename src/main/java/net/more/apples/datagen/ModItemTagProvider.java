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

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks2.APPLE_LOG.asItem())
                .add(ModBlocks2.APPLE_WOOD.asItem())
                .add(ModBlocks2.STRIPPED_APPLE_LOG.asItem())
                .add(ModBlocks2.STRIPPED_APPLE_WOOD.asItem())

                .add(ModBlocks2.TEST_APPLE_LOG.asItem())
                .add(ModBlocks2.TEST_APPLE_WOOD.asItem())
                .add(ModBlocks2.STRIPPED_TEST_APPLE_LOG.asItem())
                .add(ModBlocks2.STRIPPED_TEST_APPLE_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks2.APPLE_PLANKS.asItem())
                .add(ModBlocks2.TEST_APPLE_PLANKS.asItem());


        getOrCreateTagBuilder(ModTags.Items.ALL_APPLE)
                .add(Items.APPLE)
                .add(ModItems.GREEN_APPLE)
                .add(ModItems.TEST_APPLE)
                .add(ModItems.DIAMOND_APPLE)
                .add(ModItems.ENCHANTED_DIAMOND_APPLE)
                .add(ModItems.NETHERITE_APPLE)
                .add(ModItems.ENCHANTED_NETHERITE_APPLE);

        getOrCreateTagBuilder(ModTags.Items.ALL_APPLE_LOG)
                .add(ModBlocks2.APPLE_LOG.asItem())
                .add(ModBlocks2.STRIPPED_APPLE_LOG.asItem())
                .add(ModBlocks2.APPLE_WOOD.asItem())
                .add(ModBlocks2.STRIPPED_APPLE_WOOD.asItem());
        getOrCreateTagBuilder(ModTags.Items.ALL_TEST_APPLE_LOG)
                .add(ModBlocks2.TEST_APPLE_LOG.asItem())
                .add(ModBlocks2.STRIPPED_TEST_APPLE_LOG.asItem())
                .add(ModBlocks2.TEST_APPLE_WOOD.asItem())
                .add(ModBlocks2.STRIPPED_TEST_APPLE_WOOD.asItem());


        // --- Stairs ---
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks2.APPLE_STAIRS.asItem())
                .add(ModBlocks2.TEST_APPLE_STAIRS.asItem());
        // --- Slabs ---
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBlocks2.APPLE_SLAB.asItem())
                .add(ModBlocks2.TEST_APPLE_SLAB.asItem());
        // --- Fence ---
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                .add(ModBlocks2.APPLE_FENCE.asItem())
                .add(ModBlocks2.TEST_APPLE_FENCE.asItem());
        // --- Fence Gate ---
        getOrCreateTagBuilder(ItemTags.FENCE_GATES)
                .add(ModBlocks2.APPLE_FENCE_GATE.asItem())
                .add(ModBlocks2.TEST_APPLE_FENCE_GATE.asItem());
        // --- Door ---
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                .add(ModBlocks2.APPLE_DOOR.asItem())
                .add(ModBlocks2.TEST_APPLE_DOOR.asItem());
        // --- Trapdoor ---
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks2.APPLE_TRAPDOOR.asItem())
                .add(ModBlocks2.TEST_APPLE_TRAPDOOR.asItem());
        // --- Button ---
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks2.APPLE_BUTTON.asItem())
                .add(ModBlocks2.TEST_APPLE_BUTTON.asItem());
        // --- Pressure Plate ---
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks2.APPLE_PRESSURE_PLATE.asItem())
                .add(ModBlocks2.TEST_APPLE_PRESSURE_PLATE.asItem());
    }
}
