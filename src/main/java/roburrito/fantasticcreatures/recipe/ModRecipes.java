package roburrito.fantasticcreatures.recipe;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import roburrito.fantasticcreatures.block.ModBlocks;
import roburrito.fantasticcreatures.item.ModItems;

public class ModRecipes {
	public static void init() {
		GameRegistry.addSmelting(ModBlocks.ORE_COPPER, new ItemStack(ModItems.INGOT_COPPER), 0.7f);
	}
}
