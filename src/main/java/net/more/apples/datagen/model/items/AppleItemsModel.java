package net.more.apples.datagen.model.items;

import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.datagen.provider.ModModelProvider;
import net.more.apples.item.apple_item.ModAppleFoodItems;

public final class AppleItemsModel {
    private  AppleItemsModel() {
    }

    public static void addItemModels(ItemModelGenerators generators) {
        ModModelProvider.flatItem(generators,
                ModAppleFoodItems.GREEN_APPLE,
                ModelTemplates.FLAT_ITEM
        );
        ModModelProvider.flatItem(generators,
                ModAppleFoodItems.FROSTY_APPLE,
                ModelTemplates.FLAT_ITEM
        );
    }
}
