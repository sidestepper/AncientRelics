package com.ancientrelics.biomes;

import java.util.Random;

import com.ancientrelics.AncientRelics;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenAncientCrystals implements IWorldGenerator
{
	@Override
	public void generate(
			Random random,
			int chunkX, int chunkZ,
			World world,
			IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider)
	{
		switch(world.provider.dimensionId)
		{
		case -1:
			generateNether(world, random, chunkX*16, chunkZ*16);
			break;
		case 0:
			generateSurface(world, random, chunkX*16, chunkZ*16);
			break;
		case 1:
			generateEnd(world, random, chunkX*16, chunkZ*16);
			break;
		}
	}
	
	private void generateEnd(World world, Random random, int x, int z)
	{}
	
	private void generateSurface(World world, Random random, int x, int z)
    {
		int chunkX = x + random.nextInt(16);
		int chunkY = 80 + random.nextInt(10);
		int chunkZ = z + random.nextInt(16);
		
		for(int i = 0; i < 25; i++)
		{
			(new WorldGenMinable(AncientRelics.Block_AncientCrystalOre, 8)).generate(
				world, random, chunkX, chunkY, chunkZ);
		}
    }
 
    private void generateNether(World world, Random random, int x, int z)
    {}
}
