package net.more.apples.datagen;

import net.minecraft.data.DataOutput;

import net.minecraft.data.tag.TagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PointOfInterestTypeTags;
import net.minecraft.registry.tag.TagBuilder;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;
import net.more.apples.MoreThanApples;

import java.util.concurrent.CompletableFuture;

public class ModPoiTagProvider extends TagProvider<PointOfInterestType> {
    public ModPoiTagProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.POINT_OF_INTEREST_TYPE, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        TagKey<PointOfInterestType> jobSiteTag = PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE;
        TagBuilder builder = this.getTagBuilder(jobSiteTag);
        builder.addOptional(Identifier.of(MoreThanApples.MOD_ID, "apple_poi"));
    }
}
