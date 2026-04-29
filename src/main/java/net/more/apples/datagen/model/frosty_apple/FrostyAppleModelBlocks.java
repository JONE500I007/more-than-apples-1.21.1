package net.more.apples.datagen.model.frosty_apple;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;

public class FrostyAppleModelBlocks extends FabricModelProvider {
    public FrostyAppleModelBlocks(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

        BlockModelGenerators.BlockFamilyProvider appleGarnetPool =
                blockModelGenerators.family(FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS);

        appleGarnetPool.stairs(FrostyAppleWoodVariants.FROSTY_APPLE_STAIRS);
        appleGarnetPool.slab(FrostyAppleWoodVariants.FROSTY_APPLE_SLAB);

        appleGarnetPool.button(FrostyAppleWoodVariants.FROSTY_APPLE_BUTTON);
        appleGarnetPool.pressurePlate(FrostyAppleWoodVariants.FROSTY_APPLE_PRESSURE_PLATE);

        appleGarnetPool.fence(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE);
        appleGarnetPool.fenceGate(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE);

        blockModelGenerators.createDoor(FrostyAppleWoodVariants.FROSTY_APPLE_DOOR);
        blockModelGenerators.createTrapdoor(FrostyAppleWoodVariants.FROSTY_APPLE_TRAPDOOR);

        blockModelGenerators.createParticleOnlyBlock(
                FrostyAppleWoodVariants.FROSTY_APPLE_STANDING_SIGN,
                FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS
        );
        blockModelGenerators.createParticleOnlyBlock(
                FrostyAppleWoodVariants.FROSTY_APPLE_WALL_SIGN,
                FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS
        );

        blockModelGenerators.createHangingSign(
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG,
                FrostyAppleWoodVariants.FROSTY_APPLE_HANGING_SIGN_BLOCK,
                FrostyAppleWoodVariants.FROSTY_APPLE_WALL_HANGING_SIGN
        );

        blockModelGenerators.woodProvider(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG)
                .log(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG)
                .wood(FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD);
        blockModelGenerators.woodProvider(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG)
                .log(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG)
                .wood(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD);

        blockModelGenerators.createShelf(FrostyAppleWoodVariants.FROSTY_APPLE_SHELF, FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG);

        blockModelGenerators.createCrossBlock(FrostyAppleWoodBlocks.FROSTY_APPLE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }
}
