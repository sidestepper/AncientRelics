package com.ancientrelics.blocks;

import java.util.ArrayList;
import java.util.Random;

import com.ancientrelics.AncientRelics;
import com.ancientrelics.Utilities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class BlockAncientCrystalOre extends Block
{
	public BlockAncientCrystalOre()
	{
		super(Material.rock);
		
		setBlockName("AncientCrystalOre");
		setBlockTextureName(Utilities.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(Block.soundTypeStone);
		setLightLevel(10.0F);
		setHardness(4.0F);
	}
	
	@Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        
        // Gets drop from another block
        //ItemStack dirt = new ItemStack(
        //		Item.getItemFromBlock(Blocks.dirt));
        //ret.add(dirt);
        
        int numDust = world.rand.nextInt(3) + 1;
        
        for(int i = 0; i < numDust; i++)
        {
        	ItemStack dust = new ItemStack(
        			AncientRelics.Item_AncientCrystalDust);
        
        	ret.add(dust);
        }
        
        return ret;
    }
}
