package net.more.apples.event;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.equine.AbstractHorse;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;


public final class ModEntityUseHandler {
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
                int max  = horse.getMaxTemper();
                int now  = horse.getTemper();
                int cap  = Math.max(1, (int)Math.floor(max * 0.9));
                int gain = 20;

                int after = Math.min(cap, now + gain);
                if (after > now) {
                    horse.setTemper(after);
                    acted = true;

                    if (after >= max) {
                        horse.setTamed(true);
                    }
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
                    int grow = 60 * 20;
                    horse.setAge(Math.min(0, horse.getAge() + grow));

                    acted = true;
//                    int grow = 0;
//                    if (stack.isOf(Items.WHEAT)) {
//                        grow = 20 * 20;   // 400 tick (20s)
//                    } else if (stack.isOf(Items.APPLE)) {
//                        grow = 60 * 20;   // 1200 tick (60s)
//                    } else if (stack.isOf(Blocks.HAY_BLOCK.asItem())) {
//                        grow = 180 * 20;  // 3600 tick (180s = 3m)
//                    }
                    // apply only if grow > 0
//                    if (grow > 0 && horse.isBaby()) {
//                        horse.setBreedingAge(Math.min(0, horse.getBreedingAge() + grow));
//                        acted = true;
//                    }
                }
                if (horse.getHealth() < horse.getMaxHealth()) {
                    horse.heal(3.0f);
                    acted = true;
                }
            }

// apply effects only if something actually happened
            if (acted) {
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }

                world.playSound(
                        null,
                        horse.getX(), horse.getY(), horse.getZ(),
                        SoundEvents.HORSE_EAT,
                        SoundSource.NEUTRAL,
                        1.0f, 1.0f
                );

                if (bred) {
                    ((ServerLevel) world).sendParticles(
                            ParticleTypes.HEART,
                            horse.getX(), horse.getY(0.5), horse.getZ(),
                            7, 0.3, 0.3, 0.3, 0.02
                    );
                } else if (horse.isBaby()) {
                    ((ServerLevel) world).sendParticles(
                            ParticleTypes.HAPPY_VILLAGER,
                            horse.getX(), horse.getY(0.5), horse.getZ(),
                            6, 0.3, 0.3, 0.3, 0.02
                    );
                }

                player.swing(hand, true);
                return InteractionResult.SUCCESS;
            }


            return InteractionResult.PASS;

        });
    }
}