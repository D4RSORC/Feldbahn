package com.d4rsorc.feldbahn;

import com.d4rsorc.feldbahn.entity.EntityLocomotive;
import com.d4rsorc.feldbahn.entity.EntityLocomotiveSmall;
import com.d4rsorc.feldbahn.entity.EntityWagon;
import com.d4rsorc.feldbahn.entity.EntityWagonBrake;
import com.d4rsorc.feldbahn.item.Items;
import com.d4rsorc.feldbahn.render.RenderWagon;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

@Mod(modid = Feldbahn.MODID, name = Feldbahn.NAME, version = Feldbahn.VERSION)
public class Feldbahn
{
    public static final String MODID = "feldbahn";
    public static final String NAME = "Feldbahn";
    public static final String VERSION = "1.0";
    
    @Instance
    public static Feldbahn instance;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	Items.init();
    	OBJLoader.INSTANCE.addDomain(MODID);
    	RenderingRegistry.registerEntityRenderingHandler(EntityWagon.class, EntityWagon.RENDER_INSTANCE);
    	RenderingRegistry.registerEntityRenderingHandler(EntityWagonBrake.class, EntityWagonBrake.RENDER_INSTANCE);
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityLocomotive.class, EntityLocomotive.RENDER_INSTANCE);
    	RenderingRegistry.registerEntityRenderingHandler(EntityLocomotiveSmall.class, EntityLocomotiveSmall.RENDER_INSTANCE);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    }
}
