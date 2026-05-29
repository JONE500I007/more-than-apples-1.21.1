package net.more.apples.structure.custom;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.more.apples.MoreThanApples;

public class ModStructureTypes {
    public static StructureType<ModFixedStructure> FIXED_STRUCTURE;

    public static void register() {
        FIXED_STRUCTURE = Registry.register(
                BuiltInRegistries.STRUCTURE_TYPE,
                Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, "fixed_structure"),
                () -> ModFixedStructure.CODEC
        );
    }
}
