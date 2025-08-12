package net.more.apples.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.potion.ModPotions;

public class ModItemGroups2 {

    public static final ItemGroup ZPOTION_ICON = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MoreThanApples.MOD_ID, "zpotion_icon"),
            FabricItemGroup.builder()
                    .icon(() -> {
                        ItemStack potionIcon = new ItemStack(Items.POTION);
                        potionIcon.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(ModPotions.DARKNESS_IMMUNE_POTION));
                        return potionIcon;
                    })

                    .displayName(Text.translatable("itemgroup.more-than-apples.zpotion_icon"))
                    .entries(((displayContext, entries) -> {

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



                        ItemStack slownessPotion = new ItemStack(Items.POTION);
                        slownessPotion.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.SLOWNESS_IMMUNE_POTION));
                        entries.add(slownessPotion);
                        ItemStack slowness_lPotion = new ItemStack(Items.POTION);
                        slowness_lPotion.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.SLOWNESS_IMMUNE_POTION_L));
                        entries.add(slowness_lPotion);

                        ItemStack slownessPotionSP = new ItemStack(Items.SPLASH_POTION);
                        slownessPotionSP.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.SLOWNESS_IMMUNE_POTION));
                        entries.add(slownessPotionSP);
                        ItemStack slowness_lPotionSP = new ItemStack(Items.SPLASH_POTION);
                        slowness_lPotionSP.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.SLOWNESS_IMMUNE_POTION_L));
                        entries.add(slowness_lPotionSP);

                        ItemStack slownessPotionLI = new ItemStack(Items.LINGERING_POTION);
                        slownessPotionLI.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.SLOWNESS_IMMUNE_POTION));
                        entries.add(slownessPotionLI);
                        ItemStack slowness_lPotionLI = new ItemStack(Items.LINGERING_POTION);
                        slowness_lPotionLI.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.SLOWNESS_IMMUNE_POTION_L));
                        entries.add(slowness_lPotionLI);



                        ItemStack miningFatiguePotion = new ItemStack(Items.POTION);
                        miningFatiguePotion.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.MINING_FATIGUE_IMMUNE_POTION));
                        entries.add(miningFatiguePotion);
                        ItemStack miningFatigue_lPotion = new ItemStack(Items.POTION);
                        miningFatigue_lPotion.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.MINING_FATIGUE_IMMUNE_POTION_L));
                        entries.add(miningFatigue_lPotion);

                        ItemStack miningFatiguePotionSP = new ItemStack(Items.SPLASH_POTION);
                        miningFatiguePotionSP.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.MINING_FATIGUE_IMMUNE_POTION));
                        entries.add(miningFatiguePotionSP);
                        ItemStack miningFatigue_lPotionSP = new ItemStack(Items.SPLASH_POTION);
                        miningFatigue_lPotionSP.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.MINING_FATIGUE_IMMUNE_POTION_L));
                        entries.add(miningFatigue_lPotionSP);

                        ItemStack miningFatiguePotionLI = new ItemStack(Items.LINGERING_POTION);
                        miningFatiguePotionLI.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.MINING_FATIGUE_IMMUNE_POTION));
                        entries.add(miningFatiguePotionLI);
                        ItemStack miningFatigue_lPotionLI = new ItemStack(Items.LINGERING_POTION);
                        miningFatigue_lPotionLI.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.MINING_FATIGUE_IMMUNE_POTION_L));
                        entries.add(miningFatigue_lPotionLI);



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

                        ItemStack darknessArrow = new ItemStack(Items.TIPPED_ARROW);
                        darknessArrow.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.DARKNESS_IMMUNE_POTION));
                        entries.add(darknessArrow);
                        ItemStack darkness_lArrow = new ItemStack(Items.TIPPED_ARROW);
                        darkness_lArrow.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.DARKNESS_IMMUNE_POTION_L));
                        entries.add(darkness_lArrow);

                        ItemStack slownessArrow = new ItemStack(Items.TIPPED_ARROW);
                        slownessArrow.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.SLOWNESS_IMMUNE_POTION));
                        entries.add(slownessArrow);
                        ItemStack slowness_lArrow = new ItemStack(Items.TIPPED_ARROW);
                        slowness_lArrow.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.SLOWNESS_IMMUNE_POTION_L));
                        entries.add(slowness_lArrow);

                        ItemStack miningFatigueArrow = new ItemStack(Items.TIPPED_ARROW);
                        miningFatigueArrow.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.MINING_FATIGUE_IMMUNE_POTION));
                        entries.add(miningFatigueArrow);
                        ItemStack miningFatigue_lArrow = new ItemStack(Items.TIPPED_ARROW);
                        miningFatigue_lArrow.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.MINING_FATIGUE_IMMUNE_POTION_L));
                        entries.add(miningFatigue_lArrow);

                        ItemStack freezingArrow = new ItemStack(Items.TIPPED_ARROW);
                        freezingArrow.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.FREEZING_RESOSTANCE_POTION));
                        entries.add(freezingArrow);
                        ItemStack freezing_lArrow = new ItemStack(Items.TIPPED_ARROW);
                        freezing_lArrow.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.FREEZING_RESOSTANCE_POTION_l));
                        entries.add(freezing_lArrow);

                        ItemStack night_visionArrow = new ItemStack(Items.TIPPED_ARROW);
                        night_visionArrow.set(DataComponentTypes.POTION_CONTENTS,
                                new PotionContentsComponent(ModPotions.NIGHT_VISION_POTION_V1));
                        entries.add(night_visionArrow);

                    }))
                    .build());
    
    public static void registerItemGroups2() {
        MoreThanApples.LOGGER.info("Registering Item Groups for " + MoreThanApples.MOD_ID);
    }
}
