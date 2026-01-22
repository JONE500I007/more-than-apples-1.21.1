package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.more.apples.block.ModBlocks2;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
//        addDrop(ModBlocks2.APPLE_PLANKS);
//        addDrop(ModBlocks2.APPLE_ORE, oreDrops(ModBlocks2.APPLE_ORE, Items.APPLE));
//        addDrop(ModBlocks2.APPLE_ORE, oreDrops(ModBlocks2.APPLE_ORE, ModItems.DIAMOND_APPLE));

        addDrop(ModBlocks2.APPLE_STAIRS);
        addDrop(ModBlocks2.APPLE_SLAB, slabDrops(ModBlocks2.APPLE_SLAB));

        addDrop(ModBlocks2.APPLE_BUTTON);
        addDrop(ModBlocks2.APPLE_PRESSURE_PLATE);

        addDrop(ModBlocks2.APPLE_FENCE);
        addDrop(ModBlocks2.APPLE_FENCE_GATE);
//        addDrop(ModBlocks2.APPLE_WALL);

        addDrop(ModBlocks2.APPLE_DOOR, doorDrops(ModBlocks2.APPLE_DOOR));
        addDrop(ModBlocks2.APPLE_TRAPDOOR);

        addDrop(ModBlocks2.APPLE_LOG);
        addDrop(ModBlocks2.APPLE_WOOD);
        addDrop(ModBlocks2.STRIPPED_APPLE_LOG);
        addDrop(ModBlocks2.STRIPPED_APPLE_WOOD);
        addDrop(ModBlocks2.APPLE_PLANKS);
        addDrop(ModBlocks2.APPLE_SAPLING);
        addDrop(ModBlocks2.GOLDEN_APPLE_SAPLING);

        addDrop(ModBlocks2.APPLE_STANDING_SIGN);
        addDrop(ModBlocks2.APPLE_WALL_SIGN);
        addDrop(ModBlocks2.APPLE_HANGING_SIGN_BLOCK);
        addDrop(ModBlocks2.APPLE_WALL_HANGING_SIGN);


        addDrop(ModBlocks2.TEST_APPLE_LOG);
        addDrop(ModBlocks2.TEST_APPLE_WOOD);
        addDrop(ModBlocks2.STRIPPED_TEST_APPLE_LOG);
        addDrop(ModBlocks2.STRIPPED_TEST_APPLE_WOOD);
        addDrop(ModBlocks2.TEST_APPLE_PLANKS);
        addDrop(ModBlocks2.TEST_APPLE_SAPLING);

        addDrop(ModBlocks2.TEST_APPLE_STAIRS);
        addDrop(ModBlocks2.TEST_APPLE_SLAB, slabDrops(ModBlocks2.TEST_APPLE_SLAB));

        addDrop(ModBlocks2.TEST_APPLE_BUTTON);
        addDrop(ModBlocks2.TEST_APPLE_PRESSURE_PLATE);

        addDrop(ModBlocks2.TEST_APPLE_FENCE);
        addDrop(ModBlocks2.TEST_APPLE_FENCE_GATE);

        addDrop(ModBlocks2.TEST_APPLE_DOOR, doorDrops(ModBlocks2.TEST_APPLE_DOOR));
        addDrop(ModBlocks2.TEST_APPLE_TRAPDOOR);

        addDrop(ModBlocks2.TEST_APPLE_STANDING_SIGN);
        addDrop(ModBlocks2.TEST_APPLE_WALL_SIGN);
        addDrop(ModBlocks2.TEST_APPLE_HANGING_SIGN_BLOCK);
        addDrop(ModBlocks2.TEST_APPLE_WALL_HANGING_SIGN);

        addDrop(ModBlocks2.APPLE_BARREL);


        addDrop(ModBlocks2.FROSTY_APPLE_LOG);
        addDrop(ModBlocks2.FROSTY_APPLE_WOOD);
        addDrop(ModBlocks2.STRIPPED_FROSTY_APPLE_LOG);
        addDrop(ModBlocks2.STRIPPED_FROSTY_APPLE_WOOD);
        addDrop(ModBlocks2.FROSTY_APPLE_PLANKS);
        addDrop(ModBlocks2.FROSTY_APPLE_SAPLING);

        addDrop(ModBlocks2.FROSTY_APPLE_STAIRS);
        addDrop(ModBlocks2.FROSTY_APPLE_SLAB, slabDrops(ModBlocks2.FROSTY_APPLE_SLAB));

        addDrop(ModBlocks2.FROSTY_APPLE_BUTTON);
        addDrop(ModBlocks2.FROSTY_APPLE_PRESSURE_PLATE);

        addDrop(ModBlocks2.FROSTY_APPLE_FENCE);
        addDrop(ModBlocks2.FROSTY_APPLE_FENCE_GATE);

        addDrop(ModBlocks2.FROSTY_APPLE_DOOR, doorDrops(ModBlocks2.FROSTY_APPLE_DOOR));
        addDrop(ModBlocks2.FROSTY_APPLE_TRAPDOOR);

        addDrop(ModBlocks2.FROSTY_APPLE_STANDING_SIGN);
        addDrop(ModBlocks2.FROSTY_APPLE_WALL_SIGN);
        addDrop(ModBlocks2.FROSTY_APPLE_HANGING_SIGN_BLOCK);
        addDrop(ModBlocks2.FROSTY_APPLE_WALL_HANGING_SIGN);

    }
}
