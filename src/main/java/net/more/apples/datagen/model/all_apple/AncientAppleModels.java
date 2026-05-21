package net.more.apples.datagen.model.all_apple;

import net.minecraft.client.color.item.GrassColorSource;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodBlocks;
import net.more.apples.block.wood_type.ancient_apple.AncientAppleWoodVariants;
import net.more.apples.block.wood_type.frosty_wood.FrostyAppleWoodBlocks;
import net.more.apples.datagen.provider.ModModelProvider;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import net.more.apples.item.apple_wood_item.AncientAppleWoodItem;
import net.more.apples.item.apple_wood_item.TestAppleWoodItem;

public final class AncientAppleModels {
    private AncientAppleModels() {
    }

    public static void addBlockModels(BlockModelGenerators generators) {

        // --- Ancient Apple Wood Family ---
        BlockModelGenerators.BlockFamilyProvider family =
                generators.family(AncientAppleWoodBlocks.ANCIENT_APPLE_PLANKS);

        family.stairs(AncientAppleWoodVariants.ANCIENT_APPLE_STAIRS);
        family.slab(AncientAppleWoodVariants.ANCIENT_APPLE_SLAB);

        family.button(AncientAppleWoodVariants.ANCIENT_APPLE_BUTTON);
        family.pressurePlate(AncientAppleWoodVariants.ANCIENT_APPLE_PRESSURE_PLATE);

        family.fence(AncientAppleWoodVariants.ANCIENT_APPLE_FENCE);
        family.fenceGate(AncientAppleWoodVariants.ANCIENT_APPLE_FENCE_GATE);

        // --- Ancient Apple Door & Trapdoor ---
        generators.createDoor(AncientAppleWoodVariants.ANCIENT_APPLE_DOOR);
        generators.createTrapdoor(AncientAppleWoodVariants.ANCIENT_APPLE_TRAPDOOR);

        // --- Ancient Apple Signs ---
        generators.createParticleOnlyBlock(
                AncientAppleWoodVariants.ANCIENT_APPLE_STANDING_SIGN,
                AncientAppleWoodBlocks.ANCIENT_APPLE_PLANKS
        );

        generators.createParticleOnlyBlock(
                AncientAppleWoodVariants.ANCIENT_APPLE_WALL_SIGN,
                AncientAppleWoodBlocks.ANCIENT_APPLE_PLANKS
        );

        generators.createHangingSign(
                AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG,
                AncientAppleWoodVariants.ANCIENT_APPLE_HANGING_SIGN_BLOCK,
                AncientAppleWoodVariants.ANCIENT_APPLE_WALL_HANGING_SIGN
        );

        // --- Ancient Apple Logs ---
        generators.woodProvider(AncientAppleWoodBlocks.ANCIENT_APPLE_LOG)
                .log(AncientAppleWoodBlocks.ANCIENT_APPLE_LOG)
                .wood(AncientAppleWoodBlocks.ANCIENT_APPLE_WOOD);

        generators.woodProvider(AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG)
                .log(AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG)
                .wood(AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_WOOD);

        // --- Ancient Apple Shelf ---
        generators.createShelf(
                AncientAppleWoodVariants.ANCIENT_APPLE_SHELF,
                AncientAppleWoodBlocks.STRIPPED_ANCIENT_APPLE_LOG
        );

        // --- Ancient Apple Sapling ---
        generators.createCrossBlock(
                AncientAppleWoodBlocks.ANCIENT_APPLE_SAPLING,
                BlockModelGenerators.PlantType.NOT_TINTED
        );
        // block model + blockstate
//        generators.createTrivialBlock(
//                AncientAppleWoodBlocks.ANCIENT_APPLE_LEAVES, TexturedModel.LEAVES);

        // item model with tint
        generators.registerSimpleTintedItemModel(
                AncientAppleWoodBlocks.ANCIENT_APPLE_LEAVES,
                TexturedModel.LEAVES.create(AncientAppleWoodBlocks.ANCIENT_APPLE_LEAVES, generators.modelOutput),
                new GrassColorSource());
    }

    public static void addItemModels(ItemModelGenerators generators) {

        // --- Ancient Apple Sapling ---
        ModModelProvider.flatItem(
                generators,
                AncientAppleWoodBlocks.ANCIENT_APPLE_SAPLING.asItem(),
                ModelTemplates.FLAT_ITEM
        );

        // --- Ancient Apple Sign ---
        ModModelProvider.flatItem(
                generators,
                AncientAppleWoodItem.ANCIENT_APPLE_SIGN,
                ModelTemplates.FLAT_ITEM
        );

        // --- Ancient Apple Boats ---
        ModModelProvider.flatItem(
                generators,
                AncientAppleWoodItem.ANCIENT_APPLE_BOAT,
                ModelTemplates.FLAT_ITEM
        );

        ModModelProvider.flatItem(
                generators,
                AncientAppleWoodItem.ANCIENT_APPLE_CHEST_BOAT,
                ModelTemplates.FLAT_ITEM
        );
    }
}
