package net.more.apples.world.biome.surface;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;

public class ModAppleGroveMaterialRules {
    /*
    private static final NoiseChunk.BlockStateFiller GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final NoiseChunk.BlockStateFiller STONE = makeStateRule(Blocks.STONE);
    private static final NoiseChunk.BlockStateFiller DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);

    private static final NoiseChunk.BlockStateFiller APPLE_BLOCK1 = makeStateRule(ModBlocks2.APPLE_PLANKS);
    private static final NoiseChunk.BlockStateFiller APPLE_BLOCK2 = makeStateRule(ModBlocks.DIAMOND_APPLE_BLOCK);
     */
    private static final SurfaceRules.RuleSource DIRT = SurfaceRules.state(Blocks.DIRT.defaultBlockState());
    private static final SurfaceRules.RuleSource GRASS_BLOCK = SurfaceRules.state(Blocks.GRASS_BLOCK.defaultBlockState());
    private static final SurfaceRules.RuleSource STONE = SurfaceRules.state(Blocks.STONE.defaultBlockState());
    private static final SurfaceRules.RuleSource DEEPSLATE = SurfaceRules.state(Blocks.DEEPSLATE.defaultBlockState());

    private static final SurfaceRules.RuleSource APPLE_BLOCK1 = SurfaceRules.state(AppleWoodBlocks.APPLE_PLANKS.defaultBlockState());
    private static final SurfaceRules.RuleSource APPLE_BLOCK2 = SurfaceRules.state(AppleWoodBlocks.APPLE_WOOD.defaultBlockState());


    //public static NoiseChunk.BlockStateFiller makeRule() {
    public static SurfaceRules.RuleSource makeRule() {
        /*
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        //MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLeave, GRASS_BLOCK), DIRT);

        MaterialRules.MaterialCondition isAppleGrove = MaterialRules.biome(ModBiomesAppleGrove.APPLE_GROVE);

        MaterialRules.MaterialRule appleSurface = MaterialRules.sequence(
                // Grass surface
                MaterialRules.condition(
                        MaterialRules.surface(),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,
                                MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK))),
                // Dirt just below surface
                MaterialRules.condition(
                        MaterialRules.surface(),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, DIRT)),
                // Deepslate below Y=0
                MaterialRules.condition(
                        MaterialRules.not(MaterialRules.aboveY(YOffset.fixed(0), 0)),
                        DEEPSLATE),
                // Else fallback stone
                STONE);

        return MaterialRules.sequence(
                MaterialRules.condition(isAppleGrove, appleSurface)
        );
         */
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

    //    private static NoiseChunk.BlockStateFiller makeStateRule(Block block) {
//        return (context) -> block.defaultBlockState();
//    }
    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
