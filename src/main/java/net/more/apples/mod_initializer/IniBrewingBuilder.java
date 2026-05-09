package net.more.apples.mod_initializer;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricPotionBrewingBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import net.more.apples.potion.ModPotions;

public class IniBrewingBuilder implements ModInitializer {
    @Override
    public void onInitialize() {
        FabricPotionBrewingBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD,Ingredient.of(ModAppleFoodItems.DIAMOND_CARROT), ModPotions.NIGHT_VISION_POTION_V1);
        });
        FabricPotionBrewingBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, Ingredient.of(ModAppleFoodItems.TEST_APPLE), ModPotions.CALL_OF_APPLE_POTION);
            builder.registerPotionRecipe(ModPotions.CALL_OF_APPLE_POTION, Ingredient.of(Items.REDSTONE), ModPotions.CALL_OF_APPLE_POTION_L);
        });

        FabricPotionBrewingBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD,Ingredient.of(ModAppleFoodItems.GREEN_APPLE), Potions.LUCK);
        });
    }
}
