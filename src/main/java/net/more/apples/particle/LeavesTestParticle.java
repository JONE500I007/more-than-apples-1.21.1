package net.more.apples.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class LeavesTestParticle extends BillboardParticle {
    private final float spinDirection;
    private final float angularAcceleration;
    private final float horizontalDrift;
    private final float initialAngle;

    protected LeavesTestParticle(ClientWorld world, double x, double y, double z,
                                 SpriteProvider spriteProvider) {
        super(world, x, y, z, spriteProvider.getSprite(world.random));

        this.setSprite(spriteProvider.getSprite(this.random));

        this.gravityStrength = 0.05F * 0.0025F;
        this.maxAge = Math.max(1, 300 + random.nextInt(200));
        this.scale = 0.07F + random.nextFloat() * 0.05F;

        this.spinDirection = random.nextBoolean() ? 1.0F : -1.0F;
        this.angularAcceleration = (float) Math.toRadians(random.nextBoolean() ? 5.0 : -5.0);
        this.horizontalDrift = 8.0F + random.nextFloat() * 2.0F;
        this.initialAngle = random.nextFloat() * 60.0F;

        this.velocityY = -0.01;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.maxAge-- <= 0) {
            this.markDead();
            return;
        }

        float ageNorm = 1.0F - (float) this.maxAge / 300.0F;
        double xOffset = Math.cos(ageNorm * this.horizontalDrift + this.initialAngle) * 0.002;
        double zOffset = Math.sin(ageNorm * this.horizontalDrift + this.initialAngle) * 0.002;

        this.velocityX += xOffset;
        this.velocityZ += zOffset;
        this.velocityY -= this.gravityStrength;

        this.lastZRotation = this.zRotation;
        this.zRotation += this.angularAcceleration * this.spinDirection;

        if (this.onGround) this.markDead();
    }

    @Override
    protected RenderType getRenderType() {
        return RenderType.PARTICLE_ATLAS_TRANSLUCENT;
    }


    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientWorld world,
                                       double x, double y, double z,
                                       double velocityX, double velocityY, double velocityZ,
                                       Random random) {
            return new LeavesTestParticle(world, x, y, z, this.sprites);
        }
    }
}

