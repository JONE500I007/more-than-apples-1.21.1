package net.more.apples.block;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.more.apples.MoreThanApples;
import net.more.apples.item.ModFoodComponents;

public class ModBlocks {

    public static final Block DIAMOND_APPLE_BLOCK = registerBlock("diamond_apple_block",
            new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "diamond_apple_block")))
                    .sound(SoundType.METAL)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name),
                new BlockItem(block, new Item.Properties()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name)))
                        .food(ModFoodComponents.DIAMOND_CARROT_FOOD ,ModFoodComponents.DIAMOND_APPLE_EFFECT)));
    }

    public static void registerModBlocks() {
        MoreThanApples.LOGGER.info("Registering Mod Blocks " + MoreThanApples.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(entrise -> {
            //entrise.add(DIAMOND_APPLE_BLOCK);
        });
    }
}
