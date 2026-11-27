package net.more.apples.world.biome;

import net.biome.api.climate.ClimatePoints;
import net.biome.api.climate.Continentalness;
import net.biome.api.climate.Erosion;
import net.biome.api.climate.Humidity;
import net.biome.api.climate.Temperature;
import net.biome.api.climate.Weirdness;
import net.biome.api.region.BiomeRegion;
import net.minecraft.resources.Identifier;
import net.more.apples.MoreThanApples;

import static net.more.apples.world.biome.biomes_regions.ancient_apple.AncientAppleBiome.ANCIENT_APPLE_WILDS;
import static net.more.apples.world.biome.biomes_regions.apple_biome.AppleGroveBiome.APPLE_GROVE;
import static net.more.apples.world.biome.biomes_regions.frosty_apple_biome.FrostyAppleBiome.FROSTY_APPLE;
import static net.more.apples.world.biome.biomes_regions.golden_apple_orchard_biome.GoldenAppleOrchardBiome.GOLDEN_APPLE_ORCHARD;

/**
 * Places the More Than Apples biomes in the Overworld with JONE500 Biome API (this used to be TerraBlender).
 *
 * <p>Each biome has a region of its own, with the same ids and weights as before. Vanilla patches have weight 10.
 * Inside its region's patches a biome appears where the climate matches; everywhere else the world stays vanilla.
 *
 * <p>Climate values (vanilla's bands, see the enums in {@code net.biome.api.climate}):
 * <ul>
 *   <li>Several values in one call (e.g. {@code continentalness(MID_INLAND, INLAND)}) = any of them.</li>
 *   <li>{@code Temperature.between(a, b)} = everything from {@code a} to {@code b}.</li>
 *   <li>{@code depth(-1.0F, 1.0F)} = surface and underground.</li>
 * </ul>
 * TerraBlender's {@code Temperature.COOL} is Biome API's {@link Temperature#COLD} (same numbers: -0.45 to -0.15).
 *
 * <p>{@code .overlay()} (Biome API 1.1.0) places the biomes the way TerraBlender did: a biome also wins
 * <i>around</i> its ranges, not only where every value is inside them. Without it these biomes would be about five
 * times rarer than with TerraBlender.
 */
public final class ModBiomeRegions {
	private ModBiomeRegions() {
	}

	public static void register() {
		BiomeRegion.builder(id("apple_grove_region"))
				.overworld()
				.weight(6)
				.addBiome(ClimatePoints.builder()
						.temperature(Temperature.between(Temperature.NEUTRAL, Temperature.WARM))
						.humidity(Humidity.between(Humidity.NEUTRAL, Humidity.WET))
						.continentalness(Continentalness.MID_INLAND, Continentalness.INLAND)
						.erosion(Erosion.EROSION_5, Erosion.EROSION_6)
						.depth(-1.0F, 1.0F)
						.weirdness(Weirdness.MID_SLICE_NORMAL_DESCENDING, Weirdness.LOW_SLICE_NORMAL_DESCENDING)
						.overlay(), APPLE_GROVE)
				.register();

		BiomeRegion.builder(id("golden_apple_orchard_region"))
				.overworld()
				.weight(4)
				.addBiome(ClimatePoints.builder()
						.temperature(Temperature.between(Temperature.NEUTRAL, Temperature.WARM))
						.humidity(Humidity.between(Humidity.NEUTRAL, Humidity.WET))
						.continentalness(Continentalness.MID_INLAND, Continentalness.INLAND)
						.erosion(Erosion.EROSION_5, Erosion.EROSION_6)
						.depth(-1.0F, 1.0F)
						.weirdness(Weirdness.MID_SLICE_NORMAL_DESCENDING, Weirdness.LOW_SLICE_NORMAL_DESCENDING)
						.overlay(), GOLDEN_APPLE_ORCHARD)
				.register();

		// Temperature exactly -0.45 (the border between frozen and cold), the same as before with TerraBlender:
		// TerraBlender's span(COOL, FROZEN) takes the start of COOL (-0.45) and the end of FROZEN (-0.45).
		// For the whole range from frozen to cold use Temperature.between(Temperature.FROZEN, Temperature.COLD).
		BiomeRegion.builder(id("frosty_apple_region"))
				.overworld()
				.weight(5)
				.addBiome(ClimatePoints.builder()
						.temperature(-0.45F, -0.45F)
						.humidity(Humidity.between(Humidity.ARID, Humidity.NEUTRAL))
						.continentalness(Continentalness.NEAR_INLAND, Continentalness.FAR_INLAND)
						.erosion(Erosion.EROSION_5, Erosion.EROSION_6)
						.depth(-1.0F, 1.0F)
						.weirdness(Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING, Weirdness.VALLEY)
						.overlay(), FROSTY_APPLE)
				.register();

		BiomeRegion.builder(id("ancient_apple_wilds"))
				.overworld()
				.weight(5)
				.addBiome(ClimatePoints.builder()
						.temperature(Temperature.between(Temperature.COLD, Temperature.NEUTRAL))
						.humidity(Humidity.between(Humidity.DRY, Humidity.NEUTRAL))
						.continentalness(Continentalness.MID_INLAND, Continentalness.INLAND)
						.erosion(0.05F, 1.0F)
						.depth(-1.0F, 1.0F)
						.weirdness(Weirdness.PEAK_VARIANT, Weirdness.HIGH_SLICE_VARIANT_DESCENDING)
						.overlay(), ANCIENT_APPLE_WILDS)
				.register();

		// Scorched apple badlands: not finished yet (was also commented out with TerraBlender).
		// BiomeRegion.builder(id("scorched_apple_badlands"))
		//		.weight(5)
		//		.addBiome(ClimatePoints.builder()
		//				.temperature(Temperature.between(Temperature.WARM, Temperature.HOT))
		//				.humidity(Humidity.between(Humidity.ARID, Humidity.DRY))
		//				.continentalness(Continentalness.MID_INLAND, Continentalness.INLAND)
		//				.erosion(Erosion.EROSION_0, Erosion.EROSION_6)
		//				.depth(-1.0F, 1.0F)
		//				.weirdness(Weirdness.VALLEY, Weirdness.HIGH_SLICE_VARIANT_DESCENDING), SCORCHED_APPLE_BADLANDS)
		//		.register();
	}

	private static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MoreThanApples.MOD_ID, path);
	}
}
