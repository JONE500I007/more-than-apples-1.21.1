package net.more.apples.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.more.apples.MoreThanApples;
import net.more.apples.item.general_item.ModGeneralItems;

import static net.more.apples.item.apple_item.ModAppleFoodItems.*;
import static net.more.apples.item.general_item.ModGeneralItems.*;

public class CreativeModeItemTabs {
    public static void registerModItemTab(){
        MoreThanApples.LOGGER.info("Registering Creative Mode Item inventory for " + MoreThanApples.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                .register(entrise -> {
                    entrise.accept(GREEN_APPLE);
                    entrise.accept(TEST_APPLE);

                    entrise.accept(DIAMOND_APPLE);
                    entrise.accept(ENCHANTED_DIAMOND_APPLE);
                    entrise.accept(DIAMOND_CARROT);

                    entrise.accept(NETHERITE_APPLE);
                    entrise.accept(ENCHANTED_NETHERITE_APPLE);
                });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register(entrise -> {
                    entrise.accept(DIAMOND_NUGGET);
                });
    }
}
