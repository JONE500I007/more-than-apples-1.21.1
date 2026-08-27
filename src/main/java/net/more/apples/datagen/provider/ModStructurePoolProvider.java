package net.more.apples.datagen.provider;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.more.apples.MoreThanApples;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModStructurePoolProvider {
    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

        context.register(
                ResourceKey.create(Registries.TEMPLATE_POOL,
                        Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                                "just_test/start_pool")),
                new StructureTemplatePool(
                        pools.getOrThrow(Pools.EMPTY),
                        List.of(
                                new com.mojang.datafixers.util.Pair<>(
                                        StructurePoolElement.single(
                                                MoreThanApples.MOD_ID + ":just_test"
                                        ).apply(StructureTemplatePool.Projection.RIGID),
                                        1
                                )
                        )
                )
        );


        // start pool
        context.register(
                ResourceKey.create(Registries.TEMPLATE_POOL,
                        Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_dungeon/start")),
                new StructureTemplatePool(
                        pools.getOrThrow(Pools.EMPTY),
                        List.of(new Pair<>(
                                StructurePoolElement.single("more-than-apples:test_room1")
                                        .apply(StructureTemplatePool.Projection.RIGID), 1))
                )
        );

        // rooms pool
        context.register(
                ResourceKey.create(Registries.TEMPLATE_POOL,
                        Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_dungeon/rooms")),
                new StructureTemplatePool(
                        pools.getOrThrow(Pools.EMPTY),
                        List.of(
                                new Pair<>(StructurePoolElement.single("more-than-apples:test_room2")
                                        .apply(StructureTemplatePool.Projection.RIGID), 1),
                                new Pair<>(StructurePoolElement.single("more-than-apples:test_room3")
                                        .apply(StructureTemplatePool.Projection.RIGID), 1)
                        )
                )
        );


        // start pool
        context.register(
                ResourceKey.create(Registries.TEMPLATE_POOL,
                        Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "dng_room/start_pool")),
                new StructureTemplatePool(
                        pools.getOrThrow(Pools.EMPTY),
                        List.of(new Pair<>(
                                StructurePoolElement.single(MoreThanApples.MOD_ID + ":dng_room_start")
                                        .apply(StructureTemplatePool.Projection.RIGID), 1))
                )
        );

        // rooms pool
        context.register(
                ResourceKey.create(Registries.TEMPLATE_POOL,
                        Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "dng_room/rooms")),
                new StructureTemplatePool(
                        pools.getOrThrow(Pools.EMPTY),
                        List.of(
                                new Pair<>(StructurePoolElement.single(MoreThanApples.MOD_ID + ":dng_room1")
                                        .apply(StructureTemplatePool.Projection.RIGID), 1),
                                new Pair<>(StructurePoolElement.single(MoreThanApples.MOD_ID + ":dng_room2")
                                        .apply(StructureTemplatePool.Projection.RIGID), 1),
                                new Pair<>(StructurePoolElement.single(MoreThanApples.MOD_ID + ":dng_room3")
                                        .apply(StructureTemplatePool.Projection.RIGID), 1),
                                new Pair<>(StructurePoolElement.single(MoreThanApples.MOD_ID + ":dng_room4")
                                        .apply(StructureTemplatePool.Projection.RIGID), 1)
                        )
                )
        );


        // start pool
        context.register(
                ResourceKey.create(Registries.TEMPLATE_POOL,
                        Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "tower_room/start_pool")),
                new StructureTemplatePool(
                        pools.getOrThrow(Pools.EMPTY),
                        List.of(new Pair<>(
                                StructurePoolElement.single(MoreThanApples.MOD_ID + ":tower_room_start")
                                        .apply(StructureTemplatePool.Projection.RIGID), 1))
                )
        );

        // rooms pool
        context.register(
                ResourceKey.create(Registries.TEMPLATE_POOL,
                        Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "tower_room/tower")),
                new StructureTemplatePool(
                        pools.getOrThrow(Pools.EMPTY),
                        List.of(
                                new Pair<>(StructurePoolElement.single(MoreThanApples.MOD_ID + ":tower_room1")
                                        .apply(StructureTemplatePool.Projection.RIGID), 1),
                                new Pair<>(StructurePoolElement.single(MoreThanApples.MOD_ID + ":tower_room2")
                                        .apply(StructureTemplatePool.Projection.RIGID), 1),
                                new Pair<>(StructurePoolElement.single(MoreThanApples.MOD_ID + ":tower_room_end")
                                        .apply(StructureTemplatePool.Projection.RIGID), 2)
                        )
                )
        );

        context.register(
                ResourceKey.create(Registries.TEMPLATE_POOL,
                        Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "badlands_hideout")),
                new StructureTemplatePool(
                        pools.getOrThrow(Pools.EMPTY),
                        List.of(new Pair<>(
                                StructurePoolElement.single(MoreThanApples.MOD_ID + ":badlands_hideout")
                                        .apply(StructureTemplatePool.Projection.RIGID), 1))
                )
        );
    }
}
