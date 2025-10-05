package net.more.apples.util.custom_loottable;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.more.apples.item.ModItems;

public class ModLootTableModifiers3 {
    private static final RegistryKey<LootTable> SIMPLE_DUNGEON_CHEST_KEY =
            LootTables.SIMPLE_DUNGEON_CHEST;
    private static final RegistryKey<LootTable> ABANDONED_MINESHAFT_CHEST_KEY =
            LootTables.ABANDONED_MINESHAFT_CHEST;

    private static final RegistryKey<LootTable> BASTION_OTHER_CHEST_KEY =
            LootTables.BASTION_OTHER_CHEST;
    private static final RegistryKey<LootTable> BASTION_HOGLIN_STABLE_CHEST_KEY =
            LootTables.BASTION_HOGLIN_STABLE_CHEST;

    private static final RegistryKey<LootTable> DESERT_PYRAMID_CHEST_KEY =
            LootTables.DESERT_PYRAMID_CHEST;

//    private static final RegistryKey<LootTable> IGLOO_CHEST_CHEST_KEY =
//            LootTables.IGLOO_CHEST_CHEST;

    private static final RegistryKey<LootTable> RUINED_PORTAL_CHEST_KEY =
            LootTables.RUINED_PORTAL_CHEST;

    private static final RegistryKey<LootTable> STRONGHOLD_CORRIDOR_CHEST_KEY =
            LootTables.STRONGHOLD_CORRIDOR_CHEST;

    private static final RegistryKey<LootTable> TRIAL_CHAMBERS_REWARD_OMINOUS_RARE_CHEST_KEY =
            LootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_RARE_CHEST;

    private static final RegistryKey<LootTable> TRIAL_CHAMBERS_REWARD_UNIQUE_CHEST_KEY =
            LootTables.TRIAL_CHAMBERS_REWARD_UNIQUE_CHEST;

    private static final RegistryKey<LootTable> UNDERWATER_RUIN_BIG_CHEST_KEY =
            LootTables.UNDERWATER_RUIN_BIG_CHEST;

    private static final RegistryKey<LootTable> WOODLAND_MANSION_CHEST_KEY =
            LootTables.WOODLAND_MANSION_CHEST;



    public static void modifyLootTables2() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (SIMPLE_DUNGEON_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.19f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE)));
            }
            if (ABANDONED_MINESHAFT_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.282f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE)));
            }

            if (BASTION_OTHER_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.101f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE)));
            }
            if (BASTION_HOGLIN_STABLE_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.10f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE)));
            }

            if (DESERT_PYRAMID_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.222f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE)));
            }
            /*
            if (IGLOO_CHEST_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE)));
            }
             */

            if (RUINED_PORTAL_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.205f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE)));
            }

            if (STRONGHOLD_CORRIDOR_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.025f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE)));
            }

            if (TRIAL_CHAMBERS_REWARD_OMINOUS_RARE_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.083f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE)));
            }
            if (TRIAL_CHAMBERS_REWARD_UNIQUE_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.083f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE)));
            }

            if (UNDERWATER_RUIN_BIG_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.043f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE)));
            }

            if (WOODLAND_MANSION_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.218f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE)));
            }
        });
    }
}
