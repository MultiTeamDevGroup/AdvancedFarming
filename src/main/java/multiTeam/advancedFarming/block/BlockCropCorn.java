package multiteam.advancedfarming.block;

import multiteam.advancedfarming.item.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockCropCorn extends BlockCrops {
	
    public BlockCropCorn() {
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
}
