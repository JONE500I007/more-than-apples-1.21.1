package net.more.apples.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.more.apples.MoreThanApples;
import net.more.apples.item.custom.CustomEnchApple;

import java.util.function.Function;

public class ModItemsFoText {

    public static final Item ITEM_TE11 = registerItem("ITEM_te11",
            setting -> new Item(setting
            .food(ModFoodComponents.GREEN_APPLE_FOOD ,ModFoodComponents.GREEN_APPLE_EFFECT)));

    public static final Item DONOT_T1 = registerItem("donot_t1", Item::new);


//    public static final Item DARKNESS_IMMUNE_POTION = registerItem("darkness_immune_potion", new PotionItem(new Item.Settings()
//            .maxCount(1)));


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(MoreThanApples.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreThanApples.MOD_ID, name)))));
    }

    public static void registerModItem(){
        MoreThanApples.LOGGER.info("Registering Mod Items for " + MoreThanApples.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entrise -> {

        });
    }
}
