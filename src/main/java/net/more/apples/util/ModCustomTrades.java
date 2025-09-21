package net.more.apples.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.more.apples.MoreThanApples;
import net.more.apples.item.ModItems;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        MoreThanApples.LOGGER.info("Registering Villager Trades From " + MoreThanApples.MOD_ID);

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 5, factories -> {
            factories.add((entity, random) -> {
                if (random.nextBoolean()) {
                    return new TradeOffer(
                            new TradedItem(Items.EMERALD, 20),
                            new ItemStack(ModItems.DIAMOND_CARROT, 2),
                            6, 40, 0.2f
                    );
                }
                return null;
            });
        });

        // level 1 for WanderingTrader is common trades
        // level 2 for WanderingTrader is rare trades lol not have level 3
        // just maybe cuz i dont know for this as much lmao
        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD_BLOCK, 3),
                    new ItemStack(Items.GOLDEN_APPLE, 1),
                    13, 100, 0.2f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD_BLOCK, 7),
                    new ItemStack(ModItems.DIAMOND_APPLE, 1),
                    10, 200, 0.2f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD_BLOCK, 7),
                    new ItemStack(ModItems.DIAMOND_APPLE, 1),
                    10, 200, 0.2f
            ));

            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD_BLOCK, 4),
                    new ItemStack(ModItems.DIAMOND_CARROT, 24),
                    5, 40, 0.2f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD_BLOCK, 14),
                    new ItemStack(ModItems.NETHERITE_APPLE, 1),
                    2, 200, 0.2f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD_BLOCK, 17),
                    new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 1),
                    2, 350, 0.2f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD_BLOCK, 20),
                    new ItemStack(ModItems.ENCHANTED_DIAMOND_APPLE, 1),
                    2, 400, 0.2f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD_BLOCK, 20),
                    new ItemStack(ModItems.ENCHANTED_NETHERITE_APPLE, 1),
                    1, 500, 0.2f
            ));
        });
    }
}
