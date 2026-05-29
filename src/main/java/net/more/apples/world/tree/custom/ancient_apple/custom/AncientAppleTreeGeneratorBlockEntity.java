package net.more.apples.world.tree.custom.ancient_apple.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.more.apples.MoreThanApples;
import net.more.apples.block.custom.AncientAppleLeavesBlock;

import java.util.ArrayList;
import java.util.List;

public class AncientAppleTreeGeneratorBlockEntity extends BlockEntity {

    private List<BlockPlacement> queue = new ArrayList<>();
    private int currentIndex = 0;
    private boolean initialized = false;
    private static final int BLOCKS_PER_TICK = 500;

    private int completionTimer = -1;
    private static final int COMPLETION_DELAY = 60;

    public AncientAppleTreeGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(AncientBlockEntities.ANCIENT_APPLE_TREE_GENERATOR, pos, state);
    }

    public void setQueue(List<BlockPlacement> queue) {
        this.queue = queue;
        this.currentIndex = 0;
    }

    public static void tick(Level level, BlockPos pos, BlockState state,
                            AncientAppleTreeGeneratorBlockEntity entity) {
        if (level.isClientSide()) return;

        if (!entity.initialized) {
            MoreThanApples.LOGGER.info("Generator at pos: " + pos);
            entity.queue = AncientAppleTreePlan.generate(
                    (ServerLevel) level, pos, level.getRandom());
            entity.currentIndex = 0;
            entity.initialized = true;
            MoreThanApples.LOGGER.info("Starting tree gen, total blocks: " + entity.queue.size());
            return;
        }

        if (entity.currentIndex == 0) {
            MoreThanApples.LOGGER.info("Starting tree gen, total blocks: " + entity.queue.size());
        }

        ServerLevel serverLevel = (ServerLevel) level;
        //int blocksPerTick = entity.queue.size();
        // all plan all block
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
            if (entity.completionTimer < 0) {
                // เริ่มนับ
                entity.completionTimer = 0;
                MoreThanApples.LOGGER.info("Tree gen complete! Waiting...");
                return;
            }

            entity.completionTimer++;

            if (entity.completionTimer >= COMPLETION_DELAY) {
                // เปลี่ยนใบไม้เป็น persistent = false
                for (BlockPlacement placement : entity.queue) {
                    BlockState leafState = level.getBlockState(placement.pos());
                    if (leafState.getBlock() instanceof AncientAppleLeavesBlock
                            && leafState.getValue(AncientAppleLeavesBlock.PERSISTENT)) {
                        level.setBlock(placement.pos(),
                                leafState.setValue(AncientAppleLeavesBlock.PERSISTENT, false), 3);
                    }
                }
                MoreThanApples.LOGGER.info("Tree finalized!");
                level.removeBlock(pos, false);
            }
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
