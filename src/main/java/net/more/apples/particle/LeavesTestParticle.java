package net.more.apples.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import org.jspecify.annotations.Nullable;

import java.util.Random;

@Environment(EnvType.CLIENT)
public class LeavesTestParticle extends SingleQuadParticle {
    //particle rotation
    private final float spinDirection;
    //acceleration of rotation maybe speed
    private final float angularAcceleration;
    //left and right swing
    private final float horizontalDrift;
    //Initial angle of swing
    private final float initialAngle;

    protected LeavesTestParticle(ClientLevel level, double x, double y, double z,
                                 SpriteSet spriteProvider) {
        super(level, x, y, z, spriteProvider.get(level.getRandom()));

        this.setSprite(spriteProvider.get(this.random));
        //this.setSprite(spriteProvider.get(this.random.nextInt(12), 12));

        //strength of gravity
        this.gravity = 0.05F * 0.0025F;
        //lifetime of particle 300–500 tick for now
        this.lifetime = 300 + random.nextInt(200);
        //this.lifetime = Math.max(1, 300 + random.nextInt(200));
        //particle size
        this.quadSize = 0.07F + random.nextFloat() * 0.05F;

        //direction of rotation
        this.spinDirection = random.nextBoolean() ? 1.0F : -1.0F;
        //acceleration of rotation maybe speed
        this.angularAcceleration = (float) Math.toRadians(random.nextBoolean() ? 5.0 : -5.0);
        //trength of the left and right swings in air
        this.horizontalDrift = 8.0F + random.nextFloat() * 2.0F;
        //starting angle for swing
        this.initialAngle = random.nextFloat() * 60.0F;

        //Initial vertical velocity maybe this just gravity
        this.yd = -0.01;
        //this.setColor(0.9F, 0.8F, 0.3F);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.age-- <= 0) {
            this.remove();
            return;
        }

        float ageNorm = 1.0F - (float) this.lifetime / 300.0F;
        //wwaying left and right
        double xOffset = Math.cos(ageNorm * this.horizontalDrift + this.initialAngle) * 0.002;
        double zOffset = Math.sin(ageNorm * this.horizontalDrift + this.initialAngle) * 0.002;

        //update horizontal speed
        this.xd += xOffset;
        //update vertical speed
        this.zd += zOffset;
        this.yd -= this.gravity;

        //rotation of leaves
        /*
        this.lastZRotation = this.zRotation;
        this.zRotation += this.angularAcceleration * this.spinDirection;
         */
        this.oRoll = this.roll;
        this.roll += this.angularAcceleration * this.spinDirection;

        //if a particle hit the ground just gone lol
        if (this.onGround) this.remove();
    }

    @Override
    protected Layer getLayer() {
        return Layer.TRANSLUCENT;
    }


    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Factory(SpriteSet sprites) {
            this.sprites = sprites;
        }
        /*
        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel world,
                                       double x, double y, double z,
                                       double velocityX, double velocityY, double velocityZ,
                                       Random random) {
            return new LeavesTestParticle(world, x, y, z, this.sprites);
        }
         */
        @Override
        public @Nullable Particle createParticle(SimpleParticleType options, ClientLevel level,
                                                 double x, double y, double z,
                                                 double xAux, double yAux, double zAux,
                                                 RandomSource random) {
            return new LeavesTestParticle(level, x, y, z, this.sprites);
        }
    }
}
