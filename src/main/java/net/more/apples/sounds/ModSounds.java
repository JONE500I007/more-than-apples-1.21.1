package net.more.apples.sounds;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.more.apples.MoreThanApples;

public class ModSounds {
    public static final SoundEvent CODEX_PAGE_TURN_1 = register("codex_page_turn_1");
    public static final SoundEvent CODEX_PAGE_TURN_2 = register("codex_page_turn_2");
    public static final SoundEvent CODEX_PAGE_TURN_3 = register("codex_page_turn_3");
    public static final SoundEvent CODEX_PAGE_TURN_4 = register("codex_page_turn_4");

    private static SoundEvent register(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static void registerSounds() {
        MoreThanApples.LOGGER.info("Registering Mod Sounds for " + MoreThanApples.MOD_ID);
    }
}