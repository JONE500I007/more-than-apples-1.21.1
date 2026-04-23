package net.more.apples.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.more.apples.block.ModBlocks2;

public class AppleBlockEntity extends BlockEntity {
    public AppleBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks2.SHELF_ENTITY_TYPE, pos, state);
    }
}
