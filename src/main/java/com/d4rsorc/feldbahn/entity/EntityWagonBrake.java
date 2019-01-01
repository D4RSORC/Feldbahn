package com.d4rsorc.feldbahn.entity;

import com.d4rsorc.feldbahn.render.RenderWagon;
import com.d4rsorc.feldbahn.util.VecUtil;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class EntityWagonBrake extends EntityCartBase{
	
	public static IRenderFactory<EntityWagonBrake> RENDER_INSTANCE = new IRenderFactory<EntityWagonBrake>() {
		@Override
		public Render<? super EntityWagonBrake> createRenderFor(RenderManager manager) {
			return new RenderWagon<EntityWagonBrake>(manager);
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
	
	@Override
	public boolean shouldRiderSit()
	{
		return false;
	}
	
	@Override
	public double getMountedYOffset()
    {
        return 0.2D;
    }
	
	@Override
	public void updatePassenger(Entity passenger)
    {
        if (this.isPassenger(passenger))
        {
        	Vec3d pos = new Vec3d(-0.9,0.3,0);
			//pos = pos.add(passengerPositions.get(passenger.getPersistentID()));
			pos = VecUtil.rotateWrongYaw(pos, this.rotationYaw);
			pos = pos.add(this.getPositionVector());
			if (passenger instanceof EntityPlayer && shouldRiderSit()) {
				pos = pos.subtract(0, 0.75, 0);
			}
			passenger.setPosition(pos.x, pos.y, pos.z);
			passenger.motionX = this.motionX;
			passenger.motionY = this.motionY;
			passenger.motionZ = this.motionZ;
			
			passenger.prevRotationYaw = passenger.rotationYaw;
			passenger.rotationYaw += (this.rotationYaw - this.prevRotationYaw);

        }
    }
	
	@Override
	public boolean processInitialInteract(EntityPlayer player, EnumHand hand)
    {
        //if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.entity.minecart.MinecartInteractEvent(this, player, hand))) return true;

        if (player.isSneaking())
        {
        	if (!this.world.isRemote)
            {
                player.displayGUIChest(this);
                return true;
            }
            return false;
        }
        else if (this.isBeingRidden())
        {
            return true;
        }
        else
        {
            if (!this.world.isRemote)
            {
                player.startRiding(this);
            }

            return true;
        }
    }
	

}
