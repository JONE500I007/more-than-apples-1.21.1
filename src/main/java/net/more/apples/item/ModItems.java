package net.more.apples.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.more.apples.MoreThanApples;
import net.more.apples.block.ModBlocks2;
import net.more.apples.block.ModBlocksForText;
import net.more.apples.entity.ModBoats;
import net.more.apples.item.custom.CustomEnchApple;

import static net.more.apples.entity.ModBoats.*;

public class ModItems {
    public static final Item GREEN_APPLE = registerItem("green_apple", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, "green_apple")))
            .food(ModFoodComponents.GREEN_APPLE_FOOD ,ModFoodComponents.GREEN_APPLE_EFFECT)));
    public static final Item TEST_APPLE = registerItem("test_apple", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, "test_apple")))
            .food(ModFoodComponents.TEST_APPLE_FOOD ,ModFoodComponents.TEST_APPLE_EFFECT)));

    public static final Item DIAMOND_APPLE = registerItem("diamond_apple", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, "diamond_apple")))
            .food(ModFoodComponents.DIAMOND_APPLE_FOOD, ModFoodComponents.DIAMOND_APPLE_EFFECT)
            .rarity(Rarity.RARE)));
    public static final Item ENCHANTED_DIAMOND_APPLE = registerItem("enchanted_diamond_apple", new CustomEnchApple(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, "enchanted_diamond_apple")))
            .food(ModFoodComponents.ENCHANTED_DIAMOND_APPLE_FOOD ,ModFoodComponents.ENCHANTED_DIAMOND_APPLE_EFFECT)
            .rarity(Rarity.EPIC)));
    public static final Item DIAMOND_CARROT = registerItem("diamond_carrot", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, "diamond_carrot")))
            .food(ModFoodComponents.DIAMOND_CARROT_FOOD ,ModFoodComponents.DIAMOND_CARROT_EFFECT)));

    public static final Item NETHERITE_APPLE = registerItem("netherite_apple", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, "netherite_apple")))
            .food(ModFoodComponents.NETHERITE_APPLE_FOOD ,ModFoodComponents.NETHERITE_APPLE_EFFECT)
            .rarity(Rarity.RARE)));
    public static final Item ENCHANTED_NETHERITE_APPLE = registerItem("enchanted_netherite_apple", new CustomEnchApple(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, "enchanted_netherite_apple")))
            .food(ModFoodComponents.ENCHANTED_NETHERITE_APPLE_FOOD ,ModFoodComponents.ENCHANTED_NETHERITE_APPLE_EFFECT)
            .rarity(Rarity.EPIC)));

    public static final Item APPLE_SIGN = registerItem("apple_sign",
            new SignItem(ModBlocks2.APPLE_STANDING_SIGN, ModBlocks2.APPLE_WALL_SIGN,
                    new Item.Settings()
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, "apple_sign")))
                            .maxCount(16)));
    public static final Item APPLE_HANGING_SIGN = registerItem("apple_hanging_sign", new HangingSignItem(
            ModBlocks2.APPLE_HANGING_SIGN_BLOCK,
            ModBlocks2.APPLE_WALL_HANGING_SIGN,
            new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, "apple_hanging_sign")))
                    .maxCount(16)));


    public static final Item APPLE_BOAT =
            TerraformBoatItemHelper.registerBoatItem(APPLE_BOAT_ID, false);
    public static final Item APPLE_CHEST_BOAT =
            TerraformBoatItemHelper.registerBoatItem(APPLE_BOAT_ID, true);
//    public static final Item APPLE_BOAT = ModBoats.APPLE_BOAT_ITEM;
//    public static final Item APPLE_CHEST_BOAT = ModBoats.APPLE_CHEST_BOAT_ITEM;
//    public static final Item TEST_APPLE_BOAT =
//        TerraformBoatItemHelper.registerBoatItem(ModBoats.TEST_APPLE_BOAT_ID, ModBoats.TEST_APPLE_BOAT_KEY, false);
//    public static final Item TEST_APPLE_CHEST_BOAT =
//            TerraformBoatItemHelper.registerBoatItem(ModBoats.TEST_APPLE_CHEST_BOAT_ID, ModBoats.TEST_APPLE_BOAT_KEY, true);


    public static final Item TEST_APPLE_SIGN = registerItem("test_apple_sign",
            new SignItem(ModBlocks2.TEST_APPLE_STANDING_SIGN, ModBlocks2.TEST_APPLE_WALL_SIGN,
                    new Item.Settings()
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, "test_apple_sign")))
                            .maxCount(16)));
    public static final Item TEST_APPLE_HANGING_SIGN = registerItem("test_apple_hanging_sign", new HangingSignItem(
            ModBlocks2.TEST_APPLE_HANGING_SIGN_BLOCK,
            ModBlocks2.TEST_APPLE_WALL_HANGING_SIGN,
            new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, "test_apple_hanging_sign")))
                    .maxCount(16)));
    public static final Item TEST_APPLE_BOAT =
            TerraformBoatItemHelper.registerBoatItem(TEST_APPLE_BOAT_ID, false);
    public static final Item TEST_APPLE_CHEST_BOAT =
            TerraformBoatItemHelper.registerBoatItem(TEST_APPLE_BOAT_ID, true);

    public static final Item FROSTY_APPLE_SIGN = registerItem("frosty_apple_sign",
            new SignItem(ModBlocks2.FROSTY_APPLE_STANDING_SIGN, ModBlocks2.FROSTY_APPLE_WALL_SIGN,
                    new Item.Settings()
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_sign")))
                            .maxCount(16)));
    public static final Item FROSTY_APPLE_HANGING_SIGN = registerItem("frosty_apple_hanging_sign", new HangingSignItem(
            ModBlocks2.FROSTY_APPLE_HANGING_SIGN_BLOCK,
            ModBlocks2.FROSTY_APPLE_WALL_HANGING_SIGN,
            new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_hanging_sign")))
                    .maxCount(16)));
    public static final Item FROSTY_APPLE_BOAT =
            TerraformBoatItemHelper.registerBoatItem(FROSTY_APPLE_BOAT_ID, false);
    public static final Item FROSTY_APPLE_CHEST_BOAT =
            TerraformBoatItemHelper.registerBoatItem(FROSTY_APPLE_BOAT_ID, true);


//    public static final Item CUSTOM_SIGN_ITEM = registerItem("custom_sign_item",
//            new SignItem(new Item.Settings().maxCount(16), CUSTOM_SIGN, CUSTOM_WALL_SIGN));

    public static final Item DIAMOND_NUGGET = registerItem("diamond_nugget", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, "diamond_nugget")))));

//    public static final Item DARKNESS_IMMUNE_POTION = registerItem("darkness_immune_potion", new PotionItem(new Item.Settings()
//            .maxCount(1)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MoreThanApples.MOD_ID, name), item);
    }

    public static void registerModItem(){
        MoreThanApples.LOGGER.info("Registering Mod Items for " + MoreThanApples.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entrise -> {
            entrise.add(GREEN_APPLE);
            entrise.add(TEST_APPLE);
            entrise.add(DIAMOND_APPLE);
            entrise.add(ENCHANTED_DIAMOND_APPLE);
            entrise.add(DIAMOND_CARROT);

            entrise.add(NETHERITE_APPLE);
            entrise.add(ENCHANTED_NETHERITE_APPLE);

            /*
            ItemStack darknessPotion = new ItemStack(Items.POTION);
            darknessPotion.set(DataComponentTypes.POTION_CONTENTS,
                    new PotionContentsComponent(ModPotions.DARKNESS_IMMUNE_POTION));
            entrise.add(darknessPotion);
             */
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entrise -> {
            entrise.add(DIAMOND_NUGGET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entrise -> {
            entrise.add(APPLE_SIGN);
            entrise.add(APPLE_HANGING_SIGN);

            entrise.add(TEST_APPLE_SIGN);
            entrise.add(TEST_APPLE_HANGING_SIGN);

            entrise.add(FROSTY_APPLE_SIGN);
            entrise.add(FROSTY_APPLE_HANGING_SIGN);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entrise -> {
            entrise.add(APPLE_BOAT);
            entrise.add(APPLE_CHEST_BOAT);

            entrise.add(TEST_APPLE_BOAT);
            entrise.add(TEST_APPLE_CHEST_BOAT);

            entrise.add(FROSTY_APPLE_BOAT);
            entrise.add(FROSTY_APPLE_CHEST_BOAT);
        });
    }
}
