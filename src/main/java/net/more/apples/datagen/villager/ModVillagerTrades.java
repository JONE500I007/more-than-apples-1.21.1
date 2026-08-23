package net.more.apples.datagen.villager;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.more.apples.MoreThanApples;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import net.more.apples.potion.ModPotions;

import java.util.List;
import java.util.Optional;


public class ModVillagerTrades {

    // apple_master / level 1
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_1_APPLE_TO_EMERALD = key("apple_master/1/apple_to_emerald");
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_1_APPLE_SAPLING_TO_EMERALD = key("apple_master/1/apple_sapling_to_emerald");
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_1_STICK_TO_EMERALD = key("apple_master/1/stick_to_emerald");

    // apple_master / level 2
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_2_EMERALD_TO_APPLE_LOG = key("apple_master/2/emerald_to_apple_log");
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_2_EMERALD_TO_BIRCH_LOG = key("apple_master/2/emerald_to_birch_log");
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_2_EMERALD_TO_DARK_OAK_LOG = key("apple_master/2/emerald_to_dark_oak_log");
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_2_EMERALD_TO_FROSTY_APPLE_LOG = key("apple_master/2/emerald_to_frosty_apple_log");
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_2_EMERALD_TO_OAK_LOG = key("apple_master/2/emerald_to_oak_log");
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_2_GOLDEN_APPLE_SAPLING_TO_EMERALD = key("apple_master/2/golden_apple_sapling_to_emerald");

    // apple_master / level 3
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_3_EMERALD_TO_GOLD_INGOT = key("apple_master/3/emerald_to_gold_ingot");
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_3_EMERALD_BLOCK_TO_GOLDEN_APPLE = key("apple_master/3/emerald_block_to_golden_apple");
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_3_EMERALD_TO_ENCHANTED_GOLDEN_PICKAXE = key("apple_master/3/emerald_to_enchanted_golden_pickaxe");

    // apple_master / level 4
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_4_TEST_APPLE_LOG_TO_EMERALD_BLOCK = key("apple_master/4/test_apple_log_to_emerald_block");
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_4_EMERALD_BLOCK_TO_DIAMOND_APPLE = key("apple_master/4/emerald_block_to_diamond_apple");
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_4_EMERALD_TO_FREEZING_RESISTANCE_POTION = key("apple_master/4/emerald_to_freezing_resistance_potion");
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_4_EMERALD_TO_DARKNESS_IMMUNE_POTION = key("apple_master/4/emerald_to_darkness_immune_potion");

    // apple_master / level 5
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_5_DIRT_TO_DIAMOND = key("apple_master/5/dirt_to_diamond");
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_5_EMERALD_BLOCK_TO_ENCHANTED_GOLDEN_APPLE = key("apple_master/5/emerald_block_to_enchanted_golden_apple");
    public static final ResourceKey<VillagerTrade> APPLE_MASTER_5_EMERALD_BLOCK_TO_NETHERITE_APPLE = key("apple_master/5/emerald_block_to_netherite_apple");

    // farmer / level 5 (added into vanilla's own farmer/level_5 tag)
    public static final ResourceKey<VillagerTrade> FARMER_5_EMERALD_TO_DIAMOND_CARROT = key("farmer/5/emerald_to_diamond_carrot");

    // wandering_trader (added into vanilla's own buying/common/uncommon tags)
    public static final ResourceKey<VillagerTrade> WANDERING_TRADER_EMERALD_BLOCK_TO_DIAMOND_APPLE = key("wandering_trader/emerald_block_to_diamond_apple");
    public static final ResourceKey<VillagerTrade> WANDERING_TRADER_EMERALD_BLOCK_TO_DIAMOND_CARROT = key("wandering_trader/emerald_block_to_diamond_carrot");
    public static final ResourceKey<VillagerTrade> WANDERING_TRADER_EMERALD_BLOCK_TO_ENCHANTED_DIAMOND_APPLE = key("wandering_trader/emerald_block_to_enchanted_diamond_apple");
    public static final ResourceKey<VillagerTrade> WANDERING_TRADER_EMERALD_BLOCK_TO_ENCHANTED_GOLDEN_APPLE = key("wandering_trader/emerald_block_to_enchanted_golden_apple");
    public static final ResourceKey<VillagerTrade> WANDERING_TRADER_EMERALD_BLOCK_TO_ENCHANTED_NETHERITE_APPLE = key("wandering_trader/emerald_block_to_enchanted_netherite_apple");
    public static final ResourceKey<VillagerTrade> WANDERING_TRADER_EMERALD_BLOCK_TO_GOLDEN_APPLE = key("wandering_trader/emerald_block_to_golden_apple");
    public static final ResourceKey<VillagerTrade> WANDERING_TRADER_EMERALD_BLOCK_TO_NETHERITE_APPLE = key("wandering_trader/emerald_block_to_netherite_apple");

    public static Holder<VillagerTrade> bootstrap(BootstrapContext<VillagerTrade> context) {
        Optional<HolderSet<Enchantment>> enchantmentsForTradedEquipment =
                context.lookup(Registries.ENCHANTMENT).get(EnchantmentTags.ON_TRADED_EQUIPMENT)
                        .map(named -> named);

        // apple_master / level 1
        register(context, APPLE_MASTER_1_APPLE_TO_EMERALD,
                new VillagerTrade(new TradeCost(Items.APPLE, 9), new ItemStackTemplate(Items.EMERALD),
                        16, 2, 0.05F, Optional.empty(), List.of()));
        register(context, APPLE_MASTER_1_APPLE_SAPLING_TO_EMERALD,
                new VillagerTrade(new TradeCost(AppleWoodBlocks.APPLE_SAPLING, 16), new ItemStackTemplate(Items.EMERALD),
                        18, 2, 0.05F, Optional.empty(), List.of()));
        register(context, APPLE_MASTER_1_STICK_TO_EMERALD,
                new VillagerTrade(new TradeCost(Items.STICK, 30), new ItemStackTemplate(Items.EMERALD),
                        16, 2, 0.05F, Optional.empty(), List.of()));

        // apple_master / level 2
        register(context, APPLE_MASTER_2_EMERALD_TO_APPLE_LOG,
                new VillagerTrade(new TradeCost(Items.EMERALD, 4), new ItemStackTemplate(AppleWoodBlocks.APPLE_LOG.asItem()),
                        14, 5, 0.08F, Optional.empty(), List.of()));
        register(context, APPLE_MASTER_2_EMERALD_TO_BIRCH_LOG,
                new VillagerTrade(new TradeCost(Items.EMERALD, 4), new ItemStackTemplate(Items.BIRCH_LOG),
                        14, 5, 0.08F, Optional.empty(), List.of()));
        register(context, APPLE_MASTER_2_EMERALD_TO_DARK_OAK_LOG,
                new VillagerTrade(new TradeCost(Items.EMERALD, 4), new ItemStackTemplate(Items.DARK_OAK_LOG),
                        14, 5, 0.08F, Optional.empty(), List.of()));
        register(context, APPLE_MASTER_2_EMERALD_TO_FROSTY_APPLE_LOG,
                new VillagerTrade(new TradeCost(Items.EMERALD, 4), new ItemStackTemplate(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG.asItem()),
                        14, 5, 0.08F, Optional.empty(), List.of()));
        register(context, APPLE_MASTER_2_EMERALD_TO_OAK_LOG,
                new VillagerTrade(new TradeCost(Items.EMERALD, 4), new ItemStackTemplate(Items.OAK_LOG),
                        14, 5, 0.08F, Optional.empty(), List.of()));
        register(context, APPLE_MASTER_2_GOLDEN_APPLE_SAPLING_TO_EMERALD,
                new VillagerTrade(new TradeCost(AppleWoodBlocks.GOLDEN_APPLE_SAPLING, 8), new ItemStackTemplate(Items.EMERALD, 3),
                        18, 5, 0.08F, Optional.empty(), List.of()));

        // apple_master / level 3
        register(context, APPLE_MASTER_3_EMERALD_TO_GOLD_INGOT,
                new VillagerTrade(new TradeCost(Items.EMERALD, 9), new ItemStackTemplate(Items.GOLD_INGOT),
                        16, 10, 0.1F, Optional.empty(), List.of()));
        register(context, APPLE_MASTER_3_EMERALD_BLOCK_TO_GOLDEN_APPLE,
                new VillagerTrade(new TradeCost(Items.EMERALD_BLOCK, 3), new ItemStackTemplate(Items.GOLDEN_APPLE),
                        6, 10, 0.2F, Optional.empty(), List.of()));
        register(context, APPLE_MASTER_3_EMERALD_TO_ENCHANTED_GOLDEN_PICKAXE,
                new VillagerTrade(new TradeCost(Items.EMERALD, 8), new ItemStackTemplate(Items.GOLDEN_PICKAXE),
                        2, 10, 0.1F, Optional.empty(),
                        List.of(new EnchantWithLevelsFunction.Builder(ConstantValue.exactly(25.0F))
                                .withOptions(enchantmentsForTradedEquipment)
                                .includeAdditionalCostComponent()
                                .build())));

        // apple_master / level 4
        register(context, APPLE_MASTER_4_TEST_APPLE_LOG_TO_EMERALD_BLOCK,
                new VillagerTrade(new TradeCost(TestAppleWoodBlocks.TEST_APPLE_LOG, 1), new ItemStackTemplate(Items.EMERALD_BLOCK),
                        18, 15, 0.08F, Optional.empty(), List.of()));
        register(context, APPLE_MASTER_4_EMERALD_BLOCK_TO_DIAMOND_APPLE,
                new VillagerTrade(new TradeCost(Items.EMERALD_BLOCK, 7), new ItemStackTemplate(ModAppleFoodItems.DIAMOND_APPLE),
                        6, 15, 0.08F, Optional.empty(), List.of()));
        register(context, APPLE_MASTER_4_EMERALD_TO_FREEZING_RESISTANCE_POTION,
                new VillagerTrade(new TradeCost(Items.EMERALD, 16), new ItemStackTemplate(Items.POTION),
                        4, 15, 0.08F, Optional.empty(),
                        List.of(SetPotionFunction.setPotion(ModPotions.FREEZING_RESISTANCE_POTION).build())));
        register(context, APPLE_MASTER_4_EMERALD_TO_DARKNESS_IMMUNE_POTION,
                new VillagerTrade(new TradeCost(Items.EMERALD, 23), new ItemStackTemplate(Items.POTION),
                        4, 15, 0.08F, Optional.empty(),
                        List.of(SetPotionFunction.setPotion(ModPotions.DARKNESS_IMMUNE_POTION).build())));

        // apple_master / level 5
        register(context, APPLE_MASTER_5_DIRT_TO_DIAMOND,
                new VillagerTrade(new TradeCost(Items.DIRT, 1), new ItemStackTemplate(Items.DIAMOND),
                        1, 35, 0.2F, Optional.of(randomChance(0.3F)), List.of()));
        register(context, APPLE_MASTER_5_EMERALD_BLOCK_TO_ENCHANTED_GOLDEN_APPLE,
                new VillagerTrade(new TradeCost(Items.EMERALD_BLOCK, 15), new ItemStackTemplate(Items.ENCHANTED_GOLDEN_APPLE),
                        3, 35, 0.2F, Optional.empty(), List.of()));
        register(context, APPLE_MASTER_5_EMERALD_BLOCK_TO_NETHERITE_APPLE,
                new VillagerTrade(new TradeCost(Items.EMERALD_BLOCK, 13), new ItemStackTemplate(ModAppleFoodItems.NETHERITE_APPLE),
                        2, 35, 0.2F, Optional.empty(), List.of()));

        // farmer / level 5 addition
        register(context, FARMER_5_EMERALD_TO_DIAMOND_CARROT,
                new VillagerTrade(new TradeCost(Items.EMERALD, 20), new ItemStackTemplate(ModAppleFoodItems.DIAMOND_CARROT, 2),
                        6, 40, 0.2F, Optional.of(randomChance(0.5F)), List.of()));

        // wandering_trader additions
        register(context, WANDERING_TRADER_EMERALD_BLOCK_TO_DIAMOND_APPLE,
                new VillagerTrade(new TradeCost(Items.EMERALD_BLOCK, 7), new ItemStackTemplate(ModAppleFoodItems.DIAMOND_APPLE),
                        10, 200, 0.2F, Optional.empty(), List.of()));
        register(context, WANDERING_TRADER_EMERALD_BLOCK_TO_DIAMOND_CARROT,
                new VillagerTrade(new TradeCost(Items.EMERALD_BLOCK, 4), new ItemStackTemplate(ModAppleFoodItems.DIAMOND_CARROT, 24),
                        5, 40, 0.2F, Optional.empty(), List.of()));
        register(context, WANDERING_TRADER_EMERALD_BLOCK_TO_ENCHANTED_DIAMOND_APPLE,
                new VillagerTrade(new TradeCost(Items.EMERALD_BLOCK, 20), new ItemStackTemplate(ModAppleFoodItems.ENCHANTED_DIAMOND_APPLE),
                        2, 400, 0.2F, Optional.empty(), List.of()));
        register(context, WANDERING_TRADER_EMERALD_BLOCK_TO_ENCHANTED_GOLDEN_APPLE,
                new VillagerTrade(new TradeCost(Items.EMERALD_BLOCK, 17), new ItemStackTemplate(Items.ENCHANTED_GOLDEN_APPLE),
                        2, 350, 0.2F, Optional.empty(), List.of()));
        register(context, WANDERING_TRADER_EMERALD_BLOCK_TO_ENCHANTED_NETHERITE_APPLE,
                new VillagerTrade(new TradeCost(Items.EMERALD_BLOCK, 20), new ItemStackTemplate(ModAppleFoodItems.ENCHANTED_NETHERITE_APPLE),
                        1, 500, 0.2F, Optional.empty(), List.of()));
        register(context, WANDERING_TRADER_EMERALD_BLOCK_TO_GOLDEN_APPLE,
                new VillagerTrade(new TradeCost(Items.EMERALD_BLOCK, 3), new ItemStackTemplate(Items.GOLDEN_APPLE),
                        13, 100, 0.2F, Optional.empty(), List.of()));
        return register(context, WANDERING_TRADER_EMERALD_BLOCK_TO_NETHERITE_APPLE,
                new VillagerTrade(new TradeCost(Items.EMERALD_BLOCK, 14), new ItemStackTemplate(ModAppleFoodItems.NETHERITE_APPLE),
                        2, 200, 0.2F, Optional.empty(), List.of()));
    }

    private static LootItemCondition randomChance(float probability) {
        return LootItemRandomChanceCondition.randomChance(probability).build();
    }

    private static Holder.Reference<VillagerTrade> register(
            BootstrapContext<VillagerTrade> context,
            ResourceKey<VillagerTrade> resourceKey, VillagerTrade villagerTrade) {
        return context.register(resourceKey, villagerTrade);
    }

    private static ResourceKey<VillagerTrade> key(String path) {
        return ResourceKey.create(Registries.VILLAGER_TRADE,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, path));
    }
}
