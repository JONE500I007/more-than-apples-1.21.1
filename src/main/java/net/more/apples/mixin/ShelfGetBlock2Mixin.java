package net.more.apples.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SelectableSlotContainer;
import net.minecraft.world.level.block.ShelfBlock;
import net.minecraft.world.level.block.SideChainPartBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.more.apples.block.custom.IShelfLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.OptionalInt;

@Mixin(ShelfBlock.class)
public abstract class ShelfGetBlock2Mixin {

    @Inject(method = "useItemOn", at = @At("HEAD"), cancellable = true)
    private void moreApples$useItemOn(
            ItemStack itemStack,
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            InteractionHand hand,
            BlockHitResult hitResult,
            CallbackInfoReturnable<InteractionResult> cir
    ) {
        BlockEntity be = level.getBlockEntity(pos);

        if (!(be instanceof IShelfLike shelf)) {
            return;
        }

        if (hand == InteractionHand.OFF_HAND) return;

        OptionalInt hitSlot = ((SelectableSlotContainer)(Object)this)
                .getHitSlot(hitResult, state.getValue(ShelfBlock.FACING));

        if (hitSlot.isEmpty()) {
            cir.setReturnValue(InteractionResult.PASS);
            cir.cancel();
            return;
        }

        Inventory inventory = player.getInventory();

        if (level.isClientSide()) {
            cir.setReturnValue(inventory.getSelectedItem().isEmpty()
                    ? InteractionResult.PASS
                    : InteractionResult.SUCCESS);
            cir.cancel();
            return;
        }


        if (!state.getValue(ShelfBlock.POWERED)) {

            int slot = hitSlot.getAsInt();

            ItemStack shelfItem = shelf.getItem(slot).copy();

            ItemStack removed = shelf.swapItemNoUpdate(slot, itemStack);

            ItemStack newItem = player.getAbilities().instabuild && removed.isEmpty()
                    ? itemStack.copy()
                    : removed;

            inventory.setItem(inventory.getSelectedSlot(), newItem);
            inventory.setChanged();

            shelf.setChanged();

            // ===== Sound Logic =====

            SoundEvent sound;

            if (!itemStack.isEmpty() && shelfItem.isEmpty()) {

                // Put item into empty shelf
                sound = SoundEvents.SHELF_PLACE_ITEM;

            } else if (itemStack.isEmpty() && !shelfItem.isEmpty()) {

                // Take item from shelf
                sound = SoundEvents.SHELF_TAKE_ITEM;

            } else {

                // Swap item
                sound = SoundEvents.SHELF_SINGLE_SWAP;
            }

            level.playSound(
                    null,
                    pos,
                    sound,
                    SoundSource.BLOCKS,
                    1.0F,
                    1.0F + level.getRandom().nextFloat() * 0.1F
            );

            cir.setReturnValue(InteractionResult.SUCCESS);
            cir.cancel();
            return;
        }


        List<BlockPos> connected = ((SideChainPartBlock)this)
                .getAllBlocksConnectedTo(level, pos);

        boolean any = false;

        boolean playedSound = false;

        for (int i = 0; i < connected.size(); i++) {

            BlockEntity partBe = level.getBlockEntity(connected.get(i));

            if (!(partBe instanceof IShelfLike part)) continue;

            for (int slot = 0; slot < 3; slot++) {

                int invSlot = 9 - (connected.size() - i) * 3 + slot;

                if (invSlot < 0 || invSlot >= inventory.getContainerSize()) continue;

                ItemStack invItem = inventory.removeItemNoUpdate(invSlot);
                ItemStack shelfItem = part.swapItemNoUpdate(slot, invItem);

                if (!playedSound && (!invItem.isEmpty() || !shelfItem.isEmpty())) {

                    level.playSound(
                            null,
                            pos,
                            SoundEvents.SHELF_MULTI_SWAP,
//                            !invItem.isEmpty()
//                                    ? SoundEvents.SHELF_SINGLE_SWAP
//                                    : SoundEvents.SHELF_MULTI_SWAP,
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F + level.getRandom().nextFloat() * 0.1F
                    );

                    playedSound = true;
                }

                if (!invItem.isEmpty() || !shelfItem.isEmpty()) {
                    inventory.setItem(invSlot, shelfItem);
                    any = true;
                }
            }

            inventory.setChanged();
            part.setChanged();
        }

        cir.setReturnValue(any ? InteractionResult.SUCCESS : InteractionResult.CONSUME);
        cir.cancel();
    }
}
