package net.more.apples.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

@Environment(EnvType.CLIENT)
public class LeavesTestParticle extends SpriteBillboardParticle {
    //particle rotation
    private final float spinDirection;
    //acceleration of rotation maybe speed
    private final float angularAcceleration;
    //left and right swing
    private final float horizontalDrift;
    //Initial angle of swing
    private final float initialAngle;
    protected LeavesTestParticle(ClientWorld world, double x, double y, double z,
                                 SpriteProvider spriteProvider) {
        super(world, x, y, z);

        this.setSprite(spriteProvider.getSprite(this.random.nextInt(12), 12));

        //strength of gravity
        this.gravityStrength = 0.05F * 0.0025F;
        //age of particle 300–500 tick for now
        this.maxAge = 300 + random.nextInt(200);
        //particle size
        this.scale = 0.07F + random.nextFloat() * 0.05F;

        //direction of rotation
        this.spinDirection = random.nextBoolean() ? 1.0F : -1.0F;
        //acceleration of rotation maybe speed
        this.angularAcceleration = (float) Math.toRadians(random.nextBoolean() ? 5.0 : -5.0);
        //trength of the left and right swings in air
        this.horizontalDrift = 8.0F + random.nextFloat() * 2.0F;
        //starting angle for swing
        this.initialAngle = random.nextFloat() * 60.0F;

        //Initial vertical velocity maybe this just gravity
        this.velocityY = -0.01;
        //this.setColor(0.9F, 0.8F, 0.3F);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.maxAge-- <= 0) {
            this.markDead();
            return;
        }

        float ageNorm = 1.0F - (float) this.maxAge / 300.0F;
        //wwaying left and right
        double xOffset = Math.cos(ageNorm * this.horizontalDrift + this.initialAngle) * 0.002;
        double zOffset = Math.sin(ageNorm * this.horizontalDrift + this.initialAngle) * 0.002;

        //update horizontal speed
        this.velocityX += xOffset;
        //update vertical speed
        this.velocityZ += zOffset;
        this.velocityY -= this.gravityStrength;

        //rotation of leaves
        this.lastAngle = this.angle;
        this.angle += this.angularAcceleration * this.spinDirection;

        //if a particle hit the ground just gone lol
        if (this.onGround) this.markDead();
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider sprites;
        public Factory(SpriteProvider sprites) { this.sprites = sprites; }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientWorld world,
                                       double x, double y, double z,
                                       double velocityX, double velocityY, double velocityZ) {
            return new LeavesTestParticle(world, x, y, z, this.sprites);
        }
    }
}
