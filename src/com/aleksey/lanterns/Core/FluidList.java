package com.aleksey.lanterns.Core;

import com.bioxx.tfc.Core.TFCFluid;

import net.minecraftforge.fluids.Fluid;

public class FluidList
{
    public static Fluid[] AlcoholFluids;
    
    public static void setup()
    {
        AlcoholFluids = new Fluid[]
        {
            TFCFluid.RUM,
            TFCFluid.BEER,
            TFCFluid.RYEWHISKEY,
            TFCFluid.WHISKEY,
            TFCFluid.CORNWHISKEY,
            TFCFluid.SAKE,
            TFCFluid.VODKA,
            TFCFluid.CIDER
        };
    }
}
