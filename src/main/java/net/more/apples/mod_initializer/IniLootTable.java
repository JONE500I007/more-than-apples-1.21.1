package net.more.apples.mod_initializer;

import net.fabricmc.api.ModInitializer;
import net.more.apples.block.general_block.ModGeneralBlock;
import net.more.apples.block.ore_block.ModBlockOre;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;
import net.more.apples.util.custom_loottable.ModLootTableModifiers_DiaApple;
import net.more.apples.util.custom_loottable.ModLootTableModifiers_DiaCarrot;

public class IniLootTable implements ModInitializer {
    @Override
    public void onInitialize() {
        ModLootTableModifiers_DiaApple.modifyLootTables();
        ModLootTableModifiers_DiaCarrot.modifyLootTables();
    }
}
