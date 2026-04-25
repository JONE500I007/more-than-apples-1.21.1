package net.more.apples.world.biome.surface;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class ModNoiseSettings {
/*
    public static NoiseGeneratorSettings bootstrap(BootstrapContext<NoiseGeneratorSettings> context) {

        HolderGetter<NoiseGeneratorSettings> noiseSettings =
                context.lookup(Registries.NOISE_SETTINGS);

        NoiseGeneratorSettings vanilla = noiseSettings
                .getOrThrow(NoiseGeneratorSettings.OVERWORLD)
                .value();

        return new NoiseGeneratorSettings(
                vanilla.noiseSettings(),
                vanilla.defaultBlock(),
                vanilla.defaultFluid(),

                vanilla.noiseRouter(),

                ModGoldenAppleOrchardMaterialRules.makeRule(),

                vanilla.spawnTarget(),
                vanilla.seaLevel(),
                vanilla.disableMobGeneration(),
                vanilla.aquifersEnabled(),
                vanilla.oreVeinsEnabled(),
                vanilla.useLegacyRandomSource()
        );
    }

 */
}
