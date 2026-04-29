package net.more.apples.datagen.model.apple;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.more.apples.block.general_block.ModGeneralBlock;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;

public class AppleModelBlocks extends FabricModelProvider {
    public AppleModelBlocks(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

        BlockModelGenerators.BlockFamilyProvider appleGarnetPool =
                blockModelGenerators.family(AppleWoodBlocks.APPLE_PLANKS);

        appleGarnetPool.stairs(AppleWoodVariants.APPLE_STAIRS);
        appleGarnetPool.slab(AppleWoodVariants.APPLE_SLAB);

        appleGarnetPool.button(AppleWoodVariants.APPLE_BUTTON);
        appleGarnetPool.pressurePlate(AppleWoodVariants.APPLE_PRESSURE_PLATE);

        appleGarnetPool.fence(AppleWoodVariants.APPLE_FENCE);
        appleGarnetPool.fenceGate(AppleWoodVariants.APPLE_FENCE_GATE);

        blockModelGenerators.createDoor(AppleWoodVariants.APPLE_DOOR);
        blockModelGenerators.createTrapdoor(AppleWoodVariants.APPLE_TRAPDOOR);

        blockModelGenerators.createParticleOnlyBlock(
                AppleWoodVariants.APPLE_STANDING_SIGN,
                AppleWoodBlocks.APPLE_PLANKS
        );
        blockModelGenerators.createParticleOnlyBlock(
                AppleWoodVariants.APPLE_WALL_SIGN,
                AppleWoodBlocks.APPLE_PLANKS
        );

        blockModelGenerators.createHangingSign(
                AppleWoodBlocks.STRIPPED_APPLE_LOG,
                AppleWoodVariants.APPLE_HANGING_SIGN_BLOCK,
                AppleWoodVariants.APPLE_WALL_HANGING_SIGN
        );

        blockModelGenerators.woodProvider(AppleWoodBlocks.APPLE_LOG)
                .log(AppleWoodBlocks.APPLE_LOG)
                .wood(AppleWoodBlocks.APPLE_WOOD);
        blockModelGenerators.woodProvider(AppleWoodBlocks.STRIPPED_APPLE_LOG)
                .log(AppleWoodBlocks.STRIPPED_APPLE_LOG)
                .wood(AppleWoodBlocks.STRIPPED_APPLE_WOOD);

        blockModelGenerators.createShelf(AppleWoodVariants.APPLE_SHELF, AppleWoodBlocks.STRIPPED_APPLE_LOG);

        blockModelGenerators.createCrossBlock(AppleWoodBlocks.APPLE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
        blockModelGenerators.createCrossBlock(AppleWoodBlocks.GOLDEN_APPLE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);


        blockModelGenerators.createTrivialBlock(
                ModGeneralBlock.APPLE_BARREL,
                TexturedModel.CUBE_TOP_BOTTOM.updateTexture((map) -> {
                    map.put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModGeneralBlock.APPLE_BARREL, "_top"));
                    map.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModGeneralBlock.APPLE_BARREL, "_bottom"));
                    map.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModGeneralBlock.APPLE_BARREL, ""));
                }));
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }
}
