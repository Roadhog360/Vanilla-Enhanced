package roadhog.venhanced.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockBarkNew extends BlockLog {

	public static final String[] icons = new String[] {"acacia", "big_oak"};
	
	@SideOnly(Side.CLIENT)
	protected IIcon[] icon;
	
	public BlockBarkNew() {
		super();
		this.setHarvestLevel("axe", 0);
		this.setStepSound(soundTypeWood);
		this.setHardness(2.0F);
		this.setResistance(10.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	protected IIcon getSideIcon(int meta) {
		return this.icon[meta % icon.length];
	}

	@Override
	@SideOnly(Side.CLIENT)
	protected IIcon getTopIcon(int meta) {
		return this.icon[meta % icon.length];
	}

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.icon = new IIcon[icons.length];

        for (int i = 0; i < this.icons.length; ++i)
        {
			this.icon[i] = icon.registerIcon("minecraft:log_" + icons[i]);
        }
    }
	
	public int damageDropped(int meta) {
		return meta & 3;
	}
	
    public int quantityDropped(Random random)
    {
        return 1;
    }

    public Item getItemDropped(int unk1, Random random, int unk2)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public boolean isWood(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
    
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
		
		for (int i = 0; i < icon.length; i++) {
			list.add(new ItemStack(block, 1, i));
		}
	}
	
	public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
		return false;
	}

}
