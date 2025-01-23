package com.johmaru;

import com.johmaru.block.ModBlocks;
import com.johmaru.item.ModItemGroup;
import com.johmaru.item.ModItems;
import com.johmaru.world.feature.ModPlacedFeatures;
import net.fabricmc.api.ModInitializer;
import net.minecraft.Bootstrap;
import net.minecraft.registry.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.registry.Registries;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import com.johmaru.world.*;


import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static net.minecraft.registry.RegistryKeys.*;

public class GoddesOfVictoryMod implements ModInitializer {
	public static final String MODID = "goddes-of-victory-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.\
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroup.registerModItemGroup();

		Bootstrap.initialize();

		BiomeModifications.create(new Identifier(MODID, "rapture_scrap_gen"))
				.add(ModificationPhase.ADDITIONS,
						BiomeSelectors.foundInOverworld(),
						context -> context.getGenerationSettings().addFeature(
								GenerationStep.Feature.VEGETAL_DECORATION,
								ModPlacedFeatures.RAPTURE_SCRAP_PLACED
						)
				);

		LOGGER.info("Goddes of Victory Mod initialized.");
	}
	}
