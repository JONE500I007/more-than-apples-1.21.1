package net.more.apples.item.custom.codex_page;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;

public interface CodexPage {
    void render(GuiGraphicsExtractor graphics, Font font,
                int bookX, int bookY, int mouseX, int mouseY);
}
