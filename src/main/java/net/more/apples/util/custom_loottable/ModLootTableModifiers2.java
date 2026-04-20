package net.more.apples.util.custom_loottable;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.more.apples.item.ModItems;

public class ModLootTableModifiers2 {
    private static final Identifier JUNGLE_TEMPLE_ID =
            Identifier.fromNamespaceAndPath("minecraft", "chests/jungle_temple");
    private static final Identifier CREEPER_ID =
            Identifier.fromNamespaceAndPath("minecraft", "entities/creeper");

    private static final ResourceKey<LootTable> CREEPER_LOOT_TABLE_KEY =
            ResourceKey.create(
                    Registries.LOOT_TABLE,
                    Identifier.fromNamespaceAndPath("minecraft", "entities/creeper"));

//    private static final ResourceKey<LootTable> CREEPER_LOOT_TABLE_KEY =
//            BuiltInLootTables.CHARGED_CREEPER;
    private static final ResourceKey<LootTable> FISHING_LOOT_KEY =
            BuiltInLootTables.FISHING_TREASURE;
    private static final ResourceKey<LootTable> JUNGLE_TEMPLE_LOOT_KEY =
            BuiltInLootTables.JUNGLE_TEMPLE;

    private static final ResourceKey<LootTable> ANCIENT_CITY_KEY =
            BuiltInLootTables.ANCIENT_CITY;

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (key.equals(BuiltInLootTables.JUNGLE_TEMPLE)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(1f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_APPLE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
                        )
                );
            }

            if (key.equals(CREEPER_LOOT_TABLE_KEY)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(1.0f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_APPLE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)))
                        )
                );
            }
        });
    }
}
