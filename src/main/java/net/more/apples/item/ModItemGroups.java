package net.more.apples.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.block.ModBlocks2;

public class ModItemGroups {

    public static final ItemGroup DIAMOND_APPLE_ICON = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MoreThanApples.MOD_ID, "diamond_apple_icon"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.DIAMOND_APPLE))
                    .displayName(Text.translatable("itemgroup.more-than-apples.diamond_apple_icon"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.DIAMOND_NUGGET);
                        entries.add(ModItems.GREEN_APPLE);
                        entries.add(ModItems.TEST_APPLE);
                        entries.add(ModItems.DIAMOND_APPLE);
                        entries.add(ModItems.ENCHANTED_DIAMOND_APPLE);
                        entries.add(ModItems.DIAMOND_CARROT);

                        entries.add(ModItems.NETHERITE_APPLE);
                        entries.add(ModItems.ENCHANTED_NETHERITE_APPLE);

                        entries.add(ModBlocks2.APPLE_ORE);
                        entries.add(ModBlocks2.DEEPSLATE_APPLE_ORE);

                        entries.add(ModBlocks2.APPLE_LOG);
                        entries.add(ModBlocks2.APPLE_WOOD);
                        entries.add(ModBlocks2.STRIPPED_APPLE_LOG);
                        entries.add(ModBlocks2.STRIPPED_APPLE_WOOD);
                        entries.add(ModBlocks2.APPLE_PLANKS);

                        entries.add(ModBlocks2.APPLE_STAIRS);
                        entries.add(ModBlocks2.APPLE_SLAB);
                        entries.add(ModBlocks2.APPLE_FENCE);
                        entries.add(ModBlocks2.APPLE_FENCE_GATE);
                        entries.add(ModBlocks2.APPLE_DOOR);
                        entries.add(ModBlocks2.APPLE_TRAPDOOR);
                        entries.add(ModBlocks2.APPLE_PRESSURE_PLATE);
                        entries.add(ModBlocks2.APPLE_BUTTON);
//                        entries.add(ModBlocks2.APPLE_WALL);
                        entries.add(ModItems.APPLE_SIGN);
                        entries.add(ModItems.APPLE_HANGING_SIGN);
                        entries.add(ModItems.APPLE_BOAT);
                        entries.add(ModItems.APPLE_CHEST_BOAT);

                        entries.add(ModBlocks2.APPLE_LEAVES);
                        entries.add(ModBlocks2.FRUIT_APPLE_LEAVES);
                        entries.add(ModBlocks2.APPLE_SAPLING);

                        entries.add(ModBlocks2.GOLDEN_APPLE_LEAVES);
                        entries.add(ModBlocks2.FRUIT_GOLDEN_APPLE_LEAVES);
                        entries.add(ModBlocks2.GOLDEN_APPLE_SAPLING);


                        entries.add(ModBlocks2.TEST_APPLE_LOG);
                        entries.add(ModBlocks2.TEST_APPLE_WOOD);
                        entries.add(ModBlocks2.STRIPPED_TEST_APPLE_LOG);
                        entries.add(ModBlocks2.STRIPPED_TEST_APPLE_WOOD);
                        entries.add(ModBlocks2.TEST_APPLE_PLANKS);

                        entries.add(ModBlocks2.TEST_APPLE_STAIRS);
                        entries.add(ModBlocks2.TEST_APPLE_SLAB);
                        entries.add(ModBlocks2.TEST_APPLE_FENCE);
                        entries.add(ModBlocks2.TEST_APPLE_FENCE_GATE);
                        entries.add(ModBlocks2.TEST_APPLE_DOOR);
                        entries.add(ModBlocks2.TEST_APPLE_TRAPDOOR);
                        entries.add(ModBlocks2.TEST_APPLE_PRESSURE_PLATE);
                        entries.add(ModBlocks2.TEST_APPLE_BUTTON);

                        entries.add(ModBlocks2.TEST_APPLE_LEAVES);
                        entries.add(ModBlocks2.TEST_APPLE_SAPLING);

                        entries.add(ModBlocks2.APPLE_BARREL);


                    }))
                    .build());

    public static void registerItemGroups() {
        MoreThanApples.LOGGER.info("Registering Item Groups for " + MoreThanApples.MOD_ID);
    }
}
