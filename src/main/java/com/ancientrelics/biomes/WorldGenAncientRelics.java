package com.ancientrelics.biomes;

import java.util.Random;

import com.ancientrelics.AncientRelics;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenAncientRelics implements IWorldGenerator
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
	
	private void generateSurface(World world, Random random, int globalX, int globalZ)
    {
		this.addOreSpawn(
			AncientRelics.Block_AncientCrystalOre,
			Blocks.stone,
			world,
			random,
			globalX,
			globalZ,
			8,
			25,
			42, 72 // Sealevel - 20 to Sealevel + 10
		);
		
		this.addOreSpawn(
			AncientRelics.Block_HiddenArtifactStoneOre,
			Blocks.stone,
			world,
			random,
			globalX,
			globalZ,
			3,
			12,
			57, 112 // Sealevel - 5 to Sealevel + 50
		);
		
		this.addOreSpawn(
			AncientRelics.Block_HiddenArtifactDirtOre,
			Blocks.dirt,
			world,
			random,
			globalX,
			globalZ,
			3,
			12,
			57, 112 // Sealevel - 5 to Sealevel + 50
		);
    }
 
    private void generateNether(World world, Random random, int x, int z)
    {}
    
    private void addOreSpawn(
    		Block block,
    		Block replaces,
    		World world,
    		Random random,
    		int globalX,
    		int globalZ,
    		int maxVeinSize,
    		int spawnRate,
    		int minY,
    		int maxY)
    {
    	int localX = globalX + random.nextInt(16);
    	int localZ = globalZ + random.nextInt(16);
    	
		int localY = minY + random.nextInt(maxY - minY);
		
    	for(int i = 0; i < spawnRate; i++)
		{
			(new WorldGenMinable(block, maxVeinSize, replaces)).generate(
				world, random, localX, localY, localZ);
		}
    }
}
