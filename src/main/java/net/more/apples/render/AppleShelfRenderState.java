package net.more.apples.render;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.Direction;

public class AppleShelfRenderState extends BlockEntityRenderState {
    public Direction facing;
    public ItemStackRenderState[] items = new ItemStackRenderState[3];
}
