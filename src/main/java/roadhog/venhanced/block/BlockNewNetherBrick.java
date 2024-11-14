package roadhog.venhanced.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import roadhog.venhanced.VanillaEnhanced;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockNewNetherBrick extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon[] texture;

	final static String[] metaBlocks = new String[] {"Cracked", "Bloody", "Black", "BlackCracked", "BlackBloody", "Red", "RedCracked", "RedBloody"};
	
	public BlockNewNetherBrick(Material material) {
		super(material);
		this.setHarvestLevel("pickaxe", 0);
		this.setHardness(2.0F);
		this.setResistance(30.0F);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		texture = new IIcon[metaBlocks.length];
		
		for (int i = 0; i < metaBlocks.length; i++) {
			texture[i] = iconRegister.registerIcon(VanillaEnhanced.modid + ":" + "blockNetherBrick" + metaBlocks[i]);
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
