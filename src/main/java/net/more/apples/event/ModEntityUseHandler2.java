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

public class ModEntityUseHandler2 {
    private static final TagKey<Item> MY_HORSE_FOOD =
            TagKey.create(BuiltInRegistries.ITEM.key(),
                    Identifier.fromNamespaceAndPath("more-than-apples", "horse_food"));

    private static final float HEAL_AMOUNT = 4.0F;
    private static final int AGE_UP_SECONDS = 60;
    private static final int TEMPER_GAIN = 20;

    public static void register() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hit) -> {
            if (!(entity instanceof AbstractHorse horse)) return InteractionResult.PASS;

            ItemStack stack = player.getItemInHand(hand);
            if (!stack.is(MY_HORSE_FOOD)) return InteractionResult.PASS;

            if (world.isClientSide()) return InteractionResult.SUCCESS;

            boolean itemUsed = false;

            if (horse.getHealth() < horse.getMaxHealth()) {
                horse.heal(HEAL_AMOUNT);
                itemUsed = true;
            }

            if (horse.isBaby()) {
                ((ServerLevel) world).sendParticles(
                        ParticleTypes.HAPPY_VILLAGER,
                        horse.getX(), horse.getY(0.5), horse.getZ(),
                        6, 0.3, 0.3, 0.3, 0.02
                );
                horse.ageUp(AGE_UP_SECONDS);
                itemUsed = true;
            } else if (!horse.isTamed()) {
                // Feeding only raises temper; the vanilla RunAroundLikeCrazyGoal
                // (already registered on every AbstractHorse) rolls the actual
                // taming chance against temper/maxTemper while the horse is ridden.
                if (horse.getTemper() < horse.getMaxTemper()) {
                    horse.modifyTemper(TEMPER_GAIN);
                    itemUsed = true;
                }
            } else if (horse.getAge() == 0 && !horse.isInLove()) {
                // setInLove() also sets the loveCause (breeding credit) and
                // broadcasts the heart-particle event, unlike setInLoveTime().
                horse.setInLove(player);
                itemUsed = true;
            }

            if (itemUsed) {
                if (!player.hasInfiniteMaterials()) stack.shrink(1);

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
