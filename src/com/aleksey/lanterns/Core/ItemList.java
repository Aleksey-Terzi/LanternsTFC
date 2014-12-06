package com.aleksey.lanterns.Core;

import net.minecraft.item.Item;

import com.aleksey.lanterns.Items.ItemLanternShell;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemList
{
    public static Item[] LanternShells;
    
    public static void Setup()
    {
        LanternShells = new Item[Constants.Lanterns.length];
        
        for(int i = 0; i < LanternShells.length; i++)
        {
            LanternInfo info = Constants.Lanterns[i];
            
            LanternShells[i] = new ItemLanternShell(info).setUnlocalizedName("LanternShell" + "." + info.LanternName);
        }
        
        for(int i = 0; i < LanternShells.length; i++)
        {
            Item lanternShell = LanternShells[i];
            
            GameRegistry.registerItem(lanternShell, lanternShell.getUnlocalizedName());
        }
    }
}
