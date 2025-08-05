package net.more.apples.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.more.apples.item.ModItems;

import static com.ibm.icu.number.NumberRangeFormatter.with;

public class ModLootTableModifiers {
    private static final Identifier JUNGLE_TEMPLE_ID =
            Identifier.of("minecraft", "chests/jungle_temple");
    private static final Identifier CREEPER_ID =
            Identifier.of("minecraft", "entities/creeper");

    public static void modifyLootTables() {
        /*
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (JUNGLE_TEMPLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.DIAMOND_APPLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
         */
        /*
        LootTableEvents.MODIFY.register((registryKey, builder, lootTableSource, wrapperLookup) -> {
            if (registryKey == LootTables.DESERT_PYRAMID_ARCHAEOLOGY) {
                // thing;
            }
        });
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (key == LootTables.DESERT_PYRAMID_ARCHAEOLOGY) {
                tableBuilder.modifyPools(poolBuilder -> poolBuilder
                        .with(ItemEntry.builder(Items.RESPAWN_ANCHOR)));
            }
        });

         */
    }
}
