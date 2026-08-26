package net.more.apples.mixin;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.monster.zombie.ZombieVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.more.apples.item.apple_item.ModAppleFoodItems;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(ZombieVillager.class)
public abstract class ZombieVillagerCureMixin extends Zombie {

    protected ZombieVillagerCureMixin(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }

    @Shadow
    private void startConverting(@Nullable UUID player, int time) {
        throw new UnsupportedOperationException();
    }

    @Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
    private void moreApples$cureWithModApples(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!itemStack.is(ModAppleFoodItems.DIAMOND_APPLE) && !itemStack.is(ModAppleFoodItems.NETHERITE_APPLE)) {
            return;
        }

        if (this.hasEffect(MobEffects.WEAKNESS)) {
            itemStack.consume(1, player);
            if (!this.level().isClientSide()) {
                this.startConverting(player.getUUID(), this.random.nextInt(2401) + 3600);
            }

            cir.setReturnValue(InteractionResult.SUCCESS_SERVER);
        } else {
            cir.setReturnValue(InteractionResult.CONSUME);
        }
    }
}
