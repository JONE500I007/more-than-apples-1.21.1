package net.more.apples.world.biome.worldbiomes;

import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.OceanPlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.more.apples.MoreThanApples;
import net.more.apples.world.ModPlacedFeatures;
import org.joml.Vector3f;

public class ModBiomesGoldenAppleOrchard {
    public static final RegistryKey<Biome> GOLDEN_APPLE_ORCHARD = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(MoreThanApples.MOD_ID, "golden_apple_orchard"));


    public static void boostrap(Registerable<Biome> context) {
        context.register(GOLDEN_APPLE_ORCHARD, applegBiome(context));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static Biome applegBiome(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();
        //spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));


        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);
        DefaultBiomeFeatures.addOceanMobs(spawnBuilder, 10, 4, 10);
        DefaultBiomeFeatures.addMonsters(spawnBuilder, 95, 5, 100, true);


        // world gen maybe biome
        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addExtraGoldOre(biomeBuilder);

        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.LARGE_GOLDEN_APPLE_TREE_PLACED_KEY);
        //biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
//        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
//                ModPlacedFeatures.LARGE_APPLE_TREE_PLACED_KEY);
//        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
//                ModPlacedFeatures.ORCHARD_SEAGRASS_PLACED_KEY);

        /*
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.EXTRA_FLOWERS_PLACED_KEY);

         */

        //DefaultBiomeFeatures.addDefaultGrass(biomeBuilder);
        //DefaultBiomeFeatures.addPlainsTallGrass(biomeBuilder);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                VegetationPlacedFeatures.FLOWER_PLAIN);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                VegetationPlacedFeatures.PATCH_GRASS_PLAIN);

        DefaultBiomeFeatures.addDefaultDisks(biomeBuilder);
        //DefaultBiomeFeatures.addSeagrassOnStone(biomeBuilder);
        DefaultBiomeFeatures.addLessKelp(biomeBuilder);
//        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
//                OceanPlacedFeatures.SEA_PICKLE);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                OceanPlacedFeatures.SEAGRASS_RIVER);
//        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
//                VegetationPlacedFeatures.PATCH_SUGAR_CANE);

        //DefaultBiomeFeatures.addKelp(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.65f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3F76E4)
                        .waterFogColor(0x50533)
                        .skyColor(0xFFD580)
                        .grassColor(0xFFC030)
                        .foliageColor(0xFBC03A)
                        .fogColor(0xFFF2CC)
//                        .particleConfig(new BiomeParticleConfig(
//                                new DustParticleEffect(new Vector3f(0.95f, 0.69f, 0.15f), 1.0f), 0.02f))
                        .moodSound(BiomeMoodSound.CAVE)
                        .grassColorModifier(BiomeEffects.GrassColorModifier.NONE)
                        //.music(MusicType.createIngameMusic(RegistryEntry.of(ModSounds.APPLE_LAND)))
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_FOREST))
                .build())
                .build();
    }
}
