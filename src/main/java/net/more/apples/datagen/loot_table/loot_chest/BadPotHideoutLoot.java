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

public class BadPotHideoutLoot {
    public static final ResourceKey<LootTable> BAD_HIDEOUT_POT = ModLootTableChest.key(
            "bad_hideout_pot");

    public static void addLoot(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        ModLootTableChest.addChestLoot(output, BAD_HIDEOUT_POT,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(2, 4))
                                .add(LootItem.lootTableItem(Items.FEATHER)
                                        .setWeight(2)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))

                                .add(LootItem.lootTableItem(Items.GOLD_NUGGET)
                                        .setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))

                                .add(LootItem.lootTableItem(Items.FLINT)
                                        .setWeight(2)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))))

                                .add(LootItem.lootTableItem(Items.RAW_GOLD)
                                        .setWeight(1)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
                        )
        );
    }
}
