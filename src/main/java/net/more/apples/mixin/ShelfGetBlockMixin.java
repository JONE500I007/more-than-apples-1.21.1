package net.more.apples.mixin;


import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ShelfBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.more.apples.entity.AppleBlockEntity;
import net.more.apples.world.IShelfLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShelfBlock.class)
public class ShelfGetBlockMixin {

    @Inject(
            method = "useItemOn",
            at = @At("HEAD"),
            cancellable = true
    )
    private void moreApples$useItemOn(
            ItemStack stack,
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            InteractionHand hand,
            BlockHitResult hit,
            CallbackInfoReturnable<InteractionResult> cir
    ) {

        if (!(level.getBlockEntity(pos) instanceof AppleBlockEntity shelf)) {
            return;
        }

        if (level.isClientSide()) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }


        int slot = 0;

        if (!stack.isEmpty()) {
            ItemStack copy = stack.copy();

            shelf.setItem(slot, copy);

            if (!player.getAbilities().instabuild) {
                stack.shrink(copy.getCount());
            }

        } else {
            ItemStack taken = shelf.getItem(slot);

            if (!taken.isEmpty()) {
                player.addItem(taken.copy());
                shelf.setItem(slot, ItemStack.EMPTY);
            }
        }

        shelf.setChanged();

        cir.setReturnValue(InteractionResult.SUCCESS);
    }
}
