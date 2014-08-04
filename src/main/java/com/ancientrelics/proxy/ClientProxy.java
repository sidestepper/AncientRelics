package com.ancientrelics.proxy;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.ancientrelics.AncientRelics;
import com.ancientrelics.renderer.ItemRenderCrystalEnergizer;
import com.ancientrelics.renderer.RenderCrystalEnergizer;
import com.ancientrelics.tileentity.TileEntityCrystalEnergizer;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	public void registerRenderThings() {
		// CrystalEnergizer
		TileEntitySpecialRenderer renderer = new RenderCrystalEnergizer();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrystalEnergizer.class, renderer);
		
		MinecraftForgeClient.registerItemRenderer(
				Item.getItemFromBlock(AncientRelics.Block_CrystalEnergizer),
				new ItemRenderCrystalEnergizer(renderer, new TileEntityCrystalEnergizer()
			)
		);
		
	}
	
	public void registerTileEntitySpecialRenderer() {
		
	}
}
