package net.more.apples.datage_entrypoint;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.more.apples.datagen.loot_table.loot_blockdrop.AppleLootBlockDrop;
import net.more.apples.datagen.loot_table.loot_blockdrop.FrostyAppleLootBlockDrop;
import net.more.apples.datagen.loot_table.loot_blockdrop.TestAppleLootBlockDrop;
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

        pack.addProvider(TestAppleBlockTag::new);
        pack.addProvider(TestAppleItemTag::new);
        pack.addProvider(TestAppleLootBlockDrop::new);

        pack.addProvider(FrostyAppleBlockTag::new);
        pack.addProvider(FrostyAppleItemTag::new);
        pack.addProvider(FrostyAppleLootBlockDrop::new);
    }
}
