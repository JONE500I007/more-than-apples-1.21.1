package net.more.apples.datagen.tag.frosty;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.tags.BlockTags;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;

public class FrostyTest {
    public static void add(FabricTagsProvider.BlockTagsProvider provider) {

        provider.valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                .add(AppleWoodBlocks.APPLE_LOG)
                .add(AppleWoodBlocks.APPLE_WOOD);
    }
}
