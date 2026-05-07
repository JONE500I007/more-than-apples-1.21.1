package net.more.apples.world.config_feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.more.apples.MoreThanApples;
import net.more.apples.block.ore_block.ModBlockOre;

import java.util.List;

public class AppleOreConfig {
    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_ORE_KEY = registryOreKey("apple_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_APPLE_ORE_KEY = registryOreKey("deepslate_apple_ore");

    //OreFeatureConfiguration
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldAppleOre =
                List.of(OreConfiguration.target(stoneReplaceables, ModBlockOre.APPLE_ORE.defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables, ModBlockOre.DEEPSLATE_APPLE_ORE.defaultBlockState()));

//WeightedBlockStateProvider
        registerOreConfig(context, APPLE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAppleOre, 9));
    }



    public static ResourceKey<ConfiguredFeature<?, ?>> registryOreKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void registerOreConfig(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
