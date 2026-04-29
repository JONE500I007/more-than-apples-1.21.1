package net.more.apples.entity;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BoatItem;
import net.more.apples.MoreThanApples;

public class ModBoats {
    public static final Identifier APPLE_BOAT_ID = Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple");
    public static BoatItem APPLE_BOAT_ITEM;
    public static BoatItem APPLE_CHEST_BOAT_ITEM;

//    public static void registerBoats() {
//        APPLE_BOAT_ITEM = TerraformBoatItemHelper.registerBoatItem(APPLE_BOAT_ID, false);
//        APPLE_CHEST_BOAT_ITEM = TerraformBoatItemHelper.registerBoatItem(APPLE_BOAT_ID, true);
//    }

    public static final Identifier TEST_APPLE_BOAT_ID = Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple");
    public static BoatItem TEST_APPLE_BOAT_ITEM;
    public static BoatItem TEST_APPLE_CHEST_BOAT_ITEM;

    public static final Identifier FROSTY_APPLE_BOAT_ID = Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple");
    public static BoatItem FROSTY_APPLE_BOAT_ITEM;
    public static BoatItem FROSTY_APPLE_CHEST_BOAT_ITEM;
}
