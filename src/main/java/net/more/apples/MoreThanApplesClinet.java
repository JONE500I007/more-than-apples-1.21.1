package net.more.apples;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.world.biome.FoliageColors;
import net.more.apples.block.ModBlocks2;
import net.more.apples.particle.ModParticle;
import net.more.apples.particle.LeavesTestParticle;

public class MoreThanApplesClinet implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        //make leaves can color by map
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            return world != null && pos != null
                    ? BiomeColors.getFoliageColor(world, pos)
                    : FoliageColors.DEFAULT;
        }, ModBlocks2.APPLE_LEAVES,
                ModBlocks2.FRUIT_APPLE_LEAVES,

                ModBlocks2.GOLDEN_APPLE_LEAVES,
                ModBlocks2.FRUIT_GOLDEN_APPLE_LEAVES);

        // man... just use items i mean in .json
        /*
        ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
                FoliageColors.DEFAULT,
                ModBlocks2.APPLE_LEAVES,
                ModBlocks2.FRUIT_APPLE_LEAVES,

                ModBlocks2.GOLDEN_APPLE_LEAVES,
                ModBlocks2.FRUIT_GOLDEN_APPLE_LEAVES);
         */


        BlockRenderLayerMap.putBlock(ModBlocks2.APPLE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks2.FRUIT_APPLE_LEAVES, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks2.APPLE_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks2.APPLE_TRAPDOOR, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks2.GOLDEN_APPLE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks2.FRUIT_GOLDEN_APPLE_LEAVES, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks2.TEST_APPLE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks2.TEST_APPLE_LEAVES, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks2.TEST_APPLE_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks2.TEST_APPLE_TRAPDOOR, BlockRenderLayer.CUTOUT);

        ParticleFactoryRegistry.getInstance().register(ModParticle.TEST_LEAVES_PARTICLE, LeavesTestParticle.Factory::new);
    }
}
