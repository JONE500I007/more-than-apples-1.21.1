package net.more.apples.effect.this_effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
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
        int current = mob.getTicksFrozen();
        int max = mob.getTicksRequiredToFreeze();
        mob.setIsInPowderSnow(true);

        int freezeAmount = 1 + amplification;
        if (current < max) {
            mob.setTicksFrozen(Math.min(current + freezeAmount, max));
        }

        return true;
    }

    @Override
    public void onMobHurt(ServerLevel level, LivingEntity mob, int amplifier, DamageSource source, float damage) {
        if (source.is(DamageTypes.FREEZE)) {
            //System.out.println("[FreezingEffect] onMobHurt called | amp=" + amplifier + " | incomingDmg=" + damage);
            mob.hurtServer(level, source, amplifier);
        }
    }

    @Override
    public boolean isInstantenous() {
        return false;
    }
}
