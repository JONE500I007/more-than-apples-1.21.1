package net.more.apples.mod_initializer;

import net.fabricmc.api.ModInitializer;
import net.more.apples.block.general_block.ModGeneralBlock;
import net.more.apples.block.general_block.concrete.ConcreteVariants;
import net.more.apples.block.ore_block.ModBlockOre;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodVariants;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;

public class IniBlocks implements ModInitializer {
    @Override
    public void onInitialize() {
        ModGeneralBlock.registerModGenBlocks();
        ModBlockOre.registerModOreBlocks();

        // 🌳 wood set
        AppleWoodBlocks.registerAppleWoodBlock();
        AppleWoodVariants.registerAppleWoodVariant();

        TestAppleWoodBlocks.registerAppleWoodBlock();
        TestAppleWoodVariants.registerAppleWoodBlock();

        FrostyAppleWoodBlocks.registerAppleWoodBlock();
        FrostyAppleWoodVariants.registerAppleWoodBlock();

        AncientAppleWoodBlocks.registerAppleWoodBlock();
        AncientAppleWoodVariants.registerAppleWoodBlock();

        ConcreteVariants.registerConcreteBlock();
    }
}
