package roadhog.venhanced.renderer.block;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import roadhog.venhanced.VanillaEnhanced;

public class RenderLantern implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {
	    {
	        Tessellator tessellator = Tessellator.instance;
	        tessellator.setBrightness(block.getMixedBrightnessForBlock(renderer.blockAccess, x, y, z));
	        int l = block.colorMultiplier(renderer.blockAccess, x, y, z);
	        IIcon iicon = renderer.getBlockIcon(VanillaEnhanced.blockLantern);
	        float f = (float)(l >> 16 & 255) / 255.0F;
	        float f1 = (float)(l >> 8 & 255) / 255.0F;
	        float f2 = (float)(l & 255) / 255.0F;
	        float f3;

	        if (EntityRenderer.anaglyphEnable)
	        {
	            f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
	            float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
	            float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
	            f = f3;
	            f1 = f4;
	            f2 = f5;
	        }

	        tessellator.setColorOpaque_F(f, f1, f2);
	        f3 = 0.1865F;

	        if (l != 16777215)
	        {
	            f = (float)(l >> 16 & 255) / 255.0F;
	            f1 = (float)(l >> 8 & 255) / 255.0F;
	            f2 = (float)(l & 255) / 255.0F;
	            tessellator.setColorOpaque_F(f, f1, f2);
	        }
	        
	        this.renderLanternUVs(world, x, y, z, block, modelId, renderer);
	    }

        return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return VanillaEnhanced.renderID_Lantern;
	}
	
	public void renderLanternUVs(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {
        IIcon iicon = renderer.getBlockIcon(VanillaEnhanced.blockLantern);
        Tessellator tessellator = Tessellator.instance;
    	float r = 0.0625F;
        int i = world.getBlockMetadata(x, y, z);
        
		//Sides of main block
		double iIntU = iicon.getInterpolatedU(0);
		double iIntV = iicon.getInterpolatedV(2);
		
		double iIntU1 = iicon.getInterpolatedU(6);
		double iIntV1 = iicon.getInterpolatedV(9);
		
		tessellator.addVertexWithUV(x + (r * 5D), y + (r * (double)i), z + (r * 11D), iIntU, iIntV1);
		tessellator.addVertexWithUV(x + (r * 5D), y + (r * (7D + (double)i)), z + (r * 11D), iIntU, iIntV);
		tessellator.addVertexWithUV(x + (r * 5D), y + (r * (7D + (double)i)), z + (r * 5D), iIntU1, iIntV);
		tessellator.addVertexWithUV(x + (r * 5D), y + (r * (double)i),  z + (r * 5D), iIntU1, iIntV1);
		
		tessellator.addVertexWithUV(x + (r * 11D), y + (r * (double)i), z + (r * 5D), iIntU, iIntV1);
		tessellator.addVertexWithUV(x + (r * 11D), y + (r * (7D + (double)i)), z + (r * 5D), iIntU, iIntV);
		tessellator.addVertexWithUV(x + (r * 11D), y + (r * (7D + (double)i)), z + (r * 11D), iIntU1, iIntV);
		tessellator.addVertexWithUV(x + (r * 11D), y + (r * (double)i),  z + (r * 11D), iIntU1, iIntV1);

		tessellator.addVertexWithUV(x + (r * 5D), y + (r * (double)i), z + (r * 5D), iIntU, iIntV1);
		tessellator.addVertexWithUV(x + (r * 5D), y + (r * (7D + (double)i)), z + (r * 5D), iIntU, iIntV);
		tessellator.addVertexWithUV(x + (r * 11D), y + (r * (7D + (double)i)), z + (r * 5D), iIntU1, iIntV);
		tessellator.addVertexWithUV(x + (r * 11D), y + (r * (double)i),  z + (r * 5D), iIntU1, iIntV1);

		tessellator.addVertexWithUV(x + (r * 11D), y + (r * (double)i), z + (r * 11D), iIntU, iIntV1);
		tessellator.addVertexWithUV(x + (r * 11D), y + (r * (7D + (double)i)), z + (r * 11D), iIntU, iIntV);
		tessellator.addVertexWithUV(x + (r * 5D), y + (r * (7D + (double)i)), z + (r * 11D), iIntU1, iIntV);
		tessellator.addVertexWithUV(x + (r * 5D), y + (r * (double)i),  z + (r * 11D), iIntU1, iIntV1);
		
		//Top/Bottom of main block
		double iIntU2 = iicon.getInterpolatedU(0);
		double iIntV2 = iicon.getInterpolatedV(9);
		
		double iIntU3 = iicon.getInterpolatedU(6);
		double iIntV3 = iicon.getInterpolatedV(15);
		
		tessellator.addVertexWithUV(x + (r * 5D), y + (r * (7D + (double)i)), z + (r * 5D), iIntU2, iIntV3);
		tessellator.addVertexWithUV(x + (r * 5D), y + (r * (7D + (double)i)), z + (r * 11D), iIntU2, iIntV2);
		tessellator.addVertexWithUV(x + (r * 11D), y + (r * (7D + (double)i)), z + (r * 11D), iIntU3, iIntV2);
		tessellator.addVertexWithUV(x + (r * 11D), y + (r * (7D + (double)i)),  z + (r * 5D), iIntU3, iIntV3);

		tessellator.addVertexWithUV(x + (r * 5D), y + (r * (double)i), z + (r * 11D), iIntU2, iIntV3);
		tessellator.addVertexWithUV(x + (r * 5D), y + (r * (double)i), z + (r * 5D), iIntU2, iIntV2);
		tessellator.addVertexWithUV(x + (r * 11D), y + (r * (double)i), z + (r * 5D), iIntU3, iIntV2);
		tessellator.addVertexWithUV(x + (r * 11D), y + (r * (double)i),  z + (r * 11D), iIntU3, iIntV3);
		
		//Sides of lantern top piece
		double iIntU4 = iicon.getInterpolatedU(1);
		double iIntV4 = iicon.getInterpolatedV(0);
		
		double iIntU5 = iicon.getInterpolatedU(5);
		double iIntV5 = iicon.getInterpolatedV(2);
		
		tessellator.addVertexWithUV(x + (r * 6D), y + (r * (7D + (double)i)), z + (r * 10D), iIntU4, iIntV5);
		tessellator.addVertexWithUV(x + (r * 6D), y + (r * (9D + (double)i)), z + (r * 10D), iIntU4, iIntV4);
		tessellator.addVertexWithUV(x + (r * 6D), y + (r * (9D + (double)i)), z + (r * 6D), iIntU5, iIntV4);
		tessellator.addVertexWithUV(x + (r * 6D), y + (r * (7D + (double)i)),  z + (r * 6D), iIntU5, iIntV5);
		
		tessellator.addVertexWithUV(x + (r * 10D), y + (r * (7D + (double)i)), z + (r * 6D), iIntU4, iIntV5);
		tessellator.addVertexWithUV(x + (r * 10D), y + (r * (9D + (double)i)), z + (r * 6D), iIntU4, iIntV4);
		tessellator.addVertexWithUV(x + (r * 10D), y + (r * (9D + (double)i)), z + (r * 10D), iIntU5, iIntV4);
		tessellator.addVertexWithUV(x + (r * 10D), y + (r * (7D + (double)i)),  z + (r * 10D), iIntU5, iIntV5);

		tessellator.addVertexWithUV(x + (r * 6D), y + (r * (7D + (double)i)), z + (r * 6D), iIntU4, iIntV5);
		tessellator.addVertexWithUV(x + (r * 6D), y + (r * (9D + (double)i)), z + (r * 6D), iIntU4, iIntV4);
		tessellator.addVertexWithUV(x + (r * 10D), y + (r * (9D + (double)i)), z + (r * 6D), iIntU5, iIntV4);
		tessellator.addVertexWithUV(x + (r * 10D), y + (r * (7D + (double)i)),  z + (r * 6D), iIntU5, iIntV5);

		tessellator.addVertexWithUV(x + (r * 10D), y + (r * (7D + (double)i)), z + (r * 10D), iIntU4, iIntV5);
		tessellator.addVertexWithUV(x + (r * 10D), y + (r * (9D + (double)i)), z + (r * 10D), iIntU4, iIntV4);
		tessellator.addVertexWithUV(x + (r * 6D), y + (r * (9D + (double)i)), z + (r * 10D), iIntU5, iIntV4);
		tessellator.addVertexWithUV(x + (r * 6D), y + (r * (7D + (double)i)),  z + (r * 10D), iIntU5, iIntV5);
		
		//Top/Bottom of main block
		double iIntU6 = iicon.getInterpolatedU(1);
		double iIntV6 = iicon.getInterpolatedV(10);
		
		double iIntU7 = iicon.getInterpolatedU(5);
		double iIntV7 = iicon.getInterpolatedV(14);
		
		tessellator.addVertexWithUV(x + (r * 6D), y + (r * (9D + (double)i)), z + (r * 6D), iIntU6, iIntV7);
		tessellator.addVertexWithUV(x + (r * 6D), y + (r * (9D + (double)i)), z + (r * 10D), iIntU6, iIntV6);
		tessellator.addVertexWithUV(x + (r * 10D), y + (r * (9D + (double)i)), z + (r * 10D), iIntU7, iIntV6);
		tessellator.addVertexWithUV(x + (r * 10D), y + (r * (9D + (double)i)),  z + (r * 6D), iIntU7, iIntV7);
		
		//Lantern chain
		double iIntU8 = iicon.getInterpolatedU(11);
		double iIntV8 = iicon.getInterpolatedV(10);
		
		double iIntU9 = iicon.getInterpolatedU(14);
		double iIntV9 = iicon.getInterpolatedV(12);
		
		tessellator.addVertexWithUV(x + (r * 7D), y + (r * (9D + (double)i)), z + (r * 7D), iIntU8, iIntV9);
		tessellator.addVertexWithUV(x + (r * 7D), y + (r * (11D + (double)i)), z + (r * 7D), iIntU8, iIntV8);
		tessellator.addVertexWithUV(x + (r * 9D), y + (r * (11D + (double)i)), z + (r * 9D), iIntU9, iIntV8);
		tessellator.addVertexWithUV(x + (r * 9D), y + (r * (9D + (double)i)),  z + (r * 9D), iIntU9, iIntV9);

		tessellator.addVertexWithUV(x + (r * 9D), y + (r * (9D + (double)i)), z + (r * 9D), iIntU8, iIntV9);
		tessellator.addVertexWithUV(x + (r * 9D), y + (r * (11D + (double)i)), z + (r * 9D), iIntU8, iIntV8);
		tessellator.addVertexWithUV(x + (r * 7D), y + (r * (11D + (double)i)), z + (r * 7D), iIntU9, iIntV8);
		tessellator.addVertexWithUV(x + (r * 7D), y + (r * (9D + (double)i)),  z + (r * 7D), iIntU9, iIntV9);

		//If meta is not 0, the other parts of the chain will appear
		if (world.getBlockMetadata(x, y, z) == 0) {
			tessellator.addVertexWithUV(x + (r * 7D), y + (r * 9D), z + (r * 9D), iIntU8, iIntV9);
			tessellator.addVertexWithUV(x + (r * 7D), y + (r * 11D), z + (r * 9D), iIntU8, iIntV8);
			tessellator.addVertexWithUV(x + (r * 9D), y + (r * 11D), z + (r * 7D), iIntU9, iIntV8);
			tessellator.addVertexWithUV(x + (r * 9D), y + (r * 9D),  z + (r * 7D), iIntU9, iIntV9);

			tessellator.addVertexWithUV(x + (r * 9D), y + (r * 9D), z + (r * 7D), iIntU8, iIntV9);
			tessellator.addVertexWithUV(x + (r * 9D), y + (r * 11D), z + (r * 7D), iIntU8, iIntV8);
			tessellator.addVertexWithUV(x + (r * 7D), y + (r * 11D), z + (r * 9D), iIntU9, iIntV8);
			tessellator.addVertexWithUV(x + (r * 7D), y + (r * 9D),  z + (r * 9D), iIntU9, iIntV9);
		} else {
			double iIntU10 = iicon.getInterpolatedU(11);
			double iIntV10 = iicon.getInterpolatedV(1);
			
			double iIntU11 = iicon.getInterpolatedU(14);
			double iIntV11 = iicon.getInterpolatedV(5);
			
			tessellator.addVertexWithUV(x + (r * 9D), y + (r * 11D), z + (r * 7D), iIntU10, iIntV11);
			tessellator.addVertexWithUV(x + (r * 9D), y + (r * 15D), z + (r * 7D), iIntU10, iIntV10);
			tessellator.addVertexWithUV(x + (r * 7D), y + (r * 15D), z + (r * 9D), iIntU11, iIntV10);
			tessellator.addVertexWithUV(x + (r * 7D), y + (r * 11D),  z + (r * 9D), iIntU11, iIntV11);

			tessellator.addVertexWithUV(x + (r * 7D), y + (r * 11D), z + (r * 9D), iIntU10, iIntV11);
			tessellator.addVertexWithUV(x + (r * 7D), y + (r * 15D), z + (r * 9D), iIntU10, iIntV10);
			tessellator.addVertexWithUV(x + (r * 9D), y + (r * 15D), z + (r * 7D), iIntU11, iIntV10);
			tessellator.addVertexWithUV(x + (r * 9D), y + (r * 11D),  z + (r * 7D), iIntU11, iIntV11);

			double iIntU12 = iicon.getInterpolatedU(11);
			double iIntV12 = iicon.getInterpolatedV(6);
			
			double iIntU13 = iicon.getInterpolatedU(14);
			double iIntV13 = iicon.getInterpolatedV(8);
			
			tessellator.addVertexWithUV(x + (r * 7D), y + (r * 14D), z + (r * 7D), iIntU12, iIntV13);
			tessellator.addVertexWithUV(x + (r * 7D), y + (r * 16D), z + (r * 7D), iIntU12, iIntV12);
			tessellator.addVertexWithUV(x + (r * 9D), y + (r * 16D), z + (r * 9D), iIntU13, iIntV12);
			tessellator.addVertexWithUV(x + (r * 9D), y + (r * 14D),  z + (r * 9D), iIntU13, iIntV13);

			tessellator.addVertexWithUV(x + (r * 9D), y + (r * 14D), z + (r * 9D), iIntU12, iIntV13);
			tessellator.addVertexWithUV(x + (r * 9D), y + (r * 16D), z + (r * 9D), iIntU12, iIntV12);
			tessellator.addVertexWithUV(x + (r * 7D), y + (r * 16D), z + (r * 7D), iIntU13, iIntV12);
			tessellator.addVertexWithUV(x + (r * 7D), y + (r * 14D),  z + (r * 7D), iIntU13, iIntV13);
		}
	}

}
