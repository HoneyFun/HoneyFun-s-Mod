package com.lyghtningwither.honeyfunmods.util.handlers;

import com.lyghtningwither.honeyfunmods.blocks.machines.compressor.TileEntityCompressor;
import com.lyghtningwither.honeyfunmods.commands.CommandDimensionTeleport;
import com.lyghtningwither.honeyfunmods.commands.Explosion;
import com.lyghtningwither.honeyfunmods.entity.EntityInit;
import com.lyghtningwither.honeyfunmods.init.BiomeInit;
import com.lyghtningwither.honeyfunmods.init.DimensionInit;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;
import com.lyghtningwither.honeyfunmods.util.IHasModel;
import com.lyghtningwither.honeyfunmods.util.compat.OreDictionaryCompact;
import com.lyghtningwither.honeyfunmods.world.gen.WorldGenCustomStructures;
import com.lyghtningwither.honeyfunmods.world.gen.WorldGenCustumOres;
import com.lyghtningwither.honeyfunmods.world.types.WorldTypeCustom;
//import com.lyghtningwither.honeyfunmods.world.types.WorldTypeSheets;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		
		for(Item item : ModItems.ITEMS) {
			
			if(item instanceof IHasModel) {
				
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS) {
			
			if(block instanceof IHasModel) {
				
				((IHasModel)block).registerModels();
			}
		}
	}
	
	public static void preInitRegistries(FMLPreInitializationEvent event) {
		
		DimensionInit.registerDimensions();
		
		GameRegistry.registerWorldGenerator(new WorldGenCustumOres(), 0);
		
		TileEntity.register("hm:compressor", TileEntityCompressor.class);
		
		BiomeInit.registerBiomes();
		
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
		
		//EntityInit.registerEntities();
		
		RenderHandler.RegisterEntityRenderes();
		
		ConfigHandler.registerConfig(event);
	}
	
	public static void initRegistries(FMLInitializationEvent event) {
		
		OreDictionaryCompact.registerOres();
	}
	
	public static void PostInitRegistries(FMLPostInitializationEvent event) {
		
		WorldType CUSTOM = new WorldTypeCustom();
	}
	
	public static void serverRegistries(FMLServerStartingEvent event) {
		
		event.registerServerCommand(new CommandDimensionTeleport());
		event.registerServerCommand(new Explosion());
	}
}
