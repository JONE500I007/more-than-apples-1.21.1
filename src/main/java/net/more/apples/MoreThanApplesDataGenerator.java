package net.more.apples;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.more.apples.datagen.ModPoiTagProvider;
import net.more.apples.datagen.ModRegistryDataGenerator;
import net.more.apples.datagen.provider.ModBlockTagProvider;
import net.more.apples.datagen.provider.ModItemTagProvider;
import net.more.apples.datagen.provider.ModLootBlockDrop;
import net.more.apples.datagen.provider.ModRecipeProvider;
import net.more.apples.datagen.tag.ModBiomeTagProvider;
import net.more.apples.world.biome.biomes_regions.apple_biome.AppleGroveBiome;
import net.more.apples.world.biome.biomes_regions.frosty_apple_biome.FrostyAppleBiome;
import net.more.apples.world.biome.biomes_regions.golden_apple_orchard_biome.GoldenAppleOrchardBiome;
import net.more.apples.world.config_feature.AppleOreConfig;
import net.more.apples.world.config_feature.AppleTreeConfig;
import net.more.apples.world.config_feature.FrostyTreeConfig;
import net.more.apples.world.config_feature.GoldenDandeltioConfig;
import net.more.apples.world.placed_feature.ApplePlacedFeature;

public class MoreThanApplesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);

		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModLootBlockDrop::new);

		//pack.addProvider(ModModelProvider::new);

		pack.addProvider(ModRegistryDataGenerator::new);

		pack.addProvider(ModPoiTagProvider::new);

		pack.addProvider((output, registriesFuture) -> new ModBiomeTagProvider(output, registriesFuture));
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, AppleOreConfig::bootstrap);
		registryBuilder.add(Registries.CONFIGURED_FEATURE, AppleTreeConfig::bootstrap);
		registryBuilder.add(Registries.CONFIGURED_FEATURE, FrostyTreeConfig::bootstrap);
		registryBuilder.add(Registries.CONFIGURED_FEATURE, GoldenDandeltioConfig::bootstrap);

		registryBuilder.add(Registries.PLACED_FEATURE, ApplePlacedFeature::boostrap);

		registryBuilder.add(Registries.BIOME, AppleGroveBiome::boostrap);
		registryBuilder.add(Registries.BIOME, GoldenAppleOrchardBiome::boostrap);
		registryBuilder.add(Registries.BIOME, FrostyAppleBiome::boostrap);
	}
}
