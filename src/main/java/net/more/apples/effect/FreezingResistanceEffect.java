package net.more.apples.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FreezingResistanceEffect extends StatusEffect {
    public FreezingResistanceEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.setFrozenTicks(0);
        return true;
    }

    @Override
    public boolean isInstant() {
        return false;
    }
}
