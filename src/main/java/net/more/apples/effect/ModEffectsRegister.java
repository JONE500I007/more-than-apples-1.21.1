package net.more.apples.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.more.apples.MoreThanApples;
import net.more.apples.effect.this_effects.*;

public class ModEffectsRegister {
    public static final Holder<MobEffect> DARKNESS_IMMUNE = registerStatusEffect("darkness_immune",
            new DarknessImmuneEffect(MobEffectCategory.BENEFICIAL, 0xF5C827));
    public static final Holder<MobEffect> SLOWNESS_IMMUNE = registerStatusEffect("slowness_immune",
            new SlownessImmuneEffect(MobEffectCategory.BENEFICIAL, 0x647570));
    public static final Holder<MobEffect> MINING_FATIGUE_IMMUNE = registerStatusEffect("mining_fatigue_immune",
            new MiningFatigueImmuneEffect(MobEffectCategory.BENEFICIAL, 0x91B399));
    public static final Holder<MobEffect> FREEZING = registerStatusEffect("freezing",
            new FreezingEffect(MobEffectCategory.HARMFUL, 0xA3EAFF));
    public static final Holder<MobEffect> FREEZING_RESISTANCE = registerStatusEffect("freezing_resistance",
            new FreezingResistanceEffect(MobEffectCategory.BENEFICIAL, 0x3246E6));
    public static final Holder<MobEffect> CALL_OF_APPLE = registerStatusEffect("call_of_apple",
            new CallofAppleEffect(MobEffectCategory.BENEFICIAL, 0x24FF00));

    private static Holder<MobEffect> registerStatusEffect(String name, MobEffect statusEffect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        MoreThanApples.LOGGER.info("Registering Mod Effects for +" + MoreThanApples.MOD_ID);
    }
}
