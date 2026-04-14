package net.more.apples.potion;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.more.apples.MoreThanApples;
import net.more.apples.effect.ModEffects;

public class ModPotions {
    public static final Holder<Potion> DARKNESS_IMMUNE_POTION = registerPotion1("darkness_immune_potion",
            new Potion("darkness_immune_potion", new MobEffectInstance(ModEffects.DARKNESS_IMMUNE, 3600, 0)));
    public static final Holder<Potion> DARKNESS_IMMUNE_POTION_L = registerPotion1("darkness_immune_potion_l",
            new Potion("darkness_immune_potion_l", new MobEffectInstance(ModEffects.DARKNESS_IMMUNE, 9600, 0)));

    public static final Holder<Potion> SLOWNESS_IMMUNE_POTION = registerPotion1("slowness_immune_potion",
            new Potion("slowness_immune_potion", new MobEffectInstance(ModEffects.SLOWNESS_IMMUNE, 3600, 0)));
    public static final Holder<Potion> SLOWNESS_IMMUNE_POTION_L = registerPotion1("slowness_immune_potion_l",
            new Potion("slowness_immune_potion_l", new MobEffectInstance(ModEffects.SLOWNESS_IMMUNE, 9600, 0)));

    public static final Holder<Potion> MINING_FATIGUE_IMMUNE_POTION = registerPotion1("mining_fatigue_immune_potion",
            new Potion("mining_fatigue_immune_potion", new MobEffectInstance(ModEffects.MINING_FATIGUE_IMMUNE, 3600, 0)));
    public static final Holder<Potion> MINING_FATIGUE_IMMUNE_POTION_L = registerPotion1("mining_fatigue_immune_potion_l",
            new Potion("mining_fatigue_immune_potion_l", new MobEffectInstance(ModEffects.MINING_FATIGUE_IMMUNE, 9600, 0)));

    public static final Holder<Potion> FREEZING_RESISTANCE_POTION = registerPotion1("freezing_resistance_potion",
            new Potion("freezing_resistance_potion", new MobEffectInstance(ModEffects.FREEZING_RESISTANCE, 3600, 0)));
    public static final Holder<Potion> FREEZING_RESISTANCE_POTION_L = registerPotion1("freezing_resistance_potion_l",
            new Potion("freezing_resistance_potion_l", new MobEffectInstance(ModEffects.FREEZING_RESISTANCE, 9600, 0)));

    public static final Holder<Potion> NIGHT_VISION_POTION_V1 = registerPotion1("night_vision_potion_v1",
            new Potion("night_vision_potion_v1", new MobEffectInstance(MobEffects.NIGHT_VISION, 30000, 0)));

    public static final Holder<Potion> CALL_OF_APPLE_POTION = registerPotion1("call_of_apple_potion",
            new Potion("call_of_apple_potion", new MobEffectInstance(ModEffects.CALL_OF_APPLE, 3600, 0)));
    public static final Holder<Potion> CALL_OF_APPLE_POTION_L = registerPotion1("call_of_apple_potion_l",
            new Potion("call_of_apple_potion_l", new MobEffectInstance(ModEffects.CALL_OF_APPLE, 9600, 0)));

    public static Holder<Potion> registerPotion1(String name, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name), potion);
    }

    public static void registerPotions(){
        MoreThanApples.LOGGER.info("Registering Mod Potions for " + MoreThanApples.MOD_ID);
    }
}
