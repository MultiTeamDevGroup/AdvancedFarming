package roburrito.fantasticcreatures.block;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import roburrito.fantasticcreatures.FantasticCreatures;
import roburrito.fantasticcreatures.ModGuiHandler;
import roburrito.fantasticcreatures.stats.ModStats;
import roburrito.fantasticcreatures.tileentity.TileEntityPetriDish;

public class BlockPetriDish extends BlockTileEntity {

	public BlockPetriDish() {
		super(Material.GLASS, "petri_dish");
		this.setCreativeTab(FantasticCreatures.microbiologyTab);
	}
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.25D, 0.75D);
    }
	
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
	
	@Override
	@Deprecated
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	@Deprecated
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public Class getTileEntityClass() {
		return TileEntityPetriDish.class;
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityPetriDish();
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(world.isRemote) {
			return true;
		} else {
			TileEntity tile = getTileEntity(world, pos);
			if (tile instanceof TileEntityPetriDish) {
				playerIn.openGui(FantasticCreatures.MODID, ModGuiHandler.PETRI_DISH, world, pos.getX(), pos.getY(), pos.getZ());
				playerIn.addStat(ModStats.PETRI_DISH_INTERACTION);
			}
			return true;
		}
	}
}
