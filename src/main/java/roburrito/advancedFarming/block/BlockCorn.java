package roburrito.advancedFarming.block;

import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import roburrito.advancedFarming.item.ModItems;

public class BlockCorn extends BlockCropsAF {
	public static final PropertyInteger CORN_AGE = PropertyInteger.create("age", 0, 3);
    private static final AxisAlignedBB[] CORN_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D)};

    protected PropertyInteger getAgeProperty()
    {
        return CORN_AGE;
    }

    public int getMaxAge()
    {
        return 3;
    }
    
    protected Item getSeed()
    {
        return ModItems.CORN_SEEDS;
    }

    protected Item getCrop()
    {
        return ModItems.CORN;
    }
}
