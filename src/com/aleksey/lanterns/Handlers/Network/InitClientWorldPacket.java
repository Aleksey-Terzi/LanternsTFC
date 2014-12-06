package com.aleksey.lanterns.Handlers.Network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

import com.aleksey.lanterns.Core.Recipes;
import com.bioxx.tfc.Handlers.Network.AbstractPacket;

public class InitClientWorldPacket extends AbstractPacket
{
    public InitClientWorldPacket()
    {
        
    }

    @Override
    public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
    {
    }

    @Override
    public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer)
    {
    }

    @Override
    public void handleClientSide(EntityPlayer player)
    {
        if(!Recipes.areAnvilRecipesRegistered())
            Recipes.registerAnvilRecipes();

        System.out.println("[TFC Lanterns] Recieved client init packet.");
    }

    @Override
    public void handleServerSide(EntityPlayer player)
    {
        System.out.println("[TFC Lanterns] Recieved server init packet.");
    }
}