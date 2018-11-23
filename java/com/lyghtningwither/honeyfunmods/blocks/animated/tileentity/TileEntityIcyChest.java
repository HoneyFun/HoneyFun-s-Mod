package com.lyghtningwither.honeyfunmods.blocks.animated.tileentity;

import com.lyghtningwither.honeyfunmods.blocks.animated.container.ContainerIcyChest;
import com.lyghtningwither.honeyfunmods.util.Reference;
import com.lyghtningwither.honeyfunmods.util.handlers.LootTableHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;

public class TileEntityIcyChest extends TileEntityLockableLoot implements ITickable {
	
	private NonNullList<ItemStack> itemHandler = NonNullList.<ItemStack>withSize(72, ItemStack.EMPTY);
	public int numPlayersUsing, ticksSinceSync;
	public float lidAngle, prevLidAngle;
	private boolean lootSet;
	
	public int getSizeInventory() {
		
		return 72;
	}
	
	@Override
	public boolean isEmpty() {
		
		for(ItemStack stack : itemHandler) {
			
			if(stack.isEmpty()) return false;
		}
		
		return true;
	}
	
	@Override
	public String getName() {
		
		return this.hasCustomName() ? this.customName : "container.icy_chest";
	}
	
	@Override
	public int getInventoryStackLimit() {
		
		return 64;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		
		super.readFromNBT(compound);
		
		if(!this.checkLootAndRead(compound)) ItemStackHelper.loadAllItems(compound, itemHandler);
		if(compound.hasKey("CustomName")) this.customName = compound.getString("CustomName");
		if(compound.hasKey("LootSet")) this.lootSet = compound.getBoolean("LootSet");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		
		super.writeToNBT(compound);
		
		if(!this.checkLootAndWrite(compound)) ItemStackHelper.saveAllItems(compound, itemHandler);
		if(compound.hasKey("CustomName")) compound.setString("CustomName", this.customName);
		compound.setBoolean("LootSet", this.lootSet);
		
		return compound;
	}
	
	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		
		return new ContainerIcyChest(playerInventory, this, playerIn);
	}
	
	@Override
	public String getGuiID() {
		
		return Reference.MOD_ID + ":icy_chest";
	}
	
	@Override
	protected NonNullList<ItemStack> getItems() {
		
		return itemHandler;
	}
	
	private void init() {
		
		//this.setLootTable(LootTableHandler.ICY_CHEST, this.getWorld().rand.nextLong());
		
		//if(!this.lootSet) {
			
			//this.lootSet = true;
		//}
	}
	
	@Override
	public void update()
	{
		//this.init();
		
		if (!this.world.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync + pos.getX() + pos.getY() + pos.getZ()) % 200 == 0)
        {
            this.numPlayersUsing = 0;
            float f = 5.0F;

            for (EntityPlayer entityplayer : this.world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB((double)((float)pos.getX() - 5.0F), (double)((float)pos.getY() - 5.0F), (double)((float)pos.getZ() - 5.0F), (double)((float)(pos.getX() + 1) + 5.0F), (double)((float)(pos.getY() + 1) + 5.0F), (double)((float)(pos.getZ() + 1) + 5.0F))))
            {
                if (entityplayer.openContainer instanceof ContainerIcyChest)
                {
                    if (((ContainerIcyChest)entityplayer.openContainer).getChestInventory() == this)
                    {
                        ++this.numPlayersUsing;
                    }
                }
            }
        }
		
        this.prevLidAngle = this.lidAngle;
        float f1 = 0.1F;

        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F)
        {
            double d1 = (double)pos.getX() + 0.5D;
            double d2 = (double)pos.getZ() + 0.5D;
            this.world.playSound((EntityPlayer)null, d1, (double)pos.getY() + 0.5D, d2, SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
        }

        if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F)
        {
            float f2 = this.lidAngle;

            if (this.numPlayersUsing > 0)
            {
                this.lidAngle += 0.1F;
            }
            else
            {
                this.lidAngle -= 0.1F;
            }

            if (this.lidAngle > 1.0F)
            {
                this.lidAngle = 1.0F;
            }

            float f3 = 0.5F;

            if (this.lidAngle < 0.5F && f2 >= 0.5F)
            {
                double d3 = (double)pos.getX() + 0.5D;
                double d0 = (double)pos.getZ() + 0.5D;
                this.world.playSound((EntityPlayer)null, d3, (double)pos.getY() + 0.5D, d0, SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
            }

            if (this.lidAngle < 0.0F)
            {
                this.lidAngle = 0.0F;
            }
        }		
	}
	
	@Override
	public void openInventory(EntityPlayer player) {
		
		this.numPlayersUsing++;
		this.world.addBlockEvent(pos, this.getBlockType(), 1, this.numPlayersUsing);
		this.world.notifyNeighborsOfStateChange(pos, this.getBlockType(), false);
	}
	
	@Override
	public void closeInventory(EntityPlayer player) {
		
		this.numPlayersUsing--;
		this.world.addBlockEvent(pos, this.getBlockType(), 1, this.numPlayersUsing);
		this.world.notifyNeighborsOfStateChange(pos, this.getBlockType(), false);
	}
}