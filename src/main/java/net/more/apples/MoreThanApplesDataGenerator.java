package net.more.apples;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.more.apples.datagen.*;
import net.more.apples.datagen.villager_trade.famer.ModTradeFarmerDefinitionProvider;
import net.more.apples.datagen.villager_trade.famer.ModTradeFarmerSetProvider;
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

//		pack.addProvider(ModTradeFarmerDefinitionProvider::new);
//		pack.addProvider(ModTradeFarmerSetProvider::new);

		pack.addProvider((output, registriesFuture) -> new ModBiomeTagProvider(output, registriesFuture));
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.add(Registries.PLACED_FEATURE, ModPlacedFeatures::boostrap);

		registryBuilder.add(Registries.BIOME, ModBiomesAppleGrove::boostrap);
		registryBuilder.add(Registries.BIOME, ModBiomesGoldenAppleOrchard::boostrap);
		registryBuilder.add(Registries.BIOME, ModBiomeFrostyApple::boostrap);
	}
}
