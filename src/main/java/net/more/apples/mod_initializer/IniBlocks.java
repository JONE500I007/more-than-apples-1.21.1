package net.more.apples.mod_initializer;

import net.fabricmc.api.ModInitializer;
import net.more.apples.block.general_block.ModGeneralBlock;
import net.more.apples.block.ore_block.ModBlockOre;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;

public class IniBlocks implements ModInitializer {
    @Override
    public void onInitialize() {
        ModGeneralBlock.registerModGenerBlocks();
        ModBlockOre.registerModOreBlocks();

        // 🌳 wood set
        AppleWoodBlocks.registerAppleWoodBlock();
        AppleWoodVariants.registerAppleWoodVariant();

        TestAppleWoodBlocks.registerTestAppleWoodBlock();
        TestAppleWoodVariants.registerTestAppleWoodVariant();
    }
}
