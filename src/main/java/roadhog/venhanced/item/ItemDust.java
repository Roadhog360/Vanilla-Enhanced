package roadhog.venhanced.item;

import java.util.List;

import roadhog.venhanced.VanillaEnhanced;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

public class ItemDust extends Item {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] texture;

	final static String[] metaItems = new String[] {"Coal", "Charcoal", "Anthracite", "Iron", "Gold", "Blazicite", "Diamond", "Emerald", "Ruby", "Sapphire"};
	
	public ItemDust(){
		super();
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemStack) {
		int i = itemStack.getItemDamage();
		if(i < 0 || i >= metaItems.length) {
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + metaItems[i];
	}
	
	public int getMetadata(int meta) {
		if(meta < metaItems.length)
		return meta;
		else if(meta > metaItems.length);
		return 0;
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs creativeTabs, List list) {
		
		for (int i = 0; i < metaItems.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
		
	}
	
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
        int j = MathHelper.clamp_int(meta, 0, metaItems.length);
        if (j > metaItems.length) {
        	return this.texture[0];
        } else
        return this.texture[j];
    }
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister icon)
    {
        texture = new IIcon[metaItems.length];

        for (int i = 0; i < metaItems.length; ++i) {
            this.texture[i] = icon.registerIcon(VanillaEnhanced.modid + ":" + "itemDust" + metaItems[i]);
        }
    }
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if(meta < metaItems.length)
			return texture[meta];
		else if(meta > metaItems.length);
			return texture[0];
		}
	
    public EnumRarity getRarity(ItemStack itemstack)
    {
        return itemstack.getItemDamage() == 5 ? EnumRarity.uncommon : EnumRarity.common;
    }
}