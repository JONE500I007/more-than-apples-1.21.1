package net.more.apples.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.more.apples.MoreThanApples;
import net.more.apples.world.tree.ModSaplingGenerators;

public class ModBlocks2 {

    public static final Block APPLE_ORE = registerBlock2("apple_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(3.0f, 3.0f)
                    .sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block DEEPSLATE_APPLE_ORE = registerBlock2("deepslate_apple_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4.5f, 3.0f)
                            .sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block THISBOX = registerBlock2("thisbox",
            new Block(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.METAL)));

    public static final Block APPLE_LOG = registerBlock2("apple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    public static final Block APPLE_WOOD = registerBlock2("apple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_APPLE_LOG = registerBlock2("stripped_apple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_APPLE_WOOD = registerBlock2("stripped_apple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block APPLE_PLANKS = registerBlock2("apple_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block APPLE_LEAVES = registerBlock2("apple_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));
    public static final Block FRUIT_APPLE_LEAVES = registerBlock2("fruit_apple_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));
    public static final Block APPLE_SAPLING = registerBlock2("apple_sapling",
            new SaplingBlock(ModSaplingGenerators.APPLE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block APPLE_STAIRS = registerBlock2("apple_stairs",
            new StairsBlock(ModBlocks2.APPLE_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.create()));
    public static final Block APPLE_SLAB = registerBlock2("apple_slab",
            new SlabBlock(AbstractBlock.Settings.create()));

    public static final Block APPLE_BUTTON = registerBlock2("apple_button",
            new ButtonBlock(BlockSetType.OAK, 2,
                    AbstractBlock.Settings.create().noCollision()));
    public static final Block APPLE_PRESSURE_PLATE = registerBlock2("apple_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.create()));

    public static final Block APPLE_FENCE = registerBlock2("apple_fence",
            new FenceBlock(AbstractBlock.Settings.create()));
    public static final Block APPLE_FENCE_GATE = registerBlock2("apple_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.create()));
//    public static final Block APPLE_WALL = registerBlock2("apple_wall",
//            new WallBlock(AbstractBlock.Settings.create()));

    public static final Block APPLE_DOOR = registerBlock2("apple_door",
            new DoorBlock(BlockSetType.OAK ,AbstractBlock.Settings.create().nonOpaque()));
    public static final Block APPLE_TRAPDOOR = registerBlock2("apple_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK ,AbstractBlock.Settings.create().nonOpaque()));

    public static final Block TEST_APPLE_LOG = registerBlock2("test_apple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    public static final Block TEST_APPLE_WOOD = registerBlock2("test_apple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block TEST_STRIPPED_APPLE_LOG = registerBlock2("test_stripped_apple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block TEST_STRIPPED_APPLE_WOOD = registerBlock2("test_stripped_apple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block TEST_APPLE_PLANKS = registerBlock2("test_apple_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block TEST_APPLE_LEAVES = registerBlock2("test_apple_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));
    public static final Block TEST_APPLE_SAPLING = registerBlock2("test_apple_sapling",
            new SaplingBlock(ModSaplingGenerators.TEST_APPLE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block GOLDEN_APPLE_LEAVES = registerBlock2("golden_apple_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));
    public static final Block FRUIT_GOLDEN_APPLE_LEAVES = registerBlock2("fruit_golden_apple_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));
    public static final Block GOLDEN_APPLE_SAPLING = registerBlock2("golden_apple_sapling",
            new SaplingBlock(ModSaplingGenerators.GOLDEN_APPLE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));


    private static Block registerBlock2(String name, Block block) {
        registerBlockItem2(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MoreThanApples.MOD_ID, name), block);
    }

    private static void registerBlockItem2(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MoreThanApples.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks2() {
        MoreThanApples.LOGGER.info("Registering Mod Blocks " + MoreThanApples.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entrise -> {
            entrise.add(APPLE_ORE);
            entrise.add(DEEPSLATE_APPLE_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entrise -> {
            entrise.add(APPLE_LOG);
            entrise.add(APPLE_WOOD);
            entrise.add(STRIPPED_APPLE_LOG);
            entrise.add(STRIPPED_APPLE_WOOD);
            entrise.add(APPLE_PLANKS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entrise -> {
            entrise.add(APPLE_LEAVES);
            entrise.add(FRUIT_APPLE_LEAVES);
            entrise.add(APPLE_SAPLING);
        });
    }
}
