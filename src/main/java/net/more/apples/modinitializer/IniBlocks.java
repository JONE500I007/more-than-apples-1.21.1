package net.more.apples.modinitializer;

import net.fabricmc.api.ModInitializer;
import net.more.apples.block.general_block.ModGeneralBlock;
import net.more.apples.block.ore_block.ModBlockOre;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;

public class IniBlocks implements ModInitializer {
    @Override
    public void onInitialize() {
        ModGeneralBlock.registerModGenerBlocks();
        ModBlockOre.registerModOreBlocks();

        // 🌳 wood set
        AppleWoodBlocks.registerAppleWoodBlock();
        AppleWoodVariants.registerAppleWoodVariant();
    }
}
