package net.more.apples.datagen.loot_table.loot_blockdrop;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;

import java.util.concurrent.CompletableFuture;

public class FrostyAppleLootBlockDrop extends FabricBlockLootSubProvider {
    public FrostyAppleLootBlockDrop(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG);
        dropSelf(FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD);
        dropSelf(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG);
        dropSelf(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD);
        dropSelf(FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS);
        dropSelf(FrostyAppleWoodBlocks.FROSTY_APPLE_SAPLING);

        dropSelf(FrostyAppleWoodVariants.FROSTY_APPLE_STAIRS);
        add(FrostyAppleWoodVariants.FROSTY_APPLE_SLAB, createSlabItemTable(FrostyAppleWoodVariants.FROSTY_APPLE_SLAB));

        dropSelf(FrostyAppleWoodVariants.FROSTY_APPLE_BUTTON);
        dropSelf(FrostyAppleWoodVariants.FROSTY_APPLE_PRESSURE_PLATE);

        dropSelf(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE);
        dropSelf(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE);

        add(FrostyAppleWoodVariants.FROSTY_APPLE_DOOR, createDoorTable(FrostyAppleWoodVariants.FROSTY_APPLE_DOOR));
        dropSelf(FrostyAppleWoodVariants.FROSTY_APPLE_TRAPDOOR);

        dropSelf(FrostyAppleWoodVariants.FROSTY_APPLE_STANDING_SIGN);
        add(FrostyAppleWoodVariants.FROSTY_APPLE_WALL_SIGN, createSingleItemTable(FrostyAppleWoodVariants.FROSTY_APPLE_STANDING_SIGN));
        dropSelf(FrostyAppleWoodVariants.FROSTY_APPLE_HANGING_SIGN_BLOCK);
        add(FrostyAppleWoodVariants.FROSTY_APPLE_WALL_HANGING_SIGN, createSingleItemTable(FrostyAppleWoodVariants.FROSTY_APPLE_HANGING_SIGN_BLOCK));
    }
}
