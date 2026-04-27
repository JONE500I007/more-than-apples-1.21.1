package net.more.apples.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.more.apples.entity.AppleBlockEntity;
import net.more.apples.util.ModTags;
import net.more.apples.world.IShelfLike;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static net.minecraft.world.level.block.CaveVines.SHAPE;

//DirectionProperty
public class AppleShelfBlock extends BaseEntityBlock {

    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final EnumProperty<SideChainPart> SIDE_CHAIN_PART = BlockStateProperties.SIDE_CHAIN_PART;

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
        builder.add(FACING, POWERED, SIDE_CHAIN_PART);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(POWERED, context.getLevel().hasNeighborSignal(context.getClickedPos()))
                .setValue(SIDE_CHAIN_PART, SideChainPart.UNCONNECTED);
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
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        if (!oldState.is(state.getBlock())) {
            if (state.getValue(POWERED)) {
                level.updateNeighborsAt(pos, this);
            }
        }
    }

    @Override
    protected void affectNeighborsAfterRemoval(BlockState state, ServerLevel level, BlockPos pos, boolean movedByPiston) {
        level.updateNeighborsAt(pos, this);
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
            level.updateNeighborsAt(pos, this);

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

    //slot detection

    private int getSlot(BlockHitResult hit, Direction facing, BlockPos pos) {
        Vec3 hitPos = hit.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ());

        double x = hitPos.x;
        double z = hitPos.z;

        double localX;

        switch (facing) {
            case NORTH -> localX = 1 - x;
            case SOUTH -> localX = x;
            case WEST  -> localX = z;
            case EAST  -> localX = 1 - z;
            default -> localX = x;
        }

        if (localX < 0.33) return 0;
        if (localX < 0.66) return 1;
        return 2;
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
        if (!(level.getBlockEntity(pos) instanceof IShelfLike shelf)) {
            return InteractionResult.PASS;
        }

        if (hand == InteractionHand.OFF_HAND) {
            return InteractionResult.PASS;
        }

        Direction facing = state.getValue(FACING);

        if (hit.getDirection() != facing) {
            return InteractionResult.PASS;
        }

        if (state.getValue(POWERED)) {
            if (!level.isClientSide()) {
                List<BlockPos> shelves =
                        getConnectedShelves(level, pos, state.getValue(FACING));

                swapChain(player, shelves);
            }
            return InteractionResult.SUCCESS;
        }

        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        int slot = getSlot(hit, facing, pos);
        ItemStack current = shelf.getItem(slot);
        int selected = player.getInventory().getSelectedSlot();

        if (!stack.isEmpty()) {

            ItemStack old = shelf.swapItemNoUpdate(slot, stack.copy());

            if (!player.getAbilities().instabuild) {
                player.getInventory().setItem(selected, old);
            }

            shelf.setChanged();
            return InteractionResult.SUCCESS;
        }

        if (stack.isEmpty() && !current.isEmpty()) {

            ItemStack inHand = player.getInventory().getItem(selected);

            if (inHand.isEmpty()) {
                player.getInventory().setItem(selected, current.copy());
            } else {
                player.addItem(current.copy());
            }

            shelf.setItem(slot, ItemStack.EMPTY);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    private void swapHotbar(Player player, AppleBlockEntity shelf) {

        Inventory inv = player.getInventory();

        int base = inv.getSelectedSlot();

        for (int i = 0; i < 3; i++) {

            int invIndex = (base + i) % 9;

            ItemStack invStack = inv.getItem(invIndex);
            ItemStack shelfStack = shelf.getItem(i);

            shelf.setItem(i, invStack);
            inv.setItem(invIndex, shelfStack);
        }
    }

    private List<BlockPos> getConnectedShelves(Level level, BlockPos pos, Direction facing) {

        List<BlockPos> list = new ArrayList<>();

        Direction side = facing.getClockWise();

        for (int i = 1; i <= 2; i++) {

            BlockPos checkPos = pos.relative(side, -i);
            BlockState checkState = level.getBlockState(checkPos);

            if (!(checkState.getBlock() instanceof AppleShelfBlock)
                    || checkState.getValue(FACING) != facing
                    || !checkState.getValue(POWERED)) {
                break;
            }

            list.add(checkPos);
        }

        list.add(pos);

        for (int i = 1; i <= 2; i++) {

            BlockPos checkPos = pos.relative(side, i);
            BlockState checkState = level.getBlockState(checkPos);

            if (!(checkState.getBlock() instanceof AppleShelfBlock)
                    || checkState.getValue(FACING) != facing
                    || !checkState.getValue(POWERED)) {
                break;
            }

            list.add(checkPos);
        }

        // sort
        list.sort(Comparator.comparingInt((BlockPos p) ->
                facing.getAxis() == Direction.Axis.X ? p.getZ() : p.getX()
        ));

        return list;
    }
    private void swapChain(Player player, List<BlockPos> positions) {

        Inventory inv = player.getInventory();

        int totalShelves = positions.size();

        for (int s = 0; s < totalShelves; s++) {

            BlockPos pos = positions.get(s);

            if (!(player.level().getBlockEntity(pos) instanceof IShelfLike shelf)) continue;

            for (int i = 0; i < 3; i++) {

                int invIndex = 9 - (totalShelves - s) * 3 + i;

                if (invIndex < 0 || invIndex >= 9) continue;

                ItemStack invStack = inv.getItem(invIndex);
                ItemStack removed = shelf.swapItemNoUpdate(i, invStack);

                if (!invStack.isEmpty() || !removed.isEmpty()) {
                    inv.setItem(invIndex, removed);
                }
            }

            shelf.setChanged();
        }

        inv.setChanged();
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
}
