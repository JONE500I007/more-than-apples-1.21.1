package net.more.apples.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.context.ContextKeySet;
import net.minecraft.world.level.storage.loot.LootTable;
import net.more.apples.MoreThanApples;
import net.more.apples.datagen.loot_table.loot_chest.TowerLootTable;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModLootTableChest extends SimpleFabricLootTableSubProvider {
    public ModLootTableChest(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture, ContextKeySet contextParamSet) {
        super(output, registryLookupFuture, contextParamSet);
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        TowerLootTable.addLoot(output);
    }

    public static ResourceKey<LootTable> key(String name) {
        return ResourceKey.create(Registries.LOOT_TABLE,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "chests/" + name));
    }

    public static void addChestLoot(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output,
                                    ResourceKey<LootTable> key,
                                    LootTable.Builder builder) {
        output.accept(key, builder);
    }
}
