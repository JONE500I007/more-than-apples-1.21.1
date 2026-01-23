package net.more.apples.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class CustomAppleLeaves extends LeavesBlock {

    public CustomAppleLeaves(float leafParticleChance, Settings settings) {
        super(leafParticleChance, settings);
    }

    @Override
    public MapCodec<? extends LeavesBlock> getCodec() {
        return null;
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return false;
    }

    @Override
    protected void spawnLeafParticle(World world, BlockPos pos, Random random) {

    }
}
