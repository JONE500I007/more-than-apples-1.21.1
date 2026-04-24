package net.more.apples.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
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
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.more.apples.entity.AppleBlockEntity;
import org.jspecify.annotations.Nullable;

import static net.minecraft.world.level.block.CaveVines.SHAPE;

//DirectionProperty
public class AppleShelfBlock extends BaseEntityBlock {
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final EnumProperty<SideChainPart> SIDE_CHAIN_PART = BlockStateProperties.SIDE_CHAIN_PART;

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
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(POWERED, false)
                .setValue(SIDE_CHAIN_PART, SideChainPart.UNCONNECTED);
    }

//    @Override
//    protected VoxelShape getInteractionShape(BlockState state, BlockGetter level, BlockPos pos) {
//        return this.getShape(state, level, pos, CollisionContext.empty());
//    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case EAST  -> SHAPE_EAST;
            case WEST  -> SHAPE_WEST;
            default -> SHAPE;
        };
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

        Direction facing = state.getValue(FACING);

        if (hit.getDirection() != facing) {
            return InteractionResult.PASS;
        }

        if (level.getBlockEntity(pos) instanceof AppleBlockEntity shelf) {

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

            int slot;
            if (localX < 0.33) {
                slot = 0;
            } else if (localX < 0.66) {
                slot = 1;
            } else {
                slot = 2;
            }

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

    private static VoxelShape rotate90(VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{shape, Shapes.empty()};

        shape.forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> {
            buffer[1] = Shapes.or(buffer[1],
                    Block.box(
                            16 - maxZ, minY, minX,
                            16 - minZ, maxY, maxX
                    ));
        });
        return buffer[1];
    }
    private static VoxelShape rotate180(VoxelShape shape) {
        return rotate90(rotate90(shape));
    }
    private static VoxelShape rotate270(VoxelShape shape) {
        return rotate90(rotate180(shape));
    }
}