package net.more.apples.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static net.more.apples.world.biome.ModBiomes.APPLE_GROVE;
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

        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.NEUTRAL, Temperature.HOT))
                .humidity(Humidity.span(Humidity.ARID, Humidity.DRY))
                .continentalness(Continentalness.INLAND)
                .erosion(Erosion.EROSION_0, Erosion.EROSION_1)
                .depth(Depth.SURFACE, Depth.FLOOR)
                .weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING)
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
//Depth.SHALLOW   บริเวณตื้น
//Depth.DEEP      บริเวณลึก

// idk wtf is it
//Weirdness.MID_SLICE_NORMAL_ASCENDING
//Weirdness.MID_SLICE_NORMAL_DESCENDING
//Weirdness.HIGH_SLICE_VARIANT_ASCENDING
//Weirdness.HIGH_SLICE_VARIANT_DESCENDING
//Weirdness.LOW_SLICE_VARIANT_ASCENDING
//Weirdness.LOW_SLICE_VARIANT_DESCENDING
//Weirdness.VALLEY
