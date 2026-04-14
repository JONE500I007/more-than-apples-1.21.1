package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;

import java.util.concurrent.CompletableFuture;

public class ModRegistryDataGenerator extends FabricDynamicRegistryProvider {

    public ModRegistryDataGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider wrapperLookup, Entries entries) {
        entries.addAll(wrapperLookup.lookupOrThrow(Registries.CONFIGURED_FEATURE));
        entries.addAll(wrapperLookup.lookupOrThrow(Registries.PLACED_FEATURE));
        entries.addAll(wrapperLookup.lookupOrThrow(Registries.BIOME));
    }

    @Override
    public String getName() {
        return "MoreThanApples Registry Data Generator";
    }
}
