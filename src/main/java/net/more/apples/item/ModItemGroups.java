package net.more.apples.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.block.ModBlocks;
import net.more.apples.potion.ModPotions;

public class ModItemGroups {

    public static final ItemGroup DIAMOND_APPLE_ICON = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MoreThanApples.MOD_ID, "diamond_apple_icon"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.DIAMOND_APPLE))
                    .displayName(Text.translatable("itemgroup.more-than-apples.diamond_apple_icon"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.DIAMOND_NUGGET);
                        entries.add(ModItems.DIAMOND_APPLE);
                        entries.add(ModItems.ENCHANTED_DIAMOND_APPLE);
                        entries.add(ModItems.DIAMOND_CARROT);


                        ItemStack darknessPotion = new ItemStack(Items.POTION);
                        darknessPotion.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.DARKNESS_IMMUNE_POTION));
                        entries.add(darknessPotion);
                        ItemStack darkness_lPotion = new ItemStack(Items.POTION);
                        darkness_lPotion.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.DARKNESS_IMMUNE_POTION_L));
                        entries.add(darkness_lPotion);

                        ItemStack darknessPotionSP = new ItemStack(Items.SPLASH_POTION);
                        darknessPotionSP.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.DARKNESS_IMMUNE_POTION));
                        entries.add(darknessPotionSP);
                        ItemStack darkness_lPotionSP = new ItemStack(Items.SPLASH_POTION);
                        darkness_lPotionSP.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.DARKNESS_IMMUNE_POTION_L));
                        entries.add(darkness_lPotionSP);

                        ItemStack darknessPotionLI = new ItemStack(Items.LINGERING_POTION);
                        darknessPotionLI.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.DARKNESS_IMMUNE_POTION));
                        entries.add(darknessPotionLI);
                        ItemStack darkness_lPotionLI = new ItemStack(Items.LINGERING_POTION);
                        darkness_lPotionLI.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.DARKNESS_IMMUNE_POTION_L));
                        entries.add(darkness_lPotionLI);


                        ItemStack freezingPotion = new ItemStack(Items.POTION);
                        freezingPotion.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.FREEZING_RESOSTANCE_POTION));
                        entries.add(freezingPotion);
                        ItemStack freezing_lPotion = new ItemStack(Items.POTION);
                        freezing_lPotion.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.FREEZING_RESOSTANCE_POTION_l));
                        entries.add(freezing_lPotion);

                        ItemStack freezingPotionSP = new ItemStack(Items.SPLASH_POTION);
                        freezingPotionSP.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.FREEZING_RESOSTANCE_POTION));
                        entries.add(freezingPotionSP);
                        ItemStack freezing_lPotionSP = new ItemStack(Items.SPLASH_POTION);
                        freezing_lPotionSP.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.FREEZING_RESOSTANCE_POTION_l));
                        entries.add(freezing_lPotionSP);

                        ItemStack freezingPotionLI = new ItemStack(Items.LINGERING_POTION);
                        freezingPotionLI.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.FREEZING_RESOSTANCE_POTION));
                        entries.add(freezingPotionLI);
                        ItemStack freezing_lPotionLI = new ItemStack(Items.LINGERING_POTION);
                        freezing_lPotionLI.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.FREEZING_RESOSTANCE_POTION_l));
                        entries.add(freezing_lPotionLI);

                        ItemStack night_visionPotion = new ItemStack(Items.POTION);
                        night_visionPotion.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.NIGHT_VISION_POTION_V1));
                        entries.add(night_visionPotion);
                        ItemStack night_visionPotionSP = new ItemStack(Items.SPLASH_POTION);
                        night_visionPotionSP.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.NIGHT_VISION_POTION_V1));
                        entries.add(night_visionPotionSP);
                        ItemStack night_visionPotionLI = new ItemStack(Items.LINGERING_POTION);
                        night_visionPotionLI.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.NIGHT_VISION_POTION_V1));
                        entries.add(night_visionPotionLI);
                    }))
                    .build());

    public static void registerItemGroups() {
        MoreThanApples.LOGGER.info("Registering Item Groups for " + MoreThanApples.MOD_ID);
    }
}
