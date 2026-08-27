package net.more.apples.world.config_feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
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
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.PlaceOnGroundDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.more.apples.MoreThanApples;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;

import java.util.List;
import java.util.OptionalInt;

public class AppleTreeConfig {

    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_TREE_KEY = registryTreeKey("apple_tree_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_APPLE_KEY = registryTreeKey("large_apple_key");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_GOLDEN_APPLE_KEY = registryTreeKey("large_golden_apple_key");

    //public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_LEAF_LITTER_KEY = registryTreeKey("apple_leaf_litter_key");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        // Places leaf litter only within a small radius of each tree's base, matching vanilla's oak/birch trees
        // (see net.minecraft.data.worldgen.features.TreeFeatures#sparseLeafLitter/thickLeafLitter),
        // instead of scattering it across the whole biome.
        PlaceOnGroundDecorator sparseLeafLitter = new PlaceOnGroundDecorator(
                96, 4, 2, new WeightedStateProvider(VegetationFeatures.leafLitterPatchBuilder(1, 3)));
        PlaceOnGroundDecorator thickLeafLitter = new PlaceOnGroundDecorator(
                150, 2, 2, new WeightedStateProvider(VegetationFeatures.leafLitterPatchBuilder(1, 4)));

        WeightedStateProvider twoLeavesProvider = new WeightedStateProvider(
                WeightedList.<BlockState>builder()
                        .add(AppleWoodBlocks.APPLE_LEAVES.defaultBlockState(), 5)
                        .add(AppleWoodBlocks.FRUIT_APPLE_LEAVES.defaultBlockState(), 1)
                        .build()
        );
        registerTreeConfig(context, APPLE_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(AppleWoodBlocks.APPLE_LOG),
                // 3 baseHeight 11 firstRandomHeight 0 secondRandomHeight
                new StraightTrunkPlacer(4, 2, 0),
                twoLeavesProvider,
                // radius = 2, offset = 0, bush height = 3
                //radius = 2 leaves radius -> around the trunk, the leaves are spread out 2 blocks wide
                //offset = 4 Height offset of leaf bush from trunk top ->
                // leaves will start to emerge 4 blocks below trunk top
                // foliage height = leaves layer height, leaves bush will be ~4 blocks high
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                // layer size maybe idk for now
                // 0 limit 0 lowerSize 0 upperSize, and 4 minClippedHeight
                // limit= maybe starting point for the change from lower size -> upper size
                // lowerSize = thickness of the bottom layer, bottommost leaf
                // upperSize = thickness of the top layer, top layer
                new TwoLayersFeatureSize(1, 0, 1)
        ).decorators(List.of(new BeehiveDecorator(0.1f), sparseLeafLitter, thickLeafLitter)).build());

        registerTreeConfig(context, LARGE_APPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(AppleWoodBlocks.APPLE_LOG),
                new FancyTrunkPlacer(4, 14, 2),
                twoLeavesProvider,

                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(2, 0, 2, OptionalInt.of(4))
        ).decorators(List.of(new BeehiveDecorator(0.1f), sparseLeafLitter, thickLeafLitter)).build());



        WeightedStateProvider twoLeavesProvider2 = new WeightedStateProvider(
                WeightedList.<BlockState>builder()
                        .add(AppleWoodBlocks.GOLDEN_APPLE_LEAVES.defaultBlockState(), 8)
                        .add(AppleWoodBlocks.FRUIT_GOLDEN_APPLE_LEAVES.defaultBlockState(), 1)
                        .build()
        );
        registerTreeConfig(context, LARGE_GOLDEN_APPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(AppleWoodBlocks.APPLE_LOG),
                new FancyTrunkPlacer(6, 10, 14),
                twoLeavesProvider2,

                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),
                new TwoLayersFeatureSize(2, 0, 2, OptionalInt.of(3))
        ).decorators(List.of(new BeehiveDecorator(0.1f), sparseLeafLitter, thickLeafLitter)).build());
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registryTreeKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void registerTreeConfig(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                                   ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
