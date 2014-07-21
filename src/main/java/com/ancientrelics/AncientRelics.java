package com.ancientrelics;

import static net.minecraft.world.biome.BiomeGenBase.forestHills;

import java.util.ArrayList;
import java.util.Arrays;

import com.ancientrelics.biomes.BiomeGenAncient;
import com.ancientrelics.biomes.WorldGenAncient;
import com.ancientrelics.biomes.WorldGenAncientCrystals;
import com.ancientrelics.blocks.*;
import com.ancientrelics.items.ItemAncientCrystalDust;

import net.minecraft.block.Block;
import net.minecraft.block.BlockNewLog;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Utilities.MODID, version = Utilities.VERSION)
public class AncientRelics
{
    public static Block Block_AncientCrystalOre;
    
    public static Block Block_AshleafLog;
    public static Block Block_AshleafPlanks;
    public static Block Block_AshleafLeaves;
    public static Block Block_AshleafSapling;
    
    public static Item Item_AncientCrystalDust;
    
    
    public static final BiomeGenBase Biome_Ancient = new BiomeGenAncient(150);
    
    public static WorldGenAncient WorldGen_Ancient;
    public static WorldGenAncientCrystals WorldGen_AncientCrystalOre;
    
    
    @EventHandler
    public void preInit(FMLInitializationEvent event)
    {
    	// Register blocks
    	Block_AncientCrystalOre = new BlockAncientCrystalOre();
    	Utilities.RegisterBlock(Block_AncientCrystalOre);
    	
    	Block_AshleafLog = new BlockAshleafLog();
    	Utilities.RegisterBlock(Block_AshleafLog);
    	
    	Block_AshleafPlanks = new BlockAshleafPlanks();
    	Utilities.RegisterBlock(Block_AshleafPlanks);
    	
    	Block_AshleafLeaves = new BlockAshleafLeaves();
    	Utilities.RegisterBlock(Block_AshleafLeaves);
    	
    	Block_AshleafSapling = new BlockAshleafSapling();
    	Utilities.RegisterBlock(Block_AshleafSapling);
    	
    	
    	// Register items
    	Item_AncientCrystalDust = new ItemAncientCrystalDust();
    	Utilities.RegisterItem(Item_AncientCrystalDust);
    	
    	// Register biomes
    	BiomeDictionary.registerBiomeType(Biome_Ancient, Type.SWAMP);
    	
    	// Force spawn biome
    	WorldChunkManager.allowedBiomes.clear();
    	WorldChunkManager.allowedBiomes = new ArrayList<BiomeGenBase>(Arrays.asList(Biome_Ancient));
    	//BiomeManager.addSpawnBiome(BiomeNuked);
    	
    	BiomeManager.warmBiomes.add(new BiomeEntry(Biome_Ancient, 100));
    	WorldGen_Ancient = new WorldGenAncient();
    	
    	
    	WorldGen_AncientCrystalOre = new WorldGenAncientCrystals();
    	GameRegistry.registerWorldGenerator(WorldGen_AncientCrystalOre, 1);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	// Register recipes
		System.out.println("Aligning Spirit Realm...");
    }
    
    @EventHandler
    public void postInit(FMLInitializationEvent event)
    {
    	// Cross-mod changes
    	BiomeDictionary.registerAllBiomes();
    }
}
