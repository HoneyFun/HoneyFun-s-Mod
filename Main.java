package com.lyghtningwither.honeyfunmods;

import java.io.File;

import org.apache.logging.log4j.Logger;

import com.google.gson.JsonObject;
import com.lyghtningwither.honeyfunmods.commands.CommandDimensionTeleport;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;
import com.lyghtningwither.honeyfunmods.proxy.CommonProxy;
import com.lyghtningwither.honeyfunmods.tabs.HoneyfunTabBlocks;
import com.lyghtningwither.honeyfunmods.tabs.HoneyfunTabItems;
import com.lyghtningwither.honeyfunmods.tabs.HoneyfunTabToolsAndWeapons;
import com.lyghtningwither.honeyfunmods.util.Reference;
import com.lyghtningwither.honeyfunmods.util.handlers.RegistryHandler;
import com.lyghtningwither.honeyfunmods.util.helpers.RecipeHelper;

import net.minecraft.advancements.Advancement;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.advancements.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS, updateJSON = Reference.UPDATE_URL, canBeDeactivated = true)
public class Main {

	public static File config;
	
	public static Logger logger;

	public static final CreativeTabs honeyfuntab_items = new HoneyfunTabItems("honeyfuntab_items");

	public static final CreativeTabs honeyfuntab_blocks = new HoneyfunTabBlocks("honeyfuntab_blocks");

	public static final CreativeTabs honeyfuntab_tools_weapons = new HoneyfunTabToolsAndWeapons("honeyfuntab_tools_weapons");
	
	@Instance
	public static Main instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	static {
		
		FluidRegistry.enableUniversalBucket();
	}
	
	@EventHandler
	@SideOnly(Side.CLIENT)
	public static void preInitClient(FMLPreInitializationEvent event) {
		
		RegistryHandler.preInitClientSideRegistries(event);
	}

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		
		logger = event.getModLog();
		RegistryHandler.preInitRegistries(event);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		
		RegistryHandler.initRegistries(event);
	}

	@EventHandler
	public static void postinit(FMLPostInitializationEvent event) {

		RegistryHandler.PostInitRegistries(event);
	}

	@EventHandler
	public static void serverInit(FMLServerStartingEvent event) {

		RegistryHandler.serverRegistries(event);
	}
}
