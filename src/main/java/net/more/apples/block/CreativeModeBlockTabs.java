package net.more.apples.block;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.more.apples.MoreThanApples;

import static net.more.apples.block.ore_block.ModBlockOre.*;


public class CreativeModeBlockTabs {
    public static void registerModBlockTab() {
        MoreThanApples.LOGGER.info("Registering Mod Blocks " + MoreThanApples.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS)
                .register(entrise -> {
                    entrise.accept(APPLE_ORE);
                    entrise.accept(DEEPSLATE_APPLE_ORE);
                });

    }
}
