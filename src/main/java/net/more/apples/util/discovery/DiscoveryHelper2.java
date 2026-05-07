package net.more.apples.util.discovery;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.resources.Identifier;
import net.more.apples.MoreThanApples;

public class DiscoveryHelper2 {

    public static boolean hasDiscovered(String advancementPath) {

        Minecraft minecraft = Minecraft.getInstance();

        if(minecraft.player == null) {
            return false;
        }

        ClientPacketListener connection = minecraft.player.connection;

        if(connection == null) {
            return false;
        }

        AdvancementHolder advancement =
                connection.getAdvancements().get(
                        Identifier.fromNamespaceAndPath(
                                MoreThanApples.MOD_ID,
                                advancementPath));

        return advancement != null;
    }
}