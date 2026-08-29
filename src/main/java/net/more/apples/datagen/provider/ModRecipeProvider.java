package net.more.apples.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.more.apples.datagen.recipe.AncientAppleRecipes;
import net.more.apples.datagen.recipe.AppleRecipes;
import net.more.apples.datagen.recipe.FrostyAppleRecipes;
import net.more.apples.datagen.recipe.TestAppleRecipes;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new ModRecipeBuilder(registryLookup, exporter);
    }

    @Override
    public String getName() {
        return "Recipes";
    }

    public static class ModRecipeBuilder extends RecipeProvider {
        private final RecipeOutput exporter;

        public ModRecipeBuilder(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
            super(registryLookup, exporter);
            this.exporter = exporter;
        }

        @Override
        public void buildRecipes() {
            AppleRecipes.addRecipes(this, exporter);
            TestAppleRecipes.addRecipes(this, exporter);
            FrostyAppleRecipes.addRecipes(this, exporter);
            AncientAppleRecipes.addRecipes(this, exporter);
        }

        public void generateWoodFamily(net.minecraft.data.BlockFamily family) {
            generateRecipes(family, net.minecraft.world.flag.FeatureFlags.VANILLA_SET);
        }

        public void addWoodFromLogs(Block wood, Block log) {
            woodFromLogs(wood, log);
        }

        public void addPlanksFromLogs(Block planks, TagKey<Item> logs, int count) {
            planksFromLog(planks, logs, count);
        }

        public void addShelfRecipe(Block shelf, Block strippedLog) {
            shelf(shelf, strippedLog);
        }

        public ShapedRecipeBuilder shapedRecipe(RecipeCategory category, ItemLike result) {
            return shaped(category, result);
        }

        public ShapedRecipeBuilder shapedRecipe(RecipeCategory category, ItemLike result, int count) {
            return shaped(category, result, count);
        }

        public ShapelessRecipeBuilder shapelessRecipe(RecipeCategory category, ItemLike result) {
            return shapeless(category, result);
        }

        public Criterion<?> hasItem(ItemLike itemLike) {
            return has(itemLike);
        }

        public Criterion<?> hasItemTag(TagKey<Item> tag) {
            return has(tag);
        }
    }
}
