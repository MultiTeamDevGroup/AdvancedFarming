package multiteam.advancedfarming.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
	public static BlockCropDouble CROP_CORN = new BlockCropDouble();
	
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				CROP_CORN
		);
		
	}
	
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		
	}
	
	public static void registerModels() {
		
	}
}
