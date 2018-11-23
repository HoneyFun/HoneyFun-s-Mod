package com.lyghtningwither.honeyfunmods.util.handlers;

import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {

	public static final ResourceLocation ICY_CHEST = new ResourceLocation(Reference.MOD_ID + ":icy_table.json");
	
	public static void register() {
		
		LootTableList.register(ICY_CHEST);
	}
}
