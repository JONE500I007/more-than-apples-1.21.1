package net.more.apples.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.more.apples.MoreThanApples;
import net.more.apples.block.ModBlocksForText;
import net.more.apples.item.custom.CustomEnchApple;

public class ModItems {
    public static final Item GREEN_APPLE = registerItem("green_apple", new Item(new Item.Settings()
            .food(ModFoodComponents.GREEN_APPLE_EFFECT)));
    public static final Item TEST_APPLE = registerItem("test_apple", new Item(new Item.Settings()
            .food(ModFoodComponents.TEST_APPLE_EFFECT)));

    public static final Item DIAMOND_APPLE = registerItem("diamond_apple", new Item(new Item.Settings()
            .food(ModFoodComponents.DIAMOND_APPLE_EFFECT)
            .rarity(Rarity.RARE)));
    public static final Item ENCHANTED_DIAMOND_APPLE = registerItem("enchanted_diamond_apple", new CustomEnchApple(new Item.Settings()
            .food(ModFoodComponents.ENCHANTED_DIAMOND_APPLE_EFFECT)
            .rarity(Rarity.EPIC)));
    public static final Item DIAMOND_CARROT = registerItem("diamond_carrot", new Item(new Item.Settings()
            .food(ModFoodComponents.DIAMOND_CARROT_EFFECT)));

    public static final Item NETHERITE_APPLE = registerItem("netherite_apple", new Item(new Item.Settings()
            .food(ModFoodComponents.NETHERITE_APPLE_EFFECT)
            .rarity(Rarity.RARE)));
    public static final Item ENCHANTED_NETHERITE_APPLE = registerItem("enchanted_netherite_apple", new CustomEnchApple(new Item.Settings()
            .food(ModFoodComponents.ENCHANTED_NETHERITE_APPLE_EFFECT)
            .rarity(Rarity.EPIC)));

//    public static final Item CUSTOM_SIGN_ITEM = registerItem("custom_sign_item",
//            new SignItem(new Item.Settings().maxCount(16), CUSTOM_SIGN, CUSTOM_WALL_SIGN));

    public static final Item DIAMOND_NUGGET = registerItem("diamond_nugget", new Item(new Item.Settings()));

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
    }
}
