package net.more.apples.item.custom.codex_page.dont;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.more.apples.MoreThanApples;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import net.more.apples.item.custom.codex_page.CodexPage;
import net.more.apples.util.discovery.DiscoveryHelper2;

public class Page0ApplePage_dontuse3 implements CodexPage {
    @Override
    public void render(GuiGraphicsExtractor graphics, Font font,
                       int bookX, int bookY, int mouseX, int mouseY) {

        final int ICON_X    = 20;
        final int TEXT_X    = 40;
        final int ROW_HEIGHT = 22;

        graphics.text(font, "Hello Applepedia!",
                bookX + ICON_X, bookY + 20, 0xFF000000, false);

        boolean apple        = DiscoveryHelper2.hasDiscovered("discover_items/discover_apple");
        boolean green_apple  = DiscoveryHelper2.hasDiscovered("discover_items/discover_green_apple");
        boolean test_apple   = DiscoveryHelper2.hasDiscovered("discover_items/discover_test_apple");
        boolean frosty_apple = DiscoveryHelper2.hasDiscovered("discover_items/discover_frosty_apple");

        int y = bookY + 40; // cursor Y

        // -------- Apple --------
        if (apple) {
            graphics.item(new ItemStack(Items.APPLE), bookX + ICON_X, y);
            graphics.text(font, "Apple", bookX + TEXT_X, y, 0xFF000000, false);
            graphics.text(font, "A common fruit.", bookX + TEXT_X, y + 10, 0xFF888888, false);
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                            "textures/gui/items/unknown_apple.png"),
                    bookX + ICON_X, y, 0, 0, 16, 16, 16, 16);
            graphics.text(font, "Undiscovered", bookX + TEXT_X, y + 4, 0xFF888888, false);
        }
        y += ROW_HEIGHT;

        // -------- Green Apple --------
        if (green_apple) {
            graphics.item(new ItemStack(ModAppleFoodItems.GREEN_APPLE), bookX + ICON_X, y);
            graphics.text(font, "Green Apple", bookX + TEXT_X, y, 0xFF000000, false);
            graphics.text(font, "Brings good luck :3", bookX + TEXT_X, y + 10, 0xFF888888, false);
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                            "textures/gui/items/unknown_apple.png"),
                    bookX + ICON_X, y, 0, 0, 16, 16, 16, 16);
            graphics.text(font, "Undiscovered", bookX + TEXT_X, y + 4, 0xFF888888, false);
        }
        y += ROW_HEIGHT;

        // -------- Test Apple --------
        if (test_apple) {
            graphics.item(new ItemStack(ModAppleFoodItems.TEST_APPLE), bookX + ICON_X, y);
            graphics.text(font, "Test Apple", bookX + TEXT_X, y, 0xFF000000, false);
            graphics.text(font, "Just some test.", bookX + TEXT_X, y + 10, 0xFF888888, false);
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                            "textures/gui/items/unknown_apple.png"),
                    bookX + ICON_X, y, 0, 0, 16, 16, 16, 16);
            graphics.text(font, "Undiscovered", bookX + TEXT_X, y + 4, 0xFF888888, false);
        }
        y += ROW_HEIGHT;

        // -------- Frosty Apple --------
        if (frosty_apple) {
            graphics.item(new ItemStack(ModAppleFoodItems.FROSTY_APPLE), bookX + ICON_X, y);
            graphics.text(font, "Frosty Apple", bookX + TEXT_X, y, 0xFF000000, false);
            graphics.text(font, "Gives Freezing effect.", bookX + TEXT_X, y + 10, 0xFF888888, false);
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                            "textures/gui/items/unknown_frosty_apple.png"),
                    bookX + ICON_X, y, 0, 0, 16, 16, 16, 16);
            graphics.text(font, "Undiscovered", bookX + TEXT_X, y + 4, 0xFF888888, false);
        }
        y += ROW_HEIGHT;
    }
}
