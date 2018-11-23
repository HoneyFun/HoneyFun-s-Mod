package com.lyghtningwither.honeyfunmods.blocks.machines.tntminer.gui;

import com.lyghtningwither.honeyfunmods.blocks.machines.tntminer.tileentity.TileEntityTNTMiner;
import com.lyghtningwither.honeyfunmods.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GUITNTMiner extends GuiContainer {

	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/tnt_miner.png");
	private final InventoryPlayer player;
	private final TileEntityTNTMiner tileentity;
	
	public GUITNTMiner(InventoryPlayer player, TileEntityTNTMiner tileentity) {
		
		super(new ContainerTNTMiner(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		
		String tileName = this.tileentity.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2), 8, 4210752);
		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 122, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}
