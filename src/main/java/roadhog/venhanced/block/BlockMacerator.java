package roadhog.venhanced.block;

import java.util.List;

import roadhog.venhanced.VanillaEnhanced;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockMacerator extends Block {
	
	public IIcon Side0;
	public IIcon Side1;
	public IIcon Side2;

	public BlockMacerator(Material material) {
		super(material);
		this.setHardness(3.5F);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(soundTypeStone);
		this.setResistance(12.5F);
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon){
		Side0 = icon.registerIcon("minecraft:furnace_top");
		Side1 = icon.registerIcon("venh:blockMaceratorTop");
		Side2 = icon.registerIcon("minecraft:furnace_side");
	}
	
	public IIcon getIcon(int side, int meta){
		
		if(side == 0){
			return Side0;
		}else if(side == 1){
			return Side1;
		}else if(side >= 2){
			return Side2;	
		}
		return null;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {

		if (!player.isSneaking()) {
			player.openGui(VanillaEnhanced.instance, VanillaEnhanced.guiID_BlockMacerator, world, x, y, z);
			return true;
		}else{
			return false;
		}
	}
	
}