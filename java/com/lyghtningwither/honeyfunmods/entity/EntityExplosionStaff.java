package com.lyghtningwither.honeyfunmods.entity;

import com.lyghtningwither.honeyfunmods.world.ExplosionNoShooterDamage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityExplosionStaff extends EntityLargeFireball {
	
	public EntityExplosionStaff(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ, int explosionPower) {
		
		super(worldIn, x, y, z, accelX, accelY, accelZ);
		this.explosionPower = explosionPower;
	}
	
	public EntityExplosionStaff(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ, int power) {
		
		super(worldIn, shooter, accelX, accelY, accelZ);
		this.explosionPower = power;
	}
	
	public EntityExplosionStaff(World worldIn) {
		
		super(worldIn);
	}

	@Override
	protected void entityInit() {}
	
	@Override
	public boolean isBurning() {
		
		return false;
	}
	
	@Override
	public void onUpdate() {
		
		super.onUpdate();
		
		if(this.isInWater()) {
			
			this.world.createExplosion(this, posX, posY, posZ, 3, true);
			this.setDead();
		}
	}
	
	@Override
	protected void onImpact(RayTraceResult result) {
		
		if (!this.world.isRemote) {
			
			this.world.createExplosion(this.shootingEntity, posX, posY, posZ, this.explosionPower, true);
            
            this.setDead();
        }
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		
		super.readEntityFromNBT(compound);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		
		super.writeEntityToNBT(compound);
	}
}
