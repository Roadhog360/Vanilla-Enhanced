package roadhog.venhanced.item;

import java.util.ArrayList;

import roadhog.venhanced.VanillaEnhanced;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;

public class ItemAxeClass extends ItemAxe {

	public ItemAxeClass(ToolMaterial material) {
		super(material);
	}

	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack){
		if(par1ItemStack.getItem() == VanillaEnhanced.itemRubyAxe) {
		return VanillaEnhanced.itemRuby == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemEmeraldAxe) {
		return Items.emerald == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemTinAxe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 0 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemCopperAxe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 1 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemOsmiumAxe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 2 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemIridiumAxe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 3 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemBronzeAxe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 4 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} else if(par1ItemStack.getItem() == VanillaEnhanced.itemSteelAxe) {
			return VanillaEnhanced.itemIngotMetal == par2ItemStack.getItem() && par2ItemStack.getItemDamage() == 5 ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		} 
		return false;
	}
	
}