package net.more.apples.effect.this_effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class FreezingResistanceEffect extends MobEffect {
    public FreezingResistanceEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, net.minecraft.world.entity.LivingEntity mob, int amplification) {
        mob.setTicksFrozen(0);
        return true;
    }

    @Override
    public boolean isInstantenous() {
        return false;
    }
}
