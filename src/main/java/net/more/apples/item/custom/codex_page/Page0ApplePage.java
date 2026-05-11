package net.more.apples.item.custom.codex_page;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.more.apples.MoreThanApples;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import net.more.apples.util.discovery.DiscoveryHelper2;

import java.util.List;
import java.util.Optional;

public class Page0ApplePage implements CodexPage{
    @Override
    public void render(GuiGraphicsExtractor graphics, Font font,
                       int bookX, int bookY, int mouseX, int mouseY) {

        graphics.text(font, "Hello Applepedia!",
                bookX + 20, bookY + 20, 0xFF3B2A1A, false);

        boolean apple = DiscoveryHelper2.hasDiscovered("discover_items/discover_apple");
        boolean test_apple = DiscoveryHelper2.hasDiscovered("discover_items/discover_test_apple");

        // -------- Apple --------
        if (apple) {
            graphics.item(new ItemStack(Items.APPLE), bookX + 40, bookY + 40);
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                            "textures/gui/items/unknown_apple.png"),
                    bookX + 40, bookY + 40, 0, 0, 16, 16, 16, 16);
        }
        if (mouseX >= bookX + 40 && mouseX <= bookX + 56
                && mouseY >= bookY + 40 && mouseY <= bookY + 56) {
            if (apple) {
                graphics.setTooltipForNextFrame(font,
                        List.of(Component.literal("Apple"),
                                Component.literal("This apple")),
                        Optional.empty(), mouseX, mouseY);
            } else {
                graphics.setTooltipForNextFrame(font,
                        Component.literal("Undiscovered"), mouseX, mouseY);
            }
        }
        // ------ Test_Apple (ตำแหน่ง 60, 40 เลื่อนขวา 20px) ------
        if (test_apple) {
            graphics.item(new ItemStack(ModAppleFoodItems.TEST_APPLE), bookX + 60, bookY + 40);
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                            "textures/gui/items/unknown_apple.png"),
                    bookX + 60, bookY + 40, 0, 0, 16, 16, 16, 16);
        }
        if (mouseX >= bookX + 60 && mouseX <= bookX + 76
                && mouseY >= bookY + 40 && mouseY <= bookY + 56) {
            if (test_apple) {
                graphics.setTooltipForNextFrame(font,
                        List.of(Component.literal("Test_Apple"),
                                Component.literal("This_Test_Apple")),
                        Optional.empty(), mouseX, mouseY);
            } else {
                graphics.setTooltipForNextFrame(font,
                        Component.literal("Undiscovered"), mouseX, mouseY);
            }
        }
    }
}
