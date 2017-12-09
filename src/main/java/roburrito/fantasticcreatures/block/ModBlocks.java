package roburrito.fantasticcreatures.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import roburrito.fantasticcreatures.FantasticCreatures;

public class ModBlocks {
	static CreativeTabs microTab = FantasticCreatures.microbiologyTab;
	
	public static BlockOre ORE_COPPER = new BlockOre("ore_copper", "oreCopper").setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	public static BlockPetriDish PETRI_DISH = new BlockPetriDish();
	
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				ORE_COPPER,
				PETRI_DISH
		);
		
		GameRegistry.registerTileEntity(PETRI_DISH.getTileEntityClass(), PETRI_DISH.getRegistryName().toString());
	}
	
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				ORE_COPPER.createItemBlock(),
				PETRI_DISH.createItemBlock()
		);
	}
	
	public static void registerModels() {
		ORE_COPPER.registerItemModel(Item.getItemFromBlock(ORE_COPPER));
		PETRI_DISH.registerItemModel(Item.getItemFromBlock(PETRI_DISH));
	}
}
