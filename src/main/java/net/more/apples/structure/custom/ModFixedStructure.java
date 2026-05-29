package net.more.apples.structure.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.pools.alias.PoolAliasLookup;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.more.apples.MoreThanApples;

import java.util.Optional;

public class ModFixedStructure extends Structure {

    private final ResourceKey<StructureTemplatePool> startPool;
    private final int maxDepth;
    private final Rotation rotation;

    public static final MapCodec<ModFixedStructure> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Structure.settingsCodec(instance),
                    ResourceKey.codec(Registries.TEMPLATE_POOL)
                            .fieldOf("start_pool")
                            .forGetter(s -> s.startPool),
                    Codec.intRange(0, 20)
                            .fieldOf("max_depth")
                            .forGetter(s -> s.maxDepth),
                    Rotation.CODEC
                            .optionalFieldOf("rotation", Rotation.NONE)
                            .forGetter(s -> s.rotation)
            ).apply(instance, ModFixedStructure::new));

    public ModFixedStructure(StructureSettings settings,
                             ResourceKey<StructureTemplatePool> startPool,
                             int maxDepth,
                             Rotation rotation) {
        super(settings);
        this.startPool = startPool;
        this.maxDepth = maxDepth;
        this.rotation = rotation;
    }

    @Override
    protected Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        ChunkPos chunkPos = context.chunkPos();
        BlockPos startPos = new BlockPos(
                chunkPos.getMiddleBlockX(),
                0,
                chunkPos.getMiddleBlockZ()
        );

        return ModJigsawPlacement.addPieces(
                context,
                context.registryAccess()
                        .lookupOrThrow(Registries.TEMPLATE_POOL)
                        .getOrThrow(startPool),
                Optional.empty(),
                maxDepth,
                startPos,
                false,
                Optional.of(Heightmap.Types.WORLD_SURFACE_WG),
                new JigsawStructure.MaxDistance(80, 80),
                PoolAliasLookup.EMPTY,
                JigsawStructure.DEFAULT_DIMENSION_PADDING,
                JigsawStructure.DEFAULT_LIQUID_SETTINGS,
                rotation
        );
    }

    @Override
    public StructureType<?> type() {
        return ModStructureTypes.FIXED_STRUCTURE;
    }
}
