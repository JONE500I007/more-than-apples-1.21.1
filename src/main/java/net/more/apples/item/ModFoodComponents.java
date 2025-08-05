package net.more.apples.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    // 1s = 20 tick
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
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 6000, 0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 6000, 0), 1)
            .build();

    public static final FoodComponent DIAMOND_CARROT_EFFECT = new FoodComponent.Builder().nutrition(6).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 40, 0), 1)
            .build();
    //14.4 = 6 * saturationModifier * 2
    //14.4 = 12 * saturationModifier
    //saturationModifier = 14.4 / 12
    //saturationModifier = 1.2f
}
