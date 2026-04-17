package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
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
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.more.apples.block.ModBlocks2;
import net.more.apples.item.ModItems;
import net.more.apples.util.ModTags;


import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {

            //ItemConvertible
            @Override
            public void buildRecipes() {
                List<ItemLike> GARNET_APPLE_ORE = List.of(
                        ModBlocks2.APPLE_ORE,
                        ModBlocks2.DEEPSLATE_APPLE_ORE);

                oreSmelting(GARNET_APPLE_ORE, RecipeCategory.MISC, CookingBookCategory.MISC,  Items.APPLE,
                        0.25f, 200, "this_apple");
                oreBlasting(GARNET_APPLE_ORE, RecipeCategory.MISC, CookingBookCategory.MISC, Items.APPLE,
                        0.25f, 100, "this_apple");


                //this.generateForEnabledBlockFamilies(FeatureFlags.VANILLA_SET);
                this.generateRecipes(APPLE_WOOD_FAMILY, FeatureFlags.VANILLA_SET);
                this.generateRecipes(TEST_APPLE_WOOD_FAMILY, FeatureFlags.VANILLA_SET);
                this.generateRecipes(FROSTY_APPLE_WOOD_FAMILY, FeatureFlags.VANILLA_SET);

//                this.generateForEnabledBlockFamilies(APPLE_WOOD_FAMILY, FeatureFlags.VANILLA);
//                this.generateForEnabledBlockFamilies(TEST_APPLE_WOOD_FAMILY, FeatureFlags.VANILLA);
//                this.generateForEnabledBlockFamilies(FROSTY_APPLE_WOOD_FAMILY, FeatureFlags.VANILLA);

                planksFromLog(ModBlocks2.APPLE_PLANKS, ModTags.Items.ALL_APPLE_LOG, 4);
                planksFromLog(ModBlocks2.TEST_APPLE_PLANKS, ModTags.Items.ALL_TEST_APPLE_LOG, 4);
                planksFromLog(ModBlocks2.FROSTY_APPLE_PLANKS, ModTags.Items.ALL_FROSTY_APPLE_LOG, 4);

                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                shaped(RecipeCategory.MISC, ModBlocks2.APPLE_BARREL)
                        .define('A', ModTags.Items.ALL_APPLE)
                        .define('B', ItemTags.PLANKS)
                        .pattern("AA")
                        .pattern("BB")
                        .pattern("BB")
                        .unlockedBy("has_apple", has(ModTags.Items.ALL_APPLE))
                        .unlockedBy("has_planks", has(ItemTags.PLANKS))
                        .save(exporter);
                //recipeExporter

                shaped(RecipeCategory.DECORATIONS, ModItems.APPLE_HANGING_SIGN, 6)
                        .define('C', Items.IRON_CHAIN)
                        .define('L', ModBlocks2.STRIPPED_APPLE_LOG)
                        .pattern("C C")
                        .pattern("LLL")
                        .pattern("LLL")
                        .unlockedBy("has_chain", has(Items.IRON_CHAIN))
                        .unlockedBy("has_stripped_apple_log", has(ModBlocks2.STRIPPED_APPLE_LOG))
                        .group("hanging_sign")
                        .save(exporter);
                shaped(RecipeCategory.DECORATIONS, ModItems.APPLE_BOAT)
                        .define('B', ModBlocks2.APPLE_PLANKS)
                        .pattern("B B")
                        .pattern("BBB")
                        .unlockedBy("has_planks", has(ModBlocks2.APPLE_PLANKS))
                        .group("boat")
                        .save(exporter);
                shapeless(RecipeCategory.TRANSPORTATION, ModItems.APPLE_CHEST_BOAT)
                        .requires(Items.CHEST)
                        .requires(ModItems.APPLE_BOAT)
                        .unlockedBy("has_planks", has(ModItems.APPLE_BOAT))
                        .group("chest_boat")
                        .save(exporter);


                shaped(RecipeCategory.DECORATIONS, ModItems.TEST_APPLE_HANGING_SIGN, 6)
                        .define('C', Items.IRON_CHAIN)
                        .define('L', ModBlocks2.STRIPPED_TEST_APPLE_LOG)
                        .pattern("C C")
                        .pattern("LLL")
                        .pattern("LLL")
                        .unlockedBy("has_chain", has(Items.IRON_CHAIN))
                        .unlockedBy("has_stripped_apple_log", has(ModBlocks2.STRIPPED_TEST_APPLE_LOG))
                        .group("hanging_sign")
                        .save(exporter);
                shaped(RecipeCategory.DECORATIONS, ModItems.TEST_APPLE_BOAT)
                        .define('B', ModBlocks2.TEST_APPLE_PLANKS)
                        .pattern("B B")
                        .pattern("BBB")
                        .unlockedBy("has_planks", has(ModBlocks2.TEST_APPLE_PLANKS))
                        .group("boat")
                        .save(exporter);
                shapeless(RecipeCategory.TRANSPORTATION, ModItems.TEST_APPLE_CHEST_BOAT)
                        .requires(Items.CHEST)
                        .requires(ModItems.TEST_APPLE_BOAT)
                        .unlockedBy("has_planks", has(ModItems.TEST_APPLE_BOAT))
                        .group("chest_boat")
                        .save(exporter);


                shaped(RecipeCategory.DECORATIONS, ModItems.FROSTY_APPLE_HANGING_SIGN, 6)
                        .define('C', Items.IRON_CHAIN)
                        .define('L', ModBlocks2.STRIPPED_FROSTY_APPLE_LOG)
                        .pattern("C C")
                        .pattern("LLL")
                        .pattern("LLL")
                        .unlockedBy("has_chain", has(Items.IRON_CHAIN))
                        .unlockedBy("has_stripped_apple_log", has(ModBlocks2.STRIPPED_FROSTY_APPLE_LOG))
                        .group("hanging_sign")
                        .save(exporter);
                shaped(RecipeCategory.DECORATIONS, ModItems.FROSTY_APPLE_BOAT)
                        .define('B', ModBlocks2.FROSTY_APPLE_PLANKS)
                        .pattern("B B")
                        .pattern("BBB")
                        .unlockedBy("has_planks", has(ModBlocks2.FROSTY_APPLE_PLANKS))
                        .group("boat")
                        .save(exporter);
                shapeless(RecipeCategory.TRANSPORTATION, ModItems.FROSTY_APPLE_CHEST_BOAT)
                        .requires(Items.CHEST)
                        .requires(ModItems.FROSTY_APPLE_BOAT)
                        .unlockedBy("has_planks", has(ModItems.FROSTY_APPLE_BOAT))
                        .group("chest_boat")
                        .save(exporter);

                woodFromLogs(ModBlocks2.APPLE_WOOD, ModBlocks2.APPLE_LOG);
                woodFromLogs(ModBlocks2.STRIPPED_APPLE_WOOD, ModBlocks2.STRIPPED_APPLE_LOG);
                woodFromLogs(ModBlocks2.TEST_APPLE_WOOD, ModBlocks2.TEST_APPLE_LOG);
                woodFromLogs(ModBlocks2.STRIPPED_TEST_APPLE_WOOD, ModBlocks2.STRIPPED_TEST_APPLE_LOG);
                woodFromLogs(ModBlocks2.FROSTY_APPLE_WOOD, ModBlocks2.FROSTY_APPLE_LOG);
                woodFromLogs(ModBlocks2.STRIPPED_FROSTY_APPLE_WOOD, ModBlocks2.STRIPPED_FROSTY_APPLE_LOG);

            }
        };
    }

    public static final BlockFamily APPLE_WOOD_FAMILY = BlockFamilies.familyBuilder(ModBlocks2.APPLE_PLANKS)
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
            .recipeGroupPrefix("wooden")
            //.group("mod_all_apple")
            .recipeUnlockedBy("has_apple_planks")
            .getFamily();

    public static final BlockFamily TEST_APPLE_WOOD_FAMILY = BlockFamilies.familyBuilder(ModBlocks2.TEST_APPLE_PLANKS)
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
            .recipeGroupPrefix("wooden")
            //.group("mod_all_apple")
            .recipeUnlockedBy("has_apple_planks")
            .getFamily();

    public static final BlockFamily FROSTY_APPLE_WOOD_FAMILY = BlockFamilies.familyBuilder(ModBlocks2.FROSTY_APPLE_PLANKS)
            .stairs(ModBlocks2.FROSTY_APPLE_STAIRS)
            .slab(ModBlocks2.FROSTY_APPLE_SLAB)
            .fence(ModBlocks2.FROSTY_APPLE_FENCE)
            .fenceGate(ModBlocks2.FROSTY_APPLE_FENCE_GATE)
            .door(ModBlocks2.FROSTY_APPLE_DOOR)
            .trapdoor(ModBlocks2.FROSTY_APPLE_TRAPDOOR)
            .pressurePlate(ModBlocks2.FROSTY_APPLE_PRESSURE_PLATE)
            .button(ModBlocks2.FROSTY_APPLE_BUTTON)

            .sign(ModBlocks2.FROSTY_APPLE_STANDING_SIGN, ModBlocks2.FROSTY_APPLE_WALL_SIGN)
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_apple_planks")
            .getFamily();

    @Override
    public String getName() {
        return "";
    }

}
