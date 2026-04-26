package net.more.apples;

import com.terraformersmc.terraform.boat.api.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.more.apples.block.ModBlocks2;
import net.more.apples.custom_folicolor.FoliageTintSource;
import net.more.apples.entity.ModBoats;

import net.more.apples.particle.LeavesTestParticle;
import net.more.apples.particle.ModParticle;
import net.more.apples.render.AppleShelfRenderer;

import java.util.List;

public class MoreThanApplesClinet implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        //make leaves can color by map
//        List<BlockTintSource> foliageTint = List.of(new FoliageTintSource());
//        BlockColorRegistry.register(foliageTint,
//                ModBlocks2.APPLE_LEAVES,
//                ModBlocks2.FRUIT_APPLE_LEAVES,
//                ModBlocks2.GOLDEN_APPLE_LEAVES,
//                ModBlocks2.FRUIT_GOLDEN_APPLE_LEAVES);

        BlockColorRegistry.register(List.of(new FoliageTintSource()),
                ModBlocks2.APPLE_LEAVES,
                ModBlocks2.FRUIT_APPLE_LEAVES,
                ModBlocks2.GOLDEN_APPLE_LEAVES,
                ModBlocks2.FRUIT_GOLDEN_APPLE_LEAVES);


        /*
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

        BlockRenderLayerMap.putBlock(ModBlocks2.FROSTY_APPLE_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks2.FROSTY_APPLE_LEAVES, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks2.FROSTY_APPLE_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks2.FROSTY_APPLE_TRAPDOOR, BlockRenderLayer.CUTOUT);
         */

        //BlockEntityRendererFactories.register(BlockEntityType.SIGN, SignBlockEntityRenderer::new);

        BlockEntityRenderers.register(ModBlocks2.APPLE_SHELF_ENTITY_TYPE, AppleShelfRenderer::new);

        //SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks2.APPLE_SIGN_TEXTURE));
        //SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks2.APPLE_HANGING_SIGN_TEXTURE));

        TerraformBoatClientHelper.registerModelLayers(ModBoats.APPLE_BOAT_ID);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.TEST_APPLE_BOAT_ID);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.FROSTY_APPLE_BOAT_ID);

        ParticleProviderRegistry.getInstance().register(ModParticle.TEST_LEAVES_PARTICLE, LeavesTestParticle.Factory::new);
    }
}
