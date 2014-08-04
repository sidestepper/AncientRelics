package com.ancientrelics.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ancientrelics.AncientRelics;
import com.ancientrelics.Utilities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class BlockHiddenArtifactDirtOre extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon _iconTop;
    
    @SideOnly(Side.CLIENT)
    private IIcon _iconSide;

    public BlockHiddenArtifactDirtOre()
    {
        super(Material.ground);
        this.setCreativeTab(CreativeTabs.tabBlock);
        
        setHardness(0.5F);
        setStepSound(soundTypeLadder);
        setBlockName("HiddenArtifactDirtOre");
        setBlockTextureName(Utilities.MODID + ":dirt_hiddenartifact");
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        if (p_149691_2_ == 2)
        {
            if (p_149691_1_ == 1)
            {
                return this._iconTop;
            }

            if (p_149691_1_ != 0)
            {
                return this._iconSide;
            }
        }

        return this.blockIcon;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_)
    {
        int i1 = p_149673_1_.getBlockMetadata(p_149673_2_, p_149673_3_, p_149673_4_);

        if (i1 == 2)
        {
            if (p_149673_5_ == 1)
            {
                return this._iconTop;
            }

            if (p_149673_5_ != 0)
            {
                Material material = p_149673_1_.getBlock(p_149673_2_, p_149673_3_ + 1, p_149673_4_).getMaterial();

                if (material == Material.snow || material == Material.craftedSnow)
                {
                    return AncientRelics.Block_HiddenArtifactGrassOre.getIcon(p_149673_1_, p_149673_2_, p_149673_3_, p_149673_4_, p_149673_5_);
                }

                Block block = p_149673_1_.getBlock(p_149673_2_, p_149673_3_ + 1, p_149673_4_);

                if (block != Blocks.dirt && block != Blocks.grass
                	&& block != AncientRelics.Block_HiddenArtifactDirtOre
                	&& block != AncientRelics.Block_HiddenArtifactGrassOre)
                {
                    return this._iconSide;
                }
            }
        }

        return this.blockIcon;
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int p_149644_1_)
    {
        if (p_149644_1_ == 1)
        {
            p_149644_1_ = 0;
        }

        return super.createStackedBlock(p_149644_1_);
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        p_149666_3_.add(new ItemStack(this, 1, 0));
        //p_149666_3_.add(new ItemStack(this, 1, 2));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        super.registerBlockIcons(p_149651_1_);
        this._iconTop = p_149651_1_.registerIcon(this.getTextureName() + "_top");
        this._iconSide = p_149651_1_.registerIcon(this.getTextureName() + "_side");
    }

    /**
     * Get the block's damage value (for use with pick block).
     */
    public int getDamageValue(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_)
    {
        int l = p_149643_1_.getBlockMetadata(p_149643_2_, p_149643_3_, p_149643_4_);

        if (l == 1)
        {
            l = 0;
        }

        return l;
    }
}
