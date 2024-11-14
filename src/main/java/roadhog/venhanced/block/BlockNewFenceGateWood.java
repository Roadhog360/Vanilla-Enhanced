package roadhog.venhanced.block;

import java.util.Random;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import roadhog.venhanced.VanillaEnhanced;

public class BlockNewFenceGateWood extends BlockFenceGate {
	
final static String[] gates = new String[] {"spruce", "birch", "jungle", "acacia", "big_oak"};

@SideOnly(Side.CLIENT)
private IIcon[] gateTexture;

    public BlockNewFenceGateWood()
    {
        super();
        this.setStepSound(soundTypeWood);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("axe", 0);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
    	int i = 0;
    	if (this == VanillaEnhanced.blockFenceGateBirch) {
    		i = 1;
    	} else if (this == VanillaEnhanced.blockFenceGateJungle) {
    		i = 2;
    	} else if (this == VanillaEnhanced.blockFenceGateAcacia) {
    		i = 3;
    	} else if (this == VanillaEnhanced.blockFenceGateBigOak) {
    		i = 4;
    	}
        return this.gateTexture[i];
    }
    
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		gateTexture = new IIcon[gates.length];
		
		for (int i = 0; i < gates.length; i++) {
			gateTexture[i] = iconRegister.registerIcon("minecraft:" + "planks_" + gates[i]);
		}
		
	}

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
    	this.onBlockAdded(world, x, y, z);
    	Blocks.fence_gate.onNeighborBlockChange(world, x, y, z, block);
    }

}
