package net.more.apples.world.config_feature;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BlockStateProviders;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.more.apples.MoreThanApples;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.world.tree.custom.test_tree.TestAppleTrunkPlacer;

public class TestAppleTreeConfig {
    public static final ResourceKey<Feature> TEST_APPLE_TREE_KEY = registryTreeKey("test_apple_tree_key");

    public static void bootstrap(BootstrapContext<Feature> context) {


        Holder<BlockStateProvider> belowTrunk =
                context.lookup(Registries.BLOCK_STATE_PROVIDER).getOrThrow(BlockStateProviders.SOIL_BENEATH_TREE);

        context.register(TEST_APPLE_TREE_KEY, new TreeFeature.Builder(
                        BlockStateProvider.of(TestAppleWoodBlocks.TEST_APPLE_LOG),
                        new TestAppleTrunkPlacer(3, 1, 1),
                        BlockStateProvider.of(TestAppleWoodBlocks.TEST_APPLE_LEAVES),
                        new AcaciaFoliagePlacer(
                                ConstantInt.of(0),
                                ConstantInt.of(1)),
                        new TwoLayersFeatureSize(1, 0, 1),
                        belowTrunk)
                        .build());
    }


    public static ResourceKey<Feature> registryTreeKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
    }
}
