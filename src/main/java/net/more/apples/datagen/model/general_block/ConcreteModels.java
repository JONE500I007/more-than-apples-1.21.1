package net.more.apples.datagen.model.general_block;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.world.level.block.Blocks;
import net.more.apples.block.general_block.concrete.ConcreteVariants;


public final class ConcreteModels {
    private ConcreteModels() {
    }

    public static void addBlockModels(BlockModelGenerators generators) {

        // --- Concrete Wood Family ---
        // White
        generators.family(Blocks.WHITE_CONCRETE)
                .stairs(ConcreteVariants.WHITE_CONCRETE_STAIRS)
                .slab(ConcreteVariants.WHITE_CONCRETE_SLAB);

        // Light Gray
        generators.family(Blocks.LIGHT_GRAY_CONCRETE)
                .stairs(ConcreteVariants.LIGHT_GRAY_CONCRETE_STAIRS)
                .slab(ConcreteVariants.LIGHT_GRAY_CONCRETE_SLAB);

        // Gray
        generators.family(Blocks.GRAY_CONCRETE)
                .stairs(ConcreteVariants.GRAY_CONCRETE_STAIRS)
                .slab(ConcreteVariants.GRAY_CONCRETE_SLAB);

        // Black
        generators.family(Blocks.BLACK_CONCRETE)
                .stairs(ConcreteVariants.BLACK_CONCRETE_STAIRS)
                .slab(ConcreteVariants.BLACK_CONCRETE_SLAB);

        // Brown
        generators.family(Blocks.BROWN_CONCRETE)
                .stairs(ConcreteVariants.BROWN_CONCRETE_STAIRS)
                .slab(ConcreteVariants.BROWN_CONCRETE_SLAB);

        // Red
        generators.family(Blocks.RED_CONCRETE)
                .stairs(ConcreteVariants.RED_CONCRETE_STAIRS)
                .slab(ConcreteVariants.RED_CONCRETE_SLAB);

        // Orange
        generators.family(Blocks.ORANGE_CONCRETE)
                .stairs(ConcreteVariants.ORANGE_CONCRETE_STAIRS)
                .slab(ConcreteVariants.ORANGE_CONCRETE_SLAB);

        // Yellow
        generators.family(Blocks.YELLOW_CONCRETE)
                .stairs(ConcreteVariants.YELLOW_CONCRETE_STAIRS)
                .slab(ConcreteVariants.YELLOW_CONCRETE_SLAB);

        // Lime
        generators.family(Blocks.LIME_CONCRETE)
                .stairs(ConcreteVariants.LIME_CONCRETE_STAIRS)
                .slab(ConcreteVariants.LIME_CONCRETE_SLAB);

        // Green
        generators.family(Blocks.GREEN_CONCRETE)
                .stairs(ConcreteVariants.GREEN_CONCRETE_STAIRS)
                .slab(ConcreteVariants.GREEN_CONCRETE_SLAB);

        // Cyan
        generators.family(Blocks.CYAN_CONCRETE)
                .stairs(ConcreteVariants.CYAN_CONCRETE_STAIRS)
                .slab(ConcreteVariants.CYAN_CONCRETE_SLAB);

        // Light Blue
        generators.family(Blocks.LIGHT_BLUE_CONCRETE)
                .stairs(ConcreteVariants.LIGHT_BLUE_CONCRETE_STAIRS)
                .slab(ConcreteVariants.LIGHT_BLUE_CONCRETE_SLAB);

        // Blue
        generators.family(Blocks.BLUE_CONCRETE)
                .stairs(ConcreteVariants.BLUE_CONCRETE_STAIRS)
                .slab(ConcreteVariants.BLUE_CONCRETE_SLAB);

        // Purple
        generators.family(Blocks.PURPLE_CONCRETE)
                .stairs(ConcreteVariants.PURPLE_CONCRETE_STAIRS)
                .slab(ConcreteVariants.PURPLE_CONCRETE_SLAB);

        // Magenta
        generators.family(Blocks.MAGENTA_CONCRETE)
                .stairs(ConcreteVariants.MAGENTA_CONCRETE_STAIRS)
                .slab(ConcreteVariants.MAGENTA_CONCRETE_SLAB);

        // Pink
        generators.family(Blocks.PINK_CONCRETE)
                .stairs(ConcreteVariants.PINK_CONCRETE_STAIRS)
                .slab(ConcreteVariants.PINK_CONCRETE_SLAB);

//        TextureMapping whiteConcreteMapping = TextureMapping.cube(Blocks.WHITE_CONCRETE);
//
//        // Stairs
//        MultiVariant inner = BlockModelGenerators.plainVariant(
//                ModelTemplates.STAIRS_INNER.create(WhiteConcrete.WHITE_CONCRETE_STAIRS, whiteConcreteMapping, generators.modelOutput));
//        MultiVariant straight = BlockModelGenerators.plainVariant(
//                ModelTemplates.STAIRS_STRAIGHT.create(WhiteConcrete.WHITE_CONCRETE_STAIRS, whiteConcreteMapping, generators.modelOutput));
//        MultiVariant outer = BlockModelGenerators.plainVariant(
//                ModelTemplates.STAIRS_OUTER.create(WhiteConcrete.WHITE_CONCRETE_STAIRS, whiteConcreteMapping, generators.modelOutput));
//        generators.blockStateOutput.accept(BlockModelGenerators.createStairs(WhiteConcrete.WHITE_CONCRETE_STAIRS, inner, straight, outer));
//        generators.registerSimpleItemModel(WhiteConcrete.WHITE_CONCRETE_STAIRS, ModelLocationUtils.getModelLocation(WhiteConcrete.WHITE_CONCRETE_STAIRS));
//
//        // Slab
//        Identifier slabBottom = ModelTemplates.SLAB_BOTTOM.create(WhiteConcrete.WHITE_CONCRETE_SLAB, whiteConcreteMapping, generators.modelOutput);
//        MultiVariant slabTop = BlockModelGenerators.plainVariant(
//                ModelTemplates.SLAB_TOP.create(WhiteConcrete.WHITE_CONCRETE_SLAB, whiteConcreteMapping, generators.modelOutput));
//        MultiVariant fullBlock = BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(Blocks.WHITE_CONCRETE));
//        generators.blockStateOutput.accept(BlockModelGenerators.createSlab(
//                WhiteConcrete.WHITE_CONCRETE_SLAB,
//                BlockModelGenerators.plainVariant(slabBottom), slabTop, fullBlock));
//        generators.registerSimpleItemModel(WhiteConcrete.WHITE_CONCRETE_SLAB, slabBottom);

        /*
        family.button(AppleWoodVariants.APPLE_BUTTON);
        family.pressurePlate(AppleWoodVariants.APPLE_PRESSURE_PLATE);

        family.fence(AppleWoodVariants.APPLE_FENCE);
        family.fenceGate(AppleWoodVariants.APPLE_FENCE_GATE);

        // --- Concrete Door & Trapdoor ---
        generators.createDoor(AppleWoodVariants.APPLE_DOOR);
        generators.createTrapdoor(AppleWoodVariants.APPLE_TRAPDOOR);

        // --- Concrete Signs ---
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

        // --- Concrete Logs ---
        generators.woodProvider(AppleWoodBlocks.APPLE_LOG)
                .log(AppleWoodBlocks.APPLE_LOG)
                .wood(AppleWoodBlocks.APPLE_WOOD);

        generators.woodProvider(AppleWoodBlocks.STRIPPED_APPLE_LOG)
                .log(AppleWoodBlocks.STRIPPED_APPLE_LOG)
                .wood(AppleWoodBlocks.STRIPPED_APPLE_WOOD);

        // --- Concrete Shelf ---
        generators.createShelf(
                AppleWoodVariants.APPLE_SHELF,
                AppleWoodBlocks.STRIPPED_APPLE_LOG
        );

        // --- Concrete Sapling ---
        generators.createCrossBlock(
                AppleWoodBlocks.APPLE_SAPLING,
                BlockModelGenerators.PlantType.NOT_TINTED
        );
        generators.createCrossBlock(
                AppleWoodBlocks.GOLDEN_APPLE_SAPLING,
                BlockModelGenerators.PlantType.NOT_TINTED
        );
         */
    }

    public static void addItemModels(ItemModelGenerators generators) {
        /*

        // --- Concrete Sapling ---
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

        // --- Concrete Sign ---
        ModModelProvider.flatItem(
                generators,
                AppleWoodItem.APPLE_SIGN,
                ModelTemplates.FLAT_ITEM
        );

        // --- Concrete Boats ---
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
         */
    }
}
