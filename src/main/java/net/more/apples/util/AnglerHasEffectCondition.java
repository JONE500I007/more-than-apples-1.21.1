package net.more.apples.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import net.more.apples.effect.ModEffects;

import java.util.function.Consumer;

public class AnglerHasEffectCondition implements LootItemCondition {

    public static final MapCodec<AnglerHasEffectCondition> CODEC =
            RecordCodecBuilder.mapCodec(instance ->
                    instance.group(
                                    BuiltInRegistries.MOB_EFFECT.holderByNameCodec()
                                            .fieldOf("effect")
                                            .forGetter(c -> c.effect))
                            .apply(instance, AnglerHasEffectCondition::new));

    private final Holder<MobEffect> effect;

    public AnglerHasEffectCondition(Holder<MobEffect> effect) {
        this.effect = effect;
    }

    @Override
    public MapCodec<? extends LootItemCondition> codec() {
        return ModLootConditions.ANGLER_HAS_EFFECT;
    }

    @Override
    public boolean test(LootContext ctx) {
        Entity e = ctx.getParameter(LootContextParams.THIS_ENTITY);
        if (e instanceof FishingHook bobber) {
            Entity owner = bobber.getOwner();
            if (owner instanceof LivingEntity living) {
                return living.hasEffect(this.effect);
            }
        }
        return false;
    }
    /*
    @Override
    public boolean test(LootContext ctx) {
        Entity e = ctx.get(LootContextParameters.THIS_ENTITY);

        if (e instanceof FishingBobberEntity bobber) {
            Entity owner = bobber.getOwner();
            if (owner instanceof LivingEntity living) {
                return living.hasStatusEffect(effect);
            }
            return false;
        }
        if (e instanceof LivingEntity living) {
            return living.hasStatusEffect(effect);
        }

        return false;
    }
     */


    public static AnglerHasEffectCondition of(Holder<MobEffect> effect) {
        return new AnglerHasEffectCondition(effect);
    }
}
