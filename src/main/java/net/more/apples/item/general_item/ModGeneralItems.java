package net.more.apples.item.general_item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.more.apples.MoreThanApples;

public class ModGeneralItems {

    public static final Item DIAMOND_NUGGET = registerItem("diamond_nugget", new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "diamond_nugget")))));



    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name), item);
    }

    public static void registerModForItem(){
        MoreThanApples.LOGGER.info("Registering Mod General Items for " + MoreThanApples.MOD_ID);
    }
}
