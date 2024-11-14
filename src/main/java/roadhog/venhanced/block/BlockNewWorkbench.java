package roadhog.venhanced.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import roadhog.venhanced.VanillaEnhanced;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNewWorkbench extends Block {
	
	final static String[] metaBlocks = new String[] {"Spruce", "Birch", "Jungle", "Acacia", "BigOak"};
	final static String[] vanillaPlanks = new String[] {"spruce", "birch", "jungle", "acacia", "big_oak"};	
	
	public IIcon[] Side0;
	public IIcon[] Side1;
	public IIcon[] Side2;
	public IIcon[] Side3;

	public BlockNewWorkbench(Material material) {
		super(material);
		this.setHardness(2.5F);
		this.setHarvestLevel("axe", 0);
		this.setStepSound(soundTypeWood);
		this.setResistance(12.5F);
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon){
		
		Side0 = new IIcon[metaBlocks.length];
		Side1 = new IIcon[metaBlocks.length];
		Side2 = new IIcon[metaBlocks.length];
		Side3 = new IIcon[metaBlocks.length];
		
		for (int i = 0; i < metaBlocks.length; i++) {
		Side0[i] = icon.registerIcon("minecraft:planks_" + vanillaPlanks[i]);
		Side1[i] = icon.registerIcon("venh:blockCraftingTableTop" + metaBlocks[i]);
		Side2[i] = icon.registerIcon("venh:blockCraftingTableFront" + metaBlocks[i]);
		Side3[i] = icon.registerIcon("venh:blockCraftingTableSide" + metaBlocks[i]);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
		
		for (int i = 0; i < metaBlocks.length; i++) {
			list.add(new ItemStack(block, 1, i));
		}
		
	}
	
	public IIcon getIcon(int side, int meta){
		
		if(side == 0){
			if(meta < metaBlocks.length)
				return Side0[meta];
			else if(meta > metaBlocks.length);
				return Side0[0];
		}else if(side == 1){
			if(meta < metaBlocks.length)
				return Side1[meta];
			else if(meta > metaBlocks.length);
				return Side1[0];
		}else if(side == 2 || side == 4){
			if(meta < metaBlocks.length)
				return Side2[meta];
			else if(meta > metaBlocks.length);
				return Side2[0];
		}else if(side == 3 || side == 5){
			if(meta < metaBlocks.length)
				return Side3[meta];
			else if(meta > metaBlocks.length);
				return Side3[0];
		}
		return null;
	}
	
	public int damageDropped(int meta) {
		if(meta < metaBlocks.length)
		return meta;
		else if(meta > metaBlocks.length);
		return 0;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {

		if (!player.isSneaking()) {
			player.openGui(VanillaEnhanced.instance, VanillaEnhanced.guiID_BlockNewWorkbench, world, x, y, z);
			return true;
		}else{
			return false;
		}
	}
	
}
