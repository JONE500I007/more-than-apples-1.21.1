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

public class ModLootTableModifiers_DiaApple {
    private static final RegistryKey<LootTable> SIMPLE_DUNGEON_CHEST_KEY =
            LootTables.SIMPLE_DUNGEON_CHEST;



    public static void modifyLootTables2() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (SIMPLE_DUNGEON_CHEST_KEY.equals(key)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.549f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_CARROT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f))));
            }
        });
    }
}
