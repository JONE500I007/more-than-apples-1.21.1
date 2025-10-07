package net.more.apples.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.more.apples.MoreThanApples;
import net.more.apples.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator APPLE = new SaplingGenerator(
            MoreThanApples.MOD_ID + "apple",
            0.25F,
            Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.APPLE_TREE_KEY), // small tree
            Optional.of(ModConfiguredFeatures.LARGE_APPLE_KEY), // large tree
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.APPLE_TREE_KEY));

    public static final SaplingGenerator TEST_APPLE = new SaplingGenerator(
            MoreThanApples.MOD_ID + "test_apple",
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.TEST_APPLE_TREE_KEY),
            Optional.empty());

    public static final SaplingGenerator GOLDEN_APPLE = new SaplingGenerator(
            MoreThanApples.MOD_ID + "golden_apple",
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.LARGE_GOLDEN_APPLE_KEY),
            Optional.empty());
}

