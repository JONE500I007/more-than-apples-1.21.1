package net.more.apples.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ClampedNormalInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.more.apples.MoreThanApples;
import net.more.apples.block.ModBlocks2;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> APPLE_ORE_PLACED_KEY = registryKey("apple_ore_placed");

    public static final ResourceKey<PlacedFeature> APPLE_TREE_PLACED_KEY = registryKey("apple_tree_placed");
    public static final ResourceKey<PlacedFeature> LARGE_APPLE_TREE_PLACED_KEY = registryKey("large_apple_tree_placed");

    public static final ResourceKey<PlacedFeature> LARGE_GOLDEN_APPLE_TREE_PLACED_KEY = registryKey("large_golden_apple_tree_placed");

    public static final ResourceKey<PlacedFeature> FROSTY_APPLE_TREE_PLACED_KEY = registryKey("frosty_apple_tree_placed");

    public static final ResourceKey<PlacedFeature> EXTRA_FLOWERS_PLACED_KEY = registryKey("extra_flowers_placed");

    public static final ResourceKey<PlacedFeature> ORCHARD_SEAGRASS_PLACED_KEY = registryKey("orchard_seagrass_placed");

    public static final ResourceKey<PlacedFeature> GOLDEN_DANDELION_PLACED_KEY = registryKey("golden_dandelion_placed");

    public static void boostrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, APPLE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.APPLE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-80),
                                VerticalAnchor.absolute(80))));

        /*CountPlacement
         */
        //count = minimum number to spawn every chunk
        //extraChance = Random chance 0.0 – 1.0 (maybe) to spawn an additional extraCount
        //extraCount = the number to spawn increases if extraChance is randomly cast
        /*register(context, APPLE_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.APPLE_TREE_KEY),
                VegetationPlacements.treePlacement(
                        CountPlacement.of(2, 0.1f, 2), ModBlocks2.APPLE_SAPLING));
         */
        register(context, APPLE_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.APPLE_TREE_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(2, 0.1f, 2),
                        ModBlocks2.APPLE_SAPLING));
        // 1 in 6 chunk for your num
        // 1 in 4 chunk
        register(context, LARGE_APPLE_TREE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_APPLE_KEY),
                VegetationPlacements.treePlacement(
                        //CountPlacement.of(4),
                        RarityFilter.onAverageOnceEvery(4),
                        ModBlocks2.APPLE_SAPLING));
//RarityFilterPlacementModifier
        register(context, LARGE_GOLDEN_APPLE_TREE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_GOLDEN_APPLE_KEY),
                VegetationPlacements.treePlacement(
                        //CountPlacement.of(7),
                        RarityFilter.onAverageOnceEvery(7),
                        ModBlocks2.GOLDEN_APPLE_SAPLING));

        register(context, FROSTY_APPLE_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FROSTY_APPLE_TREE_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(3, 0.1f, 2), ModBlocks2.FROSTY_APPLE_SAPLING));

        register(context, GOLDEN_DANDELION_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.GOLDEN_DANDELION_KEY),
                List.of(RarityFilter.onAverageOnceEvery(5),
                        CountPlacement.of(4),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()));

//        register(context, GOLDEN_DANDELION_PLACED_KEY,
//                configuredFeatures.getOrThrow(ModConfiguredFeatures.GOLDEN_DANDELION_KEY),
//                List.of(CountPlacement.of(64),
//                        InSquarePlacement.spread(),
//                        PlacementUtils.HEIGHTMAP,
//                        RandomOffsetPlacement.of(
//                                ClampedNormalInt.of(0f, 6f, -6, 6),
//                                ClampedNormalInt.of(0f, 2f, -2, 2)),
//                        BiomeFilter.biome()));
    }


    public static ResourceKey<PlacedFeature> registryKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
    /*
    private static void register(BootstrapContext<PlacedFeature> context,
                                 ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {

        register(context, key, configuration, List.of(modifiers));
    }
     */
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                                                                          Holder<ConfiguredFeature<?, ?>> configuration,
                                                                                          PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
