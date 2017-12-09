package roburrito.fantasticcreatures.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import roburrito.fantasticcreatures.client.model.ModelEquine;
import roburrito.fantasticcreatures.entity.EntityEquine;

@SideOnly(Side.CLIENT)
public class RenderEquine extends RenderLiving<EntityEquine> {

	private static final ResourceLocation EQUINE_TEXTURES = new ResourceLocation("textures/entity/equine/equine.png");
	
	public RenderEquine(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelEquine(), 0.5F);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityEquine entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
