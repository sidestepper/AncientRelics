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
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class BlockAshleafLeaves extends BlockLeaves
{
	public static final String[][] field_150132_N = new String[][] {{"ashleaf"}, {"ashleaf_opaque"}};
    public static final String[] field_150133_O = new String[] {"ashleaf"};
    
	public BlockAshleafLeaves()
	{
		super();
		
		field_150121_P = true;
		
		setBlockName("AshleafLeaves");
		setBlockTextureName(Utilities.MODID + ":leaves");
	}
	
	// Color as it appears in inventory
    @Override
    public int getRenderColor(int p_149741_1_)
    {
        return 0xFFFFFF;
    }
    
    // Color as it appears in world
    @Override
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
    {
    	return 0xCCCCCC;
    }
    
	protected void func_150124_c(World p_150124_1_, int p_150124_2_, int p_150124_3_, int p_150124_4_, int p_150124_5_, int p_150124_6_)
    {
        if ((p_150124_5_ & 3) == 1 && p_150124_1_.rand.nextInt(p_150124_6_) == 0)
        {
            //this.dropBlockAsItem(p_150124_1_, p_150124_2_, p_150124_3_, p_150124_4_, new ItemStack(Items.apple, 1, 0));
        }
    }

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(AncientRelics.Block_AshleafSapling);
    }
	
    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return super.damageDropped(p_149692_1_) + 4;
    }

    /**
     * Get the block's damage value (for use with pick block).
     */
    public int getDamageValue(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_)
    {
        return p_149643_1_.getBlockMetadata(p_149643_2_, p_149643_3_, p_149643_4_) & 3;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.field_150129_M[this.field_150127_b][0];
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
        for (int i = 0; i < field_150132_N.length; ++i)
        {
            this.field_150129_M[i] = new IIcon[field_150132_N[i].length];

            for (int j = 0; j < field_150132_N[i].length; ++j)
            {
                this.field_150129_M[i][j] = p_149651_1_.registerIcon(this.getTextureName() + "_" + field_150132_N[i][j]);
            }
        }
    }

    public String[] func_150125_e()
    {
        return field_150133_O;
    }
}
