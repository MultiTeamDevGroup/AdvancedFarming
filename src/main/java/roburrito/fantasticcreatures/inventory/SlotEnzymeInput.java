package roburrito.fantasticcreatures.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotEnzymeInput extends Slot {
	private final InventoryEnzyme enzyme;
	private int removeCount;

	public SlotEnzymeInput(InventoryEnzyme enzymeIn, IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		enzyme = enzymeIn;
	}

	public boolean isItemValid(ItemStack stack)
    {
        return false;
    }
	
	public ItemStack decrStackSize(int amount)
    {
        if (this.getHasStack())
        {
            this.removeCount += Math.min(amount, this.getStack().getCount());
        }

        return super.decrStackSize(amount);
    }
	
	
}
