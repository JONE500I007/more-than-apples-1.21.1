package net.more.apples.block.wood_type.apple_wood;

import com.terraformersmc.terraform.sign.api.block.TerraformSignBlockHelper;
import net.more.apples.block.wood_type.ModSignBlockHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.more.apples.MoreThanApples;
import net.more.apples.block.custom.AppleShelfBlock;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;
import net.more.apples.entity.AppleBlockEntity;

import java.util.function.Function;

public class AppleWoodVariants {
    public static final Block APPLE_STAIRS = registerBlock("apple_stairs",
            properties -> new StairBlock(AppleWoodBlocks.APPLE_PLANKS.defaultBlockState(),
                    properties.strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final Block APPLE_SLAB = registerBlock("apple_slab",
            properties -> new SlabBlock(properties
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));
    public static final Block APPLE_BUTTON = registerBlock("apple_button",
            properties -> new ButtonBlock(BlockSetType.OAK, 30,
                    properties
                            .noCollision()
                            .strength(0.5f)
                            .sound(SoundType.WOOD)));
    public static final Block APPLE_PRESSURE_PLATE = registerBlock("apple_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.OAK,
                    properties
                            .strength(0.5f)
                            .sound(SoundType.WOOD)));
    public static final Block APPLE_FENCE = registerBlock("apple_fence",
            properties -> new FenceBlock(
                    properties
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final Block APPLE_FENCE_GATE = registerBlock("apple_fence_gate",
            properties -> new FenceGateBlock(WoodType.OAK,
                    properties
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final Block APPLE_DOOR = registerBlock("apple_door",
            properties -> new DoorBlock(BlockSetType.OAK,
                    properties
                            .noOcclusion()
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final Block APPLE_TRAPDOOR = registerBlock("apple_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.OAK,
                    properties
                            .noOcclusion()
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));

    public static final Identifier APPLE_SIGN_TEXTURE =
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "entity/signs/apple_sign");
    public static final Identifier APPLE_HANGING_SIGN_TEXTURE =
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "entity/signs/hanging/apple_hanging_sign");
    public static final Identifier APPLE_HANGING_GUI_SIGN_TEXTURE =
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "textures/gui/hanging_signs/apple_sign_gui");


    public static final WoodType APPLE_SIGN_WOOD_TYPE = ModSignBlockHelper.registerDefaultWoodType(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_sign"));
    public static final WoodType APPLE_HANGING_SIGN_WOOD_TYPE = ModSignBlockHelper.registerDefaultWoodType(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_hanging_sign"));

    public static final Block APPLE_STANDING_SIGN = ModSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_standing_sign"),
            (settings) -> new StandingSignBlock(APPLE_SIGN_WOOD_TYPE, settings),
            registerIdBlock("apple_standing_sign", Blocks.OAK_SIGN));
    public static final Block APPLE_WALL_SIGN = ModSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_wall_sign"),
            (settings) -> new WallSignBlock(APPLE_SIGN_WOOD_TYPE, settings),
            registerIdBlock("apple_wall_sign", Blocks.OAK_WALL_SIGN));

    public static final Block APPLE_HANGING_SIGN_BLOCK = ModSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_hanging_sign"),
            (settings) -> new CeilingHangingSignBlock(APPLE_HANGING_SIGN_WOOD_TYPE, settings),
            registerIdBlock("apple_hanging_sign", Blocks.OAK_HANGING_SIGN));
    public static final Block APPLE_WALL_HANGING_SIGN = ModSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_wall_hanging_sign"),
            (settings) -> new WallHangingSignBlock(APPLE_HANGING_SIGN_WOOD_TYPE, settings),
            registerIdBlock("apple_wall_hanging_sign", Blocks.OAK_WALL_HANGING_SIGN));

    public static final Block APPLE_SHELF = registerBlock("apple_shelf",
            properties -> new AppleShelfBlock(
                    registerIdBlock("apple_shelf", Blocks.OAK_SHELF)));


    private static BlockBehaviour.Properties registerIdBlock(String name, Block base) {
        ResourceKey<Block> key = ResourceKey.create(
                Registries.BLOCK,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));

        return BlockBehaviour.Properties.ofFullCopy(base).setId(key);
    }

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
