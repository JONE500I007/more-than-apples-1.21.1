package net.more.apples;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.world.biome.FoliageColors;
import net.more.apples.block.ModBlocks2;

public class MoreThanApplesClinet implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        //make leaves can color by map
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            return world != null && pos != null
                    ? BiomeColors.getFoliageColor(world, pos)
                    : FoliageColors.getDefaultColor();
        }, ModBlocks2.APPLE_LEAVES,
                ModBlocks2.FRUIT_APPLE_LEAVES);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) ->
                FoliageColors.getDefaultColor(),
                ModBlocks2.APPLE_LEAVES,
                ModBlocks2.FRUIT_APPLE_LEAVES);


        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks2.APPLE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks2.FRUIT_APPLE_LEAVES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks2.APPLE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks2.APPLE_TRAPDOOR, RenderLayer.getCutout());
    }
}
