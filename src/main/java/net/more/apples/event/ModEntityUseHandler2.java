package net.more.apples.event;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

public final class ModEntityUseHandler2 {
    private static final TagKey<Item> MY_HORSE_FOOD =
            TagKey.of(RegistryKeys.ITEM, Identifier.of("more-than-apples", "horse_food"));

    public static void register() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hit) -> {
            if (!(entity instanceof AbstractHorseEntity horse)) return ActionResult.PASS;

            ItemStack stack = player.getStackInHand(hand);
            if (!stack.isIn(MY_HORSE_FOOD)) return ActionResult.PASS;

            if (world.isClient) return ActionResult.SUCCESS;

            boolean acted = false;
            boolean bred  = false;

            if (!horse.isTame()) {
                try {
                    int max  = horse.getMaxTemper();
                    int now  = horse.getTemper();
                    int cap  = Math.max(1, (int)Math.floor(max * 0.9));
                    int gain = 20;

                    int after = Math.min(cap, now + gain);
                    if (after > now) {
                        horse.setTemper(after);
                        acted = true;
                    }

                } catch (Throwable ignored) {

                }
            }

            boolean canBreed =
                    horse.isTame() &&
                            !horse.isBaby() &&
                            horse.getBreedingAge() == 0 &&
                            !horse.isInLove();

            if (canBreed) {
                horse.setLoveTicks(600);
                bred = true;
                acted = true;
            } else {

                if (horse.isBaby()) {
                    ((ServerWorld) world).spawnParticles(
                            bred ? ParticleTypes.HEART : ParticleTypes.HAPPY_VILLAGER,
                            horse.getX(), horse.getBodyY(0.5), horse.getZ(),
                            bred ? 7 : 6, 0.3, 0.3, 0.3, 0.02
                    );
                    int grow = 60 * 20;
                    horse.setBreedingAge(Math.min(0, horse.getBreedingAge() + grow));
                    acted = true;
                }
                if (horse.getHealth() < horse.getMaxHealth()) {
                    horse.heal(3.0f);
                    acted = true;
                }
            }

            if (acted) {
                if (!player.getAbilities().creativeMode) stack.decrement(1);

                world.playSound(
                        null,
                        horse.getX(), horse.getY(), horse.getZ(),
                        SoundEvents.ENTITY_HORSE_EAT,
                        SoundCategory.NEUTRAL,
                        1.0f, 1.0f
                );

                player.swingHand(hand, true);
                return ActionResult.SUCCESS;
            }

            return ActionResult.PASS;
        });
    }
}