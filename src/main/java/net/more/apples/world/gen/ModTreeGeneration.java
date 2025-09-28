package net.more.apples.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.more.apples.world.ModPlacedFeatures;
import net.more.apples.world.biome.ModBiomes;

public class ModTreeGeneration {
    public static void generaTrees(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.APPLE_GROVE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.APPLE_TREE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.APPLE_GROVE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_APPLE_TREE_PLACED_KEY);
        /*
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.APPLE_GROVE, BiomeKeys.MEADOW),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_APPLE_TREE_PLACED_KEY);
         */
    }
}
