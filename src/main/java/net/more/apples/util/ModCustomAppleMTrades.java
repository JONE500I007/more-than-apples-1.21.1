package net.more.apples.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.more.apples.MoreThanApples;
import net.more.apples.block.ModBlocks2;
import net.more.apples.item.ModItems;
import net.more.apples.villager.ModAppleVillagers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ModCustomAppleMTrades {
    public static void registerCustomTrades() {
        MoreThanApples.LOGGER.info("Registering Villager Trades From " + MoreThanApples.MOD_ID);

        TradeOfferHelper.registerVillagerOffers(ModAppleVillagers.APPLE_MASTER,1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.APPLE, 9),
                    new ItemStack(Items.EMERALD, 1),
                    16, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModBlocks2.APPLE_SAPLING, 16),
                    new ItemStack(Items.EMERALD, 1),
                    18, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.STICK, 30),
                    new ItemStack(Items.EMERALD, 1),
                    16, 10, 0.05f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModAppleVillagers.APPLE_MASTER,2, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 4),
                    new ItemStack(ModBlocks2.APPLE_LOG, 1),
                    14, 40, 0.08f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 4),
                    new ItemStack(Items.OAK_LOG, 1),
                    14, 40, 0.08f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 4),
                    new ItemStack(Items.BIRCH_LOG, 1),
                    14, 40, 0.08f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 4),
                    new ItemStack(Items.DARK_OAK_LOG, 1),
                    14, 40, 0.08f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModAppleVillagers.APPLE_MASTER,3, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 9),
                    new ItemStack(Items.GOLD_INGOT, 1),
                    8, 20, 0.2f
            ));
            factories.add((entity, random) -> {
                ItemStack randomPick  = new ItemStack(Items.DIAMOND_PICKAXE);
                var enchantments = entity.getWorld()
                        .getRegistryManager()
                        .getWrapperOrThrow(RegistryKeys.ENCHANTMENT)
                        .streamEntries()
                        .map(ref -> (RegistryEntry<Enchantment>) ref)
                        .filter(entry -> entry.value().isPrimaryItem(randomPick));


                EnchantmentHelper.enchant(random, randomPick, 25, enchantments);
                return new TradeOffer(
                        new TradedItem(Items.EMERALD, 8),
                        randomPick,
                        2, 20, 0.08f
                );
            });
        });
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

        TradeOfferHelper.registerVillagerOffers(ModAppleVillagers.APPLE_MASTER,4, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.APPLE, 9),
                    new ItemStack(Items.EMERALD, 1),
                    16, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(ModBlocks2.APPLE_SAPLING, 16),
                    new ItemStack(Items.EMERALD, 1),
                    18, 10, 0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.STICK, 30),
                    new ItemStack(Items.EMERALD, 1),
                    16, 10, 0.05f
            ));
        });
    }
}
