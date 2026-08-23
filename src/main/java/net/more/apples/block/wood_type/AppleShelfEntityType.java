package net.more.apples.block.wood_type;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.more.apples.MoreThanApples;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodVariants;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;
import net.more.apples.entity.AppleBlockEntity;

import java.util.function.Function;

public class AppleShelfEntityType {
    public static final BlockEntityType<AppleBlockEntity> APPLE_SHELF_ENTITY_TYPE =
            Registry.register(
                    BuiltInRegistries.BLOCK_ENTITY_TYPE,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_entity_shelf"),
                    FabricBlockEntityTypeBuilder
                            //.create(AppleBlockEntity::new, ModBlocks2.APPLE_SHELF)
                            .create(AppleBlockEntity::new,
                                    AppleWoodVariants.APPLE_SHELF,
                                    TestAppleWoodVariants.TEST_APPLE_SHELF,
                                    FrostyAppleWoodVariants.FROSTY_APPLE_SHELF,
                                    AncientAppleWoodVariants.ANCIENT_APPLE_SHELF)
                            .build());


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

    public static void registerAppleEntityType() {
        MoreThanApples.LOGGER.info("Registering Mod Blocks " + MoreThanApples.MOD_ID);
    }
}
