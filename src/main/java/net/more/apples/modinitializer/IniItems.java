package net.more.apples.modinitializer;

import net.fabricmc.api.ModInitializer;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import net.more.apples.item.apple_wood_item.apple_varen.AppleWoodItem;
import net.more.apples.item.general_item.ModGeneralItems;

public class IniItems implements ModInitializer {
    @Override
    public void onInitialize() {
        ModAppleFoodItems.registerModForItem();
        ModGeneralItems.registerModForItem();
        AppleWoodItem.registerWoodItem();
    }
}
