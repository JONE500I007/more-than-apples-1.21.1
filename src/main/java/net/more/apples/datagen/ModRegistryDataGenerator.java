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


        entries.addAll(wrapperLookup.lookupOrThrow(Registries.STRUCTURE));
        entries.addAll(wrapperLookup.lookupOrThrow(Registries.STRUCTURE_SET));
        entries.addAll(wrapperLookup.lookupOrThrow(Registries.TEMPLATE_POOL));

        entries.addAll(wrapperLookup.lookupOrThrow(Registries.VILLAGER_TRADE));
        entries.addAll(wrapperLookup.lookupOrThrow(Registries.TRADE_SET));
    }

    @Override
    public String getName() {
        return "MoreThanApples Registry Data Generator";
    }
}
