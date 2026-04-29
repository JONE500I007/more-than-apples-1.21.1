package net.more.apples.block.wood_type.test_wood;

import com.terraformersmc.terraform.sign.api.block.TerraformSignBlockHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.more.apples.MoreThanApples;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;

import java.util.function.Function;

public class TestAppleWoodVariants {
    public static final Block TEST_APPLE_STAIRS = registerBlock("test_apple_stairs",
            properties -> new StairBlock(AppleWoodBlocks.APPLE_PLANKS.defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final Block TEST_APPLE_SLAB = registerBlock("test_apple_slab",
            properties -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));
    public static final Block TEST_APPLE_BUTTON = registerBlock("test_apple_button",
            properties -> new ButtonBlock(BlockSetType.OAK, 30,
                    BlockBehaviour.Properties.of()
                            .noCollision()
                            .strength(0.5f)
                            .sound(SoundType.WOOD)));
    public static final Block TEST_APPLE_PRESSURE_PLATE = registerBlock("test_apple_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.OAK,
                    BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.WOOD)));
    public static final Block TEST_APPLE_FENCE = registerBlock("test_apple_fence",
            properties -> new FenceBlock(
                    BlockBehaviour.Properties.of()
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final Block TEST_APPLE_FENCE_GATE = registerBlock("test_apple_fence_gate",
            properties -> new FenceGateBlock(WoodType.OAK,
                    BlockBehaviour.Properties.of()
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final Block TEST_APPLE_DOOR = registerBlock("test_apple_door",
            properties -> new DoorBlock(BlockSetType.OAK,
                    BlockBehaviour.Properties.of()
                            .noOcclusion()
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final Block TEST_APPLE_TRAPDOOR = registerBlock("test_apple_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.OAK,
                    BlockBehaviour.Properties.of()
                            .noCollision()
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
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN));
    public static final Block TEST_APPLE_WALL_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_wall_sign"),
            (settings) -> new WallSignBlock(TEST_APPLE_SIGN_WOOD_TYPE, settings),
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN));

    public static final Block TEST_APPLE_HANGING_SIGN_BLOCK = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_hanging_sign"),
            (settings) -> new CeilingHangingSignBlock(TEST_APPLE_HANGING_SIGN_WOOD_TYPE, settings),
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN));
    public static final Block TEST_APPLE_WALL_HANGING_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_apple_wall_hanging_sign"),
            (settings) -> new WallHangingSignBlock(TEST_APPLE_HANGING_SIGN_WOOD_TYPE, settings),
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN));


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

    public static void registerTestAppleWoodVariant() {
        MoreThanApples.LOGGER.info("Registering Mod Blocks " + MoreThanApples.MOD_ID);
    }
}
