package roadhog.venhanced.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GuiNewWorkbench extends GuiContainer {
	
    private static final ResourceLocation guiTexture = new ResourceLocation("textures/gui/container/crafting_table.png");

	public GuiNewWorkbench(InventoryPlayer inv, World world, int x, int y, int z) {
		super(new ContainerNewWorkbench(inv, world, x, y, z));
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	public void onGuiClosed(){
		super.onGuiClosed();
	}
	
	protected void drawGuiContainerForegroundLayer(int i, int j){
        this.fontRendererObj.drawString(I18n.format("container.crafting", new Object[0]), 28, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(guiTexture);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}

}
