package net.more.apples.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CustomEnchApple extends Item {
    public CustomEnchApple(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
