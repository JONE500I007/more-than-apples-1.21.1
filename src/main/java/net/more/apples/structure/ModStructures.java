package net.more.apples.structure;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.more.apples.MoreThanApples;

import java.util.Map;
import java.util.Optional;

public class ModStructures {

    public static final ResourceKey<Structure> JUST_TEST = ResourceKey.create(
            Registries.STRUCTURE,
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "just_test"));

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
    }
}
