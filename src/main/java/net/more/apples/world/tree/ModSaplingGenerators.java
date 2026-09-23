package net.more.apples.world.tree;

import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.more.apples.MoreThanApples;
import net.more.apples.world.config_feature.AppleTreeConfig;
import net.more.apples.world.config_feature.FrostyTreeConfig;
import net.more.apples.world.config_feature.AncientAppleTreeConfig;
import net.more.apples.world.config_feature.TestAppleTreeConfig;


public class ModSaplingGenerators {
    public static final TreeGrower APPLE = new TreeGrower(
            MoreThanApples.MOD_ID + "apple",
            // 75% small tree, 25% large tree (same odds as the old 0.25F secondaryChance)
            WeightedList.of(new Weighted<>(AppleTreeConfig.APPLE_TREE_KEY, 3), new Weighted<>(AppleTreeConfig.LARGE_APPLE_KEY, 1)),
            WeightedList.of(),
            WeightedList.of(),
            AppleTreeConfig.APPLE_TREE_KEY);

    public static final TreeGrower TEST_APPLE = new TreeGrower(
            MoreThanApples.MOD_ID + "test_apple",
            WeightedList.of(TestAppleTreeConfig.TEST_APPLE_TREE_KEY),
            WeightedList.of(),
            WeightedList.of(),
            TestAppleTreeConfig.TEST_APPLE_TREE_KEY);

    public static final TreeGrower GOLDEN_APPLE = new TreeGrower(
            MoreThanApples.MOD_ID + "golden_apple",
            WeightedList.of(AppleTreeConfig.LARGE_GOLDEN_APPLE_KEY),
            WeightedList.of(),
            WeightedList.of(),
            AppleTreeConfig.LARGE_GOLDEN_APPLE_KEY);

    public static final TreeGrower FROSTY_APPLE = new TreeGrower(
            MoreThanApples.MOD_ID + "frosty_apple",
            WeightedList.of(FrostyTreeConfig.FROSTY_APPLE_TREE_KEY),
            WeightedList.of(),
            WeightedList.of(),
            FrostyTreeConfig.FROSTY_APPLE_TREE_KEY);

    public static final TreeGrower ANCIENT_APPLE = new TreeGrower(
            MoreThanApples.MOD_ID + "ancient_apple",
            WeightedList.of(AncientAppleTreeConfig.ANCIENT_APPLE_KEY),
            WeightedList.of(),
            WeightedList.of(),
            AncientAppleTreeConfig.ANCIENT_APPLE_KEY);

    public static final TreeGrower ANCIENT_APPLE2 = new TreeGrower(
            MoreThanApples.MOD_ID + "ancient_apple2",
            WeightedList.of(AncientAppleTreeConfig.ANCIENT_APPLE_KEY2),
            WeightedList.of(),
            WeightedList.of(),
            AncientAppleTreeConfig.ANCIENT_APPLE_KEY2);
}
