package net.more.apples.mod_initializer.wood_apple;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodVariants;

public class IniAncientAppleFlamStr implements ModInitializer {
    @Override
    public void onInitialize() {
        StrippableBlockRegistry.register(AncientAppleWoodBlocks.ANCIENT_APPLE_LOG, AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG);
        StrippableBlockRegistry.register(AncientAppleWoodBlocks.ANCIENT_APPLE_WOOD, AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_WOOD);


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

        FuelValueEvents.BUILD.register(((builder, context) -> {
            builder.add(AncientAppleWoodVariants.ANCIENT_APPLE_STAIRS, 300);
            builder.add(AncientAppleWoodVariants.ANCIENT_APPLE_SLAB, 150);
            builder.add(AncientAppleWoodVariants.ANCIENT_APPLE_BUTTON, 100);
            builder.add(AncientAppleWoodVariants.ANCIENT_APPLE_PRESSURE_PLATE, 300);
            builder.add(AncientAppleWoodVariants.ANCIENT_APPLE_FENCE, 300);
            builder.add(AncientAppleWoodVariants.ANCIENT_APPLE_FENCE_GATE, 300);
            builder.add(AncientAppleWoodVariants.ANCIENT_APPLE_DOOR, 200);
            builder.add(AncientAppleWoodVariants.ANCIENT_APPLE_TRAPDOOR, 200);
        }));
    }
}
