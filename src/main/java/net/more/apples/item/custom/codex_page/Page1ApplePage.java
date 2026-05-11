package net.more.apples.item.custom.codex_page;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class Page1ApplePage implements CodexPage{
    @Override
    public void render(GuiGraphicsExtractor graphics, Font font,
                       int bookX, int bookY, int mouseX, int mouseY) {

        graphics.text(font, "Second Page",
                bookX + 20, bookY + 20, 0xFF3B2A1A, false);

        graphics.item(new ItemStack(Items.DIAMOND), bookX + 40, bookY + 40);
    }
}
