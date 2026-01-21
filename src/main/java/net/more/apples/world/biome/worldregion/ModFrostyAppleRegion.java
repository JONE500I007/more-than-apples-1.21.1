package net.more.apples.world.biome.worldregion;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static net.more.apples.world.biome.worldbiomes.ModBiomeFrostyApple.FROSTY_APPLE;
import static terrablender.api.ParameterUtils.*;

public class ModFrostyAppleRegion extends Region {
    public ModFrostyAppleRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube,
            RegistryKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.FROZEN, Temperature.COOL))
                .humidity(Humidity.span(Humidity.ARID, Humidity.NEUTRAL))
                .continentalness(Continentalness.NEAR_INLAND, Continentalness.FAR_INLAND)
                .erosion(Erosion.EROSION_5, Erosion.EROSION_6)
                .depth(MultiNoiseUtil.ParameterRange.of(-1.0F, 1.0F))
                .weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING,
                        Weirdness.VALLEY,
                        Weirdness.MID_SLICE_NORMAL_DESCENDING)
                .build().forEach(point -> builder.add(point, FROSTY_APPLE));

        builder.build().forEach(mapper);
    }
}