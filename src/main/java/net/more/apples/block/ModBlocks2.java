package net.more.apples.block;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.particle.EntityEffectParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.more.apples.MoreThanApples;
import net.more.apples.particle.ModParticle;
import net.more.apples.world.tree.ModSaplingGenerators;

public class ModBlocks2 {

    public static final Block APPLE_ORE = registerBlock2("apple_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(3.0f, 3.0f)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_ore")))
                            .sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block DEEPSLATE_APPLE_ORE = registerBlock2("deepslate_apple_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4.5f, 3.0f)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "deepslate_apple_ore")))
                            .sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));

    public static final Block APPLE_LOG = registerBlock2("apple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_log")))));
    public static final Block APPLE_WOOD = registerBlock2("apple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_wood")))));
    public static final Block STRIPPED_APPLE_LOG = registerBlock2("stripped_apple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "stripped_apple_log")))));
    public static final Block STRIPPED_APPLE_WOOD = registerBlock2("stripped_apple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "stripped_apple_wood")))));

    public static final Block APPLE_PLANKS = registerBlock2("apple_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_planks")))));
    public static final Block APPLE_LEAVES = registerBlock2("apple_leaves",
            new UntintedParticleLeavesBlock(
                    0.02f, EntityEffectParticleEffect.create(ParticleTypes.TINTED_LEAVES, 0x77AB2F)
                    ,AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_leaves")))));
    public static final Block FRUIT_APPLE_LEAVES = registerBlock2("fruit_apple_leaves",
            new UntintedParticleLeavesBlock(
                    0.02f, EntityEffectParticleEffect.create(ParticleTypes.TINTED_LEAVES, 0x77AB2F)
                    ,AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "fruit_apple_leaves")))));
    public static final Block APPLE_SAPLING = registerBlock2("apple_sapling",
            new SaplingBlock(ModSaplingGenerators.APPLE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_sapling")))));

    public static final Block APPLE_STAIRS = registerBlock2("apple_stairs",
            new StairsBlock(ModBlocks2.APPLE_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.create()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_stairs")))
                            .strength(2.0f, 3.0f)
                            .sounds(BlockSoundGroup.WOOD)));
    public static final Block APPLE_SLAB = registerBlock2("apple_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_slab")))
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block APPLE_BUTTON = registerBlock2("apple_button",
            new ButtonBlock(BlockSetType.OAK, 30,
                    AbstractBlock.Settings.create()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_button")))
                            .noCollision()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.WOOD)));
    public static final Block APPLE_PRESSURE_PLATE = registerBlock2("apple_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_pressure_plate")))
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block APPLE_FENCE = registerBlock2("apple_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_fence")))
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)));
    public static final Block APPLE_FENCE_GATE = registerBlock2("apple_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_fence_gate")))
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)));
//    public static final Block APPLE_WALL = registerBlock2("apple_wall",
//            new WallBlock(AbstractBlock.Settings.create()));

    public static final Block APPLE_DOOR = registerBlock2("apple_door",
            new DoorBlock(BlockSetType.OAK ,AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_door")))
                    .nonOpaque()
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)));
    public static final Block APPLE_TRAPDOOR = registerBlock2("apple_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK ,AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_trapdoor")))
                    .nonOpaque()
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Identifier APPLE_SIGN_TEXTURE =
            Identifier.of(MoreThanApples.MOD_ID, "entity/signs/apple_sign");
    public static final Identifier APPLE_HANGING_SIGN_TEXTURE =
            Identifier.of(MoreThanApples.MOD_ID, "entity/signs/hanging/apple_hanging_sign");
    public static final Identifier APPLE_HANGING_GUI_SIGN_TEXTURE =
            Identifier.of(MoreThanApples.MOD_ID, "textures/gui/hanging_signs/apple_sign_gui");

    /*
    public static final Block APPLE_STANDING_SIGN = registerBlock2("apple_standing_sign",
            new TerraformSignBlock(APPLE_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_standing_sign")))));
    public static final Block APPLE_WALL_SIGN = registerBlock2("apple_wall_sign",
            new TerraformWallSignBlock(APPLE_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_wall_sign")))));
    public static final Block APPLE_HANGING_SIGN_BLOCK = registerBlock2("apple_hanging_sign_block",
            new TerraformHangingSignBlock(APPLE_HANGING_SIGN_TEXTURE, APPLE_HANGING_GUI_SIGN_TEXTURE,
                    AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_hanging_sign_block")))));
    public static final Block APPLE_WALL_HANGING_SIGN = registerBlock2("apple_wall_hanging_sign",
            new TerraformWallHangingSignBlock(APPLE_HANGING_SIGN_TEXTURE, APPLE_HANGING_GUI_SIGN_TEXTURE,
                    AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_wall_hanging_sign")))));
     */
    public static final Block APPLE_STANDING_SIGN = registerBlock2("apple_standing_sign",
            new TerraformSignBlock(APPLE_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_standing_sign")))));
    public static final Block APPLE_WALL_SIGN = registerBlock2("apple_wall_sign",
            new TerraformWallSignBlock(APPLE_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_wall_sign")))));
    public static final Block APPLE_HANGING_SIGN_BLOCK = registerBlock2("apple_hanging_sign_block",
            new TerraformHangingSignBlock(APPLE_HANGING_SIGN_TEXTURE, APPLE_HANGING_GUI_SIGN_TEXTURE,
                    AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_hanging_sign_block")))));
    public static final Block APPLE_WALL_HANGING_SIGN = registerBlock2("apple_wall_hanging_sign",
            new TerraformWallHangingSignBlock(APPLE_HANGING_SIGN_TEXTURE, APPLE_HANGING_GUI_SIGN_TEXTURE,
                    AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_wall_hanging_sign")))));


    public static final Block GOLDEN_APPLE_LEAVES = registerBlock2("golden_apple_leaves",
            new UntintedParticleLeavesBlock(
                    0.02f , EntityEffectParticleEffect.create(ParticleTypes.TINTED_LEAVES, 0xE6A96B),
                    AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "golden_apple_leaves")))));
    public static final Block FRUIT_GOLDEN_APPLE_LEAVES = registerBlock2("fruit_golden_apple_leaves",
            new UntintedParticleLeavesBlock(
                    0.02f , EntityEffectParticleEffect.create(ParticleTypes.TINTED_LEAVES, 0xE6A96B),
                    AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "fruit_golden_apple_leaves")))));
    public static final Block GOLDEN_APPLE_SAPLING = registerBlock2("golden_apple_sapling",
            new SaplingBlock(ModSaplingGenerators.GOLDEN_APPLE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "golden_apple_sapling")))));

//    public static final BlockFamily THE_APPLE_FAMILY = BlockFamilies.register(ModBlocks2.APPLE_PLANKS)
//            .sign(ModBlocks2.APPLE_STANDING_SIGN, ModBlocks2.APPLE_WALL_SIGN)
//            .group("wooden")
//            .unlockCriterionName("has_planks")
//            .build();


    public static final Block TEST_APPLE_LOG = registerBlock2("test_apple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_log")))));
    public static final Block TEST_APPLE_WOOD = registerBlock2("test_apple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_wood")))));
    public static final Block STRIPPED_TEST_APPLE_LOG = registerBlock2("stripped_test_apple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "stripped_test_apple_log")))));
    public static final Block STRIPPED_TEST_APPLE_WOOD = registerBlock2("stripped_test_apple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "stripped_test_apple_wood")))));

    public static final Block TEST_APPLE_PLANKS = registerBlock2("test_apple_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_planks")))));
    public static final Block TEST_APPLE_LEAVES = registerBlock2("test_apple_leaves",
            new UntintedParticleLeavesBlock(0.05f, ModParticle.TEST_LEAVES_PARTICLE,
                    AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_leaves")))));
    public static final Block TEST_APPLE_SAPLING = registerBlock2("test_apple_sapling",
            new SaplingBlock(ModSaplingGenerators.TEST_APPLE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_sapling")))));

    public static final Block TEST_APPLE_STAIRS = registerBlock2("test_apple_stairs",
            new StairsBlock(ModBlocks2.TEST_APPLE_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.create()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_stairs")))
                            .strength(2.0f, 3.0f)
                            .sounds(BlockSoundGroup.WOOD)));
    public static final Block TEST_APPLE_SLAB = registerBlock2("test_apple_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_slab")))
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block TEST_APPLE_BUTTON = registerBlock2("test_apple_button",
            new ButtonBlock(BlockSetType.OAK, 30,
                    AbstractBlock.Settings.create()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_button")))
                            .noCollision()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.WOOD)));
    public static final Block TEST_APPLE_PRESSURE_PLATE = registerBlock2("test_apple_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_pressure_plate")))
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block TEST_APPLE_FENCE = registerBlock2("test_apple_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_fence")))
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)));
    public static final Block TEST_APPLE_FENCE_GATE = registerBlock2("test_apple_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_fence_gate")))
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Block TEST_APPLE_DOOR = registerBlock2("test_apple_door",
            new DoorBlock(BlockSetType.OAK ,AbstractBlock.Settings.create().nonOpaque()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_door")))
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)));
    public static final Block TEST_APPLE_TRAPDOOR = registerBlock2("test_apple_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK ,AbstractBlock.Settings.create().nonOpaque()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_trapdoor")))
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Identifier TEST_APPLE_SIGN_TEXTURE =
            Identifier.of(MoreThanApples.MOD_ID, "entity/signs/test_apple_sign");
    public static final Identifier TEST_APPLE_HANGING_SIGN_TEXTURE =
            Identifier.of(MoreThanApples.MOD_ID, "entity/signs/hanging/test_apple_hanging_sign");
    public static final Identifier TEST_APPLE_HANGING_GUI_SIGN_TEXTURE =
            Identifier.of(MoreThanApples.MOD_ID, "textures/gui/hanging_signs/test_apple_sign_gui");

    public static final Block TEST_APPLE_STANDING_SIGN = Registry.register(Registries.BLOCK,
            Identifier.of(MoreThanApples.MOD_ID, "test_apple_standing_sign"),
            new TerraformSignBlock(TEST_APPLE_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_standing_sign")))));
    public static final Block TEST_APPLE_WALL_SIGN = Registry.register(Registries.BLOCK,
            Identifier.of(MoreThanApples.MOD_ID, "test_apple_wall_sign"),
            new TerraformWallSignBlock(TEST_APPLE_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_wall_sign")))));
    public static final Block TEST_APPLE_HANGING_SIGN_BLOCK = Registry.register(Registries.BLOCK,
            Identifier.of(MoreThanApples.MOD_ID, "test_apple_hanging_sign_block"),
            new TerraformHangingSignBlock(TEST_APPLE_HANGING_SIGN_TEXTURE, TEST_APPLE_HANGING_GUI_SIGN_TEXTURE,
                    AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_hanging_sign_block")))));
    public static final Block TEST_APPLE_WALL_HANGING_SIGN = Registry.register(Registries.BLOCK,
            Identifier.of(MoreThanApples.MOD_ID, "test_apple_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(TEST_APPLE_HANGING_SIGN_TEXTURE, TEST_APPLE_HANGING_GUI_SIGN_TEXTURE,
                    AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "test_apple_wall_hanging_sign")))));


    public static final Block FROSTY_APPLE_LOG = registerBlock2("frosty_apple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_log")))));
    public static final Block FROSTY_APPLE_WOOD = registerBlock2("frosty_apple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_wood")))));
    public static final Block STRIPPED_FROSTY_APPLE_LOG = registerBlock2("stripped_frosty_apple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "stripped_frosty_apple_log")))));
    public static final Block STRIPPED_FROSTY_APPLE_WOOD = registerBlock2("stripped_frosty_apple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "stripped_frosty_apple_wood")))));

    public static final Block FROSTY_APPLE_PLANKS = registerBlock2("frosty_apple_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_planks")))));
    public static final Block FROSTY_APPLE_LEAVES = registerBlock2("frosty_apple_leaves",
            new UntintedParticleLeavesBlock(
                    0.02f , EntityEffectParticleEffect.create(ParticleTypes.TINTED_LEAVES, 0x85c0c8),
                    AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_leaves")))));
    public static final Block FROSTY_APPLE_SAPLING = registerBlock2("frosty_apple_sapling",
            new SaplingBlock(ModSaplingGenerators.FROSTY_APPLE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_sapling")))));

    public static final Block FROSTY_APPLE_STAIRS = registerBlock2("frosty_apple_stairs",
            new StairsBlock(ModBlocks2.FROSTY_APPLE_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.create()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_stairs")))
                            .strength(2.0f, 3.0f)
                            .sounds(BlockSoundGroup.WOOD)));
    public static final Block FROSTY_APPLE_SLAB = registerBlock2("frosty_apple_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_slab")))
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)));
    public static final Block FROSTY_APPLE_BUTTON = registerBlock2("frosty_apple_button",
            new ButtonBlock(BlockSetType.OAK, 30,
                    AbstractBlock.Settings.create()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_button")))
                            .noCollision()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.WOOD)));
    public static final Block FROSTY_APPLE_PRESSURE_PLATE = registerBlock2("frosty_apple_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_pressure_plate")))
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.WOOD)));
    public static final Block FROSTY_APPLE_FENCE = registerBlock2("frosty_apple_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_fence")))
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)));
    public static final Block FROSTY_APPLE_FENCE_GATE = registerBlock2("frosty_apple_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_fence_gate")))
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)));
    public static final Block FROSTY_APPLE_DOOR = registerBlock2("frosty_apple_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().nonOpaque()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_door")))
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)));
    public static final Block FROSTY_APPLE_TRAPDOOR = registerBlock2("frosty_apple_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().nonOpaque()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_trapdoor")))
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)));

    public static final Identifier FROSTY_APPLE_SIGN_TEXTURE =
            Identifier.of(MoreThanApples.MOD_ID, "entity/signs/frosty_apple_sign");
    public static final Identifier FROSTY_APPLE_HANGING_SIGN_TEXTURE =
            Identifier.of(MoreThanApples.MOD_ID, "entity/signs/hanging/frosty_apple_hanging_sign");
    public static final Identifier FROSTY_APPLE_HANGING_GUI_SIGN_TEXTURE =
            Identifier.of(MoreThanApples.MOD_ID, "textures/gui/hanging_signs/frosty_apple_sign_gui");

    public static final Block FROSTY_APPLE_STANDING_SIGN = Registry.register(Registries.BLOCK,
            Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_standing_sign"),
            new TerraformSignBlock(FROSTY_APPLE_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_standing_sign")))));
    public static final Block FROSTY_APPLE_WALL_SIGN = Registry.register(Registries.BLOCK,
            Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_wall_sign"),
            new TerraformWallSignBlock(FROSTY_APPLE_SIGN_TEXTURE, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_wall_sign")))));
    public static final Block FROSTY_APPLE_HANGING_SIGN_BLOCK = Registry.register(Registries.BLOCK,
            Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_hanging_sign_block"),
            new TerraformHangingSignBlock(FROSTY_APPLE_HANGING_SIGN_TEXTURE, FROSTY_APPLE_HANGING_GUI_SIGN_TEXTURE,
                    AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_hanging_sign_block")))));
    public static final Block FROSTY_APPLE_WALL_HANGING_SIGN = Registry.register(Registries.BLOCK,
            Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(FROSTY_APPLE_HANGING_SIGN_TEXTURE, FROSTY_APPLE_HANGING_GUI_SIGN_TEXTURE,
                    AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "frosty_apple_wall_hanging_sign")))));



    public static final Block APPLE_BARREL = registerBlock2("apple_barrel",
            new Block(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreThanApples.MOD_ID, "apple_barrel")))
                    .strength(2.0f, 3.0f)
                    .sounds(BlockSoundGroup.WOOD)));


    private static Block registerBlock2(String name, Block block) {
        registerBlockItem2(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MoreThanApples.MOD_ID, name), block);
    }

    private static void registerBlockItem2(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MoreThanApples.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, name)))));
    }

    public static void registerModBlocks2() {
        MoreThanApples.LOGGER.info("Registering Mod Blocks " + MoreThanApples.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entrise -> {
            entrise.add(APPLE_ORE);
            entrise.add(DEEPSLATE_APPLE_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entrise -> {
            entrise.add(APPLE_LOG);
            entrise.add(APPLE_WOOD);
            entrise.add(STRIPPED_APPLE_LOG);
            entrise.add(STRIPPED_APPLE_WOOD);
            entrise.add(APPLE_PLANKS);
            entrise.add(APPLE_STAIRS);
            entrise.add(APPLE_SLAB);
            entrise.add(APPLE_FENCE);
            entrise.add(APPLE_FENCE_GATE);
            entrise.add(APPLE_DOOR);
            entrise.add(APPLE_TRAPDOOR);
            entrise.add(APPLE_PRESSURE_PLATE);
            entrise.add(APPLE_BUTTON);

            entrise.add(TEST_APPLE_LOG);
            entrise.add(TEST_APPLE_WOOD);
            entrise.add(STRIPPED_TEST_APPLE_LOG);
            entrise.add(STRIPPED_TEST_APPLE_WOOD);
            entrise.add(TEST_APPLE_PLANKS);
            entrise.add(TEST_APPLE_STAIRS);
            entrise.add(TEST_APPLE_SLAB);
            entrise.add(TEST_APPLE_FENCE);
            entrise.add(TEST_APPLE_FENCE_GATE);
            entrise.add(TEST_APPLE_DOOR);
            entrise.add(TEST_APPLE_TRAPDOOR);
            entrise.add(TEST_APPLE_PRESSURE_PLATE);
            entrise.add(TEST_APPLE_BUTTON);

            entrise.add(FROSTY_APPLE_LOG);
            entrise.add(FROSTY_APPLE_WOOD);
            entrise.add(STRIPPED_FROSTY_APPLE_LOG);
            entrise.add(STRIPPED_FROSTY_APPLE_WOOD);
            entrise.add(FROSTY_APPLE_PLANKS);
            entrise.add(FROSTY_APPLE_STAIRS);
            entrise.add(FROSTY_APPLE_SLAB);
            entrise.add(FROSTY_APPLE_FENCE);
            entrise.add(FROSTY_APPLE_FENCE_GATE);
            entrise.add(FROSTY_APPLE_DOOR);
            entrise.add(FROSTY_APPLE_TRAPDOOR);
            entrise.add(FROSTY_APPLE_PRESSURE_PLATE);
            entrise.add(FROSTY_APPLE_BUTTON);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entrise -> {
            entrise.add(APPLE_LOG);
            entrise.add(APPLE_LEAVES);
            entrise.add(FRUIT_APPLE_LEAVES);
            entrise.add(APPLE_SAPLING);

            entrise.add(GOLDEN_APPLE_LEAVES);
            entrise.add(FRUIT_GOLDEN_APPLE_LEAVES);
            entrise.add(GOLDEN_APPLE_SAPLING);

            entrise.add(TEST_APPLE_LOG);
            entrise.add(TEST_APPLE_LEAVES);
            entrise.add(TEST_APPLE_SAPLING);

            entrise.add(FROSTY_APPLE_LOG);
            entrise.add(FROSTY_APPLE_LEAVES);
            entrise.add(FROSTY_APPLE_SAPLING);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entrise -> {
            entrise.add(APPLE_BARREL);
        });
    }
}
