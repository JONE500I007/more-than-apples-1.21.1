package net.more.apples.datagen.recipe;

import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;
import net.more.apples.datagen.provider.ModRecipeProvider;
import net.more.apples.item.apple_wood_item.TestAppleWoodItem;
import net.more.apples.util.ModTags;

public final class TestAppleRecipes {
    private  TestAppleRecipes() {
    }

    public static final BlockFamily TEST_APPLE_WOOD_FAMILY = BlockFamilies.familyBuilder(TestAppleWoodBlocks.TEST_APPLE_PLANKS)
            .stairs(TestAppleWoodVariants.TEST_APPLE_STAIRS)
            .slab(TestAppleWoodVariants.TEST_APPLE_SLAB)
            .fence(TestAppleWoodVariants.TEST_APPLE_FENCE)
            .fenceGate(TestAppleWoodVariants.TEST_APPLE_FENCE_GATE)
            .door(TestAppleWoodVariants.TEST_APPLE_DOOR)
            .trapdoor(TestAppleWoodVariants.TEST_APPLE_TRAPDOOR)
            .pressurePlate(TestAppleWoodVariants.TEST_APPLE_PRESSURE_PLATE)
            .button(TestAppleWoodVariants.TEST_APPLE_BUTTON)
            .sign(TestAppleWoodVariants.TEST_APPLE_STANDING_SIGN, TestAppleWoodVariants.TEST_APPLE_WALL_SIGN)
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_apple_planks")
            .getFamily();

    public static void addRecipes(ModRecipeProvider.ModRecipeBuilder provider, RecipeOutput exporter) {
        provider.generateWoodFamily(TEST_APPLE_WOOD_FAMILY);
        provider.addWoodFromLogs(TestAppleWoodBlocks.TEST_APPLE_WOOD, TestAppleWoodBlocks.TEST_APPLE_LOG);
        provider.addWoodFromLogs(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD, TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG);
        provider.addPlanksFromLogs(TestAppleWoodBlocks.TEST_APPLE_PLANKS, ModTags.Items.ALL_TEST_APPLE_LOG, 4);
        provider.addShelfRecipe(TestAppleWoodVariants.TEST_APPLE_SHELF, TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG);

        provider.shapedRecipe(RecipeCategory.DECORATIONS, TestAppleWoodItem.TEST_APPLE_HANGING_SIGN, 6)
                .define('C', Items.IRON_CHAIN)
                .define('L', TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG)
                .pattern("C C")
                .pattern("LLL")
                .pattern("LLL")
                .unlockedBy("has_chain", provider.hasItem(Items.IRON_CHAIN))
                .unlockedBy("has_stripped_apple_log", provider.hasItem(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG))
                .group("hanging_sign")
                .save(exporter);
        provider.shapedRecipe(RecipeCategory.DECORATIONS, TestAppleWoodItem.TEST_APPLE_BOAT)
                .define('B', TestAppleWoodBlocks.TEST_APPLE_PLANKS)
                .pattern("B B")
                .pattern("BBB")
                .unlockedBy("has_planks", provider.hasItem(TestAppleWoodBlocks.TEST_APPLE_PLANKS))
                .group("boat")
                .save(exporter);
        provider.shapelessRecipe(RecipeCategory.TRANSPORTATION, TestAppleWoodItem.TEST_APPLE_CHEST_BOAT)
                .requires(Items.CHEST)
                .requires(TestAppleWoodItem.TEST_APPLE_BOAT)
                .unlockedBy("has_planks", provider.hasItem(TestAppleWoodItem.TEST_APPLE_BOAT))
                .group("chest_boat")
                .save(exporter);
    }
}
