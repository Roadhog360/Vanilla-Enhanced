package roadhog.venhanced.item.itemblock;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import roadhog.venhanced.VanillaEnhanced;

public class BlockPaeoniaItem extends ItemBlock {

	public BlockPaeoniaItem(Block block) {
		super(block);
		
	}
	
/*	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz)
	{

        if (world.getBlock(x, y, z) == Blocks.flower_pot) {
                world.setBlock(x, y, z, VanillaEnhanced.blockVenhPot, 1, 3);
        }
        return true;
    }*/

}
