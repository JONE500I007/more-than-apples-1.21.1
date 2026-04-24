package net.more.apples.datagen.villager_trade.famer;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
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
import net.more.apples.item.ModItems;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModTradeFarmerDefinitionProvider extends FabricCodecDataProvider<VillagerTrade> {

    public ModTradeFarmerDefinitionProvider(
            FabricPackOutput output,
            CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(
                output,
                registriesFuture,
                PackOutput.Target.DATA_PACK,
                "villager_trade",
                VillagerTrade.CODEC);
    }

    @Override
    protected void configure(BiConsumer<Identifier, VillagerTrade> provider,
                             HolderLookup.Provider lookup) {

        provider.accept(
                Identifier.fromNamespaceAndPath("more-than-apples", "farmer_trade_level1_a"),
                createTrade(Items.EMERALD, 5, ModItems.DIAMOND_CARROT, 3)
        );
        provider.accept(
                Identifier.fromNamespaceAndPath("more-than-apples", "farmer_trade_level1_b"),
                createTrade(Items.EMERALD, 10, ModItems.ENCHANTED_DIAMOND_APPLE, 1)
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
