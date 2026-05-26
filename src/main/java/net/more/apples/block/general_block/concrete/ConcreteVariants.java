package net.more.apples.block.general_block.concrete;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.more.apples.MoreThanApples;

import java.util.function.Function;

public class ConcreteVariants {
    // White
    public static final Block WHITE_CONCRETE_STAIRS = registerBlock("white_concrete_stairs",
            properties -> new StairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(),
                    registerIdBlock("white_concrete_stairs", Blocks.WHITE_CONCRETE)));
    public static final Block WHITE_CONCRETE_SLAB = registerBlock("white_concrete_slab",
            properties -> new SlabBlock(registerIdBlock("white_concrete_slab", Blocks.WHITE_CONCRETE)));

    // Light Gray
    public static final Block LIGHT_GRAY_CONCRETE_STAIRS = registerBlock("light_gray_concrete_stairs",
            properties -> new StairBlock(Blocks.LIGHT_GRAY_CONCRETE.defaultBlockState(),
                    registerIdBlock("light_gray_concrete_stairs", Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Block LIGHT_GRAY_CONCRETE_SLAB = registerBlock("light_gray_concrete_slab",
            properties -> new SlabBlock(registerIdBlock("light_gray_concrete_slab", Blocks.LIGHT_GRAY_CONCRETE)));

    // Gray
    public static final Block GRAY_CONCRETE_STAIRS = registerBlock("gray_concrete_stairs",
            properties -> new StairBlock(Blocks.GRAY_CONCRETE.defaultBlockState(),
                    registerIdBlock("gray_concrete_stairs", Blocks.GRAY_CONCRETE)));
    public static final Block GRAY_CONCRETE_SLAB = registerBlock("gray_concrete_slab",
            properties -> new SlabBlock(registerIdBlock("gray_concrete_slab", Blocks.GRAY_CONCRETE)));

    // Black
    public static final Block BLACK_CONCRETE_STAIRS = registerBlock("black_concrete_stairs",
            properties -> new StairBlock(Blocks.BLACK_CONCRETE.defaultBlockState(),
                    registerIdBlock("black_concrete_stairs", Blocks.BLACK_CONCRETE)));
    public static final Block BLACK_CONCRETE_SLAB = registerBlock("black_concrete_slab",
            properties -> new SlabBlock(registerIdBlock("black_concrete_slab", Blocks.BLACK_CONCRETE)));

    // Brown
    public static final Block BROWN_CONCRETE_STAIRS = registerBlock("brown_concrete_stairs",
            properties -> new StairBlock(Blocks.BROWN_CONCRETE.defaultBlockState(),
                    registerIdBlock("brown_concrete_stairs", Blocks.BROWN_CONCRETE)));
    public static final Block BROWN_CONCRETE_SLAB = registerBlock("brown_concrete_slab",
            properties -> new SlabBlock(registerIdBlock("brown_concrete_slab", Blocks.BROWN_CONCRETE)));

    // Red
    public static final Block RED_CONCRETE_STAIRS = registerBlock("red_concrete_stairs",
            properties -> new StairBlock(Blocks.RED_CONCRETE.defaultBlockState(),
                    registerIdBlock("red_concrete_stairs", Blocks.RED_CONCRETE)));
    public static final Block RED_CONCRETE_SLAB = registerBlock("red_concrete_slab",
            properties -> new SlabBlock(registerIdBlock("red_concrete_slab", Blocks.RED_CONCRETE)));

    // Orange
    public static final Block ORANGE_CONCRETE_STAIRS = registerBlock("orange_concrete_stairs",
            properties -> new StairBlock(Blocks.ORANGE_CONCRETE.defaultBlockState(),
                    registerIdBlock("orange_concrete_stairs", Blocks.ORANGE_CONCRETE)));
    public static final Block ORANGE_CONCRETE_SLAB = registerBlock("orange_concrete_slab",
            properties -> new SlabBlock(registerIdBlock("orange_concrete_slab", Blocks.ORANGE_CONCRETE)));

    // Yellow
    public static final Block YELLOW_CONCRETE_STAIRS = registerBlock("yellow_concrete_stairs",
            properties -> new StairBlock(Blocks.YELLOW_CONCRETE.defaultBlockState(),
                    registerIdBlock("yellow_concrete_stairs", Blocks.YELLOW_CONCRETE)));
    public static final Block YELLOW_CONCRETE_SLAB = registerBlock("yellow_concrete_slab",
            properties -> new SlabBlock(registerIdBlock("yellow_concrete_slab", Blocks.YELLOW_CONCRETE)));

    // Lime
    public static final Block LIME_CONCRETE_STAIRS = registerBlock("lime_concrete_stairs",
            properties -> new StairBlock(Blocks.LIME_CONCRETE.defaultBlockState(),
                    registerIdBlock("lime_concrete_stairs", Blocks.LIME_CONCRETE)));
    public static final Block LIME_CONCRETE_SLAB = registerBlock("lime_concrete_slab",
            properties -> new SlabBlock(registerIdBlock("lime_concrete_slab", Blocks.LIME_CONCRETE)));

    // Green
    public static final Block GREEN_CONCRETE_STAIRS = registerBlock("green_concrete_stairs",
            properties -> new StairBlock(Blocks.GREEN_CONCRETE.defaultBlockState(),
                    registerIdBlock("green_concrete_stairs", Blocks.GREEN_CONCRETE)));
    public static final Block GREEN_CONCRETE_SLAB = registerBlock("green_concrete_slab",
            properties -> new SlabBlock(registerIdBlock("green_concrete_slab", Blocks.GREEN_CONCRETE)));

    // Cyan
    public static final Block CYAN_CONCRETE_STAIRS = registerBlock("cyan_concrete_stairs",
            properties -> new StairBlock(Blocks.CYAN_CONCRETE.defaultBlockState(),
                    registerIdBlock("cyan_concrete_stairs", Blocks.CYAN_CONCRETE)));
    public static final Block CYAN_CONCRETE_SLAB = registerBlock("cyan_concrete_slab",
            properties -> new SlabBlock(registerIdBlock("cyan_concrete_slab", Blocks.CYAN_CONCRETE)));

    // Light Blue
    public static final Block LIGHT_BLUE_CONCRETE_STAIRS = registerBlock("light_blue_concrete_stairs",
            properties -> new StairBlock(Blocks.LIGHT_BLUE_CONCRETE.defaultBlockState(),
                    registerIdBlock("light_blue_concrete_stairs", Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Block LIGHT_BLUE_CONCRETE_SLAB = registerBlock("light_blue_concrete_slab",
            properties -> new SlabBlock(registerIdBlock("light_blue_concrete_slab", Blocks.LIGHT_BLUE_CONCRETE)));

    // Blue
    public static final Block BLUE_CONCRETE_STAIRS = registerBlock("blue_concrete_stairs",
            properties -> new StairBlock(Blocks.BLUE_CONCRETE.defaultBlockState(),
                    registerIdBlock("blue_concrete_stairs", Blocks.BLUE_CONCRETE)));
    public static final Block BLUE_CONCRETE_SLAB = registerBlock("blue_concrete_slab",
            properties -> new SlabBlock(registerIdBlock("blue_concrete_slab", Blocks.BLUE_CONCRETE)));

    // Purple
    public static final Block PURPLE_CONCRETE_STAIRS = registerBlock("purple_concrete_stairs",
            properties -> new StairBlock(Blocks.PURPLE_CONCRETE.defaultBlockState(),
                    registerIdBlock("purple_concrete_stairs", Blocks.PURPLE_CONCRETE)));
    public static final Block PURPLE_CONCRETE_SLAB = registerBlock("purple_concrete_slab",
            properties -> new SlabBlock(registerIdBlock("purple_concrete_slab", Blocks.PURPLE_CONCRETE)));

    // Magenta
    public static final Block MAGENTA_CONCRETE_STAIRS = registerBlock("magenta_concrete_stairs",
            properties -> new StairBlock(Blocks.MAGENTA_CONCRETE.defaultBlockState(),
                    registerIdBlock("magenta_concrete_stairs", Blocks.MAGENTA_CONCRETE)));
    public static final Block MAGENTA_CONCRETE_SLAB = registerBlock("magenta_concrete_slab",
            properties -> new SlabBlock(registerIdBlock("magenta_concrete_slab", Blocks.MAGENTA_CONCRETE)));

    // Pink
    public static final Block PINK_CONCRETE_STAIRS = registerBlock("pink_concrete_stairs",
            properties -> new StairBlock(Blocks.PINK_CONCRETE.defaultBlockState(),
                    registerIdBlock("pink_concrete_stairs", Blocks.PINK_CONCRETE)));
    public static final Block PINK_CONCRETE_SLAB = registerBlock("pink_concrete_slab",
            properties -> new SlabBlock(registerIdBlock("pink_concrete_slab", Blocks.PINK_CONCRETE)));


    private static BlockBehaviour.Properties registerIdBlock(String name, Block base) {
        ResourceKey<Block> key = ResourceKey.create(
                Registries.BLOCK,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));

        return BlockBehaviour.Properties.ofFullCopy(base).setId(key);
    }

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name)));

        Block toRegister = function.apply(properties);
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name), toRegister);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<BlockBehaviour.Properties, Block> function) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name)));

        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name),
                function.apply(properties));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name)))));
    }

    public static void registerConcreteBlock() {
        MoreThanApples.LOGGER.info("Registering Mod Blocks " + MoreThanApples.MOD_ID);
    }
}
