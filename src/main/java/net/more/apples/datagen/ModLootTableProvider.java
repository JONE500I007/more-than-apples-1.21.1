package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;

import net.minecraft.core.HolderLookup;
import net.more.apples.block.ModBlocks2;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootSubProvider {
    public ModLootTableProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
//        addDrop(ModBlocks2.APPLE_PLANKS);
//        addDrop(ModBlocks2.APPLE_ORE, oreDrops(ModBlocks2.APPLE_ORE, Items.APPLE));
//        addDrop(ModBlocks2.APPLE_ORE, oreDrops(ModBlocks2.APPLE_ORE, ModItems.DIAMOND_APPLE));

        //this.dropSelf(ModBlocks2.APPLE_STAIRS);
        dropSelf(ModBlocks2.APPLE_STAIRS);
        dropSelf(ModBlocks2.APPLE_SLAB);

        dropSelf(ModBlocks2.APPLE_BUTTON);
        dropSelf(ModBlocks2.APPLE_PRESSURE_PLATE);

        dropSelf(ModBlocks2.APPLE_FENCE);
        dropSelf(ModBlocks2.APPLE_FENCE_GATE);
//        addDrop(ModBlocks2.APPLE_WALL);

        add(ModBlocks2.APPLE_DOOR, createDoorTable(ModBlocks2.APPLE_DOOR));
        dropSelf(ModBlocks2.APPLE_TRAPDOOR);

        dropSelf(ModBlocks2.APPLE_LOG);
        dropSelf(ModBlocks2.APPLE_WOOD);
        dropSelf(ModBlocks2.STRIPPED_APPLE_LOG);
        dropSelf(ModBlocks2.STRIPPED_APPLE_WOOD);
        dropSelf(ModBlocks2.APPLE_PLANKS);
        dropSelf(ModBlocks2.APPLE_SAPLING);
        dropSelf(ModBlocks2.GOLDEN_APPLE_SAPLING);

        dropSelf(ModBlocks2.APPLE_STANDING_SIGN);
        add(ModBlocks2.APPLE_WALL_SIGN, createSingleItemTable(ModBlocks2.APPLE_STANDING_SIGN));
        dropSelf(ModBlocks2.APPLE_HANGING_SIGN_BLOCK);
        add(ModBlocks2.APPLE_WALL_HANGING_SIGN, createSingleItemTable(ModBlocks2.APPLE_HANGING_SIGN_BLOCK));


        dropSelf(ModBlocks2.TEST_APPLE_LOG);
        dropSelf(ModBlocks2.TEST_APPLE_WOOD);
        dropSelf(ModBlocks2.STRIPPED_TEST_APPLE_LOG);
        dropSelf(ModBlocks2.STRIPPED_TEST_APPLE_WOOD);
        dropSelf(ModBlocks2.TEST_APPLE_PLANKS);
        dropSelf(ModBlocks2.TEST_APPLE_SAPLING);

        dropSelf(ModBlocks2.TEST_APPLE_STAIRS);
        add(ModBlocks2.TEST_APPLE_SLAB, createSlabItemTable(ModBlocks2.TEST_APPLE_SLAB));

        dropSelf(ModBlocks2.TEST_APPLE_BUTTON);
        dropSelf(ModBlocks2.TEST_APPLE_PRESSURE_PLATE);

        dropSelf(ModBlocks2.TEST_APPLE_FENCE);
        dropSelf(ModBlocks2.TEST_APPLE_FENCE_GATE);

        add(ModBlocks2.TEST_APPLE_DOOR, createDoorTable(ModBlocks2.TEST_APPLE_DOOR));
        dropSelf(ModBlocks2.TEST_APPLE_TRAPDOOR);

        dropSelf(ModBlocks2.TEST_APPLE_STANDING_SIGN);
        add(ModBlocks2.TEST_APPLE_WALL_SIGN, createSingleItemTable(ModBlocks2.TEST_APPLE_STANDING_SIGN));
        dropSelf(ModBlocks2.TEST_APPLE_HANGING_SIGN_BLOCK);
        add(ModBlocks2.TEST_APPLE_WALL_HANGING_SIGN, createSingleItemTable(ModBlocks2.TEST_APPLE_HANGING_SIGN_BLOCK));

        dropSelf(ModBlocks2.APPLE_BARREL);


        dropSelf(ModBlocks2.FROSTY_APPLE_LOG);
        dropSelf(ModBlocks2.FROSTY_APPLE_WOOD);
        dropSelf(ModBlocks2.STRIPPED_FROSTY_APPLE_LOG);
        dropSelf(ModBlocks2.STRIPPED_FROSTY_APPLE_WOOD);
        dropSelf(ModBlocks2.FROSTY_APPLE_PLANKS);
        dropSelf(ModBlocks2.FROSTY_APPLE_SAPLING);

        dropSelf(ModBlocks2.FROSTY_APPLE_STAIRS);
        add(ModBlocks2.FROSTY_APPLE_SLAB, createSlabItemTable(ModBlocks2.FROSTY_APPLE_SLAB));

        dropSelf(ModBlocks2.FROSTY_APPLE_BUTTON);
        dropSelf(ModBlocks2.FROSTY_APPLE_PRESSURE_PLATE);

        dropSelf(ModBlocks2.FROSTY_APPLE_FENCE);
        dropSelf(ModBlocks2.FROSTY_APPLE_FENCE_GATE);

        add(ModBlocks2.FROSTY_APPLE_DOOR, createDoorTable(ModBlocks2.FROSTY_APPLE_DOOR));
        dropSelf(ModBlocks2.FROSTY_APPLE_TRAPDOOR);

        dropSelf(ModBlocks2.FROSTY_APPLE_STANDING_SIGN);
        add(ModBlocks2.FROSTY_APPLE_WALL_SIGN, createSingleItemTable(ModBlocks2.FROSTY_APPLE_STANDING_SIGN));
        dropSelf(ModBlocks2.FROSTY_APPLE_HANGING_SIGN_BLOCK);
        add(ModBlocks2.FROSTY_APPLE_WALL_HANGING_SIGN, createSingleItemTable(ModBlocks2.FROSTY_APPLE_HANGING_SIGN_BLOCK));

    }
}
