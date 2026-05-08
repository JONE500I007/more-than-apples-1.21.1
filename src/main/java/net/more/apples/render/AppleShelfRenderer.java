package net.more.apples.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.more.apples.block.custom.AppleShelfBlock;
import net.more.apples.entity.AppleBlockEntity;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class AppleShelfRenderer implements BlockEntityRenderer<AppleBlockEntity, AppleShelfRenderState> {

    private final ItemModelResolver itemModelResolver;

    public AppleShelfRenderer(BlockEntityRendererProvider.Context context) {
        this.itemModelResolver = context.itemModelResolver();
    }

    @Override
    public AppleShelfRenderState createRenderState() {
        return new AppleShelfRenderState();
    }

    @Override
    public void extractRenderState(
            AppleBlockEntity blockEntity,
            AppleShelfRenderState state,
            float partialTicks,
            Vec3 cameraPos,
            @Nullable ModelFeatureRenderer.CrumblingOverlay overlay
    ) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPos, overlay);

        state.facing = blockEntity.getBlockState().getValue(AppleShelfBlock.FACING);

        state.alignToBottom = false;

        for (int i = 0; i < 3; i++) {
            ItemStack stack = blockEntity.getItem(i);

            if (!stack.isEmpty()) {
                ItemStackRenderState rs = new ItemStackRenderState();

                itemModelResolver.updateForTopItem(
                        rs,
                        stack,
                        ItemDisplayContext.ON_SHELF,
                        blockEntity.getLevel(),
                        null,
                        i
                );

                state.items[i] = rs;
            } else {
                state.items[i] = null;
            }
        }
    }

    @Override
    public void submit(
            AppleShelfRenderState state,
            PoseStack poseStack,
            SubmitNodeCollector collector,
            CameraRenderState camera
    ) {
        float yRot = state.facing.getAxis().isHorizontal()
                ? -state.facing.toYRot()
                : 180.0F;

        for (int slot = 0; slot < state.items.length; ++slot) {
            ItemStackRenderState item = state.items[slot];
            if (item == null) continue;

            submitItem(state, item, poseStack, collector, slot, yRot);
        }
    }

    private void submitItem(
            AppleShelfRenderState state,
            ItemStackRenderState item,
            PoseStack poseStack,
            SubmitNodeCollector collector,
            int slot,
            float yRot
    ) {
        float x = (slot - 1) * 0.3125F;

        Vec3 offset = new Vec3(
                x,
                0.0,
                -0.25F
        );

        poseStack.pushPose();

        //move to cen block
        poseStack.translate(0.5F, 0.5F, 0.5F);

        //rotateblock
        poseStack.mulPose(Axis.YP.rotationDegrees(yRot));

        //slot
        poseStack.translate(offset);

        // scale
        poseStack.scale(0.25F, 0.25F, 0.25F);

        AABB box = item.getModelBoundingBox();

        double offsetY = -box.minY;
        offsetY += -(box.maxY - box.minY) / 2.0;

        poseStack.translate(0.0, offsetY, 0.0);

        // render
        item.submit(
                poseStack,
                collector,
                state.lightCoords,
                OverlayTexture.NO_OVERLAY,
                0
        );

        poseStack.popPose();
    }
}
