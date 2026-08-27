package net.more.apples.datagen.loot_table.loot_blockdrop;

import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodVariants;
import net.more.apples.datagen.provider.ModLootBlockDrop;

public final class AncientAppleBlockDrop {
    private AncientAppleBlockDrop() {
    }

    public static void addLoot(ModLootBlockDrop provider) {
        // --- Test Apple Wood Blocks ---
        provider.drop(AncientAppleWoodBlocks.ANCIENT_APPLE_LOG);
        provider.drop(AncientAppleWoodBlocks.ANCIENT_APPLE_WOOD);
        provider.drop(AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG);
        provider.drop(AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_WOOD);
        provider.drop(AncientAppleWoodBlocks.ANCIENT_APPLE_PLANKS);
        provider.drop(AncientAppleWoodBlocks.ANCIENT_APPLE_SAPLING);

        // --- Test Apple Wood Variants ---
        provider.drop(AncientAppleWoodVariants.ANCIENT_APPLE_STAIRS);
        provider.addSlabLoot(AncientAppleWoodVariants.ANCIENT_APPLE_SLAB);

        provider.drop(AncientAppleWoodVariants.ANCIENT_APPLE_BUTTON);
        provider.drop(AncientAppleWoodVariants.ANCIENT_APPLE_PRESSURE_PLATE);

        provider.drop(AncientAppleWoodVariants.ANCIENT_APPLE_FENCE);
        provider.drop(AncientAppleWoodVariants.ANCIENT_APPLE_FENCE_GATE);

        provider.addDoorLoot(AncientAppleWoodVariants.ANCIENT_APPLE_DOOR);
        provider.drop(AncientAppleWoodVariants.ANCIENT_APPLE_TRAPDOOR);

        // --- Apple Shelf ---
        provider.drop(AncientAppleWoodVariants.ANCIENT_APPLE_SHELF);

        // --- Test Apple Signs ---
        provider.drop(AncientAppleWoodVariants.ANCIENT_APPLE_STANDING_SIGN);

        provider.addWallSignLoot(
                AncientAppleWoodVariants.ANCIENT_APPLE_WALL_SIGN,
                AncientAppleWoodVariants.ANCIENT_APPLE_STANDING_SIGN
        );

        provider.drop(AncientAppleWoodVariants.ANCIENT_APPLE_HANGING_SIGN_BLOCK);

        provider.addWallHangingSignLoot(
                AncientAppleWoodVariants.ANCIENT_APPLE_WALL_HANGING_SIGN,
                AncientAppleWoodVariants.ANCIENT_APPLE_HANGING_SIGN_BLOCK
        );
    }
}
