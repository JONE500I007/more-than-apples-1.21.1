package net.more.apples.mod_initializer.wood_apple;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.item.v1.BlockTransformerHelper;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodVariants;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.more.apples.util.ModFuels;

public class IniAncientAppleFlamStr implements ModInitializer {
    @Override
    public void onInitialize() {
        BlockTransformerHelper.registerStripping(AncientAppleWoodBlocks.ANCIENT_APPLE_LOG, AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG);
        BlockTransformerHelper.registerStripping(AncientAppleWoodBlocks.ANCIENT_APPLE_WOOD, AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_WOOD);


        FlammableBlockRegistry.getDefaultInstance().add(AncientAppleWoodBlocks.ANCIENT_APPLE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AncientAppleWoodBlocks.ANCIENT_APPLE_WOOD, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_WOOD, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AncientAppleWoodBlocks.ANCIENT_APPLE_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AncientAppleWoodBlocks.ANCIENT_APPLE_LEAVES, 30, 60);

        FlammableBlockRegistry.getDefaultInstance().add(AncientAppleWoodVariants.ANCIENT_APPLE_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AncientAppleWoodVariants.ANCIENT_APPLE_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AncientAppleWoodVariants.ANCIENT_APPLE_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AncientAppleWoodVariants.ANCIENT_APPLE_FENCE_GATE, 5, 20);

        DefaultItemComponentEvents.MODIFY.register(context -> {
            ModFuels.add(context, AncientAppleWoodVariants.ANCIENT_APPLE_STAIRS, ContextIntProviders.COOKING_TIME_WOOD_BLOCKS);
            ModFuels.add(context, AncientAppleWoodVariants.ANCIENT_APPLE_SLAB, ContextIntProviders.COOKING_TIME_WOOD_SLABS);
            ModFuels.add(context, AncientAppleWoodVariants.ANCIENT_APPLE_BUTTON, ContextIntProviders.COOKING_TIME_WOOD_ITEMS_EXTRA_SMALL);
            ModFuels.add(context, AncientAppleWoodVariants.ANCIENT_APPLE_PRESSURE_PLATE, ContextIntProviders.COOKING_TIME_WOOD_BLOCKS);
            ModFuels.add(context, AncientAppleWoodVariants.ANCIENT_APPLE_FENCE, ContextIntProviders.COOKING_TIME_WOOD_BLOCKS);
            ModFuels.add(context, AncientAppleWoodVariants.ANCIENT_APPLE_FENCE_GATE, ContextIntProviders.COOKING_TIME_WOOD_BLOCKS);
            ModFuels.add(context, AncientAppleWoodVariants.ANCIENT_APPLE_DOOR, ContextIntProviders.COOKING_TIME_WOOD_ITEMS_LARGE);
            ModFuels.add(context, AncientAppleWoodVariants.ANCIENT_APPLE_TRAPDOOR, ContextIntProviders.COOKING_TIME_WOOD_ITEMS_LARGE);
        });
    }
}
