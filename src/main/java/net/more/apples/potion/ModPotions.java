package net.more.apples.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.effect.ModEffects;

public class ModPotions {
    public static final RegistryEntry<Potion> DARKNESS_IMMUNE_POTION = registerPotion1("darkness_immune_potion",
            new Potion(new StatusEffectInstance(ModEffects.DARKNESS_IMMUNE, 3600, 0)));
    public static final RegistryEntry<Potion> DARKNESS_IMMUNE_POTION_L = registerPotion1("darkness_immune_potion_l",
            new Potion(new StatusEffectInstance(ModEffects.DARKNESS_IMMUNE, 9600, 0)));
    public static final RegistryEntry<Potion> FREEZING_RESOSTANCE_POTION = registerPotion1("freezing_resistance_potion",
            new Potion(new StatusEffectInstance(ModEffects.FREEZING_RESISTANCE, 3600, 0)));
    public static final RegistryEntry<Potion> FREEZING_RESOSTANCE_POTION_l = registerPotion1("freezing_resistance_potion_l",
            new Potion(new StatusEffectInstance(ModEffects.FREEZING_RESISTANCE, 9600, 0)));
    public static final RegistryEntry<Potion> NIGHT_VISION_POTION_V1 = registerPotion1("night_vision_potion_v1",
            new Potion(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 30000, 0)));

    public static RegistryEntry<Potion> registerPotion1(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(MoreThanApples.MOD_ID, name), potion);
    }

    public static void registerPotions(){
        MoreThanApples.LOGGER.info("Registering Mod Potions for " + MoreThanApples.MOD_ID);
    }
}
