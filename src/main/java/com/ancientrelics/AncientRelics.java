package com.ancientrelics;

import static net.minecraft.world.biome.BiomeGenBase.forestHills;

import java.util.ArrayList;
import java.util.Arrays;

import com.ancientrelics.biomes.BiomeGenAncient;
import com.ancientrelics.biomes.WorldGenAncient;
import com.ancientrelics.biomes.WorldGenAncientRelics;
import com.ancientrelics.blocks.*;
import com.ancientrelics.items.ItemAncientCrystalDust;
import com.ancientrelics.items.ItemCrystallineBlend;
import com.ancientrelics.items.ItemCrystallineIngot;
import com.ancientrelics.items.ItemInfusedCrystallineBlend;
import com.ancientrelics.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.BlockNewLog;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
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
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Utilities.MODID, version = Utilities.VERSION)
public class AncientRelics
{
	@Instance(Utilities.MODID)
	public static AncientRelics instance;
	
    public static Block Block_AncientCrystalOre;
    public static Block Block_HiddenArtifactDirtOre;
    public static Block Block_HiddenArtifactGrassOre;
    public static Block Block_HiddenArtifactStoneOre;
    
    public static Block Block_AshleafLog;
    public static Block Block_AshleafPlanks;
    public static Block Block_AshleafLeaves;
    public static Block Block_AshleafSapling;
    public static Block Block_CrystalEnergizer;
    
    public static Item Item_AncientCrystalDust;
    public static Item Item_CrystallineIngot;
    public static Item Item_CrystallineBlend;
    public static Item Item_InfusedCrystallineBlend;
    public static Item Item_AncientCrystal;
    public static Item Item_InfusedAncientCrystal;
    
    public static final BiomeGenBase Biome_Ancient = new BiomeGenAncient(150);
    
    public static WorldGenAncient WorldGen_Ancient;
    public static WorldGenAncientRelics WorldGen_AncientRelics;
    
    @SidedProxy(clientSide = "com.ancientrelics.proxy.ClientProxy", serverSide = "com.ancientrelics.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLInitializationEvent event)
    {
    	// Register blocks
    	Block_AncientCrystalOre = new BlockAncientCrystalOre();
    	Utilities.RegisterBlock(Block_AncientCrystalOre);
    	
    	Block_HiddenArtifactDirtOre = new BlockHiddenArtifactDirtOre();
    	Utilities.RegisterBlock(Block_HiddenArtifactDirtOre);
    	
    	Block_HiddenArtifactGrassOre = new BlockHiddenArtifactGrassOre();
    	Utilities.RegisterBlock(Block_HiddenArtifactGrassOre);
    	
    	Block_HiddenArtifactStoneOre = new BlockHiddenArtifactStoneOre();
    	Utilities.RegisterBlock(Block_HiddenArtifactStoneOre);
    	
    	Block_AshleafLog = new BlockAshleafLog();
    	Utilities.RegisterBlock(Block_AshleafLog);
    	
    	Block_AshleafPlanks = new BlockAshleafPlanks();
    	Utilities.RegisterBlock(Block_AshleafPlanks);
    	
    	Block_AshleafLeaves = new BlockAshleafLeaves();
    	Utilities.RegisterBlock(Block_AshleafLeaves);
    	
    	Block_AshleafSapling = new BlockAshleafSapling();
    	Utilities.RegisterBlock(Block_AshleafSapling);
    	
    	Block_CrystalEnergizer = new BlockCrystalEnergizer();
    	Utilities.RegisterBlock(Block_CrystalEnergizer);
    	
    	// Register items
    	Item_AncientCrystalDust = new ItemAncientCrystalDust();
    	Utilities.RegisterItem(Item_AncientCrystalDust);
    	
    	Item_CrystallineIngot = new ItemCrystallineIngot();
    	Utilities.RegisterItem(Item_CrystallineIngot);
    	
    	Item_CrystallineBlend = new ItemCrystallineBlend();
    	Utilities.RegisterItem(Item_CrystallineBlend);
    	
    	Item_InfusedCrystallineBlend = new ItemInfusedCrystallineBlend();
    	Utilities.RegisterItem(Item_InfusedCrystallineBlend);
    	
    	// Register biomes
    	BiomeDictionary.registerBiomeType(Biome_Ancient, Type.SWAMP);
    	
    	// Force spawn biome
    	WorldChunkManager.allowedBiomes.clear();
    	WorldChunkManager.allowedBiomes = new ArrayList<BiomeGenBase>(Arrays.asList(Biome_Ancient));
    	//BiomeManager.addSpawnBiome(BiomeNuked);
    	
    	BiomeManager.warmBiomes.add(new BiomeEntry(Biome_Ancient, 100));
    	WorldGen_Ancient = new WorldGenAncient();
    	
    	WorldGen_AncientRelics = new WorldGenAncientRelics();
    	GameRegistry.registerWorldGenerator(WorldGen_AncientRelics, 0);
    	
    	// Shapeless Crafting...
    	GameRegistry.addShapelessRecipe(
			new ItemStack(Item_CrystallineBlend),
			new ItemStack(Item_AncientCrystalDust),
			new ItemStack(Item_AncientCrystalDust),
			new ItemStack(Items.redstone),
			new ItemStack(Items.glowstone_dust)
    	);
    	
    	
    	//Blocks.enchanting_table
    	//EnumEnchantmentType.all
    	
    	// Smelting Recipes...
		GameRegistry.addSmelting(this.Item_CrystallineBlend, new ItemStack(this.Item_CrystallineIngot), 0F);
		
		// Renderers
		proxy.registerRenderThings();
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
