package roadhog.venhanced.item;

import java.util.Random;

import roadhog.venhanced.VanillaEnhanced;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWitheredBone extends Item {

	public ItemWitheredBone(){
		
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		
		boolean canUse = false;
		Random random = new Random();
		
		if(itemstack.getItem() == VanillaEnhanced.itemWitheredBonemeal && world.getBlock(x, y, z) == Blocks.nether_wart && world.getBlockMetadata(x, y, z) < 3){
			
			int randBoost;
			int wartDamage = world.getBlockMetadata(x, y, z);
			
			if (random.nextInt(3) > 1 && wartDamage <= 1){
				randBoost = 1;
			} else {
				randBoost = 0;
			}
						
			world.setBlockMetadataWithNotify(x, y, z, wartDamage + randBoost + 1, 2);
			canUse = true;
			
			if (!player.capabilities.isCreativeMode)
            {
                --itemstack.stackSize;
            }

			world.spawnParticle("largesmoke", x + random.nextFloat(), y + .25, z + random.nextFloat(), 0.0D, 0.0D, 0.0D);
			world.spawnParticle("largesmoke", x + random.nextFloat(), y + .2, z + random.nextFloat(), 0.0D, 0.0D, 0.0D);
            
        	world.markBlockForUpdate(x, y, z);
		} else {
			canUse = false;
		}
			
		return canUse;
	}
}
