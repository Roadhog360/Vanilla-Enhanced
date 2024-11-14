package roadhog.venhanced.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSign;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import roadhog.venhanced.VanillaEnhanced;

public class BlockNewSign extends BlockSign {

	public Item signType;
    private Class field_149968_a;
    private boolean field_149967_b;

    final static String[] signs = new String[] {"spruce", "birch", "jungle", "acacia", "big_oak"};

    @SideOnly(Side.CLIENT)
    private IIcon[] signTexture;

	public BlockNewSign(Class tileEntity, boolean standing) {
		super(tileEntity, standing);
        this.field_149967_b = standing;
        this.field_149968_a = tileEntity;
        float f = 0.25F;
        float f1 = 1.0F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
        this.disableStats();
        this.setHardness(1.0F);
        this.setStepSound(soundTypeWood);
        this.setHarvestLevel("axe", 0);
        this.setCreativeTab(null);
	}

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
    	int i = 0;
    	if (this == VanillaEnhanced.blockWallSignBirch || this == VanillaEnhanced.blockStandingSignBirch) {
    		i = 1;
    	} else if (this == VanillaEnhanced.blockWallSignJungle || this == VanillaEnhanced.blockStandingSignJungle) {
    		i = 2;
    	} else if (this == VanillaEnhanced.blockWallSignAcacia || this == VanillaEnhanced.blockStandingSignAcacia) {
    		i = 3;
    	} else if (this == VanillaEnhanced.blockWallSignBigOak || this == VanillaEnhanced.blockStandingSignBigOak) {
    		i = 4;
    	}
        return this.signTexture[i];
    }
    
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		signTexture = new IIcon[signs.length];
		
		for (int i = 0; i < signs.length; i++) {
			signTexture[i] = iconRegister.registerIcon("minecraft:" + "planks_" + signs[i]);
		}
		
	}
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
    	signType = VanillaEnhanced.itemSignSpruce;
    	if (this == VanillaEnhanced.blockStandingSignBirch || this == VanillaEnhanced.blockWallSignBirch) {
        	signType = VanillaEnhanced.itemSignBirch;
    	} else if (this == VanillaEnhanced.blockStandingSignJungle || this == VanillaEnhanced.blockWallSignJungle) {
    		signType = VanillaEnhanced.itemSignJungle;
    	} else if (this == VanillaEnhanced.blockStandingSignAcacia || this == VanillaEnhanced.blockWallSignAcacia) {
    		signType = VanillaEnhanced.itemSignAcacia;
    	} else if (this == VanillaEnhanced.blockStandingSignBigOak || this == VanillaEnhanced.blockWallSignBigOak) {
    		signType = VanillaEnhanced.itemSignBigOak;
    	}
        return signType;
    }
    
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
    	signType = VanillaEnhanced.itemSignSpruce;
    	if (this == VanillaEnhanced.blockStandingSignBirch || this == VanillaEnhanced.blockWallSignBirch) {
        	signType = VanillaEnhanced.itemSignBirch;
    	} else if (this == VanillaEnhanced.blockStandingSignJungle || this == VanillaEnhanced.blockWallSignJungle) {
    		signType = VanillaEnhanced.itemSignJungle;
    	} else if (this == VanillaEnhanced.blockStandingSignAcacia || this == VanillaEnhanced.blockWallSignAcacia) {
    		signType = VanillaEnhanced.itemSignAcacia;
    	} else if (this == VanillaEnhanced.blockStandingSignBigOak || this == VanillaEnhanced.blockWallSignBigOak) {
    		signType = VanillaEnhanced.itemSignBigOak;
    	}
        return signType;
    }
}
