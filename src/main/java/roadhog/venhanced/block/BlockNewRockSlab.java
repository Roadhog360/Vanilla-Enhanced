package roadhog.venhanced.block;

import java.util.List;
import java.util.Random;

import roadhog.venhanced.VanillaEnhanced;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockNewRockSlab extends BlockSlab {

    public static final String[] field_150006_b = new String[] {"RedNetherBrick", "BlackNetherBrick", "RedSandstone"};
	
    @SideOnly(Side.CLIENT)
    private IIcon field_150007_M;
    protected boolean field_150004_a;
    
	public BlockNewRockSlab(boolean isDouble, Material material) {
		super(isDouble, material);
		this.setHarvestLevel("pickaxe", 0);
		this.setHardness(2.0F);
		this.setResistance(30.0F);

        field_150004_a = isDouble;

        if (isDouble)
        {
            this.opaque = true;
        }
        else
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            this.useNeighborBrightness = true;
        }

        this.setLightOpacity(255);
        
	}

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {

        IIcon[] blocks = new IIcon[] {
        		VanillaEnhanced.blockNewNetherBrick.getIcon(0, 5),
        		VanillaEnhanced.blockNewNetherBrick.getIcon(0, 2),
        		VanillaEnhanced.blockRedSandstone.getIcon(side, 0)};
    	
        int k = meta & 7;

        return blocks[k >= blocks.length ? 0 : k];
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(VanillaEnhanced.blockNewRockSlab);
    }

    public String func_150002_b(int meta)
    {
    	meta = meta >= field_150006_b.length ? 0 : meta;
        return super.getUnlocalizedName() + "." + field_150006_b[meta];
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        for (int i = 0; i < field_150006_b.length; ++i)
        {
            p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
        }
    }

    public int damageDropped(int p_149692_1_)
    {
        return p_149692_1_ & 7;
    }
    
    public boolean renderAsNormalBlock()
    {
        return this.field_150004_a;
    }
    
    public boolean isOpaqueCube()
    {
        return this.field_150004_a;
    }
    
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return Item.getItemFromBlock(VanillaEnhanced.blockNewRockSlab);
    }
}
