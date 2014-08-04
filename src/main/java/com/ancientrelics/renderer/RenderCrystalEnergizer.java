package com.ancientrelics.renderer;

import org.lwjgl.opengl.GL11;

import com.ancientrelics.Utilities;
import com.ancientrelics.model.ModelCrystalEnergizer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderCrystalEnergizer extends TileEntitySpecialRenderer {

	public static final ResourceLocation texture =
			new ResourceLocation(Utilities.MODID + ":" + "textures/models/CrystalEnergizer.png");
	
	private ModelCrystalEnergizer model;
	
	public RenderCrystalEnergizer() {
		this.model = new ModelCrystalEnergizer();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		
			GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
			GL11.glRotatef(180F, 0F, 0F, 1F);
			
			this.bindTexture(texture);
			
			GL11.glPushMatrix();
				this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
			
		GL11.glPopMatrix();
	}

}
