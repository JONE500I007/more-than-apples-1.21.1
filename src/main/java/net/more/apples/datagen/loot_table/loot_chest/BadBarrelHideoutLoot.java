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

public class BadBarrelHideoutLoot {
    public static final ResourceKey<LootTable> BAD_HIDEOUT_BARREL = ModLootTableChest.key(
            "bad_hideout_barrel");

    public static void addLoot(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        ModLootTableChest.addChestLoot(output, BAD_HIDEOUT_BARREL,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(6, 12))
                                .add(LootItem.lootTableItem(Items.RAW_GOLD)
                                        .setWeight(3)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))

                                .add(LootItem.lootTableItem(Items.GOLD_NUGGET)
                                        .setWeight(6)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 7))))

                                .add(LootItem.lootTableItem(Items.GOLD_INGOT)
                                        .setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4))))

                                .add(LootItem.lootTableItem(Items.IRON_INGOT)
                                        .setWeight(4)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 7))))

                                .add(LootItem.lootTableItem(Items.STICK)
                                        .setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))

                                .add(LootItem.lootTableItem(Items.STRING)
                                        .setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6))))
                        )
        );
    }
}
