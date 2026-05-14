package net.more.apples.item.custom.codex_page;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.util.discovery.DiscoveryHelperBiomes;

public class Page0ApplePage implements CodexPage{
    private static final int ICON_X_left = 20;
    private static final int TEXT_X_left = 40;

    private static final int ICON_X_right = 125 + 20;
    private static final int TEXT_X_right = 125 + 40;

    private static final int LINE_HEIGHT = 10;

    @Override
    public void render(GuiGraphicsExtractor graphics, Font font,
                       int bookX, int bookY, int mouseX, int mouseY) {

        // left page
        int y = bookY + 20;

        graphics.text(font, "Welcome to the",
                bookX + ICON_X_left, y, 0xFF3B2A1A, false);
        y += LINE_HEIGHT;

        graphics.text(font,
                Component.literal("Apple Codex!").withStyle(ChatFormatting.BOLD),
                bookX + ICON_X_left, y, 0xFF3B2A1A, false);
        y += LINE_HEIGHT + 4; // เว้นช่องว่างหลังชื่อ

        String[] leftLines = {
                "This tome holds",
                "knowledge",
                "of every apple",
                "discovered",
                "across your journey.",
                "",
                "Explore the world,",
                "collect rare apples,",
                "and uncover their",
                "secrets",
                "",
                "\u2014 Happy Exploring! \u2014"  // — Happy Exploring! —
        };

        for (String line : leftLines) {
            if (line.isEmpty()) {
                y += LINE_HEIGHT / 2; // เว้นบรรทัด
            } else if (line.startsWith("\u2014")) {
                // บรรทัดสุดท้าย italic
                graphics.text(font,
                        Component.literal(line).withStyle(ChatFormatting.ITALIC),
                        bookX + ICON_X_left, y, 0xFF888888, false);
                y += LINE_HEIGHT;
            } else {
                graphics.text(font, line,
                        bookX + ICON_X_left, y, 0xFF3B2A1A, false);
                y += LINE_HEIGHT;
            }
        }

        // right page
        int ry = bookY + 20;

        graphics.text(font,
                Component.literal("How to Use").withStyle(ChatFormatting.BOLD),
                bookX + ICON_X_right, ry, 0xFF3B2A1A, false);
        ry += LINE_HEIGHT + 4;

        String[] rightLines = {
                "\u27A4 Tap an item icon",       // ➤
                "  to reveal its name.",
                "",
                "\u27A4 Gray icons mean",
                "  the item is yet",
                "  to be discovered.",
                "",
                "\u27A4 Use the bookmarks",
                "  on the right to jump",
                "  between categories.",
                "",
                "\u27A4 New entries appear",
                "  as you explore",
                "  the world."
        };

        for (String line : rightLines) {
            if (line.isEmpty()) {
                ry += LINE_HEIGHT / 2;
            } else if (line.startsWith("\u27A4")) {
                // บรรทัด bullet สีน้ำตาลเข้ม
                graphics.text(font, line,
                        bookX + ICON_X_right, ry, 0xFF3B2A1A, false);
                ry += LINE_HEIGHT;
            } else {
                // บรรทัด indent สีจาง
                graphics.text(font, line,
                        bookX + ICON_X_right, ry, 0xFF888888, false);
                ry += LINE_HEIGHT;
            }
        }
    }
}
