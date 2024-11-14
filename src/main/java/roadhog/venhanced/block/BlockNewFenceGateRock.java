package roadhog.venhanced.block;

import java.util.Random;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import roadhog.venhanced.VanillaEnhanced;

public class BlockNewFenceGateRock extends BlockFenceGate {

	final static String[] gates = new String[] {null, "Red", "Black"};

	@SideOnly(Side.CLIENT)
	private IIcon[] gateTexture;

	public BlockNewFenceGateRock(Material material)
	{
	    super();
	    this.setStepSound(soundTypeStone);
	    this.setHardness(2.0F);
	    this.setResistance(10.0F);
	    this.setHarvestLevel("pickaxe", 0);
	}

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
    	int i = 0;
    	if (this == VanillaEnhanced.blockFenceGateRedNetherBrick) {
    		i = 1;
    	} else if (this == VanillaEnhanced.blockFenceGateBlackNetherBrick) {
    		i = 2;
    	}
        return this.gateTexture[i];
    }
    
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		gateTexture = new IIcon[gates.length];

		gateTexture[0] = iconRegister.registerIcon("minecraft:nether_brick");
		for (int i = 1; i < gates.length; i++) {
			gateTexture[i] = iconRegister.registerIcon(VanillaEnhanced.modid + ":" + "blockNetherBrick" + gates[i]);
		}
		
	}
}
