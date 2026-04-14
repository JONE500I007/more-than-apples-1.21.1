package net.more.apples.event;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.equine.AbstractHorse;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;


public final class ModEntityUseHandler2 {
    private static final TagKey<Item> MY_HORSE_FOOD =
            TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath("more-than-apples", "horse_food"));

    public static void register() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hit) -> {
            if (!(entity instanceof AbstractHorse horse)) return InteractionResult.PASS;

            ItemStack stack = player.getItemInHand(hand);
            if (!stack.is(MY_HORSE_FOOD)) return InteractionResult.PASS;

            if (world.isClientSide()) return InteractionResult.SUCCESS;

            boolean acted = false;
            boolean bred  = false;

            if (!horse.isTamed()) {
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
                    horse.isTamed() &&
                            !horse.isBaby() &&
                            horse.getAge() == 0 &&
                            !horse.isInLove();

            if (canBreed) {
                horse.setInLoveTime(600);
                bred = true;
                acted = true;
            } else {

                if (horse.isBaby()) {
                    ((ServerLevel) world).sendParticles(
                            bred ? ParticleTypes.HEART : ParticleTypes.HAPPY_VILLAGER,
                            horse.getX(), horse.getY(0.5), horse.getZ(),
                            bred ? 7 : 6, 0.3, 0.3, 0.3, 0.02
                    );
                    int grow = 60 * 20;
                    horse.setAge(Math.min(0, horse.getAge() + grow));
                    acted = true;
                }
                if (horse.getHealth() < horse.getMaxHealth()) {
                    horse.heal(3.0f);
                    acted = true;
                }
            }

            if (acted) {
                if (!player.getAbilities().instabuild) stack.shrink(1);

                world.playSound(
                        null,
                        horse.getX(), horse.getY(), horse.getZ(),
                        SoundEvents.HORSE_EAT,
                        SoundSource.NEUTRAL,
                        1.0f, 1.0f
                );

                player.swing(hand, true);
                return InteractionResult.SUCCESS;
            }

            return InteractionResult.PASS;
        });
    }
}