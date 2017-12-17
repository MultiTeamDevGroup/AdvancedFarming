package multiteam.advancedfarming.item;

import multiteam.advancedfarming.AdvancedFarming;
import multiteam.advancedfarming.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;

public class ItemAFSeed extends ItemSeeds {
	protected String name;
	
	public ItemAFSeed(String name, Block crops, Block soil) {
		super(crops, soil);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	public void registerItemModel() {
		AdvancedFarming.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public ItemAFSeed setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
}
