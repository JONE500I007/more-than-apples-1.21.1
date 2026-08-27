package net.more.apples.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Util;
import net.more.apples.sounds.ModSounds;

public class BookTextureButton extends AbstractWidget {

    private final Identifier texture;
    private final Runnable onClick;

    private final Identifier hoverTexture;


    public BookTextureButton(int x, int y, int width, int height, Identifier texture, Identifier hoverTexture, Runnable onClick) {
        super(x, y, width, height, Component.empty());
        this.texture = texture;
        this.hoverTexture = hoverTexture;
        this.onClick = onClick;
    }
/*
    @Override
    protected void extractWidgetRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        graphics.blit(
                RenderPipelines.GUI_TEXTURED,
                texture,
                this.getX(), this.getY(),
                0, 0,
                15, 21,
                15, 21
        );
    }

 */
    /*
    @Override
    protected void extractWidgetRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        graphics.blit(
                RenderPipelines.GUI_TEXTURED,
                texture,
                this.getX(), this.getY(),
                0, 0,
                15, 21,
                15, 21
        );

        // Highlight เวลา hover
        if (this.isHovered) {
            graphics.fill(
                    this.getX(), this.getY(),
                    this.getX() + 15, this.getY() + 21,
                    0x80FFFFFF // สีขาว 50% โปร่งใส
            );
        }
    }
     */

    @Override
    protected void extractWidgetRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        Identifier current = this.isHovered ? hoverTexture : texture;

        graphics.blit(
                RenderPipelines.GUI_TEXTURED,
                current,
                this.getX(), this.getY(),
                0, 0,
                15, 21,
                15, 21
        );
    }

    @Override
    public void playDownSound(SoundManager soundManager) {

    }

//    @Override
//    public void onClick(MouseButtonEvent event, boolean doubleClick) {
//        Minecraft.getInstance().getSoundManager().play(
//                SimpleSoundInstance.forUI(SoundEvents.BOOK_PAGE_TURN, 1.0F)
//        );
//        onClick.run();
//    }

    private static final SoundEvent[] PAGE_TURN_SOUNDS = {
            ModSounds.CODEX_PAGE_TURN_1,
            ModSounds.CODEX_PAGE_TURN_2,
            ModSounds.CODEX_PAGE_TURN_3,
            ModSounds.CODEX_PAGE_TURN_4
    };


    @Override
    public void onClick(MouseButtonEvent event, boolean doubleClick) {
        SoundEvent chosen = Util.getRandom(PAGE_TURN_SOUNDS, RandomSource.create());

        Minecraft.getInstance().getSoundManager().play(
                SimpleSoundInstance.forUI(chosen, 1.0F)
        );
        onClick.run();
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput output) {
        this.defaultButtonNarrationText(output);
    }
}
