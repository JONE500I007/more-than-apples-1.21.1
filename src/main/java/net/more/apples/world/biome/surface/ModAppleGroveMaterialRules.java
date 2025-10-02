package net.more.apples.world.biome.surface;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.more.apples.block.ModBlocks;
import net.more.apples.block.ModBlocks2;
import net.more.apples.world.biome.worldbiomes.ModBiomesAppleGrove;

public class ModAppleGroveMaterialRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule STONE = makeStateRule(Blocks.STONE);
    private static final MaterialRules.MaterialRule DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);

    private static final MaterialRules.MaterialRule APPLE_BLOCK1 = makeStateRule(ModBlocks2.APPLE_PLANKS);
    private static final MaterialRules.MaterialRule APPLE_BLOCK2 = makeStateRule(ModBlocks.DIAMOND_APPLE_BLOCK);


    public static MaterialRules.MaterialRule makeRule() {
        //MaterialRules.MaterialCondition isAtOrAboveWaterLeave = MaterialRules.water(-1, 0);

        //MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLeave, GRASS_BLOCK), DIRT);

        MaterialRules.MaterialCondition isAppleGrove = MaterialRules.biome(ModBiomesAppleGrove.APPLE_GROVE);

        MaterialRules.MaterialRule appleSurface = MaterialRules.sequence(
                // Grass surface
                MaterialRules.condition(
                        MaterialRules.surface(),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, GRASS_BLOCK)),
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

        // bad version
        /*
        MaterialRules.MaterialRule appleSurface = MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, GRASS_BLOCK),
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, DIRT),
                MaterialRules.condition(MaterialRules.not(MaterialRules.aboveY(YOffset.fixed(0), 0)), DEEPSLATE),
                STONE
        );
        return MaterialRules.sequence(
                MaterialRules.condition(isAppleGrove, appleSurface)
        );
         */


        /*
        return MaterialRules.sequence(
                MaterialRules.condition(
                        MaterialRules.biome(ModBiomesAppleGrove.APPLE_GROVE),
                        MaterialRules.sequence(
                                grassSurface,
                                MaterialRules.condition(MaterialRules.aboveY(YOffset.fixed(60), 0), DIRT),
                                MaterialRules.condition(
                                        MaterialRules.aboveY(YOffset.fixed(0), 0), STONE), DEEPSLATE)));
         */
        /*
        return MaterialRules.sequence(
                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
         */

        /*
        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.biome(ModBiomesAppleGrove.APPLE_GROVE),
                        MaterialRules.sequence(
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, GRASS_BLOCK),
                                MaterialRules.condition(MaterialRules.aboveY(YOffset.fixed(60), 0), DIRT),STONE)));
         */


        //return grassSurface;
        /*
        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.APPLE_GROVE),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, GRASS_BLOCK)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, DEEPSLATE)),


                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
         */

    }



    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
