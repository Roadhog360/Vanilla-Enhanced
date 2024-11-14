package roadhog.venhanced.handler;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import roadhog.venhanced.VanillaEnhanced;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		
		if (fuel.getItem() == Item.getItemFromBlock(VanillaEnhanced.blockCharcoal)){
		return 16000;
		}
		else if (fuel.getItem() == Item.getItemFromBlock(VanillaEnhanced.blockBlaze)){
		return 10000;
		}
		else if (fuel.getItem() == Item.getItemFromBlock(VanillaEnhanced.blockAnthracite)){
		return 21100;
		}
		else if (fuel.getItem() == VanillaEnhanced.itemAnthracite){
		return 4800;
		}
		else if (fuel.getItem() == VanillaEnhanced.itemShard && fuel.getItemDamage() == 0 || fuel.getItem() == VanillaEnhanced.itemShard && fuel.getItemDamage() == 1){
		return 177;
		}
		else if (fuel.getItem() == VanillaEnhanced.itemShard && fuel.getItemDamage() == 2){
		return 533;
		}
		else if (fuel.getItem() == VanillaEnhanced.itemDust && fuel.getItemDamage() == 0 || fuel.getItem() == VanillaEnhanced.itemDust &&  fuel.getItemDamage() == 1){
		return 1600;
		}
		else if (fuel.getItem() == VanillaEnhanced.itemDust && fuel.getItemDamage() == 2){
		return 4800;
		}
		else if (fuel.getItem() == Item.getItemFromBlock(VanillaEnhanced.blockOakScaffolding)){
		return 150;
		}
		else if (fuel.getItem() == Item.getItemFromBlock(VanillaEnhanced.blockSpruceScaffolding)){
		return 150;
		}
		else if (fuel.getItem() == Item.getItemFromBlock(VanillaEnhanced.blockBirchScaffolding)){
		return 150;
		}
		else if (fuel.getItem() == Item.getItemFromBlock(VanillaEnhanced.blockJungleScaffolding)){
		return 150;
		}
		else if (fuel.getItem() == Item.getItemFromBlock(VanillaEnhanced.blockAcaciaScaffolding)){
		return 150;
		}
		else if (fuel.getItem() == Item.getItemFromBlock(VanillaEnhanced.blockBigOakScaffolding)){
		return 150;
		}
		else if (fuel.getItem() == Item.getItemFromBlock(VanillaEnhanced.blockFenceGateNetherBrick)){
			return 0;
		}
		else if (fuel.getItem() == Item.getItemFromBlock(VanillaEnhanced.blockFenceGateRedNetherBrick)){
			return 0;
		}
		else if (fuel.getItem() == Item.getItemFromBlock(VanillaEnhanced.blockFenceGateBlackNetherBrick)){
			return 0;
		}
		else return 0;
	}

}
