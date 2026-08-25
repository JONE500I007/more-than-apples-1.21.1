package net.more.apples.world.tree.custom.ancient_apple.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
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
        for (int y = 0; y < trunkHeight; y++) {
            BlockPos base = origin.above(y);
            int size = y < trunkHeight / 3 ? 2 : y < trunkHeight * 2 / 3 ? 1 : 0;
            addCross(placements, base, size);
        }

        // ── ราก ────────────────────────────────────────────────
        addRoots(placements, origin, random, level);

        // ── กิ่งและใบไม้ ────────────────────────────────────────
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

                BlockPos checkStart = origin.offset(Mth.floor(x), relativeY - 1, Mth.floor(z));
                //BlockPos checkEnd = checkStart.above(5);

                int dx = origin.getX() - checkStart.getX();
                int dz = origin.getZ() - checkStart.getZ();
                double branchHeight = checkStart.getY() - Math.sqrt(dx * dx + dz * dz) * BRANCH_SLOPE;
                int branchTop = branchHeight > trunkTop ? trunkTop : (int) branchHeight;
                BlockPos checkBranchBase = new BlockPos(origin.getX(), branchTop, origin.getZ());

                if (branchTop - origin.getY() >= actualHeight * 0.2) {
                    addLine(placements, checkBranchBase, checkStart);
                    foliagePositions.add(checkStart);
                }
            }
        }

        // ── ลำต้นหลัก ──────────────────────────────────────────
        addLine(placements, origin, origin.above(trunkHeight));

        // ── ใบไม้ ────────────────────────────────────────────────
        for (BlockPos foliagePos : foliagePositions) {
            addFoliage(placements, foliagePos, random);
        }

        return placements;
    }

    private static void addCross(List<AncientAppleTreeGeneratorBlockEntity.BlockPlacement> placements,
                                 BlockPos center, int size) {
        for (int ox = -size; ox <= size; ox++) {
            for (int oz = -size; oz <= size; oz++) {
                if (Math.abs(ox) <= 1 || Math.abs(oz) <= 1) {
                    addLog(placements, center.offset(ox, 0, oz), Direction.Axis.Y);
                }
            }
        }
    }

    private static void addRoots(List<AncientAppleTreeGeneratorBlockEntity.BlockPlacement> placements,
                                 BlockPos origin, RandomSource random, ServerLevel level) {
        for (Direction dir : Direction.Plane.HORIZONTAL) {
            int rootCount = random.nextIntBetweenInclusive(2, 3);
            for (int r = 0; r < rootCount; r++) {
                int rootLength = random.nextIntBetweenInclusive(25, 40);
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
                        BlockState existing = level.getBlockState(placePos);
                        if (existing.isAir() || existing.is(BlockTags.REPLACEABLE) || existing.is(BlockTags.FLOWERS)) {
                            addLog(placements, placePos, axis);
                        }
                    }

                    BlockPos checkBelow = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
                    if (level.getBlockState(checkBelow).isAir()) {
                        // ส่ง pos ที่ Y จริงๆ ของราก ไม่ใช่ origin.getY()
                        addDropRoots(placements, pos.immutable(), origin, random, level);
                    }

                    if (rootThickness == 1 && i == rootLength) {
                        int tailLength = random.nextIntBetweenInclusive(4, 8);
                        Direction tailDir = currentDir;
                        for (int t = 1; t <= tailLength; t++) {
                            if (random.nextFloat() < 0.3f) {
                                tailDir = random.nextBoolean()
                                        ? tailDir.getClockWise()
                                        : tailDir.getCounterClockWise();
                            }
                            pos.move(tailDir);
                            final Direction.Axis tailAxis = tailDir.getAxis();

                            BlockPos tailPos = new BlockPos(pos.getX(), origin.getY(), pos.getZ());
                            BlockState tailState = level.getBlockState(tailPos);
                            if (tailState.isAir() || tailState.is(BlockTags.REPLACEABLE) || tailState.is(BlockTags.FLOWERS)) {
                                addLog(placements, tailPos, tailAxis);
                            }

                            BlockPos groundLevel = new BlockPos(pos.getX(), origin.getY(), pos.getZ());
                            addDropRoots(placements, groundLevel, origin, random, level);
                        }
                    }

                    if (i < rootLength / 2 && random.nextFloat() < 0.5f) {
                        BlockPos wide = pos.relative(currentDir.getClockWise()).immutable();
                        BlockState wideState = level.getBlockState(wide);
                        if (wideState.isAir() || wideState.is(BlockTags.REPLACEABLE) || wideState.is(BlockTags.FLOWERS)) {
                            addLog(placements, wide, axis);
                        }
                        addDropRoots(placements, wide, origin, random, level);
                    }
                }
            }
        }
    }
    private static void addDropRoots(List<AncientAppleTreeGeneratorBlockEntity.BlockPlacement> placements,
                                     BlockPos startPos, BlockPos origin, RandomSource random, ServerLevel level) {
        int dropDepth = random.nextIntBetweenInclusive(7, 15);
        BlockPos groundPos = null;
        Direction branchDir = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        for (int d = 1; d <= dropDepth; d++) {
            BlockPos dropPos = new BlockPos(startPos.getX(), startPos.getY() - d, startPos.getZ());
            BlockState state = level.getBlockState(dropPos);

            if (state.isAir() || state.is(BlockTags.REPLACEABLE) || state.is(BlockTags.FLOWERS)) {
                addLog(placements, dropPos, Direction.Axis.Y);
                groundPos = dropPos;

                // แตกรากออกมาระหว่าง drop
                if (random.nextFloat() < 0.2f) {
                    if (random.nextFloat() < 0.4f) branchDir = branchDir.getClockWise();
                    else if (random.nextFloat() < 0.7f) branchDir = branchDir.getCounterClockWise();

                    int branchLen = random.nextIntBetweenInclusive(2, 5);
                    BlockPos.MutableBlockPos branchPos = dropPos.mutable();

                    for (int b = 0; b < branchLen; b++) {
                        if (random.nextFloat() < 0.3f) {
                            branchDir = random.nextBoolean()
                                    ? branchDir.getClockWise()
                                    : branchDir.getCounterClockWise();
                        }
                        branchPos.move(branchDir);
                        final Direction.Axis branchAxis = branchDir.getAxis();
                        addLog(placements, branchPos.immutable(), branchAxis);
                    }
                }
            } else {
                break;
            }
        }

        // spread ที่พื้นเหมือนเดิม
        if (groundPos != null && !level.getBlockState(groundPos.below()).isAir()) {
            int spreadLength = random.nextIntBetweenInclusive(4, 8);
            Direction spreadDir = Direction.Plane.HORIZONTAL.getRandomDirection(random);
            BlockPos.MutableBlockPos spreadPos = groundPos.mutable();

            for (int s = 1; s <= spreadLength; s++) {
                float r = random.nextFloat();
                if (r < 0.4f) spreadDir = spreadDir.getClockWise();
                else if (r < 0.7f) spreadDir = spreadDir.getCounterClockWise();

                spreadPos.move(spreadDir);
                final Direction.Axis spreadAxis = spreadDir.getAxis();
                addLog(placements, spreadPos.immutable(), spreadAxis);

                if (random.nextFloat() < 0.3f) {
                    addLog(placements, spreadPos.relative(spreadDir.getClockWise()).immutable(), spreadAxis);
                }
            }
        }
    }

    private static void addFoliage(List<AncientAppleTreeGeneratorBlockEntity.BlockPlacement> placements,
                                   BlockPos center, RandomSource random) {
        int leafRadius = 4;
        int foliageHeight = 6;
        int offset = 4;

        for (int yo = offset; yo >= offset - foliageHeight; yo--) {
            int layer = offset - yo;
            float progress = (float) layer / Math.max(1, foliageHeight);
            int currentRadius = Math.round(
                    leafRadius * (float) Math.sin(Math.PI * progress)
                            + leafRadius * 0.5f  // minimum radius
                            + 0                  // radiusOffset = 0
            );

            for (int dx = -currentRadius; dx <= currentRadius; dx++) {
                for (int dz = -currentRadius; dz <= currentRadius; dz++) {
                    if (Mth.square(dx + 0.5F) + Mth.square(dz + 0.5F) <= currentRadius * currentRadius) {
                        BlockPos pos = center.offset(dx, yo, dz);
                        BlockState leafState = AncientAppleWoodBlocks.ANCIENT_APPLE_LEAVES
                                .defaultBlockState()
                                .setValue(AncientAppleLeavesBlock.PERSISTENT, true);
                        placements.add(new AncientAppleTreeGeneratorBlockEntity.BlockPlacement(pos, leafState));
                    }
                }
            }
        }
    }

    private static void addLine(List<AncientAppleTreeGeneratorBlockEntity.BlockPlacement> placements,
                                BlockPos start, BlockPos end) {
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
            addLog(placements, pos, getAxis(start, pos));

            // กิ่งหนา 2 block เหมือน AncientAppleTrunkPlacerv2
            Direction.Axis axis = getAxis(start, pos);
            BlockPos extra = axis == Direction.Axis.X
                    ? pos.south()
                    : axis == Direction.Axis.Z
                      ? pos.east()
                      : pos.east();
            addLog(placements, extra, axis);
        }
    }

    private static void addLog(List<AncientAppleTreeGeneratorBlockEntity.BlockPlacement> placements,
                               BlockPos pos, Direction.Axis axis) {
        BlockState state = AncientAppleWoodBlocks.ANCIENT_APPLE_LOG.defaultBlockState()
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
