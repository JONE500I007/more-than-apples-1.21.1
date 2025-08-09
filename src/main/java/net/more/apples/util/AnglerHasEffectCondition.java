package net.more.apples.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.entry.LootPoolEntryType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.more.apples.effect.ModEffects;

import java.util.function.Consumer;

public class AnglerHasEffectCondition implements LootCondition {

    public static final MapCodec<AnglerHasEffectCondition> CODEC =
            RecordCodecBuilder.mapCodec(instance ->
                    instance.group(
                            Registries.STATUS_EFFECT.getEntryCodec()
                                    .fieldOf("effect")
                                    .forGetter(c -> c.effect)
                    ).apply(instance, AnglerHasEffectCondition::new)
            );

    private final RegistryEntry<StatusEffect> effect;

    public AnglerHasEffectCondition(RegistryEntry<StatusEffect> effect) {
        this.effect = effect;
    }

    @Override
    public LootConditionType getType() {
        return ModLootConditions.ANGLER_HAS_EFFECT;
    }

    @Override
    public boolean test(LootContext ctx) {
        Entity e = ctx.get(LootContextParameters.THIS_ENTITY);
        if (e instanceof FishingBobberEntity bobber) {
            Entity owner = bobber.getOwner();
            if (owner instanceof LivingEntity living) {
                return living.hasStatusEffect(effect);
            }
        }
        return false;
    }
    /*
    @Override
    public boolean test(LootContext ctx) {
        Entity e = ctx.get(LootContextParameters.THIS_ENTITY);

        // เคส 1: เป็นทุ่นตกปลา
        if (e instanceof FishingBobberEntity bobber) {
            Entity owner = bobber.getOwner();
            if (owner instanceof LivingEntity living) {
                return living.hasStatusEffect(effect); // 1.21.1 รับ RegistryEntry ได้ตรง ๆ
            }
            return false;
        }

        // เคส 2: เป็นผู้เล่น/ม็อบตรง ๆ
        if (e instanceof LivingEntity living) {
            return living.hasStatusEffect(effect);
        }

        return false;
    }
     */


    public static AnglerHasEffectCondition of(RegistryEntry<StatusEffect> eff) {
        return new AnglerHasEffectCondition(eff);
    }
}
