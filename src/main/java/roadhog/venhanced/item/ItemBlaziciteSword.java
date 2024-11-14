package roadhog.venhanced.item;

import java.util.ArrayList;
import java.util.List;

import roadhog.venhanced.VanillaEnhanced;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class ItemBlaziciteSword extends ItemSword {
	
	
	public ItemBlaziciteSword(ToolMaterial material) {
		super(material);
		
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack){
		if(par1ItemStack.getItem() == VanillaEnhanced.itemBlaziciteSword) {
		return VanillaEnhanced.itemIngotBlazicite == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		}
		return false;
	}
	
    @Override
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase targetEntity, EntityLivingBase entity) {
		boolean result = super.hitEntity(itemstack, targetEntity, entity);
		NBTTagList ench = itemstack.getEnchantmentTagList();
		short level = 0;
		if(ench != null)
		{
			for (int x = 0; x < ench.tagCount(); x++)
			{
				NBTTagCompound nbt = ench.getCompoundTagAt(x);
				short id = nbt.getShort("id");
				if (id == Enchantment.fireAspect.effectId)
				{
					level = nbt.getShort("lvl");
				}
			}
		}
		
		int burnTime = level * 5;
		
    	if(targetEntity.isImmuneToFire() == false)
    	targetEntity.setFire(10 + burnTime);
    	return result;
    }
    
	public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.uncommon;
    }
}
