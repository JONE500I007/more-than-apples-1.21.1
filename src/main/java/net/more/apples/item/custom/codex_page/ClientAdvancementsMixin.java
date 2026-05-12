package net.more.apples.item.custom.codex_page;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;

import java.util.Map;

public interface ClientAdvancementsMixin {
    Map<AdvancementHolder, AdvancementProgress> morethanapples$getProgress();
}
