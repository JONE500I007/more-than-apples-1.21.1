package net.more.apples;

import net.fabricmc.api.ModInitializer;

import net.more.apples.item.CreativeModeItemInv;
import net.more.apples.item.general_item.ModGeneralItems;
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
		CreativeModeItemInv.registerModInvItem();
		ModGeneralItems.registerModItem();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}