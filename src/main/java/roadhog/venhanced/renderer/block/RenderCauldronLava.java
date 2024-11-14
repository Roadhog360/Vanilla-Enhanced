package roadhog.venhanced.renderer.block;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import roadhog.venhanced.VanillaEnhanced;

public class RenderCauldronLava implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {
		renderer.renderStandardBlock(VanillaEnhanced.blockCauldronLava, x, y, z);
	    {
	    	renderer.renderBlockCauldron(Blocks.cauldron, x, y, z);
            IIcon lava = BlockLiquid.getLiquidIcon("lava_still");
	        renderer.renderFaceYPos(block, (double)x, (double)((float)y - 1.0F + (.0625 * 15F)), (double)z, lava);
	        return true;
	    }
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return VanillaEnhanced.renderID_CauldronLava;
	}

}
