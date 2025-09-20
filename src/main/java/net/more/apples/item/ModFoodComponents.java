package net.more.apples.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.more.apples.effect.ModEffects;

import java.util.List;

public class ModFoodComponents {
    // 1s = 20 tick
    public static final FoodComponent DIAMOND_APPLE_FOOD = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(1.2f)
            .alwaysEdible().build();
    public static final ConsumableComponent DIAMOND_APPLE_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.ABSORPTION, 4800, 2), 1))
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1))
            .build();

    public static final FoodComponent ENCHANTED_DIAMOND_APPLE_FOOD = new FoodComponent.Builder().
            nutrition(4)
            .saturationModifier(1.2f)
            .alwaysEdible()
            .build();
    public static final ConsumableComponent ENCHANTED_DIAMOND_APPLE_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 6000, 7), 1))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1200, 1), 1))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 12000, 0), 1))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 12000, 0), 1))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModEffects.FREEZING_RESISTANCE, 12000, 0), 1))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 6000, 0), 1))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.LUCK, 6000, 0), 1))
            .build();

    /*
    public static final ConsumableComponent ENCHANTED_DIAMOND_APPLE_EFFECT2 = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    List.of(new StatusEffectInstance(StatusEffects.ABSORPTION, 4800, 2),
                            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 4800, 2)), 1))
            .build();
     */

    public static final FoodComponent DIAMOND_CARROT_FOOD = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(1.2f)
            .build();
    public static final ConsumableComponent DIAMOND_CARROT_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    List.of(
                            new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 1),
                            new StatusEffectInstance(StatusEffects.SATURATION, 40, 0)),
                    1))
            .build();

    public static final FoodComponent NETHERITE_APPLE_FOOD = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(1.2f)
            .alwaysEdible()
            .build();
    public static final ConsumableComponent NETHERITE_APPLE_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    List.of(
                            new StatusEffectInstance(StatusEffects.ABSORPTION, 9600, 4),
                            new StatusEffectInstance(StatusEffects.REGENERATION, 800, 2),
                            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 9600, 1),
                            new StatusEffectInstance(ModEffects.FREEZING_RESISTANCE, 12000, 0),
                            new StatusEffectInstance(ModEffects.MINING_FATIGUE_IMMUNE, 12000, 0)),
                    1))
            .build();

    public static final FoodComponent ENCHANTED_NETHERITE_APPLE_FOOD = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(1.2f)
            .alwaysEdible()
            .build();
    public static final ConsumableComponent ENCHANTED_NETHERITE_APPLE_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    List.of(
                            new StatusEffectInstance(StatusEffects.ABSORPTION, 12000, 10),
                            new StatusEffectInstance(StatusEffects.REGENERATION, 4800, 2),
                            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 30000, 1),
                            new StatusEffectInstance(StatusEffects.RESISTANCE, 30000, 1),
                            new StatusEffectInstance(ModEffects.FREEZING_RESISTANCE, 30000, 0),
                            new StatusEffectInstance(ModEffects.SLOWNESS_IMMUNE, 30000, 0),
                            new StatusEffectInstance(ModEffects.MINING_FATIGUE_IMMUNE, 30000, 0),
                            new StatusEffectInstance(ModEffects.DARKNESS_IMMUNE, 30000, 0),
                            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 12000, 3),
                            new StatusEffectInstance(StatusEffects.LUCK, 12000, 0)),
                    1))
            .build();


    //14.4 = 6 * saturationModifier * 2
    //14.4 = 12 * saturationModifier
    //saturationModifier = 14.4 / 12
    //saturationModifier = 1.2f
}
