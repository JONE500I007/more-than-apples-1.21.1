package net.more.apples.block.wood_type.test_wood;

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
import net.more.apples.particle.ModParticle;
import net.more.apples.world.tree.ModSaplingGenerators;

import java.util.function.Function;

public class TestAppleWoodBlocks {
    public static final Block TEST_APPLE_LOG = registerBlock("test_apple_log",
            properties -> new RotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_LOG)));
    public static final Block TEST_APPLE_WOOD = registerBlock("test_apple_wood",
            properties -> new RotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_TEST_APPLE_LOG = registerBlock("stripped_test_apple_log",
            properties -> new RotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_TEST_APPLE_WOOD = registerBlock("stripped_test_apple_wood",
            properties -> new RotatedPillarBlock(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block TEST_APPLE_PLANKS = registerBlock("test_apple_planks",
            properties -> new Block(BlockBehaviour.Properties
                    .ofFullCopy(Blocks.OAK_PLANKS)));

    public static final Block TEST_APPLE_LEAVES  = registerBlock("test_apple_leaves",
            properties -> new UntintedParticleLeavesBlock(0.05f, ModParticle.TEST_LEAVES_PARTICLE,
                    BlockBehaviour.Properties
                            .ofFullCopy(Blocks.OAK_LEAVES)));
    public static final Block TEST_APPLE_SAPLING = registerBlock("test_apple_sapling",
            properties -> new SaplingBlock(
                    ModSaplingGenerators.TEST_APPLE,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));





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

    public static void registerTestAppleWoodBlock() {
        MoreThanApples.LOGGER.info("Registering Mod Blocks " + MoreThanApples.MOD_ID);
    }
}
