package net.more.apples.world.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.more.apples.MoreThanApples;
import net.more.apples.world.ModPlacedFeatures;

public class ModBiomes {
    public static final RegistryKey<Biome> APPLE_GROVE = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(MoreThanApples.MOD_ID, "apple_grove"));


    public static void boostrap(Registerable<Biome> context) {
        context.register(APPLE_GROVE, applegBiome(context));
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
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        // world gen maybe biome
        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        //DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        DefaultBiomeFeatures.addExtraGoldOre(biomeBuilder);

        //biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.APPLE_TREE_PLACED_KEY);
        /*
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.EXTRA_FLOWERS_PLACED_KEY);

         */

        //DefaultBiomeFeatures.addPlainsTallGrass(biomeBuilder);
        //DefaultBiomeFeatures.addForestFlowers(biomeBuilder);
        //DefaultBiomeFeatures.addLargeFerns(biomeBuilder);
        //DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        //DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);
        DefaultBiomeFeatures.addMeadowFlowers(biomeBuilder);


//        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
//        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.04f)
                .temperature(0.55f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0xE6A96B)
                        .waterFogColor(0xC97F5C)
                        .skyColor(0xF2C38B)
                        .grassColor(0xD9A066)
                        .foliageColor(0xE1B16A)
                        .fogColor(0xF6D6AD)
                        .moodSound(BiomeMoodSound.CAVE)
                        //.music(MusicType.createIngameMusic(RegistryEntry.of(ModSounds.APPLE_LAND)))
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_MEADOW))
                .build())
                .build();
    }
}
