package net.more.apples.world;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.foliage.MegaPineFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.more.apples.MoreThanApples;
import net.more.apples.block.ModBlocks2;

import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> APPLE_ORE_KEY = registryKey("apple_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEEPSLATE_APPLE_ORE_KEY = registryKey("deepslate_apple_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> APPLE_TREE_KEY = registryKey("apple_tree_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LARGE_APPLE_KEY = registryKey("large_apple_key");


    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldAppleOre =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks2.APPLE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks2.DEEPSLATE_APPLE_ORE.getDefaultState()));


        register(context, APPLE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldAppleOre, 12));



//        register(context, APPLE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
//                BlockStateProvider.of(ModBlocks2.APPLE_LOG),
//                new StraightTrunkPlacer(4, 2, 0), // trunk height = oak
//
//                BlockStateProvider.of(ModBlocks2.APPLE_LEAVES),
//                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3), // foliage = oak
//
//                new TwoLayersFeatureSize(1, 0, 1) // size = oak
//        ).build());

        /*
        WeightedBlockStateProvider twoLeavesProvider = new WeightedBlockStateProvider(
                DataPool.<BlockState>builder()
                        .add(ModBlocks2.APPLE_LEAVES.getDefaultState(), 4)
                        .add(ModBlocks2.FRUIT_APPLE_LEAVES.getDefaultState(), 2)
                        .build()
        );
        register(context, APPLE_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks2.APPLE_LOG),
                new StraightTrunkPlacer(4, 2, 0),
                twoLeavesProvider,
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),

                new TwoLayersFeatureSize(1, 0, 1)
        ).build());
         */

        WeightedBlockStateProvider twoLeavesProvider = new WeightedBlockStateProvider(
                DataPool.<BlockState>builder()
                        .add(ModBlocks2.APPLE_LEAVES.getDefaultState(), 4)
                        .add(ModBlocks2.FRUIT_APPLE_LEAVES.getDefaultState(), 1)
                        .build()
        );
        register(context, APPLE_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks2.APPLE_LOG),
                // 3 baseHeight 11 firstRandomHeight 0 secondRandomHeight
                new StraightTrunkPlacer(4, 2, 0),
                twoLeavesProvider,
                // radius = 2, offset = 0, bush height = 3
                //radius = 2 leaves radius -> around the trunk, the leaves are spread out 2 blocks wide
                //offset = 4 Height offset of leaf bush from trunk top ->
                // leaves will start to emerge 4 blocks below trunk top
                // foliage height = leaves layer height, leaves bush will be ~4 blocks high
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                // layer size maybe idk for now
                // 0 limit 0 lowerSize 0 upperSize, and 4 minClippedHeight
                // limit= maybe starting point for the change from lower size -> upper size
                // lowerSize = thickness of the bottom layer, bottommost leaf
                // upperSize = thickness of the top layer, top layer
                new TwoLayersFeatureSize(1, 0, 1)
        ).build());

        register(context, LARGE_APPLE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks2.APPLE_LOG),
                new LargeOakTrunkPlacer(4, 14, 2),
                twoLeavesProvider,

                new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(2, 0, 2, OptionalInt.of(4))
        ).build());

    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MoreThanApples.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
