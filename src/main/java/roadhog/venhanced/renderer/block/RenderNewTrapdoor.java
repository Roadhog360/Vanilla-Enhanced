package roadhog.venhanced.renderer.block;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.src.FMLRenderAccessLibrary;
import net.minecraft.world.IBlockAccess;
import roadhog.venhanced.VanillaEnhanced;

public class RenderNewTrapdoor implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		
		Tessellator tessellator = Tessellator.instance;
        float f = 0.1875F;
        float r = 0.0625F;
        float e = f - (r * 1.5F);
        
        if (block == VanillaEnhanced.blockTrapDoorLadder) {
    		GL11.glTranslatef(-.5F, -e + (r / 2F), -.5F);
    		renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, f - r, 1.0F);
        }
        else {
    		GL11.glTranslatef(-.5F, -e, -.5F);
    		renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
        }
		
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1.0F, 0.0F);
		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
		tessellator.setNormal(0.0F, 0.0F, -1.0F);
		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
		tessellator.setNormal(-1.0F, 0.0F, 0.0F);
		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
		tessellator.draw();
		
		GL11.glTranslatef(0, 0, 0);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {
		
		int l = renderer.blockAccess.getBlockMetadata(x, y, z);
        int j = block.colorMultiplier(renderer.blockAccess, x, y, z);
        float f = (float)(j >> 16 & 255) / 255.0F;
        float f1 = (float)(j >> 8 & 255) / 255.0F;
        float f2 = (float)(j & 255) / 255.0F;

        if (EntityRenderer.anaglyphEnable)
        {
            float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
            float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
            float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
            f = f3;
            f1 = f4;
            f2 = f5;
        }

        if (l <= 3) {
        	renderer.uvRotateEast = 3;
        	renderer.uvRotateWest = 3;
        	renderer.uvRotateSouth = 3;
        	renderer.uvRotateNorth = 3;
        } else if (l == 5 || l == 13) {
        	renderer.uvRotateSouth = 1;
        	renderer.uvRotateNorth = 2;
        	if (l == 5) {
            	renderer.uvRotateEast = 3;
            	renderer.uvRotateWest = 3;
        	}
        } else if (l == 4 || l == 12) {
        	renderer.uvRotateSouth = 2;
        	renderer.uvRotateNorth = 1;
        	if (l == 4) {
            	renderer.uvRotateEast = 3;
            	renderer.uvRotateWest = 3;
        	}
        } else if (l == 7 || l == 15) {
        	renderer.uvRotateEast = 1;
        	renderer.uvRotateWest = 2;
        	if (l == 7) {
            	renderer.uvRotateSouth = 3;
            	renderer.uvRotateNorth = 3;
        	}
        } else if (l == 6 || l == 14) {
        	renderer.uvRotateEast = 2;
        	renderer.uvRotateWest = 1;
        	if (l == 6) {
            	renderer.uvRotateSouth = 3;
            	renderer.uvRotateNorth = 3;
        	}
        }
        
        // 1 = west, 2 = east, 3 = north
        
        if (l == 0 || l == 4 || l == 8 || l == 12) {
        	renderer.uvRotateTop = 3;
        	renderer.uvRotateBottom = 3;
        } else if (l == 2 || l == 6 || l == 10 || l == 14) {
        	renderer.uvRotateTop = 1;
        	renderer.uvRotateBottom = 2;
        } else if (l == 3 || l == 7 || l == 11 || l == 15) {
        	renderer.uvRotateTop = 2;
        	renderer.uvRotateBottom = 1;
        }
        
    	boolean flag;
    	flag = Minecraft.isAmbientOcclusionEnabled() && block.getLightValue() == 0 ? (renderer.partialRenderBounds ? renderer.renderStandardBlockWithAmbientOcclusionPartial(block, x, y, z, f, f1, f2) : renderer.renderStandardBlockWithAmbientOcclusion(block, x, y, z, f, f1, f2)) : renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, f, f1, f2);
    	renderer.uvRotateTop = 0;
    	renderer.uvRotateBottom = 0;
    	renderer.uvRotateEast = 0;
    	renderer.uvRotateWest = 0;
    	renderer.uvRotateSouth = 0;
    	renderer.uvRotateNorth = 0;
        return flag;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return VanillaEnhanced.renderID_VenhTrapdoor;
	}

}
