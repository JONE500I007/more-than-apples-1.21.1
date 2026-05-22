package net.more.apples.world.biome.biomes_regions.ancient_apple;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.*;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.attribute.AmbientMoodSettings;
import net.minecraft.world.attribute.AmbientSounds;
import net.minecraft.world.attribute.BackgroundMusic;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.more.apples.MoreThanApples;
import net.more.apples.world.placed_feature.AncientApplePlacedFeature;
import net.more.apples.world.placed_feature.ApplePlacedFeature;

import java.util.List;
import java.util.Optional;

import static net.minecraft.world.level.levelgen.GenerationStep.Decoration.*;
import static net.minecraft.world.level.levelgen.GenerationStep.Decoration.UNDERGROUND_DECORATION;
import static net.minecraft.world.level.levelgen.GenerationStep.Decoration.UNDERGROUND_ORES;
import static net.minecraft.world.level.levelgen.GenerationStep.Decoration.VEGETAL_DECORATION;

public class AncientAppleBiome {
    public static final ResourceKey<Biome> ANCIENT_APPLE_WILDS = ResourceKey.create(Registries.BIOME,
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "ancient_apple_wilds"));

    public static void boostrap(BootstrapContext<Biome> context) {
        context.register(ANCIENT_APPLE_WILDS, applegBiome(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        builder.addCarver(Carvers.CAVE);
        builder.addCarver(Carvers.CAVE_EXTRA_UNDERGROUND);
        builder.addCarver(Carvers.CANYON);

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
        //builder.addFeature(VEGETAL_DECORATION, CavePlacements.CAVE_VINES);

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

        spawnBuilder.addSpawn(MobCategory.CREATURE, 8,
                new MobSpawnSettings.SpawnerData(EntityType.FOX, 2, 4));

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



        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_DIRT);
        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_GRAVEL);
        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_GRANITE_UPPER);
        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_GRANITE_LOWER);
        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_DIORITE_UPPER);
        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_DIORITE_LOWER);
        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_ANDESITE_UPPER);
        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_ANDESITE_LOWER);
        biomeBuilder.addFeature(UNDERGROUND_DECORATION, OrePlacements.ORE_TUFF);


        biomeBuilder.addFeature(VEGETAL_DECORATION,
                AncientApplePlacedFeature.ANCIENT_APPLE_TREE_PLACED_KEY);


        biomeBuilder.addFeature(
                VEGETAL_DECORATION,
                VegetationPlacements.PATCH_GRASS_PLAIN);
        biomeBuilder.addFeature(
                VEGETAL_DECORATION,
                VegetationPlacements.FLOWER_MEADOW);


        biomeBuilder.addFeature(
                VEGETAL_DECORATION,
                VegetationPlacements.WILDFLOWERS_MEADOW);

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
        biomeBuilder.addFeature(
                VEGETAL_DECORATION,
                AquaticPlacements.KELP_COLD);
        biomeBuilder.addFeature(
                VEGETAL_DECORATION,
                AquaticPlacements.SEAGRASS_RIVER);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.35f)
                .temperature(0.35f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())

                .setAttribute(EnvironmentAttributes.SKY_COLOR, 0x78A7FF)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0xC0D8FF)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x050533)

                .setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, new AmbientSounds(
                        Optional.empty(),
                        Optional.of(AmbientMoodSettings.LEGACY_CAVE_SETTINGS),
                        List.of()))
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC,
                        new BackgroundMusic(SoundEvents.MUSIC_BIOME_CHERRY_GROVE))
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3F76E4)
                        .grassColorOverride(0x91BD59)
                        .foliageColorOverride(0x77AB2F)
                        .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                        //.music(MusicType.createIngameMusic(RegistryEntry.of(ModSounds.APPLE_LAND)))

                        .build())
                .build();
    }
}
