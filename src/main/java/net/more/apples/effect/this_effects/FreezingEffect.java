package net.more.apples.effect.this_effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.more.apples.effect.ModEffectsRegister;

public class FreezingEffect extends MobEffect {

    public FreezingEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity mob, int amplification) {
//        int max = mob.getTicksRequiredToFreeze();
//        mob.setIsInPowderSnow(true);
//        mob.setTicksFrozen(max);
//        mob.hurtServer(serverLevel, mob.damageSources().freeze(), 1.0F);

        int current = mob.getTicksFrozen();
        int max = mob.getTicksRequiredToFreeze();
        mob.setIsInPowderSnow(true);

        // Freeze speed scales with level
        int freezeAmount = 1 + amplification;

        if (current < max) {
            mob.setTicksFrozen(Math.min(current + freezeAmount, max));
        }

        // Damage scales and every 2 seconds ONLY
        if (mob.isFullyFrozen()) {
            if (serverLevel.getGameTime() % 40 == 0) {
                mob.hurtServer(serverLevel, mob.damageSources().freeze(), 1.0F + amplification);
            }
        }

        return true;
    }

    @Override
    public boolean isInstantenous() {
        return false;
    }
}
