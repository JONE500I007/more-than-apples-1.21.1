package net.more.apples.world.biome.biomes_regions.golden_apple_orchard_biome;

import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.*;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.GenerationChunkHolder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.attribute.AmbientMoodSettings;
import net.minecraft.world.attribute.AmbientSounds;
import net.minecraft.world.attribute.BackgroundMusic;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.more.apples.MoreThanApples;
import net.more.apples.world.placed_feature.ApplePlacedFeature;
import org.joml.Vector3f;
import net.minecraft.world.level.biome.BiomeGenerationSettings;

import java.util.List;
import java.util.Optional;

import static net.minecraft.world.level.levelgen.GenerationStep.Decoration.*;

public class GoldenAppleOrchardBiome {
    public static final ResourceKey<Biome> GOLDEN_APPLE_ORCHARD = ResourceKey.create(Registries.BIOME,
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "golden_apple_orchard"));


    public static void boostrap(BootstrapContext<Biome> context) {
        context.register(GOLDEN_APPLE_ORCHARD, applegBiome(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        builder.addCarver(Carvers.CAVE);
        builder.addCarver(Carvers.CAVE_EXTRA_UNDERGROUND);
        builder.addCarver(Carvers.CANYON);
//        builder.addFeature(
//                GenerationStep.Decoration.LOCAL_MODIFICATIONS,
//                MiscOverworldPlacements.DISK_CLAY);
        builder.addFeature(
                GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
                CavePlacements.AMETHYST_GEODE);
        builder.addFeature(
                GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
                CavePlacements.MONSTER_ROOM);

        //builder.addFeature(UNDERGROUND_DECORATION, CavePlacements.DRIPSTONE_CLUSTER);
        //builder.addFeature(UNDERGROUND_DECORATION, CavePlacements.LARGE_DRIPSTONE);
        //builder.addFeature(UNDERGROUND_DECORATION, CavePlacements.POINTED_DRIPSTONE);

        builder.addFeature(UNDERGROUND_DECORATION, CavePlacements.UNDERWATER_MAGMA);
        builder.addFeature(VEGETAL_DECORATION, CavePlacements.GLOW_LICHEN);
        builder.addFeature(VEGETAL_DECORATION, CavePlacements.CAVE_VINES);

/*
        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_COAL_UPPER);
        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_COAL_LOWER);

        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_IRON_UPPER);
        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_IRON_MIDDLE);
        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_IRON_SMALL);

        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_GOLD_EXTRA);
        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_GOLD);
        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_GOLD_LOWER);

        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_REDSTONE);
        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_REDSTONE_LOWER);

        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_DIAMOND);
        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_DIAMOND_MEDIUM);
        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_DIAMOND_LARGE);
        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_DIAMOND_BURIED);

        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_LAPIS);
        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_LAPIS_BURIED);

        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_COPPER);
        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_COPPER_LARGE);

        builder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_EMERALD);

        */
    }

    public static Biome applegBiome(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        //spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));

        spawnBuilder.addSpawn(MobCategory.CREATURE, 10,
                new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 2, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, 10,
                new MobSpawnSettings.SpawnerData(EntityType.COW, 2, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, 10,
                new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 2, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, 10,
                new MobSpawnSettings.SpawnerData(EntityType.PIG, 2, 4));

        spawnBuilder.addSpawn(MobCategory.MONSTER, 95,
                new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 1, 4));

        spawnBuilder.addSpawn(MobCategory.MONSTER, 100,
                new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100,
                new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100,
                new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 10,
                new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 5,
                new MobSpawnSettings.SpawnerData(EntityType.WITCH, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, 100,
                new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 4));

        spawnBuilder.addSpawn(MobCategory.MONSTER, 5,
                new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 1, 3));


        spawnBuilder.addSpawn(MobCategory.AMBIENT, 10,
                new MobSpawnSettings.SpawnerData(EntityType.BAT, 1, 2));
        spawnBuilder.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, 10,
                new MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID, 1, 2));


        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, 10,
                new MobSpawnSettings.SpawnerData(EntityType.COD, 4, 10));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, 10,
                new MobSpawnSettings.SpawnerData(EntityType.SALMON, 4, 10));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, 5,
                new MobSpawnSettings.SpawnerData(EntityType.PUFFERFISH, 1, 3));
        spawnBuilder.addSpawn(MobCategory.WATER_CREATURE, 10,
                new MobSpawnSettings.SpawnerData(EntityType.SQUID, 1, 4));

        spawnBuilder.addSpawn(MobCategory.WATER_CREATURE, 10,
                new MobSpawnSettings.SpawnerData(EntityType.SQUID, 1, 4));


        //GenerationSettings
        // world gen maybe biome
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                        context.lookup(Registries.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);

        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_COAL_UPPER);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_COAL_LOWER);

        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_IRON_UPPER);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_IRON_MIDDLE);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_IRON_SMALL);

        //biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_GOLD_EXTRA);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_GOLD);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_GOLD_LOWER);

        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_REDSTONE);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_REDSTONE_LOWER);

        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_DIAMOND);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_DIAMOND_MEDIUM);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_DIAMOND_LARGE);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_DIAMOND_BURIED);

        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_LAPIS);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_LAPIS_BURIED);


        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_COPPER);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_COPPER_LARGE);

        //biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_EMERALD);

        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_DIRT);
        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_GRAVEL);
        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_GRANITE_UPPER);
        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_GRANITE_LOWER);
        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_DIORITE_UPPER);
        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_DIORITE_LOWER);
        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_ANDESITE_UPPER);
        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_ANDESITE_LOWER);
        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_TUFF);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                ApplePlacedFeature.LARGE_GOLDEN_APPLE_TREE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                ApplePlacedFeature.GOLDEN_DANDELION_PLACED_KEY);
        //biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
//        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
//                ModPlacedFeatures.LARGE_APPLE_TREE_PLACED_KEY);
//        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
//                ModPlacedFeatures.ORCHARD_SEAGRASS_PLACED_KEY);

        /*
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.EXTRA_FLOWERS_PLACED_KEY);

         */


        //biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_PLAINS);

        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                VegetationPlacements.PATCH_GRASS_PLAIN);


//        biomeBuilder.addFeature(
//                GenerationStep.Decoration.VEGETAL_DECORATION,
//                VegetationPlacements.PATCH_LEAF_LITTER);

        biomeBuilder.addFeature(
                UNDERGROUND_DECORATION,
                MiscOverworldPlacements.SPRING_WATER);
        biomeBuilder.addFeature(
                UNDERGROUND_DECORATION,
                MiscOverworldPlacements.SPRING_LAVA);

        biomeBuilder.addFeature(
                UNDERGROUND_DECORATION,
                MiscOverworldPlacements.DISK_SAND);
        biomeBuilder.addFeature(
                UNDERGROUND_DECORATION,
                MiscOverworldPlacements.DISK_CLAY);
        biomeBuilder.addFeature(
                UNDERGROUND_DECORATION,
                MiscOverworldPlacements.DISK_GRAVEL);
        //DefaultBiomeFeatures.addSeagrassOnStone(biomeBuilder);//KELP_COLD
        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                AquaticPlacements.KELP_COLD);
//        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
//                OceanPlacedFeatures.SEA_PICKLE);
        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                AquaticPlacements.SEAGRASS_RIVER);
//        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
//                VegetationPlacedFeatures.PATCH_SUGAR_CANE);

        //DefaultBiomeFeatures.addKelp(biomeBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.4f)
                .temperature(0.65f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())

                .setAttribute(EnvironmentAttributes.SKY_COLOR, 0xFFD580)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0xFFF2CC)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x050533)

                .setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, new AmbientSounds(
                        Optional.empty(),
                        Optional.of(AmbientMoodSettings.LEGACY_CAVE_SETTINGS),
                        List.of()))
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC,
                        new BackgroundMusic(SoundEvents.MUSIC_BIOME_MEADOW))
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3F76E4)

                        .grassColorOverride(0xFFC030)
                        .foliageColorOverride(0xFBC03A)

//                        .particleConfig(new BiomeParticleConfig(
//                                new DustParticleEffect(new Vector3f(0.95f, 0.69f, 0.15f), 1.0f), 0.02f))

                        .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                        //.music(MusicType.createIngameMusic(RegistryEntry.of(ModSounds.APPLE_LAND)))

                        .build())
                .build();
    }
}
