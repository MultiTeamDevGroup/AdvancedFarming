package multiteam.advancedfarming.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCropDouble extends BlockCrops {
	public static final PropertyEnum<BlockCropDouble.EnumBlockHalf> HALF = PropertyEnum.<BlockCropDouble.EnumBlockHalf>create("half", BlockCropDouble.EnumBlockHalf.class);
	public static final int age_double;
	
    public BlockCropDouble(int age_double) {
    	super();
    	this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0).withProperty(HALF, BlockCropDouble.EnumBlockHalf.LOWER));
    	this.age_double = age_double;
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
    	checkAndDropBlock(worldIn, pos, state);
    	
    	if (state.getValue(HALF) == BlockCropDouble.EnumBlockHalf.LOWER) {
    		if (worldIn.getLightFromNeighbors(pos.up()) >= 9) {
                int i = this.getAge(state);
                if (i < this.getMaxAge()) {
                    float f = getGrowthChance(this, worldIn, pos);
                    if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0)) {
                    	worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                    	growBoth(worldIn, pos, worldIn.getBlockState(pos));
                        net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                    }
                }
            }
    	}
    }
    
    private void growBoth(World worldIn, BlockPos pos, IBlockState state) {
    	if (state.getValue(HALF) == BlockCropDouble.EnumBlockHalf.LOWER) {
    		if (state.getValue(AGE) > 1) {
    			worldIn.setBlockState(pos.up(), worldIn.getBlockState(pos).withProperty(HALF, BlockCropDouble.EnumBlockHalf.UPPER));
    		}
    	} else {
    		worldIn.setBlockState(pos.down(), worldIn.getBlockState(pos).withProperty(HALF, BlockCropDouble.EnumBlockHalf.LOWER));
    	}
    }
    
    public void grow(World worldIn, BlockPos pos, IBlockState state) {
    	super.grow(worldIn, pos, state);
    	growBoth(worldIn, pos, state);
    }
    
    public IBlockState getStateFromMeta(int meta) {
    	if (meta >= 8) {
    		return this.getDefaultState().withProperty(HALF, BlockCropDouble.EnumBlockHalf.UPPER).withProperty(AGE, meta - 8);
    	} else {
    		return this.getDefaultState().withProperty(HALF, BlockCropDouble.EnumBlockHalf.LOWER).withProperty(AGE, meta);
    	}
    }
    
    public int getMetaFromState(IBlockState state) {
    	int meta = state.getValue(AGE);
    	if (state.getValue(HALF) == BlockCropDouble.EnumBlockHalf.UPPER) {
    		meta += 8;
    	}
    	return meta;
    }
    
    public PropertyEnum getHalfProperty () {
    	return HALF;
    }
    
    public BlockCropDouble.EnumBlockHalf getHalf (IBlockAccess blockAccess, BlockPos pos, IBlockState state) {
		if (state.getBlock() == this) {
			state = state.getActualState(blockAccess, pos);
			return (BlockCropDouble.EnumBlockHalf)state.getValue(HALF);
		} else {
			return BlockCropDouble.EnumBlockHalf.LOWER;
		}
    	
    }
    
    /*
     * Stolen from BlockDoublePlant without modification beyond the obvious
     * @see net.minecraft.block.BlockBush#checkAndDropBlock(net.minecraft.world.World, net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState)
     */
    protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state) {
    	if (!this.canBlockStay(worldIn, pos, state)) {
    		boolean flag = state.getValue(HALF) == BlockCropDouble.EnumBlockHalf.UPPER;
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
    
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
    	if (state.getBlock() != this) return super.canBlockStay(worldIn, pos, state); //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
    	if (state.getValue(HALF) == BlockCropDouble.EnumBlockHalf.UPPER) {
            return worldIn.getBlockState(pos.down()).getBlock() == this && (worldIn.getLight(pos) >= 8 || worldIn.canSeeSky(pos));
        } else {
            Boolean above = true;
            if (getAge(state) > 1) {
            	above = worldIn.getBlockState(pos.up()).getBlock() == this;
            } else {
            	above = worldIn.isAirBlock(pos.up());
            }
            
            IBlockState soil = worldIn.getBlockState(pos.down());
            return above && soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
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
