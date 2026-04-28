package net.more.apples.block.wood_type.apple_wood;

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

public class AppleWoodVariants {

    public static final Block APPLE_STAIRS = registerBlock("apple_stairs",
            properties -> new StairBlock(AppleWoodBlocks.APPLE_PLANKS.defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final Block APPLE_SLAB = registerBlock("apple_slab",
            properties -> new SlabBlock(BlockBehaviour.Properties.of()
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));


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

    public static void registerAppleWoodVariant() {
        MoreThanApples.LOGGER.info("Registering Mod Blocks " + MoreThanApples.MOD_ID);
    }
}
