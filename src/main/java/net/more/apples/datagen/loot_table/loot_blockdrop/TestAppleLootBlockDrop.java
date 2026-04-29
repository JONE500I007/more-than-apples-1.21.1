package net.more.apples.datagen.loot_table.loot_blockdrop;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;

import java.util.concurrent.CompletableFuture;

public class TestAppleLootBlockDrop extends FabricBlockLootSubProvider {
    public TestAppleLootBlockDrop(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(TestAppleWoodBlocks.TEST_APPLE_LOG);
        dropSelf(TestAppleWoodBlocks.TEST_APPLE_WOOD);
        dropSelf(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG);
        dropSelf(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD);
        dropSelf(TestAppleWoodBlocks.TEST_APPLE_PLANKS);
        dropSelf(TestAppleWoodBlocks.TEST_APPLE_SAPLING);

        dropSelf(TestAppleWoodVariants.TEST_APPLE_STAIRS);
        add(TestAppleWoodVariants.TEST_APPLE_SLAB, createSlabItemTable(TestAppleWoodVariants.TEST_APPLE_SLAB));

        dropSelf(TestAppleWoodVariants.TEST_APPLE_BUTTON);
        dropSelf(TestAppleWoodVariants.TEST_APPLE_PRESSURE_PLATE);

        dropSelf(TestAppleWoodVariants.TEST_APPLE_FENCE);
        dropSelf(TestAppleWoodVariants.TEST_APPLE_FENCE_GATE);

        add(TestAppleWoodVariants.TEST_APPLE_DOOR, createDoorTable(TestAppleWoodVariants.TEST_APPLE_DOOR));
        dropSelf(TestAppleWoodVariants.TEST_APPLE_TRAPDOOR);

        dropSelf(TestAppleWoodVariants.TEST_APPLE_STANDING_SIGN);
        add(TestAppleWoodVariants.TEST_APPLE_WALL_SIGN, createSingleItemTable(TestAppleWoodVariants.TEST_APPLE_STANDING_SIGN));
        dropSelf(TestAppleWoodVariants.TEST_APPLE_HANGING_SIGN_BLOCK);
        add(TestAppleWoodVariants.TEST_APPLE_WALL_HANGING_SIGN, createSingleItemTable(TestAppleWoodVariants.TEST_APPLE_HANGING_SIGN_BLOCK));
    }
}
