package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.more.apples.block.ModBlocks2;
import net.more.apples.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //all model blockstate block and item man...
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks2.APPLE_ORE);
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks2.APPLE_PLANKS);
        BlockStateModelGenerator.BlockTexturePool appleGarnetPool = blockStateModelGenerator
                .registerCubeAllModelTexturePool(ModBlocks2.APPLE_PLANKS);

        appleGarnetPool.stairs(ModBlocks2.APPLE_STAIRS);
        appleGarnetPool.slab(ModBlocks2.APPLE_SLAB);

        appleGarnetPool.button(ModBlocks2.APPLE_BUTTON);
        appleGarnetPool.pressurePlate(ModBlocks2.APPLE_PRESSURE_PLATE);

        appleGarnetPool.fence(ModBlocks2.APPLE_FENCE);
        appleGarnetPool.fenceGate(ModBlocks2.APPLE_FENCE_GATE);
//        appleGarnetPool.wall(ModBlocks2.APPLE_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks2.APPLE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks2.APPLE_TRAPDOOR);

        blockStateModelGenerator.registerLog(ModBlocks2.APPLE_LOG).log(ModBlocks2.APPLE_LOG).wood(ModBlocks2.APPLE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks2.STRIPPED_APPLE_LOG).log(ModBlocks2.STRIPPED_APPLE_LOG).wood(ModBlocks2.STRIPPED_APPLE_WOOD);
        //blockStateModelGenerator.registerSingleton(ModBlocks2.APPLE_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks2.APPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //itemModelGenerator.register(ModItems.DIAMOND_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModBlocks2.APPLE_SAPLING.asItem(), Models.GENERATED);

    }
}
