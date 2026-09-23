package net.more.apples.util;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.component.CookingFuel;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;


public class ModFuels {
    public static void add(DefaultItemComponentEvents.ModifyContext context, ItemLike item, ResourceKey<ContextIntProvider> burnTime) {
        context.modify(item.asItem(), builder -> builder.set(DataComponents.COOKING_FUEL,
                new CookingFuel(burnTime, ContextFloatProviders.COOKING_DEFAULT_SPEED_MULTIPLIER)));
    }
}
