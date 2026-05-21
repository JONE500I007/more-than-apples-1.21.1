package net.more.apples.item.apple_wood_item;

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
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodVariants;

import java.util.function.Function;

import static net.more.apples.entity.ModBoats.ANCIENT_APPLE_BOAT_ID;
import static net.more.apples.entity.ModBoats.TEST_APPLE_BOAT_ID;

public class AncientAppleWoodItem {
    public static final Item ANCIENT_APPLE_SIGN = registerItem("ancient_apple_sign",
            properties -> new SignItem(
                    AncientAppleWoodVariants.ANCIENT_APPLE_STANDING_SIGN,
                    AncientAppleWoodVariants.ANCIENT_APPLE_WALL_SIGN,
                    properties.stacksTo(16)),
            new Item.Properties());
    public static final Item ANCIENT_APPLE_HANGING_SIGN = registerItem("ancient_apple_hanging_sign",
            properties -> new HangingSignItem(
                    AncientAppleWoodVariants.ANCIENT_APPLE_HANGING_SIGN_BLOCK,
                    AncientAppleWoodVariants.ANCIENT_APPLE_WALL_HANGING_SIGN,
                    properties.stacksTo(16)),
            new Item.Properties());
    public static final Item ANCIENT_APPLE_BOAT =
            TerraformBoatItemHelper.registerBoatItem(ANCIENT_APPLE_BOAT_ID, false);
    public static final Item ANCIENT_APPLE_CHEST_BOAT =
            TerraformBoatItemHelper.registerBoatItem(ANCIENT_APPLE_BOAT_ID, true);


    private static Item registerItem(String name, Function<Item.Properties, Item> factory, Item.Properties settings) {
        Item item = factory.apply(settings.setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.ITEM, ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name)), item);
    }

    public static void registerWoodItem() {
        MoreThanApples.LOGGER.info("Registering Mod Items for " + MoreThanApples.MOD_ID);
    }
}
