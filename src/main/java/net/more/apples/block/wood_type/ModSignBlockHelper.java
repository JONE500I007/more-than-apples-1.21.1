package net.more.apples.block.wood_type;

import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public final class ModSignBlockHelper {
    private static final Map<Identifier, WoodType> WOOD_TYPE_CACHE = new ConcurrentHashMap<>();

    private ModSignBlockHelper() {
    }

    public static <T extends SignBlock> T registerSignBlock(ResourceKey<Block> key, T block) {
        if (block instanceof StandingSignBlock || block instanceof WallSignBlock) {
            BlockEntityTypes.SIGN.addValidBlock(block);
        } else if (block instanceof CeilingHangingSignBlock || block instanceof WallHangingSignBlock) {
            BlockEntityTypes.HANGING_SIGN.addValidBlock(block);
        } else {
            throw new IllegalArgumentException("This method only accepts vanilla sign blocks and descendants!");
        }

        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }

    public static <T extends SignBlock> T registerSignBlock(
            Identifier id, Function<BlockBehaviour.Properties, T> factory, BlockBehaviour.Properties properties) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, id);
        return registerSignBlock(key, factory.apply(properties.setId(key)));
    }

    public static WoodType registerDefaultWoodType(Identifier typeId) {
        return WOOD_TYPE_CACHE.computeIfAbsent(typeId,
                id -> WoodTypeBuilder.copyOf(WoodType.OAK)
                        .register(id, BlockSetTypeBuilder.copyOf(BlockSetType.OAK).register(id)));
    }
}