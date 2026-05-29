package net.more.apples.structure.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.alias.PoolAliasLookup;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.more.apples.MoreThanApples;

import java.util.Optional;

public class DngRoomStructure extends Structure {

    public static final MapCodec<DngRoomStructure> CODEC = simpleCodec(DngRoomStructure::new);

    public DngRoomStructure(StructureSettings settings) {
        super(settings);
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
                        .getOrThrow(ResourceKey.create(Registries.TEMPLATE_POOL,
                                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "dng_room/start_pool"))),
                Optional.empty(),
                3,
                startPos,
                false,
                Optional.of(Heightmap.Types.WORLD_SURFACE_WG),
                new JigsawStructure.MaxDistance(80, 80),
                PoolAliasLookup.EMPTY,
                JigsawStructure.DEFAULT_DIMENSION_PADDING,
                JigsawStructure.DEFAULT_LIQUID_SETTINGS,
                Rotation.NONE
        );
    }

    @Override
    public StructureType<?> type() {
        return ModStructureTypes.DNG_ROOM;
    }
}
