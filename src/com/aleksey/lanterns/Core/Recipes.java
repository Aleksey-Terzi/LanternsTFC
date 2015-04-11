package com.aleksey.lanterns.Core;

import java.util.Map;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Constant.Global;
import com.bioxx.tfc.api.Crafting.AnvilManager;
import com.bioxx.tfc.api.Crafting.AnvilRecipe;
import com.bioxx.tfc.api.Crafting.PlanRecipe;
import com.bioxx.tfc.api.Enums.RuleEnum;

import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes
{
    private static final String LanternShellPlan = "lanternshell";
    
    public static void registerRecipes()
    {        
        registerLanternRecipes();
        registerFluidContainers();
    }
    
    public static boolean areAnvilRecipesRegistered()
    {
        Map map = AnvilManager.getInstance().getPlans();
        
        return map.containsKey(LanternShellPlan);
    }
    
    public static void registerAnvilRecipes()
    {
        AnvilManager manager = AnvilManager.getInstance();
        
        manager.addPlan(LanternShellPlan, new PlanRecipe(new RuleEnum[] { RuleEnum.HITLAST, RuleEnum.PUNCHANY, RuleEnum.HITANY }));
        
        for(int i = 0; i < Constants.Lanterns.length; i++)
        {
            LanternInfo info = Constants.Lanterns[i];
            Item sheetItem = GameRegistry.findItem("terrafirmacraft", info.SheetName);            
            ItemStack lanternShell = new ItemStack(ItemList.LanternShells[i], 1, 0);

            manager.addRecipe(new AnvilRecipe(new ItemStack(sheetItem), null, LanternShellPlan, false, info.Anvil, lanternShell).addRecipeSkill(Global.SKILL_GENERAL_SMITHING));
        }
    }
    
    private static void registerLanternRecipes()
    {
        ItemStack stick = new ItemStack(TFCItems.Stick, 1);
        ItemStack yarn = new ItemStack(TFCItems.WoolYarn, 1);
        ItemStack glassPane = new ItemStack(Blocks.glass_pane, 1);        
        
        for(int i = 0; i < Constants.Lanterns.length; i++)
        {
            ItemStack lantern = new ItemStack(BlockList.Lanterns[i], 2);
            Item lanternShell = ItemList.LanternShells[i];

            for(int k = 0; k < FluidList.AlcoholFluids.length; k++)
            {
                ItemStack shellFilled = new ItemStack(lanternShell, 1, k + 1);

                GameRegistry.addRecipe(lantern, new Object[] { "tgy", "gsg", "tgy", Character.valueOf('g'), glassPane, Character.valueOf('s'), shellFilled, Character.valueOf('t'), stick, Character.valueOf('y'), yarn });
                GameRegistry.addRecipe(lantern, new Object[] { "ygt", "gsg", "ygt", Character.valueOf('g'), glassPane, Character.valueOf('s'), shellFilled, Character.valueOf('t'), stick, Character.valueOf('y'), yarn });
            }
        }
    }
    
    private static void registerFluidContainers()
    {
        for(int i = 0; i < Constants.Lanterns.length; i++)
        {
            Item shell = ItemList.LanternShells[i]; 
            ItemStack shellEmpty = new ItemStack(shell, 1, 0);

            for(int k = 0; k < FluidList.AlcoholFluids.length; k++)
            {
                FluidStack fluid = new FluidStack(FluidList.AlcoholFluids[k], 2000);
                ItemStack shellFilled = new ItemStack(shell, 1, k + 1);

                FluidContainerRegistry.registerFluidContainer(fluid, shellFilled, shellEmpty);
            }
        }
    }
}