package net.more.apples.world.biome.surface;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.more.apples.block.ModBlocks;
import net.more.apples.block.ModBlocks2;
import net.more.apples.world.biome.worldbiomes.ModBiomesAppleGrove;
import net.more.apples.world.biome.worldbiomes.ModBiomesGoldenAppleOrchard;

public class ModGoldenAppleOrchardMaterialRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule STONE = makeStateRule(Blocks.STONE);
    private static final MaterialRules.MaterialRule DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final MaterialRules.MaterialRule SAND_BLOCK = makeStateRule(Blocks.SAND);


    public static MaterialRules.MaterialRule makeRule() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        //MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLeavel, GRASS_BLOCK), DIRT);

        MaterialRules.MaterialCondition isAppleGrove = MaterialRules.biome(ModBiomesGoldenAppleOrchard.GOLDEN_APPLE_ORCHARD);

        MaterialRules.MaterialRule appleSurface = MaterialRules.sequence(
                // Grass surface
                MaterialRules.condition(
                        MaterialRules.surface(),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,
                                MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK))),

//                MaterialRules.condition(
//                        MaterialRules.surface(),
//                        MaterialRules.condition(
//                                MaterialRules.STONE_DEPTH_FLOOR,
//                                MaterialRules.condition(
//                                        MaterialRules.not(isAtOrAboveWaterLevel), SAND_BLOCK
//                                )
//                        )
//                ),

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
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
