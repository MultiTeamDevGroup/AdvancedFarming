package roburrito.advancedFarming.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import roburrito.advancedFarming.AdvancedFarming;

public class ItemAF extends Item {
	protected String name;

	public ItemAF(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}

	public void registerItemModel() {
		AdvancedFarming.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public ItemAF setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
}
