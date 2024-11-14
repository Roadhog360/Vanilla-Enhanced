package roadhog.venhanced.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelSign;
import net.minecraft.client.renderer.tileentity.TileEntitySignRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.ResourceLocation;
import roadhog.venhanced.VanillaEnhanced;
import roadhog.venhanced.tileentity.TileEntityNewSign;

public class RenderNewSign extends TileEntitySpecialRenderer {
	
    private ResourceLocation signTexture;
    private final ModelSign field_147514_c = new ModelSign();
    
    /*
     * Gets the sign's type, and sets a chosen texture to the signTexture variable.
     * If it's a dark oak sign, this returns true, which is used in renderTileEntityAt
     * to display white text on the sign.
     */
    private boolean signType(TileEntityNewSign sign) {
        Block block = sign.getBlockType();
        boolean isBigOak = false;
    	
    	signTexture = new ResourceLocation("venh:textures/entity/sign_spruce.png");
    	if (block == VanillaEnhanced.blockStandingSignBirch || block == VanillaEnhanced.blockWallSignBirch) {
        	signTexture = new ResourceLocation("venh:textures/entity/sign_birch.png");
    	} else if (block == VanillaEnhanced.blockStandingSignJungle || block == VanillaEnhanced.blockWallSignJungle) {
    		signTexture = new ResourceLocation("venh:textures/entity/sign_jungle.png");
    	} else if (block == VanillaEnhanced.blockStandingSignAcacia || block == VanillaEnhanced.blockWallSignAcacia) {
    		signTexture = new ResourceLocation("venh:textures/entity/sign_acacia.png");
    	} else if (block == VanillaEnhanced.blockStandingSignBigOak || block == VanillaEnhanced.blockWallSignBigOak) {
    		signTexture = new ResourceLocation("venh:textures/entity/sign_big_oak.png");
    		isBigOak = true;
    	}
    	return isBigOak;
    }
    

	/*
	 * The following code is derived from Mojang's original sign code as I had no other choice as there was
	 * no way for me to add in my texture without copying most of the code to add my own code to this class.
	 * Extending the block class was not enough, since I had to copy this code anyways.
	 * I, in no way, take credit for the majority of this code. I only altered it to work with my blocks and
	 * textures.
	 */
    public void renderTileEntityAt(TileEntityNewSign p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_)
    {
        Block block = p_147500_1_.getBlockType();
        GL11.glPushMatrix();
        float f1 = 0.6666667F;
        float f3;

        if (block == VanillaEnhanced.blockStandingSignSpruce ||
        		block == VanillaEnhanced.blockStandingSignBirch ||
        		block == VanillaEnhanced.blockStandingSignJungle ||
        		block == VanillaEnhanced.blockStandingSignAcacia ||
        		block == VanillaEnhanced.blockStandingSignBigOak)
        {
            GL11.glTranslatef((float)p_147500_2_ + 0.5F, (float)p_147500_4_ + 0.75F * f1, (float)p_147500_6_ + 0.5F);
            float f2 = (float)(p_147500_1_.getBlockMetadata() * 360) / 16.0F;
            GL11.glRotatef(-f2, 0.0F, 1.0F, 0.0F);
            this.field_147514_c.signStick.showModel = true;
        }
        else
        {
            int j = p_147500_1_.getBlockMetadata();
            f3 = 0.0F;

            if (j == 2)
            {
                f3 = 180.0F;
            }

            if (j == 4)
            {
                f3 = 90.0F;
            }

            if (j == 5)
            {
                f3 = -90.0F;
            }

            GL11.glTranslatef((float)p_147500_2_ + 0.5F, (float)p_147500_4_ + 0.75F * f1, (float)p_147500_6_ + 0.5F);
            GL11.glRotatef(-f3, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, -0.3125F, -0.4375F);
            this.field_147514_c.signStick.showModel = false;
        }

        this.signType(p_147500_1_);
        this.bindTexture(signTexture);
        GL11.glPushMatrix();
        GL11.glScalef(f1, -f1, -f1);
        this.field_147514_c.renderSign();
        GL11.glPopMatrix();
        FontRenderer fontrenderer = this.func_147498_b();
        f3 = 0.016666668F * f1;
        GL11.glTranslatef(0.0F, 0.5F * f1, 0.07F * f1);
        GL11.glScalef(f3, -f3, f3);
        GL11.glNormal3f(0.0F, 0.0F, -1.0F * f3);
        GL11.glDepthMask(false);
        byte b0 = 0;

        for (int i = 0; i < p_147500_1_.signText.length; ++i)
        {
        	String colour = "";
        	if (signType(p_147500_1_)) {
        		colour = "\u00A7f";
        	}
            String s = colour + p_147500_1_.signText[i];

            if (i == p_147500_1_.lineBeingEdited)
            {
            		s = "> " + s + " <";
                fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, i * 10 - p_147500_1_.signText.length * 5, b0);
            }
            else
            {
                fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, i * 10 - p_147500_1_.signText.length * 5, b0);
            }
        }

        GL11.glDepthMask(true);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPopMatrix();
    }
    
    public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_)
    {
        this.renderTileEntityAt((TileEntityNewSign)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
    }

}
