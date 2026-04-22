package net.more.apples.world.biome.surface;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.more.apples.block.ModBlocks;
import net.more.apples.block.ModBlocks2;
import net.more.apples.world.biome.worldbiomes.ModBiomesAppleGrove;
import net.more.apples.world.biome.worldbiomes.ModBiomesGoldenAppleOrchard;

public class ModGoldenAppleOrchardMaterialRules {
    private static final SurfaceRules.RuleSource DIRT = SurfaceRules.state(Blocks.DIRT.defaultBlockState());
    private static final SurfaceRules.RuleSource GRASS_BLOCK = SurfaceRules.state(Blocks.GRASS_BLOCK.defaultBlockState());
    private static final SurfaceRules.RuleSource STONE = SurfaceRules.state(Blocks.STONE.defaultBlockState());
    private static final SurfaceRules.RuleSource DEEPSLATE = SurfaceRules.state(Blocks.DEEPSLATE.defaultBlockState());

    private static final SurfaceRules.RuleSource APPLE_BLOCK1 = SurfaceRules.state(ModBlocks2.APPLE_PLANKS.defaultBlockState());
    private static final SurfaceRules.RuleSource APPLE_BLOCK2 = SurfaceRules.state(ModBlocks.DIAMOND_APPLE_BLOCK.defaultBlockState());


    public static SurfaceRules.RuleSource makeRule() {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.ON_FLOOR,
                        SurfaceRules.state(Blocks.GRASS_BLOCK.defaultBlockState())
                ),

                SurfaceRules.ifTrue(
                        SurfaceRules.UNDER_FLOOR,
                        SurfaceRules.state(Blocks.DIRT.defaultBlockState())
                ),

                SurfaceRules.ifTrue(
                        SurfaceRules.verticalGradient("deepslate",
                                VerticalAnchor.bottom(),
                                VerticalAnchor.absolute(0)),
                        SurfaceRules.state(Blocks.DEEPSLATE.defaultBlockState())
                ),

                SurfaceRules.state(Blocks.STONE.defaultBlockState())
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
