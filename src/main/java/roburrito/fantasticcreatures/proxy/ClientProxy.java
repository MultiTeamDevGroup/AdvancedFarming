package roburrito.fantasticcreatures.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import roburrito.fantasticcreatures.FantasticCreatures;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(FantasticCreatures.MODID + ":" + id, "inventory"));
	}

	@Override
	public void registerEntityRenderer(Class<? extends Entity> entityClass, final Class<? extends Render> renderClass) {
		IRenderFactory factory = new IRenderFactory<Entity>(){
			@Override
			public Render createRenderFor(RenderManager manager) {
				try {
					return (Render) renderClass.getConstructor(RenderManager.class).newInstance(manager); 	
				} catch(Exception e) {
					e.printStackTrace();
				}
				return null;
			}
		};
		
		RenderingRegistry.registerEntityRenderingHandler(entityClass, factory);
	}
}