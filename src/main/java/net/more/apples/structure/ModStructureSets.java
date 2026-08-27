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
    public static ResourceKey<StructureSet> TEST_DUNGEON = ResourceKey.create(
            Registries.STRUCTURE_SET,
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "test_dungeon"));
    public static ResourceKey<StructureSet> DNG_ROOM = ResourceKey.create(
            Registries.STRUCTURE_SET,
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "dng_room"));
    public static ResourceKey<StructureSet> TOWER_ROOM = ResourceKey.create(
            Registries.STRUCTURE_SET,
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "tower_room"));

    public static ResourceKey<StructureSet> BADLANDS_HIDEOUT = ResourceKey.create(
            Registries.STRUCTURE_SET,
            Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "badlands_hideout"));

    public static void bootstrap(BootstrapContext<StructureSet> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);

        /*
        context.register(JUST_TEST, new StructureSet(
                structures.getOrThrow(ModStructures.JUST_TEST),
                new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 12345)
        ));

        context.register(TEST_DUNGEON, new StructureSet(
                structures.getOrThrow(ModStructures.TEST_DUNGEON),
                new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 224455)
        ));

        context.register(DNG_ROOM, new StructureSet(
                structures.getOrThrow(ModStructures.DNG_ROOM),
                new RandomSpreadStructurePlacement(4, 2, RandomSpreadType.LINEAR, 12345)
        ));

        context.register(TOWER_ROOM, new StructureSet(
                structures.getOrThrow(ModStructures.TOWER_ROOM),
                new RandomSpreadStructurePlacement(4, 2, RandomSpreadType.LINEAR, 445566)
        ));
         */

        context.register(BADLANDS_HIDEOUT, new StructureSet(
                structures.getOrThrow(ModStructures.BADLANDS_HIDEOUT),
                new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 1122)
        ));
    }
}
