package net.more.apples.datagen.villager;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.VillagerTradeTags;
import net.minecraft.world.item.trading.VillagerTrade;

import java.util.concurrent.CompletableFuture;

public class ModVillagerTradeTagProvider extends FabricTagsProvider<VillagerTrade> {
    public ModVillagerTradeTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.VILLAGER_TRADE, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        builder(ModVillagerTradeTags.APPLE_MASTER_LEVEL_1)
                .add(ModVillagerTrades.APPLE_MASTER_1_APPLE_TO_EMERALD)
                .add(ModVillagerTrades.APPLE_MASTER_1_APPLE_SAPLING_TO_EMERALD)
                .add(ModVillagerTrades.APPLE_MASTER_1_STICK_TO_EMERALD);

        builder(ModVillagerTradeTags.APPLE_MASTER_LEVEL_2)
                .add(ModVillagerTrades.APPLE_MASTER_2_EMERALD_TO_APPLE_LOG)
                .add(ModVillagerTrades.APPLE_MASTER_2_EMERALD_TO_FROSTY_APPLE_LOG)
                .add(ModVillagerTrades.APPLE_MASTER_2_EMERALD_TO_OAK_LOG)
                .add(ModVillagerTrades.APPLE_MASTER_2_EMERALD_TO_BIRCH_LOG)
                .add(ModVillagerTrades.APPLE_MASTER_2_EMERALD_TO_DARK_OAK_LOG)
                .add(ModVillagerTrades.APPLE_MASTER_2_GOLDEN_APPLE_SAPLING_TO_EMERALD);

        builder(ModVillagerTradeTags.APPLE_MASTER_LEVEL_3)
                .add(ModVillagerTrades.APPLE_MASTER_3_EMERALD_TO_GOLD_INGOT)
                .add(ModVillagerTrades.APPLE_MASTER_3_EMERALD_BLOCK_TO_GOLDEN_APPLE)
                .add(ModVillagerTrades.APPLE_MASTER_3_EMERALD_TO_ENCHANTED_GOLDEN_PICKAXE);

        builder(ModVillagerTradeTags.APPLE_MASTER_LEVEL_4)
                .add(ModVillagerTrades.APPLE_MASTER_4_TEST_APPLE_LOG_TO_EMERALD_BLOCK)
                .add(ModVillagerTrades.APPLE_MASTER_4_EMERALD_BLOCK_TO_DIAMOND_APPLE)
                .add(ModVillagerTrades.APPLE_MASTER_4_EMERALD_TO_FREEZING_RESISTANCE_POTION)
                .add(ModVillagerTrades.APPLE_MASTER_4_EMERALD_TO_DARKNESS_IMMUNE_POTION);

        builder(ModVillagerTradeTags.APPLE_MASTER_LEVEL_5)
                .add(ModVillagerTrades.APPLE_MASTER_5_DIRT_TO_DIAMOND)
                .add(ModVillagerTrades.APPLE_MASTER_5_EMERALD_BLOCK_TO_ENCHANTED_GOLDEN_APPLE)
                .add(ModVillagerTrades.APPLE_MASTER_5_EMERALD_BLOCK_TO_NETHERITE_APPLE);

        builder(VillagerTradeTags.FARMER_LEVEL_5)
                .add(ModVillagerTrades.FARMER_5_EMERALD_TO_DIAMOND_CARROT);

        builder(VillagerTradeTags.WANDERING_TRADER_BUYING)
                .add(ModVillagerTrades.WANDERING_TRADER_EMERALD_BLOCK_TO_GOLDEN_APPLE)
                .add(ModVillagerTrades.WANDERING_TRADER_EMERALD_BLOCK_TO_DIAMOND_APPLE);

        builder(VillagerTradeTags.WANDERING_TRADER_COMMON)
                .add(ModVillagerTrades.WANDERING_TRADER_EMERALD_BLOCK_TO_DIAMOND_CARROT)
                .add(ModVillagerTrades.WANDERING_TRADER_EMERALD_BLOCK_TO_NETHERITE_APPLE);

        builder(VillagerTradeTags.WANDERING_TRADER_UNCOMMON)
                .add(ModVillagerTrades.WANDERING_TRADER_EMERALD_BLOCK_TO_ENCHANTED_GOLDEN_APPLE)
                .add(ModVillagerTrades.WANDERING_TRADER_EMERALD_BLOCK_TO_ENCHANTED_DIAMOND_APPLE)
                .add(ModVillagerTrades.WANDERING_TRADER_EMERALD_BLOCK_TO_ENCHANTED_NETHERITE_APPLE);
    }
}
