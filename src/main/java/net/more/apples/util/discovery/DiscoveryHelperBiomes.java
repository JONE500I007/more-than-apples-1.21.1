package net.more.apples.util.discovery;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementNode;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientAdvancements;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.resources.Identifier;
import net.more.apples.MoreThanApples;
import net.more.apples.item.custom.codex_page.ClientAdvancementsMixin;


import java.util.Map;

public class DiscoveryHelperBiomes {
    public static boolean hasDiscovered(String advancementPath) {

        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) return false;

        ClientPacketListener connection = minecraft.player.connection;
        if (connection == null) return false;

        Identifier id = Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, advancementPath);
        ClientAdvancements clientAdvancements = connection.getAdvancements();

        AdvancementHolder holder = clientAdvancements.get(id);
        if (holder == null) return false;

        Map<AdvancementHolder, AdvancementProgress> progressMap =
                ((ClientAdvancementsMixin) clientAdvancements).morethanapples$getProgress();

        AdvancementProgress progress = progressMap.get(holder);
        if (progress == null) return false;

        return progress.isDone();
    }
}
