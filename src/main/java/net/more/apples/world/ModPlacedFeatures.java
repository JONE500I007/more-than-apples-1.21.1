package net.more.apples.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.more.apples.MoreThanApples;
import net.more.apples.block.ModBlocks2;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> APPLE_ORE_PLACED_KEY = registryKey("apple_ore_placed");

    public static final RegistryKey<PlacedFeature> APPLE_TREE_PLACED_KEY = registryKey("apple_tree_placed");
    public static final RegistryKey<PlacedFeature> LARGE_APPLE_TREE_PLACED_KEY = registryKey("large_apple_tree_placed");

    public static final RegistryKey<PlacedFeature> EXTRA_FLOWERS_PLACED_KEY = registryKey("extra_flowers_placed");


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
        register(context, LARGE_APPLE_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LARGE_APPLE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(0, 0.05f, 1), ModBlocks2.APPLE_SAPLING));

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
