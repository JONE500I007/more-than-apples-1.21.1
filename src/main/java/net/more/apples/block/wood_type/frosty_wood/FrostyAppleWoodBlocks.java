package net.more.apples.block.wood_type.frosty_wood;

import net.minecraft.core.Registry;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.more.apples.MoreThanApples;
import net.more.apples.world.tree.ModSaplingGenerators;

import java.util.function.Function;

public class FrostyAppleWoodBlocks {
    public static final Block FROSTY_APPLE_LOG = registerBlock("frosty_apple_log",
            properties -> new RotatedPillarBlock(
                    registerIdBlock("frosty_apple_log", Blocks.OAK_LOG)));
    public static final Block FROSTY_APPLE_WOOD = registerBlock("frosty_apple_wood",
            properties -> new RotatedPillarBlock(
                    registerIdBlock("frosty_apple_wood", Blocks.OAK_WOOD)));
    public static final Block STRIPPED_FROSTY_APPLE_LOG = registerBlock("stripped_frosty_apple_log",
            properties -> new RotatedPillarBlock(
                    registerIdBlock("stripped_frosty_apple_log", Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_FROSTY_APPLE_WOOD = registerBlock("stripped_frosty_apple_wood",
            properties -> new RotatedPillarBlock(
                    registerIdBlock("stripped_frosty_apple_wood", Blocks.STRIPPED_OAK_WOOD)));

    public static final Block FROSTY_APPLE_PLANKS = registerBlock("frosty_apple_planks",
            properties -> new Block(
                    registerIdBlock("frosty_apple_planks", Blocks.OAK_PLANKS)));

    public static final Block FROSTY_APPLE_LEAVES  = registerBlock("frosty_apple_leaves",
            properties -> new UntintedParticleLeavesBlock(
                    0.02f, ColorParticleOption.create(ParticleTypes.TINTED_LEAVES, 0.46f, 0.67f, 0.18f),
                    registerIdBlock("frosty_apple_leaves", Blocks.OAK_LEAVES)));
    public static final Block FRUIT_FROSTY_APPLE_LEAVES = registerBlock("fruit_frosty_apple_leaves",
            properties -> new UntintedParticleLeavesBlock(
                    0.02f, ColorParticleOption.create(ParticleTypes.TINTED_LEAVES, 0.46f, 0.67f, 0.18f),
                    registerIdBlock("fruit_frosty_apple_leaves", Blocks.OAK_LEAVES)));
    public static final Block FROSTY_APPLE_SAPLING = registerBlock("frosty_apple_sapling",
            properties -> new SaplingBlock(
                    ModSaplingGenerators.FROSTY_APPLE,
                    registerIdBlock("frosty_apple_sapling", Blocks.OAK_SAPLING)));


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

    public static void registerFrostyAppleWoodBlock() {
        MoreThanApples.LOGGER.info("Registering Mod Blocks " + MoreThanApples.MOD_ID);
    }
}
