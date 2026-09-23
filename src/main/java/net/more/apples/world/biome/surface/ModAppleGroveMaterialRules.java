package net.more.apples.world.biome.surface;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.material.MaterialRules;
import net.minecraft.world.level.levelgen.material.condition.MaterialCondition;
import net.minecraft.world.level.levelgen.material.rule.MaterialRule;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class ModAppleGroveMaterialRules {
    /*
    private static final NoiseChunk.BlockStateFiller GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final NoiseChunk.BlockStateFiller STONE = makeStateRule(Blocks.STONE);
    private static final NoiseChunk.BlockStateFiller DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);

    private static final NoiseChunk.BlockStateFiller APPLE_BLOCK1 = makeStateRule(ModBlocks2.APPLE_PLANKS);
    private static final NoiseChunk.BlockStateFiller APPLE_BLOCK2 = makeStateRule(ModBlocks.DIAMOND_APPLE_BLOCK);
     */
    private static final MaterialRule DIRT = MaterialRules.state(Blocks.DIRT.defaultBlockState());
    private static final MaterialRule GRASS_BLOCK = MaterialRules.state(Blocks.GRASS_BLOCK.defaultBlockState());
    private static final MaterialRule STONE = MaterialRules.state(Blocks.STONE.defaultBlockState());
    private static final MaterialRule DEEPSLATE = MaterialRules.state(Blocks.DEEPSLATE.defaultBlockState());

    //private static final MaterialRule APPLE_BLOCK1 = MaterialRules.state(AppleWoodBlocks.APPLE_PLANKS.defaultBlockState());
    //private static final MaterialRule APPLE_BLOCK2 = MaterialRules.state(AppleWoodBlocks.APPLE_WOOD.defaultBlockState());


    //public static NoiseChunk.BlockStateFiller makeRule() {
    public static MaterialRule makeRule() {
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
        return MaterialRules.sequence(
                MaterialRules.ifTrue(
                        MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR),
                        MaterialRules.state(Blocks.GRASS_BLOCK.defaultBlockState())
                ),

                MaterialRules.ifTrue(
                        MaterialRules.stoneDepthCheck(0, true, CaveSurface.FLOOR),
                        MaterialRules.state(Blocks.DIRT.defaultBlockState())
                ),

                MaterialRules.ifTrue(
                        MaterialRules.verticalGradient("deepslate",
                                VerticalAnchor.bottom(),
                                VerticalAnchor.absolute(0)),
                        MaterialRules.state(Blocks.DEEPSLATE.defaultBlockState())
                ),

                MaterialRules.state(Blocks.STONE.defaultBlockState())
        );
    }

    //    private static NoiseChunk.BlockStateFiller makeStateRule(Block block) {
//        return (context) -> block.defaultBlockState();
//    }
    private static MaterialRule makeStateRule(Block block) {
        return MaterialRules.state(block.defaultBlockState());
    }
}
