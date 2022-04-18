package org.yabko.yabko.blockentity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import org.yabko.yabko.block.BlockRegistry;

public class BlockEntityRegistry {
    public static BlockEntityType<MonstersShieldBlockEntity> MONSTERS_SHIELD_BLOCK_ENTITY;

    public static void init() {
        MONSTERS_SHIELD_BLOCK_ENTITY = Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                "tutorial:demo_block_entity",
                FabricBlockEntityTypeBuilder.create(MonstersShieldBlockEntity::new, BlockRegistry.MONSTERS_SHIELD_BLOCK).build(null)
        );
    }
}
