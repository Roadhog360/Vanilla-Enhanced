package roadhog.venhanced.block;

import java.util.List;

import roadhog.venhanced.VanillaEnhanced;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockConcrete extends Block {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] texture;
	
	final static String[] metaBlocks = new String[] {"White", "Orange", "Magenta", "LightBlue", "Yellow", "Lime", "Pink", "Grey", "Silver", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black"};

	public BlockConcrete(Material material) {
		super(material);
		this.setHarvestLevel("pickaxe", 0);
		this.setHardness(1.8F);
		this.setResistance(9.0F);
		this.setStepSound(soundTypeStone);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		texture = new IIcon[metaBlocks.length];
		
		for (int i = 0; i < metaBlocks.length; i++) {
			texture[i] = iconRegister.registerIcon(VanillaEnhanced.modid + ":" + "blockConcrete" + metaBlocks[i]);
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
	
