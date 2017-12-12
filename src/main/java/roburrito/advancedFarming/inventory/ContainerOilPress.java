package roburrito.advancedFarming.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import roburrito.advancedFarming.tileEntity.TileEntityOilPress;

public class ContainerOilPress extends Container {

	public ContainerOilPress(InventoryPlayer inventoryIn, TileEntityOilPress tileEntity) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

}
