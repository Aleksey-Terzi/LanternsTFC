package com.aleksey.lanterns;

import net.minecraftforge.common.MinecraftForge;

import com.aleksey.lanterns.Core.BlockList;
import com.aleksey.lanterns.Core.FluidList;
import com.aleksey.lanterns.Core.ItemList;
import com.aleksey.lanterns.Core.Recipes;
import com.aleksey.lanterns.Core.Player.PlayerTracker;
import com.aleksey.lanterns.Handlers.ChunkEventHandler;
import com.aleksey.lanterns.Handlers.Network.InitClientWorldPacket;
import com.bioxx.tfc.TerraFirmaCraft;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="LanternsTFC", name="Lanterns", version="1.0.43", dependencies="after:TerraFirmaCraft")
public class LanternsMod
{
    @Instance("LanternsTFC")
    public static LanternsMod instance;

    @SidedProxy(clientSide = "com.aleksey.lanterns.ClientProxy", serverSide = "com.aleksey.lanterns.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LanternConfig.loadConfig(event);
        
        proxy.registerTickHandler();
        
        FluidList.setup();

        BlockList.LoadBlocks();
        BlockList.RegisterBlocks();
        
        ItemList.Setup();
    }
  
    @EventHandler
    public void initialize(FMLInitializationEvent event)
    {
        TerraFirmaCraft.packetPipeline.registerPacket(InitClientWorldPacket.class);
        
        FMLCommonHandler.instance().bus().register(new PlayerTracker());
        
        // Register the Chunk Load/Save Handler
        MinecraftForge.EVENT_BUS.register(new ChunkEventHandler());
        
        proxy.registerRenderInformation();
	    
        Recipes.registerRecipes();
    }

    @EventHandler
	public void postInit(FMLPostInitializationEvent event)
    {
    }
}