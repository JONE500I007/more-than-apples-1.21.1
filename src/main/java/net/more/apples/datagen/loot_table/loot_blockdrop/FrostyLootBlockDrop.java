package net.more.apples.datagen.loot_table.loot_blockdrop;

import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.datagen.provider.ModLootBlockDrop;

public final class FrostyLootBlockDrop {
    private FrostyLootBlockDrop() {
    }

    public static void addLoot(ModLootBlockDrop provider) {
        // --- Frosty Apple Wood Blocks ---
        provider.drop(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG);
        provider.drop(FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD);
        provider.drop(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG);
        provider.drop(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD);
        provider.drop(FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS);
        provider.drop(FrostyAppleWoodBlocks.FROSTY_APPLE_SAPLING);

        // --- Frosty Apple Wood Variants ---
        provider.drop(FrostyAppleWoodVariants.FROSTY_APPLE_STAIRS);
        provider.addSlabLoot(FrostyAppleWoodVariants.FROSTY_APPLE_SLAB);

        provider.drop(FrostyAppleWoodVariants.FROSTY_APPLE_BUTTON);
        provider.drop(FrostyAppleWoodVariants.FROSTY_APPLE_PRESSURE_PLATE);

        provider.drop(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE);
        provider.drop(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE);

        provider.addDoorLoot(FrostyAppleWoodVariants.FROSTY_APPLE_DOOR);
        provider.drop(FrostyAppleWoodVariants.FROSTY_APPLE_TRAPDOOR);

        // --- Frosty Apple Signs ---
        provider.drop(FrostyAppleWoodVariants.FROSTY_APPLE_STANDING_SIGN);

        provider.addWallSignLoot(
                FrostyAppleWoodVariants.FROSTY_APPLE_WALL_SIGN,
                FrostyAppleWoodVariants.FROSTY_APPLE_STANDING_SIGN
        );

        provider.drop(FrostyAppleWoodVariants.FROSTY_APPLE_HANGING_SIGN_BLOCK);

        provider.addWallHangingSignLoot(
                FrostyAppleWoodVariants.FROSTY_APPLE_WALL_HANGING_SIGN,
                FrostyAppleWoodVariants.FROSTY_APPLE_HANGING_SIGN_BLOCK
        );
    }
}
