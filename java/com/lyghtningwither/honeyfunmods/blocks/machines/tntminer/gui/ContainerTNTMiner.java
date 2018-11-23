package com.lyghtningwither.honeyfunmods.blocks.machines.tntminer.gui;

import com.lyghtningwither.honeyfunmods.blocks.machines.tntminer.tileentity.TileEntityTNTMiner;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ContainerTNTMiner extends Container {

	private final TileEntityTNTMiner tileentity;
	
	public ContainerTNTMiner(InventoryPlayer player, TileEntityTNTMiner tileentity) {
		
		this.tileentity = tileentity;
		
		this.addSlotToContainer(new SlotTNT(tileentity, 0, 80, 40));
		
		for (int y = 0; y < 3; y++) {
			
			for (int x = 0; x < 9; x++) {
				
				this.addSlotToContainer(new Slot(player, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}
		
		for (int x = 0; x < 9; x++) {
			
			this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
		}
	}
	
	@Override
	public void addListener(IContainerListener listener) {
		
		super.addListener(listener);
		listener.sendAllWindowProperties(this, this.tileentity);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {

		return true;
	}
}
