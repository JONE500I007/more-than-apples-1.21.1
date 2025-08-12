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

                        entries.add(ModItems.NETHERITE_APPLE);
                        entries.add(ModItems.ENCHANTED_NETHERITE_APPLE);


                    }))
                    .build());

    public static void registerItemGroups() {
        MoreThanApples.LOGGER.info("Registering Item Groups for " + MoreThanApples.MOD_ID);
    }
}
