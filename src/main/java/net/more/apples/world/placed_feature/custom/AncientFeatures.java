package net.more.apples.world.placed_feature.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.more.apples.MoreThanApples;

public class AncientFeatures {
    public static final MapCodec<? extends Feature> ANCIENT_APPLE_TREE =
            Registry.register(
                    BuiltInRegistries.FEATURE_TYPE,
                    Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "ancient_apple_tree"),
                    AncientAppleTreeFeature.CODEC);

    public static void register() {
        MoreThanApples.LOGGER.info("Registering Mod Features " + MoreThanApples.MOD_ID);
    }
}
