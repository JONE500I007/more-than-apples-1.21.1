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
import net.minecraft.tags.ItemTags;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.more.apples.block.general_block.ModGeneralBlock;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.item.apple_wood_item.AppleWoodItem;
import net.more.apples.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class AppleRecipe extends FabricRecipeProvider {
    public AppleRecipe(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                this.generateRecipes(APPLE_WOOD_FAMILY, FeatureFlags.VANILLA_SET);
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                woodFromLogs(AppleWoodBlocks.APPLE_WOOD, AppleWoodBlocks.APPLE_LOG);
                woodFromLogs(AppleWoodBlocks.STRIPPED_APPLE_WOOD, AppleWoodBlocks.STRIPPED_APPLE_LOG);

                planksFromLog(AppleWoodBlocks.APPLE_PLANKS, ModTags.Items.ALL_APPLE_LOG, 4);

                shelf(AppleWoodVariants.APPLE_SHELF, AppleWoodBlocks.STRIPPED_APPLE_LOG);

                shaped(RecipeCategory.DECORATIONS, AppleWoodItem.APPLE_HANGING_SIGN, 6)
                        .define('C', Items.IRON_CHAIN)
                        .define('L', AppleWoodBlocks.STRIPPED_APPLE_LOG)
                        .pattern("C C")
                        .pattern("LLL")
                        .pattern("LLL")
                        .unlockedBy("has_chain", has(Items.IRON_CHAIN))
                        .unlockedBy("has_stripped_apple_log", has(AppleWoodBlocks.STRIPPED_APPLE_LOG))
                        .group("hanging_sign")
                        .save(exporter);
                shaped(RecipeCategory.DECORATIONS, AppleWoodItem.APPLE_BOAT)
                        .define('B', AppleWoodBlocks.APPLE_PLANKS)
                        .pattern("B B")
                        .pattern("BBB")
                        .unlockedBy("has_planks", has(AppleWoodBlocks.APPLE_PLANKS))
                        .group("boat")
                        .save(exporter);
                shapeless(RecipeCategory.TRANSPORTATION, AppleWoodItem.APPLE_CHEST_BOAT)
                        .requires(Items.CHEST)
                        .requires(AppleWoodItem.APPLE_BOAT)
                        .unlockedBy("has_planks", has(AppleWoodItem.APPLE_BOAT))
                        .group("chest_boat")
                        .save(exporter);

                shaped(RecipeCategory.MISC, ModGeneralBlock.APPLE_BARREL)
                        .define('A', ModTags.Items.ALL_APPLE)
                        .define('B', ItemTags.PLANKS)
                        .pattern("AA")
                        .pattern("BB")
                        .pattern("BB")
                        .unlockedBy("has_apple", has(ModTags.Items.ALL_APPLE))
                        .unlockedBy("has_planks", has(ItemTags.PLANKS))
                        .save(exporter);

            }
        };
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
