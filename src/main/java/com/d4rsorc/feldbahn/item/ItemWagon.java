package com.d4rsorc.feldbahn.item;

import com.d4rsorc.feldbahn.block.BlockRailBase;
import com.d4rsorc.feldbahn.entity.EntityCartBase;
import com.d4rsorc.feldbahn.entity.EntityWagon;
import com.d4rsorc.feldbahn.entity.EntityWagonBrake;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemWagon extends Item{
	
	public ItemWagon(boolean hasBrake)
	{
		this.setUnlocalizedName(hasBrake ?  "wagon_brake" : "wagon");
		this.setRegistryName(hasBrake ?  "wagon_brake/kipplore" : "wagon/kipplore");
		this.maxStackSize = 1;
	}
	
	@Override
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
                BlockRailBase.EnumRailDirection blockrailbase$enumraildirection = iblockstate.getBlock() instanceof BlockRailBase ? ((BlockRailBase)iblockstate.getBlock()).getRailDirection(worldIn, pos, iblockstate, null) : BlockRailBase.EnumRailDirection.NORTH_SOUTH;
                double d0 = 0.0D;

                if (blockrailbase$enumraildirection.isAscending())
                {
                    d0 = 0.5D;
                }
                boolean hasBrake = this.getUnlocalizedName().equals(Items.WAGON_BRAKE.getUnlocalizedName());
                EntityCartBase entitywagon = hasBrake ? new EntityWagonBrake(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.0625D + d0, (double)pos.getZ() + 0.5D) : new EntityWagon(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.0625D + d0, (double)pos.getZ() + 0.5D);

                if (itemstack.hasDisplayName())
                {
                	entitywagon.setCustomNameTag(itemstack.getDisplayName());
                }

                worldIn.spawnEntity(entitywagon);
            }

            itemstack.shrink(1);
            return EnumActionResult.SUCCESS;
        }
    }

}
