package com.lyghtningwither.honeyfunmods.world.gen;

import java.util.Random;

import javax.annotation.Nullable;

import com.lyghtningwither.honeyfunmods.Main;
import com.lyghtningwither.honeyfunmods.util.Reference;
import com.lyghtningwither.honeyfunmods.util.handlers.LootTableHandler;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class StructureHub extends WorldGenStructure {

	public StructureHub(String name) {
		
		super(name);
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		
		this.generateStructure(worldIn, position);
		return true;
	}
	
	public static void generateStructure(World world, BlockPos pos) {
		
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager manager = worldServer.getStructureTemplateManager();
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, structureName);
		Template template = manager.get(mcServer, location);
		
		if(template != null) {
			
			IBlockState state = world.getBlockState(pos);
			world.notifyBlockUpdate(pos, state, state, 3);
			template.addBlocksToWorldChunk(world, pos, settings);
			BlockPos chestPos = new BlockPos(pos.getX() + 2, pos.getY() + 1, pos.getZ() + 3);
			
			generateChest(world, new Random(world.getSeed()), chestPos, LootTableHandler.HUB, null);
		}
	}
	
	protected static boolean generateChest(World p_191080_1_, Random p_191080_3_, BlockPos p_191080_4_, ResourceLocation p_191080_5_, @Nullable IBlockState p_191080_6_)
    {
        
        if (p_191080_6_ == null)
        {
            p_191080_6_ = Blocks.CHEST.correctFacing(p_191080_1_, p_191080_4_, Blocks.CHEST.getDefaultState());
        }

        p_191080_1_.setBlockState(p_191080_4_, p_191080_6_, 2);
        TileEntity tileentity = p_191080_1_.getTileEntity(p_191080_4_);

        if (tileentity instanceof TileEntityChest)
        {
            ((TileEntityChest)tileentity).setLootTable(p_191080_5_, p_191080_3_.nextLong());
        }

        return true;
    }
}
