package net.more.apples.world.tree;

import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.more.apples.MoreThanApples;
import net.more.apples.mixin.FoliagePlacerTypeInvoker;
import net.more.apples.world.tree.custom.frosty_tree.FrostyAppleFoliagePlacer;
import net.more.apples.world.tree.custom.ancient_apple.AncientAppleFoliagePlacer;

public class ModFoliagePlacerType {
    public static final FoliagePlacerType<?> FROSTY_FOLIAGE_PLACER =
            FoliagePlacerTypeInvoker.callRegister("frosty_apple_foliage_placer", FrostyAppleFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> ANCIENT_APPLE_FOLIAGE_PLACER =
            FoliagePlacerTypeInvoker.callRegister("ancient_apple_foliage_placer", AncientAppleFoliagePlacer.CODEC);

    public static void register() {
        MoreThanApples.LOGGER.info("Registering Foliage Placer for" + MoreThanApples.MOD_ID);
    }
}
