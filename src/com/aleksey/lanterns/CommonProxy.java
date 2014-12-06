package com.aleksey.lanterns;

import com.aleksey.lanterns.Handlers.ServerTickHandler;

import cpw.mods.fml.common.FMLCommonHandler;


public class CommonProxy
{
    public void registerRenderInformation()
    {
    }

    public boolean isRemote()
    {
        return false;
    }
    
    public void registerTickHandler()
    {
        FMLCommonHandler.instance().bus().register(new ServerTickHandler());
    }
}