package multiteam.advancedfarming.block;

import java.util.Random;

import multiteam.advancedfarming.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCropCorn extends BlockCrops {
	public static final PropertyEnum<BlockCropCorn.EnumBlockHalf> HALF = PropertyEnum.<BlockCropCorn.EnumBlockHalf>create("half", BlockCropCorn.EnumBlockHalf.class);
	
    public BlockCropCorn() {
    	this.setDefaultState(this.blockState.getBaseState().withProperty(HALF, BlockCropCorn.EnumBlockHalf.LOWER));
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
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
    	if (state.getValue(HALF) == BlockCropCorn.EnumBlockHalf.LOWER) {
    		super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
            {
                int i = this.getAge(state);

                if (i < this.getMaxAge())
                {
                    float f = getGrowthChance(this, worldIn, pos);

                    if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0))
                    {
                    	if (i < 2) {
                            worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));	
                    	} else {
                    		if(worldIn.isAirBlock(pos.up()) || worldIn.getBlockState(pos.up()).getBlock() == this) {
                    			worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                    			worldIn.setBlockState(pos.up(), this.withAge(i + 1), 2);
                                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                    		}
                    	}
                    }
                }
            }
    	}
    }
    
    /*
     * Stolen from BlockDoublePlant without modification beyond the obvious
     * @see net.minecraft.block.BlockBush#checkAndDropBlock(net.minecraft.world.World, net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState)
     */
    protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state) {
    	if (!this.canBlockStay(worldIn, pos, state)) {
            boolean flag = state.getValue(HALF) == BlockCropCorn.EnumBlockHalf.UPPER;
            BlockPos blockpos = flag ? pos : pos.up();
            BlockPos blockpos1 = flag ? pos.down() : pos;
            Block block = (Block)(flag ? this : worldIn.getBlockState(blockpos).getBlock());
            Block block1 = (Block)(flag ? worldIn.getBlockState(blockpos1).getBlock() : this);

            if (!flag) this.dropBlockAsItem(worldIn, pos, state, 0); //Forge move above the setting to air.

            if (block == this) {
                worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 2);
            }

            if (block1 == this) {
                worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 3);
            }
        }
    }
    
    /*
     * Stolen from BlockDoublePlant without modification beyond the obvious
     * @see net.minecraft.block.BlockCrops#canBlockStay(net.minecraft.world.World, net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState)
     */
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        if (state.getBlock() != this) return super.canBlockStay(worldIn, pos, state); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
        if (state.getValue(HALF) == BlockCropCorn.EnumBlockHalf.UPPER) {
            return worldIn.getBlockState(pos.down()).getBlock() == this;
        } else {
            IBlockState iblockstate = worldIn.getBlockState(pos.up());
            return iblockstate.getBlock() == this && super.canBlockStay(worldIn, pos, iblockstate);
        }
    }
    
    public static enum EnumBlockHalf implements IStringSerializable
    {
        UPPER,
        LOWER;

        public String toString()
        {
            return this.getName();
        }

        public String getName()
        {
            return this == UPPER ? "upper" : "lower";
        }
    }
    
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {AGE, HALF});
    }
}
