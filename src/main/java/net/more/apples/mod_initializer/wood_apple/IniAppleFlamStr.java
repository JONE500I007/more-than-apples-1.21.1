package net.more.apples.mod_initializer.wood_apple;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.item.v1.BlockTransformerHelper;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.more.apples.util.ModFuels;

public class IniAppleFlamStr implements ModInitializer {
    @Override
    public void onInitialize() {
        BlockTransformerHelper.registerStripping(AppleWoodBlocks.APPLE_LOG, AppleWoodBlocks.STRIPPED_APPLE_LOG);
        BlockTransformerHelper.registerStripping(AppleWoodBlocks.APPLE_WOOD, AppleWoodBlocks.STRIPPED_APPLE_WOOD);
        

        FlammableBlockRegistry.getDefaultInstance().add(AppleWoodBlocks.APPLE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AppleWoodBlocks.APPLE_WOOD, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AppleWoodBlocks.STRIPPED_APPLE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AppleWoodBlocks.STRIPPED_APPLE_WOOD, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AppleWoodBlocks.APPLE_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AppleWoodBlocks.APPLE_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(AppleWoodBlocks.FRUIT_APPLE_LEAVES, 30, 60);

        FlammableBlockRegistry.getDefaultInstance().add(AppleWoodVariants.APPLE_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AppleWoodVariants.APPLE_SLAB, 5, 20);
//		FlammableBlockRegistry.getDefaultInstance().add(AppleWoodBlocks.APPLE_BUTTON, 5, 20);
//		FlammableBlockRegistry.getDefaultInstance().add(AppleWoodBlocks.APPLE_PRESSURE_PLATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AppleWoodVariants.APPLE_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AppleWoodVariants.APPLE_FENCE_GATE, 5, 20);
//		FlammableBlockRegistry.getDefaultInstance().add(AppleWoodBlocks.APPLE_DOOR, 5, 20);
//		FlammableBlockRegistry.getDefaultInstance().add(AppleWoodBlocks.APPLE_TRAPDOOR, 5, 20);

        FlammableBlockRegistry.getDefaultInstance().add(AppleWoodBlocks.GOLDEN_APPLE_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(AppleWoodBlocks.FRUIT_GOLDEN_APPLE_LEAVES, 30, 60);

        DefaultItemComponentEvents.MODIFY.register(context -> {
            ModFuels.add(context, AppleWoodVariants.APPLE_STAIRS, ContextIntProviders.COOKING_TIME_WOOD_BLOCKS);
            ModFuels.add(context, AppleWoodVariants.APPLE_SLAB, ContextIntProviders.COOKING_TIME_WOOD_SLABS);
            ModFuels.add(context, AppleWoodVariants.APPLE_BUTTON, ContextIntProviders.COOKING_TIME_WOOD_ITEMS_EXTRA_SMALL);
            ModFuels.add(context, AppleWoodVariants.APPLE_PRESSURE_PLATE, ContextIntProviders.COOKING_TIME_WOOD_BLOCKS);
            ModFuels.add(context, AppleWoodVariants.APPLE_FENCE, ContextIntProviders.COOKING_TIME_WOOD_BLOCKS);
            ModFuels.add(context, AppleWoodVariants.APPLE_FENCE_GATE, ContextIntProviders.COOKING_TIME_WOOD_BLOCKS);
            ModFuels.add(context, AppleWoodVariants.APPLE_DOOR, ContextIntProviders.COOKING_TIME_WOOD_ITEMS_LARGE);
            ModFuels.add(context, AppleWoodVariants.APPLE_TRAPDOOR, ContextIntProviders.COOKING_TIME_WOOD_ITEMS_LARGE);
        });
    }
}
