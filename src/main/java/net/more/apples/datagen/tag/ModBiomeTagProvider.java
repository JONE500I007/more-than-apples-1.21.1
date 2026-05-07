package net.more.apples.datagen.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.more.apples.world.biome.biomes_regions.apple_biome.AppleGroveBiome;
import net.more.apples.world.biome.biomes_regions.frosty_apple_biome.FrostyAppleBiome;
import net.more.apples.world.biome.biomes_regions.golden_apple_orchard_biome.GoldenAppleOrchardBiome;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends FabricTagsProvider<Biome> {
    public ModBiomeTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.BIOME, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        builder(BiomeTags.IS_OVERWORLD)
                .add(AppleGroveBiome.APPLE_GROVE);

        builder(BiomeTags.IS_OVERWORLD)
                .add(GoldenAppleOrchardBiome.GOLDEN_APPLE_ORCHARD);

        builder(BiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS)
                .add(FrostyAppleBiome.FROSTY_APPLE);
        builder(BiomeTags.SPAWNS_SNOW_FOXES)
                .add(FrostyAppleBiome.FROSTY_APPLE);
        builder(BiomeTags.SPAWNS_WHITE_RABBITS)
                .add(FrostyAppleBiome.FROSTY_APPLE);
        builder(BiomeTags.IS_OVERWORLD)
                .add(FrostyAppleBiome.FROSTY_APPLE);
    }
}
