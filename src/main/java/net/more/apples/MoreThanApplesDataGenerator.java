package net.more.apples;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.more.apples.datagen.*;
import net.more.apples.world.ModConfiguredFeatures;
import net.more.apples.world.ModPlacedFeatures;
import net.more.apples.world.biome.worldbiomes.ModBiomeFrostyApple;
import net.more.apples.world.biome.worldbiomes.ModBiomesAppleGrove;
import net.more.apples.world.biome.worldbiomes.ModBiomesGoldenAppleOrchard;

public class MoreThanApplesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModRegistryDataGenerator::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);

		pack.addProvider(ModPoiTagProvider::new);
		//pack.addProvider(ModLootTableGen::new);

		pack.addProvider((output, registriesFuture) -> new ModBiomeTagProvider(output, registriesFuture));
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.addRegistry(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::boostrap);
		registryBuilder.addRegistry(Registries.PLACED_FEATURE, ModPlacedFeatures::boostrap);

		registryBuilder.addRegistry(Registries.BIOME, ModBiomesAppleGrove::boostrap);
		registryBuilder.addRegistry(Registries.BIOME, ModBiomesGoldenAppleOrchard::boostrap);
		registryBuilder.addRegistry(Registries.BIOME, ModBiomeFrostyApple::boostrap);
	}
}
