package multiteam.advancedfarming.block;

import java.util.Random;

import multiteam.advancedfarming.item.ModItems;
import net.minecraft.block.BlockCrops;
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

public class BlockCropTomato extends BlockCropDouble {
	
    protected Item getSeed()
    {
        return ModItems.TOMATO_SEED;
    }

    protected Item getCrop()
    {
        return ModItems.TOMATO;
    }
    
    private void growBoth(World worldIn, BlockPos pos, IBlockState state) {
    	if (state.getValue(HALF) == BlockCropDouble.EnumBlockHalf.LOWER) {
    		if (state.getValue(AGE) > 2) {
    			worldIn.setBlockState(pos.up(), worldIn.getBlockState(pos).withProperty(HALF, BlockCropDouble.EnumBlockHalf.UPPER));
    		}
    	} else {
    		worldIn.setBlockState(pos.down(), worldIn.getBlockState(pos).withProperty(HALF, BlockCropDouble.EnumBlockHalf.LOWER));
    	}
    }
}
