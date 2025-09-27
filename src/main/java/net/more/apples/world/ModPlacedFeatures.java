package net.more.apples.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.more.apples.MoreThanApples;
import net.more.apples.block.ModBlocks2;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> APPLE_ORE_PLACED_KEY = registryKey("apple_ore_placed");

    public static final RegistryKey<PlacedFeature> APPLE_TREE_PLACED_KEY = registryKey("apple_tree_placed");

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

        register(context, APPLE_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.APPLE_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks2.APPLE_SAPLING));
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
