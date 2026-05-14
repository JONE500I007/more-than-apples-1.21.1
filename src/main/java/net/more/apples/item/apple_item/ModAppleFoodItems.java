package net.more.apples.item.apple_item;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.more.apples.MoreThanApples;
import net.more.apples.effect.food_consumable.ModFoodConEffects;
import net.more.apples.effect.food_consumable.ModFoodProperties;
import net.more.apples.item.custom.CustomEnchApple;

import java.util.function.Function;

public class ModAppleFoodItems {

    public static final Item GREEN_APPLE = registerItem("green_apple",
            Item::new, new Item.Properties()
                    .food(ModFoodProperties.GREEN_APPLE_FOOD)
                    .component(DataComponents.CONSUMABLE, ModFoodConEffects.GREEN_APPLE_EFFECT));

    public static final Item TEST_APPLE = registerItem("test_apple",
            Item::new, new Item.Properties()
                    .food(ModFoodProperties.TEST_APPLE_FOOD)
                    .component(DataComponents.CONSUMABLE, ModFoodConEffects.TEST_APPLE_EFFECT));

    public static final Item FROSTY_APPLE = registerItem("frosty_apple",
            Item::new, new Item.Properties()
                    .food(ModFoodProperties.FROSTY_APPLE_FOOD)
                    .component(DataComponents.CONSUMABLE, ModFoodConEffects.FROSTY_APPLE_EFFECT));

    public static final Item DIAMOND_APPLE = registerItem("diamond_apple",
            Item::new, new Item.Properties()
                    .food(ModFoodProperties.DIAMOND_APPLE_FOOD)
                    .component(DataComponents.CONSUMABLE, ModFoodConEffects.DIAMOND_APPLE_EFFECT)
                    .rarity(Rarity.RARE));
    public static final Item ENCHANTED_DIAMOND_APPLE = registerItem("enchanted_diamond_apple",
            CustomEnchApple::new, new Item.Properties()
                    .food(ModFoodProperties.ENCHANTED_DIAMOND_APPLE_FOOD)
                    .component(DataComponents.CONSUMABLE, ModFoodConEffects.ENCHANTED_DIAMOND_APPLE_EFFECT)
                    .rarity(Rarity.EPIC));
    public static final Item DIAMOND_CARROT = registerItem("diamond_carrot",
            Item::new, new Item.Properties()
                    .food(ModFoodProperties.DIAMOND_CARROT_FOOD)
                    .component(DataComponents.CONSUMABLE, ModFoodConEffects.DIAMOND_CARROT_EFFECT));

    public static final Item NETHERITE_APPLE = registerItem("netherite_apple",
            Item::new, new Item.Properties()
                    .food(ModFoodProperties.NETHERITE_APPLE_FOOD)
                    .component(DataComponents.CONSUMABLE, ModFoodConEffects.NETHERITE_APPLE_EFFECT)
                    .rarity(Rarity.RARE)
                    .fireResistant());
    public static final Item ENCHANTED_NETHERITE_APPLE = registerItem("enchanted_netherite_apple",
            CustomEnchApple::new, new Item.Properties()
                    .food(ModFoodProperties.ENCHANTED_NETHERITE_APPLE_FOOD)
                    .component(DataComponents.CONSUMABLE, ModFoodConEffects.ENCHANTED_NETHERITE_APPLE_EFFECT)
                    .rarity(Rarity.EPIC)
                    .fireResistant());

    private static Item registerItem(String name, Function<Item.Properties, Item> factory, Item.Properties settings) {
        Item item = factory.apply(settings.setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.ITEM, ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name)), item);
    }

    public static void registerModForItem() {
        MoreThanApples.LOGGER.info("Registering Mod Items for " + MoreThanApples.MOD_ID);
    }
}
