package net.more.apples.item.general_item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.more.apples.MoreThanApples;
import net.more.apples.item.custom.AppleCodexItem;

import java.util.function.Function;

public class ModGeneralItems {

    public static final Item DIAMOND_NUGGET = registerItem("diamond_nugget",
            Item::new, new Item.Properties());

    public static final Item APPLE_CODEX = registerItem("apple_codex",
            AppleCodexItem::new, new Item.Properties()
                    .stacksTo(1));

    private static Item registerItem(String name, Function<Item.Properties, Item> factory, Item.Properties settings) {
        Item item = factory.apply(settings.setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.ITEM, ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name)), item);
    }

    public static void registerModForItem() {
        MoreThanApples.LOGGER.info("Registering Mod Items for " + MoreThanApples.MOD_ID);
    }
}
