package multiteam.advancedfarming.block;

import java.util.Random;

import multiteam.advancedfarming.item.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCropCorn extends BlockCropDouble {
	
	BlockCropCorn() {
		super(2, 7);
		setUnlocalizedName("crop_corn");
    	setRegistryName("crop_corn");
	}
	
	protected Item getSeed()
    {
        return ModItems.CORN_SEED;
    }

    protected Item getCrop()
    {
        return ModItems.CORN;
    }
    
    @Override
    public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
    	int age = getAge(state);
    	if(state.getValue(HALF) == BlockCropDouble.EnumBlockHalf.UPPER || age < 2) {
    		if (age < 7) {
    			drops.add(new ItemStack(this.getSeed(), 1, 0));
    		} else {
    			for (int i = 0; i < 3 + fortune; ++i) {
    				Random rand = world instanceof World ? ((World)world).rand : new Random();
                    if (rand.nextInt(2 * getMaxAge()) <= age) {
                    	drops.add(new ItemStack(this.getCrop(), 1, 0));
                    }
                }
    		}
    	}
    }
    
}
