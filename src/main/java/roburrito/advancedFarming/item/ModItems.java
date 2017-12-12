package roburrito.advancedFarming.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	public static final ItemAF CORN = new ItemAF("corn").setCreativeTab(CreativeTabs.FOOD);
	public static final ItemAF CORN_SEEDS = new ItemAF("corn_seeds").setCreativeTab(CreativeTabs.FOOD);
	public static final ItemAF TOMATO = new ItemAF("tomato").setCreativeTab(CreativeTabs.FOOD);
	public static final ItemAF TOMATO_SEEDS = new ItemAF("tomato_seeds").setCreativeTab(CreativeTabs.FOOD);
	
	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				CORN,
				CORN_SEEDS,
				TOMATO,
				TOMATO_SEEDS
			);
	}
	
	public static void registerModels() {
		CORN.registerItemModel();
		CORN_SEEDS.registerItemModel();
		TOMATO.registerItemModel();
		TOMATO_SEEDS.registerItemModel();
	}
}
