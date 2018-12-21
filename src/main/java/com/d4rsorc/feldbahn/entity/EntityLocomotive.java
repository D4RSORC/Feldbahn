package com.d4rsorc.feldbahn.entity;

import com.d4rsorc.feldbahn.render.RenderLocomotive;
import com.d4rsorc.feldbahn.render.RenderWagon;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class EntityLocomotive extends EntityCartBase{
	
	public static IRenderFactory<EntityLocomotive> RENDER_INSTANCE = new IRenderFactory<EntityLocomotive>() {
		@Override
		public Render<? super EntityLocomotive> createRenderFor(RenderManager manager) {
			return new RenderLocomotive(manager);
		}
	};

	public EntityLocomotive(World worldIn) {
		super(worldIn);
	}
	public EntityLocomotive(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}
	
	@Override
	public boolean canBeRidden()
    {
        return true;
    }

}
