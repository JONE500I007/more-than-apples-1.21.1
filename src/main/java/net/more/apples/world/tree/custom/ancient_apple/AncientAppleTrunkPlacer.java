package net.more.apples.world.tree.custom.ancient_apple;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.more.apples.world.tree.ModTrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;

public class AncientAppleTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<AncientAppleTrunkPlacer> CODEC =
            RecordCodecBuilder.mapCodec(i -> i.group(
                    Codec.intRange(0, 256).fieldOf("base_height").forGetter(p -> p.hugeHeight),
                    Codec.intRange(0, 256).fieldOf("height_rand_a").forGetter(p -> p.hugeHeightRandA),
                    Codec.intRange(0, 256).fieldOf("height_rand_b").forGetter(p -> p.hugeHeightRandB)
            ).apply(i, AncientAppleTrunkPlacer::new));

    private static final double TRUNK_HEIGHT_SCALE = 0.618;
    private static final double BRANCH_SLOPE = 0.381;
    private static final double BRANCH_LENGTH_MAGIC = 0.328;

    private final int hugeHeight;
    private final int hugeHeightRandA;
    private final int hugeHeightRandB;

    public AncientAppleTrunkPlacer(int hugeHeight, int hugeHeightRandA, int hugeHeightRandB) {
        super(1, 0, 0); // ส่งค่าน้อยๆ ให้ parent เพื่อผ่าน validation
        this.hugeHeight = hugeHeight;
        this.hugeHeightRandA = hugeHeightRandA;
        this.hugeHeightRandB = hugeHeightRandB;
    }

    private int getHugeTreeHeight(RandomSource random) {
        return hugeHeight
                + random.nextInt(hugeHeightRandA + 1)
                + random.nextInt(hugeHeightRandB + 1);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerType.ANCIENT_APPLE_TRUNK_PLACER;
    }


    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(
            WorldGenLevel level,
            BiConsumer<BlockPos, BlockState> trunkSetter,
            RandomSource random,
            int treeHeight,
            BlockPos origin,
            TreeConfiguration config) {

        int actualHeight = getHugeTreeHeight(random);
        int trunkHeight = Mth.floor(actualHeight * TRUNK_HEIGHT_SCALE);

        // ── รากโคนต้น ──────────────────────────────────────────────
        placeBelowTrunkBlock(level, trunkSetter, random, origin.below(), config);
        placeRoots(level, trunkSetter, random, origin, config);

        // ── ลำต้น เริ่ม 5x3 ค่อยๆ เรียวขึ้น ──────────────────────
        for (int y = 0; y < trunkHeight; y++) {
            BlockPos base = origin.above(y);

            if (y < trunkHeight / 3) {
                // โคน: cross 5x5
                placeCross(level, trunkSetter, random, base, config, 2);
            } else if (y < trunkHeight * 2 / 3) {
                // กลาง: cross 3x3
                placeCross(level, trunkSetter, random, base, config, 1);
            } else {
                // ยอด: 1x1
                if (TreeFeature.isAirOrLeaves(level, base))
                    placeLog(level, trunkSetter, random, base, config);
            }
        }

        // ── กิ่งก้าน ────────────────────────────────────────────────
        int height = actualHeight + 2;
        int clustersPerY = Math.min(3, Mth.floor(1.382 + Math.pow(1.0 * height / 13.0, 2.0)));
        int trunkTop = origin.getY() + trunkHeight;
        int relativeY = height - 5;

        List<FoliageCoords> foliageCoords = new ArrayList<>();
        foliageCoords.add(new FoliageCoords(origin.above(relativeY), trunkTop));

        for (; relativeY >= 0; relativeY--) {
            float shape = treeShape(height, relativeY);
            if (shape < 0.0F) continue;

            for (int i = 0; i < clustersPerY; i++) {
                double radius = 1.7 * shape * (random.nextFloat() + BRANCH_LENGTH_MAGIC);
                double angle = random.nextFloat() * 2.0F * Math.PI;
                double x = radius * Math.sin(angle) + 0.5;
                double z = radius * Math.cos(angle) + 0.5;

                BlockPos checkStart = origin.offset(Mth.floor(x), relativeY - 1, Mth.floor(z));
                BlockPos checkEnd = checkStart.above(5);

                if (makeLimb(level, trunkSetter, random, checkStart, checkEnd, false, config)) {
                    int dx = origin.getX() - checkStart.getX();
                    int dz = origin.getZ() - checkStart.getZ();
                    double branchHeight = checkStart.getY() - Math.sqrt(dx * dx + dz * dz) * BRANCH_SLOPE;
                    int branchTop = branchHeight > trunkTop ? trunkTop : (int) branchHeight;
                    BlockPos checkBranchBase = new BlockPos(origin.getX(), branchTop, origin.getZ());

                    if (makeLimb(level, trunkSetter, random, checkBranchBase, checkStart, false, config)) {
                        foliageCoords.add(new FoliageCoords(checkStart, checkBranchBase.getY()));
                    }
                }
            }
        }

        makeLimb(level, trunkSetter, random, origin, origin.above(trunkHeight), true, config);
        makeBranches(level, trunkSetter, random, height, origin, foliageCoords, config);

        List<FoliagePlacer.FoliageAttachment> attachments = new ArrayList<>();
        for (FoliageCoords coord : foliageCoords) {
            if (trimBranches(height, coord.getBranchBase() - origin.getY())) {
                attachments.add(coord.attachment);
            }
        }

        return attachments;
    }

    private void placeCross(WorldGenLevel level, BiConsumer<BlockPos, BlockState> trunkSetter,
                            RandomSource random, BlockPos center,
                            TreeConfiguration config, int size) {
        // วาง core กลาง
        for (int ox = -size; ox <= size; ox++) {
            for (int oz = -size; oz <= size; oz++) {
                // เอาแค่แนว + ออกไป ตัดมุมออก
                if (Math.abs(ox) <= 1 || Math.abs(oz) <= 1) {
                    BlockPos pos = center.offset(ox, 0, oz);
                    if (TreeFeature.isAirOrLeaves(level, pos))
                        placeLog(level, trunkSetter, random, pos, config);
                }
            }
        }
    }

    // ── รากยื่นออกมาจากโคน ──────────────────────────────────────
    private void placeRoots(WorldGenLevel level,
                            BiConsumer<BlockPos, BlockState> trunkSetter,
                            RandomSource random,
                            BlockPos origin,
                            TreeConfiguration config) {

        for (Direction dir : Direction.Plane.HORIZONTAL) {
            // สร้างราก 2-3 เส้นต่อทิศ
            int rootCount = random.nextIntBetweenInclusive(2, 3);
            for (int r = 0; r < rootCount; r++) {

                int rootLength = random.nextIntBetweenInclusive(25, 40);
                int startHeight = 3;

                // offset เริ่มต้นให้แต่ละเส้นไม่ซ้อนกัน
                int sideOffset = r - 1; // -1, 0, 1
                BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(
                        origin.getX() + dir.getClockWise().getStepX() * sideOffset,
                        origin.getY() + startHeight,
                        origin.getZ() + dir.getClockWise().getStepZ() * sideOffset);

                Direction currentDir = dir;

                for (int i = 1; i <= rootLength; i++) {
                    // เลี้ยวบ่อย
                    float chance = random.nextFloat();
                    if (i > 1) {
                        if (chance < 0.4f) {
                            currentDir = currentDir.getClockWise();
                        } else if (chance < 0.7f) {
                            currentDir = currentDir.getCounterClockWise();
                        }
                    }

                    pos.move(currentDir);

                    float progress = (float) i / rootLength;
                    int targetY = origin.getY() + Math.round(startHeight * (1.0f - progress));
                    pos.setY(targetY);

                    final Direction.Axis axis = currentDir.getAxis();
                    int rootThickness = Math.max(1, Math.round(startHeight * (1.0f - progress)));

                    // วาด block จากพื้นขึ้นไปแค่ rootThickness block
                    for (int h = 0; h < rootThickness; h++) {
                        BlockPos placePos = new BlockPos(pos.getX(), origin.getY() + h, pos.getZ());
                        if (TreeFeature.isAirOrLeaves(level, placePos)
                                || level.getBlockState(placePos).is(BlockTags.REPLACEABLE)
                                || level.getBlockState(placePos).is(BlockTags.FLOWERS)) {
                            placeLog(level, trunkSetter, random, placePos, config,
                                    state -> state.setValue(RotatedPillarBlock.AXIS, axis));
                        }
                    }

                    BlockPos checkBelow = new BlockPos(pos.getX(), origin.getY() - 1, pos.getZ());
                    if (level.getBlockState(checkBelow).isAir()) {
                        // หาพื้นจริงๆ แล้ววาง log ลงไปอย่างน้อย 3 block
                        int dropDepth = 10;
                        for (int d = 1; d <= dropDepth; d++) {
                            BlockPos dropPos = new BlockPos(pos.getX(), origin.getY() - d, pos.getZ());
                            if (level.getBlockState(dropPos).isAir()
                                    || level.getBlockState(dropPos).is(BlockTags.REPLACEABLE)
                                    || level.getBlockState(dropPos).is(BlockTags.FLOWERS)) {
                                placeLog(level, trunkSetter, random, dropPos, config,
                                        state -> state.setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y));
                            } else {
                                break; // เจอ solid block หยุด
                            }
                        }
                    }

                    // เมื่อถึงระดับ 1 block แล้ว ต่อหางออกไปอีก
                    if (rootThickness == 1 && i == rootLength) {
                        int tailLength = random.nextIntBetweenInclusive(4, 8);
                        Direction tailDir = currentDir;

                        for (int t = 1; t <= tailLength; t++) {
                            // เลี้ยวบ้างเล็กน้อย
                            if (random.nextFloat() < 0.3f) {
                                tailDir = random.nextBoolean()
                                        ? tailDir.getClockWise()
                                        : tailDir.getCounterClockWise();
                            }

                            pos.move(tailDir);
                            final Direction.Axis tailAxis = tailDir.getAxis();
                            BlockPos tailPos = new BlockPos(pos.getX(), origin.getY(), pos.getZ());

                            if (TreeFeature.isAirOrLeaves(level, tailPos)) {
                                placeLog(level, trunkSetter, random, tailPos, config,
                                        state -> state.setValue(RotatedPillarBlock.AXIS, tailAxis));
                            }

                            BlockPos tailCheckBelow = new BlockPos(tailPos.getX(), origin.getY() - 1, tailPos.getZ());
                            if (level.getBlockState(tailCheckBelow).isAir()) {
                                int dropDepth = 10;
                                for (int d = 1; d <= dropDepth; d++) {
                                    BlockPos dropPos = new BlockPos(tailPos.getX(), origin.getY() - d, tailPos.getZ());
                                    if (level.getBlockState(dropPos).isAir()
                                            || level.getBlockState(dropPos).is(BlockTags.REPLACEABLE)
                                            || level.getBlockState(dropPos).is(BlockTags.FLOWERS)){
                                        placeLog(level, trunkSetter, random, dropPos, config,
                                                state -> state.setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y));
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }
                    }


                    if (i < rootLength / 2 && random.nextFloat() < 0.5f) {
                        BlockPos wide = pos.relative(currentDir.getClockWise()).immutable();
                        if (TreeFeature.isAirOrLeaves(level, wide)
                                || level.getBlockState(wide).is(BlockTags.REPLACEABLE)
                                || level.getBlockState(wide).is(BlockTags.FLOWERS)) {
                            placeLog(level, trunkSetter, random, wide, config,
                                    state -> state.setValue(RotatedPillarBlock.AXIS, axis));
                        }

                        BlockPos wideCheckBelow = new BlockPos(wide.getX(), origin.getY() - 1, wide.getZ());
                        if (level.getBlockState(wideCheckBelow).isAir()) {
                            int dropDepth = 10;
                            for (int d = 1; d <= dropDepth; d++) {
                                BlockPos dropPos = new BlockPos(wide.getX(), origin.getY() - d, wide.getZ());
                                if (level.getBlockState(dropPos).isAir()
                                        || level.getBlockState(dropPos).is(BlockTags.REPLACEABLE)) {
                                    placeLog(level, trunkSetter, random, dropPos, config,
                                            state -> state.setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y));
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // ── Helper methods (เหมือน FancyTrunkPlacer) ─────────────────
    private boolean makeLimb(WorldGenLevel level, BiConsumer<BlockPos, BlockState> trunkSetter,
                             RandomSource random, BlockPos startPos, BlockPos endPos,
                             boolean doPlace, TreeConfiguration config) {
        if (!doPlace && Objects.equals(startPos, endPos)) return true;

        BlockPos delta = endPos.offset(-startPos.getX(), -startPos.getY(), -startPos.getZ());
        int steps = Math.max(Math.max(Mth.abs(delta.getX()), Mth.abs(delta.getY())), Mth.abs(delta.getZ()));
        float dx = (float) delta.getX() / steps;
        float dy = (float) delta.getY() / steps;
        float dz = (float) delta.getZ() / steps;

        for (int i = 0; i <= steps; i++) {
            BlockPos center = startPos.offset(
                    Mth.floor(0.5F + i * dx),
                    Mth.floor(0.5F + i * dy),
                    Mth.floor(0.5F + i * dz));

            if (doPlace) {
                Direction.Axis axis = getLogAxis(startPos, center);
                placeLog(level, trunkSetter, random, center, config,
                        state -> state.trySetValue(RotatedPillarBlock.AXIS, axis));

                // กิ่งหนา 2 block ตามแกนที่ตั้งฉาก
                BlockPos extra = axis == Direction.Axis.X
                        ? center.south()
                        : axis == Direction.Axis.Z
                          ? center.east()
                          : center.east(); // แนวตั้ง

                if (TreeFeature.isAirOrLeaves(level, extra)) {
                    placeLog(level, trunkSetter, random, extra, config,
                            state -> state.trySetValue(RotatedPillarBlock.AXIS, axis));
                }
            } else if (!isFree(level, center)) {
                return false;
            }
        }
        return true;
    }

    private Direction.Axis getLogAxis(BlockPos start, BlockPos end) {
        int xdiff = Math.abs(end.getX() - start.getX());
        int zdiff = Math.abs(end.getZ() - start.getZ());
        int maxdiff = Math.max(xdiff, zdiff);
        if (maxdiff > 0) {
            return xdiff == maxdiff ? Direction.Axis.X : Direction.Axis.Z;
        }
        return Direction.Axis.Y;
    }

    private boolean trimBranches(int height, int localY) {
        return localY >= height * 0.2;
    }

    private void makeBranches(WorldGenLevel level, BiConsumer<BlockPos, BlockState> trunkSetter,
                              RandomSource random, int height, BlockPos origin,
                              List<FoliageCoords> foliageCoords, TreeConfiguration config) {
        for (FoliageCoords coord : foliageCoords) {
            int branchBase = coord.getBranchBase();
            BlockPos baseCoord = new BlockPos(origin.getX(), branchBase, origin.getZ());
            if (!baseCoord.equals(coord.attachment.pos()) && trimBranches(height, branchBase - origin.getY())) {
                makeLimb(level, trunkSetter, random, baseCoord, coord.attachment.pos(), true, config);
            }
        }
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

    // ── Inner class ───────────────────────────────────────────────
    private static class FoliageCoords {
        final FoliagePlacer.FoliageAttachment attachment;
        final int branchBase;

        FoliageCoords(BlockPos pos, int branchBase) {
            this.attachment = new FoliagePlacer.FoliageAttachment(pos, 0, false);
            this.branchBase = branchBase;
        }

        int getBranchBase() {
            return branchBase;
        }
    }
}
