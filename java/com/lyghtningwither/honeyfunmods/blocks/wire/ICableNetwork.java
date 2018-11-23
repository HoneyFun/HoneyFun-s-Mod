package com.lyghtningwither.honeyfunmods.blocks.wire;

import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.lyghtningwither.honeyfunmods.blocks.wire.IConnection.Type;

public interface ICableNetwork {
	
	public World getWorld();

	public List<ICable> getCables();

	public ICable getMaster();

	public void setMaster(ICable master);

	public void addSlave(ICable slave);

	public List<ICable> getSlaves();

	public IConnection[] getConnections();

	public IConnection[] getConnectionsofType(Type t);

	public int getTransferRate();

	public void onUpdate(IBlockState state, World world, BlockPos pos, ICable cable, BlockPos fromPos);

	public void cableBroken(World world, BlockPos pos);

	public void destroy();
	
	public void remove(ICable cable);

}
