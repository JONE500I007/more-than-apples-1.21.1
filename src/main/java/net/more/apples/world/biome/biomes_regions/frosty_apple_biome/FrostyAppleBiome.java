package net.more.apples.world.biome.biomes_regions.frosty_apple_biome;

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
import net.minecraft.util.ARGB;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.more.apples.MoreThanApples;
import net.more.apples.world.placed_feature.ApplePlacedFeature;

import java.util.List;
import java.util.Optional;

import static net.minecraft.world.level.levelgen.GenerationStep.Decoration.*;

public class FrostyAppleBiome {
    public static final ResourceKey<Biome> FROSTY_APPLE = ResourceKey.create(Registries.BIOME,
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple"));


    public static void boostrap(BootstrapContext<Biome> context) {
        context.register(FROSTY_APPLE, applegBiome(context));
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

        builder.addFeature(UNDERGROUND_DECORATION, CavePlacements.UNDERWATER_MAGMA);
        builder.addFeature(VEGETAL_DECORATION, CavePlacements.GLOW_LICHEN);


        builder.addFeature(
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION,
                MiscOverworldPlacements.FREEZE_TOP_LAYER);
        builder.addFeature(
                UNDERGROUND_DECORATION,
                MiscOverworldPlacements.ICE_PATCH);
    }

    public static Biome applegBiome(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(EntityTypes.CHICKEN, 10, 2, 4);
        spawnBuilder.addSpawn(EntityTypes.COW, 10, 2, 4);
        spawnBuilder.addSpawn(EntityTypes.SHEEP, 10, 2, 4);
        spawnBuilder.addSpawn(EntityTypes.PIG, 10, 2, 4);

        spawnBuilder.addSpawn(EntityTypes.ZOMBIE, 95, 1, 4);

        spawnBuilder.addSpawn(EntityTypes.SKELETON, 100, 1, 4);
        spawnBuilder.addSpawn(EntityTypes.CREEPER, 100, 1, 4);
        spawnBuilder.addSpawn(EntityTypes.SPIDER, 100, 1, 4);
        spawnBuilder.addSpawn(EntityTypes.ENDERMAN, 10, 1, 4);
        spawnBuilder.addSpawn(EntityTypes.WITCH, 5, 1, 1);
        spawnBuilder.addSpawn(EntityTypes.SLIME, 100, 1, 4);

        spawnBuilder.addSpawn(EntityTypes.DROWNED, 5, 1, 3);


        spawnBuilder.addSpawn(EntityTypes.BAT, 10, 1, 2);
        spawnBuilder.addSpawn(EntityTypes.GLOW_SQUID, 10, 1, 2);


        spawnBuilder.addSpawn(EntityTypes.COD, 10, 4, 10);
        spawnBuilder.addSpawn(EntityTypes.SALMON, 10, 4, 10);
        spawnBuilder.addSpawn(EntityTypes.PUFFERFISH, 5, 1, 3);
        spawnBuilder.addSpawn(EntityTypes.SQUID, 10, 1, 4);

        spawnBuilder.addSpawn(EntityTypes.SQUID, 10, 1, 4);

        // world gen maybe biome
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                        context.lookup(Registries.CARVER));

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

        //biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
        biomeBuilder.addFeature(VEGETAL_DECORATION,
                ApplePlacedFeature.FROSTY_APPLE_TREE_PLACED_KEY);

//        biomeBuilder.feature(
//                GenerationStep.Feature.VEGETAL_DECORATION,
//                VegetationPlacedFeatures.PATCH_GRASS_PLAIN);

        //DefaultBiomeFeatures.addLeafLitter(biomeBuilder);
        biomeBuilder.addFeature(
                VEGETAL_DECORATION,
                VegetationPlacements.PATCH_GRASS_NORMAL);
//        biomeBuilder.feature(
//                GenerationStep.Feature.VEGETAL_DECORATION,
//                VegetationPlacedFeatures.FLOWER_MEADOW);
//        DefaultBiomeFeatures.addMeadowFlowers(biomeBuilder);

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
                VegetationPlacements.PATCH_BERRY_COMMON);
//        biomeBuilder.addFeature(
//                GenerationStep.Decoration.VEGETAL_DECORATION,
//                VegetationPlacements.PATCH_SUGAR_CANE);
//        biomeBuilder.addFeature(
//                GenerationStep.Decoration.VEGETAL_DECORATION,
//                VegetationPlacements.BROWN_MUSHROOM_NORMAL);
//        biomeBuilder.addFeature(
//                GenerationStep.Decoration.VEGETAL_DECORATION,
//                VegetationPlacements.RED_MUSHROOM_NORMAL);
//        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
//                OceanPlacedFeatures.SEA_PICKLE);
        biomeBuilder.addFeature(
                VEGETAL_DECORATION,
                AquaticPlacements.KELP_COLD);
        biomeBuilder.addFeature(
                VEGETAL_DECORATION,
                AquaticPlacements.SEAGRASS_RIVER);
//        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
//                VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        //DefaultBiomeFeatures.addKelp(biomeBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.0f)
                .downfall(0.8f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())

                .setAttribute(EnvironmentAttributes.SKY_COLOR, ARGB.vector3fFromRGB24(0x82ABFF))
                .setAttribute(EnvironmentAttributes.FOG_COLOR, ARGB.vector3fFromRGB24(0xC0D8FF))
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, ARGB.vector3fFromRGB24(0x050533))

                .setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, new AmbientSounds(
                        Optional.empty(),
                        Optional.of(AmbientMoodSettings.LEGACY_CAVE_SETTINGS),
                        List.of()))
                .setAttribute(EnvironmentAttributes.BACKGROUND_MUSIC,
                        new BackgroundMusic(SoundEvents.MUSIC_BIOME_MEADOW))


                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(0x3938C9)
                        //.dryFoliageColor(0x918E5B)
                        .grassColorOverride(0x80B497)
                        .foliageColorOverride(0x60A17B)
                        .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                        .build())
                .build();
    }
}
