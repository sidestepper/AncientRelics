package com.ancientrelics;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
//import net.minecraftforge.common.BiomeDictionary;
//import static net.minecraftforge.common.BiomeDictionary.Type;

public class Utilities
{
	public static final String MODID = "ancientrelics";
	public static final String VERSION = "0.0.1";
	
	public static void RegisterBlock(Block block)
	{
		GameRegistry.registerBlock(block, "ar_" + block.getUnlocalizedName().substring(5));
	}
	
	public static void RegisterItem(Item item)
	{
		GameRegistry.registerItem(item,  "ar_" + item.getUnlocalizedName().substring(5));
	}
}
