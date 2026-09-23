package net.more.apples.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricBrewingProvider;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import net.more.apples.potion.ModPotions;

// 26.3: brewing mixes are data-driven recipes
public class ModBrewingProvider extends FabricBrewingProvider {
    public ModBrewingProvider(RecipeOutput output) {
        super(output);
    }

    @Override
    protected void buildMixes() {
        this.buildMix(Potions.AWKWARD, ModAppleFoodItems.DIAMOND_CARROT, ModPotions.NIGHT_VISION_POTION_V1);

        this.buildMix(Potions.AWKWARD, ModAppleFoodItems.TEST_APPLE, ModPotions.CALL_OF_APPLE_POTION);
        this.buildMix(ModPotions.CALL_OF_APPLE_POTION, Items.REDSTONE, ModPotions.CALL_OF_APPLE_POTION_L);

        this.buildMix(Potions.AWKWARD, ModAppleFoodItems.GREEN_APPLE, Potions.LUCK);
    }
}
