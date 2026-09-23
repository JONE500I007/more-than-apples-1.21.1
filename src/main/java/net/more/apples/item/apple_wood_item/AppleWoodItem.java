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
import net.more.apples.entity.ModBoats;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;

import java.util.function.Function;

import static net.more.apples.entity.ModBoats.APPLE_BOAT_ID;

public class AppleWoodItem {
    public static final Item APPLE_SIGN = registerItem("apple_sign",
            properties -> new StandingAndWallBlockItem(
                    AppleWoodVariants.APPLE_STANDING_SIGN,
                    AppleWoodVariants.APPLE_WALL_SIGN,
                    Direction.DOWN,
                    properties.stacksTo(16).signText()),
            new Item.Properties());
    public static final Item APPLE_HANGING_SIGN = registerItem("apple_hanging_sign",
            properties -> new HangingSignItem(
                    AppleWoodVariants.APPLE_HANGING_SIGN_BLOCK,
                    AppleWoodVariants.APPLE_WALL_HANGING_SIGN,
                    properties.stacksTo(16).signText()),
            new Item.Properties());
    public static final Item APPLE_BOAT =
            ModBoats.registerBoatItem(APPLE_BOAT_ID, false);
    public static final Item APPLE_CHEST_BOAT =
            ModBoats.registerBoatItem(APPLE_BOAT_ID, true);


    private static Item registerItem(String name, Function<Item.Properties, Item> factory, Item.Properties settings) {
        Item item = factory.apply(settings.setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.ITEM, ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name)), item);
    }

    public static void registerWoodItem() {
        MoreThanApples.LOGGER.info("Registering Mod Items for " + MoreThanApples.MOD_ID);
    }
}
