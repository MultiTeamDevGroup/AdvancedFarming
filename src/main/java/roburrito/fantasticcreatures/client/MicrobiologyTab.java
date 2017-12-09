package roburrito.fantasticcreatures.client;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import roburrito.fantasticcreatures.FantasticCreatures;
import roburrito.fantasticcreatures.item.ModItems;

public class MicrobiologyTab extends CreativeTabs {

	public MicrobiologyTab() {
		super("biochemistry");
		setBackgroundImageName("item_search.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.GENOME);
	}

	@Override
	public boolean hasSearchBar() {
		return true;
	}
}
