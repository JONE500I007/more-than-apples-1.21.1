package net.more.apples.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.more.apples.MoreThanApples;

import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_ORE_KEY = registryKey("apple_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_APPLE_ORE_KEY = registryKey("deepslate_apple_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_TREE_KEY = registryKey("apple_tree_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_APPLE_KEY = registryKey("large_apple_key");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_GOLDEN_APPLE_KEY = registryKey("large_golden_apple_key");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TEST_APPLE_TREE_KEY = registryKey("test_apple_tree_key");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FROSTY_APPLE_TREE_KEY = registryKey("frosty_apple_tree_key");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORCHARD_SEAGRASS_KEY = registryKey("orchard_seagrass_key");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLDEN_DANDELION_KEY = registryKey("golden_dandelion_key");

    //OreFeatureConfiguration
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldAppleOre =
                List.of(OreConfiguration.target(stoneReplaceables, ModBlocks2.APPLE_ORE.defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, ModBlocks2.DEEPSLATE_APPLE_ORE.defaultBlockState()));

//WeightedBlockStateProvider
        register(context, APPLE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAppleOre, 9));

        WeightedStateProvider twoLeavesProvider = new WeightedStateProvider(
                WeightedList.<BlockState>builder()
                        .add(ModBlocks2.APPLE_LEAVES.defaultBlockState(), 5)
                        .add(ModBlocks2.FRUIT_APPLE_LEAVES.defaultBlockState(), 1)
                        .build()
        );
        register(context, APPLE_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks2.APPLE_LOG),
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
        ).decorators(List.of(new BeehiveDecorator(0.1f))).build());

        register(context, LARGE_APPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks2.APPLE_LOG),
                new FancyTrunkPlacer(4, 14, 2),
                twoLeavesProvider,

                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(2, 0, 2, OptionalInt.of(4))
        ).decorators(List.of(new BeehiveDecorator(0.1f))).build());


        register(context, TEST_APPLE_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks2.TEST_APPLE_LOG),
                        new TestAppleTrunkPlacer(3, 1, 1),
                        BlockStateProvider.simple(ModBlocks2.TEST_APPLE_LEAVES),
                        new AcaciaFoliagePlacer(
                                ConstantInt.of(0),
                                ConstantInt.of(1)),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .build());

        WeightedStateProvider twoLeavesProvider2 = new WeightedStateProvider(
                WeightedList.<BlockState>builder()
                        .add(ModBlocks2.GOLDEN_APPLE_LEAVES.defaultBlockState(), 8)
                        .add(ModBlocks2.FRUIT_GOLDEN_APPLE_LEAVES.defaultBlockState(), 1)
                        .build()
        );
        register(context, LARGE_GOLDEN_APPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks2.APPLE_LOG),
                new FancyTrunkPlacer(6, 10, 14),
                twoLeavesProvider2,

                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),
                new TwoLayersFeatureSize(2, 0, 2, OptionalInt.of(3))
        ).build());

        register(context, FROSTY_APPLE_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks2.FROSTY_APPLE_LOG),
                new FrostyAppleTrunkPlacer(4, 2, 0),

                BlockStateProvider.simple(ModBlocks2.FROSTY_APPLE_LEAVES),
                new FrostyAppleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 0),
                new TwoLayersFeatureSize(1, 0, 1))
                .build());

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
