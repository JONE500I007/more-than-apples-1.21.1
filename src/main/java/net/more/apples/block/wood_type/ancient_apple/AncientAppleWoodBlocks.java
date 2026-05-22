package net.more.apples.block.wood_type.ancient_apple;

import net.minecraft.core.Registry;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.more.apples.MoreThanApples;
import net.more.apples.block.custom.AppleLeavesBlock;
import net.more.apples.world.tree.ModSaplingGenerators;

import java.util.List;
import java.util.function.Function;

public class AncientAppleWoodBlocks {
    public static final Block ANCIENT_APPLE_LOG = registerBlock("ancient_apple_log",
            properties -> new RotatedPillarBlock(
                    registerIdBlock("ancient_apple_log", Blocks.OAK_LOG)));
    public static final Block ANCIENT_APPLE_WOOD = registerBlock("ancient_apple_wood",
            properties -> new RotatedPillarBlock(
                    registerIdBlock("ancient_apple_wood", Blocks.OAK_WOOD)));
    public static final Block STRIPPED_ANCIENT_APPLE_LOG = registerBlock("stripped_ancient_apple_log",
            properties -> new RotatedPillarBlock(
                    registerIdBlock("stripped_ancient_apple_log", Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_ANCIENT_APPLE_WOOD = registerBlock("stripped_ancient_apple_wood",
            properties -> new RotatedPillarBlock(
                    registerIdBlock("stripped_ancient_apple_wood", Blocks.STRIPPED_OAK_WOOD)));

    public static final Block ANCIENT_APPLE_PLANKS = registerBlock("ancient_apple_planks",
            properties -> new Block(
                    registerIdBlock("ancient_apple_planks", Blocks.OAK_PLANKS)));

    public static final Block ANCIENT_APPLE_LEAVES  = registerBlock("ancient_apple_leaves",
            properties -> new AppleLeavesBlock(
                    0.02f, ColorParticleOption.create(ParticleTypes.TINTED_LEAVES, 0x77AB2F),
                    registerIdBlock("ancient_apple_leaves", Blocks.OAK_LEAVES)));
    public static final Block ANCIENT_APPLE_SAPLING = registerBlock("ancient_apple_sapling",
            properties -> new SaplingBlock(
                    ModSaplingGenerators.ANCIENT_APPLE,
                    registerIdBlock("ancient_apple_sapling", Blocks.OAK_SAPLING)));

    public static final Block APPLE_BLOSSOMV2 = registerBlock("apple_blossomv2",
            properties -> new FlowerBlock(
                    MobEffects.SLOW_FALLING,
                    2,
                    registerIdBlock("apple_blossomv2", Blocks.DANDELION)));

    public static final Block APPLE_BLOSSOM = registerBlock("apple_blossom",
            properties -> new FlowerBlock(
                    new SuspiciousStewEffects(List.of()),
                    registerIdBlock("apple_blossom", Blocks.DANDELION)
                            .noOcclusion()
                            .noCollision()));
    public static final Block POTTED_APPLE_BLOSSOM = registerBlockWithoutBlockItem("potted_apple_blossom",
            properties -> new FlowerPotBlock(APPLE_BLOSSOM,
                    registerIdBlock("potted_apple_blossom", Blocks.POTTED_DANDELION)
                            .noOcclusion()));

    public static final Block APPLE_LEAF_LITTER = registerBlock("apple_leaf_litter",
            properties -> new LeafLitterBlock(
                    registerIdBlock("apple_leaf_litter", Blocks.LEAF_LITTER)));

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
