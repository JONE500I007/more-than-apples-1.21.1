package net.more.apples.item.custom.codex_page;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.util.discovery.DiscoveryHelperBiomes;

public class Page6ApplePage implements CodexPage{
    private static final int ICON_X_left = 20;
    private static final int TEXT_X_left = 40;

    private static final int ICON_X_right = 125 + 20;
    private static final int TEXT_X_right = 125 + 40;

    private static final Identifier APPLE_GROVE_IMG = Identifier.fromNamespaceAndPath(
            MoreThanApples.MOD_ID, "textures/gui/image_biome/apple_grove.png");

    private static final int IMG_WIDTH  = 109;
    private static final int IMG_HEIGHT = 58;

    private static final int ROW_HEIGHT = 64;

    @Override
    public void render(GuiGraphicsExtractor graphics, Font font,
                       int bookX, int bookY, int mouseX, int mouseY) {

        graphics.text(font, "All Apple Biome", bookX + ICON_X_left, bookY + 20, 0xFF000000, false);

        boolean apple_grove = DiscoveryHelperBiomes.hasDiscovered("discover_biomes/discover_apple_grove");

        int y_leftpage = bookY + 40;
        int y_rightpage = bookY + 40;

        if (apple_grove) {
            renderImage(graphics, font, bookX, y_leftpage,
                    APPLE_GROVE_IMG, IMG_WIDTH, IMG_HEIGHT,
                    new Component[]{
                            Component.literal("Apple Grove Biome."),
                            Component.literal("Rich with apple trees.")
                    });
        } else {
            renderImage(graphics, font, bookX, y_leftpage,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                            "textures/gui/image_biome/unknown_apple_biome.png"),
                    IMG_WIDTH, IMG_HEIGHT,
                    new Component[]{
                            Component.literal("???").withStyle(ChatFormatting.GRAY),
                            Component.literal("Undiscovered Biome").withStyle(ChatFormatting.GRAY)
                    });
        }
    }

    // helper method
    private void renderImage(GuiGraphicsExtractor graphics, Font font,
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
}
