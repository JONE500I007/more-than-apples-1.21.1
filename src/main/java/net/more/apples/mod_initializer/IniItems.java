package net.more.apples.mod_initializer;

import net.fabricmc.api.ModInitializer;
import net.more.apples.item.general_item.ModGeneralItems;

public class IniItems implements ModInitializer {
    @Override
    public void onInitialize() {
        //ModAppleFoodItems.registerModForItem();
        ModGeneralItems.registerModForItem();

        //AppleWoodItem.registerWoodItem();
        //TestAppleWoodItem.registerWoodItem();
        //FrostyAppleWoodItem.registerWoodItem();
    }
}
