package net.more.apples.world.biome;

import net.minecraft.util.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.world.biome.surface.ModAppleGroveMaterialRules;
import net.more.apples.world.biome.surface.ModGoldenAppleOrchardMaterialRules;
import net.more.apples.world.biome.worldregion.ModAppleGroveRegion;
import net.more.apples.world.biome.worldregion.ModGoldenAppleOrchardRegion;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerraBlenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModAppleGroveRegion(Identifier.of(MoreThanApples.MOD_ID, "overworld"), 6));
        Regions.register(new ModGoldenAppleOrchardRegion(Identifier.of(MoreThanApples.MOD_ID, "overworld"), 6));

        //Regions.register(new ModGoldenAppleOrchardRegion(Identifier.of(MoreThanApples.MOD_ID, "overworld"), 6));
//        Regions.register(new ModOverworldRegion(
//                Identifier.of(MoreThanApples.MOD_ID, "apple_grove"), 4
//        ));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MoreThanApples.MOD_ID, ModAppleGroveMaterialRules.makeRule());
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MoreThanApples.MOD_ID, ModGoldenAppleOrchardMaterialRules.makeRule());
    }
}
