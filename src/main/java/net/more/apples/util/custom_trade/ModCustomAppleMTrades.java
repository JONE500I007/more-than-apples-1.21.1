package net.more.apples.util.custom_trade;

import net.minecraft.util.Util;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.*;
import net.more.apples.MoreThanApples;
import net.more.apples.block.ModBlocks2;
import net.more.apples.item.ModItems;
import net.more.apples.potion.ModPotions;
import net.more.apples.villager.ModAppleVillagers;

import java.util.List;
import java.util.Optional;

public class ModCustomAppleMTrades {
    public static void registerCustomTrades() {
        MoreThanApples.LOGGER.info("Registering Villager Trades From " + MoreThanApples.MOD_ID);

        MerchantOffer.createFromStream(ModAppleVillagers.APPLE_MASTER_KEY,1, factories -> {
            factories.add((world,entity,random) -> new MerchantOffer(
                    new ItemCost(Items.APPLE, 9),
                    Optional.empty(),
                    new ItemStack(Items.EMERALD, 1),
                    16, 2, 0.05f
            ));
            factories.add((world,entity,random) -> new MerchantOffer(
                    new ItemCost(ModBlocks2.APPLE_SAPLING, 16),
                    Optional.empty(),
                    new ItemStack(Items.EMERALD, 1),
                    18, 2, 0.05f
            ));
            factories.add((world,entity,random) -> new MerchantOffer(
                    new ItemCost(Items.STICK, 30),
                    Optional.empty(),
                    new ItemStack(Items.EMERALD, 1),
                    16, 2, 0.05f
            ));
        });


        TradeOfferHelper.registerVillagerOffers(ModAppleVillagers.APPLE_MASTER_KEY,2, factories -> {
            factories.add((world,entity,random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 4),
                    Optional.empty(),
                    new ItemStack(ModBlocks2.APPLE_LOG, 1),
                    14, 5, 0.08f
            ));
            factories.add((world,entity,random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 4),
                    Optional.empty(),
                    new ItemStack(ModBlocks2.FROSTY_APPLE_LOG, 1),
                    14, 5, 0.08f
            ));
            factories.add((world,entity,random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 4),
                    Optional.empty(),
                    new ItemStack(Items.OAK_LOG, 1),
                    14, 5, 0.08f
            ));
            factories.add((world,entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 4),
                    Optional.empty(),
                    new ItemStack(Items.BIRCH_LOG, 1),
                    14, 5, 0.08f
            ));
            factories.add((world,entity,random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 4),
                    Optional.empty(),
                    new ItemStack(Items.DARK_OAK_LOG, 1),
                    14, 5, 0.08f
            ));
            factories.add((world,entity,random) -> new TradeOffer(
                    new TradedItem(ModBlocks2.GOLDEN_APPLE_SAPLING, 8),
                    Optional.empty(),
                    new ItemStack(Items.EMERALD, 3),
                    18, 5, 0.08f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModAppleVillagers.APPLE_MASTER_KEY,3, factories -> {
            factories.add((world,entity,random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 9),
                    Optional.empty(),
                    new ItemStack(Items.GOLD_INGOT, 1),
                    16, 10, 0.1f
            ));
            factories.add((world,entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD_BLOCK, 3),
                    Optional.empty(),
                    new ItemStack(Items.GOLDEN_APPLE, 1),
                    6, 10, 0.2f
            ));
            factories.add((world,entity,random) -> {
                ItemStack randomPick  = new ItemStack(Items.GOLDEN_PICKAXE);
                var enchantments = entity
                        .getRegistryManager()
                        .getOrThrow(RegistryKeys.ENCHANTMENT)
                        .streamEntries()
                        .map(ref -> (RegistryEntry<Enchantment>) ref)
                        .filter(entry -> entry.value().isPrimaryItem(randomPick));


                EnchantmentHelper.enchant(random, randomPick, 25, enchantments);
                return new TradeOffer(
                        new TradedItem(Items.EMERALD, 8),
                        randomPick,
                        2, 10, 0.1f
                );
            });
        });

        TradeOfferHelper.registerVillagerOffers(ModAppleVillagers.APPLE_MASTER_KEY,4, factories -> {
            factories.add((world,entity,random) -> new TradeOffer(
                    new TradedItem(ModBlocks2.TEST_APPLE_LOG, 1),
                    Optional.empty(),
                    new ItemStack(Items.EMERALD_BLOCK, 1),
                    18, 15, 0.08f
            ));
            factories.add((world,entity,random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD_BLOCK, 7),
                    Optional.empty(),
                    new ItemStack(ModItems.DIAMOND_APPLE, 1),
                    6, 15, 0.08f
            ));
            factories.add((world,entity,random) -> {
                ItemStack healingPotion = new ItemStack(Items.POTION);
                healingPotion.set(DataComponentTypes.POTION_CONTENTS,
                        new PotionContentsComponent(ModPotions.FREEZING_RESISTANCE_POTION));
                return new TradeOffer(
                        new TradedItem(Items.EMERALD, 16),
                        healingPotion,
                        4, 15, 0.08f
                );
            });
            factories.add((world,entity,random) -> {
                ItemStack healingPotion = new ItemStack(Items.POTION);
                healingPotion.set(DataComponentTypes.POTION_CONTENTS,
                        new PotionContentsComponent(ModPotions.DARKNESS_IMMUNE_POTION));
                return new TradeOffer(
                        new TradedItem(Items.EMERALD, 23),
                        healingPotion,
                        4, 15, 0.08f
                );
            });
        });

        TradeOfferHelper.registerVillagerOffers(ModAppleVillagers.APPLE_MASTER_KEY,5, factories -> {
            factories.add((world,entity, random) -> {
                if (random.nextFloat() < 0.3f) {
                    return new TradeOffer(
                            new TradedItem(Items.DIRT, 1),
                            new ItemStack(Items.DIAMOND, 1),
                            1, 35, 0.2f
                    );
                }
                return null;
//                return new TradeOffer(
//                        new TradedItem(Items.DIRT, 1),
//                        new ItemStack(Items.GRAVEL, 1),
//                        1, 10, 0.05f
//                );
            });
            factories.add((world,entity,random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD_BLOCK, 15),
                    Optional.empty(),
                    new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 1),
                    3, 35, 0.2f
            ));
            factories.add((world,entity,random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD_BLOCK, 13),
                    Optional.empty(),
                    new ItemStack(ModItems.NETHERITE_APPLE, 1),
                    2, 35, 0.2f
            ));
        });

        /*
        TradeOfferHelper.registerVillagerOffers(ModAppleVillagers.APPLE_MASTER,4, factories -> {
            factories.add((entity, random) -> {
                ItemStack healingPotion = new ItemStack(Items.POTION);
                healingPotion.set(DataComponentTypes.POTION_CONTENTS,
                        new PotionContentsComponent(Potions.STRENGTH));
                return new TradeOffer(
                        new TradedItem(Items.EMERALD, 5),
                        healingPotion,
                        8, 10, 0.05f
                );
            });
            factories.add((entity, random) -> {
                ItemStack healingPotion = new ItemStack(Items.POTION);

                healingPotion.set(DataComponentTypes.POTION_CONTENTS,
                        new PotionContentsComponent(
                                Optional.of(Potions.HEALING),
                                Optional.empty(),
                                List.of(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1))));

                return new TradeOffer(
                        new TradedItem(Items.EMERALD, 5),
                        healingPotion,
                        8, 10, 0.05f);
            });

            factories.add((entity, random) -> {
                ItemStack healingPotion = new ItemStack(Items.POTION);

                healingPotion.set(DataComponentTypes.POTION_CONTENTS,
                        new PotionContentsComponent(
                                Optional.empty(),
                                Optional.empty(),
                                List.of(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1))));

                return new TradeOffer(
                        new TradedItem(Items.EMERALD, 5),
                        healingPotion,
                        8, 10, 0.05f);
            });

            /*
            factories.add((entity, random) -> {
                List<PotionContentsComponent> possiblePotions = List.of(
                        new PotionContentsComponent(Optional.of(Potions.HEALING), Optional.empty(),
                                List.of(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1))),
                        new PotionContentsComponent(Optional.of(Potions.STRENGTH), Optional.empty(),
                                List.of(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0))),
                        new PotionContentsComponent(Optional.of(Potions.FIRE_RESISTANCE), Optional.empty(),
                                List.of()),
                        new PotionContentsComponent(Optional.of(Potions.SWIFTNESS), Optional.empty(),
                                List.of(new StatusEffectInstance(StatusEffects.SPEED, 300, 1))),
                        new PotionContentsComponent(Optional.of(Potions.REGENERATION), Optional.empty(),
                                List.of(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200, 0)))
                );

                PotionContentsComponent randomPotion = Util.getRandom(possiblePotions, random);

                ItemStack potionItem = new ItemStack(Items.POTION);
                potionItem.set(DataComponentTypes.POTION_CONTENTS, randomPotion);

                return new TradeOffer(
                        new TradedItem(Items.EMERALD, 6), // จ่าย 6 emerald
                        potionItem,                        // ได้ potion สุ่ม
                        8, 10, 0.05f
                );
            });

        });
         */
        /*
        TradeOfferHelper.registerVillagerOffers(ModAppleVillagers.APPLE_MASTER, 3, factories -> {
            factories.add((entity, random) -> {
                ItemStack enchantedPickaxe = new ItemStack(Items.DIAMOND_PICKAXE);

                var enchantmentRegistry = entity.getWorld().getRegistryManager().get(RegistryKeys.ENCHANTMENT);
                var efficiency = enchantmentRegistry.getEntry(Enchantments.EFFICIENCY).orElseThrow();
                var unbreaking = enchantmentRegistry.getEntry(Enchantments.UNBREAKING).orElseThrow();

                enchantedPickaxe.addEnchantment(efficiency, 3);
                enchantedPickaxe.addEnchantment(unbreaking, 2);

                return new TradeOffer(
                        new TradedItem(Items.EMERALD, 6),
                        enchantedPickaxe,
                        2, 20, 0.08f);
            });

            factories.add((entity, random) -> {
                ItemStack randomPick = new ItemStack(Items.GOLDEN_PICKAXE);
                // for first random enchant
//                var enchantments = entity.getWorld()
//                        .getRegistryManager()
//                        .getWrapperOrThrow(RegistryKeys.ENCHANTMENT)
//                        .streamEntries()
//                        .map(ref -> (RegistryEntry<Enchantment>) ref)
//                        .filter(entry -> entry.value().isPrimaryItem(randomPick));
                var allEnchantments = new ArrayList<>(
                        entity.getWorld()
                                .getRegistryManager()
                                .getWrapperOrThrow(RegistryKeys.ENCHANTMENT)
                                .streamEntries()
                                .map(ref -> (RegistryEntry<Enchantment>) ref)
                                .filter(entry -> entry.value().isPrimaryItem(randomPick))
                                .toList()

                // this for random all enchantmen
                var enchantments = entity.getWorld()
                        .getRegistryManager()
                        .getWrapperOrThrow(RegistryKeys.ENCHANTMENT)
                        .streamEntries()
                        .map(ref -> (RegistryEntry<Enchantment>) ref);
                );
                // and this for first random enchant
                //EnchantmentHelper.enchant(random, randomPick, 25, enchantments);
                //List<EnchantmentLevelEntry> list = EnchantmentHelper.generateEnchantments(random, randomPick, 25, enchantments);
                List<EnchantmentLevelEntry> list = new ArrayList<>(EnchantmentHelper.generateEnchantments(
                        random, randomPick, 25, allEnchantments.stream()));

                int tries = 0;
                while (list.size() < 3 && tries < 5) {
                    List<EnchantmentLevelEntry> extra = EnchantmentHelper.generateEnchantments(
                            random, randomPick, 25, allEnchantments.stream());
                    list.addAll(extra);
                    list = new ArrayList<>(list.stream().distinct().limit(5).toList());
                    tries++;
                }
//                int tries = 0;
//                while (list.size() < 3 && tries < 5) {
//                    List<EnchantmentLevelEntry> extra = EnchantmentHelper.generateEnchantments(
//                            random, randomPick, 25, allEnchantments.stream());
//                    list.addAll(extra);
//                    list = list.stream().distinct().limit(5).toList();
//                    tries++;
//                }
//                while (list.size() < 3) {
//                    List<EnchantmentLevelEntry> extra = EnchantmentHelper.generateEnchantments(random, randomPick, 25, enchantments);
//                    list.addAll(extra);
//                }
//                list = list.stream().distinct().limit(3).toList();
//                if (list.size() > 2) {
//                    list = list.subList(0, 2);
//                }

                for (var entry : list) {
                    randomPick.addEnchantment(entry.enchantment, entry.level);
                }

                return new TradeOffer(
                        new TradedItem(Items.EMERALD, 8),
                        randomPick,
                        2, 20, 0.08f
                );
            });
        });
         */
    }
}
