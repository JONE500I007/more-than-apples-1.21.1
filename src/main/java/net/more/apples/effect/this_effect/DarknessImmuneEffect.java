package net.more.apples.effect.this_effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;

public class DarknessImmuneEffect extends StatusEffect {
    public DarknessImmuneEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

//    public WitherResistanceEffect() {
//        super(StatusEffectCategory.BENEFICIAL, 0x000000);
//    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity.hasStatusEffect(StatusEffects.DARKNESS)) {
            entity.removeStatusEffect(StatusEffects.DARKNESS);
        }
        return true;
    }
}
