package roadhog.venhanced.item.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import scala.reflect.api.FlagSets.FlagOps;
import scala.tools.nsc.doc.base.Tooltip;

public class BlockOreBlaziciteItem extends ItemBlock {
	public BlockOreBlaziciteItem(Block block) {
		super(block);
	}

	public EnumRarity getRarity(ItemStack itemstack)
    {
        return EnumRarity.uncommon;
    }

}
