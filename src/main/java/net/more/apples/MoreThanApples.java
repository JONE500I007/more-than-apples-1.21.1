package net.more.apples;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.more.apples.block.ModBlocks;
import net.more.apples.block.ModBlocks2;
import net.more.apples.block.ModBlocksForText;
import net.more.apples.effect.ModEffects;
import net.more.apples.entity.ModBoats;
import net.more.apples.event.ModEntityUseHandler;
import net.more.apples.item.ModItemGroups;
import net.more.apples.item.ModItemGroups2;
import net.more.apples.item.ModItems;
import net.more.apples.potion.ModPotions;
import net.more.apples.util.*;
import net.more.apples.util.custom_loottable.*;
import net.more.apples.util.custom_trade.ModCustomAppleMTrades;
import net.more.apples.util.custom_trade.ModCustomFarmerTrades;
import net.more.apples.villager.ModAppleVillagers;
import net.more.apples.world.gen.ModWorldGeneration;
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
		ModItems.registerModItem();
		ModBlocks.registerModBlocks();
		ModBlocks2.registerModBlocks2();
		ModBlocksForText.registerModBlocks2();
		ModItemGroups.registerItemGroups();
		ModItemGroups2.registerItemGroups2();

		ModLootTableModifiers_DiaApple.modifyLootTables();
		ModLootTableModifiers_DiaCarrot.modifyLootTables();
		ModLootTableModifiers_EnchDiaApple.modifyLootTables();
		ModLootTableModifiers_NetherApple.modifyLootTables();
		ModLootTableModifiers_EnchNetherApple.modifyLootTables();

		ModEffects.registerEffects();

		ModPotions.registerPotions();

		ModLootConditions.init();

		ModCustomFarmerTrades.registerCustomTrades();

		ModWorldGeneration.generateWorldGen();

		ModEntityUseHandler.register();

		ModAppleVillagers.registerVillagers();
		ModCustomAppleMTrades.registerCustomTrades();

		ModBoats.registerBoats();
		ModBoats.registerBoats2();
		ModBoats.registerBoats3();

		ModTrunkPlacerType.register();
		ModFoliagePlacerType.register();
		//ModEntityUseHandler2.register();
		/*
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD,ModItems.DIAMOND_CARROT, ModPotions.DARKNESS_IMMUNE_POTION);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD,ModItems.DIAMOND_APPLE, ModPotions.FREEZING_RESOSTANCE_POTION);
		});
		 */
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD,ModItems.DIAMOND_CARROT, ModPotions.NIGHT_VISION_POTION_V1);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD,ModItems.TEST_APPLE, ModPotions.CALL_OF_APPLE_POTION);
			builder.registerPotionRecipe(ModPotions.CALL_OF_APPLE_POTION, Items.REDSTONE, ModPotions.CALL_OF_APPLE_POTION_L);
		});

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD,ModItems.GREEN_APPLE, Potions.LUCK);
		});
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		StrippableBlockRegistry.register(ModBlocks2.APPLE_LOG, ModBlocks2.STRIPPED_APPLE_LOG);
		StrippableBlockRegistry.register(ModBlocks2.APPLE_WOOD, ModBlocks2.STRIPPED_APPLE_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.APPLE_LOG, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.APPLE_WOOD, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.STRIPPED_APPLE_LOG, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.STRIPPED_APPLE_WOOD, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.APPLE_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.APPLE_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.FRUIT_APPLE_LEAVES, 30, 60);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.APPLE_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.APPLE_SLAB, 5, 20);
//		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.APPLE_BUTTON, 5, 20);
//		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.APPLE_PRESSURE_PLATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.APPLE_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.APPLE_FENCE_GATE, 5, 20);
//		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.APPLE_DOOR, 5, 20);
//		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.APPLE_TRAPDOOR, 5, 20);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.GOLDEN_APPLE_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.FRUIT_GOLDEN_APPLE_LEAVES, 30, 60);


		StrippableBlockRegistry.register(ModBlocks2.TEST_APPLE_LOG, ModBlocks2.STRIPPED_TEST_APPLE_LOG);
		StrippableBlockRegistry.register(ModBlocks2.TEST_APPLE_WOOD, ModBlocks2.STRIPPED_TEST_APPLE_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.TEST_APPLE_LOG, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.TEST_APPLE_WOOD, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.STRIPPED_TEST_APPLE_LOG, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.STRIPPED_TEST_APPLE_WOOD, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.TEST_APPLE_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.TEST_APPLE_LEAVES, 30, 60);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.TEST_APPLE_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.TEST_APPLE_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.TEST_APPLE_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.TEST_APPLE_FENCE_GATE, 5, 20);


		StrippableBlockRegistry.register(ModBlocks2.FROSTY_APPLE_LOG, ModBlocks2.STRIPPED_FROSTY_APPLE_LOG);
		StrippableBlockRegistry.register(ModBlocks2.FROSTY_APPLE_WOOD, ModBlocks2.STRIPPED_FROSTY_APPLE_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.FROSTY_APPLE_LOG, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.FROSTY_APPLE_WOOD, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.STRIPPED_FROSTY_APPLE_LOG, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.STRIPPED_FROSTY_APPLE_WOOD, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.FROSTY_APPLE_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.FROSTY_APPLE_LEAVES, 30, 60);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.FROSTY_APPLE_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.FROSTY_APPLE_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.FROSTY_APPLE_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks2.FROSTY_APPLE_FENCE_GATE, 5, 20);

		FuelRegistry.INSTANCE.add(ModBlocks2.APPLE_STAIRS, 300);
		FuelRegistry.INSTANCE.add(ModBlocks2.APPLE_SLAB, 150);
		FuelRegistry.INSTANCE.add(ModBlocks2.APPLE_BUTTON, 100);
		FuelRegistry.INSTANCE.add(ModBlocks2.APPLE_PRESSURE_PLATE, 300);
		FuelRegistry.INSTANCE.add(ModBlocks2.APPLE_FENCE, 300);
		FuelRegistry.INSTANCE.add(ModBlocks2.APPLE_FENCE_GATE, 300);
		FuelRegistry.INSTANCE.add(ModBlocks2.APPLE_DOOR, 200);
		FuelRegistry.INSTANCE.add(ModBlocks2.APPLE_TRAPDOOR, 200);

		FuelRegistry.INSTANCE.add(ModBlocks2.TEST_APPLE_STAIRS, 300);
		FuelRegistry.INSTANCE.add(ModBlocks2.TEST_APPLE_SLAB, 150);
		FuelRegistry.INSTANCE.add(ModBlocks2.TEST_APPLE_BUTTON, 100);
		FuelRegistry.INSTANCE.add(ModBlocks2.TEST_APPLE_PRESSURE_PLATE, 300);
		FuelRegistry.INSTANCE.add(ModBlocks2.TEST_APPLE_FENCE, 300);
		FuelRegistry.INSTANCE.add(ModBlocks2.TEST_APPLE_FENCE_GATE, 300);
		FuelRegistry.INSTANCE.add(ModBlocks2.TEST_APPLE_DOOR, 200);
		FuelRegistry.INSTANCE.add(ModBlocks2.TEST_APPLE_TRAPDOOR, 200);

		FuelRegistry.INSTANCE.add(ModBlocks2.FROSTY_APPLE_STAIRS, 300);
		FuelRegistry.INSTANCE.add(ModBlocks2.FROSTY_APPLE_SLAB, 150);
		FuelRegistry.INSTANCE.add(ModBlocks2.FROSTY_APPLE_BUTTON, 100);
		FuelRegistry.INSTANCE.add(ModBlocks2.FROSTY_APPLE_PRESSURE_PLATE, 300);
		FuelRegistry.INSTANCE.add(ModBlocks2.FROSTY_APPLE_FENCE, 300);
		FuelRegistry.INSTANCE.add(ModBlocks2.FROSTY_APPLE_FENCE_GATE, 300);
		FuelRegistry.INSTANCE.add(ModBlocks2.FROSTY_APPLE_DOOR, 200);
		FuelRegistry.INSTANCE.add(ModBlocks2.FROSTY_APPLE_TRAPDOOR, 200);


		LOGGER.info("Hello Fabric world!");
	}
}