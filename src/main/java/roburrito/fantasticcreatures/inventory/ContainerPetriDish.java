package roburrito.fantasticcreatures.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import roburrito.fantasticcreatures.tileentity.TileEntityPetriDish;

public class ContainerPetriDish extends Container {
	
	public ContainerPetriDish (IInventory playerInv, final TileEntityPetriDish petriDish) {
		IItemHandler inventory = petriDish.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(i + ", " + j);
				addSlotToContainer(new SlotItemHandler(inventory, i * 3 + j, 62 + j * 18, 17 + i * 18) {
				@Override
				public void onSlotChanged() {
					petriDish.markDirty();
				}
			});
			}
		}
	
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
	
		for (int k = 0; k < 9; k++) {
			addSlotToContainer(new Slot(playerInv, k, 8 + k * 18, 142));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack itemStack = ItemStack.EMPTY;
		Slot slot = inventorySlots.get(index);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack itemStack1 = slot.getStack();
			itemStack = itemStack1.copy();
			
			int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();
			
			if(index < containerSlots) {
				if (!this.mergeItemStack(itemStack1, containerSlots, inventorySlots.size(), true)) {
					return itemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemStack1, 0, containerSlots, false)) {
				return ItemStack.EMPTY;
			}
			
			if (itemStack1.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
			
			if (itemStack1.getCount() == itemStack.getCount()) {
				return ItemStack.EMPTY;
			}
			
			slot.onTake(player, itemStack1);
		}
		
		return itemStack;
	}
}
