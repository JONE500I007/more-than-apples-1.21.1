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

        this.dropSelf(ModBlocks2.APPLE_STAIRS);
        this.dropSelf(ModBlocks2.APPLE_SLAB);

        this.dropSelf(ModBlocks2.APPLE_BUTTON);
        this.dropSelf(ModBlocks2.APPLE_PRESSURE_PLATE);

        this.dropSelf(ModBlocks2.APPLE_FENCE);
        this.dropSelf(ModBlocks2.APPLE_FENCE_GATE);
//        addDrop(ModBlocks2.APPLE_WALL);

        this.add(ModBlocks2.APPLE_DOOR, this.createDoorTable(ModBlocks2.APPLE_DOOR));
        this.dropSelf(ModBlocks2.APPLE_TRAPDOOR);

        this.dropSelf(ModBlocks2.APPLE_LOG);
        this.dropSelf(ModBlocks2.APPLE_WOOD);
        this.dropSelf(ModBlocks2.STRIPPED_APPLE_LOG);
        this.dropSelf(ModBlocks2.STRIPPED_APPLE_WOOD);
        this.dropSelf(ModBlocks2.APPLE_PLANKS);
        this.dropSelf(ModBlocks2.APPLE_SAPLING);
        this.dropSelf(ModBlocks2.GOLDEN_APPLE_SAPLING);

        this.dropSelf(ModBlocks2.APPLE_STANDING_SIGN);
        this.add(ModBlocks2.APPLE_WALL_SIGN, this.createSingleItemTable(ModBlocks2.APPLE_STANDING_SIGN));
        this.dropSelf(ModBlocks2.APPLE_HANGING_SIGN_BLOCK);
        this.add(ModBlocks2.APPLE_WALL_HANGING_SIGN, this.createSingleItemTable(ModBlocks2.APPLE_HANGING_SIGN_BLOCK));


        this.dropSelf(ModBlocks2.TEST_APPLE_LOG);
        this.dropSelf(ModBlocks2.TEST_APPLE_WOOD);
        this.dropSelf(ModBlocks2.STRIPPED_TEST_APPLE_LOG);
        this.dropSelf(ModBlocks2.STRIPPED_TEST_APPLE_WOOD);
        this.dropSelf(ModBlocks2.TEST_APPLE_PLANKS);
        this.dropSelf(ModBlocks2.TEST_APPLE_SAPLING);

        this.dropSelf(ModBlocks2.TEST_APPLE_STAIRS);
        this.add(ModBlocks2.TEST_APPLE_SLAB, this.createSlabItemTable(ModBlocks2.TEST_APPLE_SLAB));

        this.dropSelf(ModBlocks2.TEST_APPLE_BUTTON);
        this.dropSelf(ModBlocks2.TEST_APPLE_PRESSURE_PLATE);

        this.dropSelf(ModBlocks2.TEST_APPLE_FENCE);
        this.dropSelf(ModBlocks2.TEST_APPLE_FENCE_GATE);

        this.add(ModBlocks2.TEST_APPLE_DOOR, this.createDoorTable(ModBlocks2.TEST_APPLE_DOOR));
        this.dropSelf(ModBlocks2.TEST_APPLE_TRAPDOOR);

        this.dropSelf(ModBlocks2.TEST_APPLE_STANDING_SIGN);
        this.add(ModBlocks2.TEST_APPLE_WALL_SIGN, this.createSingleItemTable(ModBlocks2.TEST_APPLE_STANDING_SIGN));
        this.dropSelf(ModBlocks2.TEST_APPLE_HANGING_SIGN_BLOCK);
        this.add(ModBlocks2.TEST_APPLE_WALL_HANGING_SIGN, this.createSingleItemTable(ModBlocks2.TEST_APPLE_HANGING_SIGN_BLOCK));

        this.dropSelf(ModBlocks2.APPLE_BARREL);


        this.dropSelf(ModBlocks2.FROSTY_APPLE_LOG);
        this.dropSelf(ModBlocks2.FROSTY_APPLE_WOOD);
        this.dropSelf(ModBlocks2.STRIPPED_FROSTY_APPLE_LOG);
        this.dropSelf(ModBlocks2.STRIPPED_FROSTY_APPLE_WOOD);
        this.dropSelf(ModBlocks2.FROSTY_APPLE_PLANKS);
        this.dropSelf(ModBlocks2.FROSTY_APPLE_SAPLING);

        this.dropSelf(ModBlocks2.FROSTY_APPLE_STAIRS);
        this.add(ModBlocks2.FROSTY_APPLE_SLAB, this.createSlabItemTable(ModBlocks2.FROSTY_APPLE_SLAB));

        this.dropSelf(ModBlocks2.FROSTY_APPLE_BUTTON);
        this.dropSelf(ModBlocks2.FROSTY_APPLE_PRESSURE_PLATE);

        this.dropSelf(ModBlocks2.FROSTY_APPLE_FENCE);
        this.dropSelf(ModBlocks2.FROSTY_APPLE_FENCE_GATE);

        this.add(ModBlocks2.FROSTY_APPLE_DOOR, this.createDoorTable(ModBlocks2.FROSTY_APPLE_DOOR));
        this.dropSelf(ModBlocks2.FROSTY_APPLE_TRAPDOOR);

        this.dropSelf(ModBlocks2.FROSTY_APPLE_STANDING_SIGN);
        this.add(ModBlocks2.FROSTY_APPLE_WALL_SIGN, this.createSingleItemTable(ModBlocks2.FROSTY_APPLE_STANDING_SIGN));
        this.dropSelf(ModBlocks2.FROSTY_APPLE_HANGING_SIGN_BLOCK);
        this.add(ModBlocks2.FROSTY_APPLE_WALL_HANGING_SIGN, this.createSingleItemTable(ModBlocks2.FROSTY_APPLE_HANGING_SIGN_BLOCK));

    }
}
