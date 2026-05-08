package net.more.apples.block;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.more.apples.MoreThanApples;

import static net.more.apples.block.general_block.ModGeneralBlock.*;
import static net.more.apples.block.ore_block.ModBlockOre.*;
import static net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks.*;
import static net.more.apples.block.wood_type.apple_wood.AppleWoodVariants.*;
import static net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks.*;
import static net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants.*;
import static net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks.*;
import static net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants.*;

//import static net.more.apples.block.ore_block.ModBlockOre.*;


public class CreativeModeBlockTabs {
    public static void registerModBlockTab() {
        MoreThanApples.LOGGER.info("Registering Mod Blocks " + MoreThanApples.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS)
                .register(entrise -> {
                    entrise.accept(APPLE_ORE);
                    entrise.accept(DEEPSLATE_APPLE_ORE);
                });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
                .register(entrise -> {
                    entrise.accept(APPLE_LOG);
                    entrise.accept(APPLE_WOOD);
                    entrise.accept(STRIPPED_APPLE_LOG);
                    entrise.accept(STRIPPED_APPLE_WOOD);
                    entrise.accept(APPLE_PLANKS);
                    entrise.accept(APPLE_STAIRS);
                    entrise.accept(APPLE_SLAB);
                    entrise.accept(APPLE_FENCE);
                    entrise.accept(APPLE_FENCE_GATE);
                    entrise.accept(APPLE_DOOR);
                    entrise.accept(APPLE_TRAPDOOR);
                    entrise.accept(APPLE_PRESSURE_PLATE);
                    entrise.accept(APPLE_BUTTON);

                    entrise.accept(TEST_APPLE_LOG);
                    entrise.accept(TEST_APPLE_WOOD);
                    entrise.accept(STRIPPED_TEST_APPLE_LOG);
                    entrise.accept(STRIPPED_TEST_APPLE_WOOD);
                    entrise.accept(TEST_APPLE_PLANKS);
                    entrise.accept(TEST_APPLE_STAIRS);
                    entrise.accept(TEST_APPLE_SLAB);
                    entrise.accept(TEST_APPLE_FENCE);
                    entrise.accept(TEST_APPLE_FENCE_GATE);
                    entrise.accept(TEST_APPLE_DOOR);
                    entrise.accept(TEST_APPLE_TRAPDOOR);
                    entrise.accept(TEST_APPLE_PRESSURE_PLATE);
                    entrise.accept(TEST_APPLE_BUTTON);

                    entrise.accept(FROSTY_APPLE_LOG);
                    entrise.accept(FROSTY_APPLE_WOOD);
                    entrise.accept(STRIPPED_FROSTY_APPLE_LOG);
                    entrise.accept(STRIPPED_FROSTY_APPLE_WOOD);
                    entrise.accept(FROSTY_APPLE_PLANKS);
                    entrise.accept(FROSTY_APPLE_STAIRS);
                    entrise.accept(FROSTY_APPLE_SLAB);
                    entrise.accept(FROSTY_APPLE_FENCE);
                    entrise.accept(FROSTY_APPLE_FENCE_GATE);
                    entrise.accept(FROSTY_APPLE_DOOR);
                    entrise.accept(FROSTY_APPLE_TRAPDOOR);
                    entrise.accept(FROSTY_APPLE_PRESSURE_PLATE);
                    entrise.accept(FROSTY_APPLE_BUTTON);
                });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS)
                .register(entrise -> {
                    entrise.accept(APPLE_LOG);
                    entrise.accept(APPLE_LEAVES);
                    entrise.accept(FRUIT_APPLE_LEAVES);
                    entrise.accept(APPLE_SAPLING);

                    entrise.accept(GOLDEN_APPLE_LEAVES);
                    entrise.accept(FRUIT_GOLDEN_APPLE_LEAVES);
                    entrise.accept(GOLDEN_APPLE_SAPLING);

                    entrise.accept(TEST_APPLE_LOG);
                    entrise.accept(TEST_APPLE_LEAVES);
                    entrise.accept(TEST_APPLE_SAPLING);

                    entrise.accept(FROSTY_APPLE_LOG);
                    entrise.accept(FROSTY_APPLE_LEAVES);
                    entrise.accept(FROSTY_APPLE_SAPLING);
                });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register(entrise -> {
                    entrise.accept(APPLE_BARREL);
                });
    }
}
