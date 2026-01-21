package net.more.apples.world.biome.worldbiomes;

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
import net.minecraft.world.gen.feature.OceanPlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.more.apples.MoreThanApples;
import net.more.apples.world.ModPlacedFeatures;

public class ModBiomeFrostyApple {
    public static final RegistryKey<Biome> FROSTY_APPLE = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(MoreThanApples.MOD_ID, "frosty_apple"));


    public static void boostrap(Registerable<Biome> context) {
        context.register(FROSTY_APPLE, applegBiome(context));
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

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);
        DefaultBiomeFeatures.addOceanMobs(spawnBuilder, 10, 4, 10);
        DefaultBiomeFeatures.addMonsters(spawnBuilder, 95, 5, 100, true);

        // world gen maybe biome
        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        //DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        //DefaultBiomeFeatures.addFrozenTopLayer(biomeBuilder);
        //DefaultBiomeFeatures.addExtraGoldOre(biomeBuilder);

        //biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.FROSTY_APPLE_TREE_PLACED_KEY);

//        biomeBuilder.feature(
//                GenerationStep.Feature.VEGETAL_DECORATION,
//                VegetationPlacedFeatures.PATCH_GRASS_PLAIN);

        DefaultBiomeFeatures.addDefaultGrass(biomeBuilder);
//        biomeBuilder.feature(
//                GenerationStep.Feature.VEGETAL_DECORATION,
//                VegetationPlacedFeatures.FLOWER_MEADOW);
//        DefaultBiomeFeatures.addMeadowFlowers(biomeBuilder);

        DefaultBiomeFeatures.addDefaultDisks(biomeBuilder);
        DefaultBiomeFeatures.addSeagrassOnStone(biomeBuilder);
        DefaultBiomeFeatures.addLessKelp(biomeBuilder);
//        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
//                OceanPlacedFeatures.SEA_PICKLE);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                OceanPlacedFeatures.SEAGRASS_RIVER);
//        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
//                VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        //DefaultBiomeFeatures.addKelp(biomeBuilder);


//        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
//        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.8f)
                .temperature(0.0f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3938C9)
                        .waterFogColor(0x050533)
                        .skyColor(0x82ABFF)
                        .grassColor(0x80B497)
                        .foliageColor(0x60A17B)
                        .fogColor(0xC0D8FF)
                        .moodSound(BiomeMoodSound.CAVE)
                        .grassColorModifier(BiomeEffects.GrassColorModifier.NONE)
                        //.music(MusicType.createIngameMusic(RegistryEntry.of(ModSounds.APPLE_LAND)))
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_SNOWY_SLOPES))
                .build())
                .build();
    }
}

//.particleConfig(new BiomeParticleConfig(
//                        ParticleTypes.HAPPY_VILLAGER, // เลือก particle
//                        0.02f                          // ความหนาแน่น (ค่า 0.0f–1.0f)
//))
