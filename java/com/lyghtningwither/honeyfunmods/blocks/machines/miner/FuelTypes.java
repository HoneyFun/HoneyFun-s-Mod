package com.lyghtningwither.honeyfunmods.blocks.machines.miner;

import com.lyghtningwither.honeyfunmods.init.ModBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class FuelTypes {
	
	public static final Item COAL = Items.COAL;
	public static final Item COAL_BLOCK = Item.getItemFromBlock(Blocks.COAL_BLOCK);
	public static final Item LOGS = Item.getItemFromBlock(Blocks.LOG);
	public static final Item LOGS_2 = Item.getItemFromBlock(Blocks.LOG2);
	public static final Item LOGS_3 = Item.getItemFromBlock(ModBlocks.WOOD);
	public static final Item PLANKS = Item.getItemFromBlock(Blocks.PLANKS);
	public static final Item PLANKS_2 = Item.getItemFromBlock(ModBlocks.PLANKS);
	public static final Item LAVA = Items.LAVA_BUCKET;
	public static final Item BLAZE_ROD = Items.BLAZE_ROD;
	public static final Item BLAZE_POWDER = Items.BLAZE_POWDER;
	public static final Item MAGMA_CREAM = Items.MAGMA_CREAM;
	
	public static final Item[] ITEMS = {COAL, COAL_BLOCK, LOGS, LOGS_2, LOGS_3, PLANKS, PLANKS_2, LAVA, BLAZE_ROD, BLAZE_POWDER, MAGMA_CREAM};
}
