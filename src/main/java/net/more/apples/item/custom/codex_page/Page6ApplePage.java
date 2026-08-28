package net.more.apples.item.custom.codex_page;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.util.discovery.DiscoveryHelperItems;

import java.util.List;
import java.util.Optional;

public class Page6ApplePage implements CodexPage{
    private static final int ICON_X_left = 20;
    private static final int TEXT_X_left = 40;

    private static final int ICON_X_right = 125 + 20;
    private static final int TEXT_X_right = 125 + 40;

    private static final int ICON_SIZE = 18;

    private static final int ROW_HEIGHT = 64;

    @Override
    public void render(GuiGraphicsExtractor graphics, Font font,
                       int bookX, int bookY, int mouseX, int mouseY) {

        graphics.text(font, "All Mod Effects", bookX + ICON_X_left, bookY + 20, 0xFF000000, false);

        boolean darkness_immune = DiscoveryHelperItems.hasDiscovered("discover_effects/discover_darkness_immune");
        boolean slowness_immune = DiscoveryHelperItems.hasDiscovered("discover_effects/discover_slowness_immune");
        boolean mining_fatigue_immune = DiscoveryHelperItems.hasDiscovered("discover_effects/discover_mining_fatigue_immune");
        boolean freezing_resistance = DiscoveryHelperItems.hasDiscovered("discover_effects/discover_freezing_resistance");

        int y_leftpage = bookY + 40;
        int y_rightpage = bookY + 40;

        renderEffect_left(graphics, font, bookX, y_leftpage, mouseX, mouseY, darkness_immune,
                "textures/mob_effect/darkness_immune.png",
                Component.literal("Darkness Immune"),
                new Component[]{
                        Component.literal("Removes and blocks"),
                        Component.literal("the Darkness effect."),
                        Component.literal("Granted by the"),
                        Component.literal("Enchanted Netherite"),
                        Component.literal("Apple.")
                },
                "textures/gui/effects/unknown_darkness_im.png");
        y_leftpage += ROW_HEIGHT;

        renderEffect_left(graphics, font, bookX, y_leftpage, mouseX, mouseY, slowness_immune,
                "textures/mob_effect/slowness_immune.png",
                Component.literal("Slowness Immune"),
                new Component[]{
                        Component.literal("Removes and blocks"),
                        Component.literal("the Slowness effect."),
                        Component.literal("Granted by the"),
                        Component.literal("Enchanted Netherite"),
                        Component.literal("Apple.")
                },
                "textures/gui/effects/unknown_slowness_im.png");
        y_leftpage += ROW_HEIGHT;

        renderEffect_right(graphics, font, bookX, y_rightpage, mouseX, mouseY, mining_fatigue_immune,
                "textures/mob_effect/mining_fatigue_immune.png",
                Component.literal("Mining Fatigue Immune"),
                new Component[]{
                        Component.literal("Removes and blocks"),
                        Component.literal("Mining Fatigue."),
                        Component.literal("Granted by the"),
                        Component.literal("Enchanted Netherite"),
                        Component.literal("Apple.")
                },
                "textures/gui/effects/unknown_mining_fatigue_im.png");
        y_rightpage += ROW_HEIGHT;

        renderEffect_right(graphics, font, bookX, y_rightpage, mouseX, mouseY, freezing_resistance,
                "textures/mob_effect/freezing_resistance.png",
                Component.literal("Freezing Resistance"),
                new Component[]{
                        Component.literal("Removes Freezing and"),
                        Component.literal("stops you from"),
                        Component.literal("freezing again."),
                        Component.literal("Granted by the"),
                        Component.literal("Enchanted Diamond"),
                        Component.literal("Apple or higher.")
                },
                "textures/gui/effects/unknown_freezing_resistance.png");
    }

    // helper method
    private void renderEffect_left(GuiGraphicsExtractor graphics, Font font,
                                   int bookX, int y, int mouseX, int mouseY,
                                   boolean discovered, String effectTexture,
                                   Component name, Component[] desc,
                                   String unknownTexture) {
        Identifier icon = Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                discovered ? effectTexture : unknownTexture);

        graphics.blit(RenderPipelines.GUI_TEXTURED, icon,
                bookX + ICON_X_left, y, 0, 0, ICON_SIZE, ICON_SIZE, ICON_SIZE, ICON_SIZE);

        if (discovered) {
            for (int i = 0; i < desc.length; i++) {
                graphics.text(font, desc[i], bookX + TEXT_X_left, y + 4 + (i * 9), 0xFF888888, false);
            }
        } else {
            graphics.text(font, "Undiscovered", bookX + TEXT_X_left, y + 4, 0xFF888888, false);
        }

        if (mouseX >= bookX + ICON_X_left && mouseX <= bookX + ICON_X_left + ICON_SIZE
                && mouseY >= y && mouseY <= y + ICON_SIZE) {
            if (discovered) {
                graphics.setTooltipForNextFrame(font,
                        List.of(name),
                        Optional.empty(), mouseX, mouseY);
            } else {
                graphics.setTooltipForNextFrame(font,
                        Component.literal("Undiscovered").withStyle(ChatFormatting.GRAY),
                        mouseX, mouseY);
            }
        }
    }

    private void renderEffect_right(GuiGraphicsExtractor graphics, Font font,
                                    int bookX, int y, int mouseX, int mouseY,
                                    boolean discovered, String effectTexture,
                                    Component name, Component[] desc,
                                    String unknownTexture) {
        Identifier icon = Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                discovered ? effectTexture : unknownTexture);

        graphics.blit(RenderPipelines.GUI_TEXTURED, icon,
                bookX + ICON_X_right, y, 0, 0, ICON_SIZE, ICON_SIZE, ICON_SIZE, ICON_SIZE);

        if (discovered) {
            for (int i = 0; i < desc.length; i++) {
                graphics.text(font, desc[i], bookX + TEXT_X_right, y + 4 + (i * 9), 0xFF888888, false);
            }
        } else {
            graphics.text(font, "Undiscovered", bookX + TEXT_X_right, y + 4, 0xFF888888, false);
        }

        if (mouseX >= bookX + ICON_X_right && mouseX <= bookX + ICON_X_right + ICON_SIZE
                && mouseY >= y && mouseY <= y + ICON_SIZE) {
            if (discovered) {
                graphics.setTooltipForNextFrame(font,
                        List.of(name),
                        Optional.empty(), mouseX, mouseY);
            } else {
                graphics.setTooltipForNextFrame(font,
                        Component.literal("Undiscovered").withStyle(ChatFormatting.GRAY),
                        mouseX, mouseY);
            }
        }
    }
}
