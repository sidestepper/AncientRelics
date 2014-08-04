package com.ancientrelics.renderer;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderCrystalEnergizer implements IItemRenderer {

	private TileEntitySpecialRenderer renderer;
	private TileEntity entity;
	
	public ItemRenderCrystalEnergizer(TileEntitySpecialRenderer renderer, TileEntity entity) {
		this.entity = entity;
		this.renderer = renderer;
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		if(type == IItemRenderer.ItemRenderType.ENTITY)
			GL11.glTranslatef(-0.5F, 0.25F, -0.5F);
		
		this.renderer.renderTileEntityAt(this.entity, 0.0D, -0.25D, 0.0D, 0.0F);
	}

}
