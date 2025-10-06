package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.more.apples.block.ModBlocks;
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
//        blockStateModelGenerator.registerSingleton(
//                ModBlocks.DIAMOND_APPLE_BLOCK,
//                TexturedModel.CUBE_BOTTOM_TOP.andThen((map) -> {
//                    map.put(TextureKey.TOP, TextureMap.getSubId(ModBlocks.DIAMOND_APPLE_BLOCK, "_top"));
//                    map.put(TextureKey.BOTTOM, TextureMap.getSubId(ModBlocks.DIAMOND_APPLE_BLOCK, "_bottom"));
//                    map.put(TextureKey.SIDE, TextureMap.getSubId(ModBlocks.DIAMOND_APPLE_BLOCK, ""));
//                }));


        BlockStateModelGenerator.BlockTexturePool appleGarnetPool = blockStateModelGenerator
                .registerCubeAllModelTexturePool(ModBlocks2.APPLE_PLANKS);

        appleGarnetPool.stairs(ModBlocks2.APPLE_STAIRS);
        appleGarnetPool.slab(ModBlocks2.APPLE_SLAB);

        appleGarnetPool.button(ModBlocks2.APPLE_BUTTON);
        appleGarnetPool.pressurePlate(ModBlocks2.APPLE_PRESSURE_PLATE);

        appleGarnetPool.fence(ModBlocks2.APPLE_FENCE);
        appleGarnetPool.fenceGate(ModBlocks2.APPLE_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks2.APPLE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks2.APPLE_TRAPDOOR);


        BlockStateModelGenerator.BlockTexturePool testAppleGarnetPool = blockStateModelGenerator
                .registerCubeAllModelTexturePool(ModBlocks2.TEST_APPLE_PLANKS);

        testAppleGarnetPool.stairs(ModBlocks2.TEST_APPLE_STAIRS);
        testAppleGarnetPool.slab(ModBlocks2.TEST_APPLE_SLAB);

        testAppleGarnetPool.button(ModBlocks2.TEST_APPLE_BUTTON);
        testAppleGarnetPool.pressurePlate(ModBlocks2.TEST_APPLE_PRESSURE_PLATE);

        testAppleGarnetPool.fence(ModBlocks2.TEST_APPLE_FENCE);
        testAppleGarnetPool.fenceGate(ModBlocks2.TEST_APPLE_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks2.TEST_APPLE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks2.TEST_APPLE_TRAPDOOR);


        blockStateModelGenerator.registerLog(ModBlocks2.APPLE_LOG).log(ModBlocks2.APPLE_LOG).wood(ModBlocks2.APPLE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks2.STRIPPED_APPLE_LOG).log(ModBlocks2.STRIPPED_APPLE_LOG).wood(ModBlocks2.STRIPPED_APPLE_WOOD);
        //blockStateModelGenerator.registerSingleton(ModBlocks2.APPLE_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks2.APPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks2.GOLDEN_APPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerLog(ModBlocks2.TEST_APPLE_LOG).log(ModBlocks2.TEST_APPLE_LOG).wood(ModBlocks2.TEST_APPLE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks2.TEST_STRIPPED_APPLE_LOG).log(ModBlocks2.TEST_STRIPPED_APPLE_LOG).wood(ModBlocks2.TEST_STRIPPED_APPLE_WOOD);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks2.TEST_APPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);


        blockStateModelGenerator.registerSingleton(
        ModBlocks2.APPLE_BARREL,
        TexturedModel.CUBE_BOTTOM_TOP.andThen((map) -> {
            map.put(TextureKey.TOP, TextureMap.getSubId(ModBlocks2.APPLE_BARREL, "_top"));
            map.put(TextureKey.BOTTOM, TextureMap.getSubId(ModBlocks2.APPLE_BARREL, "_bottom"));
            map.put(TextureKey.SIDE, TextureMap.getSubId(ModBlocks2.APPLE_BARREL, ""));
        }));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //itemModelGenerator.register(ModItems.DIAMOND_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GREEN_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TEST_APPLE, Models.GENERATED);

        itemModelGenerator.register(ModBlocks2.APPLE_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks2.TEST_APPLE_SAPLING.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks2.GOLDEN_APPLE_SAPLING.asItem(), Models.GENERATED);

    }
}
