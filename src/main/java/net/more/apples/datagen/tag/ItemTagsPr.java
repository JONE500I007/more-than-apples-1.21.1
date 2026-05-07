package net.more.apples.datagen.tag;

import net.minecraft.world.item.Items;
import net.more.apples.datagen.provider.ModItemTagProvider;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import net.more.apples.util.ModTags;

public final class ItemTagsPr {
    private ItemTagsPr() {
    }

    public static void addItemTags(ModItemTagProvider provider) {
        provider.addToTag(ModTags.Items.ALL_APPLE,
                Items.APPLE,
                Items.GOLDEN_APPLE,
                Items.ENCHANTED_GOLDEN_APPLE,

                ModAppleFoodItems.GREEN_APPLE,
                ModAppleFoodItems.TEST_APPLE,

                ModAppleFoodItems.DIAMOND_APPLE,
                ModAppleFoodItems.ENCHANTED_DIAMOND_APPLE,

                ModAppleFoodItems.NETHERITE_APPLE,
                ModAppleFoodItems.ENCHANTED_NETHERITE_APPLE
        );
    }
}
