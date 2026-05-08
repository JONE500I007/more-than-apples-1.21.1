package net.more.apples.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.Direction;
import org.jspecify.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class AppleShelfRenderState extends BlockEntityRenderState {
    public final @Nullable ItemStackRenderState[] items = new ItemStackRenderState[3];
    public boolean alignToBottom;
    public Direction facing;

    public AppleShelfRenderState() {
        this.facing = Direction.NORTH;
    }
}
