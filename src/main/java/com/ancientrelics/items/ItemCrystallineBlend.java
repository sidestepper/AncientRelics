package com.ancientrelics.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.ancientrelics.Utilities;

public class ItemCrystallineBlend extends Item
{
	public ItemCrystallineBlend()
	{
		super();
		setUnlocalizedName("CrystallineBlend");
		setTextureName(Utilities.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
