package net.more.apples.datagen.model.all_apple;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.more.apples.block.general_block.ModGeneralBlock;
import net.more.apples.block.wood_type.apple_wood.AppleWoodBlocks;
import net.more.apples.block.wood_type.apple_wood.AppleWoodVariants;
import net.more.apples.datagen.provider.ModModelProvider;
import net.more.apples.item.apple_wood_item.AppleWoodItem;

public final class AppleModels {
    private AppleModels() {
    }

    public static void addBlockModels(BlockModelGenerators generators) {

        // --- Apple Wood Family ---
        BlockModelGenerators.BlockFamilyProvider family =
                generators.family(AppleWoodBlocks.APPLE_PLANKS);

        family.stairs(AppleWoodVariants.APPLE_STAIRS);
        family.slab(AppleWoodVariants.APPLE_SLAB);

        family.button(AppleWoodVariants.APPLE_BUTTON);
        family.pressurePlate(AppleWoodVariants.APPLE_PRESSURE_PLATE);

        family.fence(AppleWoodVariants.APPLE_FENCE);
        family.fenceGate(AppleWoodVariants.APPLE_FENCE_GATE);

        // --- Apple Door & Trapdoor ---
        generators.createDoor(AppleWoodVariants.APPLE_DOOR);
        generators.createTrapdoor(AppleWoodVariants.APPLE_TRAPDOOR);

        // --- Apple Signs ---
        generators.createParticleOnlyBlock(
                AppleWoodVariants.APPLE_STANDING_SIGN,
                AppleWoodBlocks.APPLE_PLANKS
        );

        generators.createParticleOnlyBlock(
                AppleWoodVariants.APPLE_WALL_SIGN,
                AppleWoodBlocks.APPLE_PLANKS
        );

        generators.createHangingSign(
                AppleWoodBlocks.STRIPPED_APPLE_LOG,
                AppleWoodVariants.APPLE_HANGING_SIGN_BLOCK,
                AppleWoodVariants.APPLE_WALL_HANGING_SIGN
        );

        // --- Apple Logs ---
        generators.woodProvider(AppleWoodBlocks.APPLE_LOG)
                .log(AppleWoodBlocks.APPLE_LOG)
                .wood(AppleWoodBlocks.APPLE_WOOD);

        generators.woodProvider(AppleWoodBlocks.STRIPPED_APPLE_LOG)
                .log(AppleWoodBlocks.STRIPPED_APPLE_LOG)
                .wood(AppleWoodBlocks.STRIPPED_APPLE_WOOD);

        // --- Apple Shelf ---
        generators.createShelf(
                AppleWoodVariants.APPLE_SHELF,
                AppleWoodBlocks.STRIPPED_APPLE_LOG
        );

        // --- Apple Sapling ---
        generators.createCrossBlock(
                AppleWoodBlocks.APPLE_SAPLING,
                BlockModelGenerators.PlantType.NOT_TINTED
        );
        generators.createCrossBlock(
                AppleWoodBlocks.GOLDEN_APPLE_SAPLING,
                BlockModelGenerators.PlantType.NOT_TINTED
        );
        generators.createCrossBlock(
                AppleWoodBlocks.HUGE_APPLE_SAPLING,
                BlockModelGenerators.PlantType.NOT_TINTED
        );

        generators.createTrivialBlock(ModGeneralBlock.APPLE_BARREL,
                TexturedModel.CUBE_TOP_BOTTOM.updateTexture((map) -> {
                    map.put(TextureSlot.TOP, TextureMapping.getBlockTexture(ModGeneralBlock.APPLE_BARREL, "_top"));
                    map.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(ModGeneralBlock.APPLE_BARREL, "_bottom"));
                    map.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModGeneralBlock.APPLE_BARREL, ""));
                }));
    }

    public static void addItemModels(ItemModelGenerators generators) {

        // --- Apple Sapling ---
        ModModelProvider.flatItem(
                generators,
                AppleWoodBlocks.APPLE_SAPLING.asItem(),
                ModelTemplates.FLAT_ITEM
        );
        ModModelProvider.flatItem(
                generators,
                AppleWoodBlocks.GOLDEN_APPLE_SAPLING.asItem(),
                ModelTemplates.FLAT_ITEM
        );

        // --- Apple Sign ---
        ModModelProvider.flatItem(
                generators,
                AppleWoodItem.APPLE_SIGN,
                ModelTemplates.FLAT_ITEM
        );

        // --- Apple Boats ---
        ModModelProvider.flatItem(
                generators,
                AppleWoodItem.APPLE_BOAT,
                ModelTemplates.FLAT_ITEM
        );

        ModModelProvider.flatItem(
                generators,
                AppleWoodItem.APPLE_CHEST_BOAT,
                ModelTemplates.FLAT_ITEM
        );
    }
}
