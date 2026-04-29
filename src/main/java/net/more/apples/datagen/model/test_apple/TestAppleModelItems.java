package net.more.apples.datagen.model.test_apple;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.item.apple_wood_item.TestAppleWoodItem;

public class TestAppleModelItems extends FabricModelProvider {
    public TestAppleModelItems(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(TestAppleWoodBlocks.TEST_APPLE_SAPLING.asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(TestAppleWoodItem.TEST_APPLE_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(TestAppleWoodItem.TEST_APPLE_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(TestAppleWoodItem.TEST_APPLE_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
    }
}