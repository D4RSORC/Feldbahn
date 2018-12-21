package com.d4rsorc.feldbahn.item;

import com.d4rsorc.feldbahn.block.BlockRailBase;
import com.d4rsorc.feldbahn.entity.EntityLocomotive;
import com.d4rsorc.feldbahn.entity.EntityLocomotiveSmall;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemLocomotive extends Item{
	
	public ItemLocomotive(boolean isBig)
	{
		this.setUnlocalizedName(isBig ?  "locomotive" : "small_locomotive");
		this.setRegistryName(isBig ?  "locomotive" : "small_locomotive/kuli");
	}
	
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		IBlockState iblockstate = worldIn.getBlockState(pos);
		
		if (!BlockRailBase.isRailBlock(iblockstate))
        {
            return EnumActionResult.FAIL;
        }
		else
        {
			ItemStack itemstack = player.getHeldItem(hand);
			
			if (!worldIn.isRemote)
            {
                //BlockRailBase.EnumRailDirection blockrailbase$enumraildirection = iblockstate.getBlock() instanceof BlockRailBase ? ((BlockRailBase)iblockstate.getBlock()).getRailDirection(worldIn, pos, iblockstate, null) : BlockRailBase.EnumRailDirection.NORTH_SOUTH;
                double d0 = 0.0D;

//                if (blockrailbase$enumraildirection.isAscending())
//                {
//                    d0 = 0.5D;
//                }
           
			boolean isBig = this.getUnlocalizedName().equals(Items.LOCOMOTIVE_BIG.getUnlocalizedName());
			EntityMinecartChest entitylocomotive = isBig ? new EntityLocomotive(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.0625D, (double)pos.getZ() + 0.5D) : new EntityLocomotiveSmall(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.0625D, (double)pos.getZ() + 0.5D);
	
			if (itemstack.hasDisplayName())
            {
				entitylocomotive.setCustomNameTag(itemstack.getDisplayName());
            }
			
	        worldIn.spawnEntity(entitylocomotive);
            }
	        
		    itemstack.shrink(1);
		    return EnumActionResult.SUCCESS;
        }
    }

}
