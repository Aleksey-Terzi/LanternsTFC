package com.aleksey.lanterns;

import com.aleksey.lanterns.Core.BlockList;
import com.aleksey.lanterns.Render.Blocks.RenderLantern;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    public void registerRenderInformation()
    {
        RenderingRegistry.registerBlockHandler(BlockList.LanternRenderId = RenderingRegistry.getNextAvailableRenderId(), new RenderLantern());
    }

    public boolean isRemote()
    {
        return true;
    }
}
