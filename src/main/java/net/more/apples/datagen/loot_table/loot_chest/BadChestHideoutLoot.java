package net.more.apples.datagen.loot_table.loot_chest;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.more.apples.datagen.provider.ModLootTableChest;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import net.more.apples.item.general_item.ModGeneralItems;

import java.util.function.BiConsumer;

public class BadChestHideoutLoot {
    public static final ResourceKey<LootTable> BAD_HIDEOUT_CHEST = ModLootTableChest.key(
            "bad_hideout_chest");

    public static void addLoot(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        ModLootTableChest.addChestLoot(output, BAD_HIDEOUT_CHEST,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(4, 8))
                                .add(LootItem.lootTableItem(Items.GOLD_BLOCK)
                                        .setWeight(2)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))

                                .add(LootItem.lootTableItem(Items.GOLD_INGOT)
                                        .setWeight(3)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))

                                .add(LootItem.lootTableItem(Items.DIAMOND)
                                        .setWeight(2)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))

                                .add(LootItem.lootTableItem(ModGeneralItems.DIAMOND_NUGGET)
                                        .setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 15))))

                                .add(LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                        .setWeight(2)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))
                        )
        );
    }
}
