package net.more.apples;

import net.fabricmc.api.ModInitializer;

import net.more.apples.effect.ModEffectsRegister;
import net.more.apples.event.ModEntityUseHandler2;
import net.more.apples.particle.ModParticle;
import net.more.apples.potion.ModPotions;
import net.more.apples.util.ModLootConditions;
import net.more.apples.util.custom_loottable.ModLootTableModifiers_DiaApple;
import net.more.apples.util.custom_trade.ModCustomAppleMTrades;
import net.more.apples.util.custom_trade.ModCustomFarmerTrades;
import net.more.apples.villager.ModAppleVillagers;
import net.more.apples.world.tree.ModFoliagePlacerType;
import net.more.apples.world.tree.ModTrunkPlacerType;
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
		ModEffectsRegister.registerEffects();
		ModPotions.registerPotionsForItem();


		ModEntityUseHandler2.register();

		ModParticle.registerParticle();

		ModAppleVillagers.registerVillagers();

		ModLootConditions.init();

		//ModTrunkPlacerType.register();
		//ModFoliagePlacerType.register();

		ModCustomAppleMTrades.registerCustomTrades();
		ModCustomFarmerTrades.registerCustomTrades();

		//ModLootTableModifiers_DiaApple.modifyLootTables();

		LOGGER.info("Hello Fabric world!");
	}
}