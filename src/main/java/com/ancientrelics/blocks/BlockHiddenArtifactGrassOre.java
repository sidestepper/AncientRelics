package com.ancientrelics.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ancientrelics.AncientRelics;
import com.ancientrelics.Utilities;

public class BlockHiddenArtifactGrassOre extends Block implements IGrowable
{
    private static final Logger logger = LogManager.getLogger();
    
    @SideOnly(Side.CLIENT)
    private IIcon _iconTop;
    
    @SideOnly(Side.CLIENT)
    private IIcon _iconSideSnowed;
    
    @SideOnly(Side.CLIENT)
    private IIcon _iconSide;
    
    @SideOnly(Side.CLIENT)
    private IIcon _iconSideOverlay;
    
    //private static final String __OBFID = "CL_00000251";

    public BlockHiddenArtifactGrassOre()
    {
        super(Material.grass);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
        
        // TODO
        // set texture name
        this.setHardness(0.5F);
        this.setStepSound(soundTypeLadder);
        setBlockName("HiddenArtifactGrassOre");
        setBlockTextureName(Utilities.MODID + ":dirt_hiddenartifact");
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this._iconTop : (p_149691_1_ == 0 ? _iconSide : this.blockIcon);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
        if (!p_149674_1_.isRemote)
        {
            if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) < 4 && p_149674_1_.getBlockLightOpacity(p_149674_2_, p_149674_3_ + 1, p_149674_4_) > 2)
            {
                p_149674_1_.setBlock(p_149674_2_, p_149674_3_, p_149674_4_, AncientRelics.Block_HiddenArtifactDirtOre);
            }
            else if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
                    int j1 = p_149674_3_ + p_149674_5_.nextInt(5) - 3;
                    int k1 = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
                    Block block = p_149674_1_.getBlock(i1, j1 + 1, k1);

                    if (
                    	p_149674_1_.getBlock(i1, j1, k1) == AncientRelics.Block_HiddenArtifactDirtOre
                    	&& p_149674_1_.getBlockMetadata(i1, j1, k1) == 0
                    	&& p_149674_1_.getBlockLightValue(i1, j1 + 1, k1) >= 4
                    	&& p_149674_1_.getBlockLightOpacity(i1, j1 + 1, k1) <= 2 )
                    {
                        p_149674_1_.setBlock(i1, j1, k1, AncientRelics.Block_HiddenArtifactGrassOre);
                    }
                }
            }
        }
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
    	// TODO: Add stack of possible ancient relic pieces
        return Blocks.dirt.getItemDropped(0, p_149650_2_, p_149650_3_);
    }

    public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_)
    {
        return true;
    }

    public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_)
    {
        return true;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
    	return false;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_)
    {
        if (p_149673_5_ == 1)
        {
        	// Top
            return this._iconTop;
        }
        else if (p_149673_5_ == 0)
        {
        	// Bottom
            return this.blockIcon;
        }
        else
        {
        	// Side
            Material material = p_149673_1_.getBlock(p_149673_2_, p_149673_3_ + 1, p_149673_4_).getMaterial();
            return material != Material.snow && material != Material.craftedSnow ? this._iconSide : this._iconSideSnowed;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName());
        this._iconTop = p_149651_1_.registerIcon(this.getTextureName() + "_top");
        this._iconSide = p_149651_1_.registerIcon(this.getTextureName() + "_side");
        this._iconSideSnowed = p_149651_1_.registerIcon(this.getTextureName() + "_side_snowed");
        this._iconSideOverlay = p_149651_1_.registerIcon(this.getTextureName() + "_side_overlay");
    }

    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        double d0 = 0.5D;
        double d1 = 1.0D;
        return ColorizerGrass.getGrassColor(d0, d1);
    }

    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    @SideOnly(Side.CLIENT)
    public int getRenderColor(int p_149741_1_)
    {
        return this.getBlockColor();
    }

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
    {
        int l = 0;
        int i1 = 0;
        int j1 = 0;

        for (int k1 = -1; k1 <= 1; ++k1)
        {
            for (int l1 = -1; l1 <= 1; ++l1)
            {
                int i2 = p_149720_1_.getBiomeGenForCoords(p_149720_2_ + l1, p_149720_4_ + k1).getBiomeGrassColor(p_149720_2_ + l1, p_149720_3_, p_149720_4_ + k1);
                l += (i2 & 16711680) >> 16;
                i1 += (i2 & 65280) >> 8;
                j1 += i2 & 255;
            }
        }

        return (l / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255;
    }

    @SideOnly(Side.CLIENT)
    public static IIcon getIconSideOverlay()
    {
        return ((BlockHiddenArtifactGrassOre)AncientRelics.Block_HiddenArtifactGrassOre)._iconSideOverlay;
    }

    public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_)
    {
        int l = 0;

        while (l < 128)
        {
            int i1 = p_149853_3_;
            int j1 = p_149853_4_ + 1;
            int k1 = p_149853_5_;
            int l1 = 0;

            while (true)
            {
                if (l1 < l / 16)
                {
                    i1 += p_149853_2_.nextInt(3) - 1;
                    j1 += (p_149853_2_.nextInt(3) - 1) * p_149853_2_.nextInt(3) / 2;
                    k1 += p_149853_2_.nextInt(3) - 1;

                    if (
                    	(p_149853_1_.getBlock(i1, j1 - 1, k1) == Blocks.grass 
                    	|| p_149853_1_.getBlock(i1, j1 - 1, k1) == AncientRelics.Block_HiddenArtifactGrassOre)
                    	&& !p_149853_1_.getBlock(i1, j1, k1).isNormalCube())
                    {
                        ++l1;
                        continue;
                    }
                }
                else if (p_149853_1_.getBlock(i1, j1, k1).isAir(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_))
                {
                    if (p_149853_2_.nextInt(8) != 0)
                    {
                        if (Blocks.tallgrass.canBlockStay(p_149853_1_, i1, j1, k1))
                        {
                            p_149853_1_.setBlock(i1, j1, k1, Blocks.tallgrass, 1, 3);
                        }
                    }
                    else
                    {
                        p_149853_1_.getBiomeGenForCoords(i1, k1).plantFlower(p_149853_1_, p_149853_2_, i1, j1, k1);
                    }
                }

                ++l;
                break;
            }
        }
    }
}