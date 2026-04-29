package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.tags.TagBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.more.apples.MoreThanApples;

import java.util.concurrent.CompletableFuture;

public class ModPoiTagProvider extends FabricTagsProvider<PoiType> {
    public ModPoiTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.POINT_OF_INTEREST_TYPE, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        TagKey<PoiType> jobSiteTag = PoiTypeTags.ACQUIRABLE_JOB_SITE;
        TagBuilder builder = this.getOrCreateRawBuilder(jobSiteTag);
        builder.addOptionalElement(Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_poi"));
    }
}
