package net.more.apples.world.config_feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.more.apples.MoreThanApples;

public class TestAppleTreeConfig {
    public static final ResourceKey<ConfiguredFeature<?, ?>> TEST_APPLE_TREE_KEY = registryTreeKey("test_apple_tree_key");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        registerTreeConfig(context, TEST_APPLE_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks2.TEST_APPLE_LOG),
                        new TestAppleTrunkPlacer(3, 1, 1),
                        BlockStateProvider.simple(ModBlocks2.TEST_APPLE_LEAVES),
                        new AcaciaFoliagePlacer(
                                ConstantInt.of(0),
                                ConstantInt.of(1)),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .build());
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registryTreeKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void registerTreeConfig(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                                    ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
