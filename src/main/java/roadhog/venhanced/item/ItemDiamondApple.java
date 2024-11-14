package roadhog.venhanced.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemDiamondApple extends ItemFood {

	public ItemDiamondApple(int heal, float saturation, boolean wolflikes) {
		super(heal, saturation, wolflikes);
		this.setHasSubtypes(true);
		this.setAlwaysEdible();
	}
    protected void onFoodEaten(ItemStack itemstack, World world, EntityPlayer player)
    {
    	if (!world.isRemote) {
        	if (itemstack.getItemDamage() >= 1) {
                player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 2850, 1));
            	player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 900, 4));
                player.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 0));
                player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 8400, 0));
                player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1800, 0));
        	} else {
                player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 150, 1));
                player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 2700, 0));
                player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1800, 0));
        	}
        }
    }
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemstack)
    {
        return itemstack.getItemDamage() > 0;
    }
    
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs creativeTabs, List list) {
		
		for (int i = 0; i < 2; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
    public EnumRarity getRarity(ItemStack itemstack)
    {
        return itemstack.getItemDamage() == 0 ? EnumRarity.rare : EnumRarity.epic;
    }
}
