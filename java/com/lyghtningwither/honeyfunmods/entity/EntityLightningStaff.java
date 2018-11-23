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
import net.minecraft.item.EnumDyeColor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class EntityLightningStaff extends EntityFireball {

	public double accelX, accelY, accelZ;
	public EntityLivingBase shooter;
	private int lightningStrikes;
	
	public EntityLightningStaff(World worldIn) {
		
		super(worldIn);
	}
	
	public EntityLightningStaff(World worldIn, EntityPlayer playerIn, int x, int y, int z, double accelX, double accelY, double accelZ) {
		
		super(worldIn, x, y, z, accelX, accelY, accelZ);
	}
	
	public EntityLightningStaff(World worldIn, EntityPlayer playerIn, int accelX, int accelY, int accelZ) {
		
		super(worldIn, playerIn, accelX, accelY, accelZ);
	}
	
	@Override
	protected void entityInit() {
		
		this.lightningStrikes = this.world.rand.nextInt(2) + 1;
	}
	
	@Override
	protected boolean isFireballFiery() {
		
		return false;
	}

	protected void onImpact(RayTraceResult trace) {
		
		if(trace.typeOfHit == RayTraceResult.Type.BLOCK) {
			
			EntityLightningBolt lightning = new EntityLightningBolt(this.world, this.posX, this.posY, this.posZ, false);
			
			if(this.world.getBlockState(new BlockPos(posX, posY, posZ)) == Blocks.SAND.getDefaultState().withProperty(Blocks.SAND.VARIANT, BlockSand.EnumType.SAND)) {
				
				this.world.setBlockState(new BlockPos(posX, posY, posZ), Blocks.GLASS.getDefaultState());
			}
			
			if(this.world.getBlockState(new BlockPos(posX, posY, posZ)) == Blocks.SAND.getDefaultState().withProperty(Blocks.SAND.VARIANT, BlockSand.EnumType.RED_SAND)) {
				
				this.world.setBlockState(new BlockPos(posX, posY, posZ), Blocks.STAINED_GLASS.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.RED));
			}
			
			this.world.spawnEntity(lightning);
			this.setDead();
		}
		
		else if(trace.typeOfHit == RayTraceResult.Type.ENTITY) {
			
			EntityLightningBolt lightning = new EntityLightningBolt(this.world, this.posX, this.posY, this.posZ, false);
			
			this.world.spawnEntity(lightning);
			
			trace.entityHit.attackEntityFrom(DamageSource.GENERIC, this.rand.nextInt(2) + 1);
			
			this.setDead();
		}
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		
		if(compound.hasKey("ticks_existed")) this.ticksExisted = compound.getInteger("ticks_existed");
		
		if(compound.hasKey("lightning_strikes")) this.lightningStrikes = compound.getInteger("lightning_strikes");
		
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
		compound.setInteger("lightning_strikes", this.lightningStrikes);
		compound.setTag("direction", this.newDoubleNBTList(this.accelX, this.accelY, this.accelZ));
	}
}
