package net.more.apples.world.biome.worldregion;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.more.apples.world.biome.worldbiomes.ModBiomesGoldenAppleOrchard;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static net.more.apples.world.biome.worldbiomes.ModBiomesAppleGrove.APPLE_GROVE;
import static net.more.apples.world.biome.worldbiomes.ModBiomesGoldenAppleOrchard.GOLDEN_APPLE_ORCHARD;
import static terrablender.api.ParameterUtils.*;

public class ModGoldenAppleOrchardRegion extends Region {
    public ModGoldenAppleOrchardRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube,
            RegistryKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.NEUTRAL, Temperature.WARM))
                .humidity(Humidity.span(Humidity.NEUTRAL, Humidity.WET))
                .continentalness(Continentalness.INLAND, Continentalness.MID_INLAND)
                .erosion(Erosion.EROSION_5, Erosion.EROSION_6)
                .depth(MultiNoiseUtil.ParameterRange.of(-1.0F, 1.0F))
                .weirdness(Weirdness.MID_SLICE_NORMAL_DESCENDING, Weirdness.LOW_SLICE_NORMAL_DESCENDING)
                .build().forEach(point -> builder.add(point, GOLDEN_APPLE_ORCHARD));

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
//    Continentalness.MUSHROOM_FIELDS
//    Continentalness.DEEP_OCEAN
//    Continentalness.OCEAN
//    Continentalness.COAST
//    Continentalness.NEAR_INLAND
//    Continentalness.MID_INLAND
//    Continentalness.FAR_INLAND
//    Continentalness.INLAND
//    Continentalness.FULL_RANGE
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
