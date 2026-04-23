package net.more.apples.block;

import com.terraformersmc.terraform.sign.api.block.TerraformSignBlockHelper;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.client.particle.FallingLeavesParticle;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ShelfBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.more.apples.MoreThanApples;
import net.more.apples.block.custom.AppleShelfBlock;
import net.more.apples.entity.AppleBlockEntity;
import net.more.apples.particle.ModParticle;
import net.more.apples.world.tree.ModSaplingGenerators;

import java.util.Set;

public class ModBlocks2 {

    public static final Block APPLE_ORE = registerBlock2("apple_ore",
            new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.of().strength(3.0f, 3.0f)
                            .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_ore")))
                            .sound(SoundType.STONE)
                            .requiresCorrectToolForDrops()));
    public static final Block DEEPSLATE_APPLE_ORE = registerBlock2("deepslate_apple_ore",
            new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.of().strength(4.5f, 3.0f)
                            .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "deepslate_apple_ore")))
                            .sound(SoundType.DEEPSLATE)
                            .requiresCorrectToolForDrops()));

    public static final Block APPLE_LOG = registerBlock2("apple_log",
            new RotatedPillarBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_LOG)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_log")))));
    public static final Block APPLE_WOOD = registerBlock2("apple_wood",
            new RotatedPillarBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_wood")))));
    public static final Block STRIPPED_APPLE_LOG = registerBlock2("stripped_apple_log",
            new RotatedPillarBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.STRIPPED_OAK_LOG)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "stripped_apple_log")))));
    public static final Block STRIPPED_APPLE_WOOD = registerBlock2("stripped_apple_wood",
            new RotatedPillarBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.STRIPPED_OAK_WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "stripped_apple_wood")))));

    public static final Block APPLE_PLANKS = registerBlock2("apple_planks",
            new Block(BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_PLANKS)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_planks")))));
    public static final Block APPLE_LEAVES = registerBlock2("apple_leaves",
            new UntintedParticleLeavesBlock(
                    0.02f, ColorParticleOption.create(ParticleTypes.TINTED_LEAVES, 0.46f, 0.67f, 0.18f)
                    ,BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_LEAVES)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_leaves")))));
    public static final Block FRUIT_APPLE_LEAVES = registerBlock2("fruit_apple_leaves",
            new UntintedParticleLeavesBlock(
                    0.02f, ColorParticleOption.create(ParticleTypes.TINTED_LEAVES, 0x77AB2F)
                    ,BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_LEAVES)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "fruit_apple_leaves")))));
    public static final Block APPLE_SAPLING = registerBlock2("apple_sapling",
            new SaplingBlock(ModSaplingGenerators.APPLE, BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SAPLING)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_sapling")))));

    public static final Block APPLE_STAIRS = registerBlock2("apple_stairs",
            new StairBlock(ModBlocks2.APPLE_PLANKS.defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_stairs")))
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final Block APPLE_SLAB = registerBlock2("apple_slab",
            new SlabBlock(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_slab")))
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));

    public static final Block APPLE_BUTTON = registerBlock2("apple_button",
            new ButtonBlock(BlockSetType.OAK, 30,
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_button")))
                            .noCollision()
                            .strength(0.5f)
                            .sound(SoundType.WOOD)));
    public static final Block APPLE_PRESSURE_PLATE = registerBlock2("apple_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_pressure_plate")))
                    .strength(0.5f)
                    .sound(SoundType.WOOD)));

    public static final Block APPLE_FENCE = registerBlock2("apple_fence",
            new FenceBlock(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_fence")))
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));
    public static final Block APPLE_FENCE_GATE = registerBlock2("apple_fence_gate",
            new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_fence_gate")))
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));
//    public static final Block APPLE_WALL = registerBlock2("apple_wall",
//            new WallBlock(BlockBehaviour.Properties.of()));

    public static final Block APPLE_DOOR = registerBlock2("apple_door",
            new DoorBlock(BlockSetType.OAK ,BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_door")))
                    .noOcclusion()
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));
    public static final Block APPLE_TRAPDOOR = registerBlock2("apple_trapdoor",
            new TrapDoorBlock(BlockSetType.OAK ,BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_trapdoor")))
                    .noOcclusion()
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));

    public static final Identifier APPLE_SIGN_TEXTURE =
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "entity/signs/apple_sign");
    public static final Identifier APPLE_HANGING_SIGN_TEXTURE =
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "entity/signs/hanging/apple_hanging_sign");
    public static final Identifier APPLE_HANGING_GUI_SIGN_TEXTURE =
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "textures/gui/hanging_signs/apple_sign_gui");

//    public static final Block APPLE_STANDING_SIGN = registerBlock2(
//            "apple_standing_sign", new SignBlock(WoodType.OAK, BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SIGN)
//                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_standing_sign")))));

    /*
    public static final Block APPLE_STANDING_SIGN = registerBlock2("apple_standing_sign",
            new TerraformSignBlock(APPLE_SIGN_TEXTURE, BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SIGN)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_standing_sign")))));
    public static final Block APPLE_WALL_SIGN = registerBlock2("apple_wall_sign",
            new TerraformWallSignBlock(APPLE_SIGN_TEXTURE, BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_WALL_SIGN)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_wall_sign")))));
    public static final Block APPLE_HANGING_SIGN_BLOCK = registerBlock2("apple_hanging_sign_block",
            new TerraformHangingSignBlock(APPLE_HANGING_SIGN_TEXTURE, APPLE_HANGING_GUI_SIGN_TEXTURE,
                    BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_HANGING_SIGN)
                            .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_hanging_sign_block")))));
    public static final Block APPLE_WALL_HANGING_SIGN = registerBlock2("apple_wall_hanging_sign",
            new TerraformWallHangingSignBlock(APPLE_HANGING_SIGN_TEXTURE, APPLE_HANGING_GUI_SIGN_TEXTURE,
                    BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_WALL_HANGING_SIGN)
                            .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_wall_hanging_sign")))));
     */
    public static final WoodType APPLE_SIGN_WOOD_TYPE = TerraformSignBlockHelper.registerDefaultWoodType(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_sign"));
    public static final WoodType APPLE_HANGING_SIGN_WOOD_TYPE = TerraformSignBlockHelper.registerDefaultWoodType(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_hanging_sign"));

    public static final Block APPLE_STANDING_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_standing_sign"),
            (settings) -> new StandingSignBlock(APPLE_SIGN_WOOD_TYPE, settings),
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SIGN));
    public static final Block APPLE_WALL_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_wall_sign"),
            (settings) -> new WallSignBlock(APPLE_SIGN_WOOD_TYPE, settings),
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_WALL_SIGN));

    public static final Block APPLE_HANGING_SIGN_BLOCK = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_hanging_sign"),
            (settings) -> new CeilingHangingSignBlock(APPLE_HANGING_SIGN_WOOD_TYPE, settings),
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_HANGING_SIGN));
    public static final Block APPLE_WALL_HANGING_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_wall_hanging_sign"),
            (settings) -> new WallHangingSignBlock(APPLE_HANGING_SIGN_WOOD_TYPE, settings),
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_WALL_HANGING_SIGN));


//    public static final Block APPLE_STANDING_SIGN = registerBlock2("apple_standing_sign",
//            new TerraformSignBlock(APPLE_SIGN_TEXTURE, BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SIGN)
//                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_standing_sign")))));
//    public static final Block APPLE_WALL_SIGN = registerBlock2("apple_wall_sign",
//            new TerraformWallSignBlock(APPLE_SIGN_TEXTURE, BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_WALL_SIGN)
//                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_wall_sign")))));
//    public static final Block APPLE_HANGING_SIGN_BLOCK = registerBlock2("apple_hanging_sign_block",
//            new TerraformHangingSignBlock(APPLE_HANGING_SIGN_TEXTURE, APPLE_HANGING_GUI_SIGN_TEXTURE,
//                    BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_HANGING_SIGN)
//                            .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_hanging_sign_block")))));
//    public static final Block APPLE_WALL_HANGING_SIGN = registerBlock2("apple_wall_hanging_sign",
//            new TerraformWallHangingSignBlock(APPLE_HANGING_SIGN_TEXTURE, APPLE_HANGING_GUI_SIGN_TEXTURE,
//                    BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_WALL_HANGING_SIGN)
//                            .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_wall_hanging_sign")))));


    public static final Block GOLDEN_APPLE_LEAVES = registerBlock2("golden_apple_leaves",
            new UntintedParticleLeavesBlock(
                    0.02f , ColorParticleOption.create(ParticleTypes.TINTED_LEAVES, 0xE6A96B),
                    BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_LEAVES)
                            .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "golden_apple_leaves")))));
    public static final Block FRUIT_GOLDEN_APPLE_LEAVES = registerBlock2("fruit_golden_apple_leaves",
            new UntintedParticleLeavesBlock(
                    0.02f , ColorParticleOption.create(ParticleTypes.TINTED_LEAVES, 0xE6A96B),
                    BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_LEAVES)
                            .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "fruit_golden_apple_leaves")))));
    public static final Block GOLDEN_APPLE_SAPLING = registerBlock2("golden_apple_sapling",
            new SaplingBlock(ModSaplingGenerators.GOLDEN_APPLE, BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SAPLING)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "golden_apple_sapling")))));

//    public static final BlockFamily THE_APPLE_FAMILY = BlockFamilies.register(ModBlocks2.APPLE_PLANKS)
//            .sign(ModBlocks2.APPLE_STANDING_SIGN, ModBlocks2.APPLE_WALL_SIGN)
//            .group("wooden")
//            .unlockCriterionName("has_planks")
//            .build();


    public static final Block TEST_APPLE_LOG = registerBlock2("test_apple_log",
            new RotatedPillarBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_LOG)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_log")))));
    public static final Block TEST_APPLE_WOOD = registerBlock2("test_apple_wood",
            new RotatedPillarBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_wood")))));
    public static final Block STRIPPED_TEST_APPLE_LOG = registerBlock2("stripped_test_apple_log",
            new RotatedPillarBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.STRIPPED_OAK_LOG)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "stripped_test_apple_log")))));
    public static final Block STRIPPED_TEST_APPLE_WOOD = registerBlock2("stripped_test_apple_wood",
            new RotatedPillarBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.STRIPPED_OAK_WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "stripped_test_apple_wood")))));

    public static final Block TEST_APPLE_PLANKS = registerBlock2("test_apple_planks",
            new Block(BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_PLANKS)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_planks")))));
    public static final Block TEST_APPLE_LEAVES = registerBlock2("test_apple_leaves",
            new UntintedParticleLeavesBlock(0.05f, ModParticle.TEST_LEAVES_PARTICLE,
                    BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_LEAVES)
                            .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_leaves")))));
    public static final Block TEST_APPLE_SAPLING = registerBlock2("test_apple_sapling",
            new SaplingBlock(ModSaplingGenerators.TEST_APPLE, BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SAPLING)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_sapling")))));

    public static final Block TEST_APPLE_STAIRS = registerBlock2("test_apple_stairs",
            new StairBlock(ModBlocks2.TEST_APPLE_PLANKS.defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_stairs")))
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final Block TEST_APPLE_SLAB = registerBlock2("test_apple_slab",
            new SlabBlock(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_slab")))
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));

    public static final Block TEST_APPLE_BUTTON = registerBlock2("test_apple_button",
            new ButtonBlock(BlockSetType.OAK, 30,
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_button")))
                            .noCollision()
                            .strength(0.5f)
                            .sound(SoundType.WOOD)));
    public static final Block TEST_APPLE_PRESSURE_PLATE = registerBlock2("test_apple_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_pressure_plate")))
                    .strength(0.5f)
                    .sound(SoundType.WOOD)));

    public static final Block TEST_APPLE_FENCE = registerBlock2("test_apple_fence",
            new FenceBlock(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_fence")))
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));
    public static final Block TEST_APPLE_FENCE_GATE = registerBlock2("test_apple_fence_gate",
            new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_fence_gate")))
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));

    public static final Block TEST_APPLE_DOOR = registerBlock2("test_apple_door",
            new DoorBlock(BlockSetType.OAK ,BlockBehaviour.Properties.of().noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_door")))
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));
    public static final Block TEST_APPLE_TRAPDOOR = registerBlock2("test_apple_trapdoor",
            new TrapDoorBlock(BlockSetType.OAK ,BlockBehaviour.Properties.of().noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_trapdoor")))
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));

    public static final Identifier TEST_APPLE_SIGN_TEXTURE =
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "entity/signs/test_apple_sign");
    public static final Identifier TEST_APPLE_HANGING_SIGN_TEXTURE =
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "entity/signs/hanging/test_apple_hanging_sign");
    public static final Identifier TEST_APPLE_HANGING_GUI_SIGN_TEXTURE =
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "textures/gui/hanging_signs/test_apple_sign_gui");

    public static final WoodType TEST_APPLE_SIGN_WOOD_TYPE = TerraformSignBlockHelper.registerDefaultWoodType(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_sign"));
    public static final WoodType TEST_APPLE_HANGING_SIGN_WOOD_TYPE = TerraformSignBlockHelper.registerDefaultWoodType(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_hanging_sign"));

    public static final Block TEST_APPLE_STANDING_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_standing_sign"),
            (settings) -> new StandingSignBlock(TEST_APPLE_SIGN_WOOD_TYPE, settings),
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SIGN));
    public static final Block TEST_APPLE_WALL_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_wall_sign"),
            (settings) -> new WallSignBlock(TEST_APPLE_SIGN_WOOD_TYPE, settings),
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_WALL_SIGN));

    public static final Block TEST_APPLE_HANGING_SIGN_BLOCK = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_hanging_sign_block"),
            (settings) -> new CeilingHangingSignBlock(TEST_APPLE_HANGING_SIGN_WOOD_TYPE, settings),
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_HANGING_SIGN));
    public static final Block TEST_APPLE_WALL_HANGING_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_wall_hanging_sign"),
            (settings) -> new WallHangingSignBlock(TEST_APPLE_HANGING_SIGN_WOOD_TYPE, settings),
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_WALL_HANGING_SIGN));


    public static final Block FROSTY_APPLE_LOG = registerBlock2("frosty_apple_log",
            new RotatedPillarBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_LOG)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_log")))));
    public static final Block FROSTY_APPLE_WOOD = registerBlock2("frosty_apple_wood",
            new RotatedPillarBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_wood")))));
    public static final Block STRIPPED_FROSTY_APPLE_LOG = registerBlock2("stripped_frosty_apple_log",
            new RotatedPillarBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.STRIPPED_OAK_LOG)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "stripped_frosty_apple_log")))));
    public static final Block STRIPPED_FROSTY_APPLE_WOOD = registerBlock2("stripped_frosty_apple_wood",
            new RotatedPillarBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.STRIPPED_OAK_WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "stripped_frosty_apple_wood")))));

    public static final Block FROSTY_APPLE_PLANKS = registerBlock2("frosty_apple_planks",
            new Block(BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_PLANKS)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_planks")))));
    public static final Block FROSTY_APPLE_LEAVES = registerBlock2("frosty_apple_leaves",
            new UntintedParticleLeavesBlock(
                    0.02f , ColorParticleOption.create(ParticleTypes.TINTED_LEAVES, 0x85c0c8),
                    BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_LEAVES)
                            .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_leaves")))));
    public static final Block FROSTY_APPLE_SAPLING = registerBlock2("frosty_apple_sapling",
            new SaplingBlock(ModSaplingGenerators.FROSTY_APPLE, BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SAPLING)
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_sapling")))));

    public static final Block FROSTY_APPLE_STAIRS = registerBlock2("frosty_apple_stairs",
            new StairBlock(ModBlocks2.FROSTY_APPLE_PLANKS.defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_stairs")))
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final Block FROSTY_APPLE_SLAB = registerBlock2("frosty_apple_slab",
            new SlabBlock(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_slab")))
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));
    public static final Block FROSTY_APPLE_BUTTON = registerBlock2("frosty_apple_button",
            new ButtonBlock(BlockSetType.OAK, 30,
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_button")))
                            .noCollision()
                            .strength(0.5f)
                            .sound(SoundType.WOOD)));
    public static final Block FROSTY_APPLE_PRESSURE_PLATE = registerBlock2("frosty_apple_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_pressure_plate")))
                    .strength(0.5f)
                    .sound(SoundType.WOOD)));
    public static final Block FROSTY_APPLE_FENCE = registerBlock2("frosty_apple_fence",
            new FenceBlock(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_fence")))
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));
    public static final Block FROSTY_APPLE_FENCE_GATE = registerBlock2("frosty_apple_fence_gate",
            new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_fence_gate")))
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));
    public static final Block FROSTY_APPLE_DOOR = registerBlock2("frosty_apple_door",
            new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_door")))
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));
    public static final Block FROSTY_APPLE_TRAPDOOR = registerBlock2("frosty_apple_trapdoor",
            new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_trapdoor")))
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));

    public static final Identifier FROSTY_APPLE_SIGN_TEXTURE =
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "entity/signs/frosty_apple_sign");
    public static final Identifier FROSTY_APPLE_HANGING_SIGN_TEXTURE =
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "entity/signs/hanging/frosty_apple_hanging_sign");
    public static final Identifier FROSTY_APPLE_HANGING_GUI_SIGN_TEXTURE =
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "textures/gui/hanging_signs/frosty_apple_sign_gui");

    public static final WoodType FROSTY_APPLE_SIGN_WOOD_TYPE = TerraformSignBlockHelper.registerDefaultWoodType(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_sign"));
    public static final WoodType FROSTY_APPLE_HANGING_SIGN_WOOD_TYPE = TerraformSignBlockHelper.registerDefaultWoodType(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_hanging_sign"));

    public static final Block FROSTY_APPLE_STANDING_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_standing_sign"),
            (settings) -> new StandingSignBlock(FROSTY_APPLE_SIGN_WOOD_TYPE, settings),
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SIGN));
    public static final Block FROSTY_APPLE_WALL_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_wall_sign"),
            (settings) -> new WallSignBlock(FROSTY_APPLE_SIGN_WOOD_TYPE, settings),
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_WALL_SIGN));
    public static final Block FROSTY_APPLE_HANGING_SIGN_BLOCK = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_hanging_sign_block"),
            (settings) -> new CeilingHangingSignBlock(FROSTY_APPLE_HANGING_SIGN_WOOD_TYPE, settings),
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_HANGING_SIGN));
    public static final Block FROSTY_APPLE_WALL_HANGING_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "frosty_apple_wall_hanging_sign"),
            (settings) -> new WallHangingSignBlock(FROSTY_APPLE_HANGING_SIGN_WOOD_TYPE, settings),
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_WALL_HANGING_SIGN));

    public static final Block APPLE_SHELF = registerBlock2("apple_shelf",
            new AppleShelfBlock(BlockBehaviour.Properties.ofLegacyCopy(Blocks.OAK_SHELF)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_shelf")))));

    public static final BlockEntityType<AppleBlockEntity> SHELF_ENTITY_TYPE =
            Registry.register(
                    BuiltInRegistries.BLOCK_ENTITY_TYPE,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_shelf"),
                    FabricBlockEntityTypeBuilder
                            .create(AppleBlockEntity::new, ModBlocks2.APPLE_SHELF)
                            .build());



    public static final Block APPLE_BARREL = registerBlock2("apple_barrel",
            new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_barrel")))
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));


    private static Block registerBlock2(String name, Block block) {
        registerBlockItem2(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name), block);
    }

    private static void registerBlockItem2(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name),
                new BlockItem(block, new Item.Properties()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name)))));
    }

    public static void registerModBlocks2() {
        MoreThanApples.LOGGER.info("Registering Mod Blocks " + MoreThanApples.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entrise -> {
            entrise.accept(APPLE_ORE);
            entrise.accept(DEEPSLATE_APPLE_ORE);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entrise -> {
            entrise.accept(APPLE_LOG);
            entrise.accept(APPLE_WOOD);
            entrise.accept(STRIPPED_APPLE_LOG);
            entrise.accept(STRIPPED_APPLE_WOOD);
            entrise.accept(APPLE_PLANKS);
            entrise.accept(APPLE_STAIRS);
            entrise.accept(APPLE_SLAB);
            entrise.accept(APPLE_FENCE);
            entrise.accept(APPLE_FENCE_GATE);
            entrise.accept(APPLE_DOOR);
            entrise.accept(APPLE_TRAPDOOR);
            entrise.accept(APPLE_PRESSURE_PLATE);
            entrise.accept(APPLE_BUTTON);

            entrise.accept(TEST_APPLE_LOG);
            entrise.accept(TEST_APPLE_WOOD);
            entrise.accept(STRIPPED_TEST_APPLE_LOG);
            entrise.accept(STRIPPED_TEST_APPLE_WOOD);
            entrise.accept(TEST_APPLE_PLANKS);
            entrise.accept(TEST_APPLE_STAIRS);
            entrise.accept(TEST_APPLE_SLAB);
            entrise.accept(TEST_APPLE_FENCE);
            entrise.accept(TEST_APPLE_FENCE_GATE);
            entrise.accept(TEST_APPLE_DOOR);
            entrise.accept(TEST_APPLE_TRAPDOOR);
            entrise.accept(TEST_APPLE_PRESSURE_PLATE);
            entrise.accept(TEST_APPLE_BUTTON);

            entrise.accept(FROSTY_APPLE_LOG);
            entrise.accept(FROSTY_APPLE_WOOD);
            entrise.accept(STRIPPED_FROSTY_APPLE_LOG);
            entrise.accept(STRIPPED_FROSTY_APPLE_WOOD);
            entrise.accept(FROSTY_APPLE_PLANKS);
            entrise.accept(FROSTY_APPLE_STAIRS);
            entrise.accept(FROSTY_APPLE_SLAB);
            entrise.accept(FROSTY_APPLE_FENCE);
            entrise.accept(FROSTY_APPLE_FENCE_GATE);
            entrise.accept(FROSTY_APPLE_DOOR);
            entrise.accept(FROSTY_APPLE_TRAPDOOR);
            entrise.accept(FROSTY_APPLE_PRESSURE_PLATE);
            entrise.accept(FROSTY_APPLE_BUTTON);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entrise -> {
            entrise.accept(APPLE_LOG);
            entrise.accept(APPLE_LEAVES);
            entrise.accept(FRUIT_APPLE_LEAVES);
            entrise.accept(APPLE_SAPLING);

            entrise.accept(GOLDEN_APPLE_LEAVES);
            entrise.accept(FRUIT_GOLDEN_APPLE_LEAVES);
            entrise.accept(GOLDEN_APPLE_SAPLING);

            entrise.accept(TEST_APPLE_LOG);
            entrise.accept(TEST_APPLE_LEAVES);
            entrise.accept(TEST_APPLE_SAPLING);

            entrise.accept(FROSTY_APPLE_LOG);
            entrise.accept(FROSTY_APPLE_LEAVES);
            entrise.accept(FROSTY_APPLE_SAPLING);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entrise -> {
            entrise.accept(APPLE_BARREL);
        });
    }
}
