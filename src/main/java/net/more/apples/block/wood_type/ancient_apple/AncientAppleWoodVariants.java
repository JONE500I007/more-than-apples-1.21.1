package net.more.apples.block.wood_type.ancient_apple;

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
import net.more.apples.block.custom.AppleShelfBlock;

import java.util.function.Function;

public class AncientAppleWoodVariants {
    public static final Block ANCIENT_APPLE_STAIRS = registerBlock("ancient_apple_stairs",
            properties -> new StairBlock(AncientAppleWoodBlocks.ANCIENT_APPLE_PLANKS.defaultBlockState(),
                    properties
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final Block ANCIENT_APPLE_SLAB = registerBlock("ancient_apple_slab",
            properties -> new SlabBlock(properties
                    .strength(2.0f, 3.0f)
                    .sound(SoundType.WOOD)));
    public static final Block ANCIENT_APPLE_BUTTON = registerBlock("ancient_apple_button",
            properties -> new ButtonBlock(BlockSetType.OAK, 30,
                    properties
                            .noCollision()
                            .strength(0.5f)
                            .sound(SoundType.WOOD)));
    public static final Block ANCIENT_APPLE_PRESSURE_PLATE = registerBlock("ancient_apple_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.OAK,
                    properties
                            .strength(0.5f)
                            .sound(SoundType.WOOD)));
    public static final Block ANCIENT_APPLE_FENCE = registerBlock("ancient_apple_fence",
            properties -> new FenceBlock(
                    properties
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final Block ANCIENT_APPLE_FENCE_GATE = registerBlock("ancient_apple_fence_gate",
            properties -> new FenceGateBlock(WoodType.OAK,
                    properties
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final Block ANCIENT_APPLE_DOOR = registerBlock("ancient_apple_door",
            properties -> new DoorBlock(BlockSetType.OAK,
                    properties
                            .noOcclusion()
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final Block ANCIENT_APPLE_TRAPDOOR = registerBlock("ancient_apple_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.OAK,
                    properties
                            .noOcclusion()
                            .strength(2.0f, 3.0f)
                            .sound(SoundType.WOOD)));

    public static final Identifier ANCIENT_APPLE_SIGN_TEXTURE =
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "entity/signs/ancient_apple_sign");
    public static final Identifier ANCIENT_APPLE_HANGING_SIGN_TEXTURE =
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "entity/signs/hanging/ancient_apple_hanging_sign");
    public static final Identifier ANCIENT_APPLE_HANGING_GUI_SIGN_TEXTURE =
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "textures/gui/hanging_signs/ancient_apple_sign_gui");


    public static final WoodType ANCIENT_APPLE_SIGN_WOOD_TYPE = TerraformSignBlockHelper.registerDefaultWoodType(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "ancient_apple_sign"));
    public static final WoodType ANCIENT_APPLE_HANGING_SIGN_WOOD_TYPE = TerraformSignBlockHelper.registerDefaultWoodType(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "ancient_apple_hanging_sign"));

    public static final Block ANCIENT_APPLE_STANDING_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "ancient_apple_standing_sign"),
            (settings) -> new StandingSignBlock(ANCIENT_APPLE_SIGN_WOOD_TYPE, settings),
            registerIdBlock("ancient_apple_standing_sign", Blocks.OAK_SIGN));
    public static final Block ANCIENT_APPLE_WALL_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "ancient_apple_wall_sign"),
            (settings) -> new WallSignBlock(ANCIENT_APPLE_SIGN_WOOD_TYPE, settings),
            registerIdBlock("ancient_apple_wall_sign", Blocks.OAK_WALL_SIGN));

    public static final Block ANCIENT_APPLE_HANGING_SIGN_BLOCK = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "ancient_apple_hanging_sign"),
            (settings) -> new CeilingHangingSignBlock(ANCIENT_APPLE_HANGING_SIGN_WOOD_TYPE, settings),
            registerIdBlock("ancient_apple_hanging_sign", Blocks.OAK_HANGING_SIGN));
    public static final Block ANCIENT_APPLE_WALL_HANGING_SIGN = TerraformSignBlockHelper.registerSignBlock(
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "ancient_apple_wall_hanging_sign"),
            (settings) -> new WallHangingSignBlock(ANCIENT_APPLE_HANGING_SIGN_WOOD_TYPE, settings),
            registerIdBlock("ancient_apple_wall_hanging_sign", Blocks.OAK_WALL_HANGING_SIGN));

    public static final Block ANCIENT_APPLE_SHELF = registerBlock("ancient_apple_shelf",
            properties -> new AppleShelfBlock(
                    registerIdBlock("ancient_apple_shelf", Blocks.OAK_SHELF)));



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

    public static void registerAppleWoodBlock() {
        MoreThanApples.LOGGER.info("Registering Mod Blocks " + MoreThanApples.MOD_ID);
    }
}
