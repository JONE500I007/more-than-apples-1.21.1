package net.more.apples.world;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;

public interface IShelfLike {
    NonNullList<ItemStack> getItems();

    ItemStack getItem(int slot);

    void setItem(int slot, ItemStack stack);

    ItemStack swapItemNoUpdate(int slot, ItemStack stack);

    void setChanged();
}
