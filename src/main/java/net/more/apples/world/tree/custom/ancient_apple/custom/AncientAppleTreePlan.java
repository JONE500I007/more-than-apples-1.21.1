package net.more.apples.world.tree.custom.ancient_apple.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.more.apples.MoreThanApples;
import net.more.apples.block.custom.AncientAppleLeavesBlock;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;

import java.util.ArrayList;
import java.util.List;

public class AncientAppleTreePlan {

    private static final double TRUNK_HEIGHT_SCALE = 0.618;
    private static final double BRANCH_SLOPE = 0.381;
    private static final double BRANCH_LENGTH_MAGIC = 0.328;

    public static List<AncientAppleTreeGeneratorBlockEntity.BlockPlacement> generate(
            ServerLevel level, BlockPos origin, RandomSource random) {

        List<AncientAppleTreeGeneratorBlockEntity.BlockPlacement> placements = new ArrayList<>();

        int actualHeight = 30 + random.nextInt(9) + random.nextInt(8);
        int trunkHeight = Mth.floor(actualHeight * TRUNK_HEIGHT_SCALE);

        MoreThanApples.LOGGER.info("Generating tree at: " + origin + " height: " + actualHeight);

        // ── ลำต้น ──────────────────────────────────────────────
        addTrunk(placements, origin, trunkHeight, level);

        // ── ราก ────────────────────────────────────────────────
        addRoots(placements, origin, trunkHeight, random, level);

        // ── กิ่งและใบไม้ ────────────────────────────────────────
        addBranchesAndFoliage(placements, origin, actualHeight, trunkHeight, random, level);

        return placements;
    }

    private static void addTrunk(List<AncientAppleTreeGeneratorBlockEntity.BlockPlacement> placements,
                                 BlockPos origin, int trunkHeight, ServerLevel level) {
        for (int y = 0; y < trunkHeight; y++) {
            BlockPos base = origin.above(y);
            int size = y < trunkHeight / 3 ? 2 : y < trunkHeight * 2 / 3 ? 1 : 0;
            addCross(placements, base, size, level);
        }
    }

    private static void addCross(List<AncientAppleTreeGeneratorBlockEntity.BlockPlacement> placements,
                                 BlockPos center, int size, ServerLevel level) {
        for (int ox = -size; ox <= size; ox++) {
            for (int oz = -size; oz <= size; oz++) {
                if (Math.abs(ox) <= 1 || Math.abs(oz) <= 1) {
                    BlockPos pos = center.offset(ox, 0, oz);
                    addLog(placements, pos, Direction.Axis.Y, level);
                }
            }
        }
    }

    private static void addRoots(List<AncientAppleTreeGeneratorBlockEntity.BlockPlacement> placements,
                                 BlockPos origin, int trunkHeight, RandomSource random, ServerLevel level) {
        for (Direction dir : Direction.Plane.HORIZONTAL) {
            int rootCount = random.nextIntBetweenInclusive(2, 3);
            for (int r = 0; r < rootCount; r++) {
                int rootLength = random.nextIntBetweenInclusive(8, 14);
                int startHeight = 3;
                int sideOffset = r - 1;

                BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(
                        origin.getX() + dir.getClockWise().getStepX() * sideOffset,
                        origin.getY() + startHeight,
                        origin.getZ() + dir.getClockWise().getStepZ() * sideOffset);

                Direction currentDir = dir;

                for (int i = 1; i <= rootLength; i++) {
                    float chance = random.nextFloat();
                    if (i > 1) {
                        if (chance < 0.4f) currentDir = currentDir.getClockWise();
                        else if (chance < 0.7f) currentDir = currentDir.getCounterClockWise();
                    }

                    pos.move(currentDir);

                    float progress = (float) i / rootLength;
                    pos.setY(origin.getY() + Math.round(startHeight * (1.0f - progress)));

                    final Direction.Axis axis = currentDir.getAxis();
                    int rootThickness = Math.max(1, Math.round(startHeight * (1.0f - progress)));

                    for (int h = 0; h < rootThickness; h++) {
                        BlockPos placePos = new BlockPos(pos.getX(), origin.getY() + h, pos.getZ());
                        addLog(placements, placePos, axis, level);
                    }
                }
            }
        }
    }

    private static void addBranchesAndFoliage(
            List<AncientAppleTreeGeneratorBlockEntity.BlockPlacement> placements,
            BlockPos origin, int actualHeight, int trunkHeight,
            RandomSource random, ServerLevel level) {

        int height = actualHeight + 2;
        int clustersPerY = Math.min(3, Mth.floor(1.382 + Math.pow(1.0 * height / 13.0, 2.0)));
        int trunkTop = origin.getY() + trunkHeight;
        int relativeY = height - 5;

        List<BlockPos> foliagePositions = new ArrayList<>();
        foliagePositions.add(origin.above(relativeY));

        for (; relativeY >= 0; relativeY--) {
            float shape = treeShape(height, relativeY);
            if (shape < 0.0F) continue;

            for (int i = 0; i < clustersPerY; i++) {
                double radius = 1.7 * shape * (random.nextFloat() + BRANCH_LENGTH_MAGIC);
                double angle = random.nextFloat() * 2.0F * Math.PI;
                double x = radius * Math.sin(angle) + 0.5;
                double z = radius * Math.cos(angle) + 0.5;

                BlockPos branchEnd = origin.offset(Mth.floor(x), relativeY - 1, Mth.floor(z));

                // เพิ่มกิ่ง
                addLine(placements, origin.above(trunkHeight), branchEnd, level);

                foliagePositions.add(branchEnd);
            }
        }

        // เพิ่มใบไม้
        for (BlockPos foliagePos : foliagePositions) {
            addFoliage(placements, foliagePos, random, level);
        }
    }

    private static void addFoliage(List<AncientAppleTreeGeneratorBlockEntity.BlockPlacement> placements,
                                   BlockPos center, RandomSource random, ServerLevel level) {
        int radius = 4;
        for (int yo = 3; yo >= -3; yo--) {
            int layer = 3 - yo;
            float progress = (float) layer / 6;
            int currentRadius = Math.round(radius * (float) Math.sin(Math.PI * progress) + radius * 0.4f);

            for (int dx = -currentRadius; dx <= currentRadius; dx++) {
                for (int dz = -currentRadius; dz <= currentRadius; dz++) {
                    if (Mth.square(dx + 0.5F) + Mth.square(dz + 0.5F) <= currentRadius * currentRadius) {
                        BlockPos pos = center.offset(dx, yo, dz);
                        BlockState leafState = random.nextFloat() < 0.15f
                                ? AncientAppleWoodBlocks.ANCIENT_APPLE_LEAVES.defaultBlockState()
                                  .setValue(AncientAppleLeavesBlock.PERSISTENT, false)
                                : AncientAppleWoodBlocks.ANCIENT_APPLE_LEAVES.defaultBlockState()
                                  .setValue(AncientAppleLeavesBlock.PERSISTENT, false);
                        placements.add(new AncientAppleTreeGeneratorBlockEntity.BlockPlacement(pos, leafState));
                    }
                }
            }
        }
    }

    private static void addLine(List<AncientAppleTreeGeneratorBlockEntity.BlockPlacement> placements,
                                BlockPos start, BlockPos end, ServerLevel level) {
        BlockPos delta = end.offset(-start.getX(), -start.getY(), -start.getZ());
        int steps = Math.max(Math.max(Mth.abs(delta.getX()), Mth.abs(delta.getY())), Mth.abs(delta.getZ()));
        if (steps == 0) return;

        float dx = (float) delta.getX() / steps;
        float dy = (float) delta.getY() / steps;
        float dz = (float) delta.getZ() / steps;

        for (int i = 0; i <= steps; i++) {
            BlockPos pos = start.offset(
                    Mth.floor(0.5F + i * dx),
                    Mth.floor(0.5F + i * dy),
                    Mth.floor(0.5F + i * dz));
            addLog(placements, pos, getAxis(start, pos), level);
        }
    }

    private static void addLog(List<AncientAppleTreeGeneratorBlockEntity.BlockPlacement> placements,
                               BlockPos pos, Direction.Axis axis, ServerLevel level) {
        BlockState state = AppleWoodBlocks.APPLE_LOG.defaultBlockState()
                .setValue(RotatedPillarBlock.AXIS, axis);
        placements.add(new AncientAppleTreeGeneratorBlockEntity.BlockPlacement(pos, state));
    }

    private static Direction.Axis getAxis(BlockPos start, BlockPos end) {
        int xdiff = Math.abs(end.getX() - start.getX());
        int zdiff = Math.abs(end.getZ() - start.getZ());
        int maxdiff = Math.max(xdiff, zdiff);
        if (maxdiff > 0) return xdiff == maxdiff ? Direction.Axis.X : Direction.Axis.Z;
        return Direction.Axis.Y;
    }

    private static float treeShape(int height, int y) {
        if (y < height * 0.3F) return -1.0F;
        float radius = height / 2.0F;
        float adjacent = radius - y;
        float distance = Mth.sqrt(radius * radius - adjacent * adjacent);
        if (adjacent == 0.0F) distance = radius;
        else if (Math.abs(adjacent) >= radius) return 0.0F;
        return distance * 0.5F;
    }
}
