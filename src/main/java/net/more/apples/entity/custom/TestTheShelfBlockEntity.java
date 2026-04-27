package net.more.apples.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.ShelfBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TestTheShelfBlockEntity extends ShelfBlockEntity {
    public TestTheShelfBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(worldPosition, blockState);
    }
}
