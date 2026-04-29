package net.more.apples.datagen.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends FabricTagsProvider<Biome> {
    public ModBiomeTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.BIOME, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        builder(BiomeTags.IS_OVERWORLD)
                .add(ModBiomesAppleGrove.APPLE_GROVE);

        builder(BiomeTags.IS_OVERWORLD)
                .add(ModBiomesGoldenAppleOrchard.GOLDEN_APPLE_ORCHARD);

        builder(BiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS)
                .add(ModBiomeFrostyApple.FROSTY_APPLE);
        builder(BiomeTags.SPAWNS_SNOW_FOXES)
                .add(ModBiomeFrostyApple.FROSTY_APPLE);
        builder(BiomeTags.SPAWNS_WHITE_RABBITS)
                .add(ModBiomeFrostyApple.FROSTY_APPLE);
        builder(BiomeTags.IS_OVERWORLD)
                .add(ModBiomeFrostyApple.FROSTY_APPLE);
    }
}
