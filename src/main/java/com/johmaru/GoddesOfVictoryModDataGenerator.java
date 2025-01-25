package com.johmaru;

import com.johmaru.advancement.RaptureAdvancement;
import com.johmaru.world.ModPlaceFeatures;
import com.johmaru.world.feature.ModPlacedFeatures;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.registry.RegistryWrapper;

import java.util.function.Consumer;

public class GoddesOfVictoryModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider((output, registries) ->
				new FabricDynamicRegistryProvider(output, registries) {
					@Override
					protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
						ModPlaceFeatures.bootstrap(entries);
						ModPlacedFeatures.bootstrap(entries);
					}

					@Override
					public String getName() {
						return "Goddes of Victory Mod";
					}
				});

		pack.addProvider((output, registries) ->
			new FabricAdvancementProvider(output) {
				@Override
				public void generateAdvancement(Consumer<Advancement> consumer) {
					RaptureAdvancement.register(consumer);
				}
			}
		);
	}
}
