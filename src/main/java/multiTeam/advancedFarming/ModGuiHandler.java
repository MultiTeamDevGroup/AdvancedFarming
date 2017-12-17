package multiteam.advancedfarming;

import multiteam.advancedfarming.inventory.ContainerOilPress;
import multiteam.advancedfarming.tileEntity.TileEntityOilPress;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {
	public static final int OIL_PRESS = 0;
	
	@Override
	public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case OIL_PRESS:
			return new ContainerOilPress(player.inventory, (TileEntityOilPress) world.getTileEntity(new BlockPos(x, y, z)));
		default:
			return null;
		}
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case OIL_PRESS:
			return new TileEntityOilPress(ID, player, world, x, y, z, player.inventory);
		default:
			return null;
		}
	}
}
