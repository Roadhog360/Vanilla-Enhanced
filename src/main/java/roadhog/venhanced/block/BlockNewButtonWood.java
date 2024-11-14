package roadhog.venhanced.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockButtonWood;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import roadhog.venhanced.VanillaEnhanced;

public class BlockNewButtonWood extends BlockButtonWood {

final static String[] buttons = new String[] {"spruce", "birch", "jungle", "acacia", "big_oak"};

@SideOnly(Side.CLIENT)
private IIcon[] buttonTexture;

	public BlockNewButtonWood() {
        super();
		this.setHardness(0.5F);
		this.setStepSound(soundTypeWood);
	}
	

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
    	int i = 0;
    	if (this == VanillaEnhanced.blockButtonBirch) {
    		i = 1;
    	} else if (this == VanillaEnhanced.blockButtonJungle) {
    		i = 2;
    	} else if (this == VanillaEnhanced.blockButtonAcacia) {
    		i = 3;
    	} else if (this == VanillaEnhanced.blockButtonBigOak) {
    		i = 4;
    	}
        return this.buttonTexture[i];
    }
    
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		buttonTexture = new IIcon[buttons.length];
		
		for (int i = 0; i < buttons.length; i++) {
			buttonTexture[i] = iconRegister.registerIcon("minecraft:" + "planks_" + buttons[i]);
		}
		
	}

}
