package multiteam.advancedfarming.item;

import multiteam.advancedfarming.block.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	public static final ItemAF CORN = new ItemAF("corn").setCreativeTab(CreativeTabs.FOOD);
	public static final ItemAFSeed CORN_SEED = new ItemAFSeed("corn_seed", ModBlocks.CROP_CORN, Blocks.FARMLAND);
	public static final ItemAF TOMATO = new ItemAF("tomato").setCreativeTab(CreativeTabs.FOOD);
	public static final ItemAF TOMATO_SEED = new ItemAF("tomato_seed").setCreativeTab(CreativeTabs.FOOD);
	
	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				CORN,
				CORN_SEED,
				TOMATO,
				TOMATO_SEED
			);
	}
	
	public static void registerModels() {
		CORN.registerItemModel();
		CORN_SEED.registerItemModel();
		TOMATO.registerItemModel();
		TOMATO_SEED.registerItemModel();
	}
}
