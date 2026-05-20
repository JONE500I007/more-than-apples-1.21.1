package net.more.apples.world.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.more.apples.MoreThanApples;
import net.more.apples.world.config_feature.AppleTreeConfig;
import net.more.apples.world.config_feature.FrostyTreeConfig;
import net.more.apples.world.config_feature.AncientAppleTreeConfig;
import net.more.apples.world.config_feature.TestAppleTreeConfig;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final TreeGrower APPLE = new TreeGrower(
            MoreThanApples.MOD_ID + "apple",
            0.25F,
            Optional.empty(),
            Optional.empty(),
            Optional.of(AppleTreeConfig.APPLE_TREE_KEY), // small tree
            Optional.of(AppleTreeConfig.LARGE_APPLE_KEY), // large tree
            Optional.empty(),
            Optional.of(AppleTreeConfig.APPLE_TREE_KEY));

    public static final TreeGrower TEST_APPLE = new TreeGrower(
            MoreThanApples.MOD_ID + "test_apple",
            Optional.empty(),
            Optional.of(TestAppleTreeConfig.TEST_APPLE_TREE_KEY),
            Optional.empty());

    public static final TreeGrower GOLDEN_APPLE = new TreeGrower(
            MoreThanApples.MOD_ID + "golden_apple",
            Optional.empty(),
            Optional.of(AppleTreeConfig.LARGE_GOLDEN_APPLE_KEY),
            Optional.empty());

    public static final TreeGrower FROSTY_APPLE = new TreeGrower(
            MoreThanApples.MOD_ID + "frosty_apple",
            Optional.empty(),
            Optional.of(FrostyTreeConfig.FROSTY_APPLE_TREE_KEY),
            Optional.empty());

    public static final TreeGrower HUGE_APPLE = new TreeGrower(
            MoreThanApples.MOD_ID + "huge_apple",
            Optional.empty(),
            Optional.of(AncientAppleTreeConfig.ANCIENT_APPLE_KEY),
            Optional.empty());
}
