package net.more.apples.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.more.apples.MoreThanApples;
import net.more.apples.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator APPLE = new SaplingGenerator(MoreThanApples.MOD_ID + ":apple",
            Optional.empty(), Optional.of(ModConfiguredFeatures.APPLE_TREE_KEY), Optional.empty());
}
