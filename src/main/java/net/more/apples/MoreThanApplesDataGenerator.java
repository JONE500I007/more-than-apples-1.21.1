package net.more.apples;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.more.apples.datagen.ModPoiTagProvider;
import net.more.apples.datagen.ModRegistryDataGenerator;
import net.more.apples.datagen.provider.*;
import net.more.apples.datagen.tag.ModBiomeTagProvider;
import net.more.apples.datagen.villager.ModVillagerTradeSets;
import net.more.apples.datagen.villager.ModVillagerTradeTagProvider;
import net.more.apples.datagen.villager.ModVillagerTrades;
import net.more.apples.structure.ModStructureSets;
import net.more.apples.structure.ModStructures;
import net.more.apples.world.biome.biomes_regions.ancient_apple.AncientAppleBiome;
import net.more.apples.world.biome.biomes_regions.apple_biome.AppleGroveBiome;
import net.more.apples.world.biome.biomes_regions.frosty_apple_biome.FrostyAppleBiome;
import net.more.apples.world.biome.biomes_regions.golden_apple_orchard_biome.GoldenAppleOrchardBiome;
import net.more.apples.world.biome.biomes_regions.scorched_apple.ScorchedAppleBiome;
import net.more.apples.world.config_feature.*;
import net.more.apples.world.placed_feature.AncientApplePlacedFeature;
import net.more.apples.world.placed_feature.ApplePlacedFeature;

public class MoreThanApplesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);

		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModLootBlockDrop::new);

		pack.addProvider(ModModelProvider::new);

		pack.addProvider(ModRegistryDataGenerator::new);

		pack.addProvider(ModPoiTagProvider::new);

		//pack.addProvider(ModStructurePoolProvider::new);

		pack.addProvider((output, registriesFuture) -> new ModLootTableChest(
				output, registriesFuture, LootContextParamSets.CHEST));

		pack.addProvider((output, registriesFuture) -> new ModBiomeTagProvider(output, registriesFuture));

		pack.addProvider((output, registriesFuture) -> new ModVillagerTradeTagProvider(output, registriesFuture));
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, AppleOreConfig::bootstrap);
		registryBuilder.add(Registries.CONFIGURED_FEATURE, AppleTreeConfig::bootstrap);
		registryBuilder.add(Registries.CONFIGURED_FEATURE, TestAppleTreeConfig::bootstrap);
		registryBuilder.add(Registries.CONFIGURED_FEATURE, FrostyTreeConfig::bootstrap);
		registryBuilder.add(Registries.CONFIGURED_FEATURE, GoldenDandeltioConfig::bootstrap);
		registryBuilder.add(Registries.CONFIGURED_FEATURE, AncientAppleTreeConfig::bootstrap);

		registryBuilder.add(Registries.PLACED_FEATURE, ApplePlacedFeature::boostrap);
		registryBuilder.add(Registries.PLACED_FEATURE, AncientApplePlacedFeature::boostrap);


		registryBuilder.add(Registries.BIOME, AppleGroveBiome::boostrap);
		registryBuilder.add(Registries.BIOME, GoldenAppleOrchardBiome::boostrap);
		registryBuilder.add(Registries.BIOME, FrostyAppleBiome::boostrap);
		registryBuilder.add(Registries.BIOME, AncientAppleBiome::boostrap);
		registryBuilder.add(Registries.BIOME, ScorchedAppleBiome::boostrap);


		registryBuilder.add(Registries.TEMPLATE_POOL, ModStructurePoolProvider::bootstrap);
		registryBuilder.add(Registries.STRUCTURE, ModStructures::bootstrap);
		registryBuilder.add(Registries.STRUCTURE_SET, ModStructureSets::bootstrap);

		registryBuilder.add(Registries.VILLAGER_TRADE, ModVillagerTrades::bootstrap);
		registryBuilder.add(Registries.TRADE_SET, ModVillagerTradeSets::bootstrap);
	}
}
