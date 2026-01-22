package net.more.apples.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.item.ModFoodComponents;

public class ModBlocks {

    public static final Block DIAMOND_APPLE_BLOCK = registerBlock("diamond_apple_block",
            new Block(AbstractBlock.Settings.create().strength(2f)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "diamond_apple_block")))
                    .sounds(BlockSoundGroup.METAL)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MoreThanApples.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MoreThanApples.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, name)))
                        .food(ModFoodComponents.DIAMOND_CARROT_FOOD ,ModFoodComponents.DIAMOND_APPLE_EFFECT)));
    }

    public static void registerModBlocks() {
        MoreThanApples.LOGGER.info("Registering Mod Blocks " + MoreThanApples.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entrise -> {
            //entrise.add(DIAMOND_APPLE_BLOCK);
        });
    }
}
