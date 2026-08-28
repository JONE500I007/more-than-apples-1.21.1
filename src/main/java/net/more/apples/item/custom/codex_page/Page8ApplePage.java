package net.more.apples.item.custom.codex_page;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.util.discovery.DiscoveryHelperBiomes;

public class Page8ApplePage implements CodexPage{
    private static final int ICON_X_left = 20;
    private static final int TEXT_X_left = 40;

    private static final int ICON_X_right = 125 + 20;
    private static final int TEXT_X_right = 125 + 40;

    private static final Identifier BADLANDS_HIDEOUT_IMG = Identifier.fromNamespaceAndPath(
            MoreThanApples.MOD_ID, "textures/gui/image_structure/badlands_hideout.png");
    private static final Identifier UNKNOWN_STRUCTURE_IMG = Identifier.fromNamespaceAndPath(
            MoreThanApples.MOD_ID, "textures/gui/image_structure/unknown_structure.png");

    private static final int IMG_WIDTH  = 109;
    private static final int IMG_HEIGHT = 58;

    private static final int ROW_HEIGHT = 64;

    @Override
    public void render(GuiGraphicsExtractor graphics, Font font,
                       int bookX, int bookY, int mouseX, int mouseY) {

        graphics.text(font, "All Structures", bookX + ICON_X_left, bookY + 20, 0xFF000000, false);

        boolean badlands_hideout = DiscoveryHelperBiomes.hasDiscovered(
                "discover_structures/discover_badlands_hideout");

        int y_leftpage = bookY + 40;

        if (badlands_hideout) {
            renderImage_left(graphics, font, bookX, y_leftpage,
                    BADLANDS_HIDEOUT_IMG, IMG_WIDTH, IMG_HEIGHT,
                    new Component[]{
                            Component.literal("Badlands Hideout"),
                            Component.literal("Structure."),
                            Component.literal("A hidden shelter"),
                            Component.literal("in the Badlands,"),
                            Component.literal("guarding chests,"),
                            Component.literal("barrels, and pots"),
                            Component.literal("full of loot.")
                    });
        } else {
            renderImage_left(graphics, font, bookX, y_leftpage,
                    UNKNOWN_STRUCTURE_IMG,
                    IMG_WIDTH, IMG_HEIGHT,
                    new Component[]{
                            Component.literal("???").withStyle(ChatFormatting.GRAY),
                            Component.literal("Undiscovered Structure").withStyle(ChatFormatting.GRAY)
                    });
        }
    }

    // helper method
    private void renderImage_left(GuiGraphicsExtractor graphics, Font font,
                                  int bookX, int y,
                                  Identifier image, int imgW, int imgH,
                                  Component[] caption) {
        graphics.blit(RenderPipelines.GUI_TEXTURED,
                image,
                bookX + ICON_X_left, y,
                0, 0,
                imgW, imgH,
                imgW, imgH);

        for (int i = 0; i < caption.length; i++) {
            graphics.text(font, caption[i],
                    bookX + ICON_X_left, y + imgH + 3 + (i * 9),
                    0xFF888888, false);
        }
    }

    private void renderImage_right(GuiGraphicsExtractor graphics, Font font,
                                   int bookX, int y,
                                   Identifier image, int imgW, int imgH,
                                   Component[] caption) {
        graphics.blit(RenderPipelines.GUI_TEXTURED,
                image,
                bookX + ICON_X_right, y,
                0, 0,
                imgW, imgH,
                imgW, imgH);

        for (int i = 0; i < caption.length; i++) {
            graphics.text(font, caption[i],
                    bookX + ICON_X_right, y + imgH + 3 + (i * 9),
                    0xFF888888, false);
        }
    }
}
