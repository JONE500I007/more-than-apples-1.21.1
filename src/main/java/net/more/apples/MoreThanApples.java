package net.more.apples;

import net.fabricmc.api.ModInitializer;

import net.more.apples.block.CreativeModeBlockTabs;
import net.more.apples.block.general_block.ModGeneralBlock;
import net.more.apples.block.ore_block.ModBlockOre;
import net.more.apples.effect.ModEffectsRegister;
import net.more.apples.event.ModEntityUseHandler2;
import net.more.apples.item.CreativeModeItemTabs;
import net.more.apples.item.ModItemGroups;
import net.more.apples.item.ModPotionsGroups;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import net.more.apples.item.general_item.ModGeneralItems;
import net.more.apples.potion.ModPotions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreThanApples implements ModInitializer {
	public static final String MOD_ID = "more-than-apples";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		CreativeModeItemTabs.registerModItemTab();
		ModAppleFoodItems.registerModForItem();
		ModGeneralItems.registerModForItem();

		CreativeModeBlockTabs.registerModBlockTab();
		ModBlockOre.registerModOreBlocks();
		ModGeneralBlock.registerModGenerBlocks();


		ModItemGroups.registerItemGroups();
		ModPotionsGroups.registerItemGroups2();


		ModEffectsRegister.registerEffects();
		ModPotions.registerPotionsForItem();

		ModEntityUseHandler2.register();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}