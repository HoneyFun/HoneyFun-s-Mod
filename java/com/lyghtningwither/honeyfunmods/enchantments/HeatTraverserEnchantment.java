package com.lyghtningwither.honeyfunmods.enchantments;

import com.lyghtningwither.honeyfunmods.init.EnchantmentInit;
import com.lyghtningwither.honeyfunmods.init.ModBlocks;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class HeatTraverserEnchantment extends Enchantment {

	public HeatTraverserEnchantment() {
		
		super(Rarity.VERY_RARE, EnumEnchantmentType.ARMOR_FEET, new EntityEquipmentSlot[] {EntityEquipmentSlot.FEET});
		this.setName("heat_traverser");
		this.setRegistryName("heat_traverser");
		
		EnchantmentInit.ENCHANTMENTS.add(this);
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 10 * enchantmentLevel;
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return this.getMinEnchantability(enchantmentLevel) + 10;
	}
	
	@Override
	public int getMaxLevel() {
		
		return 1;
	}
	
	@SubscribeEvent
	public static void createMagma(LivingUpdateEvent event) 
	{	
		
		EntityLivingBase living = event.getEntityLiving();
		World worldIn = living.getEntityWorld();
		int level = EnchantmentHelper.getMaxEnchantmentLevel(EnchantmentInit.HEAT_TRAVERSER, living);
		BlockPos pos = living.getPosition();
		
		if (living.onGround && level >= 1)
        {
            float f = (float)Math.min(16, 2 + level);
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(0, 0, 0);

            for (BlockPos.MutableBlockPos blockpos$mutableblockpos1 : BlockPos.getAllInBoxMutable(pos.add((double)(-f), -1.0D, (double)(-f)), pos.add((double)f, -1.0D, (double)f)))
            {
                if (blockpos$mutableblockpos1.distanceSqToCenter(living.posX, living.posY, living.posZ) <= (double)(f * f))
                {
                    blockpos$mutableblockpos.setPos(blockpos$mutableblockpos1.getX(), blockpos$mutableblockpos1.getY() + 1, blockpos$mutableblockpos1.getZ());
                    IBlockState iblockstate = worldIn.getBlockState(blockpos$mutableblockpos);

                    if (iblockstate.getMaterial() == Material.AIR)
                    {
                        IBlockState iblockstate1 = worldIn.getBlockState(blockpos$mutableblockpos1);

                        if (iblockstate1.getMaterial() == Material.LAVA && (iblockstate1.getBlock() == net.minecraft.init.Blocks.LAVA || iblockstate1.getBlock() == net.minecraft.init.Blocks.FLOWING_LAVA) && ((Integer)iblockstate1.getValue(BlockLiquid.LEVEL)).intValue() == 0 && worldIn.mayPlace(ModBlocks.BASALT, blockpos$mutableblockpos1, false, EnumFacing.DOWN, (Entity)null))
                        {
                            worldIn.setBlockState(blockpos$mutableblockpos1, ModBlocks.BASALT.getDefaultState());
                            worldIn.scheduleUpdate(blockpos$mutableblockpos1.toImmutable(), ModBlocks.BASALT, MathHelper.getInt(living.getRNG(), 60, 120));
                        }
                    }
                }
            }
        }
	}

}
