package roadhog.venhanced.block;

import java.util.List;
import java.util.Random;

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

public class BlockConcretePowder extends BlockFalling {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] texture;
	
	final static String[] metaBlocks = new String[] {"White", "Orange", "Magenta", "LightBlue", "Yellow", "Lime", "Pink", "Grey", "Silver", "Cyan", "Purple", "Blue", "Brown", "Green", "Red", "Black"};

	public BlockConcretePowder(Material material) {
		super(material);
		this.setHarvestLevel("shovel", 0);
		this.setHardness(0.5F);
		this.setResistance(2.5F);
		this.setStepSound(soundTypeSand);
        this.setTickRandomly(true);
		
	}
    public void onBlockAdded(World world, int x, int y, int z)
    {
        world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
        this.setBlock(world, x, y, z);
    }
        	
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
        this.setBlock(world, x, y, z);
    }
	
    private void setBlock(World world, int x, int y, int z)
    {
                boolean flag = false;

                if (flag || world.getBlock(x, y, z - 1).getMaterial() == Material.water)
                {
                    flag = true;
                }

                if (flag || world.getBlock(x, y, z + 1).getMaterial() == Material.water)
                {
                    flag = true;
                }

                if (flag || world.getBlock(x - 1, y, z).getMaterial() == Material.water)
                {
                    flag = true;
                }

                if (flag || world.getBlock(x + 1, y, z).getMaterial() == Material.water)
                {
                    flag = true;
                }

                if (flag || world.getBlock(x, y + 1, z).getMaterial() == Material.water)
                {
                    flag = true;
                }

                if (flag)
                {
                    int l = world.getBlockMetadata(x, y, z);
                    	world.setBlock(x, y, z, VanillaEnhanced.blockConcrete, l, 2);
                    	world.markBlockForUpdate(x, y, z);
                    }
                if (world.getBlock(x, y, z) == VanillaEnhanced.blockConcrete) {
                	world.markBlockForUpdate(x, y, z);
                }
                
    		}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		texture = new IIcon[metaBlocks.length];
		
		for (int i = 0; i < metaBlocks.length; i++) {
			texture[i] = iconRegister.registerIcon(VanillaEnhanced.modid + ":" + "blockConcretePowder" + metaBlocks[i]);
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
	
