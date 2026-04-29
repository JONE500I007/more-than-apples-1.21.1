package net.more.apples.datagen.model;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.more.apples.block.general_block.ModGeneralBlock;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import net.more.apples.item.apple_wood_item.AppleWoodItem;
import net.more.apples.item.apple_wood_item.FrostyAppleWoodItem;
import net.more.apples.item.apple_wood_item.TestAppleWoodItem;

public class GeneralBlockAndItem extends FabricModelProvider {
    public GeneralBlockAndItem(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        BlockModelGenerators.BlockFamilyProvider appleFamily = blockModelGenerators.family(AppleWoodBlocks.APPLE_PLANKS);
        appleFamily.stairs(AppleWoodVariants.APPLE_STAIRS);
        appleFamily.slab(AppleWoodVariants.APPLE_SLAB);
        appleFamily.button(AppleWoodVariants.APPLE_BUTTON);
        appleFamily.pressurePlate(AppleWoodVariants.APPLE_PRESSURE_PLATE);
        appleFamily.fence(AppleWoodVariants.APPLE_FENCE);
        appleFamily.fenceGate(AppleWoodVariants.APPLE_FENCE_GATE);

        blockModelGenerators.createDoor(AppleWoodVariants.APPLE_DOOR);
        blockModelGenerators.createTrapdoor(AppleWoodVariants.APPLE_TRAPDOOR);
        blockModelGenerators.createParticleOnlyBlock(AppleWoodVariants.APPLE_STANDING_SIGN, AppleWoodBlocks.APPLE_PLANKS);
        blockModelGenerators.createParticleOnlyBlock(AppleWoodVariants.APPLE_WALL_SIGN, AppleWoodBlocks.APPLE_PLANKS);
        blockModelGenerators.createHangingSign(
                AppleWoodBlocks.STRIPPED_APPLE_LOG,
                AppleWoodVariants.APPLE_HANGING_SIGN_BLOCK,
                AppleWoodVariants.APPLE_WALL_HANGING_SIGN
        );
        blockModelGenerators.woodProvider(AppleWoodBlocks.APPLE_LOG).log(AppleWoodBlocks.APPLE_LOG).wood(AppleWoodBlocks.APPLE_WOOD);
        blockModelGenerators.woodProvider(AppleWoodBlocks.STRIPPED_APPLE_LOG).log(AppleWoodBlocks.STRIPPED_APPLE_LOG).wood(AppleWoodBlocks.STRIPPED_APPLE_WOOD);
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

        BlockModelGenerators.BlockFamilyProvider testFamily = blockModelGenerators.family(TestAppleWoodBlocks.TEST_APPLE_PLANKS);
        testFamily.stairs(TestAppleWoodVariants.TEST_APPLE_STAIRS);
        testFamily.slab(TestAppleWoodVariants.TEST_APPLE_SLAB);
        testFamily.button(TestAppleWoodVariants.TEST_APPLE_BUTTON);
        testFamily.pressurePlate(TestAppleWoodVariants.TEST_APPLE_PRESSURE_PLATE);
        testFamily.fence(TestAppleWoodVariants.TEST_APPLE_FENCE);
        testFamily.fenceGate(TestAppleWoodVariants.TEST_APPLE_FENCE_GATE);

        blockModelGenerators.createDoor(TestAppleWoodVariants.TEST_APPLE_DOOR);
        blockModelGenerators.createTrapdoor(TestAppleWoodVariants.TEST_APPLE_TRAPDOOR);
        blockModelGenerators.createParticleOnlyBlock(TestAppleWoodVariants.TEST_APPLE_STANDING_SIGN, TestAppleWoodBlocks.TEST_APPLE_PLANKS);
        blockModelGenerators.createParticleOnlyBlock(TestAppleWoodVariants.TEST_APPLE_WALL_SIGN, TestAppleWoodBlocks.TEST_APPLE_PLANKS);
        blockModelGenerators.createHangingSign(
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG,
                TestAppleWoodVariants.TEST_APPLE_HANGING_SIGN_BLOCK,
                TestAppleWoodVariants.TEST_APPLE_WALL_HANGING_SIGN
        );
        blockModelGenerators.woodProvider(TestAppleWoodBlocks.TEST_APPLE_LOG).log(TestAppleWoodBlocks.TEST_APPLE_LOG).wood(TestAppleWoodBlocks.TEST_APPLE_WOOD);
        blockModelGenerators.woodProvider(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG).log(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG).wood(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD);
        blockModelGenerators.createShelf(TestAppleWoodVariants.TEST_APPLE_SHELF, TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG);
        blockModelGenerators.createCrossBlock(TestAppleWoodBlocks.TEST_APPLE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);

        BlockModelGenerators.BlockFamilyProvider frostyFamily = blockModelGenerators.family(FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS);
        frostyFamily.stairs(FrostyAppleWoodVariants.FROSTY_APPLE_STAIRS);
        frostyFamily.slab(FrostyAppleWoodVariants.FROSTY_APPLE_SLAB);
        frostyFamily.button(FrostyAppleWoodVariants.FROSTY_APPLE_BUTTON);
        frostyFamily.pressurePlate(FrostyAppleWoodVariants.FROSTY_APPLE_PRESSURE_PLATE);
        frostyFamily.fence(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE);
        frostyFamily.fenceGate(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE);

        blockModelGenerators.createDoor(FrostyAppleWoodVariants.FROSTY_APPLE_DOOR);
        blockModelGenerators.createTrapdoor(FrostyAppleWoodVariants.FROSTY_APPLE_TRAPDOOR);
        blockModelGenerators.createParticleOnlyBlock(FrostyAppleWoodVariants.FROSTY_APPLE_STANDING_SIGN, FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS);
        blockModelGenerators.createParticleOnlyBlock(FrostyAppleWoodVariants.FROSTY_APPLE_WALL_SIGN, FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS);
        blockModelGenerators.createHangingSign(
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG,
                FrostyAppleWoodVariants.FROSTY_APPLE_HANGING_SIGN_BLOCK,
                FrostyAppleWoodVariants.FROSTY_APPLE_WALL_HANGING_SIGN
        );
        blockModelGenerators.woodProvider(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG).log(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG).wood(FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD);
        blockModelGenerators.woodProvider(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG).log(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG).wood(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD);
        blockModelGenerators.createShelf(FrostyAppleWoodVariants.FROSTY_APPLE_SHELF, FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG);
        blockModelGenerators.createCrossBlock(FrostyAppleWoodBlocks.FROSTY_APPLE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModAppleFoodItems.GREEN_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModAppleFoodItems.TEST_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AppleWoodBlocks.APPLE_SAPLING.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AppleWoodBlocks.GOLDEN_APPLE_SAPLING.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AppleWoodItem.APPLE_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AppleWoodItem.APPLE_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(AppleWoodItem.APPLE_CHEST_BOAT, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(TestAppleWoodBlocks.TEST_APPLE_SAPLING.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(TestAppleWoodItem.TEST_APPLE_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(TestAppleWoodItem.TEST_APPLE_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(TestAppleWoodItem.TEST_APPLE_CHEST_BOAT, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(FrostyAppleWoodBlocks.FROSTY_APPLE_SAPLING.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrostyAppleWoodItem.FROSTY_APPLE_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrostyAppleWoodItem.FROSTY_APPLE_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrostyAppleWoodItem.FROSTY_APPLE_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
    }
}
