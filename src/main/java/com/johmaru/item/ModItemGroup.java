package com.johmaru.item;

import com.johmaru.GoddesOfVictoryMod;
import com.johmaru.block.ModBlocks;
import com.johmaru.item.general.RaptureScrapItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public final static ItemGroup Ore_Group = FabricItemGroup.builder()
            .icon(() -> new ItemStack(RaptureScrapItem.getRaptureScrapRegister()))
            .displayName(Text.translatable("itemgroup.ore"))
            .entries(((displayContext, entries) -> {
                entries.add(RaptureScrapItem.getRaptureScrapRegister());
                entries.add(ModBlocks.RAPTURE_SCRAP_BLOCK);
            }))
            .build();

    public static void registerModItemGroup() {
        GoddesOfVictoryMod.LOGGER.info("Registering mod item group for " + GoddesOfVictoryMod.MODID);

        Registry.register(Registries.ITEM_GROUP, new Identifier(GoddesOfVictoryMod.MODID, "ore"), Ore_Group);
    }
}
