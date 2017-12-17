package multiteam.advancedfarming.block;

import java.util.Random;

import multiteam.advancedfarming.item.ModItems;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCropTomato extends BlockCrop {
	public static final PropertyInteger TOMATO_AGE = PropertyInteger.create("age", 0, 2);
    private static final AxisAlignedBB[] TOMATO_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D)};

    protected PropertyInteger getAgeProperty()
    {
        return TOMATO_AGE;
    }

    public int getMaxAge()
    {
        return 2;
    }
    
    protected Item getSeed()
    {
        return ModItems.TOMATO_SEED;
    }

    protected Item getCrop()
    {
        return ModItems.TOMATO;
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (rand.nextInt(2) == 0)
        {
            this.checkAndDropBlock(worldIn, pos, state);
        }
        else
        {
            super.updateTick(worldIn, pos, state, rand);
        }
    }
    
    protected int getBonemealAgeIncrease(World worldIn)
    {
        return super.getBonemealAgeIncrease(worldIn) / 2;
    }
    
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {TOMATO_AGE});
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return TOMATO_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    }
}
