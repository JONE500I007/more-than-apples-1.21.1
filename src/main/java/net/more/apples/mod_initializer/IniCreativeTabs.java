package net.more.apples.mod_initializer;

import net.fabricmc.api.ModInitializer;
import net.more.apples.block.CreativeModeBlockTabs;
import net.more.apples.item.CreativeModeItemTabs;
import net.more.apples.item.ModItemGroups;
import net.more.apples.item.ModPotionsGroups;

public class IniCreativeTabs implements ModInitializer {
    @Override
    public void onInitialize() {
        CreativeModeItemTabs.registerModItemTab();
        CreativeModeBlockTabs.registerModBlockTab();

        ModItemGroups.registerItemGroups();
        ModPotionsGroups.registerItemGroups2();
    }
}
