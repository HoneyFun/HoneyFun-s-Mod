package com.lyghtningwither.honeyfunmods.blocks.machines.energy.gui;

import com.lyghtningwither.honeyfunmods.blocks.machines.energy.container.ContainerElectricCompressor;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.tileentity.TileEntityCompressor;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiElectricCompressor extends GuiContainer {
	
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/electric_compressor.png");
	private final InventoryPlayer player;
	private final TileEntityCompressor tileentity;
	
	public GuiElectricCompressor(InventoryPlayer player, TileEntityCompressor tileentity) 
	{
		super(new ContainerElectricCompressor(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		String tileName = this.tileentity.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2) -5, 6, 4210752);
		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 7, this.ySize - 96 + 2, 4210752);
		this.fontRenderer.drawString(Integer.toString(this.tileentity.getEnergyStored()), 80, 70, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		int l = this.getCookProgressScaled(22);
		this.drawTexturedModalRect(this.guiLeft + 80, this.guiTop + 35, 176, 14, l + 1, 16);
		
		int k = this.getEnergyStoredScaled(37);
		this.drawTexturedModalRect(this.guiLeft + 55, this.guiTop + 37, 176, 31, 18, 37 - k);
	}
	
	private int getCookProgressScaled(int pixels)
	{
		int i = this.tileentity.cookTime;
		return i != 0 ? i * pixels / 100 : 0;
	}
	
	private int getEnergyStoredScaled(int pixels)
	{
		int i = this.tileentity.getEnergyStored();
		int j = this.tileentity.getMaxEnergyStored();
		return i != 0 && j != 0 ? i * pixels / j : 0; 
	}
}
