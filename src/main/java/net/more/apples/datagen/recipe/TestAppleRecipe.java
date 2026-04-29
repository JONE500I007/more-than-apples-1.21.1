package net.more.apples.datagen.recipe;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;
import net.more.apples.item.apple_wood_item.TestAppleWoodItem;
import net.more.apples.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class TestAppleRecipe extends FabricRecipeProvider {
    public TestAppleRecipe(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                this.generateRecipes(TEST_APPLE_WOOD_FAMILY, FeatureFlags.VANILLA_SET);
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                woodFromLogs(TestAppleWoodBlocks.TEST_APPLE_WOOD, TestAppleWoodBlocks.TEST_APPLE_LOG);
                woodFromLogs(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD, TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG);

                planksFromLog(TestAppleWoodBlocks.TEST_APPLE_PLANKS, ModTags.Items.ALL_TEST_APPLE_LOG, 4);

                shelf(TestAppleWoodVariants.TEST_APPLE_SHELF, TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG);

                shaped(RecipeCategory.DECORATIONS, TestAppleWoodItem.TEST_APPLE_HANGING_SIGN, 6)
                        .define('C', Items.IRON_CHAIN)
                        .define('L', TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG)
                        .pattern("C C")
                        .pattern("LLL")
                        .pattern("LLL")
                        .unlockedBy("has_chain", has(Items.IRON_CHAIN))
                        .unlockedBy("has_stripped_apple_log", has(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG))
                        .group("hanging_sign")
                        .save(exporter);
                shaped(RecipeCategory.DECORATIONS, TestAppleWoodItem.TEST_APPLE_BOAT)
                        .define('B', TestAppleWoodBlocks.TEST_APPLE_PLANKS)
                        .pattern("B B")
                        .pattern("BBB")
                        .unlockedBy("has_planks", has(TestAppleWoodBlocks.TEST_APPLE_PLANKS))
                        .group("boat")
                        .save(exporter);
                shapeless(RecipeCategory.TRANSPORTATION, TestAppleWoodItem.TEST_APPLE_CHEST_BOAT)
                        .requires(Items.CHEST)
                        .requires(TestAppleWoodItem.TEST_APPLE_BOAT)
                        .unlockedBy("has_planks", has(TestAppleWoodItem.TEST_APPLE_BOAT))
                        .group("chest_boat")
                        .save(exporter);

            }
        };
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

            //.group("apple_wood")
            .recipeGroupPrefix("wooden")
            //.group("mod_all_apple")
            .recipeUnlockedBy("has_apple_planks")
            .getFamily();


    @Override
    public String getName() {
        return "";
    }
}
