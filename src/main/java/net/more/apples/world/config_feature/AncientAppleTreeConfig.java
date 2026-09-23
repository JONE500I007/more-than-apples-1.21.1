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
import net.more.apples.world.placed_feature.custom.AncientAppleTreeFeature;
import net.more.apples.world.tree.custom.ancient_apple.AncientAppleFoliagePlacer;
import net.more.apples.world.tree.custom.ancient_apple.AncientAppleTrunkPlacer;

import java.util.OptionalInt;

public class AncientAppleTreeConfig {

    public static final ResourceKey<Feature> ANCIENT_APPLE_KEY = registryTreeKey("ancient_apple_key");

    public static final ResourceKey<Feature> ANCIENT_APPLE_KEY2 = registryTreeKey("ancient_apple_key2");

    public static void bootstrap(BootstrapContext<Feature> context) {


        Holder<BlockStateProvider> belowTrunk =
                context.lookup(Registries.BLOCK_STATE_PROVIDER).getOrThrow(BlockStateProviders.SOIL_BENEATH_TREE);

        context.register(ANCIENT_APPLE_KEY2, new TreeFeature.Builder(
                BlockStateProvider.of(AncientAppleWoodBlocks.ANCIENT_APPLE_LOG),
                new AncientAppleTrunkPlacer(30, 8, 7),

                BlockStateProvider.of(AncientAppleWoodBlocks.ANCIENT_APPLE_LEAVES),
                new AncientAppleFoliagePlacer(ConstantInt.of(4), ConstantInt.of(4), 6),
                new TwoLayersFeatureSize(7, 3, 7, OptionalInt.of(32)),
                belowTrunk)
                .build());

        context.register(ANCIENT_APPLE_KEY, new AncientAppleTreeFeature());

    }



    public static ResourceKey<Feature> registryTreeKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
    }
}
