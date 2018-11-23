package com.lyghtningwither.honeyfunmods.util.helpers;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.lyghtningwither.honeyfunmods.blocks.machines.miner.tileentity.TileEntityMiner;
import com.lyghtningwither.honeyfunmods.blocks.machines.tntminer.tileentity.TileEntityTNTMiner;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class NBTHelper {

	/** 
	 * 
	 * 
	 * <p>Writes either an <code>ItemStack</code> or a <code>TileEntityMiner</code> to NBT.</p>
	 * @return {@link NBTTagCompound}
	 * **/
	public static NBTTagCompound toNBT (Object o) {
		
		if(o instanceof ItemStack)
			
			return writeItemStack((ItemStack) o);
		if(o instanceof TileEntityMiner) {
			
			return writeMiner((TileEntityMiner) o);
		}
		
		return null;
	}
	
	private static NBTTagCompound writeMiner (TileEntityMiner o) {
		
		NBTTagCompound compound = new NBTTagCompound();
		compound.setInteger("y", o.y);
		compound.setInteger("x", o.x);
		compound.setInteger("z", o.z);
		compound.setInteger("tick", o.tick);
		compound.setBoolean("isOn", o.isOn);
		compound.setInteger("burningTime", o.burningTimeInTicks);
		return compound;
	}

	private static NBTTagCompound writeItemStack (ItemStack i) {
		
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("count", i.getCount());
		nbt.setString("item", i.getItem().getRegistryName().toString());
		nbt.setByte("type", (byte) 0);
		return nbt;
	}
	
	@Nullable
	public static Object fromNBT (@Nonnull NBTTagCompound compound) {
		
		switch (compound.getByte("type")) {
		
		case 0:
			
			return readItemStack(compound);
		default:
			
			return null;
		}
	}
	
	private static ItemStack readItemStack (NBTTagCompound compound) {
		
		Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(compound.getString("item")));
		int count = compound.getInteger("count");
		return new ItemStack(item, count);
	}

}