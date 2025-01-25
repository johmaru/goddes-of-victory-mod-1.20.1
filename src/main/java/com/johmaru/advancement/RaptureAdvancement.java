package com.johmaru.advancement;

import com.johmaru.block.ModBlocks;
import com.johmaru.item.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class RaptureAdvancement {
    //private static final Identifier RAPTURE_ADVANCEMENT = new Identifier("goddesofvictory", "rapture_advancement");

    public static void register(Consumer<Advancement> consumer) {
        Advancement.Builder.create()
                .display(new AdvancementDisplay(
                        ModItems.RaptureScrapRegister.getDefaultStack(),
                        Text.literal("Get Rapture Scrap"),
                        Text.literal("You have gotten Rapture Scrap"),
                        new Identifier("minecraft:textures/gui/advancements/backgrounds/stone.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false)

                )
                .criterion("get_rapture_scrap",
                        InventoryChangedCriterion.Conditions.items(
                                ItemPredicate.Builder.create()
                                        .items(ModBlocks.RAPTURE_SCRAP_BLOCK.asItem())
                                        .build()
                        )
                        )
                .requirements(new String[][]{{"get_rapture_scrap"}})
                .build(consumer, "goddesofvictory:rapture_advancement");
    }
}
