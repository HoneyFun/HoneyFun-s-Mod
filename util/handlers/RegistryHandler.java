package com.lyghtningwither.honeyfunmods.util.handlers;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.blocks.animated.render.RenderIcyChest;
import com.lyghtningwither.honeyfunmods.blocks.animated.tileentity.TileEntityIcyChest;
import com.lyghtningwither.honeyfunmods.commands.CommandDimensionTeleport;
import com.lyghtningwither.honeyfunmods.commands.Explosion;
import com.lyghtningwither.honeyfunmods.init.BiomeInit;
import com.lyghtningwither.honeyfunmods.init.DimensionInit;
import com.lyghtningwither.honeyfunmods.init.EnchantmentInit;
import com.lyghtningwither.honeyfunmods.init.EntityInit;
import com.lyghtningwither.honeyfunmods.init.FluidInit;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.init.ModItems;
import com.lyghtningwither.honeyfunmods.util.Reference;
import com.lyghtningwither.honeyfunmods.util.compat.OreDictionaryCompat;
import com.lyghtningwither.honeyfunmods.util.interfaces.IHasModel;
import com.lyghtningwither.honeyfunmods.world.gen.WorldGenCustomOres;
import com.lyghtningwither.honeyfunmods.world.gen.WorldGenCustomStructures;
import com.lyghtningwither.honeyfunmods.world.types.WorldTypeCustom;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidRegistry.FluidRegisterEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;

@EventBusSubscriber(modid = Reference.MOD_ID)
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		
		Main.logger.info("Registering Items...");
		
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
		
		Main.logger.info("Items Registered!");
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		
		Main.logger.info("Registering Blocks...");
		
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
		
		TileEntityHandler.RegisterTileEntities();
		
		Main.logger.info("Blocks Registered!");
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void onBlockRegisterClient(RegistryEvent.Register<Block> event) {
		
		Main.logger.info("Registering TESRs.");
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIcyChest.class, new RenderIcyChest());
		
		Main.logger.info("TESR registration is complete.");
	}
	
	@SubscribeEvent
	public static void onEnchantmentRegister(RegistryEvent.Register<Enchantment> event) {
		
		Main.logger.info("Registering Enchantments...");
		
		event.getRegistry().registerAll(EnchantmentInit.ENCHANTMENTS.toArray(new Enchantment[0]));
		
		Main.logger.info("Enchantments Registered!");
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		
		Main.logger.info("Registering Models...");
		
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(ModBlocks.ICY_CHEST), 0, "inventory");
		
		for(Item item : ModItems.ITEMS) {
			
			if(item instanceof IHasModel) {
				
				((IHasModel) item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS) {
			
			if(block instanceof IHasModel) {
				
				((IHasModel) block).registerModels();
			}
		}
		
		Main.logger.info("Registered Models!");
	}
	
	public static void preInitRegistries(FMLPreInitializationEvent event) {
		
		Main.logger.info("Pre initializing.");
		
		FluidInit.registerFluids();
		
		DimensionInit.registerDimensions();
		
		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
		
		BiomeInit.registerBiomes();
		
		EntityInit.registerEntities();
		
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
		
		ConfigHandler.registerConfig(event);
		
		SoundHandler.registerSounds();
		
		LootTableHandler.register();
		
		Main.logger.info("Done pre initializing.");
	}
	
	@SideOnly(Side.CLIENT)
	public static void preInitClientSideRegistries(FMLPreInitializationEvent event) {
		
		RenderHandler.registerRenderers();
		
		RenderHandler.registerCustomMeshesAndStates();
	}
	
	public static void initRegistries(FMLInitializationEvent event) {
		
		Main.logger.info("Initializing.");
		
		RecipeHandler.registerRecipes();
		
		Main.logger.info("Done initializing.");
	}
	
	public static void PostInitRegistries(FMLPostInitializationEvent event) {
		
		Main.logger.info("Post initializing.");
		
		WorldType custom = new WorldTypeCustom();
		
		Main.logger.info("Done post initializing.");
	}
	
	public static void serverRegistries(FMLServerStartingEvent event) {
		
		event.registerServerCommand(new CommandDimensionTeleport());
		event.registerServerCommand(new Explosion());
	}
	
	public static void onServerStop(FMLServerStoppingEvent event) {
		
		DimensionManager.unloadWorld(512);
	}
}
