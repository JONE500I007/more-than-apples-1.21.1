package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.more.apples.item.ModItems;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModLootTableGen extends SimpleFabricLootTableSubProvider {
//LootContextTypes
    public ModLootTableGen(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup, LootContextParamSets.FISHING);
    }

    public static final ResourceKey<LootTable> TEST_FISH = ResourceKey.create(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath("minecraft", "gameplay/fishing/fish"));

    /*
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
     */

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> exporter) {
        exporter.accept(TEST_FISH, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(ModItems.DIAMOND_CARROT).setWeight(10))
                        .add(LootItem.lootTableItem(Items.COD).setWeight(60))
                        .add(LootItem.lootTableItem(Items.SALMON).setWeight(25))
                        .add(LootItem.lootTableItem(Items.TROPICAL_FISH).setWeight(2))
                        .add(LootItem.lootTableItem(Items.PUFFERFISH).setWeight(13))
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