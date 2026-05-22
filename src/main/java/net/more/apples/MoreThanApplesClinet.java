package net.more.apples;

import com.terraformersmc.terraform.boat.api.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.more.apples.block.custom.FoliageTintSource;
import net.more.apples.block.wood_type.AppleShelfEntityType;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.entity.ModBoats;
import net.more.apples.particle.LeavesTestParticle;
import net.more.apples.particle.ModParticle;
import net.more.apples.render.AppleShelfRenderer;

import java.util.List;

public class MoreThanApplesClinet implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockColorRegistry.register(List.of(new FoliageTintSource()),
                AppleWoodBlocks.APPLE_LEAVES,
                AppleWoodBlocks.FRUIT_APPLE_LEAVES,
                AppleWoodBlocks.GOLDEN_APPLE_LEAVES,
                AppleWoodBlocks.FRUIT_GOLDEN_APPLE_LEAVES,

                AncientAppleWoodBlocks.ANCIENT_APPLE_LEAVES,
                AncientAppleWoodBlocks.APPLE_LEAF_LITTER);

        BlockEntityRenderers.register(AppleShelfEntityType.APPLE_SHELF_ENTITY_TYPE, AppleShelfRenderer::new);

        TerraformBoatClientHelper.registerModelLayers(ModBoats.APPLE_BOAT_ID);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.TEST_APPLE_BOAT_ID);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.FROSTY_APPLE_BOAT_ID);
        TerraformBoatClientHelper.registerModelLayers(ModBoats.ANCIENT_APPLE_BOAT_ID);

        ParticleProviderRegistry.getInstance().register(ModParticle.TEST_LEAVES_PARTICLE, LeavesTestParticle.Factory::new);

    }
}
