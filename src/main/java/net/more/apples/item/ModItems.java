package net.more.apples.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.more.apples.MoreThanApples;
import net.more.apples.item.custom.CustomEnchApple;
import net.more.apples.potion.ModPotions;

public class ModItems {
    public static final Item DIAMOND_APPLE = registerItem("diamond_apple", new Item(new Item.Settings()
            .food(ModFoodComponents.DIAMOND_APPLE_EFFECT)
            .rarity(Rarity.RARE)));
    public static final Item ENCHANTED_DIAMOND_APPLE = registerItem("enchanted_diamond_apple", new CustomEnchApple(new Item.Settings()
            .food(ModFoodComponents.ENCHANTED_DIAMOND_APPLE_EFFECT)
            .rarity(Rarity.EPIC)));
    public static final Item DIAMOND_CARROT = registerItem("diamond_carrot", new Item(new Item.Settings()
            .food(ModFoodComponents.DIAMOND_CARROT_EFFECT)));

    public static final Item NETHERITE_APPLE = registerItem("netherite_apple", new Item(new Item.Settings()
            .food(ModFoodComponents.DIAMOND_APPLE_EFFECT)
            .rarity(Rarity.RARE)));
    public static final Item ENCHANTED_NETHERITE_APPLE = registerItem("enchanted_netherite_apple", new CustomEnchApple(new Item.Settings()
            .food(ModFoodComponents.ENCHANTED_DIAMOND_APPLE_EFFECT)
            .rarity(Rarity.EPIC)));


    public static final Item DIAMOND_NUGGET = registerItem("diamond_nugget", new Item(new Item.Settings()));

//    public static final Item DARKNESS_IMMUNE_POTION = registerItem("darkness_immune_potion", new PotionItem(new Item.Settings()
//            .maxCount(1)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MoreThanApples.MOD_ID, name), item);
    }

    public static void registerModItem(){
        MoreThanApples.LOGGER.info("Registering Mod Items for " + MoreThanApples.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entrise -> {
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
