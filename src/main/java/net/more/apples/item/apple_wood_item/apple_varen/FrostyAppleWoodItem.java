package net.more.apples.item.apple_wood_item.apple_varen;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.more.apples.MoreThanApples;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;

import java.util.function.Function;

import static net.more.apples.entity.ModBoats.FROSTY_APPLE_BOAT_ID;

public class FrostyAppleWoodItem {
    public static final Item FROSTY_APPLE_SIGN = registerSignItem("frosty_apple_sign",
            new SignItem(
                    FrostyAppleWoodVariants.FROSTY_APPLE_STANDING_SIGN,
                    FrostyAppleWoodVariants.FROSTY_APPLE_WALL_SIGN,
                    new Item.Properties().stacksTo(16)));
    public static final Item FROSTY_APPLE_HANGING_SIGN = registerSignItem("frosty_apple_hanging_sign",
            new HangingSignItem(
                    FrostyAppleWoodVariants.FROSTY_APPLE_HANGING_SIGN_BLOCK,
                    FrostyAppleWoodVariants.FROSTY_APPLE_WALL_HANGING_SIGN,
                    new Item.Properties().stacksTo(16)));
    public static final Item FROSTY_APPLE_BOAT =
            TerraformBoatItemHelper.registerBoatItem(FROSTY_APPLE_BOAT_ID, false);
    public static final Item FROSTY_APPLE_CHEST_BOAT =
            TerraformBoatItemHelper.registerBoatItem(FROSTY_APPLE_BOAT_ID, true);


    private static Item registerSignItem(String name, Item item) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name),
                item);
    }
    private static Item registerItem(String name, Function<Item.Properties, Item> factory, Item.Properties settings) {
        Item item = factory.apply(settings.setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.ITEM, ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name)), item);
    }

    private static Item registerItemV2(String name, Function<Item.Properties, Item> factory) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name),
                factory.apply(new Item.Properties()));
    }

    public static void registerWoodItem() {
        MoreThanApples.LOGGER.info("Registering Mod Items for " + MoreThanApples.MOD_ID);
    }
}
