package com.d4rsorc.feldbahn.block;

import net.minecraft.block.properties.IProperty;

public class BlockRailCurve extends BlockRailBase{
	public BlockRailCurve()
	{
		this.setUnlocalizedName("rail_curve");
		this.setRegistryName("curve");
	}

	@Override
	public IProperty<EnumRailDirection> getShapeProperty() {
		return null;
	}

}
