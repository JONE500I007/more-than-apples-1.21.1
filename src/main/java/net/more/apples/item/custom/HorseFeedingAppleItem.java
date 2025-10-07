package net.more.apples.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class HorseFeedingAppleItem extends Item {
    public HorseFeedingAppleItem(Settings settings) {
        super(settings);
    }

    //all this just for test not use

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!(entity instanceof AbstractHorseEntity horse)) return ActionResult.PASS;
        World world = user.getWorld();
        if (world.isClient) return ActionResult.SUCCESS;

        boolean didFeed = false;

        if (horse.isBaby()) {
            int age = horse.getBreedingAge();
            int grow = 60 * 20;
            int newAge = Math.min(0, age + grow);
            horse.setBreedingAge(newAge);
            didFeed = true;
        }

        if (horse.getHealth() < horse.getMaxHealth()) {
            horse.heal(3.0f);
            didFeed = true;
        }

        if (didFeed) {
            if (!user.getAbilities().creativeMode) stack.decrement(1);
            world.playSound(null, horse.getBlockPos(),
                    SoundEvents.ENTITY_GENERIC_EAT.value(), SoundCategory.NEUTRAL, 1.0f, 1.0f);
            ((ServerWorld) world).spawnParticles(ParticleTypes.HAPPY_VILLAGER,
                    horse.getX(), horse.getBodyY(0.5), horse.getZ(), 5, 0.3, 0.3, 0.3, 0.01);
            user.swingHand(hand, true);
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }
}
