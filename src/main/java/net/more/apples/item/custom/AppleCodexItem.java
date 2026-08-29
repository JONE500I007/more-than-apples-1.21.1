package net.more.apples.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class AppleCodexItem extends Item {
    public AppleCodexItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {

        if(level.isClientSide()) {
            Minecraft.getInstance().setScreenAndShow(new AppleCodexScreen(Component.literal("Apple Codex")));
        }

        return InteractionResult.SUCCESS;
    }
}
