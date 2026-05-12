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

public class Page0ApplePage_dontuse4 implements CodexPage {
    @Override
    public void render(GuiGraphicsExtractor graphics, Font font,
                       int bookX, int bookY, int mouseX, int mouseY) {

        final int PAGE_PX = 5;

        graphics.text(font, "Hello Applepedia!",
                bookX + 20, bookY + 20, 0xFF000000, false);

        boolean apple = DiscoveryHelper2.hasDiscovered(
                "discover_items/discover_apple");
        boolean green_apple = DiscoveryHelper2.hasDiscovered(
                "discover_items/discover_green_apple");
        boolean test_apple = DiscoveryHelper2.hasDiscovered(
                "discover_items/discover_test_apple");
        boolean frosty_apple = DiscoveryHelper2.hasDiscovered(
                "discover_items/discover_frosty_apple");

        // -------- Apple --------
        if (apple) {
            graphics.item(new ItemStack(Items.APPLE), bookX + 20, bookY + 40);
            graphics.text(font, "Apple", bookX + 40, bookY + 40, 0xFF000000, false);
            graphics.text(font, "This apple", bookX + 40, bookY + 50, 0xFF888888, false);
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                            "textures/gui/items/unknown_apple.png"),
                    bookX + 20, bookY + 40, 0, 0, 16, 16, 16, 16);
            graphics.text(font, "Undiscovered", bookX + 40, bookY + 44, 0xFF888888, false);
        }
        // ------ Gree Apple (ตำแหน่ง 60, 40 เลื่อนขวา 20px) ------
        if (green_apple) {
            graphics.item(new ItemStack(ModAppleFoodItems.GREEN_APPLE), bookX + 20, bookY + 60+PAGE_PX);
            graphics.text(font, "Green Apple", bookX + 40, bookY + 60+PAGE_PX, 0xFF000000, false);
            graphics.text(font, "Brings good luck :3", bookX + 40, bookY + 70+PAGE_PX, 0xFF888888, false);
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                            "textures/gui/items/unknown_apple.png"),
                    bookX + 20, bookY + 60, 0, 0, 16, 16, 16, 16);
            graphics.text(font, "Undiscovered", bookX + 40, bookY + 64, 0xFF888888, false);
        }
        // ------ Test_Apple ------
        if (test_apple) {
            graphics.item(new ItemStack(ModAppleFoodItems.TEST_APPLE), bookX + 20, bookY + 80+PAGE_PX);
            graphics.text(font, "Test_Apple", bookX + 40, bookY + 80+PAGE_PX, 0xFF000000, false);
            graphics.text(font, "Just_Some_Test", bookX + 40, bookY + 90+PAGE_PX, 0xFF888888, false);
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                            "textures/gui/items/unknown_apple.png"),
                    bookX + 20, bookY + 80, 0, 0, 16, 16, 16, 16);
            graphics.text(font, "Undiscovered", bookX + 40, bookY + 84+PAGE_PX, 0xFF888888, false);
        }
        // ------ Frosty Apple ------
        if (frosty_apple) {
            graphics.item(new ItemStack(ModAppleFoodItems.FROSTY_APPLE), bookX + 20, bookY + 100+PAGE_PX);
            graphics.text(font, "Frosty Apple", bookX + 40, bookY + 100+PAGE_PX, 0xFF000000, false);
            graphics.text(font, "if you eat it you got na FREEZING", bookX + 40, bookY + 110+PAGE_PX, 0xFF888888, false);
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                            "textures/gui/items/unknown_frosty_apple.png"),
                    bookX + 20, bookY + 100, 0, 0, 16, 16, 16, 16);
            graphics.text(font, "Undiscovered", bookX + 40, bookY + 104+PAGE_PX, 0xFF888888, false);
        }
    }
}
