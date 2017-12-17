package multiteam.advancedfarming.inventory;

import multiteam.advancedfarming.tileEntity.TileEntityOilPress;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerOilPress extends Container {

	public ContainerOilPress(InventoryPlayer inventoryIn, TileEntityOilPress tileEntity) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

}
