package net.more.apples.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.more.apples.MoreThanApples;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> DARKNESS_IMMUNE = registerStatusEffect("darkness_immune",
            new DarknessImmuneEffect(StatusEffectCategory.NEUTRAL, 0xF5C827));
    public static final RegistryEntry<StatusEffect> FREEZING_RESISTANCE = registerStatusEffect("freezing_resistance",
            new FreezingResistanceEffect(StatusEffectCategory.NEUTRAL, 0xA3EAFF));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MoreThanApples.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        MoreThanApples.LOGGER.info("Registering Mod Effects for +" + MoreThanApples.MOD_ID);
    }
}
