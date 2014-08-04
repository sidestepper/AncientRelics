package com.ancientrelics.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.ancientrelics.Utilities;

public class ItemCrystallineIngot extends Item
{
	public ItemCrystallineIngot()
	{
		super();
		setUnlocalizedName("CrystallineIngot");
		setTextureName(Utilities.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
