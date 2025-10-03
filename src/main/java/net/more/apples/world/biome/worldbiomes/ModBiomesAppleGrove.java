package net.more.apples.world.biome.worldbiomes;

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
import net.minecraft.world.gen.feature.OceanPlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.more.apples.MoreThanApples;
import net.more.apples.world.ModPlacedFeatures;

public class ModBiomesAppleGrove {
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
        //spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));

        DefaultBiomeFeatures.addFarmAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);
        DefaultBiomeFeatures.addMonsters(spawnBuilder, 95, 5, 100, true);

        /*
        spawnBuilder.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.SQUID, 10, 1, 4));
        spawnBuilder.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(EntityType.DOLPHIN, 2, 1, 2));
        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.COD, 10, 3, 6));
        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SALMON, 5, 1, 5));
        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.TROPICAL_FISH, 25, 8, 8));

        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.DROWNED, 5, 1, 1));
         */

//        spawnBuilder.spawn(SpawnGroup.WATER_CREATURE,
//                new SpawnSettings.SpawnEntry(EntityType.SQUID, 2, 1, 4));
//        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT,
//                new SpawnSettings.SpawnEntry(EntityType.COD, 5, 3, 6));
//        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT,
//                new SpawnSettings.SpawnEntry(EntityType.SALMON, 5, 1, 5));
//        spawnBuilder.spawn(SpawnGroup.MONSTER,
//                new SpawnSettings.SpawnEntry(EntityType.DROWNED, 5, 1, 1));

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        //DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);
        //DefaultBiomeFeatures.addExtraGoldOre(biomeBuilder);

        //biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.APPLE_TREE_PLACED_KEY);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.LARGE_APPLE_TREE_PLACED_KEY);
        /*
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.EXTRA_FLOWERS_PLACED_KEY);

         */

        //DefaultBiomeFeatures.addPlainsTallGrass(biomeBuilder);
        //DefaultBiomeFeatures.addForestFlowers(biomeBuilder);
        //DefaultBiomeFeatures.addLargeFerns(biomeBuilder);
        //DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);
        biomeBuilder.feature(
                GenerationStep.Feature.VEGETAL_DECORATION,
                VegetationPlacedFeatures.PATCH_GRASS_PLAIN);
        biomeBuilder.feature(
                GenerationStep.Feature.VEGETAL_DECORATION,
                VegetationPlacedFeatures.FLOWER_MEADOW);
//        DefaultBiomeFeatures.addMeadowFlowers(biomeBuilder);

        DefaultBiomeFeatures.addDefaultDisks(biomeBuilder);
        DefaultBiomeFeatures.addSeagrassOnStone(biomeBuilder);
        DefaultBiomeFeatures.addLessKelp(biomeBuilder);
//        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
//                OceanPlacedFeatures.SEA_PICKLE);
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                OceanPlacedFeatures.SEAGRASS_RIVER);
        //DefaultBiomeFeatures.addKelp(biomeBuilder);


//        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
//        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.55f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3F76E4)
                        .waterFogColor(0x50533)
                        .skyColor(0x78A7FF)
                        .grassColor(0x91BD59)
                        .foliageColor(0x77AB2F)
                        .fogColor(0xC0D8FF)
                        .moodSound(BiomeMoodSound.CAVE)
                        .grassColorModifier(BiomeEffects.GrassColorModifier.NONE)
                        //.music(MusicType.createIngameMusic(RegistryEntry.of(ModSounds.APPLE_LAND)))
                        .music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_MEADOW))
                .build())
                .build();
    }
}

//.particleConfig(new BiomeParticleConfig(
//                        ParticleTypes.HAPPY_VILLAGER, // เลือก particle
//                        0.02f                          // ความหนาแน่น (ค่า 0.0f–1.0f)
//))
