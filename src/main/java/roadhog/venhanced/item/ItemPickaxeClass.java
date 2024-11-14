package roadhog.venhanced.item;

import roadhog.venhanced.VanillaEnhanced;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemPickaxeClass extends ItemPickaxe {

	public ItemPickaxeClass(ToolMaterial material) {
		super(material);
	}

	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack){
		if(par1ItemStack.getItem() == VanillaEnhanced.itemRubyPickaxe) {
		return VanillaEnhanced.itemRuby == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemEmeraldPickaxe) {
		return Items.emerald == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemTinPickaxe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 0 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemCopperPickaxe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 1 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemOsmiumPickaxe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 2 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemIridiumPickaxe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 3 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemBronzePickaxe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 4 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemSteelPickaxe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 5 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} 
		return false;
	}
	
}
