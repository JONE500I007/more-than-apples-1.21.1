package net.more.apples.mixin;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.ShelfBlockEntity;
import net.more.apples.world.IShelfLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ShelfBlockEntity.class)
public abstract class AppleShelfBlockEntityMixin implements IShelfLike {

    @Shadow
    private NonNullList<ItemStack> items;

    @Shadow
    public abstract ItemStack swapItemNoUpdate(int slot, ItemStack stack);

    @Shadow
    public abstract void setChanged();

    @Override
    public ItemStack getItem(int slot) {
        return this.items.get(slot);
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        this.items.set(slot, stack);
        this.setChanged();
    }
}
