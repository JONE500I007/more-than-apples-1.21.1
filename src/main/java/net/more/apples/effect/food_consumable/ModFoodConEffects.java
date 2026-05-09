package net.more.apples.effect.food_consumable;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.more.apples.effect.ModEffectsRegister;

import java.util.List;

public class ModFoodConEffects {
    // 1s = 20 tick
    public static final Consumable GREEN_APPLE_EFFECT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.LUCK, 2840, 0), 1))
            .build();

    public static final Consumable TEST_APPLE_EFFECT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(ModEffectsRegister.CALL_OF_APPLE, 5680, 0), 1))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1, 1), 1))
            .build();

    public static final Consumable FROSTY_APPLE_EFFECT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(ModEffectsRegister.FREEZING, 600, 0), 0.43f))
            .build();

    public static final Consumable DIAMOND_APPLE_EFFECT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.ABSORPTION, 4800, 2), 1))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1))
            .build();

    public static final Consumable ENCHANTED_DIAMOND_APPLE_EFFECT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.ABSORPTION, 6000, 7), 1))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 1200, 1), 1))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 12000, 0), 1))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.RESISTANCE, 12000, 0), 1))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(ModEffectsRegister.FREEZING_RESISTANCE, 12000, 0), 1))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000, 0), 1))
            .build();


    public static final Consumable DIAMOND_CARROT_EFFECT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    List.of(
                            new MobEffectInstance(MobEffects.ABSORPTION, 600, 1),
                            new MobEffectInstance(MobEffects.SATURATION, 40, 0)),
                    1))
            .build();


    public static final Consumable NETHERITE_APPLE_EFFECT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    List.of(
                            new MobEffectInstance(MobEffects.ABSORPTION, 9600, 4),
                            new MobEffectInstance(MobEffects.REGENERATION, 800, 2),
                            new MobEffectInstance(MobEffects.HEALTH_BOOST, 9600, 1),
                            new MobEffectInstance(ModEffectsRegister.FREEZING_RESISTANCE, 12000, 0),
                            new MobEffectInstance(ModEffectsRegister.MINING_FATIGUE_IMMUNE, 12000, 0)),
                    1))
            .build();


    public static final Consumable ENCHANTED_NETHERITE_APPLE_EFFECT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    List.of(
                            new MobEffectInstance(MobEffects.ABSORPTION, 12000, 10),
                            new MobEffectInstance(MobEffects.REGENERATION, 4800, 2),
                            new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 30000, 1),
                            new MobEffectInstance(MobEffects.RESISTANCE, 30000, 1),
                            new MobEffectInstance(ModEffectsRegister.FREEZING_RESISTANCE, 30000, 0),
                            new MobEffectInstance(ModEffectsRegister.SLOWNESS_IMMUNE, 30000, 0),
                            new MobEffectInstance(ModEffectsRegister.MINING_FATIGUE_IMMUNE, 30000, 0),
                            new MobEffectInstance(ModEffectsRegister.DARKNESS_IMMUNE, 30000, 0),
                            new MobEffectInstance(MobEffects.HEALTH_BOOST, 12000, 3)),
                    1))
            .build();



    //14.4 = 6 * saturationModifier * 2
    //14.4 = 12 * saturationModifier
    //saturationModifier = 14.4 / 12
    //saturationModifier = 1.2f
}
