package com.lyghtningwither.honeyfunmods.items.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelObsidianArmor - LyghtningWither
 * Created using Tabula 7.0.0
 */
public class ModelCrown extends ModelBiped {
    public ModelRenderer CrownBase;
    public ModelRenderer Stud1;
    public ModelRenderer Stud2;
    public ModelRenderer Stud3;
    public ModelRenderer Stud4;
    public ModelRenderer Stud5;
    public ModelRenderer Stud6;
    public ModelRenderer Stud7;
    public ModelRenderer Stud8;
    public ModelRenderer Stud9;

    public ModelCrown() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Stud4 = new ModelRenderer(this, 80, 0);
        this.Stud4.setRotationPoint(-1.0F, -10.0F, 3.0F);
        this.Stud4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
        this.Stud9 = new ModelRenderer(this, 70, 0);
        this.Stud9.setRotationPoint(-4.0F, -10.0F, 3.0F);
        this.Stud9.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.Stud3 = new ModelRenderer(this, 80, 0);
        this.Stud3.setRotationPoint(-1.0F, -10.0F, -4.0F);
        this.Stud3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
        this.Stud5 = new ModelRenderer(this, 80, 10);
        this.Stud5.setRotationPoint(-1.0F, -10.0F, -1.0F);
        this.Stud5.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.Stud2 = new ModelRenderer(this, 80, 0);
        this.Stud2.setRotationPoint(-4.0F, -10.0F, -1.0F);
        this.Stud2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
        this.Stud6 = new ModelRenderer(this, 70, 0);
        this.Stud6.setRotationPoint(3.0F, -10.0F, 3.0F);
        this.Stud6.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.Stud8 = new ModelRenderer(this, 70, 0);
        this.Stud8.setRotationPoint(-4.0F, -10.0F, -4.0F);
        this.Stud8.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.CrownBase = new ModelRenderer(this, 84, 0);
        this.CrownBase.setRotationPoint(-4.0F, -9.0F, -4.0F);
        this.CrownBase.addBox(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F);
        this.Stud1 = new ModelRenderer(this, 80, 0);
        this.Stud1.setRotationPoint(3.0F, -10.0F, -1.0F);
        this.Stud1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
        this.Stud7 = new ModelRenderer(this, 70, 0);
        this.Stud7.setRotationPoint(3.0F, -10.0F, -4.0F);
        this.Stud7.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        
        this.bipedHead.addChild(CrownBase);
        this.bipedHead.addChild(Stud1);
        this.bipedHead.addChild(Stud2);
        this.bipedHead.addChild(Stud3);
        this.bipedHead.addChild(Stud4);
        this.bipedHead.addChild(Stud5);
        this.bipedHead.addChild(Stud6);
        this.bipedHead.addChild(Stud7);
        this.bipedHead.addChild(Stud8);
        this.bipedHead.addChild(Stud9);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        
    	super.render(entity, f, f1, f2, f3, f4, f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
