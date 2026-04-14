package net.more.apples.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;

import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.more.apples.MoreThanApples;

public class ModParticle {
    public static final SimpleParticleType TEST_LEAVES_PARTICLE =
            registerParticle("test_leaves_particle", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name), particleType);
    }

    public static void registerParticle() {
        MoreThanApples.LOGGER.info("Registering Particle for " + MoreThanApples.MOD_ID);
    }
}
