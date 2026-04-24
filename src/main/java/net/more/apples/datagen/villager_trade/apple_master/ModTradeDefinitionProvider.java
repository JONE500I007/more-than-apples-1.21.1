package net.more.apples.datagen.villager_trade.apple_master;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricCodecDataProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModTradeDefinitionProvider extends FabricCodecDataProvider<VillagerTrade> {

    protected ModTradeDefinitionProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture, PackOutput.Target target, String directoryName, Codec<VillagerTrade> codec) {
        super(packOutput, registriesFuture, target, directoryName, codec);
    }

    @Override
    protected void configure(BiConsumer<Identifier, VillagerTrade> provider,
                             HolderLookup.Provider lookup) {

        provider.accept(
                Identifier.fromNamespaceAndPath("more-than-apples", "apple_trade_1"),
                createTrade(Items.EMERALD, 5, Items.APPLE, 3)
        );
        provider.accept(
                Identifier.fromNamespaceAndPath("more-than-apples", "apple_trade_2"),
                createTrade(Items.EMERALD, 10, Items.GOLDEN_APPLE, 1)
        );
    }

    private VillagerTrade createTrade(Item buyItem, int buyCount,
                                      Item sellItem, int sellCount) {
        return new VillagerTrade(
                new TradeCost(buyItem, buyCount),
                Optional.empty(),
                new ItemStackTemplate(sellItem, sellCount),
                10,
                2,
                0.05f,
                Optional.empty(),
                List.of());
    }

    @Override
    public String getName() {
        return "";
    }
}
