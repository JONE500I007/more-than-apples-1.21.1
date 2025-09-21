package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataWriter;

import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.LocationCheckLootCondition;
import net.minecraft.loot.condition.TimeCheckLootCondition;
import net.minecraft.loot.condition.WeatherCheckLootCondition;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.dimension.DimensionTypes;
import net.more.apples.item.ModItems;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModLootTableGen extends SimpleFabricLootTableProvider {

    public ModLootTableGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup, LootContextTypes.FISHING);
    }

    public static final RegistryKey<LootTable> TEST_FISH = RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("minecraft", "gameplay/fishing/fish"));

    @Override
    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> lootTableBiConsumer) {
        lootTableBiConsumer.accept(TEST_FISH, LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.DIAMOND_CARROT).weight(10))
                        .with(ItemEntry.builder(net.minecraft.item.Items.COD).weight(60))
                        .with(ItemEntry.builder(net.minecraft.item.Items.SALMON).weight(25))
                        .with(ItemEntry.builder(net.minecraft.item.Items.TROPICAL_FISH).weight(2))
                        .with(ItemEntry.builder(net.minecraft.item.Items.PUFFERFISH).weight(13))
                )
        );
    }
    /*
    @Override
    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> exporter) {
        exporter.accept(TEST_FISH, LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.DIAMOND_CARROT))
                        .conditionally(
                                TimeCheckLootCondition.create().build(12000L, 24000L),
                                WeatherCheckLootCondition.create().raining(true),
                                LocationCheckLootCondition.builder(
                                        LocationPredicate.Builder.create()
                                                .biome(BiomeKeys.COLD_OCEAN)
                                                .dimension(DimensionTypes.OVERWORLD)
                                )
                        )
                )
        );
    }
     */
}