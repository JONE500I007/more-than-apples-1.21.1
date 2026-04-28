package net.more.apples.villager;

import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PoiHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.level.block.Block;
import net.more.apples.MoreThanApples;
import net.more.apples.block.general_block.ModGeneralBlock;

public class ModAppleVillagers {
    public static final ResourceKey<PoiType> APPLE_POI_KEY = registerPoiKey("apple_poi");
    public static final PoiType APPLE_POI = registerPoi("apple_poi", ModGeneralBlock.APPLE_BARREL);

    public static final VillagerProfession APPLE_MASTER = registerProfession("apple_master", APPLE_POI_KEY);

    public static final ResourceKey<VillagerProfession> APPLE_MASTER_KEY = ResourceKey.create(
            Registries.VILLAGER_PROFESSION, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_master"));

    private static VillagerProfession registerProfession(String name, ResourceKey<PoiType> type) {
        return Registry.register(BuiltInRegistries.VILLAGER_PROFESSION,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name),
                new VillagerProfession(
                        Component.translatable("entity.minecraft.villager.apple_master"),
                        entry -> entry.is(type),
                        entry -> entry.is(type),
                        ImmutableSet.of(),
                        ImmutableSet.of(),
                        SoundEvents.VILLAGER_WORK_FISHERMAN,
                        Util.make(new Int2ObjectOpenHashMap<>(), trades -> {
                            trades.put(1, tradeSetKey("apple_master/level_1"));
                            trades.put(2, tradeSetKey("apple_master/level_2"));
                            trades.put(3, tradeSetKey("apple_master/level_3"));
                            trades.put(4, tradeSetKey("apple_master/level_4"));
                            trades.put(5, tradeSetKey("apple_master/level_5"));
                        })));
    }
    /*
    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(MoreThanApples.MOD_ID, name),1, 1, block);
    }
     */

    private static PoiType registerPoi(String name, Block block) {
        return PoiHelper.register(Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name),
                1, 1, ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates()));
    }

    private static ResourceKey<PoiType> registerPoiKey(String name) {
        return ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
    }

    private static ResourceKey<TradeSet> tradeSetKey(String name) {
        return ResourceKey.create(Registries.TRADE_SET,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
    }

    public static void registerVillagers() {
        MoreThanApples.LOGGER.info("Registering Villagers" + MoreThanApples.MOD_ID);
    }
}
