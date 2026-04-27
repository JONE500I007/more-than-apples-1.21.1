package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.more.apples.block.ModBlocks2;
import net.more.apples.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
//        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
//                .add(ModBlocks2.APPLE_PLANKS);
//
//        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
//                .add(ModBlocks2.DEEPSLATE_APPLE_ORE);

        valueLookupBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks2.APPLE_FENCE)
                .add(ModBlocks2.TEST_APPLE_FENCE)
                .add(ModBlocks2.FROSTY_APPLE_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks2.APPLE_FENCE_GATE)
                .add(ModBlocks2.TEST_APPLE_FENCE_GATE)
                .add(ModBlocks2.FROSTY_APPLE_FENCE_GATE);
//        valueLookupBuilder(BlockTags.WALLS)
//                .add(ModBlocks2.APPLE_WALL);

        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks2.APPLE_LOG)
                .add(ModBlocks2.APPLE_WOOD)
                .add(ModBlocks2.STRIPPED_APPLE_LOG)
                .add(ModBlocks2.STRIPPED_APPLE_WOOD)

                .add(ModBlocks2.TEST_APPLE_LOG)
                .add(ModBlocks2.TEST_APPLE_WOOD)
                .add(ModBlocks2.STRIPPED_TEST_APPLE_LOG)
                .add(ModBlocks2.STRIPPED_TEST_APPLE_WOOD)

                .add(ModBlocks2.FROSTY_APPLE_LOG)
                .add(ModBlocks2.FROSTY_APPLE_WOOD)
                .add(ModBlocks2.STRIPPED_FROSTY_APPLE_LOG)
                .add(ModBlocks2.STRIPPED_FROSTY_APPLE_WOOD);

        valueLookupBuilder(BlockTags.PLANKS)
                .add(ModBlocks2.APPLE_PLANKS)
                .add(ModBlocks2.TEST_APPLE_PLANKS)
                .add(ModBlocks2.FROSTY_APPLE_PLANKS);

        valueLookupBuilder(ModTags.Blocks.ALL_APPLE_LOG)
                .add(ModBlocks2.APPLE_LOG)
                .add(ModBlocks2.STRIPPED_APPLE_LOG)
                .add(ModBlocks2.APPLE_WOOD)
                .add(ModBlocks2.STRIPPED_APPLE_WOOD);
        valueLookupBuilder(ModTags.Blocks.ALL_TEST_APPLE_LOG)
                .add(ModBlocks2.TEST_APPLE_LOG)
                .add(ModBlocks2.STRIPPED_TEST_APPLE_LOG)
                .add(ModBlocks2.TEST_APPLE_WOOD)
                .add(ModBlocks2.STRIPPED_TEST_APPLE_WOOD);
        valueLookupBuilder(ModTags.Blocks.ALL_FROSTY_APPLE_LOG)
                .add(ModBlocks2.FROSTY_APPLE_LOG)
                .add(ModBlocks2.STRIPPED_FROSTY_APPLE_LOG)
                .add(ModBlocks2.FROSTY_APPLE_WOOD)
                .add(ModBlocks2.STRIPPED_FROSTY_APPLE_WOOD);



        // --- Stairs ---
        valueLookupBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks2.APPLE_STAIRS)
                .add(ModBlocks2.TEST_APPLE_STAIRS)
                .add(ModBlocks2.FROSTY_APPLE_STAIRS);
        // --- Slab ---
        valueLookupBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks2.APPLE_SLAB)
                .add(ModBlocks2.TEST_APPLE_SLAB)
                .add(ModBlocks2.FROSTY_APPLE_SLAB);
        // --- Fence ---
        valueLookupBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks2.APPLE_FENCE)
                .add(ModBlocks2.TEST_APPLE_FENCE)
                .add(ModBlocks2.FROSTY_APPLE_FENCE);
        // --- Fence Gate ---
        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks2.APPLE_FENCE_GATE)
                .add(ModBlocks2.TEST_APPLE_FENCE_GATE)
                .add(ModBlocks2.FROSTY_APPLE_FENCE_GATE);
        // --- Door ---
        valueLookupBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks2.APPLE_DOOR)
                .add(ModBlocks2.TEST_APPLE_DOOR)
                .add(ModBlocks2.FROSTY_APPLE_DOOR);
        // --- Trapdoor ---
        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks2.APPLE_TRAPDOOR)
                .add(ModBlocks2.TEST_APPLE_TRAPDOOR)
                .add(ModBlocks2.FROSTY_APPLE_TRAPDOOR);
        // --- Button ---
        valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks2.APPLE_BUTTON)
                .add(ModBlocks2.TEST_APPLE_BUTTON)
                .add(ModBlocks2.FROSTY_APPLE_BUTTON);
        // --- Pressure Plate ---
        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks2.APPLE_PRESSURE_PLATE)
                .add(ModBlocks2.TEST_APPLE_PRESSURE_PLATE)
                .add(ModBlocks2.FROSTY_APPLE_PRESSURE_PLATE);


        valueLookupBuilder(BlockTags.WOODEN_SHELVES)
                .add(ModBlocks2.APPLE_SHELF);

//        valueLookupBuilder(ModTags.Blocks.ALL_THE_SHELF)
//                .addTag(BlockTags.WOODEN_SHELVES)
//                .add(ModBlocks2.APPLE_SHELF);

        valueLookupBuilder(ModTags.Blocks.ALL_THE_SHELF)
                .add(
                        ModBlocks2.APPLE_SHELF,
                        Blocks.OAK_SHELF,
                        Blocks.SPRUCE_SHELF,
                        Blocks.BIRCH_SHELF,
                        Blocks.JUNGLE_SHELF,
                        Blocks.ACACIA_SHELF,
                        Blocks.DARK_OAK_SHELF,
                        Blocks.MANGROVE_SHELF,
                        Blocks.CHERRY_SHELF,
                        Blocks.BAMBOO_SHELF,
                        Blocks.CRIMSON_SHELF,
                        Blocks.WARPED_SHELF);





        valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks2.APPLE_BARREL)
                .add(ModBlocks2.APPLE_STANDING_SIGN)
                .add(ModBlocks2.APPLE_WALL_SIGN)
                .add(ModBlocks2.APPLE_HANGING_SIGN_BLOCK)
                .add(ModBlocks2.APPLE_WALL_HANGING_SIGN)

                .add(ModBlocks2.TEST_APPLE_STANDING_SIGN)
                .add(ModBlocks2.TEST_APPLE_WALL_SIGN)
                .add(ModBlocks2.TEST_APPLE_HANGING_SIGN_BLOCK)
                .add(ModBlocks2.TEST_APPLE_WALL_HANGING_SIGN)

                .add(ModBlocks2.FROSTY_APPLE_STANDING_SIGN)
                .add(ModBlocks2.FROSTY_APPLE_WALL_SIGN)
                .add(ModBlocks2.FROSTY_APPLE_HANGING_SIGN_BLOCK)
                .add(ModBlocks2.FROSTY_APPLE_WALL_HANGING_SIGN);
        valueLookupBuilder(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks2.APPLE_LEAVES)
                .add(ModBlocks2.FRUIT_APPLE_LEAVES)
                .add(ModBlocks2.TEST_APPLE_LEAVES)
                .add(ModBlocks2.GOLDEN_APPLE_LEAVES)
                .add(ModBlocks2.FRUIT_GOLDEN_APPLE_LEAVES)
                .add(ModBlocks2.FROSTY_APPLE_LEAVES);
    }
}
