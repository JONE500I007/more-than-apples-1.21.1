package net.more.apples.datagen.loot_table.loot_chest;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.more.apples.datagen.provider.ModLootTableChest;

import java.util.function.BiConsumer;

public class TowerLootTable {
    public static final ResourceKey<LootTable> TOWER_CHEST = ModLootTableChest.key(
            "tower_chest");

    public static void addLoot(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        ModLootTableChest.addChestLoot(output, TOWER_CHEST,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(6, 12))
                                .add(LootItem.lootTableItem(Items.DIAMOND)
                                        .setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))
                                .add(LootItem.lootTableItem(Items.GOLD_INGOT)
                                        .setWeight(3)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                                .add(LootItem.lootTableItem(Items.IRON_INGOT)
                                        .setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 10))))
                                .add(LootItem.lootTableItem(Items.STICK)
                                        .setWeight(7)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(6, 10))))
                        )
        );
    }
}
