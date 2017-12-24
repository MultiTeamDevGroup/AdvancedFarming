package multiteam.advancedfarming.item.crafting;

import com.google.gson.JsonObject;

import multiteam.advancedfarming.AdvancedFarming;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class OilPressRecipeFactory implements IRecipeFactory {

	@Override
	public IRecipe parse(JsonContext context, JsonObject json) {
		ShapelessOreRecipe recipe = ShapelessOreRecipe.factory(context, json);
		return new OilPressRecipe(new ResourceLocation(AdvancedFarming.MODID, "oil_press"), recipe.getRecipeOutput(), recipe.getIngredients().toArray());
	}
	
	public static class OilPressRecipe extends ShapelessOreRecipe {
		
		public OilPressRecipe(ResourceLocation group, ItemStack result, Object... recipe) {
			super(group, result, recipe);
		}
	}
}
