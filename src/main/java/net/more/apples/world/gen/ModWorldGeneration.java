package net.more.apples.world.gen;

public class ModWorldGeneration {
    public static void generateWorldGen() {
        ModOreGeneration.generateOres();

        ModTreeGeneration.generaTrees();
    }
}
