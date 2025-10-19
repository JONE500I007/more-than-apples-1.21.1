package net.more.apples.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.more.apples.effect.ModEffects;

public class ModFoodComponents {
    // 1s = 20 tick
    public static final FoodComponent GREEN_APPLE_EFFECT = new FoodComponent.Builder().nutrition(4).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 2840, 0), 1)
            .build();
    public static final FoodComponent TEST_APPLE_EFFECT = new FoodComponent.Builder().nutrition(4).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1), 1)
            .statusEffect(new StatusEffectInstance(ModEffects.CALL_OF_APPLE, 5680, 0), 1)
            .build();


    public static final FoodComponent DIAMOND_APPLE_EFFECT = new FoodComponent.Builder().nutrition(4).saturationModifier(1.2f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 4800, 2), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1)
            .build();

    public static final FoodComponent ENCHANTED_DIAMOND_APPLE_EFFECT = new FoodComponent.Builder().nutrition(4).saturationModifier(1.2f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 6000, 7), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1200, 1), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 12000, 0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 12000, 0), 1)
            .statusEffect(new StatusEffectInstance(ModEffects.FREEZING_RESISTANCE, 12000, 0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 6000, 0), 1)
            .build();

    public static final FoodComponent DIAMOND_CARROT_EFFECT = new FoodComponent.Builder().nutrition(6).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 40, 0), 1)
            .build();

    public static final FoodComponent NETHERITE_APPLE_EFFECT = new FoodComponent.Builder().nutrition(4).saturationModifier(1.2f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 9600, 4), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 800, 2), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 9600, 1), 1)
            .statusEffect(new StatusEffectInstance(ModEffects.FREEZING_RESISTANCE, 12000, 0), 1)
            .statusEffect(new StatusEffectInstance(ModEffects.MINING_FATIGUE_IMMUNE, 12000, 0), 1)
            .build();

    public static final FoodComponent ENCHANTED_NETHERITE_APPLE_EFFECT = new FoodComponent.Builder().nutrition(4).saturationModifier(1.2f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 12000, 10), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 4800, 2), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 30000, 0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 30000, 0), 1)
            .statusEffect(new StatusEffectInstance(ModEffects.FREEZING_RESISTANCE, 30000, 0), 1)
            .statusEffect(new StatusEffectInstance(ModEffects.SLOWNESS_IMMUNE, 30000, 0), 1)
            .statusEffect(new StatusEffectInstance(ModEffects.MINING_FATIGUE_IMMUNE, 30000, 0), 1)
            .statusEffect(new StatusEffectInstance(ModEffects.DARKNESS_IMMUNE, 30000, 0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 12000, 3), 1)
            .build();


    //14.4 = 6 * saturationModifier * 2
    //14.4 = 12 * saturationModifier
    //saturationModifier = 14.4 / 12
    //saturationModifier = 1.2f
}
