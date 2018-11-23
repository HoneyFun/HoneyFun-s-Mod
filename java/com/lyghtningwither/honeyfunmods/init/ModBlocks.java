package com.lyghtningwither.honeyfunmods.init;

import java.util.ArrayList;
import java.util.List;

import com.lyghtningwither.honeyfunmods.blocks.BlockBacktracker;
import com.lyghtningwither.honeyfunmods.blocks.BlockBasalt;
import com.lyghtningwither.honeyfunmods.blocks.BlockDoorBase;
import com.lyghtningwither.honeyfunmods.blocks.BlockExplodingOre;
import com.lyghtningwither.honeyfunmods.blocks.BlockFlourescentLamp;
import com.lyghtningwither.honeyfunmods.blocks.BlockIcePortal;
import com.lyghtningwither.honeyfunmods.blocks.BlockIcyBedrock;
import com.lyghtningwither.honeyfunmods.blocks.BlockTomatoPlant;
import com.lyghtningwither.honeyfunmods.blocks.EnderOpalBlock;
import com.lyghtningwither.honeyfunmods.blocks.EnderOpalOre;
import com.lyghtningwither.honeyfunmods.blocks.FieryOpalBlock;
import com.lyghtningwither.honeyfunmods.blocks.FieryOpalOre;
import com.lyghtningwither.honeyfunmods.blocks.IcyOpalBlock;
import com.lyghtningwither.honeyfunmods.blocks.IcyOpalOre;
import com.lyghtningwither.honeyfunmods.blocks.LED;
import com.lyghtningwither.honeyfunmods.blocks.OpalBlock;
import com.lyghtningwither.honeyfunmods.blocks.OpalOre;
import com.lyghtningwither.honeyfunmods.blocks.SiliconOre;
import com.lyghtningwither.honeyfunmods.blocks.SilverOre;
import com.lyghtningwither.honeyfunmods.blocks.animated.BlockIcyChest;
import com.lyghtningwither.honeyfunmods.blocks.fluid.BlockFluid;
import com.lyghtningwither.honeyfunmods.blocks.fluid.BlockHydrogenPeroxide;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.BlockElectricFurnace;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.BlockLightningGenerator;
import com.lyghtningwither.honeyfunmods.blocks.machines.miner.BlockMiner;
import com.lyghtningwither.honeyfunmods.blocks.machines.tntminer.BlockTNTMiner;
import com.lyghtningwither.honeyfunmods.blocks.trees.BlockPlanks;
import com.lyghtningwither.honeyfunmods.blocks.trees.BlockWood;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block OPAL_ORE = new OpalOre("opal_ore", Material.ROCK);
	public static final Block FIREY_OPAL_ORE = new FieryOpalOre("fiery_opal_ore", Material.ROCK);
	public static final Block ENDER_OPAL_ORE = new EnderOpalOre("ender_opal_ore", Material.ROCK);
	public static final Block ICY_OPAL_ORE = new IcyOpalOre("icy_opal_ore", Material.ICE);
	public static final Block OPAL_BLOCK = new OpalBlock("opal_block", Material.IRON);
	public static final Block FIERY_OPAL_BLOCK = new FieryOpalBlock("fiery_opal_block", Material.ROCK);
	public static final Block ENDER_OPAL_BLOCK = new EnderOpalBlock("ender_opal_block", Material.ROCK);
	public static final Block ICY_OPAL_BLOCK = new IcyOpalBlock("icy_opal_block", Material.ICE);
	public static final Block EXPLODING_ORE = new BlockExplodingOre("exploding_ore", Material.ROCK);
	public static final Block SILVER_ORE = new SilverOre("silver_ore", Material.ROCK);
	public static final Block LED = new LED(false, "led", Material.REDSTONE_LIGHT);
	public static final Block LIT_LED = new LED(true, "lit_led", Material.REDSTONE_LIGHT);
	public static final Block SILICON_ORE = new SiliconOre("silicon_ore", Material.ROCK);
	public static final Block ICY_BEDROCK = new BlockIcyBedrock("icy_bedrock", Material.PACKED_ICE);
	
	public static final Block ICE_PORTAL_BLOCK = new BlockIcePortal("ice_portal", Material.GLASS);
	public static final Block BACKTRACKER = new BlockBacktracker("backtracker", Material.GLASS);
	
	public static final Block FLOURESCENT_LAMP = new BlockFlourescentLamp("fluorescent_lamp", Material.REDSTONE_LIGHT);
	
	public static final Block TOMATO_PLANT = new BlockTomatoPlant("tomato_plant");
	//public static final Block PIZZA_PLANT = new BlockPizzaPlant("pizza_plant");
	//public static final Block NOODLE_PLANT = new BlockNoodlePlant("noodle_plant");
	
	public static final Block PLANKS = new BlockPlanks("planks", Material.WOOD);
	public static final Block WOOD = new BlockWood("log", Material.WOOD);
	
	public static final Block MINER = new BlockMiner("miner", Material.IRON);
	public static final Block TNT_MINER = new BlockTNTMiner("tnt_miner", Material.IRON);
	
	public static final Block BASALT = new BlockBasalt("basalt", Material.ROCK);
	
	//Energy Blocks
	public static final Block LIGHTNING_GENERATOR = new BlockLightningGenerator("lightning_generator");
	public static final Block COMPRESSOR = new BlockElectricFurnace("compressor");
	
	public static final Block ICY_CHEST = new BlockIcyChest("icy_chest");
	
	//Fluids
	public static final Block HYDROGEN_PEROXIDE = new BlockHydrogenPeroxide();
	
	public static final Block ICE_DOOR = new BlockDoorBase("ice_door");
}