package net.more.apples.item;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.more.apples.MoreThanApples;
import net.more.apples.block.ModBlocks2;

public class ModItemGroups {
//    public static final ResourceKey<CreativeModeTab> DIAMOND_APPLE_TAB_KEY = ResourceKey.create(
//            Registries.CREATIVE_MODE_TAB,
//            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "diamond_apple_tab")
//    );

    public static final CreativeModeTab DIAMOND_APPLE_ICON = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "diamond_apple_icon"),
            FabricCreativeModeTab.builder().icon(() -> new net.minecraft.world.item.ItemStack(ModItems.DIAMOND_APPLE))
                    .title(Component.translatable("itemgroup.more-than-apples.diamond_apple_icon"))
                    .displayItems(((displayContext, entries) -> {
                        entries.accept(ModItems.DIAMOND_NUGGET);
                        entries.accept(ModItems.GREEN_APPLE);
                        entries.accept(ModItems.TEST_APPLE);
                        entries.accept(ModItems.DIAMOND_APPLE);
                        entries.accept(ModItems.ENCHANTED_DIAMOND_APPLE);
                        entries.accept(ModItems.DIAMOND_CARROT);

                        entries.accept(ModItems.NETHERITE_APPLE);
                        entries.accept(ModItems.ENCHANTED_NETHERITE_APPLE);

                        entries.accept(ModBlocks2.APPLE_ORE);
                        entries.accept(ModBlocks2.DEEPSLATE_APPLE_ORE);

                        entries.accept(ModBlocks2.APPLE_LOG);
                        entries.accept(ModBlocks2.APPLE_WOOD);
                        entries.accept(ModBlocks2.STRIPPED_APPLE_LOG);
                        entries.accept(ModBlocks2.STRIPPED_APPLE_WOOD);
                        entries.accept(ModBlocks2.APPLE_PLANKS);

                        entries.accept(ModBlocks2.APPLE_STAIRS);
                        entries.accept(ModBlocks2.APPLE_SLAB);
                        entries.accept(ModBlocks2.APPLE_FENCE);
                        entries.accept(ModBlocks2.APPLE_FENCE_GATE);
                        entries.accept(ModBlocks2.APPLE_DOOR);
                        entries.accept(ModBlocks2.APPLE_TRAPDOOR);
                        entries.accept(ModBlocks2.APPLE_PRESSURE_PLATE);
                        entries.accept(ModBlocks2.APPLE_BUTTON);
                        //entries.accept(ModBlocks2.APPLE_WALL);
                        entries.accept(ModItems.APPLE_SIGN);
                        entries.accept(ModItems.APPLE_HANGING_SIGN);
                        entries.accept(ModItems.APPLE_BOAT);
                        entries.accept(ModItems.APPLE_CHEST_BOAT);

                        entries.accept(ModBlocks2.APPLE_LEAVES);
                        entries.accept(ModBlocks2.FRUIT_APPLE_LEAVES);
                        entries.accept(ModBlocks2.APPLE_SAPLING);

                        entries.accept(ModBlocks2.GOLDEN_APPLE_LEAVES);
                        entries.accept(ModBlocks2.FRUIT_GOLDEN_APPLE_LEAVES);
                        entries.accept(ModBlocks2.GOLDEN_APPLE_SAPLING);


                        entries.accept(ModBlocks2.TEST_APPLE_LOG);
                        entries.accept(ModBlocks2.TEST_APPLE_WOOD);
                        entries.accept(ModBlocks2.STRIPPED_TEST_APPLE_LOG);
                        entries.accept(ModBlocks2.STRIPPED_TEST_APPLE_WOOD);
                        entries.accept(ModBlocks2.TEST_APPLE_PLANKS);

                        entries.accept(ModBlocks2.TEST_APPLE_STAIRS);
                        entries.accept(ModBlocks2.TEST_APPLE_SLAB);
                        entries.accept(ModBlocks2.TEST_APPLE_FENCE);
                        entries.accept(ModBlocks2.TEST_APPLE_FENCE_GATE);
                        entries.accept(ModBlocks2.TEST_APPLE_DOOR);
                        entries.accept(ModBlocks2.TEST_APPLE_TRAPDOOR);
                        entries.accept(ModBlocks2.TEST_APPLE_PRESSURE_PLATE);
                        entries.accept(ModBlocks2.TEST_APPLE_BUTTON);
                        entries.accept(ModItems.TEST_APPLE_SIGN);
                        entries.accept(ModItems.TEST_APPLE_HANGING_SIGN);
                        entries.accept(ModItems.TEST_APPLE_BOAT);
                        entries.accept(ModItems.TEST_APPLE_CHEST_BOAT);

                        entries.accept(ModBlocks2.TEST_APPLE_LEAVES);
                        entries.accept(ModBlocks2.TEST_APPLE_SAPLING);

                        entries.accept(ModBlocks2.FROSTY_APPLE_LOG);
                        entries.accept(ModBlocks2.FROSTY_APPLE_WOOD);
                        entries.accept(ModBlocks2.STRIPPED_FROSTY_APPLE_LOG);
                        entries.accept(ModBlocks2.STRIPPED_FROSTY_APPLE_WOOD);
                        entries.accept(ModBlocks2.FROSTY_APPLE_PLANKS);

                        entries.accept(ModBlocks2.FROSTY_APPLE_STAIRS);
                        entries.accept(ModBlocks2.FROSTY_APPLE_SLAB);
                        entries.accept(ModBlocks2.FROSTY_APPLE_FENCE);
                        entries.accept(ModBlocks2.FROSTY_APPLE_FENCE_GATE);
                        entries.accept(ModBlocks2.FROSTY_APPLE_DOOR);
                        entries.accept(ModBlocks2.FROSTY_APPLE_TRAPDOOR);
                        entries.accept(ModBlocks2.FROSTY_APPLE_PRESSURE_PLATE);
                        entries.accept(ModBlocks2.FROSTY_APPLE_BUTTON);
                        entries.accept(ModItems.FROSTY_APPLE_SIGN);
                        entries.accept(ModItems.FROSTY_APPLE_HANGING_SIGN);
                        entries.accept(ModItems.FROSTY_APPLE_BOAT);
                        entries.accept(ModItems.FROSTY_APPLE_CHEST_BOAT);

                        entries.accept(ModBlocks2.FROSTY_APPLE_LEAVES);
                        entries.accept(ModBlocks2.FROSTY_APPLE_SAPLING);

                        entries.accept(ModBlocks2.APPLE_BARREL);


                    }))
                    .build());

    public static void registerItemGroups() {
        MoreThanApples.LOGGER.info("Registering Item Groups for " + MoreThanApples.MOD_ID);
    }
}
