package net.more.apples.world.config_feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.more.apples.MoreThanApples;

public class GoldenDandeltioConfig {
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLDEN_DANDELION_KEY = registryKey("golden_dandelion_key");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {


//        register(context, GOLDEN_DANDELION_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
//                        BlockStateProvider.simple(Blocks.GOLDEN_DANDELION)));

        register(context, GOLDEN_DANDELION_KEY,
                Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(
                        new WeightedStateProvider(
                                WeightedList.<BlockState>builder()
                                        .add(Blocks.POPPY.defaultBlockState(), 2)
                                        .add(Blocks.DANDELION.defaultBlockState(), 2)
                                        .add(Blocks.GOLDEN_DANDELION.defaultBlockState(), 4)
                                        .build())));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
