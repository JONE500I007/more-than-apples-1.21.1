package net.more.apples.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.more.apples.item.ModItems;

public class ModLootTableModifiers2 {
    private static final Identifier JUNGLE_TEMPLE_ID =
            Identifier.of("minecraft", "chests/jungle_temple");
    private static final Identifier CREEPER_ID =
            Identifier.of("minecraft", "entities/creeper");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (key == LootTables.JUNGLE_TEMPLE_CHEST) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build()));
            }

            if (key.equals(CREEPER_ID)) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // 50% drop
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build()));
            }
        });
    }
}
