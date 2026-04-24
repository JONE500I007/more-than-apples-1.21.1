package net.more.apples.datagen.villager_trade.apple_master;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricCodecDataProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModTradeSetProvider extends FabricCodecDataProvider<TradeSet> {
    public ModTradeSetProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture, PackOutput.Target target, String directoryName, Codec<TradeSet> codec) {
        super(packOutput, registriesFuture, target, directoryName, codec);
    }

    @Override
    protected void configure(BiConsumer<Identifier, TradeSet> provider,
                             HolderLookup.Provider lookup) {

        HolderLookup.RegistryLookup<VillagerTrade> tradeLookup =
                lookup.lookupOrThrow(Registries.VILLAGER_TRADE);

        HolderSet<VillagerTrade> trades = HolderSet.direct(
                tradeLookup.getOrThrow(ResourceKey.create(
                        Registries.VILLAGER_TRADE,
                        Identifier.fromNamespaceAndPath("more-than-apples", "apple_trade_1")
                )),
                tradeLookup.getOrThrow(ResourceKey.create(
                        Registries.VILLAGER_TRADE,
                        Identifier.fromNamespaceAndPath("more-than-apples", "apple_trade_2")
                ))
        );

        TradeSet set = new TradeSet(
                trades,
                ConstantValue.exactly(2),
                false,
                Optional.empty()
        );

        provider.accept(
                Identifier.fromNamespaceAndPath("more-than-apples", "apple_master/level_1"),
                set
        );
    }

    @Override
    public String getName() {
        return "";
    }
}
