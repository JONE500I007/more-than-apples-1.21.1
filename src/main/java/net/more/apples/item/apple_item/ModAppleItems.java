package net.more.apples.item.apple_item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.more.apples.MoreThanApples;

public class ModAppleItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name), item);
    }

    public static void registerModItem(){
        MoreThanApples.LOGGER.info("Registering Mod Apple Items for " + MoreThanApples.MOD_ID);
    }
}
