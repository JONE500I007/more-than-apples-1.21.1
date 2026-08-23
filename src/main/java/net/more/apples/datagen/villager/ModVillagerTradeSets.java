package net.more.apples.datagen.villager;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.more.apples.MoreThanApples;
import net.more.apples.villager.ModAppleVillagers;

import java.util.Optional;

public class ModVillagerTradeSets {

    public static Holder<TradeSet> bootstrap(BootstrapContext<TradeSet> context) {
        register(context, ModAppleVillagers.tradeSetKey("apple_master/level_1"), ModVillagerTradeTags.APPLE_MASTER_LEVEL_1);
        register(context, ModAppleVillagers.tradeSetKey("apple_master/level_2"), ModVillagerTradeTags.APPLE_MASTER_LEVEL_2);
        register(context, ModAppleVillagers.tradeSetKey("apple_master/level_3"), ModVillagerTradeTags.APPLE_MASTER_LEVEL_3);
        register(context, ModAppleVillagers.tradeSetKey("apple_master/level_4"), ModVillagerTradeTags.APPLE_MASTER_LEVEL_4);
        return register(context, ModAppleVillagers.tradeSetKey("apple_master/level_5"), ModVillagerTradeTags.APPLE_MASTER_LEVEL_5);
    }

    private static Holder.Reference<TradeSet> register(
            BootstrapContext<TradeSet> context, ResourceKey<TradeSet> resourceKey, TagKey<VillagerTrade> tradeTag) {
        return context.register(
                resourceKey,
                new TradeSet(
                        context.lookup(Registries.VILLAGER_TRADE).getOrThrow(tradeTag),
                        ConstantValue.exactly(2.0F),
                        false,
                        Optional.of(resourceKey.identifier().withPrefix("trade_set/"))));
    }
}
