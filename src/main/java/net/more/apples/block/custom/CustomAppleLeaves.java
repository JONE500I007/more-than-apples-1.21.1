package net.more.apples.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;

public class CustomAppleLeaves extends LeavesBlock {
    public CustomAppleLeaves(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return false;
    }
}
