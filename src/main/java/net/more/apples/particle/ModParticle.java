package net.more.apples.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.more.apples.MoreThanApples;

public class ModParticle {
    public static final SimpleParticleType TEST_LEAVES_PARTICLE =
            registerParticle("test_leaves_particle", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MoreThanApples.MOD_ID, name), particleType);
    }

    public static void registerParticle() {
        MoreThanApples.LOGGER.info("Registering Particle for " + MoreThanApples.MOD_ID);
    }
}
