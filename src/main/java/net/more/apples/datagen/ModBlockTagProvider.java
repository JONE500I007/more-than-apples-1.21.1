package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.more.apples.block.ModBlocks2;

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
                .add(ModBlocks2.APPLE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks2.APPLE_FENCE_GATE);
//        getOrCreateTagBuilder(BlockTags.WALLS)
//                .add(ModBlocks2.APPLE_WALL);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks2.APPLE_LOG)
                .add(ModBlocks2.APPLE_WOOD)
                .add(ModBlocks2.STRIPPED_APPLE_LOG)
                .add(ModBlocks2.STRIPPED_APPLE_WOOD)

                .add(ModBlocks2.TEST_APPLE_LOG)
                .add(ModBlocks2.TEST_APPLE_WOOD)
                .add(ModBlocks2.TEST_STRIPPED_APPLE_LOG)
                .add(ModBlocks2.TEST_STRIPPED_APPLE_WOOD);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks2.APPLE_PLANKS)
                .add(ModBlocks2.TEST_APPLE_PLANKS);


    }
}
