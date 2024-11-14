package roadhog.venhanced.item;

import net.minecraft.init.Items;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import roadhog.venhanced.VanillaEnhanced;

public class ItemSpadeClass extends ItemSpade {

	public ItemSpadeClass(ToolMaterial material) {
		super(material);
	}

	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack){
		if(par1ItemStack.getItem() == VanillaEnhanced.itemRubySpade) {
		return VanillaEnhanced.itemRuby == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemEmeraldSpade) {
		return Items.emerald == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemTinSpade) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 0 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemCopperSpade) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 1 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemOsmiumSpade) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 2 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemIridiumSpade) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 3 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemBronzeSpade) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 4 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemSteelSpade) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 5 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} 
		return false;
	}
	
	
}

