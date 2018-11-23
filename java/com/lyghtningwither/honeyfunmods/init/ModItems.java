package com.lyghtningwither.honeyfunmods.init;

import java.util.ArrayList;
import java.util.List;

import com.lyghtningwither.honeyfunmods.items.ItemBase;
import com.lyghtningwither.honeyfunmods.items.armor.ArmorBase;
import com.lyghtningwither.honeyfunmods.items.armor.ArmorCrown;
import com.lyghtningwither.honeyfunmods.items.battery.ItemSilverGoldBattery;
import com.lyghtningwither.honeyfunmods.items.food.ItemCustomFood;
import com.lyghtningwither.honeyfunmods.items.food.ItemTomato;
import com.lyghtningwither.honeyfunmods.items.tools.ExplosionStaff;
import com.lyghtningwither.honeyfunmods.items.tools.FireExtinguisher;
import com.lyghtningwither.honeyfunmods.items.tools.LightningStaff;
import com.lyghtningwither.honeyfunmods.items.tools.ToolAxe;
import com.lyghtningwither.honeyfunmods.items.tools.ToolHoe;
import com.lyghtningwither.honeyfunmods.items.tools.ToolPickaxe;
import com.lyghtningwither.honeyfunmods.items.tools.ToolShovel;
import com.lyghtningwither.honeyfunmods.items.tools.ToolSword;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {
	
	//List for the items to be registered
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	// Materials
	public static final ToolMaterial TOOL_OBSIDIAN = EnumHelper.addToolMaterial("tool_obsidian", 4, 1584, 5.5F, 10, 17);
	public static final ArmorMaterial ARMOR_OBSIDIAN = EnumHelper.addArmorMaterial("armor_obsidian", Reference.MOD_ID + ":obsidian", 150, new int[]{4, 5, 9, 2}, 22, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10.0F);
	public static final ArmorMaterial CROWN_MAT = EnumHelper.addArmorMaterial("crown", Reference.MOD_ID + ":crown", 150, new int[] {0,0,0,0}, 22, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1);
	
	// Items
	public static final Item OPAL = new ItemBase("opal");
	public static final Item FIERY_OPAL = new ItemBase("fiery_opal");
	public static final Item ENDER_OPAL = new ItemBase("ender_opal");
	public static final Item ICY_OPAL = new ItemBase("icy_opal");
	public static final Item COMPRESSED_OBSIDIAN = new ItemBase("compressed_obsidian");
	public static final Item SILVER_INGOT = new ItemBase("silver_ingot");
	public static final Item SILICON_ROD = new ItemBase("silicon_rod");
	
	// Tools
	public static final Item OBSIDIAN_AXE = new ToolAxe("obsidian_axe", TOOL_OBSIDIAN);
	public static final Item OBSIDIAN_HOE = new ToolHoe("obsidian_hoe", TOOL_OBSIDIAN);
	public static final Item OBSIDIAN_PICKAXE = new ToolPickaxe("obsidian_pickaxe", TOOL_OBSIDIAN);
	public static final Item OBSIDIAN_SHOVEL = new ToolShovel("obsidian_shovel", TOOL_OBSIDIAN);
	public static final Item OBSIDIAN_SWORD = new ToolSword("obsidian_sword", TOOL_OBSIDIAN);
	
	// Armor
	public static final Item OBSIDIAN_HELMET = new ArmorBase("obsidian_helmet", ARMOR_OBSIDIAN, 1, EntityEquipmentSlot.HEAD);
	public static final Item OBSIDIAN_CHESTPLATE = new ArmorBase("obsidian_chestplate", ARMOR_OBSIDIAN, 1, EntityEquipmentSlot.CHEST);
	public static final Item OBSIDIAN_LEGGINGS = new ArmorBase("obsidian_leggings", ARMOR_OBSIDIAN, 2, EntityEquipmentSlot.LEGS);
	public static final Item OBSIDIAN_BOOTS = new ArmorBase("obsidian_boots", ARMOR_OBSIDIAN, 1, EntityEquipmentSlot.FEET);
	public static final Item CROWN = (ArmorBase) new ArmorCrown("crown", CROWN_MAT, 1, EntityEquipmentSlot.HEAD);
	
	// Food
	public static final Item TOMATO_SOUP = new ItemCustomFood("tomato_soup", 5, 5.75f, false);
	public static final Item TOMATO = new ItemTomato("tomato", 2, 3, false);
	//public static final Item PEPPERONI = new ItemCustomFood("pepperoni", 1, 3.879854f, true);
	//public static final Item PIZZA = new ItemPizza("pizza", 7, 10, true);
	//public static final Item RAMEN = new ItemCustomFood("ramen_noodles", 10, 2, false);
	//public static final Item NOODLES = new ItemNoodles("noodles", 1, 0, false);
	
	// Staffs and Extra Tools
	public static final Item EXPLOSION_STAFF = new ExplosionStaff("explosion_staff");
	public static final Item LIGHTNING_STAFF = new LightningStaff("lightning_staff");
	public static final Item FIRE_EXTINGUISHER = new FireExtinguisher("fire_extinguisher");
	
	//Batteries
	public static final Item SILVER_GOLD_BATTERY = new ItemSilverGoldBattery();
}
