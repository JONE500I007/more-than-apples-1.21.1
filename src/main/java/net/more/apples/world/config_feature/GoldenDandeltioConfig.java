package net.more.apples.world.config_feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.more.apples.MoreThanApples;

public class GoldenDandeltioConfig {
    public static final ResourceKey<Feature> GOLDEN_DANDELION_KEY = registryKey("golden_dandelion_key");

    public static void bootstrap(BootstrapContext<Feature> context) {


//        register(context, GOLDEN_DANDELION_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
//                        BlockStateProvider.of(Blocks.GOLDEN_DANDELION)));

        context.register(GOLDEN_DANDELION_KEY,
                new SimpleBlockFeature(
                        new WeightedStateProvider(
                                WeightedList.<BlockState>builder()
                                        .add(Blocks.POPPY.defaultBlockState(), 2)
                                        .add(Blocks.DANDELION.defaultBlockState(), 2)
                                        .add(Blocks.GOLDEN_DANDELION.defaultBlockState(), 4)
                                        .build())));
    }


    public static ResourceKey<Feature> registryKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
    }
}
