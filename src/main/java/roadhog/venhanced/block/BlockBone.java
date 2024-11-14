package roadhog.venhanced.block;

import java.util.Random;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBone extends BlockRotatedPillar {
	
	public static final String[] icons = new String[] {null};
	
	@SideOnly(Side.CLIENT)
	protected IIcon[] iconsSide;
	@SideOnly(Side.CLIENT)
	protected IIcon[] iconsTop;

	public BlockBone(Material material) {
		super(material);
		this.setHardness(2F);
		this.setResistance(10F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	protected IIcon getSideIcon(int meta) {
		return this.iconsSide[meta % iconsSide.length];
	}

	@Override
	@SideOnly(Side.CLIENT)
	protected IIcon getTopIcon(int meta) {
		return this.iconsTop[meta % iconsTop.length];
	}

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.iconsSide = new IIcon[icons.length];
        this.iconsTop = new IIcon[icons.length];

        for (int i = 0; i < this.iconsSide.length; ++i)
        {
            this.iconsSide[i] = icon.registerIcon(this.getTextureName() + "Side");
            this.iconsTop[i] = icon.registerIcon(this.getTextureName() + "Top");
        }
    }
    
    public int quantityDropped(Random random)
    {
        return 1;
    }

    public Item getItemDropped(int unk1, Random random, int unk2)
    {
        return Item.getItemFromBlock(this);
    }
}
