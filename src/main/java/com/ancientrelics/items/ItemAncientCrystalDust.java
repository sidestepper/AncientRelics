package com.ancientrelics.items;

import com.ancientrelics.Utilities;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemAncientCrystalDust extends Item
{
	public ItemAncientCrystalDust()
	{
		super();
		setUnlocalizedName("AncientCrystalDust");
		setTextureName(Utilities.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
