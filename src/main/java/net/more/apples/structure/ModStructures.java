package net.more.apples.structure;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.more.apples.MoreThanApples;
import net.more.apples.structure.custom.ModFixedStructure;

public class ModStructures {

    public static final ResourceKey<Structure> JUST_TEST = ResourceKey.create(
            Registries.STRUCTURE,
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "just_test"));
    public static final ResourceKey<Structure> TEST_DUNGEON = ResourceKey.create(
            Registries.STRUCTURE,
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_dungeon"));
    public static final ResourceKey<Structure> DNG_ROOM = ResourceKey.create(
            Registries.STRUCTURE,
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "dng_room"));
    public static final ResourceKey<Structure> TOWER_ROOM = ResourceKey.create(
            Registries.STRUCTURE,
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "tower_room"));

    public static void bootstrap(BootstrapContext<Structure> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);

        context.register(JUST_TEST, new JigsawStructure(
                new Structure.StructureSettings.Builder(
                        biomes.getOrThrow(TagKey.create(Registries.BIOME,
                                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                                        "has_structure/just_test")))
                )
                        .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                        .terrainAdapation(TerrainAdjustment.BEARD_THIN)
                        .build(),
                pools.getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL,
                        Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                                "just_test/start_pool"))),
                1,                                          // maxDepth
                ConstantHeight.of(VerticalAnchor.absolute(1)), // startHeight
                false,                                      // useExpansionHack
                Heightmap.Types.WORLD_SURFACE_WG            // projectStartToHeightmap
        ));



        context.register(TEST_DUNGEON, new JigsawStructure(
                new Structure.StructureSettings.Builder(
                        biomes.getOrThrow(TagKey.create(Registries.BIOME,
                                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                                        "has_structure/test_dungeon")))
                )
                        .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                        .terrainAdapation(TerrainAdjustment.BEARD_THIN)
                        .build(),
                pools.getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL,
                        Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                                "test_dungeon/start"))),
                3,
                ConstantHeight.of(VerticalAnchor.absolute(1)),
                false,
                Heightmap.Types.WORLD_SURFACE_WG
        ));


//        context.register(DNG_ROOM, new JigsawStructure(
//                new Structure.StructureSettings.Builder(
//                        biomes.getOrThrow(TagKey.create(Registries.BIOME,
//                                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
//                                        "has_structure/dng_room")))
//                )
//                        .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
//                        .terrainAdapation(TerrainAdjustment.BEARD_THIN)
//                        .build(),
//                pools.getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL,
//                        Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
//                                "dng_room/start_pool"))),
//                4,                                          // maxDepth
//                ConstantHeight.of(VerticalAnchor.absolute(1)), // startHeight
//                false,                                      // useExpansionHack
//                Heightmap.Types.WORLD_SURFACE_WG            // projectStartToHeightmap
//        ));
        context.register(DNG_ROOM, new ModFixedStructure(
                new Structure.StructureSettings.Builder(
                        biomes.getOrThrow(TagKey.create(Registries.BIOME,
                                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                                        "has_structure/dng_room")))
                )
                        .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                        .terrainAdapation(TerrainAdjustment.BEARD_THIN)
                        .build(),
                ResourceKey.create(Registries.TEMPLATE_POOL,
                        Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "dng_room/start_pool")),
                4,
                Rotation.NONE
        ));


//        context.register(TOWER_ROOM, new JigsawStructure(
//                new Structure.StructureSettings.Builder(
//                        biomes.getOrThrow(TagKey.create(Registries.BIOME,
//                                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
//                                        "has_structure/tower_room")))
//                )
//                        .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
//                        .terrainAdapation(TerrainAdjustment.BEARD_THIN)
//                        .build(),
//                pools.getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL,
//                        Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
//                                "tower_room/start_pool"))),
//                2,                                          // maxDepth
//                ConstantHeight.of(VerticalAnchor.absolute(1)), // startHeight
//                false,                                      // useExpansionHack
//                Heightmap.Types.WORLD_SURFACE_WG            // projectStartToHeightmap
//        ));


        context.register(TOWER_ROOM, new ModFixedStructure(
                new Structure.StructureSettings.Builder(
                        biomes.getOrThrow(TagKey.create(Registries.BIOME,
                                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID,
                                        "has_structure/tower_room")))
                )
                        .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                        .terrainAdapation(TerrainAdjustment.BEARD_THIN)
                        .build(),
                ResourceKey.create(Registries.TEMPLATE_POOL,
                        Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "tower_room/start_pool")),
                2,
                Rotation.NONE
        ));
    }
}
