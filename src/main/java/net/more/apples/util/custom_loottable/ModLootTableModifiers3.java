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

public class ModLootTableModifiers3 {
    private static final ResourceKey<LootTable> SIMPLE_DUNGEON_CHEST_KEY =
            BuiltInLootTables.SIMPLE_DUNGEON;
    private static final ResourceKey<LootTable> ABANDONED_MINESHAFT_CHEST_KEY =
            BuiltInLootTables.ABANDONED_MINESHAFT;

    private static final ResourceKey<LootTable> BASTION_OTHER_CHEST_KEY =
            BuiltInLootTables.BASTION_OTHER;
    private static final ResourceKey<LootTable> BASTION_HOGLIN_STABLE_CHEST_KEY =
            BuiltInLootTables.BASTION_HOGLIN_STABLE;

    private static final ResourceKey<LootTable> DESERT_PYRAMID_CHEST_KEY =
            BuiltInLootTables.DESERT_PYRAMID;

//    private static final RegistryKey<LootTable> IGLOO_CHEST_CHEST_KEY =
//            LootTables.IGLOO_CHEST_CHEST;

    private static final ResourceKey<LootTable> RUINED_PORTAL_CHEST_KEY =
            BuiltInLootTables.RUINED_PORTAL;

    private static final ResourceKey<LootTable> STRONGHOLD_CORRIDOR_CHEST_KEY =
            BuiltInLootTables.STRONGHOLD_CORRIDOR;

    private static final ResourceKey<LootTable> TRIAL_CHAMBERS_REWARD_OMINOUS_RARE_CHEST_KEY =
            BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_RARE;

    private static final ResourceKey<LootTable> TRIAL_CHAMBERS_REWARD_UNIQUE_CHEST_KEY =
            BuiltInLootTables.TRIAL_CHAMBERS_REWARD_UNIQUE;

    private static final ResourceKey<LootTable> UNDERWATER_RUIN_BIG_CHEST_KEY =
            BuiltInLootTables.UNDERWATER_RUIN_BIG;

    private static final ResourceKey<LootTable> WOODLAND_MANSION_CHEST_KEY =
            BuiltInLootTables.WOODLAND_MANSION;



    public static void modifyLootTables2() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (SIMPLE_DUNGEON_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.19f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_APPLE)));
            }
            if (ABANDONED_MINESHAFT_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.282f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_APPLE)));
            }

            if (BASTION_OTHER_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.101f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_APPLE)));
            }
            if (BASTION_HOGLIN_STABLE_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.10f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_APPLE)));
            }

            if (DESERT_PYRAMID_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.222f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_APPLE)));
            }
            /*
            if (IGLOO_CHEST_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(1f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_APPLE)));
            }
             */

            if (RUINED_PORTAL_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.205f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_APPLE)));
            }

            if (STRONGHOLD_CORRIDOR_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.025f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_APPLE)));
            }

            if (TRIAL_CHAMBERS_REWARD_OMINOUS_RARE_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.083f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_APPLE)));
            }
            if (TRIAL_CHAMBERS_REWARD_UNIQUE_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.083f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_APPLE)));
            }

            if (UNDERWATER_RUIN_BIG_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.043f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_APPLE)));
            }

            if (WOODLAND_MANSION_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.218f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_APPLE)));
            }
        });
    }
}
