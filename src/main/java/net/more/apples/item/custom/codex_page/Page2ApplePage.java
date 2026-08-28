package net.more.apples.item.custom.codex_page;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.more.apples.MoreThanApples;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import net.more.apples.util.discovery.DiscoveryHelperItems;

import java.util.List;
import java.util.Optional;

public class Page2ApplePage implements CodexPage{
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
                "codex.more-than-apples.page2.diamond_apple.name", ChatFormatting.AQUA,
                "codex.more-than-apples.page2.diamond_apple.desc",
                "textures/gui/items/unknown_apple.png");
        y_leftpage += ROW_HEIGHT;


        renderItem_left(graphics, font, bookX, y_leftpage, mouseX, mouseY, enchanted_diamond_apple,
                new ItemStack(ModAppleFoodItems.ENCHANTED_DIAMOND_APPLE),
                "codex.more-than-apples.page2.enchanted_diamond_apple.name", ChatFormatting.LIGHT_PURPLE,
                "codex.more-than-apples.page2.enchanted_diamond_apple.desc",
                "textures/gui/items/unknown_apple.png");
        y_leftpage += ROW_HEIGHT;

        renderItem_right(graphics, font, bookX, y_rightpage, mouseX, mouseY, netherite_apple,
                new ItemStack(ModAppleFoodItems.NETHERITE_APPLE),
                "codex.more-than-apples.page2.netherite_apple.name", ChatFormatting.AQUA,
                "codex.more-than-apples.page2.netherite_apple.desc",
                "textures/gui/items/unknown_apple.png");
        y_rightpage += ROW_HEIGHT;

        renderItem_right(graphics, font, bookX, y_rightpage, mouseX, mouseY, enchanted_netherite_apple,
                new ItemStack(ModAppleFoodItems.ENCHANTED_NETHERITE_APPLE),
                "codex.more-than-apples.page2.enchanted_netherite_apple.name", ChatFormatting.LIGHT_PURPLE,
                "codex.more-than-apples.page2.enchanted_netherite_apple.desc",
                "textures/gui/items/unknown_apple.png");
    }

    private static String[] lines(String key) {
        return Component.translatable(key).getString().split("\n", -1);
    }

    // helper method
    private void renderItem_left(GuiGraphicsExtractor graphics, Font font,
                                 int bookX, int y, int mouseX, int mouseY,
                                 boolean discovered, ItemStack item,
                                 String nameKey, ChatFormatting nameColor, String descKey,
                                 String unknownTexture) {
        if (discovered) {
            graphics.item(item, bookX + ICON_X_left, y);
            String[] desc = lines(descKey);
            for (int i = 0; i < desc.length; i++) {
                graphics.text(font, desc[i], bookX + TEXT_X_left, y + 4 + (i * 9), 0xFF888888, false);
            }
            if (mouseX >= bookX + ICON_X_left && mouseX <= bookX + ICON_X_left + 16
                    && mouseY >= y && mouseY <= y + 16) {
                graphics.setTooltipForNextFrame(font,
                        List.of(Component.translatable(nameKey).withStyle(nameColor)),
                        Optional.empty(), mouseX, mouseY);
            }
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, unknownTexture),
                    bookX + ICON_X_left, y, 0, 0, 16, 16, 16, 16);
            graphics.text(font, "Undiscovered", bookX + TEXT_X_left, y + 4, 0xFF888888, false);
            // hover → tooltip Undiscovered
            if (mouseX >= bookX + ICON_X_left && mouseX <= bookX + ICON_X_left + 16
                    && mouseY >= y && mouseY <= y + 16) {
                graphics.setTooltipForNextFrame(font,
                        Component.literal("Undiscovered").withStyle(ChatFormatting.GRAY),
                        mouseX, mouseY);
            }
        }
    }

    private void renderItem_right(GuiGraphicsExtractor graphics, Font font,
                                 int bookX, int y, int mouseX, int mouseY,
                                 boolean discovered, ItemStack item,
                                 String nameKey, ChatFormatting nameColor, String descKey,
                                 String unknownTexture) {
        if (discovered) {
            graphics.item(item, bookX + ICON_X_right, y);
            String[] desc = lines(descKey);
            for (int i = 0; i < desc.length; i++) {
                graphics.text(font, desc[i], bookX + TEXT_X_right, y + 4 + (i * 9), 0xFF888888, false);
            }
            if (mouseX >= bookX + ICON_X_right && mouseX <= bookX + ICON_X_right + 16
                    && mouseY >= y && mouseY <= y + 16) {
                graphics.setTooltipForNextFrame(font,
                        List.of(Component.translatable(nameKey).withStyle(nameColor)),
                        Optional.empty(), mouseX, mouseY);
            }
        } else {
            graphics.blit(RenderPipelines.GUI_TEXTURED,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, unknownTexture),
                    bookX + ICON_X_right, y, 0, 0, 16, 16, 16, 16);
            graphics.text(font, "Undiscovered", bookX + TEXT_X_right, y + 4, 0xFF888888, false);
            // hover → tooltip Undiscovered
            if (mouseX >= bookX + ICON_X_right && mouseX <= bookX + ICON_X_right + 16
                    && mouseY >= y && mouseY <= y + 16) {
                graphics.setTooltipForNextFrame(font,
                        Component.literal("Undiscovered").withStyle(ChatFormatting.GRAY),
                        mouseX, mouseY);
            }
        }
    }
}
