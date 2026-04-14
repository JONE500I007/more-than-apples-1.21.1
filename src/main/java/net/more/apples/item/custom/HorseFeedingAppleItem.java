package net.more.apples.item.custom;


import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.dedicated.Settings;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HorseFeedingAppleItem extends Item {
    public HorseFeedingAppleItem(Properties properties) {
        super(properties);
    }
    //all this just for test not use


    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity target, InteractionHand type) {
        if (!(target instanceof net.minecraft.world.entity.animal.equine.AbstractHorse)) {
            return InteractionResult.PASS;
        }
        net.minecraft.world.entity.animal.equine.AbstractHorse horse = (net.minecraft.world.entity.animal.equine.AbstractHorse) target;
        Level level = player.level();
        if (level.isClientSide()) return InteractionResult.SUCCESS;

        boolean didFeed = false;

        if (horse.isBaby()) {
            int age = horse.getAge();
            int grow = 60 * 20;
            int newAge = Math.min(0, age + grow);
            horse.setAge(newAge);
            didFeed = true;
        }

        if (horse.getHealth() < horse.getMaxHealth()) {
            horse.heal(3.0f);
            didFeed = true;
        }

        if (didFeed) {
            if (!player.getAbilities().instabuild) itemStack.shrink(1);

            level.playSound(null, horse.blockPosition(),
                    net.minecraft.sounds.SoundEvents.HORSE_EAT, net.minecraft.sounds.SoundSource.NEUTRAL, 1.0f, 1.0f);

            if (level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(net.minecraft.core.particles.ParticleTypes.HAPPY_VILLAGER,
                        horse.getX(), horse.getY(0.5), horse.getZ(), 5, 0.3, 0.3, 0.3, 0.01);
            }

            player.swing(type, true);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

//    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
//        if (!(entity instanceof net.minecraft.world.entity.animal.equine.AbstractHorse)) {
//            return InteractionResult.PASS; [cite: 30]
//        }
//
//        net.minecraft.world.entity.animal.equine.AbstractHorse horse = (net.minecraft.world.entity.animal.equine.AbstractHorse) entity;
//
//        Level level = player.level();
//        if (level.isClientSide()) {
//            return InteractionResult.SUCCESS;
//        }
//
//        boolean didFeed = false;
//
//        if (horse.isBaby()) {
//            horse.ageUp(60);
//            didFeed = true;
//        }
//
//        if (horse.getHealth() < horse.getMaxHealth()) {
//            horse.heal(3.0f);
//            didFeed = true;
//        }
//
//        if (didFeed) {
//            if (!player.getAbilities().instabuild) {
//                stack.shrink(1);
//            }
//            level.playSound(null, horse.blockPosition(),
//                    net.minecraft.sounds.SoundEvents.HORSE_EAT, net.minecraft.sounds.SoundSource.NEUTRAL, 1.0f, 1.0f);
//
//            if (level instanceof ServerLevel serverLevel) {
//                serverLevel.sendParticles(net.minecraft.core.particles.ParticleTypes.HAPPY_VILLAGER,
//                        horse.getX(), horse.getY(0.5), horse.getZ(), 5, 0.3, 0.3, 0.3, 0.01);
//            }
//
//            player.swing(hand, true);
//            return InteractionResult.SUCCESS;
//        }
//
//        return InteractionResult.PASS; [cite: 30]
//    }
}
