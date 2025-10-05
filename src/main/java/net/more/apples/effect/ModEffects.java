package net.more.apples.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.effect.this_effect.*;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> DARKNESS_IMMUNE = registerStatusEffect("darkness_immune",
            new DarknessImmuneEffect(StatusEffectCategory.BENEFICIAL, 0xF5C827));
    public static final RegistryEntry<StatusEffect> SLOWNESS_IMMUNE = registerStatusEffect("slowness_immune",
            new SlownessImmuneEffect(StatusEffectCategory.BENEFICIAL, 0x647570));
    public static final RegistryEntry<StatusEffect> MINING_FATIGUE_IMMUNE = registerStatusEffect("mining_fatigue_immune",
            new MiningFatigueImmuneEffect(StatusEffectCategory.BENEFICIAL, 0x91B399));
    public static final RegistryEntry<StatusEffect> FREEZING_RESISTANCE = registerStatusEffect("freezing_resistance",
            new FreezingResistanceEffect(StatusEffectCategory.BENEFICIAL, 0xA3EAFF));
    public static final RegistryEntry<StatusEffect> CALL_OF_APPLE = registerStatusEffect("call_of_apple",
            new CallofAppleEffect(StatusEffectCategory.BENEFICIAL, 0x24FF00));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MoreThanApples.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        MoreThanApples.LOGGER.info("Registering Mod Effects for +" + MoreThanApples.MOD_ID);
    }
}
