package net.more.apples.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.more.apples.entity.AppleBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.OptionalInt;

public class AppleShelfBlock extends BaseEntityBlock
        implements SelectableSlotContainer, SideChainPartBlock, SimpleWaterloggedBlock {

    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final EnumProperty<SideChainPart> SIDE_CHAIN_PART = BlockStateProperties.SIDE_CHAIN_PART;

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    // SHAPES
    private static final VoxelShape SHAPE_NORTH = Shapes.or(
            Block.box(0, 0, 11, 16, 4, 16),
            Block.box(0, 12, 11, 16, 16, 16),
            Block.box(0, 4, 13, 16, 12, 16)
    );
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(
            Block.box(0, 0, 0, 16, 4, 5),
            Block.box(0, 12, 0, 16, 16, 5),
            Block.box(0, 4, 0, 16, 12, 3)
    );
    private static final VoxelShape SHAPE_EAST = Shapes.or(
            Block.box(0, 0, 0, 5, 4, 16),
            Block.box(0, 12, 0, 5, 16, 16),
            Block.box(0, 4, 0, 3, 12, 16)
    );
    private static final VoxelShape SHAPE_WEST = Shapes.or(
            Block.box(11, 0, 0, 16, 4, 16),
            Block.box(11, 12, 0, 16, 16, 16),
            Block.box(13, 4, 0, 16, 12, 16)
    );

    public static final MapCodec<AppleShelfBlock> CODEC = simpleCodec(AppleShelfBlock::new);

    public AppleShelfBlock(Properties properties) {
        super(properties);

        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(POWERED, false)
                        .setValue(SIDE_CHAIN_PART, SideChainPart.UNCONNECTED)
                        .setValue(WATERLOGGED, false)
        );
    }


    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AppleBlockEntity(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(
                FACING,
                POWERED,
                SIDE_CHAIN_PART,
                WATERLOGGED
        );
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {

        FluidState fluid =
                context.getLevel()
                        .getFluidState(context.getClickedPos());

        return this.defaultBlockState()
                .setValue(
                        FACING,
                        context.getHorizontalDirection().getOpposite()
                )
                .setValue(
                        POWERED,
                        context.getLevel().hasNeighborSignal(
                                context.getClickedPos()
                        )
                )
                .setValue(
                        SIDE_CHAIN_PART,
                        SideChainPart.UNCONNECTED
                )
                .setValue(
                        WATERLOGGED,
                        fluid.is(Fluids.WATER)
                );
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case EAST  -> SHAPE_EAST;
            case WEST  -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    protected boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return type == PathComputationType.WATER && state.getFluidState().is(FluidTags.WATER);
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        if (state.getValue(POWERED)) {
            this.updateSelfAndNeighborsOnPoweringUp(level, pos, state, oldState);
        } else {
            this.updateNeighborsAfterPoweringDown(level, pos, state);
        }
    }

    @Override
    protected void affectNeighborsAfterRemoval(BlockState state, ServerLevel level, BlockPos pos, boolean movedByPiston) {
        Containers.updateNeighboursAfterDestroy(state, level, pos);
        this.updateNeighborsAfterPoweringDown(level, pos, state);
    }

    //redstone

    @Override
    protected void neighborChanged(
            BlockState state,
            Level level,
            BlockPos pos,
            Block block,
            @Nullable Orientation orientation,
            boolean movedByPiston
    ) {
        if (level.isClientSide()) return;

        boolean signal = level.hasNeighborSignal(pos);

        if (state.getValue(POWERED) != signal) {

            BlockState newState = state.setValue(POWERED, signal);

            if (!signal) {
                newState = newState.setValue(SIDE_CHAIN_PART, SideChainPart.UNCONNECTED);
            }

            level.setBlock(pos, newState, 3);

            level.playSound(
                    null,
                    pos,
                    signal ? SoundEvents.SHELF_ACTIVATE : SoundEvents.SHELF_DEACTIVATE,
                    SoundSource.BLOCKS,
                    1.0f,
                    1.0f
            );

            level.gameEvent(
                    signal ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE,
                    pos,
                    GameEvent.Context.of(newState)
            );
        }
    }

    //interaction

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
        if (!(level.getBlockEntity(pos) instanceof IShelfLike shelf) || hand == InteractionHand.OFF_HAND) {
            return InteractionResult.PASS;
        }

        OptionalInt hitSlot = this.getHitSlot(hit, state.getValue(FACING));
        if (hitSlot.isEmpty()) {
            return InteractionResult.PASS;
        }

        Inventory inventory = player.getInventory();

        if (level.isClientSide()) {
            return inventory.getSelectedItem().isEmpty() ? InteractionResult.PASS : InteractionResult.SUCCESS;
        } else if (!state.getValue(POWERED)) {
            boolean itemRemoved = swapSingleItem(stack, player, shelf, hitSlot.getAsInt(), inventory);

            if (itemRemoved) {
                level.playSound(
                        null,
                        pos,
                        stack.isEmpty() ? SoundEvents.SHELF_TAKE_ITEM : SoundEvents.SHELF_SINGLE_SWAP,
                        SoundSource.BLOCKS,
                        1.0F,
                        1.0F + level.getRandom().nextFloat() * 0.1F
                );
            } else {
                if (stack.isEmpty()) {
                    return InteractionResult.PASS;
                }

                level.playSound(
                        null,
                        pos,
                        SoundEvents.SHELF_PLACE_ITEM,
                        SoundSource.BLOCKS,
                        1.0F,
                        1.0F + level.getRandom().nextFloat() * 0.1F
                );
            }

            return InteractionResult.SUCCESS.heldItemTransformedTo(stack);
        } else {
            ItemStack previousItem = inventory.getSelectedItem();
            boolean anySwapped = this.swapHotbar(level, pos, inventory);

            if (!anySwapped) {
                return InteractionResult.CONSUME;
            }

            level.playSound(
                    null,
                    pos,
                    SoundEvents.SHELF_MULTI_SWAP,
                    SoundSource.BLOCKS,
                    1.0F,
                    1.0F + level.getRandom().nextFloat() * 0.1F
            );

            return previousItem == inventory.getSelectedItem()
                    ? InteractionResult.SUCCESS
                    : InteractionResult.SUCCESS.heldItemTransformedTo(inventory.getSelectedItem());
        }
    }

    private static boolean swapSingleItem(
            ItemStack itemStack, Player player, IShelfLike shelf, int hitSlot, Inventory inventory
    ) {
        ItemStack removedItem = shelf.swapItemNoUpdate(hitSlot, itemStack);
        ItemStack newInventoryItem = player.hasInfiniteMaterials() && removedItem.isEmpty() ? itemStack.copy() : removedItem;

        inventory.setItem(inventory.getSelectedSlot(), newInventoryItem);
        inventory.setChanged();
        shelf.setChanged();

        return !removedItem.isEmpty();
    }

    private boolean swapHotbar(Level level, BlockPos pos, Inventory inventory) {
        List<BlockPos> connectedBlocks = this.getAllBlocksConnectedTo(level, pos);
        if (connectedBlocks.isEmpty()) {
            return false;
        }

        boolean anySwapped = false;

        for (int shelfPartIndex = 0; shelfPartIndex < connectedBlocks.size(); shelfPartIndex++) {
            if (!(level.getBlockEntity(connectedBlocks.get(shelfPartIndex)) instanceof IShelfLike shelfPart)) {
                continue;
            }

            for (int slot = 0; slot < this.getColumns(); slot++) {
                int inventorySlot = 9 - (connectedBlocks.size() - shelfPartIndex) * this.getColumns() + slot;
                if (inventorySlot >= 0 && inventorySlot <= inventory.getContainerSize()) {
                    ItemStack placedInventoryItem = inventory.removeItemNoUpdate(inventorySlot);
                    ItemStack removedShelfItem = shelfPart.swapItemNoUpdate(slot, placedInventoryItem);
                    if (!placedInventoryItem.isEmpty() || !removedShelfItem.isEmpty()) {
                        inventory.setItem(inventorySlot, removedShelfItem);
                        anySwapped = true;
                    }
                }
            }

            inventory.setChanged();
            shelfPart.setChanged();
        }

        return anySwapped;
    }


    @Override
    protected boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(
            BlockState state,
            Level level,
            BlockPos pos,
            Direction direction
    ) {
        if (level.isClientSide()) return 0;

        if (direction != state.getValue(FACING).getOpposite()) {
            return 0;
        }

        if (level.getBlockEntity(pos) instanceof IShelfLike shelf) {
            int item1 = shelf.getItem(0).isEmpty() ? 0 : 1;
            int item2 = shelf.getItem(1).isEmpty() ? 0 : 1;
            int item3 = shelf.getItem(2).isEmpty() ? 0 : 1;

            return item1 | (item2 << 1) | (item3 << 2);
        }

        return 0;
    }


    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public int getColumns() {
        return 3;
    }



    @Override
    public SideChainPart getSideChainPart(BlockState state) {
        return state.getValue(SIDE_CHAIN_PART);
    }

    @Override
    public BlockState setSideChainPart(BlockState state, SideChainPart part) {
        return state.setValue(SIDE_CHAIN_PART, part);
    }

    @Override
    public Direction getFacing(BlockState state) {
        return state.getValue(FACING);
    }

    @Override
    public boolean isConnectable(BlockState state) {
        // Neighbour states here can be ANY block (air included), so the property
        // must be guarded before reading it, exactly like vanilla ShelfBlock does.
        return state.is(BlockTags.WOODEN_SHELVES) && state.hasProperty(POWERED) && state.getValue(POWERED);
    }

    @Override
    public int getMaxChainLength() {
        return 3;
    }


    @Override
    protected FluidState getFluidState(BlockState state) {

        return state.getValue(WATERLOGGED)
                ? Fluids.WATER.getSource(false)
                : super.getFluidState(state);
    }

    @Override
    protected BlockState updateShape(
            BlockState state,
            LevelReader level,
            ScheduledTickAccess ticks,
            BlockPos pos,
            Direction direction,
            BlockPos neighborPos,
            BlockState neighborState,
            RandomSource random
    ) {

        if (state.getValue(WATERLOGGED)) {

            ticks.scheduleTick(
                    pos,
                    Fluids.WATER,
                    Fluids.WATER.getTickDelay(level)
            );
        }

        return super.updateShape(
                state,
                level,
                ticks,
                pos,
                direction,
                neighborPos,
                neighborState,
                random
        );
    }
}
