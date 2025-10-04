package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
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
                .add(ModBlocks2.STRIPPED_APPLE_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks2.APPLE_PLANKS.asItem());
    }
}
