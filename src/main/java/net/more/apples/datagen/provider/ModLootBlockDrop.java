package net.more.apples.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;
import net.more.apples.datagen.loot_table.loot_blockdrop.AppleLootTables;
import net.more.apples.datagen.loot_table.loot_blockdrop.FrostyLootTables;
import net.more.apples.datagen.loot_table.loot_blockdrop.TestAppleLootTables;

import java.util.concurrent.CompletableFuture;

public class ModLootBlockDrop extends FabricBlockLootSubProvider {
    public ModLootBlockDrop(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        AppleLootTables.addLoot(this);
        TestAppleLootTables.addLoot(this);
        FrostyLootTables.addLoot(this);
    }

    public void drop(Block block) {
        dropSelf(block);
    }

    public void addSlabLoot(Block slab) {
        add(slab, createSlabItemTable(slab));
    }

    public void addDoorLoot(Block door) {
        add(door, createDoorTable(door));
    }

    public void addWallSignLoot(Block wallSign, Block standingSign) {
        add(wallSign, createSingleItemTable(standingSign));
    }

    public void addWallHangingSignLoot(Block wallHangingSign, Block hangingSign) {
        add(wallHangingSign, createSingleItemTable(hangingSign));
    }
}
