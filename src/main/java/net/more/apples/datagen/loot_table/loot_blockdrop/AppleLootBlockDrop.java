package net.more.apples.datagen.loot_table.loot_blockdrop;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.more.apples.block.general_block.ModGeneralBlock;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;

import java.util.concurrent.CompletableFuture;

public class AppleLootBlockDrop extends FabricBlockLootSubProvider {
    public AppleLootBlockDrop(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(AppleWoodBlocks.APPLE_LOG);
        dropSelf(AppleWoodBlocks.APPLE_WOOD);
        dropSelf(AppleWoodBlocks.STRIPPED_APPLE_LOG);
        dropSelf(AppleWoodBlocks.STRIPPED_APPLE_WOOD);
        dropSelf(AppleWoodBlocks.APPLE_PLANKS);
        dropSelf(AppleWoodBlocks.APPLE_SAPLING);

        dropSelf(AppleWoodVariants.APPLE_STAIRS);
        add(AppleWoodVariants.APPLE_SLAB, createSlabItemTable(AppleWoodVariants.APPLE_SLAB));

        dropSelf(AppleWoodVariants.APPLE_BUTTON);
        dropSelf(AppleWoodVariants.APPLE_PRESSURE_PLATE);

        dropSelf(AppleWoodVariants.APPLE_FENCE);
        dropSelf(AppleWoodVariants.APPLE_FENCE_GATE);

        add(AppleWoodVariants.APPLE_DOOR, createDoorTable(AppleWoodVariants.APPLE_DOOR));
        dropSelf(AppleWoodVariants.APPLE_TRAPDOOR);

        dropSelf(AppleWoodVariants.APPLE_STANDING_SIGN);
        add(AppleWoodVariants.APPLE_WALL_SIGN, createSingleItemTable(AppleWoodVariants.APPLE_STANDING_SIGN));
        dropSelf(AppleWoodVariants.APPLE_HANGING_SIGN_BLOCK);
        add(AppleWoodVariants.APPLE_WALL_HANGING_SIGN, createSingleItemTable(AppleWoodVariants.APPLE_HANGING_SIGN_BLOCK));
        

        dropSelf(ModGeneralBlock.APPLE_BARREL);
    }
}
