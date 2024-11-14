package roadhog.venhanced.block;

import java.util.List;

import roadhog.venhanced.VanillaEnhanced;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockMetal extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon[] texture;
	
	final static String[] metaBlocks = new String[] {"Tin", "Copper", "Osmium", "Iridium", "Bronze", "Steel"};

	public BlockMetal(Material material) {
		super(material);
		this.setStepSound(soundTypeMetal);
		this.setHardness(5.5F);
		this.setResistance(15.0F);
		setHarvestLevel("pickaxe", 0);
		setHarvestLevel("pickaxe", 1, 1);
		setHarvestLevel("pickaxe", 2, 2);
		setHarvestLevel("pickaxe", 2, 3);
		setHarvestLevel("pickaxe", 1, 4);
		setHarvestLevel("pickaxe", 1, 5);
		setHarvestLevel("pickaxe", 1, 6);
		
	}

    public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
    {
        return this == VanillaEnhanced.blockMetal;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		texture = new IIcon[metaBlocks.length];
		
		for (int i = 0; i < metaBlocks.length; i++) {
			texture[i] = iconRegister.registerIcon(VanillaEnhanced.modid + ":" + "block" + metaBlocks[i]);
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
		
		for (int i = 0; i < metaBlocks.length; i++) {
			list.add(new ItemStack(block, 1, i));
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if(meta < metaBlocks.length)
			return texture[meta];
		else if(meta > metaBlocks.length);
			return texture[0];
		}
	
	public int damageDropped(int meta) {
		if(meta < metaBlocks.length)
		return meta;
		else if(meta > metaBlocks.length);
		return 0;
	}
	
}

