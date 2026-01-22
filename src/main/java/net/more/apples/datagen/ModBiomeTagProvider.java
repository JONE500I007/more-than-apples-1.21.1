package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.Biome;
import net.more.apples.world.biome.worldbiomes.ModBiomeFrostyApple;
import net.more.apples.world.biome.worldbiomes.ModBiomesAppleGrove;
import net.more.apples.world.biome.worldbiomes.ModBiomesGoldenAppleOrchard;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends FabricTagProvider<Biome> {
    public ModBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BIOME, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD)
                .add(ModBiomesAppleGrove.APPLE_GROVE);

        getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD)
                .add(ModBiomesGoldenAppleOrchard.GOLDEN_APPLE_ORCHARD);

        getOrCreateTagBuilder(BiomeTags.SPAWNS_SNOW_FOXES)
                .add(ModBiomeFrostyApple.FROSTY_APPLE);
        getOrCreateTagBuilder(BiomeTags.SPAWNS_WHITE_RABBITS)
                .add(ModBiomeFrostyApple.FROSTY_APPLE);
        getOrCreateTagBuilder(BiomeTags.IS_OVERWORLD)
                .add(ModBiomeFrostyApple.FROSTY_APPLE);
    }
}
