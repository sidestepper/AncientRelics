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

public class BlockAshleafPlanks extends Block
{
	public BlockAshleafPlanks()
	{
		super(Material.wood);
		
		setBlockName("AshleafPlanks");
		setBlockTextureName(Utilities.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(Block.soundTypeWood);
		
		setHardness(1.5F);
	}
	
	@Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(AncientRelics.Block_AshleafPlanks));
        return ret;
    }
}
