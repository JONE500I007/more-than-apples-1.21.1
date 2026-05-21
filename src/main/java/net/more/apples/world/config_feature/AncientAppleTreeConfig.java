package net.more.apples.world.config_feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.more.apples.MoreThanApples;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.world.tree.custom.ancient_apple.AncientAppleFoliagePlacer;
import net.more.apples.world.tree.custom.ancient_apple.AncientAppleTrunkPlacer;
import net.more.apples.world.tree.custom.ancient_apple.AncientAppleTrunkPlacerv1;
import net.more.apples.world.tree.custom.frosty_tree.FrostyAppleFoliagePlacer;
import net.more.apples.world.tree.custom.frosty_tree.FrostyAppleTrunkPlacer;

import java.util.OptionalInt;

public class AncientAppleTreeConfig {

    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_APPLE_KEY = registryTreeKey("ancient_apple_key");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

//        WeightedStateProvider twoLeavesProvider = new WeightedStateProvider(
//                WeightedList.<BlockState>builder()
//                        .add(AppleWoodBlocks.APPLE_LEAVES.defaultBlockState(), 5)
//                        .add(AppleWoodBlocks.FRUIT_APPLE_LEAVES.defaultBlockState(), 1)
//                        .build()
//        );
//
//        registerTreeConfig(context, ANCIENT_APPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
//                BlockStateProvider.simple(AppleWoodBlocks.APPLE_LOG),
//                new AncientAppleTrunkPlacer(30, 8, 7),
//                twoLeavesProvider,
//                new AncientAppleFoliagePlacer(ConstantInt.of(4), ConstantInt.of(4), 6),
//                new TwoLayersFeatureSize(7, 7, 7, OptionalInt.of(32)))
//                .build());

        registerTreeConfig(context, ANCIENT_APPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(AppleWoodBlocks.APPLE_LOG),
                new AncientAppleTrunkPlacer(30, 8, 7),

                BlockStateProvider.simple(AncientAppleWoodBlocks.ANCIENT_APPLE_LEAVES),
                new AncientAppleFoliagePlacer(ConstantInt.of(4), ConstantInt.of(4), 6),
                new TwoLayersFeatureSize(7, 7, 7, OptionalInt.of(32)))
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
