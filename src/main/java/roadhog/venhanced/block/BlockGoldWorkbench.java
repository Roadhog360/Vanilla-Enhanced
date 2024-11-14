package roadhog.venhanced.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockGoldWorkbench extends Block {

	public IIcon Side0;
	public IIcon Side1;
	public IIcon Side2;
	public IIcon Side3;

	public BlockGoldWorkbench(Material material) {
		super(material);
		this.setStepSound(soundTypeMetal);
		this.setHarvestLevel("pickaxe", 0);
		this.setHardness(3F);
		this.setResistance(11.0F);
		
	}
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon){
		Side0 = icon.registerIcon("venh:blockCraftingTableBottomGold");
		Side1 = icon.registerIcon("venh:blockCraftingTableTopGold");
		Side2 = icon.registerIcon("venh:blockCraftingTableFrontGold");
		Side3 = icon.registerIcon("venh:blockCraftingTableSideGold");
	}
	
	public IIcon getIcon(int side, int meta){
		
		if(side == 0){
				return Side0;
		}else if(side == 1){
				return Side1;
		}else if(side == 2 || side == 4){
				return Side2;
		}else if(side == 3 || side == 5){
				return Side3;
		}
		return null;
	}
	
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        return false;
    }
}