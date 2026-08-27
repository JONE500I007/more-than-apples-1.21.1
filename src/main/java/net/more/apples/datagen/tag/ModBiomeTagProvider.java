package net.more.apples.datagen.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.more.apples.MoreThanApples;
import net.more.apples.world.biome.biomes_regions.ancient_apple.AncientAppleBiome;
import net.more.apples.world.biome.biomes_regions.apple_biome.AppleGroveBiome;
import net.more.apples.world.biome.biomes_regions.frosty_apple_biome.FrostyAppleBiome;
import net.more.apples.world.biome.biomes_regions.golden_apple_orchard_biome.GoldenAppleOrchardBiome;
import net.more.apples.world.biome.biomes_regions.scorched_apple.ScorchedAppleBiome;

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

        builder(BiomeTags.IS_OVERWORLD)
                .add(AncientAppleBiome.ANCIENT_APPLE_WILDS);

        builder(BiomeTags.IS_OVERWORLD)
                .add(ScorchedAppleBiome.SCORCHED_APPLE_BADLANDS);

        builder(BiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS)
                .add(FrostyAppleBiome.FROSTY_APPLE);
        builder(BiomeTags.SPAWNS_SNOW_FOXES)
                .add(FrostyAppleBiome.FROSTY_APPLE);
        builder(BiomeTags.SPAWNS_WHITE_RABBITS)
                .add(FrostyAppleBiome.FROSTY_APPLE);
        builder(BiomeTags.IS_OVERWORLD)
                .add(FrostyAppleBiome.FROSTY_APPLE);


        builder(BiomeTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS)
                .add(FrostyAppleBiome.FROSTY_APPLE);
        builder(BiomeTags.SPAWNS_SNOW_FOXES)
                .add(FrostyAppleBiome.FROSTY_APPLE);
        builder(BiomeTags.SPAWNS_WHITE_RABBITS)
                .add(FrostyAppleBiome.FROSTY_APPLE);


        builder(TagKey.create(Registries.BIOME,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                        "has_structure/just_test")))
                .add(GoldenAppleOrchardBiome.GOLDEN_APPLE_ORCHARD);

        builder(TagKey.create(Registries.BIOME,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                        "has_structure/test_dungeon")))
                .add(GoldenAppleOrchardBiome.GOLDEN_APPLE_ORCHARD);

        builder(TagKey.create(Registries.BIOME,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                        "has_structure/dng_room")))
                .add(Biomes.PLAINS)
                .add(Biomes.FOREST)
                .add(Biomes.DESERT)
                .add(Biomes.SAVANNA)
                .add(Biomes.MEADOW);

        builder(TagKey.create(Registries.BIOME,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                        "has_structure/tower_room")))
                .add(Biomes.PLAINS)
                .add(Biomes.FOREST)
                .add(Biomes.DESERT)
                .add(Biomes.SAVANNA)
                .add(Biomes.MEADOW);

        builder(TagKey.create(Registries.BIOME,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                        "has_structure/badlands_hideout")))
                .add(Biomes.BADLANDS)
                .add(Biomes.ERODED_BADLANDS)
                .add(Biomes.WOODED_BADLANDS);
    }
}
