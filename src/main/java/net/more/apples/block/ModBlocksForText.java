package net.more.apples.block;

import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.more.apples.MoreThanApples;

import java.util.function.Function;


public class ModBlocksForText {
    public static final Block WOD1_LOG = registerBlock("wod1_log",
            properties -> new PillarBlock(properties
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD)
                    .burnable()));

    public static final Block BOX_FOR_TT11 = registerBlock("box_for_tt11",
            properties -> new UntintedParticleLeavesBlock(0.02f , ParticleTypes.CHERRY_LEAVES, properties
                    .mapColor(MapColor.DARK_GREEN).strength(0.2F).ticksRandomly()
                    .sounds(BlockSoundGroup.AZALEA_LEAVES).nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never)
                    .blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));

    public static final Block THE_BLOCK1 = registerBlock("the_block1",
            properties -> new Block(properties.strength(3f)
                    .requiresTool()));

//    public static final Block CUSTOM_SIGN = registerBlock("custom_sign",
//            new SignBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)));
//
//    public static final Block CUSTOM_WALL_SIGN = registerBlock("custom_wall_sign",
//            new WallSignBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)));

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(MoreThanApples.MOD_ID, name), toRegister);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(MoreThanApples.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, name)))));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MoreThanApples.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, name)))));
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
