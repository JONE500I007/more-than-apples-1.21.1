package net.more.apples.datagen.villager;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.trading.VillagerTrade;
import net.more.apples.MoreThanApples;

public class ModVillagerTradeTags {
    public static final TagKey<VillagerTrade> APPLE_MASTER_LEVEL_1 = tag("apple_master/level_1");
    public static final TagKey<VillagerTrade> APPLE_MASTER_LEVEL_2 = tag("apple_master/level_2");
    public static final TagKey<VillagerTrade> APPLE_MASTER_LEVEL_3 = tag("apple_master/level_3");
    public static final TagKey<VillagerTrade> APPLE_MASTER_LEVEL_4 = tag("apple_master/level_4");
    public static final TagKey<VillagerTrade> APPLE_MASTER_LEVEL_5 = tag("apple_master/level_5");

    private static TagKey<VillagerTrade> tag(String path) {
        return TagKey.create(Registries.VILLAGER_TRADE, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, path));
    }
}
