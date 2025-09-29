package net.more.apples.world.biome;

import net.minecraft.util.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.world.biome.surface.ModMaterialRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerraBlenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(Identifier.of(MoreThanApples.MOD_ID, "overworld"), 6));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MoreThanApples.MOD_ID, ModMaterialRules.makeRule());
    }
}
