package net.more.apples.item;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.more.apples.MoreThanApples;
import net.more.apples.block.general_block.ModGeneralBlock;
import net.more.apples.block.ore_block.ModBlockOre;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import net.more.apples.item.apple_wood_item.AppleWoodItem;
import net.more.apples.item.apple_wood_item.FrostyAppleWoodItem;
import net.more.apples.item.apple_wood_item.TestAppleWoodItem;
import net.more.apples.item.general_item.ModGeneralItems;

public class ModItemGroups {

    public static final CreativeModeTab DIAMOND_APPLE_ICON = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "diamond_apple_icon"),
            FabricCreativeModeTab.builder().icon(() -> new net.minecraft.world.item.ItemStack(ModAppleFoodItems.DIAMOND_APPLE))
                    .title(Component.translatable("itemgroup.more-than-apples.diamond_apple_icon"))
                    .displayItems(((displayContext, entries) -> {
                        entries.accept(ModGeneralItems.DIAMOND_NUGGET);
                        entries.accept(ModAppleFoodItems.GREEN_APPLE);
                        entries.accept(ModAppleFoodItems.TEST_APPLE);
                        entries.accept(ModAppleFoodItems.DIAMOND_APPLE);
                        entries.accept(ModAppleFoodItems.ENCHANTED_DIAMOND_APPLE);
                        entries.accept(ModAppleFoodItems.DIAMOND_CARROT);

                        entries.accept(ModAppleFoodItems.NETHERITE_APPLE);
                        entries.accept(ModAppleFoodItems.ENCHANTED_NETHERITE_APPLE);

                        entries.accept(ModBlockOre.APPLE_ORE);
                        entries.accept(ModBlockOre.DEEPSLATE_APPLE_ORE);

                        entries.accept(AppleWoodBlocks.APPLE_LOG);
                        entries.accept(AppleWoodBlocks.APPLE_WOOD);
                        entries.accept(AppleWoodBlocks.STRIPPED_APPLE_LOG);
                        entries.accept(AppleWoodBlocks.STRIPPED_APPLE_WOOD);
                        entries.accept(AppleWoodBlocks.APPLE_PLANKS);

                        entries.accept(AppleWoodVariants.APPLE_STAIRS);
                        entries.accept(AppleWoodVariants.APPLE_SLAB);
                        entries.accept(AppleWoodVariants.APPLE_FENCE);
                        entries.accept(AppleWoodVariants.APPLE_FENCE_GATE);
                        entries.accept(AppleWoodVariants.APPLE_DOOR);
                        entries.accept(AppleWoodVariants.APPLE_TRAPDOOR);
                        entries.accept(AppleWoodVariants.APPLE_PRESSURE_PLATE);
                        entries.accept(AppleWoodVariants.APPLE_BUTTON);
                        //entries.accept(AppleWoodVariants.APPLE_WALL);
                        entries.accept(AppleWoodVariants.APPLE_SHELF);
                        entries.accept(AppleWoodItem.APPLE_SIGN);
                        entries.accept(AppleWoodItem.APPLE_HANGING_SIGN);
                        entries.accept(AppleWoodItem.APPLE_BOAT);
                        entries.accept(AppleWoodItem.APPLE_CHEST_BOAT);

                        entries.accept(AppleWoodBlocks.APPLE_LEAVES);
                        entries.accept(AppleWoodBlocks.FRUIT_APPLE_LEAVES);
                        entries.accept(AppleWoodBlocks.APPLE_SAPLING);

                        entries.accept(AppleWoodBlocks.GOLDEN_APPLE_LEAVES);
                        entries.accept(AppleWoodBlocks.FRUIT_GOLDEN_APPLE_LEAVES);
                        entries.accept(AppleWoodBlocks.GOLDEN_APPLE_SAPLING);


                        entries.accept(TestAppleWoodBlocks.TEST_APPLE_LOG);
                        entries.accept(TestAppleWoodBlocks.TEST_APPLE_WOOD);
                        entries.accept(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG);
                        entries.accept(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD);
                        entries.accept(TestAppleWoodBlocks.TEST_APPLE_PLANKS);

                        entries.accept(TestAppleWoodVariants.TEST_APPLE_STAIRS);
                        entries.accept(TestAppleWoodVariants.TEST_APPLE_SLAB);
                        entries.accept(TestAppleWoodVariants.TEST_APPLE_FENCE);
                        entries.accept(TestAppleWoodVariants.TEST_APPLE_FENCE_GATE);
                        entries.accept(TestAppleWoodVariants.TEST_APPLE_DOOR);
                        entries.accept(TestAppleWoodVariants.TEST_APPLE_TRAPDOOR);
                        entries.accept(TestAppleWoodVariants.TEST_APPLE_PRESSURE_PLATE);
                        entries.accept(TestAppleWoodVariants.TEST_APPLE_BUTTON);
                        entries.accept(TestAppleWoodVariants.TEST_APPLE_SHELF);
                        entries.accept(TestAppleWoodItem.TEST_APPLE_SIGN);
                        entries.accept(TestAppleWoodItem.TEST_APPLE_HANGING_SIGN);
                        entries.accept(TestAppleWoodItem.TEST_APPLE_BOAT);
                        entries.accept(TestAppleWoodItem.TEST_APPLE_CHEST_BOAT);

                        entries.accept(TestAppleWoodBlocks.TEST_APPLE_LEAVES);
                        entries.accept(TestAppleWoodBlocks.TEST_APPLE_SAPLING);

                        entries.accept(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG);
                        entries.accept(FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD);
                        entries.accept(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG);
                        entries.accept(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD);
                        entries.accept(FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS);

                        entries.accept(FrostyAppleWoodVariants.FROSTY_APPLE_STAIRS);
                        entries.accept(FrostyAppleWoodVariants.FROSTY_APPLE_SLAB);
                        entries.accept(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE);
                        entries.accept(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE);
                        entries.accept(FrostyAppleWoodVariants.FROSTY_APPLE_DOOR);
                        entries.accept(FrostyAppleWoodVariants.FROSTY_APPLE_TRAPDOOR);
                        entries.accept(FrostyAppleWoodVariants.FROSTY_APPLE_PRESSURE_PLATE);
                        entries.accept(FrostyAppleWoodVariants.FROSTY_APPLE_BUTTON);
                        entries.accept(FrostyAppleWoodVariants.FROSTY_APPLE_SHELF);
                        entries.accept(FrostyAppleWoodItem.FROSTY_APPLE_SIGN);
                        entries.accept(FrostyAppleWoodItem.FROSTY_APPLE_HANGING_SIGN);
                        entries.accept(FrostyAppleWoodItem.FROSTY_APPLE_BOAT);
                        entries.accept(FrostyAppleWoodItem.FROSTY_APPLE_CHEST_BOAT);

                        entries.accept(FrostyAppleWoodBlocks.FROSTY_APPLE_LEAVES);
                        entries.accept(FrostyAppleWoodBlocks.FROSTY_APPLE_SAPLING);

                        entries.accept(ModGeneralBlock.APPLE_BARREL);


                    }))
                    .build());

    public static void registerItemGroups() {
        MoreThanApples.LOGGER.info("Registering Item Groups for " + MoreThanApples.MOD_ID);
    }
}
