package com.d4rsorc.feldbahn.entity;

import com.d4rsorc.feldbahn.render.RenderWagon;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class EntityWagon extends EntityCartBase{
	
	public static IRenderFactory<EntityWagon> RENDER_INSTANCE = new IRenderFactory<EntityWagon>() {
		@Override
		public Render<? super EntityWagon> createRenderFor(RenderManager manager) {
			return new RenderWagon(manager);
		}
	};

	public EntityWagon(World worldIn)
	{
		super(worldIn);
	}
	public EntityWagon(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	@Override
	public boolean canBeRidden()
    {
        return false;
    }
	

}
