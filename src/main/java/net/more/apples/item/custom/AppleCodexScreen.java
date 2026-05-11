package net.more.apples.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.more.apples.MoreThanApples;
import net.more.apples.item.custom.codex_page.BookmarkButton;
import net.more.apples.item.custom.codex_page.CodexPage;
import net.more.apples.item.custom.codex_page.Page0ApplePage;
import net.more.apples.item.custom.codex_page.Page1ApplePage;
import net.more.apples.util.discovery.DiscoveryHelper2;
import org.lwjgl.glfw.GLFW;

import java.util.List;
import java.util.Optional;

public class AppleCodexScreen extends Screen {
    private int currentPage = 0;
    private final int MAX_PAGE = 10;
    private BookTextureButton btnLeft;
    private BookTextureButton btnRight;

    private static final Identifier BTN_RIGHT = Identifier.fromNamespaceAndPath(
            MoreThanApples.MOD_ID, "textures/gui/book_button_right.png");
    private static final Identifier BTN_LEFT = Identifier.fromNamespaceAndPath(
            MoreThanApples.MOD_ID, "textures/gui/book_button_left.png");

    private static final Identifier BTN_RIGHT_HOVER = Identifier.fromNamespaceAndPath(
            MoreThanApples.MOD_ID, "textures/gui/book_button_right_hover.png");
    private static final Identifier BTN_LEFT_HOVER = Identifier.fromNamespaceAndPath(
            MoreThanApples.MOD_ID, "textures/gui/book_button_left_hover.png");

    private static final Identifier BM_APPLE = Identifier.fromNamespaceAndPath(
            MoreThanApples.MOD_ID, "textures/gui/icon_book/bookmark_apple.png");
    private static final Identifier BM_APPLE_HOVER = Identifier.fromNamespaceAndPath(
            MoreThanApples.MOD_ID, "textures/gui/icon_book/bookmark_apple_hover.png");

    private static final Identifier BM_BIOME = Identifier.fromNamespaceAndPath(
            MoreThanApples.MOD_ID, "textures/gui/icon_book/bookmark_biome.png");
    private static final Identifier BM_BIOME_HOVER = Identifier.fromNamespaceAndPath(
            MoreThanApples.MOD_ID, "textures/gui/icon_book/bookmark_biome_hover.png");


    private static final Identifier BOOK_TEXTURE = Identifier.fromNamespaceAndPath(
            MoreThanApples.MOD_ID, "textures/gui/apple_codex_book.png");

    private static final int BOOK_WIDTH = 272;
    //private static final int BOOK_HEIGHT = 180;
    private static final int BOOK_HEIGHT = 199;
    private static final int TEXTURE_WIDTH = 512;
    private static final int TEXTURE_HEIGHT = 256;

    private int bookX, bookY;

    private static final List<CodexPage> PAGES = List.of(
            new Page0ApplePage(),
            new Page1ApplePage());

    protected AppleCodexScreen(Component title) {
        super(title);
    }

    @Override
    protected void init() {
        super.init();

        bookX = (this.width - BOOK_WIDTH) / 2;
        bookY = (this.height - BOOK_HEIGHT) / 2 + 5;

        // Close Button
        this.addRenderableWidget(
                Button.builder(Component.literal("Close"), button -> this.onClose())
                        .bounds(bookX + BOOK_WIDTH / 2 - 40, bookY + BOOK_HEIGHT + 5, 80, 20)
                        .build());

        // Next Page
        btnRight = new BookTextureButton(
                bookX + BOOK_WIDTH - 20, bookY + BOOK_HEIGHT / 2 - 10,
                15, 21, BTN_RIGHT, BTN_RIGHT_HOVER,
                () -> { if (currentPage < MAX_PAGE) currentPage++; }
        );
        this.addRenderableWidget(btnRight);
        /*
        this.addRenderableWidget(new BookTextureButton(
                bookX + BOOK_WIDTH - 20, bookY + BOOK_HEIGHT / 2 - 10,
                15, 21,
                BTN_RIGHT, BTN_RIGHT_HOVER,
                () -> { if (currentPage < MAX_PAGE) currentPage++; }
        ));
         */
        /*
        this.addRenderableWidget(
                Button.builder(Component.literal(">"), button -> {
                            if (currentPage < MAX_PAGE) currentPage++;
                        }).bounds(bookX + BOOK_WIDTH - 20, bookY + BOOK_HEIGHT / 2 - 10, 20, 20)
                        .build());
         */

        // Previous Page
        btnLeft = new BookTextureButton(
                bookX, bookY + BOOK_HEIGHT / 2 - 10,
                15, 21, BTN_LEFT, BTN_LEFT_HOVER,
                () -> { if (currentPage > 0) currentPage--; }
        );
        this.addRenderableWidget(btnLeft);
        /*
        this.addRenderableWidget(
                Button.builder(Component.literal("<"), button -> {
                            if (currentPage > 0) currentPage--;
                        }).bounds(bookX, bookY + BOOK_HEIGHT / 2 - 10, 20, 20)
                        .build());
         */
        // Bookmark ขอบขวา (x = bookX + BOOK_WIDTH - 8 ให้มันยื่นออกมา)
        int bmX = bookX + BOOK_WIDTH - 8;

        this.addRenderableWidget(new BookmarkButton(
                bmX, bookY + 20,       // Apple bookmark ด้านบน
                BM_APPLE, BM_APPLE_HOVER,
                () -> currentPage = 0
        ));

        this.addRenderableWidget(new BookmarkButton(
                bmX, bookY + 40,       // Biome bookmark ถัดลงมา
                BM_BIOME, BM_BIOME_HOVER,
                () -> currentPage = 6
        ));
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
        // BG black
        graphics.fill(0, 0, this.width, this.height, 0xAA000000);

        // Book Texture
        graphics.blit(
                RenderPipelines.GUI_TEXTURED,
                BOOK_TEXTURE,
                bookX, bookY,
                0, 0,
                BOOK_WIDTH,
                BOOK_HEIGHT,
                TEXTURE_WIDTH,
                TEXTURE_HEIGHT
        );

        // page number
        int leftPage = currentPage * 2 + 1;
        int rightPage = currentPage * 2 + 2;

        // Adjust the numbers below to move the position
        int offsetX = 17; // Increase = Move right, Decrease = Move left
        int offsetY = 11; // Increase = move down, Decrease = move up

        // left front number
        graphics.text(this.font, String.valueOf(leftPage),
                bookX + offsetX, bookY + offsetY, 0xFF000000, false);

        // Right page number (automatic right alignment, adjust offsetX to move in/out of the edge)
        graphics.text(this.font, String.valueOf(rightPage),
                bookX + BOOK_WIDTH - offsetX - this.font.width(String.valueOf(rightPage)),
                bookY + offsetY, 0xFF000000, false);

        // Content
        /*
        if (currentPage == 0) {
            graphics.text(this.font, "Hello Applepedia!",
                    bookX + 20, bookY + 20, 0x3B2A1A);

            boolean apple = DiscoveryHelper2.hasDiscovered("discover_items/discover_apple");

            if (apple) {
                graphics.item(new ItemStack(Items.APPLE), bookX + 40, bookY + 40);
            } else {
                graphics.blit(RenderPipelines.GUI_TEXTURED,
                        Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "textures/gui/items/unknown_apple.png"),
                        bookX + 40, bookY + 40, 0, 0, 16, 16, 16, 16);
            }

            if (mouseX >= bookX + 40 && mouseX <= bookX + 56
                    && mouseY >= bookY + 40 && mouseY <= bookY + 56) {
                if (apple) {
                    graphics.setTooltipForNextFrame(this.font,
                            List.of(Component.literal("Apple"), Component.literal("This apple")),
                            Optional.empty(), mouseX, mouseY);
                } else {
                    graphics.setTooltipForNextFrame(this.font,
                            Component.literal("Undiscovered"), mouseX, mouseY);
                }
            }
        }

        if (currentPage == 1) {
            graphics.text(this.font, "Second Page",
                    bookX + 20, bookY + 20, 0x3B2A1A);
            graphics.item(new ItemStack(Items.DIAMOND), bookX + 40, bookY + 40);
        }
         */

        btnLeft.visible = currentPage > 0;
        btnRight.visible = currentPage < MAX_PAGE;

        if (currentPage < PAGES.size()) {
            PAGES.get(currentPage).render(graphics, this.font, bookX, bookY, mouseX, mouseY);
        }

        super.extractRenderState(graphics, mouseX, mouseY, delta);
    }



    @Override
    public boolean keyPressed(KeyEvent event) {
        if (event.key() == GLFW.GLFW_KEY_E) {
            this.onClose();
            return true;
        }
        return super.keyPressed(event);
    }

    //    @Override
//    public boolean mouseClicked(MouseButtonEvent event, boolean doubleClick) {
//        if (event.button() == 1) {
//            this.onClose();
//            return true;
//        }
//        return super.mouseClicked(event, doubleClick);
//    }
}
