package net.more.apples.datagen.tag;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.more.apples.block.general_block.ModGeneralBlock;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;
import net.more.apples.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class GeneralBlockTagProvider extends FabricTagsProvider.BlockTagsProvider{
    public GeneralBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(ModTags.Blocks.ALL_THE_SHELF)
                .add(
                        //ModBlocks2.APPLE_SHELF,
                        //ModBlocks2.FLO_APPLE_SHELF,
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
                .add(ModGeneralBlock.APPLE_BARREL)
                .add(AppleWoodVariants.APPLE_STANDING_SIGN)
                .add(AppleWoodVariants.APPLE_WALL_SIGN)
                .add(AppleWoodVariants.APPLE_HANGING_SIGN_BLOCK)
                .add(AppleWoodVariants.APPLE_WALL_HANGING_SIGN)

                .add(TestAppleWoodVariants.TEST_APPLE_STANDING_SIGN)
                .add(TestAppleWoodVariants.TEST_APPLE_WALL_SIGN)
                .add(TestAppleWoodVariants.TEST_APPLE_HANGING_SIGN_BLOCK)
                .add(TestAppleWoodVariants.TEST_APPLE_WALL_HANGING_SIGN)

                .add(FrostyAppleWoodVariants.FROSTY_APPLE_STANDING_SIGN)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_WALL_SIGN)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_HANGING_SIGN_BLOCK)
                .add(FrostyAppleWoodVariants.FROSTY_APPLE_WALL_HANGING_SIGN);

        valueLookupBuilder(BlockTags.MINEABLE_WITH_HOE)
                .add(AppleWoodBlocks.APPLE_LEAVES)
                .add(AppleWoodBlocks.FRUIT_APPLE_LEAVES)
                .add(TestAppleWoodBlocks.TEST_APPLE_LEAVES)
                .add(AppleWoodBlocks.GOLDEN_APPLE_LEAVES)
                .add(AppleWoodBlocks.FRUIT_GOLDEN_APPLE_LEAVES)
                .add(FrostyAppleWoodBlocks.FROSTY_APPLE_LEAVES);
    }
}
