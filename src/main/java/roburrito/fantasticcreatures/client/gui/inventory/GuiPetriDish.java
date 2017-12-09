package roburrito.fantasticcreatures.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import roburrito.fantasticcreatures.FantasticCreatures;
import roburrito.fantasticcreatures.block.ModBlocks;

public class GuiPetriDish extends GuiContainer {
	private InventoryPlayer playerInv;
	
	private static final ResourceLocation BG_TEXTURE = new ResourceLocation(FantasticCreatures.MODID, "textures/gui/petri_dish.png");
	
	public GuiPetriDish (Container container, InventoryPlayer playerInv) {
		super(container);
		this.playerInv = playerInv;
		System.out.println("I'm a petri dish! So gooey!");
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String name = I18n.format(ModBlocks.PETRI_DISH.getUnlocalizedName() + ".name");
		fontRenderer.drawString(name, xSize / 2 - fontRenderer.getStringWidth(name) / 2, 6, 0x404040);
		fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 94, 0x404040);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1, 1, 1, 1);
		mc.getTextureManager().bindTexture(BG_TEXTURE);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}
