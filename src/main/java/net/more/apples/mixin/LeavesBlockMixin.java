package net.more.apples.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LeavesBlock.class)
public abstract class LeavesBlockMixin {

    @ModifyConstant(method = "updateDistance", constant = @Constant(intValue = 7))
    private static int increaseMaxDistance(int original) {
        return 15;
    }

    @ModifyConstant(method = "decaying", constant = @Constant(intValue = 7))
    private int increaseDecayDistance(int original) {
        return 15;
    }

    @ModifyConstant(method = "isRandomlyTicking", constant = @Constant(intValue = 7))
    private int increaseRandomTickDistance(int original) {
        return 15;
    }
}
