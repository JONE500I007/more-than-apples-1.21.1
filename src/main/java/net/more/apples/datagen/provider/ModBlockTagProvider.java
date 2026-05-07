package net.more.apples.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.more.apples.datagen.tag.AppleTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        AppleTags.addBlockTags(this);
        //TestAppleTags.addBlockTags(this);
        //FrostyTags.addBlockTags(this);
    }

    public void addToTag(TagKey<Block> tag, Block... blocks) {
        valueLookupBuilder(tag).add(blocks);
    }
}
