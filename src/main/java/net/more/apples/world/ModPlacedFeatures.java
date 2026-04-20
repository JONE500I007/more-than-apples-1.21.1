package net.more.apples.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
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


    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, APPLE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.APPLE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80)))
                );

        /*
        register(context, APPLE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.APPLE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80)))
        );
         */
        //count = minimum number to spawn every chunk
        //extraChance = Random chance 0.0 – 1.0 (maybe) to spawn an additional extraCount
        //extraCount = the number to spawn increases if extraChance is randomly cast
        register(context, APPLE_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.APPLE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks2.APPLE_SAPLING));

//        register(context, LARGE_APPLE_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_APPLE_KEY),
//                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
//                        PlacedFeatures.createCountExtraModifier(0, 0.5f, 1), ModBlocks2.APPLE_SAPLING));

        // 1 in 6 chunk for your num
        // 1 in 4 chunk
        register(context, LARGE_APPLE_TREE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_APPLE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        RarityFilterPlacementModifier.of(4),
                        ModBlocks2.APPLE_SAPLING));

        register(context, LARGE_GOLDEN_APPLE_TREE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_GOLDEN_APPLE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        RarityFilterPlacementModifier.of(7),
                        ModBlocks2.GOLDEN_APPLE_SAPLING));

        register(context, FROSTY_APPLE_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FROSTY_APPLE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(3, 0.1f, 2), ModBlocks2.FROSTY_APPLE_SAPLING));

        /*
        context.register(EXTRA_FLOWERS_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(VegetationConfiguredFeatures.FLOWER_MEADOW),
                        List.of(
                                PlacedFeatures.createCountExtraModifier(8, 0.2f, 2),
                                SquarePlacementModifier.of(),
                                BiomePlacementModifier.of()
                        )
                )
        );
         */
        /*
        register(context, EXTRA_FLOWERS_PLACED_KEY,
                configuredFeatures.getOrThrow(VegetationConfiguredFeatures.FLOWER_MEADOW),
                PlacedFeatures.createCountExtraModifier(8, 0.2f, 2),
                SquarePlacementModifier.of(),
                BiomePlacementModifier.of()
        );
         */
        /*
        register(context, EXTRA_FLOWERS_PLACED_KEY,
                configuredFeatures.getOrThrow(VegetationConfiguredFeatures.FLOWER_MEADOW),
                PlacedFeatures.createCountExtraModifier(8, 0.1f, 2),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
         */

        /*
        context.register(ORCHARD_SEAGRASS_PLACED_KEY,
                new PlacedFeature(
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE)
                                .getOrThrow(ModConfiguredFeatures.ORCHARD_SEAGRASS_KEY),
                        List.of(
                                RarityFilterPlacementModifier.of(2),
                                SquarePlacementModifier.of(),
                                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                                BiomePlacementModifier.of()
                        )
                )
        );
         */

    }


    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MoreThanApples.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
