package net.more.apples.datagen.model.apple;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.item.apple_wood_item.AppleWoodItem;

public class AppleModelItems extends FabricModelProvider {
    public AppleModelItems(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(AppleWoodBlocks.APPLE_SAPLING.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AppleWoodBlocks.GOLDEN_APPLE_SAPLING.asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(AppleWoodItem.APPLE_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AppleWoodItem.APPLE_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AppleWoodItem.APPLE_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
    }
}