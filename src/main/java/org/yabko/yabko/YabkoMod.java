package org.yabko.yabko;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yabko.yabko.block.BlockRegistry;
import org.yabko.yabko.blockentity.BlockEntityRegistry;

public class YabkoMod implements ModInitializer {
	public static final String MOD_ID = "yabko";
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "general"),
			() -> new ItemStack(Items.APPLE));

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Yabko base mod initialising...");

		BlockRegistry.init();
		BlockEntityRegistry.init();
	}
}
