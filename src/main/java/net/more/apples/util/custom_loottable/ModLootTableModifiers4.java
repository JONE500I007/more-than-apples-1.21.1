package net.more.apples.util.custom_loottable;

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

public class ModLootTableModifiers4 {
//    private static final Identifier JUNGLE_TEMPLE_ID =
//            Identifier.of("minecraft", "chests/jungle_temple");
//    private static final Identifier CREEPER_ID =
//            Identifier.of("minecraft", "entities/creeper");
    private static final RegistryKey<LootTable> ANCIENT_CITY_ICE_BOX_CHEST_KEY =
            LootTables.ANCIENT_CITY_ICE_BOX_CHEST;

    private static final RegistryKey<LootTable> BASTION_HOGLIN_STABLE_CHEST_KEY =
            LootTables.BASTION_HOGLIN_STABLE_CHEST;
    private static final RegistryKey<LootTable> BASTION_OTHER_CHEST_KEY =
            LootTables.BASTION_OTHER_CHEST;

    private static final RegistryKey<LootTable> RUINED_PORTAL_CHEST_KEY =
            LootTables.RUINED_PORTAL_CHEST;

    private static final RegistryKey<LootTable> TRIAL_CHAMBERS_REWARD_OMINOUS_RARE_CHEST_KEY =
            LootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_RARE_CHEST;
    private static final RegistryKey<LootTable> TRIAL_CHAMBERS_REWARD_RARE_CHEST_KEY =
            LootTables.TRIAL_CHAMBERS_REWARD_RARE_CHEST;



    public static void modifyLootTables1() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (ANCIENT_CITY_ICE_BOX_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.549f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_CARROT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f))));
            }

            if (BASTION_HOGLIN_STABLE_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.10f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_CARROT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 17.0f))));
            }
            if (BASTION_OTHER_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.135f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_CARROT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(6.0f, 17.0f))));
            }

            if (RUINED_PORTAL_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.073f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_CARROT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 12.0f))));
            }

            if (TRIAL_CHAMBERS_REWARD_OMINOUS_RARE_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.14f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_CARROT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f))));
            }
            if (TRIAL_CHAMBERS_REWARD_RARE_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.07f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_CARROT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f))));
            }

            /*
            if (CREEPER_LOOT_TABLE_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build()));
            }
            if (LootTables.ANCIENT_CITY_CHEST.equals(key.getValue())) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(7.0f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build()));
            }
             */
        });
    }
}
