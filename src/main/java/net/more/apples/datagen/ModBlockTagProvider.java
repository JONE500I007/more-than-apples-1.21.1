package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.more.apples.block.ModBlocks2;
import net.more.apples.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
//        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
//                .add(ModBlocks2.APPLE_PLANKS);
//
//        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
//                .add(ModBlocks2.DEEPSLATE_APPLE_ORE);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks2.APPLE_FENCE)
                .add(ModBlocks2.TEST_APPLE_FENCE)
                .add(ModBlocks2.FROSTY_APPLE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks2.APPLE_FENCE_GATE)
                .add(ModBlocks2.TEST_APPLE_FENCE_GATE)
                .add(ModBlocks2.FROSTY_APPLE_FENCE_GATE);
//        getOrCreateTagBuilder(BlockTags.WALLS)
//                .add(ModBlocks2.APPLE_WALL);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
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

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks2.APPLE_PLANKS)
                .add(ModBlocks2.TEST_APPLE_PLANKS)
                .add(ModBlocks2.FROSTY_APPLE_PLANKS);

        getOrCreateTagBuilder(ModTags.Blocks.ALL_APPLE_LOG)
                .add(ModBlocks2.APPLE_LOG)
                .add(ModBlocks2.STRIPPED_APPLE_LOG)
                .add(ModBlocks2.APPLE_WOOD)
                .add(ModBlocks2.STRIPPED_APPLE_WOOD);
        getOrCreateTagBuilder(ModTags.Blocks.ALL_TEST_APPLE_LOG)
                .add(ModBlocks2.TEST_APPLE_LOG)
                .add(ModBlocks2.STRIPPED_TEST_APPLE_LOG)
                .add(ModBlocks2.TEST_APPLE_WOOD)
                .add(ModBlocks2.STRIPPED_TEST_APPLE_WOOD);
        getOrCreateTagBuilder(ModTags.Blocks.ALL_FROSTY_APPLE_LOG)
                .add(ModBlocks2.FROSTY_APPLE_LOG)
                .add(ModBlocks2.STRIPPED_FROSTY_APPLE_LOG)
                .add(ModBlocks2.FROSTY_APPLE_WOOD)
                .add(ModBlocks2.STRIPPED_FROSTY_APPLE_WOOD);



        // --- Stairs ---
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks2.APPLE_STAIRS)
                .add(ModBlocks2.TEST_APPLE_STAIRS)
                .add(ModBlocks2.FROSTY_APPLE_STAIRS);
        // --- Slab ---
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks2.APPLE_SLAB)
                .add(ModBlocks2.TEST_APPLE_SLAB)
                .add(ModBlocks2.FROSTY_APPLE_SLAB);
        // --- Fence ---
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks2.APPLE_FENCE)
                .add(ModBlocks2.TEST_APPLE_FENCE)
                .add(ModBlocks2.FROSTY_APPLE_FENCE);
        // --- Fence Gate ---
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks2.APPLE_FENCE_GATE)
                .add(ModBlocks2.TEST_APPLE_FENCE_GATE)
                .add(ModBlocks2.FROSTY_APPLE_FENCE_GATE);
        // --- Door ---
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks2.APPLE_DOOR)
                .add(ModBlocks2.TEST_APPLE_DOOR)
                .add(ModBlocks2.FROSTY_APPLE_DOOR);
        // --- Trapdoor ---
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks2.APPLE_TRAPDOOR)
                .add(ModBlocks2.TEST_APPLE_TRAPDOOR)
                .add(ModBlocks2.FROSTY_APPLE_TRAPDOOR);
        // --- Button ---
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks2.APPLE_BUTTON)
                .add(ModBlocks2.TEST_APPLE_BUTTON)
                .add(ModBlocks2.FROSTY_APPLE_BUTTON);
        // --- Pressure Plate ---
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks2.APPLE_PRESSURE_PLATE)
                .add(ModBlocks2.TEST_APPLE_PRESSURE_PLATE)
                .add(ModBlocks2.FROSTY_APPLE_PRESSURE_PLATE);


        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks2.APPLE_BARREL)
                .add(ModBlocks2.APPLE_STANDING_SIGN)
                .add(ModBlocks2.APPLE_WALL_SIGN)
                .add(ModBlocks2.APPLE_HANGING_SIGN)
                .add(ModBlocks2.APPLE_WALL_HANGING_SIGN)

                .add(ModBlocks2.TEST_APPLE_STANDING_SIGN)
                .add(ModBlocks2.TEST_APPLE_WALL_SIGN)
                .add(ModBlocks2.TEST_APPLE_HANGING_SIGN)
                .add(ModBlocks2.TEST_APPLE_WALL_HANGING_SIGN)

                .add(ModBlocks2.FROSTY_APPLE_STANDING_SIGN)
                .add(ModBlocks2.FROSTY_APPLE_WALL_SIGN)
                .add(ModBlocks2.FROSTY_APPLE_HANGING_SIGN)
                .add(ModBlocks2.FROSTY_APPLE_WALL_HANGING_SIGN);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks2.APPLE_LEAVES)
                .add(ModBlocks2.FRUIT_APPLE_LEAVES)
                .add(ModBlocks2.TEST_APPLE_LEAVES)
                .add(ModBlocks2.GOLDEN_APPLE_LEAVES)
                .add(ModBlocks2.FRUIT_GOLDEN_APPLE_LEAVES)
                .add(ModBlocks2.FROSTY_APPLE_LEAVES);
    }
}
