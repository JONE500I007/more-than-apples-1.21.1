package net.more.apples.world.tree.custom.ancient_apple.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.more.apples.MoreThanApples;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;

public class AncientBlockEntities {
    public static BlockEntityType<AncientAppleTreeGeneratorBlockEntity> ANCIENT_APPLE_TREE_GENERATOR;

    public static void register() {
        ANCIENT_APPLE_TREE_GENERATOR = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "ancient_apple_tree_generator"),
                FabricBlockEntityTypeBuilder
                        .create(AncientAppleTreeGeneratorBlockEntity::new,
                                AncientAppleWoodBlocks.ANCIENT_APPLE_TREE_GENERATOR)
                        .build());
    }
}
