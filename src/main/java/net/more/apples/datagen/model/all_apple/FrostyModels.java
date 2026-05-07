package net.more.apples.datagen.model.all_apple;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodVariants;
import net.more.apples.datagen.provider.ModModelProvider;
import net.more.apples.item.apple_wood_item.FrostyAppleWoodItem;

public final class FrostyModels {
    private FrostyModels() {
    }

    public static void addBlockModels(BlockModelGenerators generators) {

        // --- Frosty Apple Wood Family ---
        BlockModelGenerators.BlockFamilyProvider family =
                generators.family(FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS);

        family.stairs(FrostyAppleWoodVariants.FROSTY_APPLE_STAIRS);
        family.slab(FrostyAppleWoodVariants.FROSTY_APPLE_SLAB);

        family.button(FrostyAppleWoodVariants.FROSTY_APPLE_BUTTON);
        family.pressurePlate(FrostyAppleWoodVariants.FROSTY_APPLE_PRESSURE_PLATE);

        family.fence(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE);
        family.fenceGate(FrostyAppleWoodVariants.FROSTY_APPLE_FENCE_GATE);

        // --- Frosty Apple Door & Trapdoor ---
        generators.createDoor(FrostyAppleWoodVariants.FROSTY_APPLE_DOOR);
        generators.createTrapdoor(FrostyAppleWoodVariants.FROSTY_APPLE_TRAPDOOR);

        // --- Frosty Apple Signs ---
        generators.createParticleOnlyBlock(
                FrostyAppleWoodVariants.FROSTY_APPLE_STANDING_SIGN,
                FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS
        );

        generators.createParticleOnlyBlock(
                FrostyAppleWoodVariants.FROSTY_APPLE_WALL_SIGN,
                FrostyAppleWoodBlocks.FROSTY_APPLE_PLANKS
        );

        generators.createHangingSign(
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG,
                FrostyAppleWoodVariants.FROSTY_APPLE_HANGING_SIGN_BLOCK,
                FrostyAppleWoodVariants.FROSTY_APPLE_WALL_HANGING_SIGN
        );

        // --- Frosty Apple Logs ---
        generators.woodProvider(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG)
                .log(FrostyAppleWoodBlocks.FROSTY_APPLE_LOG)
                .wood(FrostyAppleWoodBlocks.FROSTY_APPLE_WOOD);

        generators.woodProvider(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG)
                .log(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG)
                .wood(FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_WOOD);

        // --- Frosty Apple Shelf ---
        generators.createShelf(
                FrostyAppleWoodVariants.FROSTY_APPLE_SHELF,
                FrostyAppleWoodBlocks.STRIPPED_FROSTY_APPLE_LOG
        );

        // --- Frosty Apple Sapling ---
        generators.createCrossBlock(
                FrostyAppleWoodBlocks.FROSTY_APPLE_SAPLING,
                BlockModelGenerators.PlantType.NOT_TINTED
        );
        generators.createTrivialBlock(FrostyAppleWoodBlocks.FROSTY_APPLE_LEAVES, TexturedModel.LEAVES);
    }

    public static void addItemModels(ItemModelGenerators generators) {

        // --- Frosty Apple Sapling ---
        ModModelProvider.flatItem(
                generators,
                FrostyAppleWoodBlocks.FROSTY_APPLE_SAPLING.asItem(),
                ModelTemplates.FLAT_ITEM
        );

        // --- Frosty Apple Sign ---
        ModModelProvider.flatItem(
                generators,
                FrostyAppleWoodItem.FROSTY_APPLE_SIGN,
                ModelTemplates.FLAT_ITEM
        );

        // --- Frosty Apple Boats ---
        ModModelProvider.flatItem(
                generators,
                FrostyAppleWoodItem.FROSTY_APPLE_BOAT,
                ModelTemplates.FLAT_ITEM
        );

        ModModelProvider.flatItem(
                generators,
                FrostyAppleWoodItem.FROSTY_APPLE_CHEST_BOAT,
                ModelTemplates.FLAT_ITEM
        );
    }
}
