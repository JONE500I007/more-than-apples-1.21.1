package net.more.apples.datagen.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;
import net.more.apples.datagen.loot_table.loot_blockdrop.AncientAppleBlockDrop;
import net.more.apples.datagen.loot_table.loot_blockdrop.AppleLootBlockDrop;
import net.more.apples.datagen.loot_table.loot_blockdrop.FrostyLootBlockDrop;
import net.more.apples.datagen.loot_table.loot_blockdrop.TestAppleLootBlockDrop;

import java.util.concurrent.CompletableFuture;

public class ModLootBlockDrop extends FabricBlockLootSubProvider {
    public ModLootBlockDrop(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        AppleLootBlockDrop.addLoot(this);
        TestAppleLootBlockDrop.addLoot(this);
        FrostyLootBlockDrop.addLoot(this);
        AncientAppleBlockDrop.addLoot(this);
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