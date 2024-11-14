package roadhog.venhanced.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockRedSandstone extends Block {

	final static String[] metaBlocks = new String[] {"Normal", "Carved", "Smooth"};

	public int metaLength = metaBlocks.length + 2;
	@SideOnly(Side.CLIENT)
	public IIcon Side0;
	@SideOnly(Side.CLIENT)
	public IIcon Side1;
	@SideOnly(Side.CLIENT)
	public IIcon[] Side2;

	public BlockRedSandstone(Material material) {
		super(material);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(Blocks.sandstone.stepSound);
		this.setHardness(0.8F);
		this.setResistance(4.0F);
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon){
		
		Side0 = icon.registerIcon(this.getTextureName() + "Bottom");
		Side1 = icon.registerIcon(this.getTextureName() + "Top");
		Side2 = new IIcon[metaBlocks.length];
		
		for (int i = 0; i < metaBlocks.length; i++) {
			Side2[i] = icon.registerIcon(this.getTextureName() + metaBlocks[i]);
		}
	}
	
	public IIcon getIcon(int side, int meta){
		if (meta < 3) {
			if(side == 0 && meta == 0){
				return Side0;
			}else if(side <= 1){
				return Side1;
			}else if(side > 1){
				return Side2[meta];
			}
		} else {
			return meta == 3 ? Side1 : Side0;
		}
		return null;
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
		for (int i = 0; i < metaLength; i++) {
			list.add(new ItemStack(block, 1, i));
		}
		
	}
	
	public int damageDropped(int meta) {
		if(meta < metaLength)
		return meta;
		else;
		return 0;
	}
	
}