package net.more.apples.datagen.recipe;

import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodVariants;
import net.more.apples.datagen.provider.ModRecipeProvider;
import net.more.apples.item.apple_wood_item.AncientAppleWoodItem;
import net.more.apples.util.ModTags;

public final class AncientAppleRecipes {
    private AncientAppleRecipes() {
    }

    public static final BlockFamily ANCIENT_APPLE_WOOD_FAMILY = BlockFamilies.familyBuilder(AncientAppleWoodBlocks.ANCIENT_APPLE_PLANKS)
            .stairs(AncientAppleWoodVariants.ANCIENT_APPLE_STAIRS)
            .slab(AncientAppleWoodVariants.ANCIENT_APPLE_SLAB)
            .fence(AncientAppleWoodVariants.ANCIENT_APPLE_FENCE)
            .fenceGate(AncientAppleWoodVariants.ANCIENT_APPLE_FENCE_GATE)
            .door(AncientAppleWoodVariants.ANCIENT_APPLE_DOOR)
            .trapdoor(AncientAppleWoodVariants.ANCIENT_APPLE_TRAPDOOR)
            .pressurePlate(AncientAppleWoodVariants.ANCIENT_APPLE_PRESSURE_PLATE)
            .button(AncientAppleWoodVariants.ANCIENT_APPLE_BUTTON)
            .sign(AncientAppleWoodVariants.ANCIENT_APPLE_STANDING_SIGN, AncientAppleWoodVariants.ANCIENT_APPLE_WALL_SIGN)
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_apple_planks")
            .getFamily();

    public static void addRecipes(ModRecipeProvider.ModRecipeBuilder provider, RecipeOutput exporter) {
        provider.generateWoodFamily(ANCIENT_APPLE_WOOD_FAMILY);
        provider.addWoodFromLogs(AncientAppleWoodBlocks.ANCIENT_APPLE_WOOD, AncientAppleWoodBlocks.ANCIENT_APPLE_LOG);
        provider.addWoodFromLogs(AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_WOOD, AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG);
        provider.addPlanksFromLogs(AncientAppleWoodBlocks.ANCIENT_APPLE_PLANKS, ModTags.Items.ALL_ANCIENT_APPLE_LOG, 4);
        provider.addShelfRecipe(AncientAppleWoodVariants.ANCIENT_APPLE_SHELF, AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG);

        provider.shapedRecipe(RecipeCategory.DECORATIONS, AncientAppleWoodItem.ANCIENT_APPLE_HANGING_SIGN, 6)
                .define('C', Items.IRON_CHAIN)
                .define('L', AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG)
                .pattern("C C")
                .pattern("LLL")
                .pattern("LLL")
                .unlockedBy("has_chain", provider.hasItem(Items.IRON_CHAIN))
                .unlockedBy("has_stripped_apple_log", provider.hasItem(AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG))
                .group("hanging_sign")
                .save(exporter);

        provider.shapedRecipe(RecipeCategory.DECORATIONS, AncientAppleWoodItem.ANCIENT_APPLE_BOAT)
                .define('B', AncientAppleWoodBlocks.ANCIENT_APPLE_PLANKS)
                .pattern("B B")
                .pattern("BBB")
                .unlockedBy("has_planks", provider.hasItem(AncientAppleWoodBlocks.ANCIENT_APPLE_PLANKS))
                .group("boat")
                .save(exporter);

        provider.shapelessRecipe(RecipeCategory.TRANSPORTATION, AncientAppleWoodItem.ANCIENT_APPLE_CHEST_BOAT)
                .requires(Items.CHEST)
                .requires(AncientAppleWoodItem.ANCIENT_APPLE_BOAT)
                .unlockedBy("has_planks", provider.hasItem(AncientAppleWoodItem.ANCIENT_APPLE_BOAT))
                .group("chest_boat")
                .save(exporter);
    }
}
