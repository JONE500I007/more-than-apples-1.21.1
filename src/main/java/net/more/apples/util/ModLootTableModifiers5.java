package net.more.apples.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.more.apples.item.ModItems;

public class ModLootTableModifiers5 {
    private static final RegistryKey<LootTable> SIMPLE_DUNGEON_CHEST_KEY =
            LootTables.SIMPLE_DUNGEON_CHEST;

    private static final RegistryKey<LootTable> ABANDONED_MINESHAFT_CHEST_KEY =
            LootTables.ABANDONED_MINESHAFT_CHEST;

    private static final RegistryKey<LootTable> ANCIENT_CITY_CHEST_KEY =
            LootTables.ANCIENT_CITY_CHEST;

    private static final RegistryKey<LootTable> BASTION_TREASURE_CHEST_KEY =
            LootTables.BASTION_TREASURE_CHEST;

    private static final RegistryKey<LootTable> DESERT_PYRAMID_CHEST_KEY =
            LootTables.DESERT_PYRAMID_CHEST;

    private static final RegistryKey<LootTable> RUINED_PORTAL_CHEST_KEY =
            LootTables.RUINED_PORTAL_CHEST;

    private static final RegistryKey<LootTable> TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE_CHEST_KEY =
            LootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE_CHEST;

    private static final RegistryKey<LootTable> WOODLAND_MANSION_CHEST_KEY =
            LootTables.WOODLAND_MANSION_CHEST;

    public static void modifyLootTables3() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (SIMPLE_DUNGEON_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.028f))
                        .with(ItemEntry.builder(ModItems.ENCHANTED_DIAMOND_APPLE)));
            }

            if (ABANDONED_MINESHAFT_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.014f))
                        .with(ItemEntry.builder(ModItems.ENCHANTED_DIAMOND_APPLE)));
            }

            if (ANCIENT_CITY_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.084f))
                        .with(ItemEntry.builder(ModItems.ENCHANTED_DIAMOND_APPLE)))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)));
            }

            if (BASTION_TREASURE_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                                .rolls(ConstantLootNumberProvider.create(1))
                                .conditionally(RandomChanceLootCondition.builder(0.059f))
                                .with(ItemEntry.builder(ModItems.ENCHANTED_DIAMOND_APPLE)));
            }

            if (DESERT_PYRAMID_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.024f))
                        .with(ItemEntry.builder(ModItems.ENCHANTED_DIAMOND_APPLE)));
            }

            if (RUINED_PORTAL_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.015f))
                        .with(ItemEntry.builder(ModItems.ENCHANTED_DIAMOND_APPLE)));
            }

            if (TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.225f))
                        .with(ItemEntry.builder(ModItems.ENCHANTED_DIAMOND_APPLE)));
            }

            if (WOODLAND_MANSION_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.031f))
                        .with(ItemEntry.builder(ModItems.ENCHANTED_DIAMOND_APPLE)));
            }
        });
    }
}
