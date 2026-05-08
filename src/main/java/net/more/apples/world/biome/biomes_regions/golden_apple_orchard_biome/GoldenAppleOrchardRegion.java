package net.more.apples.world.biome.biomes_regions.golden_apple_orchard_biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils.*;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static net.more.apples.world.biome.biomes_regions.golden_apple_orchard_biome.GoldenAppleOrchardBiome.GOLDEN_APPLE_ORCHARD;

public class GoldenAppleOrchardRegion extends Region{
    public GoldenAppleOrchardRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.NEUTRAL, Temperature.WARM))
                .humidity(Humidity.span(Humidity.NEUTRAL, Humidity.WET))
                .continentalness(Continentalness.MID_INLAND, Continentalness.INLAND)
                .erosion(Erosion.EROSION_5, Erosion.EROSION_6)
                .depth(Climate.Parameter.span(-1.0F, 1.0F))
                .weirdness(Weirdness.MID_SLICE_NORMAL_DESCENDING, Weirdness.LOW_SLICE_NORMAL_DESCENDING)
                .build().forEach(point -> builder.add(point, GOLDEN_APPLE_ORCHARD));

        builder.build().forEach(mapper);
    }
}
