package net.more.apples.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.more.apples.block.ModBlocks2;
import net.more.apples.world.IShelfLike;
import org.jspecify.annotations.Nullable;

public class AppleBlockEntity extends BlockEntity implements WorldlyContainer, IShelfLike {

    // inv item in shelf
    private final NonNullList<ItemStack> items =
            NonNullList.withSize(3, ItemStack.EMPTY);

    // vanilla shelf
    private boolean alignItemsToBottom = false;

    public AppleBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks2.APPLE_SHELF_ENTITY_TYPE, pos, state);
    }


    // item logic


    @Override
    public int getContainerSize() {
        return 3;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : items) {
            if (!stack.isEmpty()) return false;
        }
        return true;
    }

    public ItemStack getItem(int slot) {
        return items.get(slot);
    }

    @Override
    public ItemStack removeItem(int slot, int count) {
        return ContainerHelper.removeItem(this.items, slot, count);
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        return ContainerHelper.takeItem(this.items, slot);
    }

    public void setItem(int slot, ItemStack stack) {
        items.set(slot, stack);
        setChanged();
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    // align logic

    public boolean getAlignItemsToBottom() {
        return this.alignItemsToBottom;
    }

    public void setAlignItemsToBottom(boolean value) {
        this.alignItemsToBottom = value;
        setChanged();
    }


    //save item and load item


    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);

        this.items.clear();
        ContainerHelper.loadAllItems(input, this.items);

        this.alignItemsToBottom = input.getBooleanOr("align_items_to_bottom", false);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);

        ContainerHelper.saveAllItems(output, this.items, true);
        output.putBoolean("align_items_to_bottom", this.alignItemsToBottom);
    }


    //client sync


    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        TagValueOutput output = TagValueOutput.createWithoutContext(
                ProblemReporter.DISCARDING
        );

        ContainerHelper.saveAllItems(output, this.items, true);
        output.putBoolean("align_items_to_bottom", this.alignItemsToBottom);

        return output.buildResult();
    }


    // update item


    @Override
    public void setChanged() {
        super.setChanged();

        if (level != null) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }
    //HOPPER SUPPORT

    @Override
    public int[] getSlotsForFace(Direction direction) {
        return new int[]{0, 1, 2};
    }

    @Override
    public boolean canPlaceItemThroughFace(int slot, ItemStack itemStack, @Nullable Direction direction) {
        return true;
    }

    @Override
    public boolean canTakeItemThroughFace(int slot, ItemStack itemStack, Direction direction) {
        return true;
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }

    public ItemStack swapItemNoUpdate(int slot, ItemStack stack) {
        ItemStack old = this.removeItemNoUpdate(slot);
        this.items.set(slot, stack);
        return old;
    }
}
