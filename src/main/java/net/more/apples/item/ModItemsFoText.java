package net.more.apples.item;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.more.apples.MoreThanApples;

import java.util.function.Function;

public class ModItemsFoText {
    public static final Item ITEM_TE11 = registerItem("ITEM_te11",
            Item::new, new Item.Properties()
                    .food(ModFoodComponents.GREEN_APPLE_FOOD)
                    .component(DataComponents.CONSUMABLE, ModFoodComponents.GREEN_APPLE_EFFECT));

    public static final Item ITEM_TE12 = registerItem("ITEM_te12",
            Item::new, new Item.Properties());

    public static final Item HASTE_APPLE = registerItem("haste_apple",
            Item::new, new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(0.3f)
                    .alwaysEdible()
                    .build(), Consumables.defaultFood()
                    .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HASTE, 6000, 2), 1.0F))
                    .build()));


    //public static final Item DONOT_T1 = registerItem("donot_t1", Item::new);


//    public static final Item DARKNESS_IMMUNE_POTION = registerItem("darkness_immune_potion", new PotionItem(new Item.Settings()
//            .maxCount(1)));


    /*
    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(RegistryKeys.ITEM,
                        Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name)))));
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name));
        return Registry.register(BuiltInRegistries.ITEM, key, function.apply(new Item.Properties().setId(key)));
    }
     */

    private static Item registerItem(String name, Function<Item.Properties, Item> factory, Item.Properties settings) {
        Item item = factory.apply(settings.setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.ITEM, ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name)), item);
    }

    public static void registerModItem(){
        MoreThanApples.LOGGER.info("Registering Mod Items for " + MoreThanApples.MOD_ID);

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entrise -> {
//
//        });
    }
}
