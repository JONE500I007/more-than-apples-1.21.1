package net.more.apples.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.more.apples.block.ModBlocks2;
import net.more.apples.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
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

        blockModelGenerators.createTrivialCube(ModBlocks2.APPLE_PLANKS);
        BlockModelGenerators.BlockFamilyProvider appleGarnetPool =
                blockModelGenerators.family(ModBlocks2.APPLE_PLANKS);

        appleGarnetPool.stairs(ModBlocks2.APPLE_STAIRS);
        appleGarnetPool.slab(ModBlocks2.APPLE_SLAB);

        appleGarnetPool.button(ModBlocks2.APPLE_BUTTON);
        appleGarnetPool.pressurePlate(ModBlocks2.APPLE_PRESSURE_PLATE);

        appleGarnetPool.fence(ModBlocks2.APPLE_FENCE);
        appleGarnetPool.fenceGate(ModBlocks2.APPLE_FENCE_GATE);

        blockModelGenerators.createDoor(ModBlocks2.APPLE_DOOR);
        blockModelGenerators.createTrapdoor(ModBlocks2.APPLE_TRAPDOOR);

//        Identifier appleSignModel = Models.PARTICLE.upload(
//                ModBlocks2.APPLE_STANDING_SIGN,
//                new TextureMap().put(TextureKey.PARTICLE, TextureMap.getId(ModBlocks2.APPLE_PLANKS)),
//                blockStateModelGenerator.modelCollector
//        );

        /*
        Identifier appleSignModel = Models.GENERATED.upload(
                ModBlocks2.APPLE_STANDING_SIGN,
                new TextureMap().put(TextureKey.LAYER0, TextureMap.getId(ModBlocks2.APPLE_PLANKS)),
                blockStateModelGenerator.modelCollector
        );
        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createSingletonBlockState(ModBlocks2.APPLE_STANDING_SIGN, appleSignModel)
        );
        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createSingletonBlockState(ModBlocks2.APPLE_WALL_SIGN, appleSignModel)
        );
         */
        blockModelGenerators.createParticleOnlyBlock(
                ModBlocks2.APPLE_STANDING_SIGN,
                ModBlocks2.APPLE_PLANKS
        );
        blockModelGenerators.createParticleOnlyBlock(
                ModBlocks2.APPLE_WALL_SIGN,
                ModBlocks2.APPLE_PLANKS
        );

        /*
        Identifier testAppleSignModel = Models.GENERATED.upload(
                ModBlocks2.TEST_APPLE_STANDING_SIGN,
                new TextureMap().put(TextureKey.LAYER0, TextureMap.getId(ModBlocks2.TEST_APPLE_PLANKS)),
                blockStateModelGenerator.modelCollector
        );
        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createSingletonBlockState(ModBlocks2.TEST_APPLE_STANDING_SIGN, testAppleSignModel)
        );
        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createSingletonBlockState(ModBlocks2.TEST_APPLE_WALL_SIGN, testAppleSignModel)
        );
         */
        blockModelGenerators.createParticleOnlyBlock(
                ModBlocks2.TEST_APPLE_STANDING_SIGN,
                ModBlocks2.TEST_APPLE_PLANKS
        );
        blockModelGenerators.createParticleOnlyBlock(
                ModBlocks2.TEST_APPLE_WALL_SIGN,
                ModBlocks2.TEST_APPLE_PLANKS
        );

        blockModelGenerators.createHangingSign(
                ModBlocks2.STRIPPED_APPLE_LOG,
                ModBlocks2.APPLE_HANGING_SIGN_BLOCK,
                ModBlocks2.APPLE_WALL_HANGING_SIGN
        );

        blockModelGenerators.createHangingSign(
                ModBlocks2.STRIPPED_TEST_APPLE_LOG,
                ModBlocks2.TEST_APPLE_HANGING_SIGN_BLOCK,
                ModBlocks2.TEST_APPLE_WALL_HANGING_SIGN
        );

        //appleGarnetPool.family(ModBlocks2.THE_APPLE_FAMILY);


        blockModelGenerators.createTrivialCube(ModBlocks2.TEST_APPLE_PLANKS);
        BlockModelGenerators.BlockFamilyProvider testAppleGarnetPool = blockModelGenerators
                .family(ModBlocks2.TEST_APPLE_PLANKS);

        testAppleGarnetPool.stairs(ModBlocks2.TEST_APPLE_STAIRS);
        testAppleGarnetPool.slab(ModBlocks2.TEST_APPLE_SLAB);

        testAppleGarnetPool.button(ModBlocks2.TEST_APPLE_BUTTON);
        testAppleGarnetPool.pressurePlate(ModBlocks2.TEST_APPLE_PRESSURE_PLATE);

        testAppleGarnetPool.fence(ModBlocks2.TEST_APPLE_FENCE);
        testAppleGarnetPool.fenceGate(ModBlocks2.TEST_APPLE_FENCE_GATE);

        blockModelGenerators.createDoor(ModBlocks2.TEST_APPLE_DOOR);
        blockModelGenerators.createDoor(ModBlocks2.TEST_APPLE_TRAPDOOR);


        blockModelGenerators.woodProvider(ModBlocks2.APPLE_LOG)
                .log(ModBlocks2.APPLE_LOG)
                .wood(ModBlocks2.APPLE_WOOD);
        blockModelGenerators.woodProvider(ModBlocks2.STRIPPED_APPLE_LOG)
                .log(ModBlocks2.STRIPPED_APPLE_LOG)
                .wood(ModBlocks2.STRIPPED_APPLE_WOOD);
        //blockStateModelGenerator.registerSingleton(ModBlocks2.APPLE_LEAVES, TexturedModel.LEAVES);
        blockModelGenerators.createCrossBlock(ModBlocks2.APPLE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
        blockModelGenerators.createCrossBlock(ModBlocks2.GOLDEN_APPLE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);

        blockModelGenerators.woodProvider(ModBlocks2.TEST_APPLE_LOG)
                .log(ModBlocks2.TEST_APPLE_LOG)
                .wood(ModBlocks2.TEST_APPLE_WOOD);
        blockModelGenerators.woodProvider(ModBlocks2.STRIPPED_TEST_APPLE_LOG)
                .log(ModBlocks2.STRIPPED_TEST_APPLE_LOG)
                .wood(ModBlocks2.STRIPPED_TEST_APPLE_WOOD);
        blockModelGenerators.createCrossBlock(ModBlocks2.TEST_APPLE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);


        /*
        Identifier frostyAppleSignModel = Models.GENERATED.upload(
                ModBlocks2.FROSTY_APPLE_STANDING_SIGN,
                new TextureMap().put(TextureKey.LAYER0, TextureMap.getId(ModBlocks2.FROSTY_APPLE_PLANKS)),
                blockStateModelGenerator.modelCollector
        );
        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createSingletonBlockState(ModBlocks2.FROSTY_APPLE_STANDING_SIGN, frostyAppleSignModel)
        );
        blockStateModelGenerator.blockStateCollector.accept(
                BlockStateModelGenerator.createSingletonBlockState(ModBlocks2.FROSTY_APPLE_WALL_SIGN, frostyAppleSignModel)
        );
         */
        blockModelGenerators.createParticleOnlyBlock(
                ModBlocks2.FROSTY_APPLE_STANDING_SIGN,
                ModBlocks2.FROSTY_APPLE_PLANKS
        );
        blockModelGenerators.createParticleOnlyBlock(
                ModBlocks2.FROSTY_APPLE_WALL_SIGN,
                ModBlocks2.FROSTY_APPLE_PLANKS
        );

        blockModelGenerators.createHangingSign(
                ModBlocks2.STRIPPED_FROSTY_APPLE_LOG,
                ModBlocks2.FROSTY_APPLE_HANGING_SIGN_BLOCK,
                ModBlocks2.FROSTY_APPLE_WALL_HANGING_SIGN
        );
        BlockModelGenerators.BlockFamilyProvider frostyAppleGarnetPool = blockModelGenerators
                .family(ModBlocks2.FROSTY_APPLE_PLANKS);

        frostyAppleGarnetPool.stairs(ModBlocks2.FROSTY_APPLE_STAIRS);
        frostyAppleGarnetPool.slab(ModBlocks2.FROSTY_APPLE_SLAB);

        frostyAppleGarnetPool.button(ModBlocks2.FROSTY_APPLE_BUTTON);
        frostyAppleGarnetPool.pressurePlate(ModBlocks2.FROSTY_APPLE_PRESSURE_PLATE);

        frostyAppleGarnetPool.fence(ModBlocks2.FROSTY_APPLE_FENCE);
        frostyAppleGarnetPool.fenceGate(ModBlocks2.FROSTY_APPLE_FENCE_GATE);

        blockModelGenerators.createDoor(ModBlocks2.FROSTY_APPLE_DOOR);
        blockModelGenerators.createTrapdoor(ModBlocks2.FROSTY_APPLE_TRAPDOOR);

        blockModelGenerators.woodProvider(ModBlocks2.FROSTY_APPLE_LOG)
                .log(ModBlocks2.FROSTY_APPLE_LOG)
                .wood(ModBlocks2.FROSTY_APPLE_WOOD);
        blockModelGenerators.woodProvider(ModBlocks2.STRIPPED_FROSTY_APPLE_LOG)
                .log(ModBlocks2.STRIPPED_FROSTY_APPLE_LOG)
                .wood(ModBlocks2.STRIPPED_FROSTY_APPLE_WOOD);
        blockModelGenerators.createTrivialBlock(ModBlocks2.FROSTY_APPLE_LEAVES, TexturedModel.LEAVES);

        blockModelGenerators.createCrossBlock(ModBlocks2.FROSTY_APPLE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);

        blockModelGenerators.createTrivialBlock(
        ModBlocks2.APPLE_BARREL,
        TexturedModel.CUBE_TOP_BOTTOM.updateTexture((map) -> {
            map.put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModBlocks2.APPLE_BARREL, "_top"));
            map.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModBlocks2.APPLE_BARREL, "_bottom"));
            map.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks2.APPLE_BARREL, ""));
        }));
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        //itemModelGenerator.register(ModItems.DIAMOND_APPLE, Models.GENERATED);
        itemModelGenerators.generateFlatItem(ModItems.GREEN_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TEST_APPLE, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModBlocks2.APPLE_SAPLING.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModBlocks2.TEST_APPLE_SAPLING.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModBlocks2.GOLDEN_APPLE_SAPLING.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModBlocks2.FROSTY_APPLE_SAPLING.asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.APPLE_SIGN, ModelTemplates.FLAT_ITEM);
//        itemModelGenerator.register(ModItems.APPLE_HANGING_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.APPLE_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.APPLE_CHEST_BOAT, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.TEST_APPLE_SIGN, ModelTemplates.FLAT_ITEM);
//        itemModelGenerator.register(ModItems.TEST_APPLE_HANGING_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TEST_APPLE_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TEST_APPLE_CHEST_BOAT, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.FROSTY_APPLE_SIGN, ModelTemplates.FLAT_ITEM);
//        itemModelGenerator.register(ModItems.FROSTY_APPLE_HANGING_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FROSTY_APPLE_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FROSTY_APPLE_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
    }
}
