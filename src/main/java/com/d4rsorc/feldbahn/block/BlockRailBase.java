package com.d4rsorc.feldbahn.block;

import javax.annotation.Nullable;

import com.d4rsorc.feldbahn.item.Items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase.EnumRailDirection;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockRailBase extends Block{
	public BlockRailBase()
	{
		super(Material.CIRCUITS);
		setCreativeTab(Items.tabFeldbahn);
		this.fullBlock = false;
	}
	
	@Override
	@Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos.down(), EnumFacing.UP);
    }
	
	public static boolean isRailBlock(World worldIn, BlockPos pos)
    {
        return isRailBlock(worldIn.getBlockState(pos));
    }

	public static boolean isRailBlock(IBlockState state)
    {
        Block block = state.getBlock();
        return block instanceof BlockRailBase;
    }
	
	public static enum EnumRailDirection implements IStringSerializable
    {
        NORTH_SOUTH(0, "north_south"),
        EAST_WEST(1, "east_west"),
        ASCENDING_EAST(2, "ascending_east"),
        ASCENDING_WEST(3, "ascending_west"),
        ASCENDING_NORTH(4, "ascending_north"),
        ASCENDING_SOUTH(5, "ascending_south"),
        SOUTH_EAST(6, "south_east"),
        SOUTH_WEST(7, "south_west"),
        NORTH_WEST(8, "north_west"),
        NORTH_EAST(9, "north_east");

        private static final BlockRailBase.EnumRailDirection[] META_LOOKUP = new BlockRailBase.EnumRailDirection[values().length];
        private final int meta;
        private final String name;

        private EnumRailDirection(int meta, String name)
        {
            this.meta = meta;
            this.name = name;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public String toString()
        {
            return this.name;
        }

        public boolean isAscending()
        {
            return this == ASCENDING_NORTH || this == ASCENDING_EAST || this == ASCENDING_SOUTH || this == ASCENDING_WEST;
        }

        public static BlockRailBase.EnumRailDirection byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.name;
        }

        static
        {
            for (BlockRailBase.EnumRailDirection blockrailbase$enumraildirection : values())
            {
                META_LOOKUP[blockrailbase$enumraildirection.getMetadata()] = blockrailbase$enumraildirection;
            }
        }
    }
	
	public EnumRailDirection getRailDirection(IBlockAccess world, BlockPos pos, IBlockState state, @javax.annotation.Nullable net.minecraft.entity.item.EntityMinecart cart)
    {
        return state.getValue(getShapeProperty());
    }
	
	public abstract IProperty<BlockRailBase.EnumRailDirection> getShapeProperty();
	
	public void onMinecartPass(World world, net.minecraft.entity.item.EntityMinecart cart, BlockPos pos)
    {
    }
	
	public float getRailMaxSpeed(World world, net.minecraft.entity.item.EntityMinecart cart, BlockPos pos)
    {
        return 0.4f;
    }

}
