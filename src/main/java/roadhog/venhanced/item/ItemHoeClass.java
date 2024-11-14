package roadhog.venhanced.item;

import roadhog.venhanced.VanillaEnhanced;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemHoeClass extends ItemHoe {

	public ItemHoeClass(ToolMaterial material) {
		super(material);
	}

	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack){
		if(par1ItemStack.getItem() == VanillaEnhanced.itemRubyHoe) {
		return VanillaEnhanced.itemRuby == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemEmeraldHoe) {
		return Items.emerald == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemTinHoe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 0 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemCopperHoe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 1 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemOsmiumHoe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 2 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemIridiumHoe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 3 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemBronzeHoe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 4 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemSteelHoe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 5 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} 
		return false;
	}
	
}
