package net.more.apples.item.custom;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.more.apples.MoreThanApples;
import net.more.apples.util.discovery.DiscoveryHelper;
import net.more.apples.util.discovery.DiscoveryHelper2;

import java.util.List;
import java.util.Optional;

public class GuideBookScreen extends Screen {
    private int currentPage = 0;
    private final int MAX_PAGE = 1;

    public GuideBookScreen() {
        super(Component.literal("Guide Book"));
    }

    @Override
    protected void init() {
        super.init();

        // Close Button
        this.addRenderableWidget(
                Button.builder(
                                Component.literal("Close"),
                                button -> this.onClose())
                        .bounds(
                                this.width / 2 - 40,
                                this.height - 40,
                                80,
                                20)
                        .build());

        // Next Page
        this.addRenderableWidget(
                Button.builder(
                                Component.literal(">"),
                                button -> {
                                    if(currentPage < MAX_PAGE) {
                                        currentPage++;
                                    }
                                })
                        .bounds(
                                this.width - 40,
                                this.height / 2 - 10,
                                20,
                                20)
                        .build());

        // Previous Page
        this.addRenderableWidget(
                Button.builder(
                                Component.literal("<"),
                                button -> {
                                    if(currentPage > 0) {
                                        currentPage--;
                                    }
                                })
                        .bounds(
                                20,
                                this.height / 2 - 10,
                                20,
                                20)
                        .build());
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {

        graphics.fill(
                0,
                0,
                this.width,
                this.height,
                0xAA000000);

        // PAGE 0
        if(currentPage == 0) {

            graphics.text(
                    this.font,
                    "Hello Applepedia!",
                    this.width / 2 - 50,
                    20,
                    0xFFFFFF);

//            boolean discovered =
//                    Minecraft.getInstance().player.getInventory().contains(
//                            new ItemStack(Items.APPLE)
//                    );

//            boolean discovered =
//                    DiscoveryHelper.hasDiscoveredApple();
            boolean apple =
                    DiscoveryHelper2.hasDiscovered(
                            "discover_items/discover_apple");

            // Render Apple
            if(apple) {

                graphics.item(
                        new ItemStack(Items.APPLE),
                        40,
                        40);

            } else {

                graphics.blit(
                        RenderPipelines.GUI_TEXTURED,
                        Identifier.fromNamespaceAndPath(
                                MoreThanApples.MOD_ID,
                                "textures/gui/unknown_apple.png"
                        ),
                        40,
                        40,
                        0,
                        0,
                        16,
                        16,
                        16,
                        16);
            }

            // Hover Tooltip
            if(mouseX >= 40 && mouseX <= 56
                    && mouseY >= 40 && mouseY <= 56) {

                if(apple) {

                    graphics.setTooltipForNextFrame(
                            this.font,
                            List.of(
                                    Component.literal("Apple"),
                                    Component.literal("This apple")),
                            Optional.empty(),
                            mouseX,
                            mouseY);

                } else {

                    graphics.setTooltipForNextFrame(
                            this.font,
                            Component.literal("Undiscovered"),
                            mouseX,
                            mouseY);
                }
            }
        }

        // PAGE 1
        if(currentPage == 1) {

            graphics.text(
                    this.font,
                    "Second Page",
                    this.width / 2 - 40,
                    20,
                    0xFFFFFF);

            graphics.item(
                    new ItemStack(Items.DIAMOND),
                    40,
                    40);
        }

        super.extractRenderState(graphics, mouseX, mouseY, delta);
    }
}
