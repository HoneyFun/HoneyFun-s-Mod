package com.lyghtningwither.honeyfunmods.util.handlers;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.blocks.animated.tileentity.TileEntityIcyChest;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.tileentity.TileEntityCompressor;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.tileentity.TileEntityLightningGenerator;
import com.lyghtningwither.honeyfunmods.blocks.machines.miner.tileentity.TileEntityMiner;
import com.lyghtningwither.honeyfunmods.blocks.machines.tntminer.tileentity.TileEntityTNTMiner;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {

	public static void RegisterTileEntities() {
		
		Main.logger.info("Registering TileEntities...");
		GameRegistry.registerTileEntity(TileEntityMiner.class, new ResourceLocation("minecraft:miner_te"));
		GameRegistry.registerTileEntity(TileEntityTNTMiner.class, new ResourceLocation("minecraft:tnt_miner_te"));
		GameRegistry.registerTileEntity(TileEntityLightningGenerator.class, new ResourceLocation("minecraft:lightning_generator_te"));
		GameRegistry.registerTileEntity(TileEntityCompressor.class, new ResourceLocation("minecraft:electric_compressor"));
		GameRegistry.registerTileEntity(TileEntityIcyChest.class, new ResourceLocation(Reference.MOD_ID + ":icy_chest"));
		Main.logger.info("Registered TileEntities!");
	}
}
