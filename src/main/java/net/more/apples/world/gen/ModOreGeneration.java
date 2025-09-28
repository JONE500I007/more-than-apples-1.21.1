package net.more.apples.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.more.apples.world.ModPlacedFeatures;
import net.more.apples.world.biome.ModBiomes;

public class ModOreGeneration {
    public static void generateOres(){
//        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
//                ModPlacedFeatures.APPLE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.APPLE_GROVE), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.APPLE_ORE_PLACED_KEY);
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
