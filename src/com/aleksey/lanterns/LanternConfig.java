package com.aleksey.lanterns;

import com.aleksey.lanterns.Core.Constants;
import com.aleksey.lanterns.Core.LanternInfo;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class LanternConfig
{
    private static final String CategoryName = "Light Levels"; 
    
    public static void loadConfig(FMLPreInitializationEvent event)
    {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        
        config.setCategoryComment(CategoryName, "Light level must be specified in a range 1 - 15");
        
        for(int i = 0; i < Constants.Lanterns.length; i++)
        {
            LanternInfo info = Constants.Lanterns[i];
            
            info.LightLevel = config.get(CategoryName, info.LanternName, info.LightLevel).getInt();
            
            if(info.LightLevel < 1)
                info.LightLevel = 1;
            else if(info.LightLevel > 15)
                info.LightLevel = 15;
        }
        
        config.save();
    }
}
