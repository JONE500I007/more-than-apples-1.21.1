package net.more.apples.util;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.more.apples.MoreThanApples;


import static net.more.apples.MoreThanApples.MOD_ID;

public class ModLootConditions {
    public static final MapCodec<AnglerHasEffectCondition> ANGLER_HAS_EFFECT = register(
            "angler_has_effect",
            AnglerHasEffectCondition.CODEC
    );

    private static <T extends LootItemCondition> MapCodec<T> register(String name, MapCodec<T> codec) {
        return Registry.register(BuiltInRegistries.LOOT_CONDITION_TYPE, Identifier.fromNamespaceAndPath(MOD_ID, name), codec);
    }

    public static void init() {
        MoreThanApples.LOGGER.info("Registering Loot Conditions...");
    }
}
