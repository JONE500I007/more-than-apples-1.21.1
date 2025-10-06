package net.more.apples.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.more.apples.MoreThanApples;
import net.more.apples.block.ModBlocks2;

public class ModAppleVillagers {

    public static final RegistryKey<PointOfInterestType> APPLE_POI_KEY = registerPoiKey("apple_poi");
    public static final PointOfInterestType APPLE_POI = registerPoi("apple_poi", ModBlocks2.APPLE_BARREL);

    public static final VillagerProfession APPLE_MASTER = registerProfession("apple_master", APPLE_POI_KEY);

    public static final RegistryKey<VillagerProfession> APPLE_MASTER_KEY = RegistryKey.of(
            RegistryKeys.VILLAGER_PROFESSION, Identifier.of(MoreThanApples.MOD_ID, "apple_master"));

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(MoreThanApples.MOD_ID, name),
                /*
                new VillagerProfession(Text.literal(name), entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_FISHERMAN));
                 */
                /*
                new VillagerProfession(Text.translatable("entity.minecraft.villager.fishing_master"), entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_FISHERMAN));
                 */
                new VillagerProfession(name, entry -> entry.matchesKey(type),
                        entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_FARMER));
    }
    /*
    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(MoreThanApples.MOD_ID, name),1, 1, block);
    }
     */

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(MoreThanApples.MOD_ID, name),
                1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(MoreThanApples.MOD_ID, name));
    }

    public static void registerVillagers() {
        MoreThanApples.LOGGER.info("Registering Villagers" + MoreThanApples.MOD_ID);
    }
}
