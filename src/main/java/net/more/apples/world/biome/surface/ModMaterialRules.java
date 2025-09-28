package net.more.apples.world.biome.surface;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.more.apples.block.ModBlocks;
import net.more.apples.block.ModBlocks2;
import net.more.apples.world.biome.ModBiomes;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);

    private static final MaterialRules.MaterialRule APPLE_BLOCK1 = makeStateRule(ModBlocks2.APPLE_PLANKS);
    private static final MaterialRules.MaterialRule APPLE_BLOCK2 = makeStateRule(ModBlocks.DIAMOND_APPLE_BLOCK);


    public static MaterialRules.MaterialRule makeRule() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLeave = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLeave, GRASS_BLOCK), DIRT);

        return grassSurface;

        /*
        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.APPLE_GROVE),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, APPLE_BLOCK1)),

                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface))
        );
         */
    }
    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
