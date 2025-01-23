package com.johmaru;

import com.johmaru.world.ModPlaceFeatures;
import com.johmaru.world.feature.ModPlacedFeatures;
import com.terraformersmc.modmenu.util.mod.Mod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;

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
	}
}
