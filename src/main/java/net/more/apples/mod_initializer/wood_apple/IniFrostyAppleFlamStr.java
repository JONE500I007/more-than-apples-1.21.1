package net.more.apples.mod_initializer.wood_apple;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;

public class IniFrostyAppleFlamStr implements ModInitializer {
    @Override
    public void onInitialize() {
        StrippableBlockRegistry.register(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG, FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG);
        StrippableBlockRegistry.register(FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD, FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD);

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

        FuelValueEvents.BUILD.register(((builder, context) -> {
            builder.add(FrostyAppleWoodVariants.FROSTY_APPLE_STAIRS, 300);
            builder.add(FrostyAppleWoodVariants.FROSTY_APPLE_SLAB, 150);
            builder.add(FrostyAppleWoodVariants.FROSTY_APPLE_BUTTON, 100);
            builder.add(FrostyAppleWoodVariants.FROSTY_APPLE_PRESSURE_PLATE, 300);
            builder.add(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE, 300);
            builder.add(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE, 300);
            builder.add(FrostyAppleWoodVariants.FROSTY_APPLE_DOOR, 200);
            builder.add(FrostyAppleWoodVariants.FROSTY_APPLE_TRAPDOOR, 200);
        }));
    }
}
