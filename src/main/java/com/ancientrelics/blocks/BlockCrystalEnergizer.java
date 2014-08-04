package com.ancientrelics.blocks;

import com.ancientrelics.Utilities;
import com.ancientrelics.tileentity.TileEntityCrystalEnergizer;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCrystalEnergizer extends BlockContainer {

	public BlockCrystalEnergizer() {
		super(Material.rock);
		
		this.setBlockName("CrystalEnergizer");
		this.setBlockTextureName(Utilities.MODID + ":" + getUnlocalizedName().substring(5));
		
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		
		this.setBlockBounds(0.1875F, 0F, 0.1875F, 0.8125F, 1.4375F, 0.8125F);
		
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	public int getRenderType() {
		// See source->RenderBlock
		// Uses large case for type of render - we want to hit the default case
		return -1;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int var2) {
		
		return new TileEntityCrystalEnergizer();
	}

}
