package net.more.apples.entity;


import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BoatItem;
import net.more.apples.MoreThanApples;
import net.more.apples.block.ModBlocks2;
import net.more.apples.item.ModItems;

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

//    public static void registerBoats2() {
//        TEST_APPLE_BOAT_ITEM = TerraformBoatItemHelper.registerBoatItem(TEST_APPLE_BOAT_ID, false);
//        TEST_APPLE_CHEST_BOAT_ITEM = TerraformBoatItemHelper.registerBoatItem(TEST_APPLE_BOAT_ID, true);
//    }

    public static final Identifier FROSTY_APPLE_BOAT_ID = Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple");
    public static BoatItem FROSTY_APPLE_BOAT_ITEM;
    public static BoatItem FROSTY_APPLE_CHEST_BOAT_ITEM;

//    public static void registerBoats3() {
//        FROSTY_APPLE_BOAT_ITEM = TerraformBoatItemHelper.registerBoatItem(FROSTY_APPLE_BOAT_ID, false);
//        FROSTY_APPLE_CHEST_BOAT_ITEM = TerraformBoatItemHelper.registerBoatItem(FROSTY_APPLE_BOAT_ID, true);
//    }
    /*
    public static final Identifier TEST_APPLE_BOAT_ID = Identifier.of(MoreThanApples.MOD_ID, "test_apple_boat");
    public static final Identifier TEST_APPLE_CHEST_BOAT_ID = Identifier.of(MoreThanApples.MOD_ID, "test_apple_chest_boat");
    public static final RegistryKey<TerraformBoatType> TEST_APPLE_BOAT_KEY = TerraformBoatTypeRegistry.createKey(TEST_APPLE_BOAT_ID);

    public static void registerBoats2() {
        TerraformBoatType appleBoat = new TerraformBoatType.Builder()
                .item(ModItems.TEST_APPLE_BOAT)
                .chestItem(ModItems.TEST_APPLE_CHEST_BOAT)
                .planks(ModBlocks2.TEST_APPLE_PLANKS.asItem())
                .build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, TEST_APPLE_BOAT_KEY, appleBoat);
    }
     */
}
