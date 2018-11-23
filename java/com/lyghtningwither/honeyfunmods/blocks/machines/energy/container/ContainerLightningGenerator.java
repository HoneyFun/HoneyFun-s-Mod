package com.lyghtningwither.honeyfunmods.blocks.machines.energy.container;

import com.lyghtningwither.honeyfunmods.blocks.machines.energy.tileentity.TileEntityLightningGenerator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerLightningGenerator extends Container
{
	private final TileEntityLightningGenerator tileentity;
	private int energy, strikeTime;
	
	public ContainerLightningGenerator(InventoryPlayer player, TileEntityLightningGenerator tileentity) 
	{
		this.tileentity = tileentity;
		
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
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return this.tileentity.isUsableByPlayer(playerIn);
	}
	
	@Override
	public void updateProgressBar(int id, int data) 
	{
		this.tileentity.setField(id, data);
	}
	
	@Override
	public void detectAndSendChanges() 
	{
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.listeners.size(); ++i) 
		{
			IContainerListener listener = (IContainerListener)this.listeners.get(i);
			if(this.energy != this.tileentity.getField(0)) listener.sendWindowProperty(this, 0, this.tileentity.getField(0));
			if(this.strikeTime != this.tileentity.getField(1)) listener.sendWindowProperty(this, 1, this.tileentity.getField(1));
		}
		
		this.energy = this.tileentity.getField(0);
		this.strikeTime = this.tileentity.getField(1);
	}
}