package net.more.apples.world.tree;

import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.more.apples.MoreThanApples;
import net.more.apples.mixin.TrunkPlacerTypeInvoker;
import net.more.apples.world.tree.custom.FrostyAppleTrunkPlacer;
import net.more.apples.world.tree.custom.TestAppleTrunkPlacer;

public class ModTrunkPlacerType {
    public static final TrunkPlacerType<?> FROSTY_TRUNK_PLACER =
            TrunkPlacerTypeInvoker.callRegister("frosty_apple_trunk_placer", FrostyAppleTrunkPlacer.CODEC);

    public static final TrunkPlacerType<?> TEST_TRUNK_PLACER =
            TrunkPlacerTypeInvoker.callRegister("test_apple_trunk_placer", TestAppleTrunkPlacer.CODEC);

    public static void register() {
        MoreThanApples.LOGGER.info("Registering Trunk Placer for" + MoreThanApples.MOD_ID);
    }


    /*
    public static final TrunkPlacerType<ChestnutTrunkPlacer> CHESTNUT_TRUNK_PLACER2 =
            Registry.register(Registries.TRUNK_PLACER_TYPE, Identifier.of(MoreThanApples.MOD_ID, "chestnut_trunk_placer"),
                    new TrunkPlacerType<>(ChestnutTrunkPlacer.CODEC));
     */
}
