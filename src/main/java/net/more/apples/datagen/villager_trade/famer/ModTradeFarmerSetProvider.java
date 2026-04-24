package net.more.apples.datagen.villager_trade.famer;

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

public class ModTradeFarmerSetProvider extends FabricCodecDataProvider<TradeSet> {
    public ModTradeFarmerSetProvider(
            FabricPackOutput output,
            CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(
                output,
                registriesFuture,
                PackOutput.Target.DATA_PACK,
                "trade_set",
                TradeSet.CODEC);
    }

    @Override
    protected void configure(BiConsumer<Identifier, TradeSet> provider,
                             HolderLookup.Provider lookup) {

        HolderLookup.RegistryLookup<VillagerTrade> tradeLookup =
                lookup.lookupOrThrow(Registries.VILLAGER_TRADE);

        HolderSet<VillagerTrade> trades = HolderSet.direct(
                tradeLookup.getOrThrow(ResourceKey.create(
                        Registries.VILLAGER_TRADE,
                        Identifier.fromNamespaceAndPath("more-than-apples", "farmer/level_1")
                )),
                tradeLookup.getOrThrow(ResourceKey.create(
                        Registries.VILLAGER_TRADE,
                        Identifier.fromNamespaceAndPath("more-than-apples", "farmer/level_2")
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
