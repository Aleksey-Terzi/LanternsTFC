package com.aleksey.lanterns.Core;

import net.minecraftforge.fluids.Fluid;

import com.bioxx.tfc.api.TFCFluids;

public class FluidList
{
    public static Fluid[] AlcoholFluids;
    
    public static void setup()
    {
        AlcoholFluids = new Fluid[]
        {
            TFCFluids.RUM,
            TFCFluids.BEER,
            TFCFluids.RYEWHISKEY,
            TFCFluids.WHISKEY,
            TFCFluids.CORNWHISKEY,
            TFCFluids.SAKE,
            TFCFluids.VODKA,
            TFCFluids.CIDER
        };
    }
}
