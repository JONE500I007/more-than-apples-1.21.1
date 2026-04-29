package net.more.apples.world.biome.surface;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class ModGoldenAppleOrchardMaterialRules {
    private static final SurfaceRules.RuleSource GOLD =
            SurfaceRules.state(Blocks.GOLD_BLOCK.defaultBlockState());

    public static SurfaceRules.RuleSource makeRule() {

        SurfaceRules.ConditionSource isAppleGrove =
                SurfaceRules.isBiome(ModBiomesGoldenAppleOrchard.GOLDEN_APPLE_ORCHARD);

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
