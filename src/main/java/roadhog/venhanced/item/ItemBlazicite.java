package roadhog.venhanced.item;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import roadhog.venhanced.VanillaEnhanced;
import net.minecraft.item.Item.ToolMaterial;

public class ItemBlazicite extends Item {

	public ItemBlazicite() {
	}

	public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.uncommon;
    }

}
