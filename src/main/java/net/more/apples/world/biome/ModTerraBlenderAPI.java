package net.more.apples.world.biome;

import net.minecraft.resources.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.world.biome.biomes_regions.apple_biome.AppleGroveRegion;
import net.more.apples.world.biome.biomes_regions.frosty_apple_biome.FrostyAppleRegion;
import net.more.apples.world.biome.biomes_regions.golden_apple_orchard_biome.GoldenAppleOrchardRegion;
import net.more.apples.world.biome.surface.ModAppleGroveMaterialRules;
import net.more.apples.world.biome.surface.ModFrostyAppleMaterialRules;
import net.more.apples.world.biome.surface.ModGoldenAppleOrchardMaterialRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerraBlenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new AppleGroveRegion(Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_grove_region"), 6));
        Regions.register(new GoldenAppleOrchardRegion(Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "golden_apple_orchard_region"), 4));
        Regions.register(new FrostyAppleRegion(Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_region"), 4));

        //SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MoreThanApples.MOD_ID, ModAppleGroveMaterialRules.makeRule());
        //SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MoreThanApples.MOD_ID, ModGoldenAppleOrchardMaterialRules.makeRule());
        //SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MoreThanApples.MOD_ID, ModFrostyAppleMaterialRules.makeRule());
    }
}
