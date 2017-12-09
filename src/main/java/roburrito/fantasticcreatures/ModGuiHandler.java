package roburrito.fantasticcreatures;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import roburrito.fantasticcreatures.client.gui.inventory.GuiPetriDish;
import roburrito.fantasticcreatures.inventory.ContainerPetriDish;
import roburrito.fantasticcreatures.tileentity.TileEntityPetriDish;

public class ModGuiHandler implements IGuiHandler {
	public static final int PETRI_DISH = 0;
	
	@Override
	public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case PETRI_DISH:
				return new ContainerPetriDish(player.inventory, (TileEntityPetriDish) world.getTileEntity(new BlockPos(x, y, z)));
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case PETRI_DISH:
			return new GuiPetriDish(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
		default:
			return null;
	}
	}
}
