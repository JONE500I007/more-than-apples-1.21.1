package net.more.apples.mod_initializer.wood_apple;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.item.v1.BlockTransformerHelper;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.more.apples.util.ModFuels;

public class IniFrostyAppleFlamStr implements ModInitializer {
    @Override
    public void onInitialize() {
        BlockTransformerHelper.registerStripping(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG, FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG);
        BlockTransformerHelper.registerStripping(FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD, FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD);

        FlammableBlockRegistry.getDefaultInstance().add(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(FrostyAppleWoodBlocks.FROSTY_APPLE_LEAVES, 30, 60);

        FlammableBlockRegistry.getDefaultInstance().add(FrostyAppleWoodVariants.FROSTY_APPLE_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(FrostyAppleWoodVariants.FROSTY_APPLE_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE, 5, 20);

        DefaultItemComponentEvents.MODIFY.register(context -> {
            ModFuels.add(context, FrostyAppleWoodVariants.FROSTY_APPLE_STAIRS, ContextIntProviders.COOKING_TIME_WOOD_BLOCKS);
            ModFuels.add(context, FrostyAppleWoodVariants.FROSTY_APPLE_SLAB, ContextIntProviders.COOKING_TIME_WOOD_SLABS);
            ModFuels.add(context, FrostyAppleWoodVariants.FROSTY_APPLE_BUTTON, ContextIntProviders.COOKING_TIME_WOOD_ITEMS_EXTRA_SMALL);
            ModFuels.add(context, FrostyAppleWoodVariants.FROSTY_APPLE_PRESSURE_PLATE, ContextIntProviders.COOKING_TIME_WOOD_BLOCKS);
            ModFuels.add(context, FrostyAppleWoodVariants.FROSTY_APPLE_FENCE, ContextIntProviders.COOKING_TIME_WOOD_BLOCKS);
            ModFuels.add(context, FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE, ContextIntProviders.COOKING_TIME_WOOD_BLOCKS);
            ModFuels.add(context, FrostyAppleWoodVariants.FROSTY_APPLE_DOOR, ContextIntProviders.COOKING_TIME_WOOD_ITEMS_LARGE);
            ModFuels.add(context, FrostyAppleWoodVariants.FROSTY_APPLE_TRAPDOOR, ContextIntProviders.COOKING_TIME_WOOD_ITEMS_LARGE);
        });
    }
}
