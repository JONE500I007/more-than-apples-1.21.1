package net.more.apples.structure;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.more.apples.MoreThanApples;

public class ModStructureSets {
    public static ResourceKey<StructureSet> JUST_TEST = ResourceKey.create(
            Registries.STRUCTURE_SET,
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "just_test"));

    public static void bootstrap(BootstrapContext<StructureSet> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);

        context.register(JUST_TEST, new StructureSet(
                structures.getOrThrow(ModStructures.JUST_TEST),
                new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 12345)
        ));
    }
}
