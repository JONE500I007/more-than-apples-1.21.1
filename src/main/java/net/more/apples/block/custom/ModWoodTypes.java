package net.more.apples.block.custom;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.more.apples.MoreThanApples;

public class ModWoodTypes {
    public static final BlockSetType CUSTOM_BLOCK_SET =
            new BlockSetType(MoreThanApples.MOD_ID + ":custom");

    public static final WoodType CUSTOM_WOOD =
            new WoodType(MoreThanApples.MOD_ID + ":custom", CUSTOM_BLOCK_SET);

    public static void registerWoodTypes() {

    }
}
