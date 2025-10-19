package net.more.apples.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.block.ModBlocks2;
import net.more.apples.item.ModItems;

public class ModBoats {
    public static final Identifier APPLE_BOAT_ID = Identifier.of(MoreThanApples.MOD_ID, "apple_boat");
    public static final Identifier APPLE_CHEST_BOAT_ID = Identifier.of(MoreThanApples.MOD_ID, "apple_chest_boat");

    public static final RegistryKey<TerraformBoatType> APPLE_BOAT_KEY = TerraformBoatTypeRegistry.createKey(APPLE_BOAT_ID);

    public static void registerBoats() {
        TerraformBoatType appleBoat = new TerraformBoatType.Builder()
                .item(ModItems.APPLE_BOAT)
                .chestItem(ModItems.APPLE_CHEST_BOAT)
                .planks(ModBlocks2.APPLE_PLANKS.asItem())
                .build();
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, APPLE_BOAT_KEY, appleBoat);
    }
}
