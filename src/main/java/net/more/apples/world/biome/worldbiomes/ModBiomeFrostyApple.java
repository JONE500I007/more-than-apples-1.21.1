package net.more.apples.world.biome.worldbiomes;

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
import net.more.apples.world.ModPlacedFeatures;

import java.util.List;
import java.util.Optional;

import static net.minecraft.world.level.levelgen.GenerationStep.Decoration.UNDERGROUND_ORES;

public class ModBiomeFrostyApple {
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

        builder.addFeature(
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION,
                MiscOverworldPlacements.FREEZE_TOP_LAYER);
    }

    public static Biome applegBiome(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

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

        // world gen maybe biome
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                        context.lookup(Registries.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        //DefaultBiomeFeatures.addMossyRocks(biomeBuilder);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_COAL_UPPER);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_IRON_MIDDLE);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_COPPER);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_DIAMOND);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_LAPIS);

        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_GOLD);
        biomeBuilder.addFeature(UNDERGROUND_ORES, OrePlacements.ORE_GOLD_EXTRA);
        //DefaultBiomeFeatures.addFrozenTopLayer(biomeBuilder);
        //DefaultBiomeFeatures.addExtraGoldOre(biomeBuilder);

        //biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                ModPlacedFeatures.FROSTY_APPLE_TREE_PLACED_KEY);

//        biomeBuilder.feature(
//                GenerationStep.Feature.VEGETAL_DECORATION,
//                VegetationPlacedFeatures.PATCH_GRASS_PLAIN);

        //DefaultBiomeFeatures.addLeafLitter(biomeBuilder);
        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                VegetationPlacements.PATCH_GRASS_NORMAL);
//        biomeBuilder.feature(
//                GenerationStep.Feature.VEGETAL_DECORATION,
//                VegetationPlacedFeatures.FLOWER_MEADOW);
//        DefaultBiomeFeatures.addMeadowFlowers(biomeBuilder);


        biomeBuilder.addFeature(
                GenerationStep.Decoration.UNDERGROUND_ORES,
                MiscOverworldPlacements.DISK_SAND);
        biomeBuilder.addFeature(
                GenerationStep.Decoration.UNDERGROUND_ORES,
                MiscOverworldPlacements.DISK_CLAY);
        biomeBuilder.addFeature(
                GenerationStep.Decoration.UNDERGROUND_ORES,
                MiscOverworldPlacements.DISK_GRAVEL);

        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                VegetationPlacements.PATCH_BERRY_COMMON);
//        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION,
//                OceanPlacedFeatures.SEA_PICKLE);
        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                AquaticPlacements.KELP_COLD);
        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
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

                .setAttribute(EnvironmentAttributes.SKY_COLOR, 0x82ABFF)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0xC0D8FF)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x050533)

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

//.particleConfig(new BiomeParticleConfig(
//                        ParticleTypes.HAPPY_VILLAGER, // เลือก particle
//                        0.02f                          // ความหนาแน่น (ค่า 0.0f–1.0f)
//))
