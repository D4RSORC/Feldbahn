package com.d4rsorc.feldbahn.item;

import com.d4rsorc.feldbahn.Feldbahn;
import com.d4rsorc.feldbahn.entity.EntityLocomotive;
import com.d4rsorc.feldbahn.entity.EntityLocomotiveSmall;
import com.d4rsorc.feldbahn.entity.EntityWagon;
import com.d4rsorc.feldbahn.entity.EntityWagonBrake;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod.EventBusSubscriber(modid=Feldbahn.MODID)
public class Items {
	
	public static Item WAGON = new ItemWagon(false);
	public static Item WAGON_BRAKE = new ItemWagon(true);
	
	public static Item LOCOMOTIVE_SMALL = new ItemLocomotive(false);
	public static Item LOCOMOTIVE_BIG = new ItemLocomotive(true);
	
	public static final CreativeTabs tabFeldbahn = (new CreativeTabs("tabFeldbahn") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(WAGON);
		}
		
	});
	
	public static void init()
	{
		WAGON.setCreativeTab(tabFeldbahn);
		WAGON_BRAKE.setCreativeTab(tabFeldbahn);
		LOCOMOTIVE_BIG.setCreativeTab(tabFeldbahn);
		LOCOMOTIVE_SMALL.setCreativeTab(tabFeldbahn);
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(WAGON, WAGON_BRAKE, LOCOMOTIVE_SMALL, LOCOMOTIVE_BIG);
		
		EntityRegistry.registerModEntity(WAGON.getRegistryName(), EntityWagon.class, "wagon", 0, Feldbahn.instance, 64, 1, true);
		EntityRegistry.registerModEntity(WAGON_BRAKE.getRegistryName(), EntityWagonBrake.class, "wagon_brake", 1, Feldbahn.instance, 64, 1, true);
		
		EntityRegistry.registerModEntity(LOCOMOTIVE_BIG.getRegistryName(), EntityLocomotive.class, "locomotive", 2, Feldbahn.instance, 64, 1, true);
		EntityRegistry.registerModEntity(LOCOMOTIVE_SMALL.getRegistryName(), EntityLocomotiveSmall.class, "locomotive_small", 3, Feldbahn.instance, 64, 1, true);
	}
	
	@SubscribeEvent
	public static void registerItemModels(ModelRegistryEvent event) {
		registerModels(WAGON);
		registerModels(WAGON_BRAKE);
		registerModels(LOCOMOTIVE_SMALL);
		registerModels(LOCOMOTIVE_BIG);
	}
	
	public static void registerModels(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
