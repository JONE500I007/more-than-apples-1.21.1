package net.more.apples.item.custom;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CustomEnchApple extends net.minecraft.world.item.Item {

    public CustomEnchApple(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        return true;
    }
}
