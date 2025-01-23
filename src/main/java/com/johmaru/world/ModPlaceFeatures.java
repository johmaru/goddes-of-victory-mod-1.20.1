package com.johmaru.world;

import com.johmaru.GoddesOfVictoryMod;
import com.johmaru.block.ModBlocks;
import com.johmaru.block.general.sys.RaptureScrapBlockSys;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModPlaceFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> RAPTURE_SCRAP_BLOCK = registryKey("rapture_scrap_block");

    public static final ConfiguredFeature<?, ?> RAPTURE_SCRAP_BLOCK_CONFIGURED =
            new ConfiguredFeature<>(
                    Feature.RANDOM_PATCH,
                    new RandomPatchFeatureConfig(
                            1, 0, 0,
                            PlacedFeatures.createEntry(
                                    Feature.SIMPLE_BLOCK,
                                    new SimpleBlockFeatureConfig(
                                            BlockStateProvider.of(ModBlocks.RAPTURE_SCRAP_BLOCK)
                                    )
                            )
                    )
            );

   private static RegistryKey<ConfiguredFeature<?,?>> registryKey(String name) {
    return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(GoddesOfVictoryMod.MODID, name));
   }

   public static void bootstrap(FabricDynamicRegistryProvider.Entries entries) {
      SimpleBlockFeatureConfig blockConfig = new SimpleBlockFeatureConfig(
        BlockStateProvider.of(ModBlocks.RAPTURE_SCRAP_BLOCK)
      );

     entries.add(RAPTURE_SCRAP_BLOCK, 
        new ConfiguredFeature<>(Feature.RANDOM_PATCH,
            new RandomPatchFeatureConfig(1, 0, 0, // 1 tries, xz 0, y 0
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, blockConfig)
            )
        )
     );
   }
}