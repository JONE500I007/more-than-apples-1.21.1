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

public class Page0ApplePage_dontuse2 implements CodexPage {
    private static final int ICON_X = 20;
    private static final int TEXT_X = 40;
    private static final int ROW_HEIGHT = 22;

    @Override
    public void render(GuiGraphicsExtractor graphics, Font font,
                       int bookX, int bookY, int mouseX, int mouseY) {

        graphics.text(font, "Hello Applepedia!", bookX + ICON_X, bookY + 20, 0xFF000000, false);

        boolean apple       = DiscoveryHelper2.hasDiscovered("discover_items/discover_apple");
        boolean green_apple = DiscoveryHelper2.hasDiscovered("discover_items/discover_green_apple");
        boolean test_apple  = DiscoveryHelper2.hasDiscovered("discover_items/discover_test_apple");
        boolean frosty_apple= DiscoveryHelper2.hasDiscovered("discover_items/discover_frosty_apple");

        int y = bookY + 40;

        renderItem(graphics, font, bookX, y, apple,
                new ItemStack(Items.APPLE),
                "Apple", "A common fruit.",
                "textures/gui/items/unknown_apple.png");
        y += ROW_HEIGHT;

        renderItem(graphics, font, bookX, y, green_apple,
                new ItemStack(ModAppleFoodItems.GREEN_APPLE),
                "Green Apple", "Brings good luck :3",
                "textures/gui/items/unknown_apple.png");
        y += ROW_HEIGHT;

        renderItem(graphics, font, bookX, y, test_apple,
                new ItemStack(ModAppleFoodItems.TEST_APPLE),
                "Test Apple", "Just some test.",
                "textures/gui/items/unknown_apple.png");
        y += ROW_HEIGHT;

        renderItem(graphics, font, bookX, y, frosty_apple,
                new ItemStack(ModAppleFoodItems.FROSTY_APPLE),
                "Frosty Apple", "Gives Freezing effect.",
                "textures/gui/items/unknown_frosty_apple.png");
    }

    // helper method
    private void renderItem(GuiGraphicsExtractor graphics, Font font,
                            int bookX, int y,
                            boolean discovered, ItemStack item,
                            String name, String desc,
                            String unknownTexture) {
        if (discovered) {
            graphics.item(item, bookX + ICON_X, y);
            graphics.text(font, name, bookX + TEXT_X, y, 0xFF000000, false);
            graphics.text(font, desc, bookX + TEXT_X, y + 10, 0xFF888888, false);
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, unknownTexture),
                    bookX + ICON_X, y, 0, 0, 16, 16, 16, 16);
            graphics.text(font, "Undiscovered", bookX + TEXT_X, y + 4, 0xFF888888, false);
        }
    }
}
