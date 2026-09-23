package net.more.apples.datagen.tag;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.more.apples.block.ore_block.ModBlockOre;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.datagen.provider.ModItemTagProvider;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import net.more.apples.util.ModTags;

public final class ItemTagsPr {
    private ItemTagsPr() {
    }

    public static void addItemTags(ModItemTagProvider provider) {
        provider.addToTag(ModTags.Items.ALL_APPLE,
                Items.APPLE,
                Items.GOLDEN_APPLE,
                Items.ENCHANTED_GOLDEN_APPLE,

                ModAppleFoodItems.GREEN_APPLE,
                ModAppleFoodItems.FROSTY_APPLE,
                ModAppleFoodItems.TEST_APPLE,

                ModAppleFoodItems.DIAMOND_APPLE,
                ModAppleFoodItems.ENCHANTED_DIAMOND_APPLE,

                ModAppleFoodItems.NETHERITE_APPLE,
                ModAppleFoodItems.ENCHANTED_NETHERITE_APPLE
        );

        // --- Apple Blossom ---
        provider.addToTag(BlockItemTags.SMALL_FLOWERS.item(),
                AncientAppleWoodBlocks.APPLE_BLOSSOM.asItem(),
                AncientAppleWoodBlocks.APPLE_BLOSSOMV2.asItem());
        provider.addToTag(ConventionalItemTags.SMALL_FLOWERS,
                AncientAppleWoodBlocks.APPLE_BLOSSOM.asItem(),
                AncientAppleWoodBlocks.APPLE_BLOSSOMV2.asItem());
        provider.addToTag(ItemTags.BEE_FOOD,
                AncientAppleWoodBlocks.APPLE_BLOSSOM.asItem(),
                AncientAppleWoodBlocks.APPLE_BLOSSOMV2.asItem());
        provider.addToTag(ItemTags.SHEARABLE_FROM_COPPER_GOLEM,
                AncientAppleWoodBlocks.APPLE_BLOSSOM.asItem(),
                AncientAppleWoodBlocks.APPLE_BLOSSOMV2.asItem());

        // --- Apple Ores ---
        provider.addToTag(BlockItemTags.ORES.item(),
                ModBlockOre.APPLE_ORE.asItem(),
                ModBlockOre.DEEPSLATE_APPLE_ORE.asItem());
        provider.addToTag(ConventionalItemTags.ORES,
                ModBlockOre.APPLE_ORE.asItem(),
                ModBlockOre.DEEPSLATE_APPLE_ORE.asItem());
        provider.addToTag(ConventionalItemTags.ORES_IN_GROUND_STONE,
                ModBlockOre.APPLE_ORE.asItem());
        provider.addToTag(ConventionalItemTags.ORES_IN_GROUND_DEEPSLATE,
                ModBlockOre.DEEPSLATE_APPLE_ORE.asItem());
        provider.addToTag(ConventionalItemTags.ORE_RATES_DENSE,
                ModBlockOre.APPLE_ORE.asItem(),
                ModBlockOre.DEEPSLATE_APPLE_ORE.asItem());
    }
}
