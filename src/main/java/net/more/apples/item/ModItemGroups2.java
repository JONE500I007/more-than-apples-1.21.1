package net.more.apples.item;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.more.apples.MoreThanApples;
import net.more.apples.potion.ModPotions;


public class ModItemGroups2 {

    public static final CreativeModeTab ZPOTION_ICON = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "zpotion_icon"),
            FabricCreativeModeTab.builder()
                    .icon(() -> {
                        ItemStack potionIcon = new ItemStack(Items.POTION);
                        potionIcon.set(DataComponents.POTION_CONTENTS, new PotionContents(ModPotions.DARKNESS_IMMUNE_POTION));
                        return potionIcon;
                    })

                    .title(Component.translatable("itemgroup.more-than-apples.zpotion_icon"))
                    .displayItems(((displayContext, entries) -> {

                        ItemStack darknessPotion = new ItemStack(Items.POTION);
                        darknessPotion.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.DARKNESS_IMMUNE_POTION));
                        entries.accept(darknessPotion);
                        ItemStack darkness_lPotion = new ItemStack(Items.POTION);
                        darkness_lPotion.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.DARKNESS_IMMUNE_POTION_L));
                        entries.accept(darkness_lPotion);

                        ItemStack darknessPotionSP = new ItemStack(Items.SPLASH_POTION);
                        darknessPotionSP.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.DARKNESS_IMMUNE_POTION));
                        entries.accept(darknessPotionSP);
                        ItemStack darkness_lPotionSP = new ItemStack(Items.SPLASH_POTION);
                        darkness_lPotionSP.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.DARKNESS_IMMUNE_POTION_L));
                        entries.accept(darkness_lPotionSP);

                        ItemStack darknessPotionLI = new ItemStack(Items.LINGERING_POTION);
                        darknessPotionLI.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.DARKNESS_IMMUNE_POTION));
                        entries.accept(darknessPotionLI);
                        ItemStack darkness_lPotionLI = new ItemStack(Items.LINGERING_POTION);
                        darkness_lPotionLI.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.DARKNESS_IMMUNE_POTION_L));
                        entries.accept(darkness_lPotionLI);



                        ItemStack slownessPotion = new ItemStack(Items.POTION);
                        slownessPotion.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.SLOWNESS_IMMUNE_POTION));
                        entries.accept(slownessPotion);
                        ItemStack slowness_lPotion = new ItemStack(Items.POTION);
                        slowness_lPotion.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.SLOWNESS_IMMUNE_POTION_L));
                        entries.accept(slowness_lPotion);

                        ItemStack slownessPotionSP = new ItemStack(Items.SPLASH_POTION);
                        slownessPotionSP.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.SLOWNESS_IMMUNE_POTION));
                        entries.accept(slownessPotionSP);
                        ItemStack slowness_lPotionSP = new ItemStack(Items.SPLASH_POTION);
                        slowness_lPotionSP.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.SLOWNESS_IMMUNE_POTION_L));
                        entries.accept(slowness_lPotionSP);

                        ItemStack slownessPotionLI = new ItemStack(Items.LINGERING_POTION);
                        slownessPotionLI.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.SLOWNESS_IMMUNE_POTION));
                        entries.accept(slownessPotionLI);
                        ItemStack slowness_lPotionLI = new ItemStack(Items.LINGERING_POTION);
                        slowness_lPotionLI.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.SLOWNESS_IMMUNE_POTION_L));
                        entries.accept(slowness_lPotionLI);



                        ItemStack miningFatiguePotion = new ItemStack(Items.POTION);
                        miningFatiguePotion.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.MINING_FATIGUE_IMMUNE_POTION));
                        entries.accept(miningFatiguePotion);
                        ItemStack miningFatigue_lPotion = new ItemStack(Items.POTION);
                        miningFatigue_lPotion.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.MINING_FATIGUE_IMMUNE_POTION_L));
                        entries.accept(miningFatigue_lPotion);

                        ItemStack miningFatiguePotionSP = new ItemStack(Items.SPLASH_POTION);
                        miningFatiguePotionSP.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.MINING_FATIGUE_IMMUNE_POTION));
                        entries.accept(miningFatiguePotionSP);
                        ItemStack miningFatigue_lPotionSP = new ItemStack(Items.SPLASH_POTION);
                        miningFatigue_lPotionSP.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.MINING_FATIGUE_IMMUNE_POTION_L));
                        entries.accept(miningFatigue_lPotionSP);

                        ItemStack miningFatiguePotionLI = new ItemStack(Items.LINGERING_POTION);
                        miningFatiguePotionLI.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.MINING_FATIGUE_IMMUNE_POTION));
                        entries.accept(miningFatiguePotionLI);
                        ItemStack miningFatigue_lPotionLI = new ItemStack(Items.LINGERING_POTION);
                        miningFatigue_lPotionLI.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.MINING_FATIGUE_IMMUNE_POTION_L));
                        entries.accept(miningFatigue_lPotionLI);



                        ItemStack freezingPotion = new ItemStack(Items.POTION);
                        freezingPotion.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.FREEZING_RESISTANCE_POTION));
                        entries.accept(freezingPotion);
                        ItemStack freezing_lPotion = new ItemStack(Items.POTION);
                        freezing_lPotion.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.FREEZING_RESISTANCE_POTION_L));
                        entries.accept(freezing_lPotion);

                        ItemStack freezingPotionSP = new ItemStack(Items.SPLASH_POTION);
                        freezingPotionSP.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.FREEZING_RESISTANCE_POTION));
                        entries.accept(freezingPotionSP);
                        ItemStack freezing_lPotionSP = new ItemStack(Items.SPLASH_POTION);
                        freezing_lPotionSP.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.FREEZING_RESISTANCE_POTION_L));
                        entries.accept(freezing_lPotionSP);

                        ItemStack freezingPotionLI = new ItemStack(Items.LINGERING_POTION);
                        freezingPotionLI.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.FREEZING_RESISTANCE_POTION));
                        entries.accept(freezingPotionLI);
                        ItemStack freezing_lPotionLI = new ItemStack(Items.LINGERING_POTION);
                        freezing_lPotionLI.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.FREEZING_RESISTANCE_POTION_L));
                        entries.accept(freezing_lPotionLI);



                        ItemStack night_visionPotion = new ItemStack(Items.POTION);
                        night_visionPotion.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.NIGHT_VISION_POTION_V1));
                        entries.accept(night_visionPotion);
                        ItemStack night_visionPotionSP = new ItemStack(Items.SPLASH_POTION);
                        night_visionPotionSP.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.NIGHT_VISION_POTION_V1));
                        entries.accept(night_visionPotionSP);
                        ItemStack night_visionPotionLI = new ItemStack(Items.LINGERING_POTION);
                        night_visionPotionLI.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.NIGHT_VISION_POTION_V1));
                        entries.accept(night_visionPotionLI);


                        ItemStack CallofApplePotion = new ItemStack(Items.POTION);
                        CallofApplePotion.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.CALL_OF_APPLE_POTION));
                        entries.accept(CallofApplePotion);
                        ItemStack CallofApple_lPotion = new ItemStack(Items.POTION);
                        CallofApple_lPotion.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.CALL_OF_APPLE_POTION_L));
                        entries.accept(CallofApple_lPotion);

                        ItemStack CallofApplePotionSP = new ItemStack(Items.SPLASH_POTION);
                        CallofApplePotionSP.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.CALL_OF_APPLE_POTION));
                        entries.accept(CallofApplePotionSP);
                        ItemStack CallofApple_lPotionSP = new ItemStack(Items.SPLASH_POTION);
                        CallofApple_lPotionSP.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.CALL_OF_APPLE_POTION_L));
                        entries.accept(CallofApple_lPotionSP);

                        ItemStack CallofApplePotionLI = new ItemStack(Items.LINGERING_POTION);
                        CallofApplePotionLI.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.CALL_OF_APPLE_POTION));
                        entries.accept(CallofApplePotionLI);
                        ItemStack CallofApple_lPotionLI = new ItemStack(Items.LINGERING_POTION);
                        CallofApple_lPotionLI.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.CALL_OF_APPLE_POTION_L));
                        entries.accept(CallofApple_lPotionLI);



                        ItemStack darknessArrow = new ItemStack(Items.TIPPED_ARROW);
                        darknessArrow.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.DARKNESS_IMMUNE_POTION));
                        entries.accept(darknessArrow);
                        ItemStack darkness_lArrow = new ItemStack(Items.TIPPED_ARROW);
                        darkness_lArrow.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.DARKNESS_IMMUNE_POTION_L));
                        entries.accept(darkness_lArrow);

                        ItemStack slownessArrow = new ItemStack(Items.TIPPED_ARROW);
                        slownessArrow.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.SLOWNESS_IMMUNE_POTION));
                        entries.accept(slownessArrow);
                        ItemStack slowness_lArrow = new ItemStack(Items.TIPPED_ARROW);
                        slowness_lArrow.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.SLOWNESS_IMMUNE_POTION_L));
                        entries.accept(slowness_lArrow);

                        ItemStack miningFatigueArrow = new ItemStack(Items.TIPPED_ARROW);
                        miningFatigueArrow.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.MINING_FATIGUE_IMMUNE_POTION));
                        entries.accept(miningFatigueArrow);
                        ItemStack miningFatigue_lArrow = new ItemStack(Items.TIPPED_ARROW);
                        miningFatigue_lArrow.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.MINING_FATIGUE_IMMUNE_POTION_L));
                        entries.accept(miningFatigue_lArrow);

                        ItemStack freezingArrow = new ItemStack(Items.TIPPED_ARROW);
                        freezingArrow.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.FREEZING_RESISTANCE_POTION));
                        entries.accept(freezingArrow);
                        ItemStack freezing_lArrow = new ItemStack(Items.TIPPED_ARROW);
                        freezing_lArrow.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.FREEZING_RESISTANCE_POTION_L));
                        entries.accept(freezing_lArrow);

                        ItemStack night_visionArrow = new ItemStack(Items.TIPPED_ARROW);
                        night_visionArrow.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.NIGHT_VISION_POTION_V1));
                        entries.accept(night_visionArrow);

                        ItemStack CallofAppleArrow = new ItemStack(Items.TIPPED_ARROW);
                        CallofAppleArrow.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.CALL_OF_APPLE_POTION));
                        entries.accept(CallofAppleArrow);
                        ItemStack CallofApple_lArrow = new ItemStack(Items.TIPPED_ARROW);
                        CallofApple_lArrow.set(DataComponents.POTION_CONTENTS,
                                new PotionContents(ModPotions.CALL_OF_APPLE_POTION_L));
                        entries.accept(CallofApple_lArrow);

                    }))
                    .build());
    
    public static void registerItemGroups2() {
        MoreThanApples.LOGGER.info("Registering Item Groups for " + MoreThanApples.MOD_ID);
    }
}
