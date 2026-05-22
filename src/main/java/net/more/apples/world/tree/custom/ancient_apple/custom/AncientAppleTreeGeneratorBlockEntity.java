package net.more.apples.world.tree.custom.ancient_apple.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.more.apples.MoreThanApples;

import java.util.ArrayList;
import java.util.List;

public class AncientAppleTreeGeneratorBlockEntity extends BlockEntity {

    private List<BlockPlacement> queue = new ArrayList<>();
    private int currentIndex = 0;
    private static final int BLOCKS_PER_TICK = 10;

    public AncientAppleTreeGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ANCIENT_APPLE_TREE_GENERATOR, pos, state);
    }

    public void setQueue(List<BlockPlacement> queue) {
        this.queue = queue;
        this.currentIndex = 0;
    }

    public static void tick(Level level, BlockPos pos, BlockState state,
                            AncientAppleTreeGeneratorBlockEntity entity) {
        if (level.isClientSide()) return;

        if (entity.currentIndex == 0) {
            MoreThanApples.LOGGER.info("Starting tree gen, total blocks: " + entity.queue.size());
        }

        ServerLevel serverLevel = (ServerLevel) level;
        int placed = 0;

        while (entity.currentIndex < entity.queue.size() && placed < BLOCKS_PER_TICK) {
            BlockPlacement placement = entity.queue.get(entity.currentIndex);
            BlockPos placePos = placement.pos();

            // skip ตำแหน่งของ generator block เอง
            if (!placePos.equals(pos)) {
                if (level.getBlockState(placePos).isAir()
                        || level.getBlockState(placePos).is(BlockTags.REPLACEABLE)
                        || level.getBlockState(placePos).is(BlockTags.FLOWERS)) {
                    level.setBlock(placePos, placement.state(), 3);
                }
            }

            entity.currentIndex++;
            placed++;
            entity.setChanged();
        }

        // เสร็จแล้วลบตัวเอง
        if (entity.currentIndex >= entity.queue.size()) {
            MoreThanApples.LOGGER.info("Tree gen complete!");
            level.removeBlock(pos, false);
        }
    }

    // Save/Load queue
    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("currentIndex", currentIndex);
        // save queue...
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        currentIndex = input.getIntOr("currentIndex", 0);
        // load queue...
    }

    public record BlockPlacement(BlockPos pos, BlockState state) {}
}
