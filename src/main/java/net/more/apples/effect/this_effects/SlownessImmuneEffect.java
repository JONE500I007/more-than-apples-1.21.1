package net.more.apples.effect.this_effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;

public class SlownessImmuneEffect extends MobEffect {
    public SlownessImmuneEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, net.minecraft.world.entity.LivingEntity mob, int amplification) {
        if (mob.hasEffect(MobEffects.SLOWNESS)) {
            mob.removeEffect(MobEffects.SLOWNESS);
        }
        return true;
    }
}
