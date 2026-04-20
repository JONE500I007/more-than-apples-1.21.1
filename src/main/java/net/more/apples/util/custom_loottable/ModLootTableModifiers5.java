package net.more.apples.util.custom_loottable;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.more.apples.item.ModItems;

public class ModLootTableModifiers5 {
    private static final ResourceKey<LootTable> SIMPLE_DUNGEON_CHEST_KEY =
            BuiltInLootTables.SIMPLE_DUNGEON;

    private static final ResourceKey<LootTable> ABANDONED_MINESHAFT_CHEST_KEY =
            BuiltInLootTables.ABANDONED_MINESHAFT;

    private static final ResourceKey<LootTable> ANCIENT_CITY_CHEST_KEY =
            BuiltInLootTables.ANCIENT_CITY;

    private static final ResourceKey<LootTable> BASTION_TREASURE_CHEST_KEY =
            BuiltInLootTables.BASTION_TREASURE;

    private static final ResourceKey<LootTable> DESERT_PYRAMID_CHEST_KEY =
            BuiltInLootTables.DESERT_PYRAMID;

    private static final ResourceKey<LootTable> RUINED_PORTAL_CHEST_KEY =
            BuiltInLootTables.RUINED_PORTAL;

    private static final ResourceKey<LootTable> TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE_CHEST_KEY =
            BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE;

    private static final ResourceKey<LootTable> WOODLAND_MANSION_CHEST_KEY =
            BuiltInLootTables.WOODLAND_MANSION;

    public static void modifyLootTables3() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (SIMPLE_DUNGEON_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.028f))
                        .add(LootItem.lootTableItem(ModItems.ENCHANTED_DIAMOND_APPLE)));
            }

            if (ABANDONED_MINESHAFT_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.014f))
                        .add(LootItem.lootTableItem(ModItems.ENCHANTED_DIAMOND_APPLE)));
            }

            if (ANCIENT_CITY_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.084f))
                        .add(LootItem.lootTableItem(ModItems.ENCHANTED_DIAMOND_APPLE)))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)));
            }

            if (BASTION_TREASURE_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                                .setRolls(ConstantValue.exactly(1))
                                .when(LootItemRandomChanceCondition.randomChance(0.059f))
                                .add(LootItem.lootTableItem(ModItems.ENCHANTED_DIAMOND_APPLE)));
            }

            if (DESERT_PYRAMID_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.024f))
                        .add(LootItem.lootTableItem(ModItems.ENCHANTED_DIAMOND_APPLE)));
            }

            if (RUINED_PORTAL_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.015f))
                        .add(LootItem.lootTableItem(ModItems.ENCHANTED_DIAMOND_APPLE)));
            }

            if (TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.225f))
                        .add(LootItem.lootTableItem(ModItems.ENCHANTED_DIAMOND_APPLE)));
            }

            if (WOODLAND_MANSION_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.031f))
                        .add(LootItem.lootTableItem(ModItems.ENCHANTED_DIAMOND_APPLE)));
            }
        });
    }
}
