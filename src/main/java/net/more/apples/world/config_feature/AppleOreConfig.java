package net.more.apples.world.config_feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.BlockReplacement;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.more.apples.MoreThanApples;
import net.more.apples.block.ore_block.ModBlockOre;

import java.util.List;

public class AppleOreConfig {
    public static final ResourceKey<Feature> APPLE_ORE_KEY = registryOreKey("apple_ore");
    public static final ResourceKey<Feature> DEEPSLATE_APPLE_ORE_KEY = registryOreKey("deepslate_apple_ore");

    //OreFeatureConfiguration
    public static void bootstrap(BootstrapContext<Feature> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<BlockReplacement> overworldAppleOre =
                List.of(new BlockReplacement(stoneReplaceables, ModBlockOre.APPLE_ORE.defaultBlockState()),
                        new BlockReplacement(deepslateReplaceables, ModBlockOre.DEEPSLATE_APPLE_ORE.defaultBlockState()));

//WeightedBlockStateProvider
        context.register(APPLE_ORE_KEY, new OreFeature(overworldAppleOre, 9));
    }



    public static ResourceKey<Feature> registryOreKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
    }
}
