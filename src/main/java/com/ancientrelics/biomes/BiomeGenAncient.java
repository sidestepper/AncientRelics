package com.ancientrelics.biomes;
import java.util.Random;








import com.ancientrelics.AncientRelics;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntitySlime;
//import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenSwamp;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class BiomeGenAncient extends BiomeGenBase
{
    //private static final String __OBFID = "CL_00000167";

    public BiomeGenAncient(int id)
    {
        super(id);
        //BiomeGenBase.getBiomeGenArray()[id] = this;
        
        //this.topBlock = AncientRelics.Block_HiddenArtifactGrassOre;
        //this.fillerBlock = Blocks.dirt;
        
        this.theBiomeDecorator.treesPerChunk = 2;
        this.theBiomeDecorator.flowersPerChunk = 1;
        this.theBiomeDecorator.deadBushPerChunk = 3;
        this.theBiomeDecorator.mushroomsPerChunk = 0;
        this.theBiomeDecorator.reedsPerChunk = 0;
        this.theBiomeDecorator.clayPerChunk = 0;
        this.theBiomeDecorator.waterlilyPerChunk = 0;
        this.theBiomeDecorator.sandPerChunk2 = 0;
        this.theBiomeDecorator.sandPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 5;
        
        //this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySlime.class, 1, 1, 1));
        this.flowers.clear();
        this.addFlower(Blocks.red_flower,    1, 2); // Blue Orchid
        this.addFlower(Blocks.red_flower,    2, 5); // Allium
        this.addFlower(Blocks.red_flower,    8, 1); // Oxeye Daisy
        
        this.setBiomeName("Ancient");
        //this.func_76733_a(0xFF0000);
        this.setHeight(height_LowPlains);
        this.setTemperatureRainfall(0.8F, 0.9F);
        
        this.setColor(0x394470);
        this.waterColorMultiplier = 0x583970;
        
        
    }

    public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
    {
        return AncientRelics.WorldGen_Ancient;
    }

    public String func_150572_a(Random p_150572_1_, int p_150572_2_, int p_150572_3_, int p_150572_4_)
    {
    	int r = p_150572_1_.nextInt(3);
    	if(r == 0)
    		return BlockFlower.field_149859_a[1];
    	else if(r == 1)
    		return BlockFlower.field_149859_a[2];
    	else
    		return BlockFlower.field_149859_a[8];
    }
    
    public void genTerrainBlocks(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_)
    {
        double d1 = plantNoise.func_151601_a((double)p_150573_5_ * 0.25D, (double)p_150573_6_ * 0.25D);

        if (d1 > 0.0D)
        {
            int k = p_150573_5_ & 15;
            int l = p_150573_6_ & 15;
            int i1 = p_150573_3_.length / 256;

            for (int j1 = 255; j1 >= 0; --j1)
            {
                int k1 = (l * 16 + k) * i1 + j1;

                if (p_150573_3_[k1] == null || p_150573_3_[k1].getMaterial() != Material.air)
                {
                    if (j1 == 62 && p_150573_3_[k1] != Blocks.water)
                    {
                        p_150573_3_[k1] = Blocks.water;
                    }

                    break;
                }
            }
        }

        this.genBiomeTerrain(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
    }

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_)
    {
        double d0 = plantNoise.func_151601_a(
        	(double)p_150558_1_ * 0.0225D, (double)p_150558_3_ * 0.0225D
        );
        
        return d0 < -0.1D ? 0x3C7672 : 0x544063;
    }

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    @SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_)
    {
        return 0x396970;
    }
}