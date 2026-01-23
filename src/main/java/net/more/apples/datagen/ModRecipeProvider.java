package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
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
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {

            @Override
            public void generate() {
                List<ItemConvertible> GARNET_APPLE_ORE = List.of(
                        ModBlocks2.APPLE_ORE,
                        ModBlocks2.DEEPSLATE_APPLE_ORE);

                offerSmelting(GARNET_APPLE_ORE, RecipeCategory.MISC, Items.APPLE,
                        0.25f, 200, "this_apple");
                offerBlasting(GARNET_APPLE_ORE, RecipeCategory.MISC, Items.APPLE,
                        0.25f, 100, "this_apple");

//        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
//                Items.APPLE, RecipeCategory.DECORATIONS, ModBlocks.DIAMOND_APPLE_BLOCK);

                //RecipeProvider.generateFamily(recipeExporter, ModBlockFamilies.APPLE_WOOD_FAMILY, FeatureFlags.VANILLA_FEATURES);
                //RecipeProvider.generateFamily(recipeExporter, APPLE_WOOD_FAMILY, FeatureSet.of(FeatureFlags.VANILLA_FEATURES));
                //RecipeProvider.generateFamily(recipeExporter, TEST_APPLE_WOOD_FAMILY, FeatureSet.of(FeatureFlags.VANILLA_FEATURES));
                this.generateFamily(APPLE_WOOD_FAMILY, FeatureFlags.VANILLA_FEATURES);
                this.generateFamily(TEST_APPLE_WOOD_FAMILY, FeatureFlags.VANILLA_FEATURES);
                this.generateFamily(FROSTY_APPLE_WOOD_FAMILY, FeatureFlags.VANILLA_FEATURES);

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

                offerPlanksRecipe(ModBlocks2.APPLE_PLANKS, ModTags.Items.ALL_APPLE_LOG, 4);
                offerPlanksRecipe(ModBlocks2.TEST_APPLE_PLANKS, ModTags.Items.ALL_TEST_APPLE_LOG, 4);
                offerPlanksRecipe(ModBlocks2.FROSTY_APPLE_PLANKS, ModTags.Items.ALL_FROSTY_APPLE_LOG, 4);

                RegistryEntryLookup<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                createShaped(RecipeCategory.MISC, ModBlocks2.APPLE_BARREL)
                        .input('A', ModTags.Items.ALL_APPLE)
                        .input('B', ItemTags.PLANKS)
                        .pattern("AA")
                        .pattern("BB")
                        .pattern("BB")
                        .criterion("has_apple", conditionsFromTag(ModTags.Items.ALL_APPLE))
                        .criterion("has_planks", conditionsFromTag(ItemTags.PLANKS))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.APPLE_HANGING_SIGN, 6)
                        .input('C', Items.CHAIN)
                        .input('L', ModBlocks2.STRIPPED_APPLE_LOG)
                        .pattern("C C")
                        .pattern("LLL")
                        .pattern("LLL")
                        .criterion("has_chain", conditionsFromItem(Items.CHAIN))
                        .criterion("has_stripped_apple_log", conditionsFromItem(ModBlocks2.STRIPPED_APPLE_LOG))
                        .group("hanging_sign")
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.DECORATIONS, ModItems.APPLE_BOAT)
                        .input('B', ModBlocks2.APPLE_PLANKS)
                        .pattern("B B")
                        .pattern("BBB")
                        .criterion("has_planks", conditionsFromItem(ModBlocks2.APPLE_PLANKS))
                        .group("boat")
                        .offerTo(recipeExporter);
                ShapelessRecipeJsonBuilder.create(itemLookup, RecipeCategory.TRANSPORTATION, ModItems.APPLE_CHEST_BOAT)
                        .input(Items.CHEST)
                        .input(ModItems.APPLE_BOAT)
                        .criterion("has_planks", conditionsFromItem(ModItems.APPLE_BOAT))
                        .group("chest_boat")
                        .offerTo(recipeExporter);


                createShaped(RecipeCategory.DECORATIONS, ModItems.TEST_APPLE_HANGING_SIGN, 6)
                        .input('C', Items.CHAIN)
                        .input('L', ModBlocks2.STRIPPED_TEST_APPLE_LOG)
                        .pattern("C C")
                        .pattern("LLL")
                        .pattern("LLL")
                        .criterion("has_chain", conditionsFromItem(Items.CHAIN))
                        .criterion("has_stripped_apple_log", conditionsFromItem(ModBlocks2.STRIPPED_TEST_APPLE_LOG))
                        .group("hanging_sign")
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.DECORATIONS, ModItems.TEST_APPLE_BOAT)
                        .input('B', ModBlocks2.TEST_APPLE_PLANKS)
                        .pattern("B B")
                        .pattern("BBB")
                        .criterion("has_planks", conditionsFromItem(ModBlocks2.TEST_APPLE_PLANKS))
                        .group("boat")
                        .offerTo(recipeExporter);
                ShapelessRecipeJsonBuilder.create(itemLookup ,RecipeCategory.TRANSPORTATION, ModItems.TEST_APPLE_CHEST_BOAT)
                        .input(Items.CHEST)
                        .input(ModItems.TEST_APPLE_BOAT)
                        .criterion("has_planks", conditionsFromItem(ModItems.TEST_APPLE_BOAT))
                        .group("chest_boat")
                        .offerTo(recipeExporter);


                createShaped(RecipeCategory.DECORATIONS, ModItems.FROSTY_APPLE_HANGING_SIGN, 6)
                        .input('C', Items.CHAIN)
                        .input('L', ModBlocks2.STRIPPED_FROSTY_APPLE_LOG)
                        .pattern("C C")
                        .pattern("LLL")
                        .pattern("LLL")
                        .criterion("has_chain", conditionsFromItem(Items.CHAIN))
                        .criterion("has_stripped_apple_log", conditionsFromItem(ModBlocks2.STRIPPED_FROSTY_APPLE_LOG))
                        .group("hanging_sign")
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.DECORATIONS, ModItems.FROSTY_APPLE_BOAT)
                        .input('B', ModBlocks2.FROSTY_APPLE_PLANKS)
                        .pattern("B B")
                        .pattern("BBB")
                        .criterion("has_planks", conditionsFromItem(ModBlocks2.FROSTY_APPLE_PLANKS))
                        .group("boat")
                        .offerTo(recipeExporter);
                ShapelessRecipeJsonBuilder.create(itemLookup, RecipeCategory.TRANSPORTATION, ModItems.FROSTY_APPLE_CHEST_BOAT)
                        .input(Items.CHEST)
                        .input(ModItems.FROSTY_APPLE_BOAT)
                        .criterion("has_planks", conditionsFromItem(ModItems.FROSTY_APPLE_BOAT))
                        .group("chest_boat")
                        .offerTo(recipeExporter);

                offerBarkBlockRecipe(ModBlocks2.APPLE_WOOD, ModBlocks2.APPLE_LOG);
                offerBarkBlockRecipe(ModBlocks2.STRIPPED_APPLE_WOOD, ModBlocks2.STRIPPED_APPLE_LOG);
                offerBarkBlockRecipe(ModBlocks2.TEST_APPLE_WOOD, ModBlocks2.TEST_APPLE_LOG);
                offerBarkBlockRecipe(ModBlocks2.STRIPPED_TEST_APPLE_WOOD, ModBlocks2.STRIPPED_TEST_APPLE_LOG);
                offerBarkBlockRecipe(ModBlocks2.FROSTY_APPLE_WOOD, ModBlocks2.FROSTY_APPLE_LOG);
                offerBarkBlockRecipe(ModBlocks2.STRIPPED_FROSTY_APPLE_WOOD, ModBlocks2.STRIPPED_FROSTY_APPLE_LOG);

            }
        };
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

            .sign(ModBlocks2.TEST_APPLE_STANDING_SIGN, ModBlocks2.TEST_APPLE_WALL_SIGN)

            //.sign(ModBlocks2.APPLE_SIGN, ModBlocks2.APPLE_WALL_SIGN)
            //.group("test_apple_wood")
            .group("wooden")
            //.group("mod_all_apple")
            .unlockCriterionName("has_apple_planks")
            .build();

    public static final BlockFamily FROSTY_APPLE_WOOD_FAMILY = BlockFamilies.register(ModBlocks2.FROSTY_APPLE_PLANKS)
            .stairs(ModBlocks2.FROSTY_APPLE_STAIRS)
            .slab(ModBlocks2.FROSTY_APPLE_SLAB)
            .fence(ModBlocks2.FROSTY_APPLE_FENCE)
            .fenceGate(ModBlocks2.FROSTY_APPLE_FENCE_GATE)
            .door(ModBlocks2.FROSTY_APPLE_DOOR)
            .trapdoor(ModBlocks2.FROSTY_APPLE_TRAPDOOR)
            .pressurePlate(ModBlocks2.FROSTY_APPLE_PRESSURE_PLATE)
            .button(ModBlocks2.FROSTY_APPLE_BUTTON)

            .sign(ModBlocks2.FROSTY_APPLE_STANDING_SIGN, ModBlocks2.FROSTY_APPLE_WALL_SIGN)
            .group("wooden")
            .unlockCriterionName("has_apple_planks")
            .build();

    @Override
    public String getName() {
        return "";
    }
}
