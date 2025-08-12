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
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 20),
                    new ItemStack(ModItems.DIAMOND_CARROT, 2),
                    6, 30, 0.2f
            ));
        });

        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD_BLOCK, 10),
                    new ItemStack(ModItems.DIAMOND_APPLE, 1),
                    2, 40, 0.2f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD_BLOCK, 10),
                    new ItemStack(ModItems.DIAMOND_APPLE, 1),
                    2, 40, 0.2f
            ));
        });
    }
}
