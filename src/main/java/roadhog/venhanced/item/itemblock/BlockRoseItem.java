package roadhog.venhanced.item.itemblock;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import roadhog.venhanced.VanillaEnhanced;

public class BlockRoseItem extends ItemBlock {

	public BlockRoseItem(Block block) {
		super(block);
		
	}
	
/*	public boolean onItemRightClick(ItemStack stack, EntityPlayer player, World world)
	{
		MovingObjectPosition pos = player.rayTrace(100, 20);
		double x = pos.().getX();
		double y = pos.getBlockPos().getY();
		double z = pos.getBlockPos().getZ();

			if (world.getBlock(x, y, z) == Blocks.flower_pot) {
                world.setBlock(x, y, z, VanillaEnhanced.blockVenhPot, 0, 3);
        }
        return true;
    }*/

}
