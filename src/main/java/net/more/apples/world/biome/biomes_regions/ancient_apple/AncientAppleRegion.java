package net.more.apples.world.biome.biomes_regions.ancient_apple;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import static net.more.apples.world.biome.biomes_regions.ancient_apple.AncientAppleBiome.ANCIENT_APPLE_WILDS;

public class AncientAppleRegion extends Region {
    public AncientAppleRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }


    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
//MultiNoiseUtil
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.COOL, ParameterUtils.Temperature.NEUTRAL))
                .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.DRY, ParameterUtils.Humidity.NEUTRAL))
                .continentalness(ParameterUtils.Continentalness.MID_INLAND, ParameterUtils.Continentalness.INLAND)
                .erosion(Climate.Parameter.span(0.05F, 1.0F))
                .depth(Climate.Parameter.span(-1.0F, 1.0F))
                .weirdness(ParameterUtils.Weirdness.PEAK_VARIANT, ParameterUtils.Weirdness.HIGH_SLICE_VARIANT_DESCENDING)
                .build().forEach(point -> builder.add(point, ANCIENT_APPLE_WILDS));

        builder.build().forEach(mapper);
    }
}
