package net.more.apples.block.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;

public class AppleLeavesBlock extends HugeAppleLeavesBlock {

    public static final MapCodec<AppleLeavesBlock> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
            ExtraCodecs.floatRange(0.0F, 1.0F).fieldOf("leaf_particle_chance").forGetter(e -> e.leafParticleChance),
            ParticleTypes.CODEC.fieldOf("leaf_particle").forGetter(e -> e.leafParticle),
            propertiesCodec()
    ).apply(i, AppleLeavesBlock::new));

    private final ParticleOptions leafParticle;

    public AppleLeavesBlock(float leafParticleChance, ParticleOptions leafParticle, Properties properties) {
        super(leafParticleChance, properties);
        this.leafParticle = leafParticle;
    }

    @Override
    public MapCodec<AppleLeavesBlock> codec() {
        return CODEC;
    }

    @Override
    protected void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random) {
        ParticleUtils.spawnParticleBelow(level, pos, random, this.leafParticle);
    }
}
