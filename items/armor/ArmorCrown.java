package com.lyghtningwither.honeyfunmods.items.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmorCrown extends ArmorBase {

	public ArmorCrown(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		
		super(name, materialIn, renderIndexIn, equipmentSlotIn);
	}
	
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
		
		if(itemStack != ItemStack.EMPTY) {
			
			if(itemStack.getItem() instanceof ItemArmor) {
				
				ModelCrown model = new ModelCrown();
				
				model.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				model.isChild = _default.isChild;
				model.isRiding = _default.isRiding;
				model.isSneak = _default.isSneak;
				model.rightArmPose = _default.rightArmPose;
				model.leftArmPose = _default.leftArmPose;
				
				return model;
			}
		}
		
		return null;
	}
}
