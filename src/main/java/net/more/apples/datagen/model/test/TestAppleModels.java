package net.more.apples.datagen.model.test;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;
import net.more.apples.datagen.provider.ModModelProvider;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import net.more.apples.item.apple_wood_item.TestAppleWoodItem;

public final class TestAppleModels {
    private TestAppleModels() {
    }

    public static void addBlockModels(BlockModelGenerators generators) {
        BlockModelGenerators.BlockFamilyProvider family = generators.family(TestAppleWoodBlocks.TEST_APPLE_PLANKS);
        family.stairs(TestAppleWoodVariants.TEST_APPLE_STAIRS);
        family.slab(TestAppleWoodVariants.TEST_APPLE_SLAB);
        family.button(TestAppleWoodVariants.TEST_APPLE_BUTTON);
        family.pressurePlate(TestAppleWoodVariants.TEST_APPLE_PRESSURE_PLATE);
        family.fence(TestAppleWoodVariants.TEST_APPLE_FENCE);
        family.fenceGate(TestAppleWoodVariants.TEST_APPLE_FENCE_GATE);

        generators.createDoor(TestAppleWoodVariants.TEST_APPLE_DOOR);
        generators.createTrapdoor(TestAppleWoodVariants.TEST_APPLE_TRAPDOOR);
        generators.createParticleOnlyBlock(TestAppleWoodVariants.TEST_APPLE_STANDING_SIGN, TestAppleWoodBlocks.TEST_APPLE_PLANKS);
        generators.createParticleOnlyBlock(TestAppleWoodVariants.TEST_APPLE_WALL_SIGN, TestAppleWoodBlocks.TEST_APPLE_PLANKS);
        generators.createHangingSign(
                TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG,
                TestAppleWoodVariants.TEST_APPLE_HANGING_SIGN_BLOCK,
                TestAppleWoodVariants.TEST_APPLE_WALL_HANGING_SIGN
        );
        generators.woodProvider(TestAppleWoodBlocks.TEST_APPLE_LOG)
                .log(TestAppleWoodBlocks.TEST_APPLE_LOG)
                .wood(TestAppleWoodBlocks.TEST_APPLE_WOOD);
        generators.woodProvider(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG)
                .log(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG)
                .wood(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD);
        generators.createShelf(TestAppleWoodVariants.TEST_APPLE_SHELF, TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG);
        generators.createCrossBlock(TestAppleWoodBlocks.TEST_APPLE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
    }

    public static void addItemModels(ItemModelGenerators generators) {
        ModModelProvider.flatItem(generators, ModAppleFoodItems.TEST_APPLE, ModelTemplates.FLAT_ITEM);
        ModModelProvider.flatItem(generators, TestAppleWoodBlocks.TEST_APPLE_SAPLING.asItem(), ModelTemplates.FLAT_ITEM);
        ModModelProvider.flatItem(generators, TestAppleWoodItem.TEST_APPLE_SIGN, ModelTemplates.FLAT_ITEM);
        ModModelProvider.flatItem(generators, TestAppleWoodItem.TEST_APPLE_BOAT, ModelTemplates.FLAT_ITEM);
        ModModelProvider.flatItem(generators, TestAppleWoodItem.TEST_APPLE_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
    }
}
