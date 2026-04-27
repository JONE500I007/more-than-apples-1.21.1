package net.more.apples.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.more.apples.MoreThanApples;
import net.more.apples.item.general_item.ModGeneralItems;

public class CreativeModeItemInv {
    public static void registerModInvItem(){
        MoreThanApples.LOGGER.info("Registering Creative Mode Item inventory for " + MoreThanApples.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register(entrise -> {
                    entrise.accept(ModGeneralItems.DIAMOND_NUGGET);
                });
    }
}
