package net.more.apples.world.placed_feature.custom;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.more.apples.MoreThanApples;

public class AncientFeatures {
    public static final Feature<NoneFeatureConfiguration> ANCIENT_APPLE_TREE =
            Registry.register(
                    BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "ancient_apple_tree"),
                    new AncientAppleTreeFeature());

    public static void register() {
        MoreThanApples.LOGGER.info("Registering Mod Features " + MoreThanApples.MOD_ID);
    }
}
