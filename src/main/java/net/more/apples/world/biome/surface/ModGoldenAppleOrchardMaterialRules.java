package net.more.apples.world.biome.surface;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.more.apples.world.biome.biomes_regions.golden_apple_orchard_biome.GoldenAppleOrchardBiome;

public class ModGoldenAppleOrchardMaterialRules {
    private static final SurfaceRules.RuleSource GOLD =
            SurfaceRules.state(Blocks.GOLD_BLOCK.defaultBlockState());

    public static SurfaceRules.RuleSource makeRule() {

        SurfaceRules.ConditionSource isAppleGrove =
                SurfaceRules.isBiome(GoldenAppleOrchardBiome.GOLDEN_APPLE_ORCHARD);

        return SurfaceRules.ifTrue(
                isAppleGrove,
                SurfaceRules.sequence(

                        SurfaceRules.ifTrue(
                                SurfaceRules.ON_FLOOR,
                                GOLD
                        ),

                        SurfaceRules.ifTrue(
                                SurfaceRules.UNDER_FLOOR,
                                GOLD
                        ),

                        SurfaceRules.ifTrue(
                                SurfaceRules.not(
                                        SurfaceRules.yBlockCheck(VerticalAnchor.absolute(0), 0)
                                ),
                                GOLD
                        ),

                        GOLD
                )
        );
    }
}
