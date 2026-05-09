package net.more.apples.datagen.recipe;

import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.more.apples.block.general_block.ModGeneralBlock;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.datagen.provider.ModRecipeProvider;
import net.more.apples.item.apple_wood_item.AppleWoodItem;
import net.more.apples.util.ModTags;

public final class AppleRecipes {
    private AppleRecipes() {
    }

    public static final BlockFamily APPLE_WOOD_FAMILY = BlockFamilies.familyBuilder(AppleWoodBlocks.APPLE_PLANKS)
            .stairs(AppleWoodVariants.APPLE_STAIRS)
            .slab(AppleWoodVariants.APPLE_SLAB)
            .fence(AppleWoodVariants.APPLE_FENCE)
            .fenceGate(AppleWoodVariants.APPLE_FENCE_GATE)
            .door(AppleWoodVariants.APPLE_DOOR)
            .trapdoor(AppleWoodVariants.APPLE_TRAPDOOR)
            .pressurePlate(AppleWoodVariants.APPLE_PRESSURE_PLATE)
            .button(AppleWoodVariants.APPLE_BUTTON)
            .sign(AppleWoodVariants.APPLE_STANDING_SIGN, AppleWoodVariants.APPLE_WALL_SIGN)
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_apple_planks")
            .getFamily();

    public static void addRecipes(ModRecipeProvider.ModRecipeBuilder provider, RecipeOutput exporter) {
        provider.generateWoodFamily(APPLE_WOOD_FAMILY);
        provider.addWoodFromLogs(AppleWoodBlocks.APPLE_WOOD, AppleWoodBlocks.APPLE_LOG);
        provider.addWoodFromLogs(AppleWoodBlocks.STRIPPED_APPLE_WOOD, AppleWoodBlocks.STRIPPED_APPLE_LOG);
        provider.addPlanksFromLogs(AppleWoodBlocks.APPLE_PLANKS, ModTags.Items.ALL_APPLE_LOG, 4);
        provider.addShelfRecipe(AppleWoodVariants.APPLE_SHELF, AppleWoodBlocks.STRIPPED_APPLE_LOG);

        provider.shapedRecipe(RecipeCategory.DECORATIONS, AppleWoodItem.APPLE_HANGING_SIGN, 6)
                .define('C', Items.IRON_CHAIN)
                .define('L', AppleWoodBlocks.STRIPPED_APPLE_LOG)
                .pattern("C C")
                .pattern("LLL")
                .pattern("LLL")
                .unlockedBy("has_chain", provider.hasItem(Items.IRON_CHAIN))
                .unlockedBy("has_stripped_apple_log", provider.hasItem(AppleWoodBlocks.STRIPPED_APPLE_LOG))
                .group("hanging_sign")
                .save(exporter);

        provider.shapedRecipe(RecipeCategory.DECORATIONS, AppleWoodItem.APPLE_BOAT)
                .define('B', AppleWoodBlocks.APPLE_PLANKS)
                .pattern("B B")
                .pattern("BBB")
                .unlockedBy("has_planks", provider.hasItem(AppleWoodBlocks.APPLE_PLANKS))
                .group("boat")
                .save(exporter);

        provider.shapelessRecipe(RecipeCategory.TRANSPORTATION, AppleWoodItem.APPLE_CHEST_BOAT)
                .requires(Items.CHEST)
                .requires(AppleWoodItem.APPLE_BOAT)
                .unlockedBy("has_planks", provider.hasItem(AppleWoodItem.APPLE_BOAT))
                .group("chest_boat")
                .save(exporter);

        provider.shapedRecipe(RecipeCategory.MISC, ModGeneralBlock.APPLE_BARREL)
                .define('A', ModTags.Items.ALL_APPLE)
                .define('B', ItemTags.PLANKS)
                .pattern("AA")
                .pattern("BB")
                .pattern("BB")
                .unlockedBy("has_apple", provider.hasItemTag(ModTags.Items.ALL_APPLE))
                .unlockedBy("has_planks", provider.hasItemTag(ItemTags.PLANKS))
                .save(exporter);
    }
}
