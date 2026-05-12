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
import net.more.apples.util.discovery.DiscoveryHelperItems;

public class Page0ApplePage_dontuse5 implements CodexPage {
    private static final int ICON_X_left = 20;
    private static final int TEXT_X_left = 40;

    private static final int ICON_X_right = 125 + 20;
    private static final int TEXT_X_right = 125 + 40;

    private static final int ROW_HEIGHT = 64;

    @Override
    public void render(GuiGraphicsExtractor graphics, Font font,
                       int bookX, int bookY, int mouseX, int mouseY) {

        graphics.text(font, "Hello Applepedia!", bookX + ICON_X_left, bookY + 20, 0xFF000000, false);

        boolean apple       = DiscoveryHelperItems.hasDiscovered("discover_items/discover_apple");
        boolean green_apple = DiscoveryHelperItems.hasDiscovered("discover_items/discover_green_apple");
        boolean test_apple  = DiscoveryHelperItems.hasDiscovered("discover_items/discover_test_apple");
        boolean frosty_apple= DiscoveryHelperItems.hasDiscovered("discover_items/discover_frosty_apple");

        int y_leftpage = bookY + 40;
        int y_rightpage = bookY + 40;

        renderItem_left(graphics, font, bookX, y_leftpage, apple,
                new ItemStack(Items.APPLE),
                "Apple", new String[]{"A common fruit."},
                "textures/gui/items/unknown_apple.png");
        y_leftpage += ROW_HEIGHT;

        renderItem_left(graphics, font, bookX, y_leftpage, green_apple,
                new ItemStack(ModAppleFoodItems.GREEN_APPLE),
                "Green Apple", new String[]{"Brings good luck :3"},
                "textures/gui/items/unknown_apple.png");
        y_leftpage += ROW_HEIGHT;

        renderItem_right(graphics, font, bookX, y_rightpage, test_apple,
                new ItemStack(ModAppleFoodItems.TEST_APPLE),
                "Test_Apple", new String[]{"Just_some_test."},
                "textures/gui/items/unknown_apple.png");
        y_rightpage += ROW_HEIGHT;

        renderItem_right(graphics, font, bookX, y_rightpage, frosty_apple,
                new ItemStack(ModAppleFoodItems.FROSTY_APPLE),
                "Frosty Apple", new String[]{"Gives Freezing effect."},
                "textures/gui/items/unknown_frosty_apple.png");
    }

    // helper method
    private void renderItem_left(GuiGraphicsExtractor graphics, Font font,
                                 int bookX, int y,
                                 boolean discovered, ItemStack item,
                                 String name, String[] desc,
                                 String unknownTexture) {
        if (discovered) {
            graphics.item(item, bookX + ICON_X_left, y);
            graphics.text(font, name, bookX + TEXT_X_left, y, 0xFF000000, false);
            for (int i = 0; i < desc.length; i++) {
                graphics.text(font, desc[i], bookX + TEXT_X_left, y + 10 + (i * 9), 0xFF888888, false);
            }
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, unknownTexture),
                    bookX + ICON_X_left, y, 0, 0, 16, 16, 16, 16);
            graphics.text(font, "Undiscovered", bookX + TEXT_X_left, y + 4, 0xFF888888, false);
        }
    }

    private void renderItem_right(GuiGraphicsExtractor graphics, Font font,
                                 int bookX, int y,
                                 boolean discovered, ItemStack item,
                                 String name, String[] desc,
                                 String unknownTexture) {
        if (discovered) {
            graphics.item(item, bookX + ICON_X_right, y);
            graphics.text(font, name, bookX + TEXT_X_right, y, 0xFF000000, false);
            for (int i = 0; i < desc.length; i++) {
                graphics.text(font, desc[i], bookX + TEXT_X_right, y + 10 + (i * 9), 0xFF888888, false);
            }
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, unknownTexture),
                    bookX + ICON_X_right, y, 0, 0, 16, 16, 16, 16);
            graphics.text(font, "Undiscovered", bookX + TEXT_X_right, y + 4, 0xFF888888, false);
        }
    }
}
