package net.more.apples.mod_initializer.wood_apple;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;

public class IniAppleFlamStr implements ModInitializer {
    @Override
    public void onInitialize() {
        StrippableBlockRegistry.register(AppleWoodBlocks.APPLE_LOG, AppleWoodBlocks.STRIPPED_APPLE_LOG);
        StrippableBlockRegistry.register(AppleWoodBlocks.APPLE_WOOD, AppleWoodBlocks.STRIPPED_APPLE_WOOD);
        

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

        FuelValueEvents.BUILD.register(((builder, context) -> {
            builder.add(AppleWoodVariants.APPLE_STAIRS, 300);
            builder.add(AppleWoodVariants.APPLE_SLAB, 150);
            builder.add(AppleWoodVariants.APPLE_BUTTON, 100);
            builder.add(AppleWoodVariants.APPLE_PRESSURE_PLATE, 300);
            builder.add(AppleWoodVariants.APPLE_FENCE, 300);
            builder.add(AppleWoodVariants.APPLE_FENCE_GATE, 300);
            builder.add(AppleWoodVariants.APPLE_DOOR, 200);
            builder.add(AppleWoodVariants.APPLE_TRAPDOOR, 200);
        }));
    }
}
