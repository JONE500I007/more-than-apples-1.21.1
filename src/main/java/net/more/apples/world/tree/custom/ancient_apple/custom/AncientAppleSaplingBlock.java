package net.more.apples.world.tree.custom.ancient_apple.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;

import java.util.List;

public class AncientAppleSaplingBlock extends SaplingBlock {

    public AncientAppleSaplingBlock(Properties properties) {
        super(TreeGrower.OAK, properties); // ส่ง dummy ให้ parent
    }

    public static final MapCodec<AncientAppleSaplingBlock> CODEC = RecordCodecBuilder.mapCodec(
            i -> i.group(propertiesCodec()).apply(i, AncientAppleSaplingBlock::new)
    );

    @Override
    public MapCodec<? extends SaplingBlock> codec() {
        return CODEC;
    }

    @Override
    public void advanceTree(ServerLevel level, BlockPos pos, BlockState state, RandomSource random) {
        if (state.getValue(STAGE) == 0) {
            // stage 0 → 1 เหมือน vanilla
            level.setBlock(pos, state.cycle(STAGE), 260);
        } else {
            // stage 1 → gen ต้นไม้
            growTree(level, pos, random);
        }
    }

    private void growTree(ServerLevel level, BlockPos pos, RandomSource random) {
        level.setBlock(pos, AncientAppleWoodBlocks.ANCIENT_APPLE_TREE_GENERATOR.defaultBlockState(), 3);

        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof AncientAppleTreeGeneratorBlockEntity generator) {
            List<AncientAppleTreeGeneratorBlockEntity.BlockPlacement> plan =
                    AncientAppleTreePlan.generate(level, pos, random);
            generator.setQueue(plan);
        }
    }
}
