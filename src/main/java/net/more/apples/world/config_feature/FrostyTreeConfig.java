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

public class FrostyTreeConfig {
    public static final ResourceKey<ConfiguredFeature<?, ?>> FROSTY_APPLE_TREE_KEY = registryTreeKey("frosty_apple_tree_key");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        registerTreeConfig(context, FROSTY_APPLE_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks2.FROSTY_APPLE_LOG),
                new FrostyAppleTrunkPlacer(4, 2, 0),

                BlockStateProvider.simple(ModBlocks2.FROSTY_APPLE_LEAVES),
                new FrostyAppleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 0),
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
