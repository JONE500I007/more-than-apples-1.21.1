package net.more.apples.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static net.more.apples.world.biome.ModBiomesAppleGrove.APPLE_GROVE;
import static terrablender.api.ParameterUtils.*;

public class ModOverworldRegion extends Region {
    public ModOverworldRegion(Identifier name, int weight) {
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
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube,
            RegistryKey<Biome>>> mapper) {
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


        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.NEUTRAL, Temperature.WARM))
                .humidity(Humidity.span(Humidity.NEUTRAL, Humidity.WET))
                .continentalness(Continentalness.INLAND, Continentalness.MID_INLAND)
                //.erosion(Erosion.EROSION_5, Erosion.EROSION_6)
                //.erosion(Erosion.span(Erosion.EROSION_0, Erosion.EROSION_3))
                //.erosion(ParameterUtils.Erosion.span(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_4))
                .erosion(Erosion.EROSION_6)
                //.depth(Depth.FLOOR)
                // -values = surface/above ground
                // +values = basement, floor maybe
                //.depth(MultiNoiseUtil.ParameterRange.of(-0.5F, 0.0F)) maybe use this
                .depth(MultiNoiseUtil.ParameterRange.of(-1.0F, 1.0F))
                .weirdness(Weirdness.MID_SLICE_NORMAL_DESCENDING, Weirdness.LOW_SLICE_VARIANT_ASCENDING)
                .build().forEach(point -> builder.add(point, APPLE_GROVE));

        builder.build().forEach(mapper);
    }
}

//อุณหภูมิ
//    Temperature.FROZEN
//    Temperature.COLD
//    Temperature.COOL
//    Temperature.NEUTRAL
//    Temperature.WARM
//    Temperature.HOT
//ความชื้น
//    Humidity.ARID
//    Humidity.DRY
//    Humidity.NEUTRAL
//    Humidity.WET
//    Humidity.HUMID
//ใกล้ทะเลหรือใจกลางแผ่นดิน
//    Continentalness.COAST
//    Continentalness.NEAR_INLAND
//    Continentalness.MID_INLAND
//    Continentalness.FAR_INLAND
//    Continentalness.INLAND
//ความขรุขระของ biome
//Erosion.EROSION_0
//Erosion.EROSION_1
//Erosion.EROSION_2
//Erosion.EROSION_3
//Erosion.EROSION_4
//Erosion.EROSION_5
//Erosion.EROSION_6
//ความสูง/ระดับโลก
//Depth.SURFACE   บนผิวโลก
//Depth.FLOOR     ต่ำกว่าระดับพื้น
//Depth.UNDERGROUND ใต้ดิน
//Depth.FULL_RANGE น่าจะทั้งบนสุดยันลงสุด

// idk wtf is it
//Weirdness.MID_SLICE_NORMAL_ASCENDING
//Weirdness.MID_SLICE_NORMAL_DESCENDING
//Weirdness.HIGH_SLICE_VARIANT_ASCENDING
//Weirdness.HIGH_SLICE_VARIANT_DESCENDING
//Weirdness.LOW_SLICE_VARIANT_ASCENDING
//Weirdness.LOW_SLICE_VARIANT_DESCENDING
//Weirdness.VALLEY

//MID_SLICE_NORMAL_ASCENDING   (-1.0F, -0.9333F),
//HIGH_SLICE_NORMAL_ASCENDING  (-0.9333F, -0.7666F),
//PEAK_NORMAL                  (-0.7666F, -0.5666F),
//HIGH_SLICE_NORMAL_DESCENDING (-0.5666F, -0.4F),
//MID_SLICE_NORMAL_DESCENDING  (-0.4F, -0.2666F),
//LOW_SLICE_NORMAL_DESCENDING  (-0.2666F, -0.05F),
//VALLEY                       (-0.05F, 0.05F),
//LOW_SLICE_VARIANT_ASCENDING  (0.05F, 0.2666F),
//MID_SLICE_VARIANT_ASCENDING  (0.2666F, 0.4F),
//HIGH_SLICE_VARIANT_ASCENDING (0.4F, 0.5666F),
//PEAK_VARIANT                 (0.5666F, 0.7666F),
//HIGH_SLICE_VARIANT_DESCENDING(0.7666F, 0.9333F),
//MID_SLICE_VARIANT_DESCENDING (0.9333F, 1.0F),
//FULL_RANGE                   (-1.0F, 1.0F);
