package com.lyghtningwither.honeyfunmods.blocks.machines.tntminer.tileentity;

import com.lyghtningwither.honeyfunmods.changes.TNTMinerSpawnTNTEvent;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.MinecraftForge;

public class TileEntityTNTMiner extends TileEntity implements ITickable, ISidedInventory, IInventory {
	
	private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);
	int[] inv = new int[1];
	private String customName;
	private boolean powered;
	private int tick;
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		
		super.writeToNBT(compound);
		ItemStackHelper.saveAllItems(compound, this.inventory);
		
		if(this.hasCustomName()) compound.setString("CustomName", this.customName);
		
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {

		super.readFromNBT(compound);
		
		this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, inventory);
		
		if(compound.hasKey("CustomName", 8)) this.setCustomName(compound.getString("CustomName"));
	}
	
	@Override
	public String getName() {
		
		return this.hasCustomName() ? this.customName : "container.tnt_miner";
	}

	@Override
	public boolean hasCustomName() {

		return this.customName != null && !this.customName.isEmpty();
	}
	
	public void setCustomName(String customName) {
		
		this.customName = customName;
	}
	
	@Override
	public ITextComponent getDisplayName() {
		
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}

	@Override
	public int getSizeInventory() {
		
		return this.inventory.size();
	}

	@Override
	public boolean isEmpty() {

		for(ItemStack stack : this.inventory) {
			
			if(!stack.isEmpty()) return false;
		}
		
		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		
		return (ItemStack) this.inventory.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		
		return ItemStackHelper.getAndSplit(this.inventory, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		
		return ItemStackHelper.getAndRemove(this.inventory, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		
		ItemStack itemstack = (ItemStack) this.inventory.get(index);
		boolean flag = !stack.isEmpty() && ItemStack.areItemsEqual(itemstack, stack);
		
		this.inventory.set(index, stack);
	}

	@Override
	public int getInventoryStackLimit() {
		
		return 256;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		
		Item item = stack.getItem();
		
		if(stack.isEmpty()) return false;
		
		if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR) {
			
			Block block = Block.getBlockFromItem(item);
			
			if(block == Blocks.TNT) return true;
		}
		
		return false;
	}

	@Override
	public int getField(int id) {
		
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		
		
	}

	@Override
	public int getFieldCount() {
		
		return 0;
	}

	@Override
	public void clear() {
		
		this.inventory.clear();
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		
		return new int[] {0};
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		
		return !itemStackIn.isEmpty() && itemStackIn.getItem() instanceof ItemBlock && Block.getBlockFromItem(itemStackIn.getItem()) == Blocks.TNT ? true : false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		
		return true;
	}

	@Override
	public void update() {
		
		if(!inventory.get(0).isEmpty()) {
		
			tick++;
		}
		
		if(tick >= 50) {
			
			if(this.world.isBlockPowered(this.pos)) {
				
				ItemStack stack = inventory.get(0);
				
				if(stack.isEmpty()) return;
				
				if(!this.world.isRemote) {
				
					EntityTNTPrimed tnt = new EntityTNTPrimed(world, (double) this.pos.getX(), (double) this.pos.getY() - 1, (double) this.pos.getZ(), (EntityLivingBase) null);
					MinecraftForge.EVENT_BUS.post(new TNTMinerSpawnTNTEvent(tnt, this.world));
					this.world.spawnEntity(tnt);
					stack.shrink(1);
					this.world.playSound(this.pos.getX(), this.pos.getY(), this.pos.getZ(), SoundEvents.ENTITY_FIREWORK_LAUNCH, SoundCategory.BLOCKS, 100, 100, true);
					tick = 0;
				}
			}
		}
	}
}