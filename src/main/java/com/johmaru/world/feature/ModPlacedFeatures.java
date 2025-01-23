package com.johmaru.world.feature;

import com.johmaru.GoddesOfVictoryMod;
import com.johmaru.world.ModPlaceFeatures;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> RAPTURE_SCRAP_PLACED = registerKey("rapture_scrap_placed");


    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(GoddesOfVictoryMod.MODID, name));
    }

    public static void bootstrap(FabricDynamicRegistryProvider.Entries entries) {
        entries.add(RAPTURE_SCRAP_PLACED,
                new PlacedFeature(
                        entries.ref(ModPlaceFeatures.RAPTURE_SCRAP_BLOCK),
                        List.of(
                                RarityFilterPlacementModifier.of(4),
                                SquarePlacementModifier.of(),
                                PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                                BlockFilterPlacementModifier.of(
                                       BlockPredicate.not(
                                               BlockPredicate.anyOf(
                                                       BlockPredicate.matchingBlocks(Blocks.WATER),
                                                       BlockPredicate.matchingBlocks(Blocks.LAVA)

                                               )
                                       )
                                ),
                                CountPlacementModifier.of(1)
                        )
                )
        );
    }
  }
