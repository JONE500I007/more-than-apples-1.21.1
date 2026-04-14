package net.more.apples.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.dedicated.Settings;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;


public class CustomAppleLeaves extends LeavesBlock {
    public CustomAppleLeaves(float leafParticleChance, Properties properties) {
        super(leafParticleChance, properties);
    }

    @Override
    public MapCodec<? extends LeavesBlock> codec() {
        return null;
    }

    @Override
    protected void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random) {

    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return super.isRandomlyTicking(state);
    }

    @Override
    protected void spawnDestroyParticles(Level level, Player player, BlockPos pos, BlockState state) {
        super.spawnDestroyParticles(level, player, pos, state);
    }
}
