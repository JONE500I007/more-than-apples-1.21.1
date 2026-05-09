package net.more.apples.mod_initializer.wood_apple;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodBlocks;
import net.more.apples.block.wood_type.test_wood.TestAppleWoodVariants;

public class IniTestAppleFlamStr implements ModInitializer {
    @Override
    public void onInitialize() {
        StrippableBlockRegistry.register(TestAppleWoodBlocks.TEST_APPLE_LOG, TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG);
        StrippableBlockRegistry.register(TestAppleWoodBlocks.TEST_APPLE_WOOD, TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD);


        FlammableBlockRegistry.getDefaultInstance().add(TestAppleWoodBlocks.TEST_APPLE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TestAppleWoodBlocks.TEST_APPLE_WOOD, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_LOG, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TestAppleWoodBlocks.STRIPPED_TEST_APPLE_WOOD, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TestAppleWoodBlocks.TEST_APPLE_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TestAppleWoodBlocks.TEST_APPLE_LEAVES, 30, 60);

        FlammableBlockRegistry.getDefaultInstance().add(TestAppleWoodVariants.TEST_APPLE_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TestAppleWoodVariants.TEST_APPLE_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TestAppleWoodVariants.TEST_APPLE_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(TestAppleWoodVariants.TEST_APPLE_FENCE_GATE, 5, 20);

        FuelValueEvents.BUILD.register(((builder, context) -> {
            builder.add(TestAppleWoodVariants.TEST_APPLE_STAIRS, 300);
            builder.add(TestAppleWoodVariants.TEST_APPLE_SLAB, 150);
            builder.add(TestAppleWoodVariants.TEST_APPLE_BUTTON, 100);
            builder.add(TestAppleWoodVariants.TEST_APPLE_PRESSURE_PLATE, 300);
            builder.add(TestAppleWoodVariants.TEST_APPLE_FENCE, 300);
            builder.add(TestAppleWoodVariants.TEST_APPLE_FENCE_GATE, 300);
            builder.add(TestAppleWoodVariants.TEST_APPLE_DOOR, 200);
            builder.add(TestAppleWoodVariants.TEST_APPLE_TRAPDOOR, 200);
        }));
    }
}
