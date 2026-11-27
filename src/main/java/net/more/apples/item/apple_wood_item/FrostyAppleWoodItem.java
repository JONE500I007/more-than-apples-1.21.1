package net.more.apples.item.apple_wood_item;

import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.more.apples.MoreThanApples;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;

import java.util.function.Function;


public class FrostyAppleWoodItem {
    // Made by JONE500 Wooden API (see FrostyAppleWoodVariants.FROSTY_APPLE_WOOD_SET); same item ids as before.
    public static final Item FROSTY_APPLE_SIGN = FrostyAppleWoodVariants.FROSTY_APPLE_WOOD_SET.getSignItem();
    public static final Item FROSTY_APPLE_HANGING_SIGN = FrostyAppleWoodVariants.FROSTY_APPLE_WOOD_SET.getHangingSignItem();
    public static final Item FROSTY_APPLE_BOAT = FrostyAppleWoodVariants.FROSTY_APPLE_WOOD_SET.getBoatItem();
    public static final Item FROSTY_APPLE_CHEST_BOAT = FrostyAppleWoodVariants.FROSTY_APPLE_WOOD_SET.getChestBoatItem();


    private static Item registerItem(String name, Function<Item.Properties, Item> factory, Item.Properties settings) {
        Item item = factory.apply(settings.setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.ITEM, ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name)), item);
    }

    public static void registerWoodItem() {
        MoreThanApples.LOGGER.info("Registering Mod Items for " + MoreThanApples.MOD_ID);
    }
}
