package net.more.apples.world.config_feature;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BlockStateProviders;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
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
import java.util.function.Supplier;

public class AppleTreeConfig {


    public static final ResourceKey<Feature> APPLE_TREE_KEY = registryTreeKey("apple_tree_key");
    public static final ResourceKey<Feature> LARGE_APPLE_KEY = registryTreeKey("large_apple_key");

    public static final ResourceKey<Feature> LARGE_GOLDEN_APPLE_KEY = registryTreeKey("large_golden_apple_key");


    public static final ResourceKey<Feature> APPLE_TREE_LEAF_LITTER_KEY = registryTreeKey("apple_tree_leaf_litter_key");
    public static final ResourceKey<Feature> LARGE_APPLE_LEAF_LITTER_KEY = registryTreeKey("large_apple_leaf_litter_key");

    public static final ResourceKey<Feature> LARGE_GOLDEN_APPLE_LEAF_LITTER_KEY = registryTreeKey("large_golden_apple_leaf_litter_key");

    //public static final ResourceKey<Feature> APPLE_LEAF_LITTER_KEY = registryTreeKey("apple_leaf_litter_key");

    public static void bootstrap(BootstrapContext<Feature> context) {


        Holder<BlockStateProvider> belowTrunk =
                context.lookup(Registries.BLOCK_STATE_PROVIDER).getOrThrow(BlockStateProviders.SOIL_BENEATH_TREE);



        PlaceOnGroundDecorator sparseLeafLitter = new PlaceOnGroundDecorator(
                96, 4, 2, Holder.direct(new WeightedStateProvider(VegetationFeatures.leafLitterPatchBuilder(1, 3))));
        PlaceOnGroundDecorator thickLeafLitter = new PlaceOnGroundDecorator(
                150, 2, 2, Holder.direct(new WeightedStateProvider(VegetationFeatures.leafLitterPatchBuilder(1, 4))));


        WeightedStateProvider twoLeavesProvider = new WeightedStateProvider(
                WeightedList.<BlockState>builder()
                        .add(AppleWoodBlocks.APPLE_LEAVES.defaultBlockState(), 5)
                        .add(AppleWoodBlocks.FRUIT_APPLE_LEAVES.defaultBlockState(), 1)
                        .build()
        );


        Supplier<TreeFeature.Builder> appleTree = () ->
                new TreeFeature.Builder(
                        BlockStateProvider.of(AppleWoodBlocks.APPLE_LOG),
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
                        new TwoLayersFeatureSize(1, 0, 1),
                        belowTrunk);

        context.register(APPLE_TREE_KEY, appleTree.get().decorators(List.of(new BeehiveDecorator(0.1f))).build());
        context.register(APPLE_TREE_LEAF_LITTER_KEY, appleTree.get().decorators(List.of(new BeehiveDecorator(0.1f), sparseLeafLitter, thickLeafLitter)).build());

        Supplier<TreeFeature.Builder> largeAppleTree = () ->
                new TreeFeature.Builder(
                        BlockStateProvider.of(AppleWoodBlocks.APPLE_LOG),
                        new FancyTrunkPlacer(4, 14, 2),
                        twoLeavesProvider,

                        new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                        new TwoLayersFeatureSize(2, 0, 2, OptionalInt.of(4)),
                        belowTrunk);

        context.register(LARGE_APPLE_KEY, largeAppleTree.get().decorators(List.of(new BeehiveDecorator(0.1f))).build());
        context.register(LARGE_APPLE_LEAF_LITTER_KEY, largeAppleTree.get().decorators(List.of(new BeehiveDecorator(0.1f), sparseLeafLitter, thickLeafLitter)).build());



        WeightedStateProvider twoLeavesProvider2 = new WeightedStateProvider(
                WeightedList.<BlockState>builder()
                        .add(AppleWoodBlocks.GOLDEN_APPLE_LEAVES.defaultBlockState(), 8)
                        .add(AppleWoodBlocks.FRUIT_GOLDEN_APPLE_LEAVES.defaultBlockState(), 1)
                        .build()
        );

        Supplier<TreeFeature.Builder> largeGoldenAppleTree = () ->
                new TreeFeature.Builder(
                        BlockStateProvider.of(AppleWoodBlocks.APPLE_LOG),
                        new FancyTrunkPlacer(6, 10, 14),
                        twoLeavesProvider2,

                        new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),
                        new TwoLayersFeatureSize(2, 0, 2, OptionalInt.of(3)),
                        belowTrunk);

        context.register(LARGE_GOLDEN_APPLE_KEY, largeGoldenAppleTree.get().decorators(List.of(new BeehiveDecorator(0.1f))).build());
        context.register(LARGE_GOLDEN_APPLE_LEAF_LITTER_KEY, largeGoldenAppleTree.get().decorators(List.of(new BeehiveDecorator(0.1f), sparseLeafLitter, thickLeafLitter)).build());
    }


    public static ResourceKey<Feature> registryTreeKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
    }

}
