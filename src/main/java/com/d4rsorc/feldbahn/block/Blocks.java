package com.d4rsorc.feldbahn.block;

import com.d4rsorc.feldbahn.Feldbahn;
import com.d4rsorc.feldbahn.item.Items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry.EntityRegistration;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid=Feldbahn.MODID)
public class Blocks {
	public static Block RAIL_STRAIGHT = new BlockRail();
	public static Block RAIL_CURVE = new BlockRailCurve();
	
	public static void init()
	{
		RAIL_STRAIGHT.setCreativeTab(Items.tabFeldbahn);
		RAIL_CURVE.setCreativeTab(Items.tabFeldbahn);
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(RAIL_STRAIGHT, RAIL_CURVE);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		Item straightRailItem= new ItemBlock(RAIL_STRAIGHT).setRegistryName(RAIL_STRAIGHT.getRegistryName());
		Item curveRailItem= new ItemBlock(RAIL_CURVE).setRegistryName(RAIL_CURVE.getRegistryName());
		event.getRegistry().registerAll(straightRailItem, curveRailItem);
	}
	
	@SubscribeEvent
	public static void registerItemModels(ModelRegistryEvent event) {
		registerModels(Item.getItemFromBlock(RAIL_STRAIGHT));
		registerModels(Item.getItemFromBlock(RAIL_CURVE));
	}
	
	public static void registerModels(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	

}
