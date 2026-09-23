package net.more.apples.world.biome.surface;

import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.material.MaterialRules;
import net.minecraft.world.level.levelgen.material.condition.MaterialCondition;
import net.minecraft.world.level.levelgen.material.rule.MaterialRule;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.more.apples.world.biome.biomes_regions.golden_apple_orchard_biome.GoldenAppleOrchardBiome;

public class ModGoldenAppleOrchardMaterialRules {
    private static final MaterialRule GOLD =
            MaterialRules.state(Blocks.GOLD_BLOCK.defaultBlockState());

    public static MaterialRule makeRule(HolderGetter<Biome> biomeLookup) {

        MaterialCondition isAppleGrove =
                MaterialRules.isBiome(biomeLookup, GoldenAppleOrchardBiome.GOLDEN_APPLE_ORCHARD);

        return MaterialRules.ifTrue(
                isAppleGrove,
                MaterialRules.sequence(

                        MaterialRules.ifTrue(
                                MaterialRules.stoneDepthCheck(0, false, CaveSurface.FLOOR),
                                GOLD
                        ),

                        MaterialRules.ifTrue(
                                MaterialRules.stoneDepthCheck(0, true, CaveSurface.FLOOR),
                                GOLD
                        ),

                        MaterialRules.ifTrue(
                                MaterialRules.not(
                                        MaterialRules.yBlockCheck(VerticalAnchor.absolute(0), 0)
                                ),
                                GOLD
                        ),

                        GOLD
                )
        );
    }
}
