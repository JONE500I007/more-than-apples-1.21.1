package net.more.apples.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.OptionalInt;

public abstract class AncientAppleLeavesBlock extends Block implements SimpleWaterloggedBlock {

    public abstract MapCodec<? extends AncientAppleLeavesBlock> codec();


    public static final int DECAY_DISTANCE = 25;
    public static final IntegerProperty DISTANCE = IntegerProperty.create("distance", 1, 25);
    public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected final float leafParticleChance;

    public AncientAppleLeavesBlock(float leafParticleChance, BlockBehaviour.Properties properties) {
        super(properties);
        this.leafParticleChance = leafParticleChance;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(DISTANCE, 25)
                .setValue(PERSISTENT, false)
                .setValue(WATERLOGGED, false));
    }

    protected abstract void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random);

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return state.getValue(DISTANCE) == DECAY_DISTANCE && !state.getValue(PERSISTENT);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (this.decaying(state)) {
            dropResources(state, level, pos);
            level.removeBlock(pos, false);
        }
    }

    protected boolean decaying(BlockState state) {
        return !state.getValue(PERSISTENT) && state.getValue(DISTANCE) == DECAY_DISTANCE;
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        level.setBlock(pos, updateDistance(state, level, pos), 3);
    }

//    @Override
//    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks,
//                                     BlockPos pos, Direction dir, BlockPos neighborPos,
//                                     BlockState neighborState, RandomSource random) {
//        if (state.getValue(WATERLOGGED)) {
//            ticks.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
//        }
//        int dist = getDistanceAt(neighborState) + 1;
//        if (dist != 1 || state.getValue(DISTANCE) != dist) {
//            ticks.scheduleTick(pos, this, 1);
//        }
//        return state;
//    }

    private static final int TICK_DELAY = 1;
    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks,
                                     BlockPos pos, Direction dir, BlockPos neighborPos,
                                     BlockState neighborState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            ticks.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        int distanceFromNeighbor = getDistanceAt(neighborState) + 1;
        if (distanceFromNeighbor != 1 || state.getValue(DISTANCE) != distanceFromNeighbor) {
            ticks.scheduleTick(pos, this, TICK_DELAY);
        }

        return state;
    }

    private static BlockState updateDistance(BlockState state, LevelAccessor level, BlockPos pos) {
        int newDistance = DECAY_DISTANCE;
        BlockPos.MutableBlockPos neighborPos = new BlockPos.MutableBlockPos();

        for (Direction direction : Direction.values()) {
            neighborPos.setWithOffset(pos, direction);
            newDistance = Math.min(newDistance, getDistanceAt(level.getBlockState(neighborPos)) + 1);
            if (newDistance == 1) break;
        }

        return state.setValue(DISTANCE, newDistance);
    }

    private static int getDistanceAt(BlockState state) {
        if (state.is(BlockTags.PREVENTS_NEARBY_LEAF_DECAY)) return 0;
        if (state.hasProperty(DISTANCE)) return state.getValue(DISTANCE);
        if (state.hasProperty(LeavesBlock.DISTANCE)) return state.getValue(LeavesBlock.DISTANCE);
        return DECAY_DISTANCE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DISTANCE, PERSISTENT, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        BlockState state = this.defaultBlockState()
                .setValue(PERSISTENT, true)
                .setValue(WATERLOGGED, fluid.is(Fluids.WATER));
        return updateDistance(state, context.getLevel(), context.getClickedPos());
    }

    private static boolean cutoutLeaves = true;

    public static void setCutoutLeaves(boolean cutoutLeaves) {
        AncientAppleLeavesBlock.cutoutLeaves = cutoutLeaves;
    }

    @Override
    protected boolean skipRendering(BlockState state, BlockState neighborState, Direction direction) {
        if (!cutoutLeaves && (neighborState.getBlock() instanceof AncientAppleLeavesBlock
                || neighborState.getBlock() instanceof LeavesBlock)) {
            return true;
        }
        return super.skipRendering(state, neighborState, direction);
    }

    @Override
    protected VoxelShape getBlockSupportShape(BlockState state, BlockGetter level, BlockPos pos) {
        return Shapes.empty();
    }

    @Override
    protected int getLightDampening(BlockState state) {
        //return 1;
        return 0;
    }
    @Override
    protected boolean propagatesSkylightDown(BlockState state) {
        return true;
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        BlockPos below = pos.below();
        BlockState belowState = level.getBlockState(below);
        // dripping water
        if (level.isRainingAt(pos.above())) {
            if (random.nextInt(15) == 1) {
                if (!belowState.canOcclude() || !belowState.isFaceSturdy(level, below, Direction.UP)) {
                    ParticleUtils.spawnParticleBelow(level, pos, random, ParticleTypes.DRIPPING_WATER);
                }
            }
        }
        // falling leaves
        if (!(random.nextFloat() >= this.leafParticleChance)) {
            if (!isFaceFull(belowState.getCollisionShape(level, below), Direction.UP)) {
                this.spawnFallingLeavesParticle(level, pos, random);
            }
        }
    }

    public static OptionalInt getOptionalDistanceAt(BlockState state) {
        if (state.is(BlockTags.PREVENTS_NEARBY_LEAF_DECAY)) return OptionalInt.of(0);
        return state.hasProperty(DISTANCE) ? OptionalInt.of(state.getValue(DISTANCE)) : OptionalInt.empty();
    }
}
