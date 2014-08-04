package com.ancientrelics.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.ancientrelics.Utilities;

public class ItemInfusedCrystallineBlend extends Item
{
	public ItemInfusedCrystallineBlend()
	{
		super();
		setUnlocalizedName("InfusedCrystallineBlend");
		setTextureName(Utilities.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
