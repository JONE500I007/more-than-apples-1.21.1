package net.more.apples.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;

public class AppleLeavesBlock extends AncientAppleLeavesBlock {

    private final ParticleOptions leafParticle;

    public AppleLeavesBlock(float leafParticleChance, ParticleOptions leafParticle, Properties properties) {
        super(leafParticleChance, properties);
        this.leafParticle = leafParticle;
    }

    @Override
    protected void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random) {
        ParticleUtils.spawnParticleBelow(level, pos, random, this.leafParticle);
    }
}
