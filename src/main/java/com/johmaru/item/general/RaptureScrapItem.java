package com.johmaru.item.general;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

import static com.johmaru.item.ModItems.registerItem;

public class RaptureScrapItem {
 private static final Item RaptureScrap = registerItem("rapture_scrap", new Item(new FabricItemSettings().maxCount(64)));

 public static Item getRaptureScrapRegister() {
  return RaptureScrap;
 }

 }
