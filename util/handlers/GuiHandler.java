package com.lyghtningwither.honeyfunmods.util.handlers;

import com.lyghtningwither.honeyfunmods.blocks.animated.container.ContainerIcyChest;
import com.lyghtningwither.honeyfunmods.blocks.animated.gui.GuiIcyChest;
import com.lyghtningwither.honeyfunmods.blocks.animated.tileentity.TileEntityIcyChest;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.container.ContainerElectricCompressor;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.container.ContainerLightningGenerator;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.gui.GuiElectricCompressor;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.gui.GuiLightningGenerator;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.tileentity.TileEntityCompressor;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.tileentity.TileEntityLightningGenerator;
import com.lyghtningwither.honeyfunmods.blocks.machines.tntminer.gui.ContainerTNTMiner;
import com.lyghtningwither.honeyfunmods.blocks.machines.tntminer.gui.GUITNTMiner;
import com.lyghtningwither.honeyfunmods.blocks.machines.tntminer.tileentity.TileEntityTNTMiner;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if(ID == Reference.GUI_TNT_MINER) return new ContainerTNTMiner(player.inventory, (TileEntityTNTMiner) world.getTileEntity(new BlockPos(x, y, z)));
		else if(ID == Reference.GUI_LIGHTNING_GENERATOR) return new ContainerLightningGenerator(player.inventory, (TileEntityLightningGenerator) world.getTileEntity(new BlockPos(x, y, z)));
		else if(ID == Reference.GUI_ELECTRIC_COMPRESSOR) return new ContainerElectricCompressor(player.inventory, (TileEntityCompressor) world.getTileEntity(new BlockPos(x, y, z)));
		else if(ID == Reference.GUI_ICY_CHEST) return new ContainerIcyChest(player.inventory, (TileEntityIcyChest)world.getTileEntity(new BlockPos(x, y, z)), player);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		if(ID == Reference.GUI_TNT_MINER) return new GUITNTMiner(player.inventory, (TileEntityTNTMiner) world.getTileEntity(new BlockPos(x, y, z)));
		else if(ID == Reference.GUI_LIGHTNING_GENERATOR) return new GuiLightningGenerator(player.inventory, (TileEntityLightningGenerator) world.getTileEntity(new BlockPos(x, y, z)));
		else if(ID == Reference.GUI_ELECTRIC_COMPRESSOR) return new GuiElectricCompressor(player.inventory, (TileEntityCompressor) world.getTileEntity(new BlockPos(x, y, z)));
		else if(ID == Reference.GUI_ICY_CHEST) return new GuiIcyChest(player.inventory, (TileEntityIcyChest)world.getTileEntity(new BlockPos(x, y, z)), player);
		return null;
	}
}
