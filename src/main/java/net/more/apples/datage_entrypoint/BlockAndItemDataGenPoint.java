package net.more.apples.datage_entrypoint;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.more.apples.datagen.loot_table.loot_blockdrop.AppleLootBlockDrop;
import net.more.apples.datagen.loot_table.loot_blockdrop.FrostyAppleLootBlockDrop;
import net.more.apples.datagen.loot_table.loot_blockdrop.TestAppleLootBlockDrop;
import net.more.apples.datagen.model.apple.AppleModelBlocks;
import net.more.apples.datagen.model.apple.AppleModelItems;
import net.more.apples.datagen.model.frosty_apple.FrostyAppleModelBlocks;
import net.more.apples.datagen.model.frosty_apple.FrostyAppleModelItems;
import net.more.apples.datagen.model.test_apple.TestAppleModelBlocks;
import net.more.apples.datagen.model.test_apple.TestAppleModelItems;
import net.more.apples.datagen.recipe.AppleRecipe;
import net.more.apples.datagen.recipe.FrostyAppleRecipe;
import net.more.apples.datagen.recipe.TestAppleRecipe;
import net.more.apples.datagen.tag.apple_tag.AppleBlockTag;
import net.more.apples.datagen.tag.apple_tag.AppleItemTag;
import net.more.apples.datagen.tag.frosty_apple_tag.FrostyAppleBlockTag;
import net.more.apples.datagen.tag.frosty_apple_tag.FrostyAppleItemTag;
import net.more.apples.datagen.tag.test_apple_tag.TestAppleBlockTag;
import net.more.apples.datagen.tag.test_apple_tag.TestAppleItemTag;

public class BlockAndItemDataGenPoint implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(AppleBlockTag::new);
        pack.addProvider(AppleItemTag::new);
        pack.addProvider(AppleLootBlockDrop::new);
        pack.addProvider(AppleRecipe::new);
        pack.addProvider(AppleModelBlocks::new);
        pack.addProvider(AppleModelItems::new);


        pack.addProvider(TestAppleBlockTag::new);
        pack.addProvider(TestAppleItemTag::new);
        pack.addProvider(TestAppleLootBlockDrop::new);
        pack.addProvider(TestAppleRecipe::new);
        pack.addProvider(TestAppleModelBlocks::new);
        pack.addProvider(TestAppleModelItems::new);


        pack.addProvider(FrostyAppleBlockTag::new);
        pack.addProvider(FrostyAppleItemTag::new);
        pack.addProvider(FrostyAppleLootBlockDrop::new);
        pack.addProvider(FrostyAppleRecipe::new);
        pack.addProvider(FrostyAppleModelBlocks::new);
        pack.addProvider(FrostyAppleModelItems::new);
    }
}
