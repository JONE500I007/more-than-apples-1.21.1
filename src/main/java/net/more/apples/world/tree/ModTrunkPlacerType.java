package net.more.apples.world.tree;

import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.more.apples.MoreThanApples;
import net.more.apples.mixin.TrunkPlacerTypeInvoker;
import net.more.apples.world.tree.custom.frosty_tree.FrostyAppleTrunkPlacer;
import net.more.apples.world.tree.custom.huge_apple.HugeAppleTrunkPlacer;
import net.more.apples.world.tree.custom.test_tree.TestAppleTrunkPlacer;

public class ModTrunkPlacerType {
    public static final TrunkPlacerType<?> FROSTY_TRUNK_PLACER =
            TrunkPlacerTypeInvoker.callRegister("frosty_apple_trunk_placer", FrostyAppleTrunkPlacer.CODEC);

    public static final TrunkPlacerType<?> TEST_TRUNK_PLACER =
            TrunkPlacerTypeInvoker.callRegister("test_apple_trunk_placer", TestAppleTrunkPlacer.CODEC);

    public static final TrunkPlacerType<?> HUGE_APPLE_TRUNK_PLACER =
            TrunkPlacerTypeInvoker.callRegister("huge_apple_trunk_placer", HugeAppleTrunkPlacer.CODEC);

    public static void register() {
        MoreThanApples.LOGGER.info("Registering Trunk Placer for" + MoreThanApples.MOD_ID);
    }
}
