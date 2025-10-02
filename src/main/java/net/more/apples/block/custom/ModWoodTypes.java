package net.more.apples.block.custom;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.more.apples.MoreThanApples;

public class ModWoodTypes {
    // กำหนด BlockSetType ก่อน (ใช้ oak เป็น base)
    public static final BlockSetType CUSTOM_BLOCK_SET =
            new BlockSetType(MoreThanApples.MOD_ID + ":custom");

    // สร้าง WoodType ใหม่
    public static final WoodType CUSTOM_WOOD =
            new WoodType(MoreThanApples.MOD_ID + ":custom", CUSTOM_BLOCK_SET);

    // ต้องมี method นี้เพื่อ force ให้ static ถูก load
    public static void registerWoodTypes() {
        // ตรงนี้ไม่ต้องทำอะไร แต่เรียกจาก main class สักครั้ง
    }
}
