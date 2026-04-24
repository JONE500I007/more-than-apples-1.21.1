package net.more.apples.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.more.apples.block.custom.AppleShelfBlock;
import net.more.apples.entity.AppleBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

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
        state.facing = blockEntity.getBlockState().getValue(AppleShelfBlock.FACING);

        Arrays.fill(state.items, null);

        NonNullList<ItemStack> items = blockEntity.getItems();

        for (int i = 0; i < items.size(); i++) {
            ItemStack stack = items.get(i);
            if (!stack.isEmpty()) {
                ItemStackRenderState renderState = new ItemStackRenderState();

                this.itemModelResolver.updateForTopItem(
                        renderState,
                        stack,
                        ItemDisplayContext.GROUND,
                        blockEntity.getLevel(),
                        null,
                        i
                );

                state.items[i] = renderState;
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

        for (int slot = 0; slot < state.items.length; slot++) {
            ItemStackRenderState item = state.items[slot];
            if (item == null) continue;

            poseStack.pushPose();

            poseStack.translate(0.5, 0.5, 0.5);

            float xOffset = (slot - 1) * 0.3f;
            poseStack.translate(xOffset, -0.2, -0.25);

            poseStack.mulPose(Axis.YP.rotationDegrees(yRot));
            poseStack.mulPose(Axis.XP.rotationDegrees(90f));

            poseStack.scale(0.4f, 0.4f, 0.4f);

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
}
