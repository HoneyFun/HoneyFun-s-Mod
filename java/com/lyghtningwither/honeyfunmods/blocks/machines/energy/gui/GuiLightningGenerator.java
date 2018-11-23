package com.lyghtningwither.honeyfunmods.blocks.machines.energy.gui;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.container.ContainerLightningGenerator;
import com.lyghtningwither.honeyfunmods.blocks.machines.energy.tileentity.TileEntityLightningGenerator;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiLightningGenerator extends GuiContainer
{
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lightning_generator.png");
	private final InventoryPlayer player;
	private final TileEntityLightningGenerator tileentity;
	
	public GuiLightningGenerator(InventoryPlayer player, TileEntityLightningGenerator tileentity) 
	{
		super(new ContainerLightningGenerator(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		
		this.fontRenderer.drawString("Lightning Generator", (this.xSize / 2 - this.fontRenderer.getStringWidth("Lightning Generator") / 2) -5, 6, 4210752);
		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 7, this.ySize - 96 + 2, 4210752);
		this.fontRenderer.drawString(Integer.toString(this.tileentity.getEnergyStored()), 60, 40, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		int l = this.getCookProgressScaled(24);
		this.drawTexturedModalRect(this.guiLeft + 113, this.guiTop + 32, 176, 14, (l + 1) / 3, 16);
		
		int k = this.getEnergyStoredScaled(73);
		this.drawTexturedModalRect(this.guiLeft + 151, this.guiTop + 25, 176, 31, 18, (37 - k) / 10);
	}
	
	private int getEnergyStoredScaled(int pixels)
	{
		int i = this.tileentity.getEnergyStored();
		int j = this.tileentity.getMaxEnergyStored();
		return i != 0 && j != 0 ? i * pixels / j : 0; 
	}
	
	private int getCookProgressScaled(int pixels)
	{
		int i = this.tileentity.strikeTime;
		return i != 0 ? i * pixels / 25 : 0;
	}
}