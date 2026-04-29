package net.more.apples.world.biome.biomes_regions.apple_biome;

import com.ibm.icu.impl.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static net.more.apples.world.biome.biomes_regions.apple_biome.ModBiomesAppleGrove.APPLE_GROVE;

public class ModAppleGroveRegion extends Regions {
    public ModAppleGroveRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }
    /*
    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube,
            RegistryKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(BiomeKeys.FOREST, ModBiomes.APPLE_GROVE);
        });
    }
     */

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        /*
        MultiNoiseUtil.ParameterRange customDepth = MultiNoiseUtil.ParameterRange.of(0.3F, 0.7F);
        MultiNoiseUtil.ParameterRange customTemperature = MultiNoiseUtil.ParameterRange.of(-0.2F, 0.2F);
        MultiNoiseUtil.ParameterRange customweirdness = MultiNoiseUtil.ParameterRange.of(0.1F, 0.7F);
        .depth(customDepth)
         */

        /*
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(MultiNoiseUtil.ParameterRange.of(-0.2F, 0.2F))
                .humidity(MultiNoiseUtil.ParameterRange.of(0.5F, 0.9F))
                .continentalness(MultiNoiseUtil.ParameterRange.of(0.2F, 0.7F))
                .erosion(MultiNoiseUtil.ParameterRange.of(-0.3F, 0.0F))
                .depth(MultiNoiseUtil.ParameterRange.of(0.4F, 0.8F))
                .weirdness(MultiNoiseUtil.ParameterRange.of(-0.1F, 0.3F))
                .build()
                .forEach(point -> builder.add(point, ModBiomesAppleGrove.APPLE_GROVE));
        builder.build().forEach(mapper);
         */

        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.NEUTRAL, ParameterUtils.Temperature.WARM))
                .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.WET))
                .continentalness(ParameterUtils.Continentalness.INLAND, ParameterUtils.Continentalness.MID_INLAND)
                //.erosion(Erosion.EROSION_5, Erosion.EROSION_6)
                //.erosion(Erosion.span(Erosion.EROSION_0, Erosion.EROSION_3))
                //.erosion(ParameterUtils.Erosion.span(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_4))
                .erosion(ParameterUtils.Erosion.EROSION_5, ParameterUtils.Erosion.EROSION_6)
                //.depth(Depth.FLOOR)
                // -values = surface/above ground
                // +values = basement, floor maybe
                //.depth(MultiNoiseUtil.ParameterRange.of(-0.5F, 0.0F)) maybe use this
                .depth(Climate.Parameter.span(-1.0F, 1.0F))
                .weirdness(ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING, ParameterUtils.Weirdness.LOW_SLICE_NORMAL_DESCENDING)
                .build().forEach(point -> builder.add(point, APPLE_GROVE));

        builder.build().forEach(mapper);
    }
}
