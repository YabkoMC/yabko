package org.yabko.yabko.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.yabko.yabko.YabkoMod;

public class BlockRegistry {
    public static final MonstersShieldBlock MONSTERS_SHIELD_BLOCK = new MonstersShieldBlock(
            FabricBlockSettings.of(Material.METAL).nonOpaque().dropsNothing().breakInstantly().hardness(10F)
    );

    public static void init() {
        Registry.register(Registry.BLOCK,
                new Identifier(YabkoMod.MOD_ID, MonstersShieldBlock.block_name),
                MONSTERS_SHIELD_BLOCK);
        Registry.register(Registry.ITEM,
                new Identifier(YabkoMod.MOD_ID, MonstersShieldBlock.block_name),
                new BlockItem(MONSTERS_SHIELD_BLOCK, new FabricItemSettings().group(YabkoMod.ITEM_GROUP)));
    }
}
