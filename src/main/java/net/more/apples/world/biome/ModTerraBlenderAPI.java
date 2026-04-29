package net.more.apples.world.biome;

import net.minecraft.resources.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.world.biome.biomes_regions.apple_biome.ModAppleGroveRegion;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class ModTerraBlenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModAppleGroveRegion(Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_grove_region"), 6));
        Regions.register(new ModGoldenAppleOrchardRegion(Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "golden_apple_orchard_region"), 4));
        Regions.register(new ModFrostyAppleRegion(Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_region"), 5));

    }
}
