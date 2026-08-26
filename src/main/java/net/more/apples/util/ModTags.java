package net.more.apples.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.more.apples.MoreThanApples;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_IRON_TOOL = createTag("needs_iron_tool");
        public static final TagKey<Block> LOGS_THAT_BURN = createTag("logs_that_burn");

        public static final TagKey<Block> ALL_APPLE_LOG = createTag("all_apple_log");
        public static final TagKey<Block> ALL_TEST_APPLE_LOG = createTag("all_test_apple_log");
        public static final TagKey<Block> ALL_FROSTY_APPLE_LOG = createTag("all_frosty_apple_log");
        public static final TagKey<Block> ALL_ANCIENT_APPLE_LOG = createTag("all_ancient_apple_log");

        public static final TagKey<Block> ALL_THE_SHELF = createTag("all_the_shelf");

        public static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> HORSE_FOOD = createTag("horse_food");
        public static final TagKey<Item> HORSE_TEMPT_ITEMS = createTag("horse_tempt_items");

        public static final TagKey<Item> ALL_APPLE = createTag("all_apple");

        public static final TagKey<Item> ALL_APPLE_LOG = createTag("all_apple_log");
        public static final TagKey<Item> ALL_TEST_APPLE_LOG = createTag("all_test_apple_log");
        public static final TagKey<Item> ALL_FROSTY_APPLE_LOG = createTag("all_frosty_apple_log");
        public static final TagKey<Item> ALL_ANCIENT_APPLE_LOG = createTag("all_ancient_apple_log");

        public static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
        }
    }
}
