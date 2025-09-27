package net.more.apples.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.more.apples.MoreThanApples;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_IRON_TOOL = createTag("needs_iron_tool");
        public static final TagKey<Block> LOGS_THAT_BURN = createTag("logs_that_burn");

        public static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> HORSE_FOOD = createTag("horse_food");
        public static final TagKey<Item> HORSE_TEMPT_ITEMS = createTag("horse_tempt_items");

        public static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, name));
        }
    }
}
