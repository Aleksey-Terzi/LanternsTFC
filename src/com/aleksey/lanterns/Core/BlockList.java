package com.aleksey.lanterns.Core;

import net.minecraft.block.Block;

import com.aleksey.lanterns.Blocks.BlockCustomLantern;
import com.aleksey.lanterns.Items.ItemBlocks.ItemLantern;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockList
{
	public static int LanternRenderId;
	
	public static Block[] Lanterns;
	
	public static void RegisterBlocks()
	{
	    for(int i = 0; i < Lanterns.length; i++)
	    {
	        Block lantern = Lanterns[i];
	        
	        GameRegistry.registerBlock(lantern, ItemLantern.class, lantern.getUnlocalizedName().substring(5));
	    }
	}
	
	public static void LoadBlocks()
	{
		System.out.println("[TFC Lanterns] Loading Blocks");
		
		Lanterns = new Block[Constants.Lanterns.length];
		
		for(int i = 0; i < Constants.Lanterns.length; i++)
		{
		    LanternInfo info = Constants.Lanterns[i];
		    String name = "Lantern." + info.LanternName;
		    
		    Lanterns[i] = new BlockCustomLantern(info).setBlockName(name);
		}
	}
}
