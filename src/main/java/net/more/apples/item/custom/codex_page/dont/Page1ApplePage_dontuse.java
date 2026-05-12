package net.more.apples.item.custom.codex_page.dont;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.more.apples.MoreThanApples;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import net.more.apples.item.custom.codex_page.CodexPage;
import net.more.apples.util.discovery.DiscoveryHelperItems;

public class Page1ApplePage_dontuse implements CodexPage {
    private static final int ICON_X_left = 20;
    private static final int TEXT_X_left = 40;

    private static final int ICON_X_right = 125 + 20;
    private static final int TEXT_X_right = 125 + 40;

    private static final int ROW_HEIGHT = 64;

    @Override
    public void render(GuiGraphicsExtractor graphics, Font font,
                       int bookX, int bookY, int mouseX, int mouseY) {

        //graphics.text(font, "Hello Applepedia!", bookX + ICON_X_left, bookY + 20, 0xFF000000, false);

        boolean diamond_apple = DiscoveryHelperItems.hasDiscovered("discover_items/discover_diamond_apple");
        boolean enchanted_diamond_apple = DiscoveryHelperItems.hasDiscovered("discover_items/discover_enchanted_diamond_apple");
        boolean netherite_apple= DiscoveryHelperItems.hasDiscovered("discover_items/discover_netherite_apple");
        boolean enchanted_netherite_apple  = DiscoveryHelperItems.hasDiscovered("discover_items/discover_enchanted_netherite_apple");


        int y_leftpage = bookY + 40;
        int y_rightpage = bookY + 40;

        renderItem_left(graphics, font, bookX, y_leftpage, mouseX, mouseY, diamond_apple,
                new ItemStack(ModAppleFoodItems.DIAMOND_APPLE),
                "Diamond Apple", new String[]{"Just A OP Apple", "if you eat you got :3"},
                "textures/gui/items/unknown_apple.png");
        y_leftpage += ROW_HEIGHT;


        renderItem_left(graphics, font, bookX, y_leftpage, mouseX, mouseY,  enchanted_diamond_apple,
                new ItemStack(ModAppleFoodItems.ENCHANTED_DIAMOND_APPLE),
                "Enchanted Diamond Apple", new String[]{"Man....i just"},
                "textures/gui/items/unknown_apple.png");
        y_leftpage += ROW_HEIGHT;

        renderItem_right(graphics, font, bookX, y_rightpage, mouseX, mouseY,  netherite_apple,
                new ItemStack(ModAppleFoodItems.NETHERITE_APPLE),
                "Netherite Apple", new String[]{"This too Op"},
                "textures/gui/items/unknown_apple.png");
        y_rightpage += ROW_HEIGHT;

        renderItem_right(graphics, font, bookX, y_rightpage, mouseX, mouseY,  enchanted_netherite_apple,
                new ItemStack(ModAppleFoodItems.ENCHANTED_NETHERITE_APPLE),
                "Enchanted Netherite Apple", new String[]{"This for test"},
                "textures/gui/items/unknown_frosty_apple.png");
    }

    // helper method
    private void renderItem_left(GuiGraphicsExtractor graphics, Font font,
                                 int bookX, int y, int mouseX, int mouseY,
                                 boolean discovered, ItemStack item,
                                 String name, String[] desc,
                                 String unknownTexture) {
        if (discovered) {
            graphics.item(item, bookX + ICON_X_left, y);

            boolean isHovered = mouseX >= bookX + ICON_X_left && mouseX <= bookX + ICON_X_left + 16
                    && mouseY >= y && mouseY <= y + 16;

            if (isHovered) {
                graphics.text(font, name, bookX + TEXT_X_left, y + 4, 0xFF000000, false);
            } else {
                for (int i = 0; i < desc.length; i++) {
                    graphics.text(font, desc[i], bookX + TEXT_X_left, y + 4 + (i * 9), 0xFF888888, false);
                }
            }
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, unknownTexture),
                    bookX + ICON_X_left, y, 0, 0, 16, 16, 16, 16);
            graphics.text(font, "Undiscovered", bookX + TEXT_X_left, y + 4, 0xFF888888, false);
        }
    }

    private void renderItem_right(GuiGraphicsExtractor graphics, Font font,
                                 int bookX, int y, int mouseX, int mouseY,
                                 boolean discovered, ItemStack item,
                                 String name, String[] desc,
                                 String unknownTexture) {
        if (discovered) {
            graphics.item(item, bookX + ICON_X_right, y);

            boolean isHovered = mouseX >= bookX + ICON_X_right && mouseX <= bookX + ICON_X_right + 16
                    && mouseY >= y && mouseY <= y + 16;

            if (isHovered) {
                graphics.text(font, name, bookX + TEXT_X_right, y + 4, 0xFF000000, false);
            } else {
                for (int i = 0; i < desc.length; i++) {
                    graphics.text(font, desc[i], bookX + TEXT_X_right, y + 4 + (i * 9), 0xFF888888, false);
                }
            }
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, unknownTexture),
                    bookX + ICON_X_right, y, 0, 0, 16, 16, 16, 16);
            graphics.text(font, "Undiscovered", bookX + TEXT_X_right, y + 4, 0xFF888888, false);
        }
    }
}
