package net.more.apples.effect.this_effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class DarknessImmuneEffect extends MobEffect {
    public DarknessImmuneEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

//    public WitherResistanceEffect() {
//        super(StatusEffectCategory.BENEFICIAL, 0x000000);
//    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(ServerLevel serverLevel, net.minecraft.world.entity.LivingEntity mob, int amplification) {
        if (mob.hasEffect(MobEffects.DARKNESS)) {
            mob.removeEffect(MobEffects.DARKNESS);
            //return true;
        }
        //return super.applyUpdateEffect(entity, amplifier);
        return true;
    }
}
