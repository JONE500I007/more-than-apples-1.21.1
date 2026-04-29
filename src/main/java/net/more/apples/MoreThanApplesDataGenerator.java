package net.more.apples;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.more.apples.datagen.ModPoiTagProvider;
import net.more.apples.datagen.ModRegistryDataGenerator;
import net.more.apples.datagen.model.GeneralBlockAndItem;
import net.more.apples.world.config_feature.GoldenDandeltioConfig;

public class MoreThanApplesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(GeneralBlockAndItem::new);

		pack.addProvider(ModRegistryDataGenerator::new);

		pack.addProvider(ModPoiTagProvider::new);

		pack.addProvider((output, registriesFuture) -> new ModBiomeTagProvider(output, registriesFuture));

	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, GoldenDandeltioConfig::bootstrap);
//		registryBuilder.add(Registries.PLACED_FEATURE, ModPlacedFeatures::boostrap);
//
//		registryBuilder.add(Registries.BIOME, ModBiomesAppleGrove::boostrap);
//		registryBuilder.add(Registries.BIOME, ModBiomesGoldenAppleOrchard::boostrap);
//		registryBuilder.add(Registries.BIOME, ModBiomeFrostyApple::boostrap);
	}
}
