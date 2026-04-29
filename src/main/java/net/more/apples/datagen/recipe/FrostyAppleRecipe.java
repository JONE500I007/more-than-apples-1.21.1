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
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.item.apple_wood_item.FrostyAppleWoodItem;
import net.more.apples.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class FrostyAppleRecipe extends FabricRecipeProvider {
    public FrostyAppleRecipe(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                this.generateRecipes(FROSTY_APPLE_WOOD_FAMILY, FeatureFlags.VANILLA_SET);
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                woodFromLogs(FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD, FrostyAppleWoodBlocks.FROSTY_APPLE_LOG);
                woodFromLogs(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD, FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG);

                planksFromLog(FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS, ModTags.Items.ALL_FROSTY_APPLE_LOG, 4);

                shelf(FrostyAppleWoodVariants.FROSTY_APPLE_SHELF, FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG);

                shaped(RecipeCategory.DECORATIONS, FrostyAppleWoodItem.FROSTY_APPLE_HANGING_SIGN, 6)
                        .define('C', Items.IRON_CHAIN)
                        .define('L', FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG)
                        .pattern("C C")
                        .pattern("LLL")
                        .pattern("LLL")
                        .unlockedBy("has_chain", has(Items.IRON_CHAIN))
                        .unlockedBy("has_stripped_apple_log", has(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG))
                        .group("hanging_sign")
                        .save(exporter);
                shaped(RecipeCategory.DECORATIONS, FrostyAppleWoodItem.FROSTY_APPLE_BOAT)
                        .define('B', FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS)
                        .pattern("B B")
                        .pattern("BBB")
                        .unlockedBy("has_planks", has(FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS))
                        .group("boat")
                        .save(exporter);
                shapeless(RecipeCategory.TRANSPORTATION, FrostyAppleWoodItem.FROSTY_APPLE_CHEST_BOAT)
                        .requires(Items.CHEST)
                        .requires(FrostyAppleWoodItem.FROSTY_APPLE_BOAT)
                        .unlockedBy("has_planks", has(FrostyAppleWoodItem.FROSTY_APPLE_BOAT))
                        .group("chest_boat")
                        .save(exporter);

            }
        };
    }

    public static final BlockFamily FROSTY_APPLE_WOOD_FAMILY = BlockFamilies.familyBuilder(FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS)
            .stairs(FrostyAppleWoodVariants.FROSTY_APPLE_STAIRS)
            .slab(FrostyAppleWoodVariants.FROSTY_APPLE_SLAB)
            .fence(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE)
            .fenceGate(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE)
            .door(FrostyAppleWoodVariants.FROSTY_APPLE_DOOR)
            .trapdoor(FrostyAppleWoodVariants.FROSTY_APPLE_TRAPDOOR)
            .pressurePlate(FrostyAppleWoodVariants.FROSTY_APPLE_PRESSURE_PLATE)
            .button(FrostyAppleWoodVariants.FROSTY_APPLE_BUTTON)

            .sign(FrostyAppleWoodVariants.FROSTY_APPLE_STANDING_SIGN, FrostyAppleWoodVariants.FROSTY_APPLE_WALL_SIGN)

            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_apple_planks")
            .getFamily();


    @Override
    public String getName() {
        return "";
    }
}
