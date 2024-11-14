package roadhog.venhanced.block;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockCauldronWater extends Item {
	

	public BlockCauldronWater() {
		super();
	}
    
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
    	boolean flag = Items.cauldron.onItemUse(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
    	if(flag) {
    		Block block = p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);

            if (block == Blocks.snow_layer && (p_77648_3_.getBlockMetadata(p_77648_4_, p_77648_5_, p_77648_6_) & 7) < 1)
            {
                p_77648_7_ = 1;
            }
            else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush)
            {
                if (p_77648_7_ == 0)
                {
                    --p_77648_5_;
                }

                if (p_77648_7_ == 1)
                {
                    ++p_77648_5_;
                }

                if (p_77648_7_ == 2)
                {
                    --p_77648_6_;
                }

                if (p_77648_7_ == 3)
                {
                    ++p_77648_6_;
                }

                if (p_77648_7_ == 4)
                {
                    --p_77648_4_;
                }

                if (p_77648_7_ == 5)
                {
                    ++p_77648_4_;
                }
            }
    		p_77648_3_.setBlockMetadataWithNotify(p_77648_4_, p_77648_5_, p_77648_6_, 3, 2);
    	}
    	return flag;
    }

}
