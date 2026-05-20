package net.more.apples.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public abstract class HugeAppleLeavesBlock extends Block implements SimpleWaterloggedBlock {

    public abstract MapCodec<? extends HugeAppleLeavesBlock> codec();
    // เปลี่ยนจาก 7 เป็น 64

    public static final int DECAY_DISTANCE = 64;
    public static final IntegerProperty DISTANCE = IntegerProperty.create("distance", 1, 64);
    public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected final float leafParticleChance;

    public HugeAppleLeavesBlock(float leafParticleChance, BlockBehaviour.Properties properties) {
        super(properties);
        this.leafParticleChance = leafParticleChance; // เพิ่มบรรทัดนี้
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(DISTANCE, 64)
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

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks,
                                     BlockPos pos, Direction dir, BlockPos neighborPos,
                                     BlockState neighborState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            ticks.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        int dist = getDistanceAt(neighborState) + 1;
        if (dist != 1 || state.getValue(DISTANCE) != dist) {
            ticks.scheduleTick(pos, this, 1);
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
        return state.hasProperty(DISTANCE) ? state.getValue(DISTANCE) : DECAY_DISTANCE;
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


}
