package com.lyghtningwither.honeyfunmods.items.tools;

import com.lyghtningwither.honeyfunmods.entity.EntityLightningStaff;
import com.lyghtningwither.honeyfunmods.items.ItemBase;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LightningStaff extends ItemBase {

	public LightningStaff(String name) {
		
		super(name);
		this.setMaxDamage(20);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		ItemStack item = playerIn.getHeldItem(handIn);
		Vec3d aim = playerIn.getLookVec();
		EntityLightningStaff entity = new EntityLightningStaff(worldIn, playerIn, 3, 3, 3);
		
		entity.setPosition(playerIn.posX + aim.x, playerIn.posY + aim.y, playerIn.posZ + aim.z);
		entity.accelerationX = aim.x * .1;
		entity.accelerationY = aim.y * .1;
		entity.accelerationZ = aim.z * .1;
		worldIn.spawnEntity(entity);
		item.damageItem(1, playerIn);
		
		if(worldIn.isRemote) return new ActionResult<ItemStack>(EnumActionResult.FAIL, item);
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, item);
	}
}
