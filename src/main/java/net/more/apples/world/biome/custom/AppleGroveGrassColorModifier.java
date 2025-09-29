package net.more.apples.world.biome.custom;

import net.minecraft.world.biome.BiomeEffects;

public class AppleGroveGrassColorModifier  {
    public static int getModifiedGrassColor(double x, double z, int color) {
        return (color & 0xFEFEFE) + 0xD9A066 >> 1;
    }
}
