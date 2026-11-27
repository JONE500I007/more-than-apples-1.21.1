package net.more.apples.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/**
 * Keeps the items on apple shelves from older worlds.
 *
 * <p>Before 1.4.0 the 4 apple shelves had their own block entity, saved as
 * {@code more-than-apples:apple_entity_shelf}. Now they are normal shelves (made by JONE500 Wooden API) and use
 * vanilla's {@code minecraft:shelf} block entity. Both save their items the same way ({@code Items} and
 * {@code align_items_to_bottom}), so when an old chunk loads we only change the id; without this the game would
 * not know the old id and the items would be lost.
 */
@Mixin(BlockEntity.class)
public abstract class OldAppleShelfDataMixin {
	private static final String OLD_SHELF_ID = "more-than-apples:apple_entity_shelf";
	private static final String VANILLA_SHELF_ID = "minecraft:shelf";

	@ModifyVariable(method = "loadStatic", at = @At("HEAD"), argsOnly = true)
	private static CompoundTag moreApples$renameOldShelf(CompoundTag tag) {
		if (OLD_SHELF_ID.equals(tag.getStringOr("id", ""))) {
			CompoundTag renamed = tag.copy();
			renamed.putString("id", VANILLA_SHELF_ID);
			return renamed;
		}
		return tag;
	}
}
