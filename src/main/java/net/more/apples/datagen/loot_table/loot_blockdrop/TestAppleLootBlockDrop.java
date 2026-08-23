package net.more.apples.datagen.loot_table.loot_blockdrop;

import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;
import net.more.apples.datagen.provider.ModLootBlockDrop;

public final class TestAppleLootBlockDrop {
    private TestAppleLootBlockDrop() {
    }

    public static void addLoot(ModLootBlockDrop provider) {
        // --- Test Apple Wood Blocks ---
        provider.drop(TestAppleWoodBlocks.TEST_APPLE_LOG);
        provider.drop(TestAppleWoodBlocks.TEST_APPLE_WOOD);
        provider.drop(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG);
        provider.drop(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD);
        provider.drop(TestAppleWoodBlocks.TEST_APPLE_PLANKS);
        provider.drop(TestAppleWoodBlocks.TEST_APPLE_SAPLING);

        // --- Test Apple Wood Variants ---
        provider.drop(TestAppleWoodVariants.TEST_APPLE_STAIRS);
        provider.addSlabLoot(TestAppleWoodVariants.TEST_APPLE_SLAB);

        provider.drop(TestAppleWoodVariants.TEST_APPLE_BUTTON);
        provider.drop(TestAppleWoodVariants.TEST_APPLE_PRESSURE_PLATE);

        provider.drop(TestAppleWoodVariants.TEST_APPLE_FENCE);
        provider.drop(TestAppleWoodVariants.TEST_APPLE_FENCE_GATE);

        provider.addDoorLoot(TestAppleWoodVariants.TEST_APPLE_DOOR);
        provider.drop(TestAppleWoodVariants.TEST_APPLE_TRAPDOOR);

        // --- Apple Shelf ---
        provider.drop(TestAppleWoodVariants.TEST_APPLE_SHELF);

        // --- Test Apple Signs ---
        provider.drop(TestAppleWoodVariants.TEST_APPLE_STANDING_SIGN);

        provider.addWallSignLoot(
                TestAppleWoodVariants.TEST_APPLE_WALL_SIGN,
                TestAppleWoodVariants.TEST_APPLE_STANDING_SIGN
        );

        provider.drop(TestAppleWoodVariants.TEST_APPLE_HANGING_SIGN_BLOCK);

        provider.addWallHangingSignLoot(
                TestAppleWoodVariants.TEST_APPLE_WALL_HANGING_SIGN,
                TestAppleWoodVariants.TEST_APPLE_HANGING_SIGN_BLOCK
        );
    }
}
