package net.more.apples.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.tags.TagBuilder;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.more.apples.MoreThanApples;

import java.io.DataOutput;
import java.util.concurrent.CompletableFuture;

public class ModPoiTagProvider extends FabricTagsProvider<PoiType> {
    public ModPoiTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.POINT_OF_INTEREST_TYPE, registriesFuture);
    }

    /*
    @Override
//    protected void configure(RegistryWrapper.WrapperLookup registries) {
//        this.getTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE)
//                .addOptional(Identifier.of(MoreThanApples.MOD_ID, "apple_poi"));
//    }
    protected void configure(HolderLookup.Provider registries) {
        TagKey<PointOfInterestType> jobSiteTag = PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE;
        TagBuilder builder = this.getTagBuilder(jobSiteTag);
        builder.addOptional(Identifier.of(MoreThanApples.MOD_ID, "apple_poi"));
    }
     */

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        getOrCreateRawBuilder(PoiTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptionalTag(Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "apple_poi"));
    }
}
