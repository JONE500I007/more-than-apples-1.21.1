package net.more.apples.datagen.loot_table.loot_blockdrop;

import net.more.apples.block.general_block.ModGeneralBlock;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.datagen.provider.ModLootBlockDrop;

public final class AppleLootBlockDrop {
    private AppleLootBlockDrop() {
    }

    public static void addLoot(ModLootBlockDrop provider) {

        // --- Apple Wood Blocks ---
        provider.drop(AppleWoodBlocks.APPLE_LOG);
        provider.drop(AppleWoodBlocks.APPLE_WOOD);
        provider.drop(AppleWoodBlocks.STRIPPED_APPLE_LOG);
        provider.drop(AppleWoodBlocks.STRIPPED_APPLE_WOOD);
        provider.drop(AppleWoodBlocks.APPLE_PLANKS);
        provider.drop(AppleWoodBlocks.APPLE_SAPLING);

        // --- Apple Wood Variants ---
        provider.drop(AppleWoodVariants.APPLE_STAIRS);
        provider.addSlabLoot(AppleWoodVariants.APPLE_SLAB);

        provider.drop(AppleWoodVariants.APPLE_BUTTON);
        provider.drop(AppleWoodVariants.APPLE_PRESSURE_PLATE);

        provider.drop(AppleWoodVariants.APPLE_FENCE);
        provider.drop(AppleWoodVariants.APPLE_FENCE_GATE);

        provider.addDoorLoot(AppleWoodVariants.APPLE_DOOR);
        provider.drop(AppleWoodVariants.APPLE_TRAPDOOR);

        // --- Apple Signs ---
        provider.drop(AppleWoodVariants.APPLE_STANDING_SIGN);

        provider.addWallSignLoot(
                AppleWoodVariants.APPLE_WALL_SIGN,
                AppleWoodVariants.APPLE_STANDING_SIGN
        );

        provider.drop(AppleWoodVariants.APPLE_HANGING_SIGN_BLOCK);

        provider.addWallHangingSignLoot(
                AppleWoodVariants.APPLE_WALL_HANGING_SIGN,
                AppleWoodVariants.APPLE_HANGING_SIGN_BLOCK
        );

        // --- Apple Storage ---
        provider.drop(ModGeneralBlock.APPLE_BARREL);
    }
}
