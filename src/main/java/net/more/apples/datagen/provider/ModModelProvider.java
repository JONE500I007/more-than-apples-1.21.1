package net.more.apples.datagen.provider;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.more.apples.datagen.model.all_apple.AncientAppleModels;
import net.more.apples.datagen.model.all_apple.AppleModels;
import net.more.apples.datagen.model.all_apple.FrostyModels;
import net.more.apples.datagen.model.all_apple.TestAppleModels;
import net.more.apples.datagen.model.items.AppleItemsModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        AppleModels.addBlockModels(blockModelGenerators);
        TestAppleModels.addBlockModels(blockModelGenerators);
        FrostyModels.addBlockModels(blockModelGenerators);
        AncientAppleModels.addBlockModels(blockModelGenerators);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        AppleModels.addItemModels(itemModelGenerators);
        TestAppleModels.addItemModels(itemModelGenerators);
        FrostyModels.addItemModels(itemModelGenerators);
        AppleItemsModel.addItemModels(itemModelGenerators);
        AncientAppleModels.addItemModels(itemModelGenerators);
    }

//    public static void createBarrel(BlockModelGenerators generators, Block block) {
//        generators.createTrivialBlock(
//                block,
//                TexturedModel.CUBE_TOP_BOTTOM.updateTexture(map -> {
//                    map.put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top"));
//                    map.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(block, "_bottom"));
//                    map.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, ""));
//                }));
//    }

    public static void foliageLeavesItem(ItemModelGenerators generators, Item item, ModelTemplate template) {
        generators.generateItemWithTintedOverlay(item, (ItemTintSource) new FoliageColor());
    }

    public static void flatItem(ItemModelGenerators generators, Item item, ModelTemplate template) {
        generators.generateFlatItem(item, template);
    }
}
