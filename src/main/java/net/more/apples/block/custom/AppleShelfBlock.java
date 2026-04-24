package net.more.apples.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ShelfBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.phys.BlockHitResult;
import net.more.apples.entity.AppleBlockEntity;
import org.jspecify.annotations.Nullable;
//DirectionProperty
public class AppleShelfBlock extends BaseEntityBlock {
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final EnumProperty<SideChainPart> SIDE_CHAIN_PART = BlockStateProperties.SIDE_CHAIN_PART;

    public static final MapCodec<AppleShelfBlock> CODEC =
            simpleCodec(AppleShelfBlock::new);


    public AppleShelfBlock(Properties properties) {
        super(properties);

        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(POWERED, false)
                        .setValue(SIDE_CHAIN_PART, SideChainPart.UNCONNECTED)
        );
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, POWERED, SIDE_CHAIN_PART);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AppleBlockEntity(pos, state);
    }

    @Override
    protected InteractionResult useItemOn(
            ItemStack stack,
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            InteractionHand hand,
            BlockHitResult hit
    ) {
        if (level.isClientSide()) return InteractionResult.SUCCESS;

        if (level.getBlockEntity(pos) instanceof AppleBlockEntity shelf) {

            if (!stack.isEmpty()) {
                for (int i = 0; i < 3; i++) {
                    if (shelf.getItem(i).isEmpty()) {
                        shelf.setItem(i, stack.copy());
                        if (!player.getAbilities().instabuild) {
                            stack.setCount(0);
                        }
                        return InteractionResult.SUCCESS;
                    }
                }
            }

            else {
                for (int i = 0; i < 3; i++) {
                    if (!shelf.getItem(i).isEmpty()) {

                        ItemStack taken = shelf.getItem(i).copy();
                        player.addItem(taken);

                        shelf.setItem(i, ItemStack.EMPTY);
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    protected InteractionResult useWithoutItem(
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            BlockHitResult hit
    ) {
        if (level.getBlockEntity(pos) instanceof AppleBlockEntity shelf) {

            for (int i = 0; i < 3; i++) {
                if (!shelf.getItem(i).isEmpty()) {

                    ItemStack stack = shelf.getItem(i).copy();
                    player.addItem(stack);

                    shelf.setItem(i, ItemStack.EMPTY);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }
}