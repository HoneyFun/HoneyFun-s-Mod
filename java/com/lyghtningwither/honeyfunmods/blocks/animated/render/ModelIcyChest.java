package com.lyghtningwither.honeyfunmods.blocks.animated.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelIcyChest extends ModelBase {
    public ModelRenderer Handle;
    public ModelRenderer Lid;
    public ModelRenderer Storage;

    public ModelIcyChest() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Lid = new ModelRenderer(this, 0, 0);
        this.Lid.setRotationPoint(1.0F, 7.0F, 15.0F);
        this.Lid.addBox(0.0F, -5.0F, -14.0F, 14, 5, 14, 0.0F);
        this.Handle = new ModelRenderer(this, 0, 0);
        this.Handle.setRotationPoint(8.0F, 7.0F, 15.0F);
        this.Handle.addBox(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
        this.Storage = new ModelRenderer(this, 0, 19);
        this.Storage.setRotationPoint(1.0F, 6.0F, 1.0F);
        this.Storage.addBox(0.0F, 0.0F, 0.0F, 14, 10, 14, 0.0F);
    }

    public void renderAll() {
    	
    	this.Handle.rotateAngleX = this.Lid.rotateAngleX;
    	this.Lid.render(.0625f);
    	this.Handle.render(.0625f);
    	this.Storage.render(.0625f);
    }
}
