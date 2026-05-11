package net.more.apples.item.custom.codex_page;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;

public class BookmarkButton extends AbstractWidget {
    private final Identifier texture;
    private final Identifier hoverTexture;
    private final Runnable action;

    private static final int BM_WIDTH = 30;
    private static final int BM_HEIGHT = 15;

    public BookmarkButton(int x, int y, Identifier texture, Identifier hoverTexture, Runnable action) {
        super(x, y, BM_WIDTH, BM_HEIGHT, Component.empty());
        this.texture = texture;
        this.hoverTexture = hoverTexture;
        this.action = action;
    }

    @Override
    protected void extractWidgetRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        Identifier current = this.isHovered ? hoverTexture : texture;
        graphics.blit(RenderPipelines.GUI_TEXTURED, current,
                this.getX(), this.getY(), 0, 0, BM_WIDTH, BM_HEIGHT, BM_WIDTH, BM_HEIGHT);
    }

    @Override
    public void onClick(MouseButtonEvent event, boolean doubleClick) {
        Minecraft.getInstance().getSoundManager().play(
                SimpleSoundInstance.forUI(SoundEvents.BOOK_PAGE_TURN, 1.0F)
        );
        action.run();
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput output) {
        this.defaultButtonNarrationText(output);
    }
}
