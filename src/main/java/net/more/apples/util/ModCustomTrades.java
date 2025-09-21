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

        // if you want to use this code you can use this (: this not error for 1.21.4 maybe lol
        /*
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 5, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 20),
                    new ItemStack(ModItems.DIAMOND_CARROT, 2),
                    6, 30, 0.2f
            ));
        });

        //chance 30% for diamond carot
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 5, factories -> {
            factories.add((entity, random) -> {
                if (random.nextFloat() < 0.3f) {
                    return new TradeOffer(
                            new TradedItem(Items.EMERALD, 20),
                            new ItemStack(ModItems.DIAMOND_CARROT, 2),
                            6, 30, 0.2f
                    );
                }
                return null;
            });
        });
         */

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

        TradeOfferHelper.registerWanderingTraderOffers(factories -> {
            factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.BUY_ITEMS_POOL,
                    (entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD_BLOCK, 7),
                            new ItemStack(ModItems.DIAMOND_APPLE, 1),
                            10, 200, 0.2f
                    ),
                    (entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD_BLOCK, 7),
                            new ItemStack(ModItems.DIAMOND_APPLE, 1),
                            10, 200, 0.2f
                    )
            );
            factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_COMMON_ITEMS_POOL,
                    (entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD_BLOCK, 4),
                            new ItemStack(ModItems.DIAMOND_CARROT, 24),
                            5, 40, 0.2f
                    ),
                    (entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD_BLOCK, 14),
                            new ItemStack(ModItems.NETHERITE_APPLE, 1),
                            2, 200, 0.2f
                    )
            );
            factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_SPECIAL_ITEMS_POOL,
                    (entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD_BLOCK, 20),
                            new ItemStack(ModItems.ENCHANTED_DIAMOND_APPLE, 1),
                            2, 400, 0.2f
                    ),
                    (entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD_BLOCK, 20),
                            new ItemStack(ModItems.ENCHANTED_NETHERITE_APPLE, 1),
                            1, 500, 0.2f
                    )
            );
        });

        /*
        TradeOfferHelper.registerWanderingTraderOffers(factories -> {
            factories.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.BUY_ITEMS_POOL,
                    (entity, random) -> {
                        if (random.nextBoolean()) {
                            return new TradeOffer(
                                    new TradedItem(Items.EMERALD_BLOCK, 7),
                                    new ItemStack(ModItems.DIAMOND_APPLE, 1),
                                    10, 2, 0.2f
                            );
                        }
                        return null;
                    },
                    //chance 1/4
                    (entity, random) -> {
                        if (random.nextInt(4) == 0) {
                            return new TradeOffer(
                                    new TradedItem(Items.EMERALD_BLOCK, 10),
                                    new ItemStack(ModItems.ENCHANTED_DIAMOND_APPLE, 1),
                                    5, 2, 0.2f
                            );
                        }
                        return null;
                    },
                    (entity, random) -> {
                        if (random.nextFloat() < 0.3f) {
                            return new TradeOffer(
                                    new TradedItem(Items.EMERALD_BLOCK, 7),
                                    new ItemStack(ModItems.DIAMOND_APPLE, 1),
                                    10, 2, 0.2f
                            );
                        }
                        return null;
                    }
            );
        });
         */

    }
}
