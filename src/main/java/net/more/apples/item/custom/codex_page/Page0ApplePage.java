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

    private static String[] lines(String key) {
        return Component.translatable(key).getString().split("\n", -1);
    }

    @Override
    public void render(GuiGraphicsExtractor graphics, Font font,
                       int bookX, int bookY, int mouseX, int mouseY) {

        // left page
        int y = bookY + 20;

        graphics.text(font,
                Component.translatable("codex.more-than-apples.page0.welcome1"),
                bookX + ICON_X_left, y, 0xFF3B2A1A, false);
        y += LINE_HEIGHT;

        graphics.text(font,
                Component.translatable("codex.more-than-apples.page0.welcome2").withStyle(ChatFormatting.BOLD),
                bookX + ICON_X_left, y, 0xFF3B2A1A, false);
        y += LINE_HEIGHT + 4; // เว้นช่องว่างหลังชื่อ

        String[] leftLines = lines("codex.more-than-apples.page0.body_left");

        for (String line : leftLines) {
            if (line.isEmpty()) {
                y += LINE_HEIGHT / 2; // เว้นบรรทัด
            } else if (line.startsWith("—")) {
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
                Component.translatable("codex.more-than-apples.page0.how_to_use").withStyle(ChatFormatting.BOLD),
                bookX + ICON_X_right, ry, 0xFF3B2A1A, false);
        ry += LINE_HEIGHT + 4;

        String[] rightLines = lines("codex.more-than-apples.page0.body_right");

        for (String line : rightLines) {
            if (line.isEmpty()) {
                ry += LINE_HEIGHT / 2;
            } else if (line.startsWith("➤")) {
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
