package net.more.apples.mixin;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.multiplayer.ClientAdvancements;
import net.more.apples.item.custom.codex_page.ClientAdvancementsMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(ClientAdvancements.class)
public abstract class ClientAdvancementsMixinImpl implements ClientAdvancementsMixin {

    @Shadow
    private Map<AdvancementHolder, AdvancementProgress> progress;

    @Override
    public Map<AdvancementHolder, AdvancementProgress> morethanapples$getProgress() {
        return this.progress;
    }
}