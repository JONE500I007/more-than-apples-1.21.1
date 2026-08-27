package net.more.apples.item.custom.codex_page;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.util.discovery.DiscoveryHelperBiomes;

public class Page5ApplePage implements CodexPage{
    private static final int ICON_X_left = 20;
    private static final int TEXT_X_left = 40;

    private static final int ICON_X_right = 125 + 20;
    private static final int TEXT_X_right = 125 + 40;

    private static final Identifier FROSTY_APPLE = Identifier.fromNamespaceAndPath(
            MoreThanApples.MOD_ID, "textures/gui/image_biome/frosty_apple.png");
    private static final Identifier GOLDEN_APPLE_ORCHARD_IMG = Identifier.fromNamespaceAndPath(
            MoreThanApples.MOD_ID, "textures/gui/image_biome/ancient_apple_wilds.png");


    private static final int IMG_WIDTH  = 109;
    private static final int IMG_HEIGHT = 58;

    private static final int ROW_HEIGHT = 64;

    @Override
    public void render(GuiGraphicsExtractor graphics, Font font,
                       int bookX, int bookY, int mouseX, int mouseY) {

        //graphics.text(font, "All Apple Biomes", bookX + ICON_X_left, bookY + 20, 0xFF000000, false);

        boolean frosty_apple = DiscoveryHelperBiomes.hasDiscovered(
                "discover_biomes/discover_frosty_apple");
        boolean golden_apple_orchard = DiscoveryHelperBiomes.hasDiscovered(
                "discover_biomes/discover_ancient_apple_wilds");

        int y_leftpage = bookY + 40;
        int y_rightpage = bookY + 40;

        if (frosty_apple) {
            renderImage_left(graphics, font, bookX, y_leftpage,
                    FROSTY_APPLE, IMG_WIDTH, IMG_HEIGHT,
                    new Component[]{
                            Component.literal("Frosty Apple Biome."),
                            Component.literal("A snowy, freezing"),
                            Component.literal("biome. Frosty apple"),
                            Component.literal("trees drop chilled"),
                            Component.literal("apples.")
                    });
        } else {
            renderImage_left(graphics, font, bookX, y_leftpage,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                            "textures/gui/image_biome/unknown_apple_biome.png"),
                    IMG_WIDTH, IMG_HEIGHT,
                    new Component[]{
                            Component.literal("???").withStyle(ChatFormatting.GRAY),
                            Component.literal("Undiscovered Biome").withStyle(ChatFormatting.GRAY)
                    });
        }

        if (golden_apple_orchard) {
            renderImage_right(graphics, font, bookX, y_leftpage,
                    GOLDEN_APPLE_ORCHARD_IMG, IMG_WIDTH, IMG_HEIGHT,
                    new Component[]{
                            Component.literal("Ancient Apple Wilds"),
                            Component.literal("Biome. A wild,"),
                            Component.literal("overgrown biome, home"),
                            Component.literal(" to massive, ancient"),
                            Component.literal("apple trees.")
                    });
        } else {
            renderImage_right(graphics, font, bookX, y_leftpage,
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
