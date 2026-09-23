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
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.more.apples.MoreThanApples;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.world.tree.custom.frosty_tree.FrostyAppleFoliagePlacer;
import net.more.apples.world.tree.custom.frosty_tree.FrostyAppleTrunkPlacer;

public class FrostyTreeConfig {
    public static final ResourceKey<Feature> FROSTY_APPLE_TREE_KEY = registryTreeKey("frosty_apple_tree_key");

    public static void bootstrap(BootstrapContext<Feature> context) {


        Holder<BlockStateProvider> belowTrunk =
                context.lookup(Registries.BLOCK_STATE_PROVIDER).getOrThrow(BlockStateProviders.SOIL_BENEATH_TREE);

        context.register(FROSTY_APPLE_TREE_KEY, new TreeFeature.Builder(
                BlockStateProvider.of(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG),
                new FrostyAppleTrunkPlacer(4, 2, 0),

                BlockStateProvider.of(FrostyAppleWoodBlocks.FROSTY_APPLE_LEAVES),
                new FrostyAppleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 0),
                new TwoLayersFeatureSize(1, 0, 1),
                belowTrunk)
                .build());
    }


    public static ResourceKey<Feature> registryTreeKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
    }
}
