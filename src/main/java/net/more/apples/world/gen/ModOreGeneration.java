package net.more.apples.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.more.apples.world.ModPlacedFeatures;
import net.more.apples.world.biome.worldbiomes.ModBiomesAppleGrove;
import net.more.apples.world.biome.worldbiomes.ModBiomesGoldenAppleOrchard;

public class ModOreGeneration {
    public static void generateOres(){
//        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
//                ModPlacedFeatures.APPLE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomesAppleGrove.APPLE_GROVE), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.APPLE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomesGoldenAppleOrchard.GOLDEN_APPLE_ORCHARD), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.APPLE_ORE_PLACED_KEY);

//        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomesGoldenAppleOrchard.GOLDEN_APPLE_ORCHARD), GenerationStep.Feature.UNDERGROUND_ORES,
//                ModPlacedFeatures.APPLE_ORE_PLACED_KEY);
        /*
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SAVANNA, BiomeKeys.BADLANDS), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.APPLE_ORE_PLACED_KEY);
         */
        /*
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.APPLE_ORE_PLACED_KEY);
         */
    }
}
