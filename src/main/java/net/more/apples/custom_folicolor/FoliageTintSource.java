package net.more.apples.custom_folicolor;

import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;

public class FoliageTintSource implements BlockTintSource {
    @Override
    public int color(BlockState state) {
        return FoliageColor.FOLIAGE_DEFAULT;
    }

    @Override
    public int colorInWorld(BlockState state, BlockAndTintGetter level, BlockPos pos) {
        return BlockTintSource.super.colorInWorld(state, level, pos);
    }
}
