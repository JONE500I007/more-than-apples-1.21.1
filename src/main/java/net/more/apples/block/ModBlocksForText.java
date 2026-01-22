package net.more.apples.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.more.apples.MoreThanApples;
import net.more.apples.block.custom.ModWoodTypes;
import net.more.apples.world.tree.ModSaplingGenerators;

public class ModBlocksForText {

    public static final Block FRUIT_APPLE_LEAVES_TEST = registerBlock("fruit_apple_leaves_test",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "fruit_apple_leaves_test")))));

//    public static final Block CUSTOM_SIGN = registerBlock("custom_sign",
//            new SignBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)));
//
//    public static final Block CUSTOM_WALL_SIGN = registerBlock("custom_wall_sign",
//            new WallSignBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MoreThanApples.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MoreThanApples.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks2() {
        MoreThanApples.LOGGER.info("Registering Mod Blocks " + MoreThanApples.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entrise -> {

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entrise -> {

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entrise -> {

        });
    }
}
