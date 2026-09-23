package net.more.apples.entity;

import net.minecraft.core.Registry;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.more.apples.MoreThanApples;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

// Boats registered the same way vanilla does (EntityTypes/Items), replacing Terraform's boat API.
// IDs match what Terraform used ("<id>_boat" / "<id>_chest_boat") so existing worlds keep their boats.
public class ModBoats {
    private static final Map<Identifier, EntityType<Boat>> BOAT_TYPES = new HashMap<>();
    private static final Map<Identifier, EntityType<ChestBoat>> CHEST_BOAT_TYPES = new HashMap<>();

    public static final Identifier APPLE_BOAT_ID = Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple");
    public static BoatItem APPLE_BOAT_ITEM;
    public static BoatItem APPLE_CHEST_BOAT_ITEM;


    public static final Identifier TEST_APPLE_BOAT_ID = Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple");
    public static BoatItem TEST_APPLE_BOAT_ITEM;
    public static BoatItem TEST_APPLE_CHEST_BOAT_ITEM;


    public static final Identifier FROSTY_APPLE_BOAT_ID = Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple");
    public static BoatItem FROSTY_APPLE_BOAT_ITEM;
    public static BoatItem FROSTY_APPLE_CHEST_BOAT_ITEM;

    public static final Identifier ANCIENT_APPLE_BOAT_ID = Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "ancient_apple");
    public static BoatItem ANCIENT_APPLE_BOAT_ITEM;
    public static BoatItem ANCIENT_APPLE_CHEST_BOAT_ITEM;


//    public static void registerBoats() {
//        APPLE_BOAT_ITEM = TerraformBoatItemHelper.registerBoatItem(APPLE_BOAT_ID, false);
//        APPLE_CHEST_BOAT_ITEM = TerraformBoatItemHelper.registerBoatItem(APPLE_BOAT_ID, true);
//
//        TEST_APPLE_BOAT_ITEM = TerraformBoatItemHelper.registerBoatItem(TEST_APPLE_BOAT_ID, false);
//        TEST_APPLE_CHEST_BOAT_ITEM = TerraformBoatItemHelper.registerBoatItem(TEST_APPLE_BOAT_ID, true);
//
//        FROSTY_APPLE_BOAT_ITEM = TerraformBoatItemHelper.registerBoatItem(FROSTY_APPLE_BOAT_ID, false);
//        FROSTY_APPLE_CHEST_BOAT_ITEM = TerraformBoatItemHelper.registerBoatItem(FROSTY_APPLE_BOAT_ID, true);
//    }

    public static Item registerBoatItem(Identifier boatId, boolean chest) {
        Identifier name = boatId.withSuffix(chest ? "_chest_boat" : "_boat");
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, name);
        Supplier<Item> dropItem = () -> BuiltInRegistries.ITEM.getValue(itemKey);

        EntityType<? extends AbstractBoat> entityType;
        if (chest) {
            EntityType<ChestBoat> type = registerEntityType(name, (t, level) -> new ChestBoat(t, level, dropItem));
            CHEST_BOAT_TYPES.put(boatId, type);
            entityType = type;
        } else {
            EntityType<Boat> type = registerEntityType(name, (t, level) -> new Boat(t, level, dropItem));
            BOAT_TYPES.put(boatId, type);
            entityType = type;
        }

        Item item = Registry.register(BuiltInRegistries.ITEM, itemKey, new BoatItem(entityType,
                new Item.Properties().stacksTo(1).cookingFuel(ContextIntProviders.COOKING_TIME_BOATS).setId(itemKey)));
        DispenserBlock.registerBehavior(item, new BoatDispenseItemBehavior(entityType));
        return item;
    }

    public static EntityType<Boat> getBoatType(Identifier boatId) {
        return BOAT_TYPES.get(boatId);
    }

    public static EntityType<ChestBoat> getChestBoatType(Identifier boatId) {
        return CHEST_BOAT_TYPES.get(boatId);
    }

    // same size/tracking as vanilla boats (see EntityTypes.OAK_BOAT)
    private static <T extends AbstractBoat> EntityType<T> registerEntityType(Identifier name, EntityType.EntityFactory<T> factory) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, name);
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key,
                EntityType.Builder.of(factory, MobCategory.MISC)
                        .noLootTable()
                        .sized(1.375F, 0.5625F)
                        .eyeHeight(0.5625F)
                        .clientTrackingRange(10)
                        .build(key));
    }
}
