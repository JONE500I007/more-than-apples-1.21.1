package net.more.apples.world.tree.custom.huge_apple;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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

public class HugeAppleTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<HugeAppleTrunkPlacer> CODEC =
            RecordCodecBuilder.mapCodec(i -> i.group(
                    // ขยาย range จาก 32 เป็น 128 ได้เลย
                    Codec.intRange(0, 128).fieldOf("base_height").forGetter(p -> p.baseHeight),
                    Codec.intRange(0, 64).fieldOf("height_rand_a").forGetter(p -> p.heightRandA),
                    Codec.intRange(0, 64).fieldOf("height_rand_b").forGetter(p -> p.heightRandB)
            ).apply(i, HugeAppleTrunkPlacer::new));

    private static final double TRUNK_HEIGHT_SCALE = 0.618;
    private static final double BRANCH_SLOPE = 0.381;
    private static final double BRANCH_LENGTH_MAGIC = 0.328;

    public HugeAppleTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerType.HUGE_APPLE_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(
            WorldGenLevel level,
            BiConsumer<BlockPos, BlockState> trunkSetter,
            RandomSource random,
            int treeHeight,
            BlockPos origin,
            TreeConfiguration config) {

        // ── รากโคนต้น (แบบ DarkOak แต่ใหญ่กว่า) ──────────────────
        BlockPos below = origin.below();
        placeBelowTrunkBlock(level, trunkSetter, random, below, config);
        placeBelowTrunkBlock(level, trunkSetter, random, below.east(), config);
        placeBelowTrunkBlock(level, trunkSetter, random, below.south(), config);
        placeBelowTrunkBlock(level, trunkSetter, random, below.south().east(), config);

        // รากยื่นออกมาจากโคน
        placeRoots(level, trunkSetter, random, origin, config);

        // ── ลำต้นหลัก 2x2 ──────────────────────────────────────────
        int trunkHeight = Mth.floor(treeHeight * TRUNK_HEIGHT_SCALE);

        for (int y = 0; y < trunkHeight; y++) {
            BlockPos base = origin.above(y);
            if (TreeFeature.isAirOrLeaves(level, base)) {
                placeLog(level, trunkSetter, random, base, config);
                placeLog(level, trunkSetter, random, base.east(), config);
                placeLog(level, trunkSetter, random, base.south(), config);
                placeLog(level, trunkSetter, random, base.east().south(), config);
            }
        }

        // ── กิ่งก้าน (แบบ FancyTrunkPlacer) ──────────────────────
        int height = treeHeight + 2;
        int clustersPerY = Math.min(2, Mth.floor(1.382 + Math.pow(1.0 * height / 13.0, 2.0)));
        int trunkTop = origin.getY() + trunkHeight;
        int relativeY = height - 5;

        List<FoliageCoords> foliageCoords = new ArrayList<>();
        foliageCoords.add(new FoliageCoords(origin.above(relativeY), trunkTop));

        for (; relativeY >= 0; relativeY--) {
            float shape = treeShape(height, relativeY);
            if (shape < 0.0F) continue;

            for (int i = 0; i < clustersPerY; i++) {
                // scale radius ขึ้น 1.5x เพื่อให้กิ่งแผ่กว้างกว่า vanilla
                double radius = 1.5 * shape * (random.nextFloat() + BRANCH_LENGTH_MAGIC);
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

    // ── รากยื่นออกมาจากโคน ──────────────────────────────────────
    private void placeRoots(WorldGenLevel level,
                            BiConsumer<BlockPos, BlockState> trunkSetter,
                            RandomSource random,
                            BlockPos origin,
                            TreeConfiguration config) {
        // วนรอบทิศทาง รากยื่นออกไป 2-4 block
        for (Direction dir : Direction.Plane.HORIZONTAL) {
            int rootLength = random.nextIntBetweenInclusive(2, 4);

            for (int i = 1; i <= rootLength; i++) {
                BlockPos rootPos = origin.relative(dir, i);
                // รากจะค่อยๆ ลงต่ำ
                int rootY = -Math.max(0, i - 1);
                BlockPos finalPos = rootPos.above(rootY);

                if (TreeFeature.isAirOrLeaves(level, finalPos)) {
                    placeLog(level, trunkSetter, random, finalPos, config,
                            state -> state.setValue(RotatedPillarBlock.AXIS, dir.getAxis()));
                }
            }
        }

        // รากแนวทแยง
        for (int ox = -1; ox <= 2; ox++) {
            for (int oz = -1; oz <= 2; oz++) {
                if ((ox < 0 || ox > 1 || oz < 0 || oz > 1) && random.nextInt(3) <= 1) {
                    int length = random.nextInt(3) + 1;
                    for (int i = 0; i < length; i++) {
                        BlockPos rootPos = new BlockPos(
                                origin.getX() + ox,
                                origin.getY() - i,
                                origin.getZ() + oz);
                        if (TreeFeature.isAirOrLeaves(level, rootPos)) {
                            placeLog(level, trunkSetter, random, rootPos, config);
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
            BlockPos pos = startPos.offset(
                    Mth.floor(0.5F + i * dx),
                    Mth.floor(0.5F + i * dy),
                    Mth.floor(0.5F + i * dz));
            if (doPlace) {
                placeLog(level, trunkSetter, random, pos, config,
                        state -> state.trySetValue(RotatedPillarBlock.AXIS,
                                getLogAxis(startPos, pos)));
            } else if (!isFree(level, pos)) {
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
