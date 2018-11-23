package com.lyghtningwither.honeyfunmods.blocks.machines.miner.tileentity;

import static com.lyghtningwither.honeyfunmods.util.helpers.NBTHelper.toNBT;

import com.lyghtningwither.honeyfunmods.blocks.machines.miner.BlockMiner;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileEntityMiner extends TileEntity implements ITickable {

	public int x, y, z, tick, burningTimeInTicks;
	boolean initalized = false;
	public boolean isOn;

	@Override
	public void update() {
		
		if (!initalized)
			init();
		
		if(this.world.getBlockState(this.pos).getValue(BlockMiner.MINING).booleanValue()) {
			
			tick++;
			burningTimeInTicks++;
			
			if(tick >= 200) {
				
				tick = 0;
				
				if(y > 4) {
					
					execute();
				}
			}
			
			if(burningTimeInTicks >= 16000) {
				
				this.world.setBlockState(this.pos, this.world.getBlockState(this.pos).withProperty(BlockMiner.MINING, false));
				this.burningTimeInTicks = 0;
			}
		}
	}

	private void execute() {
		
		int index = 0;
		Block[] blocksRemoved = new Block[9];
		
		for (int x = 0; x < 3; x++) {
			
			for (int z = 0; z < 3; z++) {
				
				BlockPos posToBreak = new BlockPos(this.x + x, this.y, this.z + z);
				blocksRemoved[index] = this.world.getBlockState(posToBreak).getBlock();
				world.destroyBlock(posToBreak, false);
				index++;
			}
		}

		for (Block block : blocksRemoved) {
			
			if (!world.isRemote) InventoryHelper.spawnItemStack(this.world, this.x + 1, this.pos.getY() + 2, this.z + 1, new ItemStack(block.getItemDropped(block.getDefaultState(), world.rand, 0)));
		}
		
		this.y--;
	}

	private void init() {
		
		initalized = true;
		x = this.pos.getX() - 1;
		y = this.pos.getY() - 1;
		z = this.pos.getZ() - 1;
		tick = 0;
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		
		compound.setTag("initvalues", toNBT(this));
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		
		super.readFromNBT(compound);
		NBTTagCompound initvalues = compound.getCompoundTag("initvalues");
		
		if(initvalues != null) {
			
			this.x = initvalues.getInteger("x");
			this.y = initvalues.getInteger("y");
			this.z = initvalues.getInteger("z");
			this.tick = initvalues.getInteger("tick");
			this.isOn = initvalues.getBoolean("isOn");
			this.burningTimeInTicks = initvalues.getInteger("burningTime");
			this.initalized = true;
			return;
		}
		
		this.initalized = false;
	}
}
