package net.more.apples.datagen.model.test_apple;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.more.apples.block.general_block.ModGeneralBlock;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;

public class TestAppleModelBlocks extends FabricModelProvider {
    public TestAppleModelBlocks(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

        BlockModelGenerators.BlockFamilyProvider appleGarnetPool =
                blockModelGenerators.family(TestAppleWoodBlocks.TEST_APPLE_PLANKS);

        appleGarnetPool.stairs(TestAppleWoodVariants.TEST_APPLE_STAIRS);
        appleGarnetPool.slab(TestAppleWoodVariants.TEST_APPLE_SLAB);

        appleGarnetPool.button(TestAppleWoodVariants.TEST_APPLE_BUTTON);
        appleGarnetPool.pressurePlate(TestAppleWoodVariants.TEST_APPLE_PRESSURE_PLATE);

        appleGarnetPool.fence(TestAppleWoodVariants.TEST_APPLE_FENCE);
        appleGarnetPool.fenceGate(TestAppleWoodVariants.TEST_APPLE_FENCE_GATE);

        blockModelGenerators.createDoor(TestAppleWoodVariants.TEST_APPLE_DOOR);
        blockModelGenerators.createTrapdoor(TestAppleWoodVariants.TEST_APPLE_TRAPDOOR);

        blockModelGenerators.createParticleOnlyBlock(
                TestAppleWoodVariants.TEST_APPLE_STANDING_SIGN,
                TestAppleWoodBlocks.TEST_APPLE_PLANKS
        );
        blockModelGenerators.createParticleOnlyBlock(
                TestAppleWoodVariants.TEST_APPLE_WALL_SIGN,
                TestAppleWoodBlocks.TEST_APPLE_PLANKS
        );

        blockModelGenerators.createHangingSign(
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG,
                TestAppleWoodVariants.TEST_APPLE_HANGING_SIGN_BLOCK,
                TestAppleWoodVariants.TEST_APPLE_WALL_HANGING_SIGN
        );

        blockModelGenerators.woodProvider(TestAppleWoodBlocks.TEST_APPLE_LOG)
                .log(TestAppleWoodBlocks.TEST_APPLE_LOG)
                .wood(TestAppleWoodBlocks.TEST_APPLE_WOOD);
        blockModelGenerators.woodProvider(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG)
                .log(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG)
                .wood(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD);

        blockModelGenerators.createShelf(TestAppleWoodVariants.TEST_APPLE_SHELF, TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG);

        blockModelGenerators.createCrossBlock(TestAppleWoodBlocks.TEST_APPLE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }
}
