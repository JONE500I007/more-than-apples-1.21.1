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

public class ModLootTableModifiers4 {
//    private static final Identifier JUNGLE_TEMPLE_ID =
//            Identifier.of("minecraft", "chests/jungle_temple");
//    private static final Identifier CREEPER_ID =
//            Identifier.of("minecraft", "entities/creeper");
    private static final ResourceKey<LootTable> ANCIENT_CITY_ICE_BOX_CHEST_KEY =
        BuiltInLootTables.ANCIENT_CITY_ICE_BOX;

    private static final ResourceKey<LootTable> BASTION_HOGLIN_STABLE_CHEST_KEY =
            BuiltInLootTables.BASTION_HOGLIN_STABLE;
    private static final ResourceKey<LootTable> BASTION_OTHER_CHEST_KEY =
            BuiltInLootTables.BASTION_OTHER;

    private static final ResourceKey<LootTable> RUINED_PORTAL_CHEST_KEY =
            BuiltInLootTables.RUINED_PORTAL;

    private static final ResourceKey<LootTable> TRIAL_CHAMBERS_REWARD_OMINOUS_RARE_CHEST_KEY =
            BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_RARE;
    private static final ResourceKey<LootTable> TRIAL_CHAMBERS_REWARD_RARE_CHEST_KEY =
            BuiltInLootTables.TRIAL_CHAMBERS_REWARD_RARE;



    public static void modifyLootTables1() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (ANCIENT_CITY_ICE_BOX_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.549f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_CARROT))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 5.0f))));
            }

            if (BASTION_HOGLIN_STABLE_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.10f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_CARROT))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(8.0f, 17.0f))));
            }
            if (BASTION_OTHER_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.135f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_CARROT))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(6.0f, 17.0f))));
            }

            if (RUINED_PORTAL_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.073f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_CARROT))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(4.0f, 12.0f))));
            }

            if (TRIAL_CHAMBERS_REWARD_OMINOUS_RARE_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.14f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_CARROT))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f))));
            }
            if (TRIAL_CHAMBERS_REWARD_RARE_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.07f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_CARROT))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f))));
            }

            /*
            if (CREEPER_LOOT_TABLE_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(1.0f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_APPLE))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)).build()));
            }
            if (LootTables.ANCIENT_CITY_CHEST.equals(key.getValue())) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(7.0f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_APPLE))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)).build()));
            }
             */
        });
    }
}
