package com.d4rsorc.feldbahn.entity;

import com.d4rsorc.feldbahn.render.RenderWagon;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class EntityWagonBrake extends EntityCartBase{
	
	public static IRenderFactory<EntityWagonBrake> RENDER_INSTANCE = new IRenderFactory<EntityWagonBrake>() {
		@Override
		public Render<? super EntityWagonBrake> createRenderFor(RenderManager manager) {
			return new RenderWagon(manager);
		}
	};

	public EntityWagonBrake(World worldIn)
	{
		super(worldIn);
	}
	public EntityWagonBrake(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	@Override
	public boolean canBeRidden()
    {
        return true;
    }
	

}
