package com.johmaru.item;

import com.johmaru.GoddesOfVictoryMod;
import com.johmaru.item.general.RaptureScrapItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item RaptureScrapRegister = RaptureScrapItem.getRaptureScrapRegister();

    private static void addItemToTabItemGroup(FabricItemGroupEntries entries){
        entries.add(RaptureScrapRegister);
    }

    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(GoddesOfVictoryMod.MODID, name), item);
    };

    public static void registerModItems() {
        GoddesOfVictoryMod.LOGGER.info("Registering mod items for " + GoddesOfVictoryMod.MODID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToTabItemGroup);
    }
}
