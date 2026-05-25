package net.more.apples.world.tree.custom.ancient_apple.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class AncientAppleTreeGeneratorBlock extends BaseEntityBlock {

    public static final MapCodec<AncientAppleTreeGeneratorBlock> CODEC = simpleCodec(AncientAppleTreeGeneratorBlock::new);

    public AncientAppleTreeGeneratorBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<AncientAppleTreeGeneratorBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AncientAppleTreeGeneratorBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide() ? null :
                createTickerHelper(type, AncientBlockEntities.ANCIENT_APPLE_TREE_GENERATOR,
                        AncientAppleTreeGeneratorBlockEntity::tick);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }
}
