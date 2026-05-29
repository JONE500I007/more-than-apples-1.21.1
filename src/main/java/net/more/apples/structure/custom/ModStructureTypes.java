package net.more.apples.structure.custom;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.more.apples.MoreThanApples;

public class ModStructureTypes {
    public static StructureType<DngRoomStructure> DNG_ROOM;

    public static void register() {
        DNG_ROOM = Registry.register(
                BuiltInRegistries.STRUCTURE_TYPE,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "dng_room"),
                () -> DngRoomStructure.CODEC
        );
    }
}
