package net.more.apples.block.custom.this_test;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.ShelfBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ShelfBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.more.apples.entity.AppleBlockEntity;
import net.more.apples.entity.custom.TestTheShelfBlockEntity;

public class TestTheShelfBlock extends ShelfBlock {

    public TestTheShelfBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TestTheShelfBlockEntity(pos, state);
    }
}
