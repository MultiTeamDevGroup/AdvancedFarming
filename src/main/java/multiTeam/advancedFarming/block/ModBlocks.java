package multiteam.advancedfarming.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
	public static BlockCropCorn CROP_CORN = new BlockCropCorn();
	public static BlockCropTomato CROP_TOMATO = new BlockCropTomato();
	
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				CROP_CORN,
				CROP_TOMATO
		);
		
	}
	
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		
	}
	
	public static void registerModels() {
		
	}
}
