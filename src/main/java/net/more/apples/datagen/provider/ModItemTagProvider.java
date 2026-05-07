package net.more.apples.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.more.apples.datagen.tag.ItemTagsPr;
import net.more.apples.datagen.tag.apples_tag.AppleTags;
import net.more.apples.datagen.tag.apples_tag.FrostyTags;
import net.more.apples.datagen.tag.apples_tag.TestAppleTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        AppleTags.addItemTags(this);
        TestAppleTags.addItemTags(this);
        FrostyTags.addItemTags(this);
        ItemTagsPr.addItemTags(this);
    }

    public void addToTag(TagKey<Item> tag, Item... items) {
        valueLookupBuilder(tag).add(items);
    }
}
