package net.more.apples.world.tree.custom.huge_apple;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviders;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.more.apples.world.tree.ModFoliagePlacerType;

public class HugeAppleFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<HugeAppleFoliagePlacer> CODEC =
            RecordCodecBuilder.mapCodec(i -> i.group(
                    IntProviders.codec(0, 256).fieldOf("radius").forGetter(p -> p.radius),
                    IntProviders.codec(0, 256).fieldOf("offset").forGetter(p -> p.offset),
                    Codec.intRange(0, 256).fieldOf("height").forGetter(p -> p.height)
            ).apply(i, HugeAppleFoliagePlacer::new));

    private final int height;

    public HugeAppleFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacerType.HUGE_APPLE_FOLIAGE_PLACER;
    }

    @Override
    protected void createFoliage(WorldGenLevel level, FoliageSetter foliageSetter,
                                 RandomSource random, TreeConfiguration config,
                                 int treeHeight, FoliageAttachment attachment,
                                 int foliageHeight, int leafRadius, int offset) {

        boolean giant = attachment.doubleTrunk();

        for (int yo = offset; yo >= offset - foliageHeight; yo--) {
            int layer = offset - yo;
            float progress = (float) layer / Math.max(1, foliageHeight);

            // ทรงกลมรี ใหญ่กลาง เล็กบนล่าง
            int currentRadius = Math.round(
                    leafRadius * (float) Math.sin(Math.PI * progress)
                            + leafRadius * 0.5f  // minimum radius
                            + attachment.radiusOffset()
            );

            placeLeavesRow(level, foliageSetter, random, config,
                    attachment.pos(), currentRadius, yo, giant);
        }
    }

    @Override
    public int foliageHeight(RandomSource random, int treeHeight, TreeConfiguration config) {
        return this.height;
    }

    @Override
    public int foliageRadius(RandomSource random, int trunkHeight) {
        return this.radius.sample(random);
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int dx, int y, int dz,
                                         int currentRadius, boolean doubleTrunk) {
        return Mth.square(dx + 0.5F) + Mth.square(dz + 0.5F) > currentRadius * currentRadius;
    }
}