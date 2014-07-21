package com.ancientrelics.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ancientrelics.AncientRelics;
import com.ancientrelics.Utilities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class BlockAshleafLog extends BlockLog
{
	public static final String[] ar_ashleaf = new String[] {"ashleaf"};
    
	public BlockAshleafLog()
	{
		setBlockName("AshleafLog");
		setBlockTextureName(Utilities.MODID + ":log");
	}
	
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
    	p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.field_150167_a = new IIcon[ar_ashleaf.length];
        this.field_150166_b = new IIcon[ar_ashleaf.length];

        for (int i = 0; i < this.field_150167_a.length; ++i)
        {
            this.field_150167_a[i] = p_149651_1_.registerIcon(this.getTextureName() + "_" + ar_ashleaf[i]);
            this.field_150166_b[i] = p_149651_1_.registerIcon(this.getTextureName() + "_" + ar_ashleaf[i] + "_top");
        }
    }
}
