package net.more.apples.effect.food_consumable;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    // 1s = 20 tick
    public static final FoodProperties GREEN_APPLE_FOOD = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(1.2f)
            .alwaysEdible().build();

    public static final FoodProperties TEST_APPLE_FOOD = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(1.2f)
            .alwaysEdible().build();

    public static final FoodProperties FROSTY_APPLE_FOOD = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(1.2f)
            .alwaysEdible().build();

    public static final FoodProperties DIAMOND_APPLE_FOOD = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(1.2f)
            .alwaysEdible().build();

    public static final FoodProperties ENCHANTED_DIAMOND_APPLE_FOOD = new FoodProperties.Builder().
            nutrition(4)
            .saturationModifier(1.2f)
            .alwaysEdible()
            .build();

    public static final FoodProperties DIAMOND_CARROT_FOOD = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(1.2f)
            .build();

    public static final FoodProperties NETHERITE_APPLE_FOOD = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(1.2f)
            .alwaysEdible()
            .build();

    public static final FoodProperties ENCHANTED_NETHERITE_APPLE_FOOD = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(1.2f)
            .alwaysEdible()
            .build();

    //14.4 = 6 * saturationModifier * 2
    //14.4 = 12 * saturationModifier
    //saturationModifier = 14.4 / 12
    //saturationModifier = 1.2f
}
