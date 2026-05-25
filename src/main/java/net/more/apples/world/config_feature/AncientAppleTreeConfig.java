package net.more.apples.world.config_feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.more.apples.MoreThanApples;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.world.placed_feature.custom.AncientFeatures;
import net.more.apples.world.tree.custom.ancient_apple.AncientAppleFoliagePlacer;
import net.more.apples.world.tree.custom.ancient_apple.AncientAppleTrunkPlacer;

import java.util.OptionalInt;

public class AncientAppleTreeConfig {

    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_APPLE_KEY = registryTreeKey("ancient_apple_key");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_APPLE_KEY2 = registryTreeKey("ancient_apple_key2");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        registerTreeConfig(context, ANCIENT_APPLE_KEY2, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(AppleWoodBlocks.APPLE_LOG),
                new AncientAppleTrunkPlacer(30, 8, 7),

                BlockStateProvider.simple(AncientAppleWoodBlocks.ANCIENT_APPLE_LEAVES),
                new AncientAppleFoliagePlacer(ConstantInt.of(4), ConstantInt.of(4), 6),
                new TwoLayersFeatureSize(7, 3, 7, OptionalInt.of(32)))
                .build());

        context.register(ANCIENT_APPLE_KEY, new ConfiguredFeature<>(
                AncientFeatures.ANCIENT_APPLE_TREE,
                NoneFeatureConfiguration.INSTANCE));

    }



    public static ResourceKey<ConfiguredFeature<?, ?>> registryTreeKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void registerTreeConfig(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                                   ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
