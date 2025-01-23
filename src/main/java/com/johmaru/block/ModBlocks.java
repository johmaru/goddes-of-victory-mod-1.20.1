package com.johmaru.block;

import com.johmaru.GoddesOfVictoryMod;
import com.johmaru.block.general.sys.RaptureScrapBlockSys;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block RAPTURE_SCRAP_BLOCK =  registerBlock("rapture_scrap_block",
            new RaptureScrapBlockSys(FabricBlockSettings.copyOf(Blocks.ANVIL)
            .sounds(BlockSoundGroup.ANVIL)
                    .nonOpaque()
                    .solid()
                    .suffocates((state, world, pos) -> true)
                    .blockVision((state, world, pos) -> true)
    ));

    public static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(GoddesOfVictoryMod.MODID, name), block);
    };

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(GoddesOfVictoryMod.MODID, name),
            new BlockItem(block,new FabricItemSettings()));
    };

    public static void registerModBlocks() {

        GoddesOfVictoryMod.LOGGER.info("Registering mod blocks for " + GoddesOfVictoryMod.MODID);

    }
}
