package com.lyghtningwither.honeyfunmods.entity;

import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class EntityFireExtinguisher extends EntityFireball {

	public double accelX, accelY, accelZ;
	public EntityLivingBase shooter;
	private int lightningStrikes;
	
	public EntityFireExtinguisher(World worldIn) {
		
		super(worldIn);
	}
	
	public EntityFireExtinguisher(World worldIn, EntityPlayer playerIn, int x, int y, int z, double accelX, double accelY, double accelZ) {
		
		super(worldIn, x, y, z, accelX, accelY, accelZ);
	}
	
	public EntityFireExtinguisher(World worldIn, EntityPlayer playerIn, int accelX, int accelY, int accelZ) {
		
		super(worldIn, playerIn, accelX, accelY, accelZ);
	}
	
	@Override
	protected void entityInit() {
		
		
	}
	
	@Override
	protected boolean isFireballFiery() {
		
		return false;
	}
	
	@Override
	protected EnumParticleTypes getParticleType() {
		
		return EnumParticleTypes.WATER_SPLASH;
	}

	protected void onImpact(RayTraceResult trace) {
		
		if(trace.typeOfHit == RayTraceResult.Type.BLOCK) {
			
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			
		    for (int i = -2; i < 2; i++){
		    	
		    	for (int j = -2; j < 2; j++){
		    	
		    		for (int k = -2; k < 2; k++) {
		        	
		    			BlockPos pos = new BlockPos(x + i, y + j, z + k);
		    			
		    			if(this.world.getBlockState(pos).getBlock() == Blocks.FIRE) this.world.setBlockToAir(pos);
		    		}
		    	}
		    }
			
		    this.world.playSound(this.posX, this.posY, this.posZ, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 100, 100, true);
			this.setDead();
		}
		
		else if(trace.typeOfHit == RayTraceResult.Type.ENTITY) {
			
			trace.entityHit.extinguish();
			this.setDead();
		}
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		
		if(compound.hasKey("ticks_existed")) this.ticksExisted = compound.getInteger("ticks_existed");
		
		if(compound.hasKey("direction")) {
			
			NBTTagList list = compound.getTagList("direction", 6);
			
			this.accelX = list.getDoubleAt(0);
			this.accelY = list.getDoubleAt(1);
			this.accelZ = list.getDoubleAt(2);
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		
		compound.setInteger("ticks_existed", this.ticksExisted);
		compound.setTag("direction", this.newDoubleNBTList(this.accelX, this.accelY, this.accelZ));
	}
}
