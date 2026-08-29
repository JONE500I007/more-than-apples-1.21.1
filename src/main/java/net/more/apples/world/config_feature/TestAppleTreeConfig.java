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
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.world.tree.custom.test_tree.TestAppleTrunkPlacer;

public class TestAppleTreeConfig {
    public static final ResourceKey<ConfiguredFeature<?, ?>> TEST_APPLE_TREE_KEY = registryTreeKey("test_apple_tree_key");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        // 26.2 TreeConfigurationBuilder get belowTrunkProvider
        BlockStateProvider belowTrunk =
                TreeConfiguration.defaultPlaceBelowTreeTrunkProvider(context.lookup(Registries.BIOME));

        registerTreeConfig(context, TEST_APPLE_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(TestAppleWoodBlocks.TEST_APPLE_LOG),
                        new TestAppleTrunkPlacer(3, 1, 1),
                        BlockStateProvider.simple(TestAppleWoodBlocks.TEST_APPLE_LEAVES),
                        new AcaciaFoliagePlacer(
                                ConstantInt.of(0),
                                ConstantInt.of(1)),
                        new TwoLayersFeatureSize(1, 0, 1),
                        belowTrunk)
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
