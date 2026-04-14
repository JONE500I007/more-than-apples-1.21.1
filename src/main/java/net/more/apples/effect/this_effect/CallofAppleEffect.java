package net.more.apples.effect.this_effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class CallofAppleEffect extends MobEffect {
    public CallofAppleEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, net.minecraft.world.entity.LivingEntity mob, int amplification) {
        return super.applyEffectTick(serverLevel, mob, amplification);
    }
}
