package net.more.apples.world.biome.surface;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseChunk;
import net.more.apples.block.ModBlocks;
import net.more.apples.block.ModBlocks2;
import net.more.apples.world.biome.worldbiomes.ModBiomesAppleGrove;

public class ModAppleGroveMaterialRules {
    private static final NoiseChunk.BlockStateFiller DIRT = makeStateRule(Blocks.DIRT);
    private static final NoiseChunk.BlockStateFiller GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final NoiseChunk.BlockStateFiller STONE = makeStateRule(Blocks.STONE);
    private static final NoiseChunk.BlockStateFiller DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);

    private static final NoiseChunk.BlockStateFiller APPLE_BLOCK1 = makeStateRule(ModBlocks2.APPLE_PLANKS);
    private static final NoiseChunk.BlockStateFiller APPLE_BLOCK2 = makeStateRule(ModBlocks.DIAMOND_APPLE_BLOCK);


    public static NoiseChunk.BlockStateFiller makeRule() {
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
        return (context) -> {
            int y = context.blockY();
            if (y < 0) {
                return Blocks.DEEPSLATE.defaultBlockState();
            }
            if (y > 60) {
                return Blocks.GRASS_BLOCK.defaultBlockState();
            }
            if (y > 55) {
                return Blocks.DIRT.defaultBlockState();
            }
            return Blocks.STONE.defaultBlockState();
        };
    }

    private static NoiseChunk.BlockStateFiller makeStateRule(Block block) {
        return (context) -> block.defaultBlockState();
    }
}
