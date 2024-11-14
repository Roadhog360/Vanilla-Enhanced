package roadhog.venhanced.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import roadhog.venhanced.VanillaEnhanced;

public class GuiMacerator extends GuiContainer {

    private static final ResourceLocation guiTexture = new ResourceLocation("venh:textures/gui/macerator.png");

	public GuiMacerator(InventoryPlayer inv, World world, int x, int y, int z) {
		super(new ContainerMacerator(inv, world, x, y, z));
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	public void onGuiClosed(){
		super.onGuiClosed();
	}
	
	protected void drawGuiContainerForegroundLayer(int i, int j){
        this.fontRendererObj.drawString(I18n.format("tile.BlockMacerator.name", new Object[0]), 61, 5, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(guiTexture);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}

}
