package net.more.apples.block;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.more.apples.MoreThanApples;
import net.more.apples.block.custom.AppleShelfBlock;

import java.util.function.Function;

public class ModBlocksForText {

    public static final Block WOD1_LOG = registerBlock("wod1_log",
            properties -> new RotatedPillarBlock(properties
                    .strength(2.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()));

    public static final Block BOX_FOR_TT11 = registerBlock("box_for_tt11",
            properties -> new UntintedParticleLeavesBlock(0.02f , ParticleTypes.CHERRY_LEAVES, properties
                    .mapColor(MapColor.TERRACOTTA_GREEN)
                    .strength(0.2F)
                    .randomTicks()
                    .sound(SoundType.AZALEA_LEAVES)
                    .noOcclusion()
                    .isValidSpawn((state, level, pos, type) -> false)
                    .isSuffocating((state, level, pos) -> false)
                    .isViewBlocking((state, level, pos) -> false)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
                    .noTerrainParticles()));

    public static final Block THE_BLOCK1 = registerBlock("the_block1",
            properties -> new Block(properties.strength(3f)
                    .requiresCorrectToolForDrops()));

//    public static final Block TEST_SHELF = registerBlock("test_shelf",
//            properties -> new ShelfBlock(BlockBehaviour.Properties
//                    .ofFullCopy(Blocks.OAK_SHELF)));

//    public static final Block CUSTOM_SIGN = registerBlock("custom_sign",
//            new SignBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)));
//
//    public static final Block CUSTOM_WALL_SIGN = registerBlock("custom_wall_sign",
//            new WallSignBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)));

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

    public static void registerModBlocks2() {
        MoreThanApples.LOGGER.info("Registering Mod Blocks " + MoreThanApples.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(entrise -> {

        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entrise -> {

        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entrise -> {

        });
    }
}
