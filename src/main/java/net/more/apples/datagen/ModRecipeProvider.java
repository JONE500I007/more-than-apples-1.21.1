package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.more.apples.block.ModBlocks2;
import net.more.apples.item.ModItems;
import net.more.apples.util.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> GARNET_APPLE_ORE = List.of(
                ModBlocks2.APPLE_ORE,
                ModBlocks2.DEEPSLATE_APPLE_ORE);

        offerSmelting(recipeExporter, GARNET_APPLE_ORE, RecipeCategory.MISC, Items.APPLE,
                0.25f, 200, "this_apple");
        offerBlasting(recipeExporter, GARNET_APPLE_ORE, RecipeCategory.MISC, Items.APPLE,
                0.25f, 100, "this_apple");

//        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
//                Items.APPLE, RecipeCategory.DECORATIONS, ModBlocks.DIAMOND_APPLE_BLOCK);

        //RecipeProvider.generateFamily(recipeExporter, ModBlockFamilies.APPLE_WOOD_FAMILY, FeatureFlags.VANILLA_FEATURES);
        //RecipeProvider.generateFamily(recipeExporter, APPLE_WOOD_FAMILY, FeatureSet.of(FeatureFlags.VANILLA_FEATURES));
        //RecipeProvider.generateFamily(recipeExporter, TEST_APPLE_WOOD_FAMILY, FeatureSet.of(FeatureFlags.VANILLA_FEATURES));
        RecipeProvider.generateFamily(recipeExporter, APPLE_WOOD_FAMILY, FeatureFlags.VANILLA_FEATURES);
        RecipeProvider.generateFamily(recipeExporter, TEST_APPLE_WOOD_FAMILY, FeatureFlags.VANILLA_FEATURES);

        /*
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks2.APPLE_BARREL)
                .pattern("AA")
                .pattern("BB")
                .pattern("BB")
                .input('B', ItemTags.PLANKS)
                .input('A', Items.APPLE)
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .offerTo(recipeExporter);
         */

        offerPlanksRecipe(recipeExporter, ModBlocks2.APPLE_PLANKS, ModTags.Items.ALL_APPLE_LOG, 4);
        offerPlanksRecipe(recipeExporter, ModBlocks2.TEST_APPLE_PLANKS, ModTags.Items.ALL_TEST_APPLE_LOG, 4);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks2.APPLE_BARREL)
                .input('A', ModTags.Items.ALL_APPLE)
                .input('B', ItemTags.PLANKS)
                .pattern("AA")
                .pattern("BB")
                .pattern("BB")
                .criterion("has_apple", conditionsFromTag(ModTags.Items.ALL_APPLE))
                .criterion("has_planks", conditionsFromTag(ItemTags.PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.APPLE_HANGING_SIGN, 6)
                .input('C', Items.CHAIN)
                .input('L', ModBlocks2.STRIPPED_APPLE_LOG)
                .pattern("C C")
                .pattern("LLL")
                .pattern("LLL")
                .criterion("has_chain", conditionsFromItem(Items.CHAIN))
                .criterion("has_stripped_apple_log", conditionsFromItem(ModBlocks2.STRIPPED_APPLE_LOG))
                .group("hanging_sign")
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.APPLE_BOAT)
                .input('B', ModBlocks2.APPLE_PLANKS)
                .pattern("B B")
                .pattern("BBB")
                .criterion("has_planks", conditionsFromItem(ModBlocks2.APPLE_PLANKS))
                .group("boat")
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.APPLE_CHEST_BOAT)
                .input(Items.CHEST)
                .input(ModItems.APPLE_BOAT)
                .criterion("has_planks", conditionsFromItem(ModItems.APPLE_BOAT))
                .group("chest_boat")
                .offerTo(recipeExporter);

        offerBarkBlockRecipe(recipeExporter,
                ModBlocks2.APPLE_WOOD, ModBlocks2.APPLE_LOG);
        offerBarkBlockRecipe(recipeExporter,
                ModBlocks2.STRIPPED_APPLE_WOOD, ModBlocks2.STRIPPED_APPLE_LOG);
        offerBarkBlockRecipe(recipeExporter,
                ModBlocks2.TEST_APPLE_WOOD, ModBlocks2.TEST_APPLE_LOG);
        offerBarkBlockRecipe(recipeExporter,
                ModBlocks2.STRIPPED_TEST_APPLE_WOOD, ModBlocks2.STRIPPED_TEST_APPLE_LOG);

    }

    public static final BlockFamily APPLE_WOOD_FAMILY = BlockFamilies.register(ModBlocks2.APPLE_PLANKS)
            .stairs(ModBlocks2.APPLE_STAIRS)
            .slab(ModBlocks2.APPLE_SLAB)
            .fence(ModBlocks2.APPLE_FENCE)
            .fenceGate(ModBlocks2.APPLE_FENCE_GATE)
            .door(ModBlocks2.APPLE_DOOR)
            .trapdoor(ModBlocks2.APPLE_TRAPDOOR)
            .pressurePlate(ModBlocks2.APPLE_PRESSURE_PLATE)
            .button(ModBlocks2.APPLE_BUTTON)

            .sign(ModBlocks2.APPLE_STANDING_SIGN, ModBlocks2.APPLE_WALL_SIGN)

            //.group("apple_wood")
            .group("wooden")
            //.group("mod_all_apple")
            .unlockCriterionName("has_apple_planks")
            .build();

    public static final BlockFamily TEST_APPLE_WOOD_FAMILY = BlockFamilies.register(ModBlocks2.TEST_APPLE_PLANKS)
            .stairs(ModBlocks2.TEST_APPLE_STAIRS)
            .slab(ModBlocks2.TEST_APPLE_SLAB)
            .fence(ModBlocks2.TEST_APPLE_FENCE)
            .fenceGate(ModBlocks2.TEST_APPLE_FENCE_GATE)
            .door(ModBlocks2.TEST_APPLE_DOOR)
            .trapdoor(ModBlocks2.TEST_APPLE_TRAPDOOR)
            .pressurePlate(ModBlocks2.TEST_APPLE_PRESSURE_PLATE)
            .button(ModBlocks2.TEST_APPLE_BUTTON)

            //.sign(ModBlocks2.APPLE_SIGN, ModBlocks2.APPLE_WALL_SIGN)
            //.group("test_apple_wood")
            .group("wooden")
            //.group("mod_all_apple")
            .unlockCriterionName("has_apple_planks")
            .build();
}
